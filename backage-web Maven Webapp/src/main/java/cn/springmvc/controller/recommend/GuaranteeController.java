
package cn.springmvc.controller.recommend; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.Util.HttpSessionUtil;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.model.GuaranteeCertificateEntity;
import cn.springmvc.model.GuaranteeInfoDetailsEntity;
import cn.springmvc.model.GuaranteeInfoEntity;
import cn.springmvc.service.GuaranteeAgenciesService;
import cn.springmvc.service.GuaranteeInfoService;
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
	
	
	@RequestMapping("/projectList")
	@ResponseBody
	public PageEntity projectList(Map<String, Object> req, HttpServletRequest request) {
		
		PageEntity pager = new PageEntity();
		
		guaranteeAgenciesService.getGuaranteeproject(pager);
		return null;
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
	* queryCertificate查询证件信息 
	* TODO查询证件信息
	* @author 杨翰林  
	* * @Title: queryCertificate 
	* @Description: 查询证件信息 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return List<GuaranteeCertificateEntity> 返回类型 
	* @date 2016-4-29 上午11:45:11
	* @throws
	 */
	@RequestMapping("/queryCertificate")
	@ResponseBody
	public List<GuaranteeCertificateEntity> queryCertificate(HttpServletRequest request, Map<String, Object> req) {
		
		String guaranteeId = request.getParameter("guaranteeId");
		
		if (!"".equals(guaranteeId)){
			req.put("guaranteeID", guaranteeId);
		}
		List<GuaranteeCertificateEntity> list = guaranteeInfoService.selectGuaranteeCertificate(req);
		
		return list;
	}
	
}

