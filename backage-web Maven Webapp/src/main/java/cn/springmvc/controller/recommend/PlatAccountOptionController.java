
package cn.springmvc.controller.recommend; 

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.Admin;
import cn.springmvc.service.GuaranteeAgenciesService;
import cn.springmvc.service.GuaranteeInfoService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.util.HttpSessionUtil;
import cn.sxlc.account.manager.model.RechargeEntity;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
/**
 * 
* @author 杨翰林 
* @Description: 平台自有账户操作控制层
* @since 
* @date 2016-5-3 下午3:47:08
 */
@Controller
@RequestMapping("/account")
public class PlatAccountOptionController {

	/**
	 * 充值、提现模块
	 */
	@Resource(name="guaranteeInfoServiceImpl")
	private GuaranteeInfoService guaranteeInfoService;
	
	/**
	 * 交易记录模块
	 */
	@Resource(name="guaranteeAgenciesServiceImpl")
	private GuaranteeAgenciesService guaranteeAgenciesService;
	
	/**
	 * //第三方接口
	 */
	@Resource(name="managedInterfaceTestIImpl")
	private ManagedInterfaceServerTestI managedInterfaceServerTestI;
	
	/**
	 * 
	* rechargeRecordList查询充值、提现 
	* TODO查询充值、提现
	* @author 杨翰林  
	* * @Title: rechargeRecordList 
	* @Description: 查询充值、提现 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-3 下午6:37:11
	* @throws
	 */
	@RequestMapping("/rechargeRecordList")
	@ResponseBody
	public PageEntity rechargeRecordList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String orderNumber = request.getParameter("orderNumber");
		String thirdMerBillno = request.getParameter("batch");
		String statu = request.getParameter("statu");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dealType = request.getParameter("dealType");
		String memberType = request.getParameter("memberType");
		
		req.put("merBillno", orderNumber);
		req.put("thirdMerBillno", thirdMerBillno);
		req.put("statu", statu);
		req.put("startdealTime", startDate);
		req.put("enddealTime", endDate);
		req.put("dealType", dealType);
		req.put("memberType", memberType);
		req.put("statu", statu);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.InstitutionsToRaiseCashRecords(pager);
		return pager;
	}
	
	/**
	 * 
	* tradeRecord查询交易记录 
	* TODO查询交易记录
	* @author 杨翰林  
	* * @Title: tradeRecord 
	* @Description: 查询交易记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-4 上午9:40:55
	* @throws
	 */
	@RequestMapping("/tradeRecord")
	@ResponseBody
	public PageEntity tradeRecord(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String typeName = request.getParameter("typeName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String memberType = request.getParameter("memberType");
		
		req.put("Record_Date_Min", startDate);
		req.put("Record_Date_Max", endDate);
		req.put("typeName", typeName);
		req.put("memberType", memberType);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeAgenciesService.getTransaction(pager);
		return pager;
	}
	
	/**
	 * 
	* recharge保荐机构充值 
	* TODO保荐机构充值
	* @author 杨翰林  
	* * @Title: recharge 
	* @Description: 保荐机构充值 
	* @param @param request
	* @param @return 设定文件 
	* @return RechargeEntity 返回类型 
	* @date 2016-5-10 上午11:38:41
	* @throws
	 */
	@RequestMapping("/recharge")
	public String recharge(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String rechargeType = request.getParameter("rechargeType");
		String amount =request.getParameter("amount");//充值金额
		String remark = request.getParameter("remark");//备注
		String memberType = request.getParameter("memberType");//备注
		
		RechargeEntity recharge = new RechargeEntity();
		recharge.setMemberId(userInfo.getId());
		recharge.setMemberType(IntegerAndString.StringToInt(memberType, -1));
		recharge.setRechargeType(rechargeType);
		recharge.setAmount(amount);
		recharge.setRemark3(remark);
		recharge.setReturnURL("account/backURL.do");
		recharge.setNotifyURL("account/backServerURL.do");
		RechargeEntity rechargeEntity = managedInterfaceServerTestI.testLoanRecharge(recharge, request);
		
		
		request.setAttribute("rechargeEntity", rechargeEntity);
		return "dryLot/loanrechargetest";
	}
	
	/**
	 * 
	* returnURL第三方回调 页面返回地址 
	* TODO第三方回调 页面返回地址
	* @author 杨翰林  
	* * @Title: returnURL 
	* @Description: 第三方回调 页面返回地址 
	* @param  设定文件 
	* @return void 返回类型 
	* @date 2016-5-17 上午11:02:50
	* @throws
	 */
	@RequestMapping("/backURL")
	public String returnURL(HttpServletRequest request, HttpServletResponse response) {
		
		String isSuccess = managedInterfaceServerTestI.testLoanRechargeReturn(request);
		
		if ("SUCCESS".equals(isSuccess)) {
			return "finance/success-recharge";
		}else {
			return "finance/fail-recharge";
		}
	}
	
	/**
	 * 
	* notifyURL第三方回调 服务器返回地址 
	* TODO第三方回调 服务器返回地址
	* @author 杨翰林  
	* * @Title: notifyURL 
	* @Description: 第三方回调 服务器返回地址 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-17 上午11:06:01
	* @throws
	 */
	@RequestMapping("/backServerURL")
	public void notifyURL(HttpServletRequest request, HttpServletResponse response) {
		managedInterfaceServerTestI.testLoanRechargeNotify(request, response);
	}
	
}

