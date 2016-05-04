package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;

import com.alibaba.fastjson.JSONObject;
 
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.util.MemberSessionMng; 
import cn.sxlc.account.manager.model.RechargeEntity;

@Controller
@RequestMapping("loanRecharge")
public class LoanRechargeColltroller {
	
	//第三方接口
	@Resource(name="managedInterfaceTestIImpl")
	ManagedInterfaceServerTestI managedInterfaceServer; 
	
	/**
	 * 双乾充值
	* loanRecharge
	* @author 邱陈东  
	* * @Title: loanRecharge 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-28 下午5:33:58
	* @throws
	 */
	@RequestMapping(value="/loanRecharge",produces="text/html;charset=UTF-8")
	public String loanRecharge(HttpServletRequest request){
		Map<String,Object> message = new HashMap<String, Object>();
		String rechargeType = request.getParameter("rechargeType");//双乾充值类型  空.网银充值  1.代扣充值(暂不可用)2.快捷支付3.汇款充值4.企业网银
		String amount =request.getParameter("amount");//充值金额
		if(rechargeType==null || amount.equals("")){
			message.put("code", 403);
			message.put("message", "参数错误");
		}
		
		String remark = request.getParameter("remark");//备注
		
		long[] lMemberInfo = new long[2] ;		
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		lMemberInfo[0]=1;
		
		RechargeEntity recharge = new RechargeEntity();
		recharge.setMemberId(lMemberInfo[0]);
		recharge.setMemberType((int)lMemberInfo[1]);
		recharge.setRechargeType(rechargeType);
		recharge.setAmount(amount);
		recharge.setRemark3(remark);
		recharge.setIsApp(0);
		
		recharge =managedInterfaceServer.testLoanRecharge(recharge);
		message.put("code", 200);
		message.put("message", "获取交易信息成功");
		message.put("data", recharge);
		request.setAttribute("recharge", recharge);
		return "dryLot/loanrechargetest.jsp";
	}

	@RequestMapping(value="/loanRechargeReturn")
	public String loanRechargeReturn(HttpServletRequest request){
		String returnstr =  managedInterfaceServer.testLoanRechargeReturn();
		request.setAttribute("data", returnstr);
		if(returnstr.equals("SUCCESS")){
			return "account/fundManagement/rechargeSuccess";
		}else{
			return "account/fundManagement/rechargeFalse";
		}
	}
	@RequestMapping(value="/loanRechargeNotify",produces="text/html;charset=UTF-8")
	@ResponseBody
	public void loanRechargeNotify(HttpServletRequest request){
		managedInterfaceServer.testLoanRechargeNotify();
	}
	
}

