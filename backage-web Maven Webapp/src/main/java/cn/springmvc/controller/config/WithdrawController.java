
package cn.springmvc.controller.config; 

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.model.Admin;
import cn.springmvc.model.WithdrawalsFeeEntity;
import cn.springmvc.service.FinancialSettingService;
import cn.springmvc.service.QuickRechargeFeeService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林
* @Description: 提现充值手续费控制层 
* @since 
* @date 2016-4-13 下午4:53:37
 */
@Controller
@RequestMapping("/withdraw")
public class WithdrawController {
	
	@Autowired
	private FinancialSettingService financialSettingService;
	
	@Autowired
	private QuickRechargeFeeService quickRechargeFeeService;
	
	/**
	 * 
	* msg查询提现 
	* TODO查询提现 
	* @author 杨翰林  
	* * @Title: msg 
	* @Description: 查询提现  
	* @param @return 设定文件 
	* @return WithdrawalsFeeEntity 返回类型 
	* @date 2016-4-13 下午5:14:37
	* @throws
	 */
	@RequestMapping("/msg")
	@ResponseBody
	public List<WithdrawalsFeeEntity> msg() {
		
		List<WithdrawalsFeeEntity> list = financialSettingService.
				selectWithdrawalsFee();
		return list;
	}
	
	/**
	 * 
	* update修改提现 
	* TODO修改提现
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 修改提现 
	* @param @param payment_Member_Type
	* @param @param withdrawal_Fee_Pingtai
	* @param @param withdrawal_Fee_Third
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-13 下午5:27:16
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(HttpServletRequest request) {
		
		WithdrawalsFeeEntity withdrawalsFeeEntity = new WithdrawalsFeeEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String payment_Member_Type = request.getParameter("payment_Member_Type");
		String withdrawal_Fee_Pingtai = request.getParameter("withdrawal_Fee_Pingtai");
		String withdrawal_Fee_Third = request.getParameter("withdrawal_Fee_Third");
		
			withdrawalsFeeEntity.setPayment_Member_Type(Integer.valueOf(payment_Member_Type));
		if (withdrawal_Fee_Pingtai != null && withdrawal_Fee_Pingtai != "") {
			withdrawalsFeeEntity.setWithdrawal_Fee_Pingtai(Integer.valueOf(withdrawal_Fee_Pingtai));
		}
		if (withdrawal_Fee_Third != null && withdrawal_Fee_Third != "") {
			withdrawalsFeeEntity.setWithdrawal_Fee_Third(Integer.valueOf(withdrawal_Fee_Third));
		}
		
		String [] sIpInfo = new String[5];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(6010301);
		entity.setlModuleId(60103);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = financialSettingService.updateWithdrawalsFee(withdrawalsFeeEntity, entity, null);
		
		return num;
	}
	
	/**
	 * 
	* update4charge修改充值手续费
	* TODO修改充值手续费
	* @author 杨翰林  
	* * @Title: update4charge 
	* @Description: 修改充值手续费 
	* @param @param req
	* @param @param paymentMemberType
	* @param @param feePaymentMethod
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-14 下午2:43:15
	* @throws
	 */
	@RequestMapping("/update4charge")
	@ResponseBody
	public int update4charge (Map<String, Object> req, HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String paymentMemberType = request.getParameter("paymentMemberType");
		String feePaymentMethod = request.getParameter("feePaymentMethod");
		
		if (paymentMemberType != null && paymentMemberType != "") {
			req.put("paymentMemberType", paymentMemberType);
		}
		if (feePaymentMethod != null && feePaymentMethod != "") {
			req.put("feePaymentMethod", feePaymentMethod);
		}
		req.put("rechargeTypeThird", 0);
		
		String [] sIpInfo = new String[5];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(6010201);
		entity.setlModuleId(60102);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = quickRechargeFeeService.updateQuickRechargeFee(req, entity, sIpInfo);
		return num;
	}
	
}

