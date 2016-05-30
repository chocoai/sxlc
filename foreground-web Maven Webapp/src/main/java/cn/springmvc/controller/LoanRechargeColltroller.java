package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import product_p2p.kit.datatrans.IntegerAndString;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
 
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.QuickRechargeFeeService;
import cn.springmvc.util.MemberSessionMng; 
import cn.sxlc.account.manager.model.RechargeEntity;

@Controller
@RequestMapping("loanRecharge")
public class LoanRechargeColltroller {
	
	//第三方接口
	@Resource(name="managedInterfaceTestIImpl")
	ManagedInterfaceServerTestI managedInterfaceServer; 
	
	@Autowired
	QuickRechargeFeeService quickRechargeFeeService;
	/**
	 * 获取充值手续费率
	* loadRechargeFee
	* @author 邱陈东  
	* * @Title: loadRechargeFee 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-26 下午5:40:25
	* @throws
	 */
	@RequestMapping(value="/loadRechargeFee",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loadRechargeFee(){
		Map<String, Object>map = new HashMap<String, Object>();
		
		List<QuickRechargeFeeEntity> list = quickRechargeFeeService.findAllQuickRechargeFee();
		for (QuickRechargeFeeEntity entity : list) {
			if(entity.getPaymentMemberType()==0){
				map.put("data", entity);
				return JSONObject.toJSONString(map);
			}
		}
		map.put("data", null);
		return JSONObject.toJSONString(map);
	}
	
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
		
		RechargeEntity recharge = new RechargeEntity();
		recharge.setMemberId(lMemberInfo[0]);
		recharge.setMemberType((int)lMemberInfo[1]);
		recharge.setRechargeType(rechargeType);
		recharge.setAmount(amount);
		recharge.setRemark3(remark);
		recharge.setIsApp(0); 
		recharge.setNotifyURL("loanRecharge/loanRechargeNotify.html");
		recharge.setReturnURL("loanRecharge/loanRechargeReturn.html");
		recharge =managedInterfaceServer.testLoanRecharge(recharge,request);
	
		request.setAttribute("rechange", recharge);
		return "dryLot/loanrechargetest";
	}

	/**
	 * 充值后  双乾会自动跳到这个地址
	* loanRechargeReturn
	* @author 邱陈东  
	* * @Title: loanRechargeReturn 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-9 下午4:14:41
	* @throws
	 */
	@RequestMapping(value="/loanRechargeReturn")
	public String loanRechargeReturn(HttpServletRequest request){
		String returnstr =  managedInterfaceServer.testLoanRechargeReturn(request);
		request.setAttribute("data", returnstr);
		if(returnstr.equals("SUCCESS")){
			return "account/fundManagement/rechargeSuccess";
		}else{
			return "account/fundManagement/rechargeFalse";
		}
	}
	
	/**
	 * 充值后  双乾会把交易信息返回到这里
	* loanRechargeNotify
	* @author 邱陈东  
	* * @Title: loanRechargeNotify 
	* @param @param request
	* @param @param response 设定文件 
	* @return void 返回类型 
	* @date 2016-5-9 下午4:15:12
	* @throws
	 */
	@RequestMapping(value="/loanRechargeNotify",produces="text/html;charset=UTF-8")
	@ResponseBody
	public void loanRechargeNotify(HttpServletRequest request,HttpServletResponse response){
		managedInterfaceServer.testLoanRechargeNotify(request,response);
	}
	
}

