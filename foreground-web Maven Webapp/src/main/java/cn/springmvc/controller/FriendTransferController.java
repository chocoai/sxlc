package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.redisPlug.Core;
import cn.membermng.model.MyAccountHomeEntity;
import cn.membermng.model.OwnTradingRecordsBalanceEntity;
import cn.springmvc.service.IMemberService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.MobilePhoneBindingService;
import cn.springmvc.service.MyAccountHomeService;
import cn.springmvc.service.RecordsBalanceService;
import cn.springmvc.util.MemberSessionMng;
import cn.sxlc.account.manager.model.LoanTransferEntity;

import com.alibaba.fastjson.JSONObject;

/**
 * 好友转账
* @author 邱陈东 
* @since 
* @date 2016-5-23 上午11:12:21
 */
@Controller
@RequestMapping("friendTransfer")
public class FriendTransferController {
	
	private Logger logger = Logger.getLogger(LoginRegisterController.class);

	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private ManagedInterfaceServerTestI interfaceServerTestI;
	
	@Resource(name="recordsBalanceServiceImpl")
	RecordsBalanceService recordsBalanceService;
	
	@Resource(name="myAccountHomeServiceImpl")
	MyAccountHomeService myAccountHomeService;
	
	/**
	 * 我的好友—转账
	* friendManagementTransfer
	* @author 胥福星  
	* @date 2016-5-5 上午9:39:10
	 */
	@RequestMapping({ "/friendManagementTransfer" })
	public String friendManagementTransfer(HttpServletRequest request) {
		String friendId = request.getParameter("start");
		String friendName = request.getParameter("content");
		request.setAttribute("friendId", friendId);
		request.setAttribute("friendName", friendName);
		return "account/personalCenter/friendManagementTransfer";
	}
	
	/**
	 * 获取当前用户可转账余额
	* loadUserBalance
	* @author 邱陈东  
	* * @Title: loadUserBalance 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-23 上午10:12:03
	* @throws
	 */
	@RequestMapping(value="loadUserBalance",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadUserBalance(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		MyAccountHomeEntity data = myAccountHomeService.selectMyAccountHome(lMemberInfo[0]);
		
		message.put("status", "0");
		message.put("message", "保存成功");
		message.put("data", data);
		return JSONObject.toJSONString(message);
	}
	
	@Autowired
	MobilePhoneBindingService mobilePhoneBindingService;
	
	@RequestMapping(value="loadPhone",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loadPhone(HttpServletRequest request){
		Map<String, Object> message = new HashMap<String, Object>();
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		String phone =mobilePhoneBindingService.selectOldPhone(lMemberInfo[0]);
		
		message.put("status", "0");
		message.put("message", "保存成功");
		message.put("data", phone);
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 好友转账 - 发送手机验证码
	* sendFriendTransferPhoneVarCode
	* @author 邱陈东  
	* * @Title: sendFriendTransferPhoneVarCode 
	* @param @param request
	* @param @param loginName
	* @param @param phone
	* @param @param imgCode
	* @param @return 设定文件 
	* @return Object 返回类型 
	* @date 2016-5-23 上午10:29:27
	* @throws
	 */
	@RequestMapping(value="sendFriendTransferPhoneVarCode", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object sendFriendTransferPhoneVarCode(HttpServletRequest request){
		String imgCode = request.getParameter("imgCode");
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		String phone =mobilePhoneBindingService.selectOldPhone(lMemberInfo[0]);
		
		Map<String,Object> message = new HashMap<String, Object>();
		if(imgCode == null ){
			message.put("statu", "-1");
			message.put("checkCode", "请输入图片验证码");
		}else if(!imgCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION_FRIENDTRANSFER").toString())){
			message.put("statu", "-2");
			message.put("message", "图片验证码错误");
		}
		
		if(message.keySet().size() > 0){
			return JSONObject.toJSONString(message);
		}

		String code = StringUtils.varCode();
		int result = Core.putFriendTransferPhoneCode(phone, code);
		if(result==1){
			logger.debug("好友转账发送手机验证码发送成功："+phone+" : "+code);
			message.put("statu", 1);
			message.put("message", "验证码发送成功，请注意查收");
		}else{
			message.put("statu", 0);
			message.put("message", "验证码发送失败，请稍后重试");
		}
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 好友转账信息处理
	* debtInvestment
	* @author 邱陈东  
	* * @Title: debtInvestment 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-23 上午10:09:23
	* @throws
	 */
	@RequestMapping(value="friendTransfer",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String friendTransfer(HttpServletRequest request){
		Long friendId= Long.parseLong(request.getParameter("friendId"));
		Long amount =IntegerAndString.StringToLong(request.getParameter("amount"));;
		String imgCode = request.getParameter("imgCode");
		String code = request.getParameter("code");//短信验证码
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		String phone = mobilePhoneBindingService.selectOldPhone(lMemberInfo[0]);
		String  s = Core.getFriendTransferPhoneCode(phone);//缓存中的短信验证码
		LoanTransferEntity loanTran = new LoanTransferEntity();
		if(!code.equals(s)){
			//短信验证码错误
			loanTran.setMassage("短信验证码错误");
			request.setAttribute("message", loanTran.getMassage());
			return "invest/investFalse";
		}
		if(!imgCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION_FRIENDTRANSFER").toString())){
			//图片验证码错误
			loanTran.setMassage("图片验证码错误");
			request.setAttribute("message", loanTran.getMassage());
			return "invest/investFalse";
		}
		
		String returnURL = "friendTransfer/friendTransferReturn.html";
		String notifyURL = "friendTransfer/friendTransferNotify.html";
		loanTran = interfaceServerTestI.FriendTransfer( friendId, lMemberInfo[0],amount, request, returnURL, notifyURL);
		
		request.setAttribute("loanTransferEntity", loanTran);
		if(loanTran.getStatu() == 0){		//成功
			return "dryLot/loantransfertest";
		}else{								//失败
			request.setAttribute("message", loanTran.getMassage());
			return "invest/investFalse";
		}
	}
	
	/**
	 * 好友转账 回调通知页面
	* friendTransferReturn
	* @author 邱陈东  
	* * @Title: friendTransferReturn 
	* @param @param request
	* @param @param response
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-23 上午11:25:14
	* @throws
	 */
	@RequestMapping("/friendTransferReturn")
	public String friendTransferReturn(HttpServletRequest request,HttpServletResponse response){
		String result = interfaceServerTestI.MemberTransferReturn(request, response);
		if(result.equals("SUCCESS")){
			return "invest/investSuccess";
		}else{
			return "invest/investFalse";
		}
	}
	
	

	@RequestMapping("/friendTransferNotify")
	public void friendTransferNotify(HttpServletRequest request,HttpServletResponse response){
		interfaceServerTestI.MemberTransferBack(request,response);
	}
}

