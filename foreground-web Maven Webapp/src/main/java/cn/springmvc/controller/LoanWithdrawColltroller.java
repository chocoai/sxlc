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
import cn.membermng.model.MyAccountHomeEntity;
import cn.membermng.model.OwnTradingRecordsBalanceEntity;
import cn.springmvc.model.WithdrawalsFeeEntity;
import cn.springmvc.service.FinancialSettingService;
import cn.springmvc.service.MamberBankCardService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.MyAccountHomeService;
import cn.springmvc.service.RecordsBalanceService;
import cn.springmvc.util.MemberSessionMng;
import cn.sxlc.account.manager.model.WithdrawsInterdaceEntity;
import cn.sxlc.account.manager.model.WithdrawsInterdaceReturnEntity;

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
	
	@Resource(name="myAccountHomeServiceImpl")
	MyAccountHomeService myAccountHomeService;
	
	@Resource(name="financialSettingServiceImpl")
	FinancialSettingService financialSettingService;
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
	@RequestMapping(value="loadWithdrawData",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loadWithdrawData(HttpServletRequest request){
		
		long[] lMemberInfo = new long[2] ;	 //[登录人ID,登录人类型]
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberID", lMemberInfo[0]);
		map.put("memberType",lMemberInfo[1] );
		
		//查询提现手续费
		List<WithdrawalsFeeEntity> feeList = financialSettingService.selectWithdrawalsFee();
		
		WithdrawalsFeeEntity fee = new WithdrawalsFeeEntity();
		for (WithdrawalsFeeEntity withdrawalsFeeEntity : feeList) {
			if(withdrawalsFeeEntity.getPayment_Member_Type()==0){
				fee = withdrawalsFeeEntity;
				break;
			}
		}
		//查询已添加银行卡列表
		List<MemberBankCardEntity> list= mamberBankCardService.selectMemberBankCardList(map);
		//查询可用余额
		MyAccountHomeEntity entity = myAccountHomeService.selectMyAccountHome(lMemberInfo[0]);
		
		Map<String,Object> message = new HashMap<String, Object>();
		
		message.put("withdrawal_Type_Third", fee.getSwithdrawal_Type_Third());//第三方提现管理费类型 0：百分比 1：固定金额
		message.put("withdrawal_Fee_Third", fee.getSwithdrawal_Fee_Third());//第三方提现管理费 0 表示不需要支付  1:需要支付
		message.put("withdrawal_Fee_Pingtai", fee.getSwithdrawal_Fee_Pingtai());//提现手续费平台代付百分比
		
		if(entity!=null && entity.getUserBalances()==null){
			message.put("code","-1");
			message.put("userBalance", "0.00");
			message.put("message", "您的可提现金额不足，请充值");
		}else{
			message.put("code", 200);
			message.put("userBalance", entity.getUserBalances());
			message.put("message", "查询成功");
		}
		
		message.put("bankCardList", list);
		return JSONObject.toJSONString(message);
	}
	
	
	@RequestMapping(value="sendWithdrawPhoneVarCode",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String sendWithdrawPhoneVarCode(HttpServletRequest request){
		Map<String,Object> message = new HashMap<String, Object>();
		MemberInfo loginMember = (MemberInfo)request.getSession().getAttribute(Constant.LOGINUSER);
		
		String phone = loginMember.getPersonalBaseInfo().getPersonalPhone();
		
		String code = StringUtils.varCode();
		int result = Core.putWithdrawPhoneCode(phone, code);
		if(result==1){
			logger.debug("提现--发送手机验证码发送成功："+phone+" : "+code);
			message.put("statu", 1);
			message.put("message", "验证码发送成功，请注意查收");
		}else{
			message.put("statu", 0);
			message.put("message", "验证码发送失败，请稍后重试");
		}
		return JSONObject.toJSONString(message);
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
		
		MemberInfo loginMember = (MemberInfo)request.getSession().getAttribute(Constant.LOGINUSER);
		
		String phone=loginMember.getPersonalBaseInfo().getPersonalPhone();
		
		String amount =request.getParameter("amount");//提现金额
		String remark = request.getParameter("remark");//备注
		String bankCardId = request.getParameter("bankCardId");//银行卡信息id
		//String phone = request.getParameter("phone");
		String code = request.getParameter("code");//图片验证码
		
		String s = Core.getWithdrawPhoneCode(phone);
		Map<String,Object> message = new HashMap<String, Object>();
		if(code.equals(s)){
			//验证通过
			logger.debug("提现--手机验证码 验证通过："+phone+" : "+code);
			message.put("statu", 1);
			message.put("message", "验证码正确");
		}else{
			//手机验证码错误 跳转到提现失败的页面
			WithdrawsInterdaceReturnEntity entity = new WithdrawsInterdaceReturnEntity();
			entity.setMessage("手机验证码错误，请重试");
			request.setAttribute("withdraws", entity);
			return "account/fundManagement/cashFalse";
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
		//获取访问来源路径（ip+端口+项目名）
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		withdraw.setReturnURL(basePath+"loanWithdraw/loanWithdrawReturn.html");
		
		withdraw.setNotifyURL(basePath+"loanWithdraw/loanWithdrawNotify.html");
		
		withdraw =managedInterfaceServer.testLoanWithdraws(withdraw);
	
		request.setAttribute("draws", withdraw);
		
		return "dryLot/loanwithdrawstest";
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
	@RequestMapping(value="/loanWithdrawNotify",produces="text/html;charset=UTF-8")
	@ResponseBody
	public void loanWithdrawNotify(HttpServletRequest request,HttpServletResponse response){
		managedInterfaceServer.testLoanWithdrawsNotify(request, response);
	}
}

