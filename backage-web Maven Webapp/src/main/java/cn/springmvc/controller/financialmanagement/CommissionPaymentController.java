
package cn.springmvc.controller.financialmanagement; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.CommissionPaymentRecordsEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.InvestRepaymentEntity;
import cn.springmvc.service.CommissionPaymentService;
import cn.springmvc.service.CommissionissuedService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.sxlc.account.manager.model.LoanTransferEntity;

/**
 * 
* @author 杨翰林 
* @Description: 佣金发放控制层 
* @since 
* @date 2016-5-5 上午10:41:36
 */
@Controller
@RequestMapping("/commission")
public class CommissionPaymentController {
	
	@Resource(name="commissionPaymentServiceImpl")
	private CommissionPaymentService commissionPaymentService;
	
	@Resource(name="managedInterfaceTestIImpl")
	private ManagedInterfaceServerTestI managedInterfaceServerTestI;
	
	@Resource(name="commissionissuedServiceImpl")
	private CommissionissuedService commissionissuedService;
	/**
	 * 
	* commissionList佣金统计列表 
	* TODO佣金统计列表
	* @author 杨翰林  
	* * @Title: commissionList 
	* @Description: 佣金统计列表 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-5 下午3:37:58
	* @throws
	 */
	@RequestMapping("/commissionList")
	@ResponseBody
	public PageEntity commissionList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String memberNo = request.getParameter("memberNo");
		String personalName = request.getParameter("personalName");
		String personalPhone = request.getParameter("personalPhone");
		String startDate = request.getParameter("startDate");
		String payStatu = request.getParameter("payStatu");
		
		req.put("memberNo", memberNo);
		req.put("PersonalName", personalName);
		req.put("PersonalPhone", personalPhone);
		req.put("startDate", startDate);
		req.put("payStatu", payStatu);
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		List<CommissionPaymentRecordsEntity> list = commissionPaymentService
				.CommissionStatisticsCount(pager);
		pager.setResults(list);
		
		return pager;
	}
	
	/**
	 * 
	* sendcommission发放佣金 
	* TODO发放佣金
	* @author 杨翰林  
	* * @Title: sendcommission 
	* @Description: 发放佣金 
	* @param @param request
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-5-5 下午8:17:02
	* @throws
	 */
	@RequestMapping("/sendcommission")
	public void sendcommission(HttpServletRequest request, String realMoney, 
			String type, String memberId, String startTime, String endTime) {
		
		if ("".equals(startTime) && startTime == null) {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//获取当前月第一天：
	        Calendar c = Calendar.getInstance();    
	        c.add(Calendar.MONTH, 0);
	        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	        startTime = format.format(c.getTime());
	        
	        //获取当前月最后一天
	        Calendar ca = Calendar.getInstance();    
	        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
	        endTime = format.format(ca.getTime());
		}
		
		LoanTransferEntity loanTransferEntity = managedInterfaceServerTestI
				.PlatformAwardMoney(Long.valueOf(memberId), startTime, 
						endTime, Long.valueOf(realMoney), Integer.valueOf(type));
		request.setAttribute("loanTransferEntity", loanTransferEntity);
	}
	
	/**
	 * 
	* loanDetailList查询推荐借款明细 
	* TODO查询推荐借款明细
	* @author 杨翰林  
	* * @Title: loanDetailList 
	* @Description: 查询推荐借款明细 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-6 上午11:41:28
	* @throws
	 */
	@RequestMapping("/loanDetailList")
	@ResponseBody
	public PageEntity loanDetailList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		//String commissionId = request.getParameter("commissionId");
		String projectTitle = request.getParameter("projectTitle");
		String personalName = request.getParameter("personalName");
		String logname = request.getParameter("logname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		req.put("Project_Title", projectTitle);
		//req.put("", commissionId);
		req.put("Personal_Name", personalName);
		req.put("Hold_Date_Min", startDate);
		req.put("Hold_Date_Max", endDate);
		req.put("Logname", logname);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		List<BorrowingDetailedEntity> list = commissionissuedService
				.getBorrowingAdvisor(pager);
		pager.setResults(list);
		
		return pager;
	}
	
	/**
	 * 
	* investList查询推荐投资明细
	* TODO查询推荐投资明细)
	* @author 杨翰林  
	* * @Title: investList 
	* @Description: 查询推荐投资明细 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-6 下午1:37:15
	* @throws
	 */
	@RequestMapping("/investList")
	@ResponseBody
	public PageEntity investList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		//String memberID = request.getParameter("memberID");
		String projectTitle = request.getParameter("projectTitle");
		String personalName = request.getParameter("personalName");
		String logname = request.getParameter("logname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		req.put("Project_Title", projectTitle);
		//req.put("", memberID);
		req.put("Personal_Name", personalName);
		req.put("Hold_Date_Min", startDate);
		req.put("Hold_Date_Max", endDate);
		req.put("Logname", logname);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		List<InvestDetailedEntity> list = commissionissuedService
				.getInvestAdvisor(pager);
		pager.setResults(list);
		
		return pager;
	}
	
	/**
	 * 
	* vipList查询vip明细 
	* TODO查询vip明细
	* @author 杨翰林  
	* * @Title: vipList 
	* @Description: 查询vip明细 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-6 下午2:14:00
	* @throws
	 */
	@RequestMapping("/vipList")
	@ResponseBody
	public PageEntity vipList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		//String memberID = request.getParameter("memberID");
		String personalName = request.getParameter("personalName");
		String logname = request.getParameter("logname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		//req.put("", memberID);
		req.put("Personal_Name", personalName);
		req.put("Hold_Date_Min", startDate);
		req.put("Hold_Date_Max", endDate);
		req.put("Logname", logname);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		List<BayVIPEntity> list = commissionissuedService
				.getBayVIPAdvisor(pager);
		pager.setResults(list);
		
		return pager;
	}
	
	/**
	 * 
	* repaymentList查询还本明细 
	* TODO查询还本明细
	* @author 杨翰林  
	* * @Title: repaymentList 
	* @Description: 查询还本明细 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-6 下午2:32:23
	* @throws
	 */
	@RequestMapping("/repaymentList")
	@ResponseBody
	public PageEntity repaymentList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		//String memberID = request.getParameter("memberID");
		String projectTitle = request.getParameter("projectTitle");
		String personalName = request.getParameter("personalName");
		String logname = request.getParameter("logname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String type = request.getParameter("type");
		
		//req.put("", memberID);
		req.put("Project_Title", projectTitle);
		req.put("Personal_Name", personalName);
		req.put("Award_Date_Min", startDate);
		req.put("Award_Date_Max", endDate);
		req.put("Logname", logname);
		req.put("Statu", type);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		List<InvestRepaymentEntity> list = commissionissuedService
				.getRepaymentAdvisor(pager);
		pager.setResults(list);
		
		return pager;
	}
	
}

