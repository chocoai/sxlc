
package cn.springmvc.controller.financialmanagement; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;


import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.service.GuaranteeInfoService;
import cn.springmvc.service.ProjectBaseInfoService;

/**
 * 
* @author 杨翰林 
* @Description: 财务管理代偿控制层 
* @since 
* @date 2016-5-6 下午2:58:46
 */
@Controller
@RequestMapping("/financeCompensatory")
public class CompensatoryController {
	
	@Resource(name="guaranteeInfoServiceImpl")
	private GuaranteeInfoService guaranteeInfoService;
	
	@Resource(name="projectBaseInfoServiceImpl")
	private ProjectBaseInfoService projectBaseInfoService;
	
	/**
	 * 
	* query4type查询产品类型 
	* TODO查询产品类型
	* @author 杨翰林  
	* * @Title: query4type 
	* @Description: 查询产品类型 
	* @param @return 设定文件 
	* @return List<ProjectBaseInfoEntity> 返回类型 
	* @date 2016-5-9 上午10:55:44
	* @throws
	 */
	@RequestMapping("/query4type")
	@ResponseBody
	public List<ProjectBaseInfoEntity> query4type() {
		
		List<ProjectBaseInfoEntity> list = projectBaseInfoService.selectProjectBaseInfoCombox();
		
		return list;
	}
	
	/**
	 * 
	* CompensatoryList查询平台代偿记录 
	* TODO查询平台代偿记录
	* @author 杨翰林  
	* * @Title: CompensatoryList 
	* @Description: 查询平台代偿记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-9 上午11:57:05
	* @throws
	 */
	@RequestMapping("/CompensatoryList")
	@ResponseBody
	public PageEntity CompensatoryList(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String projectNo = request.getParameter("projectNo");
		String projectName = request.getParameter("projectName");
		String projectTitle = request.getParameter("projectTitle");
		String logname = request.getParameter("logname");
		String personalName = request.getParameter("personalName");
		String personalPhone = request.getParameter("personalPhone");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String skey = DbKeyUtil.GetDbCodeKey();
		
		req.put("projectNo", projectNo);
		req.put("projectName", projectName);
		req.put("projectTitle", projectTitle);
		req.put("logname", logname);
		req.put("personalName", personalName);
		req.put("personalPhone", personalPhone);
		req.put("startTime", startDate);
		req.put("endTime", endDate);
		req.put("projectID", -1);
		req.put("skey", skey);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.PtOverduecompensation(pager);
		return pager;
	}
	
	/**
	 * 
	* backRecord查询代偿回款记录 
	* TODO查询代偿回款记录
	* @author 杨翰林  
	* * @Title: backRecord 
	* @Description: 查询代偿回款记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-9 下午2:42:08
	* @throws
	 */
	@RequestMapping("/backRecord")
	@ResponseBody
	public PageEntity backRecord(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String projectNo = request.getParameter("projectNo");
		String projectName = request.getParameter("projectName");
		String projectTitle = request.getParameter("projectTitle");
		String logname = request.getParameter("logname");
		String personalName = request.getParameter("personalName");
		String personalPhone = request.getParameter("personalPhone");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String bstartDate = request.getParameter("bstartDate");
		String bendDate = request.getParameter("bendDate");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String skey = DbKeyUtil.GetDbCodeKey();
		
		req.put("projectNo", projectNo);
		req.put("projectName", projectName);
		req.put("projectTitle", projectTitle);
		req.put("logname", logname);
		req.put("personalName", personalName);
		req.put("personalPhone", personalPhone);
		req.put("startpaymentTime", bstartDate);
		req.put("endpaymentTime", bendDate);
		req.put("startTime", startDate);
		req.put("endTime", endDate);
		req.put("projectID", -1);
		req.put("skey", skey);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.PaymentOverduecompensation(pager);
		return pager;
	}
}

