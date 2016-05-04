
package cn.springmvc.controller.recommend; 

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.Admin;
import cn.springmvc.model.GuaranteeInfoDetailsEntity;
import cn.springmvc.service.GuaranteeAgenciesService;
import cn.springmvc.service.GuaranteeInfoService;
import cn.springmvc.service.IAdminService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

/**
 * 
* @author 杨翰林 
* @Description: 保荐机构控制层 
* @since 
* @date 2016-4-27 上午10:52:59
 */
@Controller
@RequestMapping("/guarant")
public class GuaranteeController {
	
	@Resource(name="guaranteeInfoServiceImpl")
	private GuaranteeInfoService guaranteeInfoService;
	
	@Resource(name="guaranteeAgenciesServiceImpl")
	private GuaranteeAgenciesService guaranteeAgenciesService;
	
	@Autowired
	private IAdminService adminService;
	
	/**
	 * 
	* list查询担保机构列表 
	* TODO查询担保机构列表
	* @author 杨翰林  
	* * @Title: list 
	* @Description: 查询担保机构列表 
	* @param @param req
	* @param @param request
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-4-27 上午10:52:29
	* @throws
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageEntity list(Map<String, Object> req, HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		String guaranteeNo = request.getParameter("guaranteeNo");
		String guaranteeName = request.getParameter("guaranteeName");
		String companyeBLN = request.getParameter("companyeBLN");
		String contactName = request.getParameter("contactName");
		String contactPhone = request.getParameter("contactPhone");
		String recordStatus = request.getParameter("recordStatus");
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		
			req.put("guaranteeNo", guaranteeNo);
			req.put("guaranteeName", guaranteeName);
			req.put("companyeBLN", companyeBLN);
			req.put("contactName", contactName);
			req.put("contactPhone", contactPhone);
			req.put("statu", IntegerAndString.StringToInt(recordStatus, -1));
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.selectAllGuaranteeInfo(pager);
		
		return pager;
	}
	
	/**
	 * 
	* save添加修改担保机构 
	* TODO添加修改担保机构
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加修改担保机构 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-27 上午11:19:42
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String guaranteeName = request.getParameter("guaranteeName");
		String companyeBLN = request.getParameter("companyeBLN");
		String companyOC = request.getParameter("companyOC");
		String taxRegNo = request.getParameter("taxRegNo");
		String establishments = request.getParameter("establishments");
		String companyCapital = request.getParameter("companyCapital");
		String companyAddress = request.getParameter("companyAddress");
		String companySource = request.getParameter("companySource");
		String companyBusiness = request.getParameter("companyBusiness");
		String companyProfile = request.getParameter("companyProfile");
		String contactName = request.getParameter("contactName");
		String contactPhone = request.getParameter("contactPhone");
		String contactEmail = request.getParameter("contactEmail");
		String personalPhone = request.getParameter("personalPhone");
		String personalName = request.getParameter("personalName");
		String personalIDCard = request.getParameter("personalIdCard");
		String types = request.getParameter("types");
		String guaranteeId = request.getParameter("guaranteeId");
		
		req.put("guaranteeName", guaranteeName);
		req.put("companyeBLN", companyeBLN);
		req.put("companyOC", companyOC);
		req.put("taxRegNo", taxRegNo);
		req.put("establishments", establishments);
		req.put("personalPhone", personalPhone);
		req.put("companyCapital", companyCapital);
		req.put("companyAddress", companyAddress);
		req.put("companySource", companySource);
		req.put("companyBusiness", companyBusiness);
		req.put("companyProfile", companyProfile);
		req.put("companyBusiness", companyBusiness);
		req.put("contactName", contactName);
		req.put("contactPhone", contactPhone);
		req.put("contactEmail", contactEmail);
		req.put("personalName", personalName);
		req.put("personalIDCard", personalIDCard);
		req.put("types", types);
		if (!"".equals(guaranteeId)) {
			req.put("guaranteeID", guaranteeId);
		}
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90101);
		entity.setlModuleId(901);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.handleGuaranteeInfo(req, entity, sIpInfo);
		
		return num;
	}
	
	/**
	 * 
	* queryDetail查询担保机构信息 
	* TODO查询担保机构信息
	* @author 杨翰林  
	* * @Title: queryDetail 
	* @Description: 查询担保机构信息 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return GuaranteeInfoEntity 返回类型 
	* @date 2016-4-27 上午11:27:36
	* @throws
	 */
	@RequestMapping("/query4select")
	@ResponseBody
	public GuaranteeInfoDetailsEntity queryDetail(HttpServletRequest request, Map<String, Object> req) {
		
		String guaranteeId = request.getParameter("guaranteeId");
		req.put("guaranteeID", guaranteeId);
		
		GuaranteeInfoDetailsEntity entity = guaranteeInfoService.selectGuaranteeInfoById(req);
		
		return entity;
	}
	
	/**
	 * 
	* projectList查询担保项目 
	* TODO查询担保项目
	* @author 杨翰林  
	* * @Title: projectList 
	* @Description: 查询担保项目 
	* @param @param req
	* @param @param request
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-3 上午11:13:05
	* @throws
	 */
	@RequestMapping("/projectList")
	@ResponseBody
	public PageEntity projectList(Map<String, Object> req, HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		String guaranteeID = request.getParameter("guaranteeID");
		String projectNo = request.getParameter("projectNo");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate1 = request.getParameter("startDate1");
		String endDate1 = request.getParameter("endDate1");
		String guaranteeName = request.getParameter("guaranteeName");
		String isCompensatory = request.getParameter("isCompensatory");
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		
		req.put("guaranteeID", guaranteeID);
		req.put("projectNo", projectNo);
		req.put("Record_Date_Min", startDate);
		req.put("Record_Date_Max", endDate);
		req.put("Compensatory_Time_Min", startDate1);
		req.put("Compensatory_Time_Max", endDate1);
		req.put("Guarantee_Name", guaranteeName);
		req.put("IsCompensatory", isCompensatory);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeAgenciesService.getGuaranteeproject(pager);
		
		return pager;
	}
	
	/**
	 * 
	* compensatoryrecord查询代偿记录 
	* TODO查询代偿记录
	* @author 杨翰林  
	* * @Title: compensatoryrecord 
	* @Description: 查询代偿记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-3 下午2:01:38
	* @throws
	 */
	@RequestMapping("/compensatoryrecord")
	@ResponseBody
	public PageEntity compensatoryrecord (HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String guaranteeID = request.getParameter("guaranteeID");
		String projectNo = request.getParameter("projectNo");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String startDate2 = request.getParameter("startDate2");
		String endDate2 = request.getParameter("endDate2");
		String guaranteeName = request.getParameter("guaranteeName");
		String projectTitle = request.getParameter("projectTitle");
		String personalName = request.getParameter("personalName");
		String logname = request.getParameter("logname");
		String personalPhone = request.getParameter("personalPhone");
		String status = request.getParameter("status");
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		
		req.put("guaranteeID", guaranteeID);
		req.put("projectNo", projectNo);
		req.put("Repay_MaxTime_Min", startDate);
		req.put("Repay_MaxTime_Max", endDate);
		req.put("Compensatory_Time_Min", startDate2);
		req.put("Compensatory_Time_Max", endDate2);
		req.put("Guarantee_Name", guaranteeName);
		req.put("status", status);
		req.put("personalPhone", personalPhone);
		req.put("projectTitle", projectTitle);
		req.put("personalName", personalName);
		req.put("logname", logname);
		
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeAgenciesService.getCompensatoryrecord(pager);
		
		return pager;
	}
	
	/**
	 * 
	* receivablerecords查询代偿回款记录
	* TODO查询代偿回款记录
	* @author 杨翰林  
	* * @Title: receivablerecords 
	* @Description: 查询代偿回款记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-3 下午2:03:19
	* @throws
	 */
	@RequestMapping("/receivablerecords")
	@ResponseBody
	public PageEntity receivablerecords (HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String guaranteeID = request.getParameter("guaranteeID");
		String projectNo = request.getParameter("projectNo");
		String projectTitle = request.getParameter("projectTitle");
		String personalName = request.getParameter("personalName");
		String logname = request.getParameter("logname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String guaranteeName = request.getParameter("guaranteeName");
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		
		req.put("guaranteeID", guaranteeID);
		req.put("projectNo", projectNo);
		req.put("Record_Date_Min", startDate);
		req.put("Record_Date_Max", endDate);
		req.put("guaranteeName", guaranteeName);
		req.put("projectTitle", projectTitle);
		req.put("personalName", personalName);
		req.put("logname", logname);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeAgenciesService.getReceivablerecords(pager);
		
		return pager;
	}
	
	/**
	 * 
	* ofOrOpen启用停用担保机构 
	* TODO启用停用担保机构
	* @author 杨翰林  
	* * @Title: ofOrOpen 
	* @Description: 启用停用担保机构 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-29 上午11:34:09
	* @throws
	 */
	@RequestMapping("/ofOrOpen")
	@ResponseBody
	public int ofOrOpen (HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String guaranteeId = request.getParameter("guaranteeId");
		String recordStatus = request.getParameter("recordStatus");
		if (!"".equals(guaranteeId)) {
			req.put("guaranteeId", guaranteeId);
		}
		if (!"".equals(recordStatus)) {
			req.put("recordStatus", recordStatus);
		}
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90105);
		entity.setlModuleId(901);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.deleteOrStopGuaranteeInfo(req, entity, sIpInfo);
		return num;
		
	}
	
	
	/**
	 * 
	* adminlist查询管理员列表 
	* TODO查询管理员列表
	* @author 杨翰林  
	* * @Title: adminlist 
	* @Description: 查询管理员列表 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-4-29 下午2:33:15
	* @throws
	 */
	@RequestMapping("/adminlist")
	@ResponseBody
	public PageEntity adminlist(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		String guaranteeID = request.getParameter("guaranteeID");
		
		req.put("guaranteeID", guaranteeID);
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		guaranteeInfoService.findGuaranteeAdmin(pager);
		return pager;
	}
	/**
	 * 
	* ofOrOpenAdmin启用停用管理员 
	* TODO启用停用管理员
	* @author 杨翰林  
	* * @Title: ofOrOpenAdmin 
	* @Description: 启用停用管理员 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-29 下午2:45:29
	* @throws
	 */
	@RequestMapping("/ofOrOpenAdmin")
	@ResponseBody
	public int ofOrOpenAdmin(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String adminID = request.getParameter("adminID");
		String status = request.getParameter("status");
		if (!"".equals(adminID)) {
			req.put("adminID", adminID);
		}
		if (!"".equals(status)) {
			req.put("status", status);
		}
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90105);
		entity.setlModuleId(901);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.updateGuaranteeAdmin(req, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* addAdmin添加管理员 
	* TODO添加管理员
	* @author 杨翰林  
	* * @Title: addAdmin 
	* @Description: 添加管理员 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-29 下午4:44:07
	* @throws
	 */
	@RequestMapping("/saveAdmin")
	@ResponseBody
	public int addAdmin(HttpServletRequest request, Map<String,Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		Admin admin = new Admin();
		
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		String adminRemark = request.getParameter("adminRemark");
		
		if (!"".equals(adminRemark)) {
			admin.setAdminRemark(adminRemark);
		}
			admin.setAdminName(adminName);
			admin.setAdminPwd(adminPwd);
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90105);
		entity.setlModuleId(901);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = adminService.saveAdmin(admin, 0, entity, sIpInfo);
		return num;
	}
	
	/**
	 * 
	* queryAdmin查询管理员信息 
	* TODO查询管理员信息
	* @author 杨翰林  
	* * @Title: queryAdmin 
	* @Description: 查询管理员信息 
	* @param @param request
	* @param @return 设定文件 
	* @return Admin 返回类型 
	* @date 2016-4-29 下午4:47:29
	* @throws
	 */
	@RequestMapping("/queryAdmin")
	@ResponseBody
	public Admin queryAdmin (HttpServletRequest request) {
		
		String adminId = request.getParameter("adminId");
		Admin admin = adminService.findAdminById(Long.valueOf(adminId));
		
		return admin;
	}
	
	
	
}

