
package cn.springmvc.controller.recommend; 

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.Admin;
import cn.springmvc.model.AdminGMEntity;
import cn.springmvc.model.GuaranteeBorrowingEntity;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoDetailsEntity;
import cn.springmvc.model.GuaranteePeriodEntity;
import cn.springmvc.model.GuaranteeRelationalEntity;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.service.GuaranteeAgenciesService;
import cn.springmvc.service.GuaranteeInfoService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;
import cn.sxlc.account.manager.model.AccountInterfaceEntity;
import cn.sxlc.account.manager.model.AuthorizeInterfaceEntity;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
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
	
	@Resource(name="projectBaseInfoServiceImpl")
	private ProjectBaseInfoService projectBaseInfoService;
	
	@Resource(name="managedInterfaceTestIImpl")
	private ManagedInterfaceServerTestI managedInterfaceServerTestI;
	
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
			req.put("recordStatus", IntegerAndString.StringToInt(recordStatus, -1));
			req.put("skey", DbKeyUtil.GetDbCodeKey());
		
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
	public int addAdmin(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String remark = request.getParameter("remark");
		String guaranteeID = request.getParameter("guaranteeID");
		String stype = request.getParameter("stype");
		
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90104);
		entity.setlModuleId(901);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.insertGuaranteeAdmin(
				IntegerAndString.StringToLong(guaranteeID, -1), userName, 
				password, remark, IntegerAndString.StringToInt(stype, -1), entity, sIpInfo);
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
	public AdminGMEntity selectAdmin (HttpServletRequest request) {
		
		String adminID = request.getParameter("adminID");
		AdminGMEntity admin = guaranteeInfoService.selectAdmin(Long.valueOf(adminID));
		
		return admin;
	}
	
	/**
	 * 
	* updateMGAdmin修改管理员 
	* TODO修改管理员
	* @author 杨翰林  
	* * @Title: updateMGAdmin 
	* @Description: 修改管理员 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-17 下午7:04:04
	* @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int updateMGAdmin(HttpServletRequest request) {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String adminID = request.getParameter("adminID");
		String remark = request.getParameter("remark");
		int num = guaranteeInfoService.updateMGAdmin(
				userName, password, remark, IntegerAndString.StringToLong(adminID, -1));
		
		return num;
	}
	
	/**
	 * 
	* selectGuaranteeBorrowing根据Id查询担保机构借款范围 
	* TODO根据Id查询担保机构借款范围
	* @author 杨翰林  
	* * @Title: selectGuaranteeBorrowing 
	* @Description: 根据Id查询担保机构借款范围 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return List<GuaranteeBorrowingEntity> 返回类型 
	* @date 2016-5-23 下午1:50:25
	* @throws
	 */
	@RequestMapping("/range")
	@ResponseBody
	public List<GuaranteeBorrowingEntity> selectGuaranteeBorrowing(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		req.put("guaranteeID", userInfo.getStaffId());
		
		List<GuaranteeBorrowingEntity> list = guaranteeInfoService
				.selectGuaranteeBorrowing(req);
		
		return list;
	}
	
	/**
	 * 
	* insertGuaranteeBorrowing添加借款范围 
	* TODO添加借款范围
	* @author 杨翰林  
	* * @Title: insertGuaranteeBorrowing 
	* @Description: 添加借款范围 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-23 下午2:43:54
	* @throws
	 */
	@RequestMapping("/addrange")
	@ResponseBody
	public int insertGuaranteeBorrowing(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String minAmount = request.getParameter("minAmount");
		String maxAmount = request.getParameter("maxAmount");
		
		req.put("guaranteeID", userInfo.getStaffId());
		req.put("minAmount", minAmount);
		req.put("maxAmount", maxAmount);
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90304);
		entity.setlModuleId(903);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		//int num = guaranteeInfoService
				//.insertGuaranteeBorrowing(req, entity, sIpInfo);
		
		return 0;
	}
	
	/**
	 * 
	* updateGuaranteeBorrowingByID修改借款范围 
	* TODO修改借款范围
	* @author 杨翰林  
	* * @Title: updateGuaranteeBorrowingByID 
	* @Description: 修改借款范围 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-23 下午2:45:01
	* @throws
	 */
	@RequestMapping("/updaterange")
	@ResponseBody
	public int updateGuaranteeBorrowingByID(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String minAmount = request.getParameter("minAmount");
		String maxAmount = request.getParameter("maxAmount");
		
		req.put("guaranteeID", userInfo.getStaffId());
		req.put("minAmount", minAmount);
		req.put("maxAmount", maxAmount);
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90304);
		entity.setlModuleId(903);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService
				.updateGuaranteeBorrowingByID(req, entity, sIpInfo);
		
		return num;
	}
	
	/**
	 * 
	* selectProjectBaseInfoCombox查询项目类型 
	* TODO查询项目类型
	* @author 杨翰林  
	* * @Title: selectProjectBaseInfoCombox 
	* @Description: 查询项目类型 
	* @param @return 设定文件 
	* @return List<ProjectBaseInfoEntity> 返回类型 
	* @date 2016-5-23 下午3:41:19
	* @throws
	 */
	@RequestMapping("/queryselect")
	@ResponseBody
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoCombox() {
		
		List<ProjectBaseInfoEntity> list = projectBaseInfoService.selectProjectBaseInfoCombox();
		
		return list;
	}
	
	/**
	 * 
	* insertGuaranteeRelational设置担保机构类型 
	* TODO设置担保机构类型 
	* @author 杨翰林  
	* * @Title: insertGuaranteeRelational 
	* @Description:设置担保机构类型
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-23 下午4:44:06
	* @throws
	 */
	@RequestMapping("/setType")
	@ResponseBody
	public int insertGuaranteeRelational(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		List<GuaranteeRelationalEntity> list 
			= new ArrayList<GuaranteeRelationalEntity>();
		
		String ids = request.getParameter("content");
		String[] idArray = ids.split(",");
		req.put("guaranteeID", userInfo.getStaffId());
		
		for (String string : idArray) {
			
			if (string != null && !"".equals(string)) {
				
				GuaranteeRelationalEntity guaranteeRelationalEntity
					= new GuaranteeRelationalEntity();
				
				guaranteeRelationalEntity.setProjectID(IntegerAndString
						.StringToLong(string, -1));
				list.add(guaranteeRelationalEntity);
			}
		}

		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90301);
		entity.setlModuleId(903);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.insertGuaranteeRelational(list, entity, sIpInfo, req);
		
		return num;
	}
	
	/**
	 * 
	* selectGuaranteePeriod查询借款期限起止范围 
	* TODO查询借款期限起止范围
	* @author 杨翰林  
	* * @Title: selectGuaranteePeriod 
	* @Description: 查询借款期限起止范围 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return List<GuaranteePeriodEntity> 返回类型 
	* @date 2016-5-23 下午5:34:37
	* @throws
	 */
	@RequestMapping("/rangeLimit")
	@ResponseBody
	public List<GuaranteePeriodEntity> selectGuaranteePeriod(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		req.put("guaranteeID", userInfo.getStaffId());
		
		List<GuaranteePeriodEntity> list = guaranteeInfoService.selectGuaranteePeriod(req);
		
		return list;
	}
	
	
	/**
	 * 
	* insertGuaranteePeriod添加起止范围 
	* TODO添加起止范围
	* @author 杨翰林  
	* * @Title: insertGuaranteePeriod 
	* @Description: 添加起止范围 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-23 下午6:13:24
	* @throws
	 */
	@RequestMapping("/addStartAndEnd")
	@ResponseBody
	public int  insertGuaranteePeriod(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		List<GuaranteePeriodEntity> list = 
				new ArrayList<GuaranteePeriodEntity>();
		
		String daystartDate = request.getParameter("daystartDate");
		String dayendDate = request.getParameter("dayendDate");
		String monthstartDate = request.getParameter("monthstartDate");
		String monthendDate = request.getParameter("monthendDate");
		String yearstartDate = request.getParameter("yearstartDate");
		String yearendDate = request.getParameter("yearendDate");
		
		GuaranteePeriodEntity guaranteePeriodEntity1 = new GuaranteePeriodEntity();
		guaranteePeriodEntity1.setMinDeadline(
				IntegerAndString.StringToInt(daystartDate, -1));
		guaranteePeriodEntity1.setMaxDeadline(
				IntegerAndString.StringToInt(dayendDate, -1));
		guaranteePeriodEntity1.setGuaranteeID(userInfo.getStaffId());
		guaranteePeriodEntity1.setDeadlineType(0);
		list.add(guaranteePeriodEntity1);
		
		GuaranteePeriodEntity guaranteePeriodEntity2 = new GuaranteePeriodEntity();
		guaranteePeriodEntity2.setMinDeadline(
				IntegerAndString.StringToInt(monthstartDate, -1));
		guaranteePeriodEntity2.setMaxDeadline(
				IntegerAndString.StringToInt(monthendDate, -1));
		guaranteePeriodEntity2.setGuaranteeID(userInfo.getStaffId());
		guaranteePeriodEntity2.setDeadlineType(1);
		list.add(guaranteePeriodEntity2);
		
		
		GuaranteePeriodEntity guaranteePeriodEntity3 = new GuaranteePeriodEntity();
		guaranteePeriodEntity3.setMinDeadline(
				IntegerAndString.StringToInt(yearstartDate, -1));
		guaranteePeriodEntity3.setMaxDeadline(
				IntegerAndString.StringToInt(yearendDate, -1));
		guaranteePeriodEntity3.setGuaranteeID(userInfo.getStaffId());
		guaranteePeriodEntity3.setDeadlineType(2);
		list.add(guaranteePeriodEntity3);
		
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90304);
		entity.setlModuleId(903);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.insertGuaranteePeriod(userInfo.getStaffId(), list, entity, sIpInfo);
		
		return num;
	}
	
	/**
	 * 
	* testAccountInterfaceQDD开户
	* TODO开户
	* @author 杨翰林  
	* * @Title: testAccountInterfaceQDD 
	* @Description: 开户 
	* @param @param request
	* @param @return 设定文件 
	* @return AccountInterfaceEntity 返回类型 
	* @date 2016-5-23 下午7:34:31
	* @throws
	 */
	@RequestMapping("/openAcount")
	public String testAccountInterfaceQDD(HttpServletRequest request) {
		
		AccountInterfaceEntity accountInterfaceEntity = new AccountInterfaceEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		accountInterfaceEntity.setMemberType(2);

		//accountInterfaceEntity.setId(6613037);//userInfo.getStaffId()

		accountInterfaceEntity.setId(userInfo.getStaffId());

		
		accountInterfaceEntity = managedInterfaceServerTestI
				.testAccountInterfaceQDD(accountInterfaceEntity, "guarant/pbackURL.do", "guarant/pbackServerURL.do", request);
		request.setAttribute("accountInterfaceEntity", accountInterfaceEntity);
		
		return "dryLot/loanregisterbindtest";
	}
	
	/**
	 * 
	* returnURL第三方回调 开户页面返回地址 
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
		
		String isSuccess = managedInterfaceServerTestI.testLoanRegisterBindReturn(request, response);
		
		if ("SUCCESS".equals(isSuccess)) {
			return "recommend/openAccountFail";
		}else {
			return "recommend/openAccountFail";
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
		managedInterfaceServerTestI.testLoanRegisterBindNotify(request, response);
	}
	
	
	/**
	 * 
	* testLoanAuthorize授权
	* TODO授权
	* @author 杨翰林  
	* * @Title: testLoanAuthorize 
	* @Description: 授权 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-23 下午8:29:17
	* @throws
	 */
	@RequestMapping("/Authorize")
	public String testLoanAuthorize(HttpServletRequest request) {
		
		AuthorizeInterfaceEntity authorizeInterfaceEntity = new AuthorizeInterfaceEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		authorizeInterfaceEntity.setMemberId(userInfo.getStaffId());
		authorizeInterfaceEntity.setMemberType(3);
		
		authorizeInterfaceEntity = managedInterfaceServerTestI
				.testLoanAuthorize(authorizeInterfaceEntity, "guarant/backURL.do", "guarant/backServerURL.do", request);
		request.setAttribute("author", authorizeInterfaceEntity);
		return "dryLot/loanauthorizetest";
	}
	
	/**
	 * 
	* returnURL第三方回调 授权页面返回地址 
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
		
		String isSuccess = managedInterfaceServerTestI.testLoanAuthorizeReturn(request, response);
		
		if ("SUCCESS".equals(isSuccess)) {
			return "recommend/success";
		}else {
			return "recommend/fail";
		}
	}
	
	/**
	 * 
	* notifyURL第三方回调授权 服务器返回地址 
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
		managedInterfaceServerTestI.testLoanAuthorizeNotify(request, response);
	}
	
	/**
	 * 
	* selectGuaranteeCertificate根据担保机构ID查询证件信息 
	* TODO根据担保机构ID查询证件信息
	* @author 杨翰林  
	* * @Title: selectGuaranteeCertificate 
	* @Description: 根据担保机构ID查询证件信息 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return List<GuaranteeCertificateEntity> 返回类型 
	* @date 2016-5-24 上午10:25:35
	* @throws
	 */
	@RequestMapping("/certificate")
	@ResponseBody
	public List<GuaranteeCertificateEntity> selectGuaranteeCertificate(HttpServletRequest  request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		req.put("guaranteeID", userInfo.getStaffId());
		
		List<GuaranteeCertificateEntity> list = guaranteeInfoService
				.selectGuaranteeCertificate(req);
		
		return list;
	}
	
	/**
	 * 
	* insertGuaranteeCertificate添加担保机构证件 
	* TODO添加担保机构证件
	* @author 杨翰林  
	* * @Title: insertGuaranteeCertificate 
	* @Description: 添加担保机构证件 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-24 上午10:28:53
	* @throws
	 */
	@RequestMapping("addcertificate")
	@ResponseBody
	public int insertGuaranteeCertificate(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		List<ManagementCertificateEntity> list = 
				new ArrayList<ManagementCertificateEntity>();
		
		String managementURLs = request.getParameter("content");
		String[] managementURL = managementURLs.split(",");
		
		for (String string : managementURL) {
			if (string != null && !"".equals(string)) {
				ManagementCertificateEntity managementCertificateEntity 
				= new ManagementCertificateEntity();
				managementCertificateEntity.setManagementID(userInfo.getStaffId());
				managementCertificateEntity.setManagementURL(string);
				list.add(managementCertificateEntity);
			}
		}
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90306);
		entity.setlModuleId(903);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.insertGuaranteeCertificate(userInfo.getStaffId(), list, entity, sIpInfo);
		
		return num;
	}
	
	
}

