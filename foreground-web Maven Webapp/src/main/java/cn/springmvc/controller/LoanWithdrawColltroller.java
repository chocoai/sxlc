package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.constant.Constant;
import product_p2p.kit.redisPlug.Core;

import com.alibaba.fastjson.JSONObject;

import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.springmvc.service.MamberBankCardService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.RecordsBalanceService;
import cn.springmvc.util.MemberSessionMng;
import cn.sxlc.account.manager.model.WithdrawsInterdaceEntity;

/**
 * 我的账户-资金管理-提现
* @author 邱陈东 
* @since 
* @date 2016-5-9 上午10:58:04
 */
@Controller
@RequestMapping("loanWithdraw")
public class LoanWithdrawColltroller {

	private Logger logger = Logger.getLogger(LoginRegisterController.class);
	
	//第三方接口
	@Resource(name="managedInterfaceTestIImpl")
	ManagedInterfaceServerTestI managedInterfaceServer; 
	
	@Resource(name="memberBankCardServiceImpl")
	MamberBankCardService mamberBankCardService;
	
	@Resource(name="recordsBalanceServiceImpl")
	RecordsBalanceService recordsBalanceService;
	/**
	 * 获取当前登录人提现时需要的 可用余额，手续费百分比 可用银行卡等信息
	* loadWithdrawData
	* @author 邱陈东  
	* * @Title: loadWithdrawData 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 上午11:00:07
	* @throws
	 */
	public String loadWithdrawData(HttpServletRequest request){
		
		long[] lMemberInfo = new long[2] ;	 //[登录人ID,登录人类型]
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberID", lMemberInfo[0]);
		map.put("memberType",lMemberInfo[1] );
		List<MemberBankCardEntity> list= mamberBankCardService.selectMemberBankCardList(map);
		MemberThirdAuthInfoEntity entity = recordsBalanceService.selectMemberThirdAuthInfo(map);
		
		Map<String,Object> message = new HashMap<String, Object>();
		message.put("code", 200);
		message.put("message", "查询成功");
		message.put("bankCardList", list);
		message.put("userBalance", entity.getMemberThirdInfoEntity().getUserBalances());
		return JSONObject.toJSONString(message);
	}
	
	
	@RequestMapping(value="sendWithdrawPhoneVarCode")
	@ResponseBody
	public Object sendWithdrawPhoneVarCode(HttpServletRequest request){
		Map<String,Object> message = new HashMap<String, Object>();
		MemberInfo loginMember = (MemberInfo)request.getSession().getAttribute(Constant.LOGINUSER);
		
		String phone = request.getParameter("phone");
		
		String code = StringUtils.varCode();
		Core.putWithdrawPhoneCode(phone, code);
		logger.debug("忘记密码发送手机验证码发送成功："+phone+" : "+code);
		message.put("statu", 1);
		message.put("message", "验证码发送成功，请注意查收");
		return message;
	}
	/**
	 * 双乾  提现通道
	* loanWithdraw
	* @author 邱陈东  
	* * @Title: loanWithdraw 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午4:16:00
	* @throws
	 */
	@RequestMapping(value="/loanWithdraw",produces="text/html;charset=UTF-8")
	public String loanWithdraw(HttpServletRequest request){
		String amount =request.getParameter("amount");//提现金额
		String remark = request.getParameter("remark");//备注
		String bankCardId = request.getParameter("bankCardId");//银行卡信息id
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");//图片验证码
		
		String s = Core.getWithdrawPhoneCode(phone);
		Map<String,Object> message = new HashMap<String, Object>();
		if(code.equals(s)){
			//验证通过  把状态存到缓存中
			logger.debug("忘记密码手机验证码 验证通过："+phone+" : "+code);
			message.put("statu", 1);
			message.put("message", "验证码正确");
		}else{
			message.put("statu", -1);
			message.put("message", "验证码错误");
			return JSONObject.toJSONString(message);
		}
		long[] lMemberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		WithdrawsInterdaceEntity withdraw = new WithdrawsInterdaceEntity();
		withdraw.setMemberId(lMemberInfo[0]);
		withdraw.setMemberType((int)lMemberInfo[1]);
		withdraw.setCardId(Long.parseLong(bankCardId));
		withdraw.setAmount(amount);
		withdraw.setRemark3(remark);
		
		withdraw.setSubmitURL("http://218.4.234.150:88/main/loan/toloanwithdraws.action");
		
		withdraw.setReturnURL("http://110.185.5.254:16000/foreground-web/loanWithdraw/loanWithdrawReturn.html");
		
		withdraw.setNotifyURL("http://110.185.5.254:16000/foreground-web/loanWithdraw/loanWithdrawReturn.html");
		
		withdraw =managedInterfaceServer.testLoanWithdraws(withdraw);
	
		request.setAttribute("withdraw", withdraw);
		return "dryLot/loanrechargetest";
	}
	
	/**
	 * 提现后双乾返回到该页面
	* loanWithdrawReturn
	* @author 邱陈东  
	* * @Title: loanWithdrawReturn 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午5:14:40
	* @throws
	 */
	@RequestMapping(value="/loanWithdrawReturn")
	public String loanWithdrawReturn(HttpServletRequest request,HttpServletResponse response){
		String returnstr =  managedInterfaceServer.testLoanWithdrawsReturn(request, response);
		request.setAttribute("data", returnstr);
		if(returnstr.equals("SUCCESS")){
			return "account/fundManagement/cashSuccess";
		}else{
			return "account/fundManagement/cashFalse";
		}
	}
	
	/**
	 * 双乾第三方提现服务器返回 数据处理
	* loanWithdrawNotify
	* @author 邱陈东  
	* * @Title: loanWithdrawNotify 
	* @param @param request
	* @param @param response 设定文件 
	* @return void 返回类型 
	* @date 2016-5-9 下午6:07:17
	* @throws
	 */
	@RequestMapping(value="/loanWithdrawNotify。",produces="text/html;charset=UTF-8")
	@ResponseBody
	public void loanWithdrawNotify(HttpServletRequest request,HttpServletResponse response){
		managedInterfaceServer.testLoanWithdrawsNotify(request, response);
	}
}

