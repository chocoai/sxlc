
package cn.springmvc.controller.recommend; 

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.OverdueCompensationEntity;
import cn.springmvc.service.CompensatoryInterfaceServer;
import cn.springmvc.service.GuaranteeAgenciesService;
import cn.springmvc.service.GuaranteeInfoService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.RecordsBalanceService;
import cn.springmvc.util.HttpSessionUtil;
import cn.sxlc.account.manager.model.LoanTransferEntity;
import cn.sxlc.account.manager.model.WithdrawsInterdaceEntity;
/**
 * 
* @author 杨翰林 
* @Description: 担保机构代偿控制层 
* @since 
* @date 2016-5-6 下午3:27:54
 */
@Controller
@RequestMapping("/compensatory")
public class GuaCompensatoryController {
	
	@Resource(name="guaranteeAgenciesServiceImpl")
	private GuaranteeAgenciesService guaranteeAgenciesService;
	
	@Resource(name="guaranteeInfoServiceImpl")
	private GuaranteeInfoService guaranteeInfoService;
	
	@Resource(name="managedInterfaceTestIImpl")
	private ManagedInterfaceServerTestI managedInterfaceServerTestI;
	
	@Resource(name="compensatoryInterfaceServiceImpl")
	private CompensatoryInterfaceServer compensatoryInterfaceServer;
	
	@Resource(name="recordsBalanceServiceImpl")
	RecordsBalanceService recordsBalanceService;
	
	//第三方提现接口
	@Resource(name="managedInterfaceTestIImpl")
	ManagedInterfaceServerTestI managedInterfaceServer;
	/**
	 * 
	* historyRecordList查询代偿历史记录 
	* TODO查询代偿历史记录
	* @author 杨翰林  
	* * @Title: historyRecordList 
	* @Description: 查询代偿历史记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-6 下午4:06:05
	* @throws
	 */
	@RequestMapping("/historyRecordList")
	@ResponseBody
	public PageEntity historyRecordList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String projectNo = request.getParameter("projectNo");
		String projectTitle = request.getParameter("projectTitle");
		String logname = request.getParameter("logname");
		String personalName = request.getParameter("personalName");
		String guaranteeName = request.getParameter("guaranteeName");
		String personalPhone = request.getParameter("personalPhone");
		String amountEncs = request.getParameter("amountEncs");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String cstartDate = request.getParameter("cstartDate");
		String cendDate = request.getParameter("cendDate");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		req.put("Project_No", projectNo);
		req.put("Project_Title", projectTitle);
		req.put("Logname", logname);
		req.put("Personal_Name", personalName);
		req.put("Guarantee_Name", guaranteeName);
		req.put("Personal_Phone", personalPhone);
		req.put("Amount_Enc", amountEncs);
		req.put("Repay_MaxTime_Min", startDate);
		req.put("Repay_MaxTime_Max", endDate);
		req.put("Compensatory_Time_Min", cstartDate);
		req.put("Compensatory_Time_Max", cendDate);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeAgenciesService.getCompensatoryrecord(pager);
		
		return pager;
	}
	
	/**
	 * 
	* backRecordList查询代偿回款记录 
	* TODO查询代偿回款记录
	* @author 杨翰林  
	* * @Title: backRecordList 
	* @Description: 查询代偿回款记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-6 下午4:19:18
	* @throws
	 */
	@RequestMapping("/backRecordList")
	@ResponseBody
	public PageEntity backRecordList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String projectNo = request.getParameter("projectNo");
		String projectTitle = request.getParameter("projectTitle");
		String logname = request.getParameter("logname");
		String personalName = request.getParameter("personalName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		req.put("Project_No", projectNo);
		req.put("Project_Title", projectTitle);
		req.put("Logname", logname);
		req.put("Personal_Name", personalName);
		req.put("Repay_Time_Min", startDate);
		req.put("Repay_Time_Max", endDate);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeAgenciesService.getReceivablerecords(pager);
		
		return pager;
	}
	
	/**
	 * 
	* compensatoryList查询代偿 
	* TODO查询代偿
	* @author 杨翰林  
	* * @Title: compensatoryList 
	* @Description: 查询代偿
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-9 上午9:20:31
	* @throws
	 */
	@RequestMapping("/guCompensatoryList")
	@ResponseBody
	public PageEntity compensatoryList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String projectNo = request.getParameter("projectNo");
		String projectName = request.getParameter("projectName");
		String projectTitle = request.getParameter("projectTitle");
		String logname = request.getParameter("logname");
		String personalName = request.getParameter("personalName");
		String personalPhone = request.getParameter("personalPhone");
		
		String skey = DbKeyUtil.GetDbCodeKey();
		req.put("skey", skey);
		req.put("guaranteeID", -1);
		req.put("projectNo", projectNo);
		req.put("projectID", projectName);
		req.put("projectTitle", projectTitle);
		req.put("logname", logname);
		req.put("personalName", personalName);
		req.put("personalPhone", personalPhone);
		req.put("isCompensatory", 0);
		
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.Overduecompensation(pager);
		
		return pager;
	}
	
	/**
	 * 
	* OverduecompensationByid根据还款计划id查询单个逾期代偿信息 
	* TODO根据还款计划id查询单个逾期代偿信息
	* @author 杨翰林  
	* * @Title: OverduecompensationByid 
	* @Description: 根据还款计划id查询单个逾期代偿信息 
	* @param @param request
	* @param @return 设定文件 
	* @return OverdueCompensationEntity 返回类型 
	* @date 2016-5-18 下午3:50:51
	* @throws
	 */
	@RequestMapping("/query4compensatory")
	@ResponseBody
	public OverdueCompensationEntity OverduecompensationByid(HttpServletRequest request) {
		
		String repayID = request.getParameter("repayID");
		
		OverdueCompensationEntity overdueCompensationEntity = guaranteeInfoService
				.OverduecompensationByid(IntegerAndString.StringToLong(repayID, -1));
		
		return overdueCompensationEntity;
	}
	
	/**
	 * 
	* Compensatory代偿动作 
	* TODO代偿动作
	* @author 杨翰林  
	* * @Title: Compensatory 
	* @Description: 代偿动作 
	* @param @param request
	* @param @return 设定文件 
	* @return RepayInterfaceEntity 返回类型 
	* @date 2016-5-18 下午4:21:29
	* @throws
	 */
	@RequestMapping("/toCompensatory")
	@ResponseBody
	public String Compensatory (HttpServletRequest request) {
		
//		HttpSession session = HttpSessionUtil.getSession(request);
//		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
//		Long daicangId = userInfo.getStaffId();
		
		
		String appplyId = request.getParameter("appplyId");
		String repalyId = request.getParameter("repalyId");
		String memberType = request.getParameter("memberType");
		
		int[] results = new int[1];
		
		LoanTransferEntity loanTransferEntity = compensatoryInterfaceServer
				.Compensatory(IntegerAndString.StringToLong(appplyId, -1),
						IntegerAndString.StringToLong(repalyId, -1), results, 4764955, IntegerAndString.StringToInt(memberType, -1), request, 
							"/compensatory/backURL.do", "/compensatory/backServerURL.do");
		
		request.setAttribute("loanTransferEntity", loanTransferEntity);
		
		return "dryLot/loantransfertest";
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
		
		String isSuccess = compensatoryInterfaceServer.CompensatoryReturn(request, response);
		
		if ("SUCCESS".equals(isSuccess)) {
			return "recommend/success";
		}else {
			return "recommend/fail";
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
		compensatoryInterfaceServer.CompensatoryNotify(request, response);
	}
	
	/**
	 * 
	* selectMemberThirdAuthInfo查询提现账户信息 
	* TODO查询提现账户信息
	* @author 杨翰林  
	* * @Title: selectMemberThirdAuthInfo 
	* @Description: 查询提现账户信息 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return MemberThirdAuthInfoEntity 返回类型 
	* @date 2016-5-20 下午3:43:37
	* @throws
	 */
	@RequestMapping("/queryThird")
	@ResponseBody
	public MemberThirdAuthInfoEntity selectMemberThirdAuthInfo(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		req.put("memberID", userInfo.getStaffId());
		req.put("memberType", userInfo.getStaffType());
		
		MemberThirdAuthInfoEntity memberThirdAuthInfoEntity = 
				recordsBalanceService.selectMemberThirdAuthInfo(req);
		
		return memberThirdAuthInfoEntity;
	}
	
	/**
	 * 
	* loanWithdraw担保机构提现 
	* TODO担保机构提现
	* @author 杨翰林  
	* * @Title: loanWithdraw 
	* @Description: 担保机构提现 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-20 下午4:41:40
	* @throws
	 */
	@RequestMapping("/present")
	public String loanWithdraw(HttpServletRequest request) {
		
		WithdrawsInterdaceEntity withdraw = new WithdrawsInterdaceEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String bankCardId = request.getParameter("bankCardId");
		String amount = request.getParameter("amount");
		String remark = request.getParameter("remark");
		
		withdraw.setMemberId(userInfo.getStaffId());
		withdraw.setMemberType(userInfo.getStaffType());
		withdraw.setCardId(Long.parseLong(bankCardId));
		withdraw.setAmount(amount);
		withdraw.setRemark3(remark);
		
		withdraw.setSubmitURL("http://218.4.234.150:88/main/loan/toloanwithdraws.action");
		//获取访问来源路径（ip+端口+项目名）
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		withdraw.setReturnURL(basePath+"bankCard/backURL.do");
		
		withdraw.setNotifyURL(basePath+"bankCard/backServerURL.do");
		
		withdraw = managedInterfaceServer.testLoanWithdraws(withdraw);
		request.setAttribute("draws", withdraw);
		
		return "dryLot/loanwithdrawstest";
	}
	
	/**
	 * 
	* returnURL第三方回调 提现页面返回地址 
	* TODO第三方回调 页面返回地址
	* @author 杨翰林  
	* * @Title: returnURL 
	* @Description: 第三方回调 页面返回地址 
	* @param  设定文件 
	* @return void 返回类型 
	* @date 2016-5-17 上午11:02:50
	* @throws
	 */
	@RequestMapping("/pbackURL")
	public String preturnURL(HttpServletRequest request, HttpServletResponse response) {
		
		String isSuccess = managedInterfaceServer.testLoanWithdrawsReturn(request, response);
		
		if ("SUCCESS".equals(isSuccess)) {
			return "recommend/success";
		}else {
			return "recommend/fail";
		}
	}
	
	/**
	 * 
	* notifyURL第三方回调提现 服务器返回地址 
	* TODO第三方回调 服务器返回地址
	* @author 杨翰林  
	* * @Title: notifyURL 
	* @Description: 第三方回调 服务器返回地址 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-17 上午11:06:01
	* @throws
	 */
	@RequestMapping("/pbackServerURL")
	public void pnotifyURL(HttpServletRequest request, HttpServletResponse response) {
		managedInterfaceServer.testLoanWithdrawsNotify(request, response);
	}
}

