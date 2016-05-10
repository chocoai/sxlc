
package cn.springmvc.controller.recommend; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.Admin;
import cn.springmvc.model.ManagementCertificateEntity;
import cn.springmvc.model.ManagementInfoEntity;
import cn.springmvc.service.GuaranteeInfoService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

/**
 * 
* @author 杨翰林 
* @Description: 资产管理方管理控制层 
* @since 
* @date 2016-5-4 上午9:58:21
 */
@Controller
@RequestMapping("/asset")
public class AssetManagementController {

	@Resource(name="guaranteeInfoServiceImpl")
	private GuaranteeInfoService guaranteeInfoService;
	
	/**
	 * 
	* assetList查询资产管理方列表 
	* TODO查询资产管理方列表 
	* @author 杨翰林  
	* * @Title: assetList 
	* @Description: 查询资产管理方列表  
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-4 上午10:05:09
	* @throws
	 */
	@RequestMapping("/assetList")
	@ResponseBody
	public PageEntity assetList (HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String managementNO = request.getParameter("managementNO");
		String managementName = request.getParameter("managementName");
		String companyeBLN = request.getParameter("companyeBLN");
		String contactName = request.getParameter("contactName");
		String contactPhone = request.getParameter("contactPhone");
		String recordStatus = request.getParameter("recordStatus");
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		
		req.put("managementNO", managementNO);
		req.put("companyeBLN", companyeBLN);
		req.put("managementName", managementName);
		req.put("contactName", contactName);
		req.put("contactPhone", contactPhone);
		req.put("recordStatus", recordStatus);
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.selectAllManagementInfo(pager);
		return pager;
	}
	
	/**
	 * 
	* save添加、修改资产管理方管理 
	* TODO添加、修改资产管理方管理
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加、修改资产管理方管理 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-4 上午10:48:47
	* @throws
	 */
	@RequestMapping("/save")
	@ResponseBody
	public int save(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String managementName = request.getParameter("managementName");
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
		String personalIDCard = request.getParameter("personalIDCard");
		String types = request.getParameter("types");
		String managementID = request.getParameter("managementID");
		
		req.put("managementName", managementName);
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
		if (!"".equals(managementID)) {
			req.put("managementID", managementID);
		}
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90201);
		entity.setlModuleId(902);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.handleManagementInfo(req, entity, sIpInfo);
		
		return num;
	}
	
	/**
	 * 
	* query4mod通过id查询资产管理方 
	* TODO通过id查询资产管理方
	* @author 杨翰林  
	* * @Title: query4mod 
	* @Description: 通过id查询资产管理方 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return ManagementInfoEntity 返回类型 
	* @date 2016-5-4 下午2:33:52
	* @throws
	 */
	@RequestMapping("/query4mod")
	@ResponseBody
	public ManagementInfoEntity query4mod(HttpServletRequest request, Map<String, Object> req) {
		
		String managementID = request.getParameter("managementID");
		req.put("managementID", managementID);
		
		ManagementInfoEntity entity = guaranteeInfoService.selectManagementInfoById(req);
		return entity;
	}
	
	/**
	 * 
	* ofOrOpen停用启用资产管理方 
	* TODO停用启用资产管理方
	* @author 杨翰林  
	* * @Title: ofOrOpen 
	* @Description: 停用启用资产管理方 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-4 下午3:13:07
	* @throws
	 */
	@RequestMapping("/ofOrOpen")
	@ResponseBody
	public int ofOrOpen (HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String managementID = request.getParameter("managementID");
		String recordStatus = request.getParameter("recordStatus");
		if (!"".equals(managementID)) {
			req.put("guaranteeId", managementID);
		}
		if (!"".equals(recordStatus)) {
			req.put("recordStatus", recordStatus);
		}
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(90205);
		entity.setlModuleId(901);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = guaranteeInfoService.deleteOrStopManagementInfo(req, entity, sIpInfo);
		return num;
		
	}
	
	/**
	 * 
	* query4Certificate通过id查询证件信息 
	* TODO通过id查询证件信息
	* @author 杨翰林  
	* * @Title: query4Certificate 
	* @Description: 通过id查询证件信息 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return List<ManagementCertificateEntity> 返回类型 
	* @date 2016-5-4 下午4:41:44
	* @throws
	 */
	@RequestMapping("/query4Certificate")
	@ResponseBody
	public List<ManagementCertificateEntity> query4Certificate (HttpServletRequest request, Map<String, Object> req) {
		
		String managementID = request.getParameter("managementID");
		req.put("managementID", managementID);
		
		List<ManagementCertificateEntity> list = guaranteeInfoService.selectManagementCertificate(req);
		
		return list;
	}
	
	/**
	 * 
	* queryAdmin查询管理员列表 
	* TODO查询管理员列表
	* @author 杨翰林  
	* * @Title: queryAdmin 
	* @Description: 查询管理员列表 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-4 下午5:37:46
	* @throws
	 */
	@RequestMapping("/queryAdmin")
	@ResponseBody
	public PageEntity queryAdmin(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String managementID = request.getParameter("managementID");
		String length = request.getParameter("length");
		String start = request.getParameter("start");
		req.put("managementID", managementID);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		pager.setMap(req);
		
		guaranteeInfoService.findManagementAdmin(pager);
		return pager;
	}
}

