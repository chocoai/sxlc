
package cn.springmvc.controller.financialmanagement; 

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.service.LoanService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.TransferableCreditsService;
import cn.sxlc.account.manager.model.AuditEntity;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;

/**
 * 
* @author 杨翰林 
* @Description: 债券转让、放款控制层 
* @since 
* @date 2016-5-17 上午9:22:52
 */
@Controller
@RequestMapping("/finance")
public class LendingController {
	
	@Resource(name="loanServiceImpl")
	private LoanService loanService;
	
	@Resource(name="managedInterfaceTestIImpl")
	private ManagedInterfaceServerTestI managedInterfaceServerTestI;

	@Resource(name="transferableCreditsServiceImpl")
	private TransferableCreditsService transferableCreditsService;
	
	/** 
	 * @author 唐国峰 
	 * @Description: 项目放款页面
	 * @param req
	 * @return String  
	 * @date 2016-5-20 下午12:54:14
	 * @throws 
	 */
	@RequestMapping("/toFnProLendingPg")
	public String toFnProLendingPg(HttpServletRequest req){
		return "finance/fn-pro-lending";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 债权转让放款页面
	 * @param req
	 * @return String  
	 * @date 2016-5-20 下午12:54:14
	 * @throws 
	 */
	@RequestMapping("/toFnTransLendingPg")
	public String toFnTransLendingPg(HttpServletRequest req){
		return "finance/fn-trans-lending";
	}
	
	/**
	 * 
	* projectLending查询放款列表 
	* TODO查询放款列表
	* @author 杨翰林  
	* * @Title: projectLending 
	* @Description: 查询放款列表 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-17 上午10:46:00
	* @throws
	 */
	@RequestMapping("/lendingList")
	@ResponseBody
	public PageEntity projectLending(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String projectNo = request.getParameter("projectNo");
		String logname = request.getParameter("logname");
		String memberName = request.getParameter("memberName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dealine = request.getParameter("dealine");
		String deadlineType = request.getParameter("deadlineType");
		String minAmount = request.getParameter("minAmount");
		String maxAmount = request.getParameter("maxAmount");
		String statu = request.getParameter("statu");
		
		req.put("projectNo", projectNo);
		req.put("Logname", logname);
		req.put("name", memberName);
		req.put("startTime", startDate);
		req.put("endTime", endDate);
		req.put("dealine", dealine);
		req.put("deadlineType", deadlineType);
		req.put("minAmount", minAmount);
		req.put("maxAmount", maxAmount);
		req.put("statu", statu);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		loanService.selectLoanList(pager);
		
		return pager;
	}
	
	@RequestMapping("/translendingList")
	@ResponseBody
	public PageEntity projectTransLending(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();

		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String projectName = request.getParameter("projectName");
		String loanMemberName = request.getParameter("loanMemberName");
		String transferMemberName = request.getParameter("transferMemberName");
		String status = request.getParameter("status");
		String startfangkuanTime = request.getParameter("startfangkuanTime");
		String endfangkuanTime = request.getParameter("endfangkuanTime");
		String sKey = DbKeyUtil.GetDbCodeKey();
		
		req.put("skey", sKey);
		req.put("projectName", projectName);
		req.put("loanMemberName", loanMemberName);
		req.put("transferMemberName", transferMemberName);
		req.put("status", status);
		req.put("startfangkuanTime", startfangkuanTime);
		req.put("endfangkuanTime", endfangkuanTime);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		transferableCreditsService.transferableCreditsFangKuan(pager);
		return pager;
	}
	
	/**
	 * 
	* ProjectSubmitDataProcessing放款 
	* TODO放款
	* @author 杨翰林  
	* * @Title: ProjectSubmitDataProcessing 
	* @Description: 放款 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return AuditEntity 返回类型 
	* @date 2016-5-17 上午10:46:21
	* @throws
	 */
	@RequestMapping("/loan")
	public String ProjectSubmitDataProcessing(HttpServletRequest request, Map<String, Object> req, 
			HttpServletResponse response) {
	
		String projectId = request.getParameter("projectId");
		String stype = request.getParameter("stype");
		String auditType = request.getParameter("auditType");
		String url = "";
		if("1".equals(stype)){//项目
			url = "/finance/backServerURL.do";
		}else if("2".equals(stype)){//债权
			url = "/finance/transCreditorBack.do";
		}
		AuditEntity auditEntity = managedInterfaceServerTestI
				.ProjectSubmitDataProcessing(IntegerAndString.StringToInt(stype,0), IntegerAndString.StringToLong(projectId,0),
						auditType, "/finance/backURL.do",url, request);
		request.setAttribute("transferAudit", auditEntity);
		if(auditEntity.getStatu() == -1){
			return "recommend/success";
		}else{
			return "dryLot/loantransyhl";
		}
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
		String result = managedInterfaceServerTestI.testLoanTransferAuditReturn(request, response);
		if("FAIL".equals(result)){
			return "recommend/fail";
		}else if("SUCCESS".equals(result)){
			return "recommend/success";
		}else{
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
		managedInterfaceServerTestI.testLoanTransferAuditNotify(request, response);
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 债权转让放款 第三方回调 服务器返回地址
	 * @param request
	 * @param response  
	 * @return void  
	 * @date 2016-5-23 上午9:10:07
	 * @throws 
	 */
	@RequestMapping("/transCreditorBack")
	public void transCreditorBack(HttpServletRequest request, HttpServletResponse response) {
		managedInterfaceServerTestI.TransferOfCreditorsFangkuanBack(request, response);
	}
	
	
	
}

