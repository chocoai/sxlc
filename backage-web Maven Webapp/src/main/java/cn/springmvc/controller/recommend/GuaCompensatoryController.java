
package cn.springmvc.controller.recommend; 

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.service.GuaranteeAgenciesService;
import cn.springmvc.service.GuaranteeInfoService;
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
		req.put("projectID", -1);
		req.put("projectNo", projectNo);
		req.put("projectID", projectName);
		req.put("projectTitle", projectTitle);
		req.put("logname", logname);
		req.put("personalName", personalName);
		req.put("personalPhone", personalPhone);
		
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.Overduecompensation(pager);
		
		return pager;
	}
}

