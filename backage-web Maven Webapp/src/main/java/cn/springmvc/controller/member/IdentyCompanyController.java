package cn.springmvc.controller.member; 

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.EnterpriseAttestEntity;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.service.CertificationAuditService;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 *  企业认证
 * @date:2016-5-2 下午2:36:49
 **/
@Controller
@RequestMapping("/companyidety")
public class IdentyCompanyController {
	
	@Autowired
	private CertificationAuditService certificationAuditService;
	
/*************************查询会员认证列表 start*************************************************************/	
	
	
	/**
	 * 企业认证列表
	 * TODO
	 * 创建日期：2016-5-10下午3:19:36
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getCompanyIdentyList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getCompanyIdentyList(HttpServletRequest req){
		//查询条件
		int   attestTypeID = IntegerAndString.StringToInt(req.getParameter("attestTypeID"), 1);
		String logname = req.getParameter("logName");
		String companyName = req.getParameter("companyName");
		int status  = IntegerAndString.StringToInt( req.getParameter("statu"), 1);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("logname", logname);
		map.put("companyName", companyName);
		map.put("attestTypeID", attestTypeID);
		map.put("memberType", 1);
		map.put("status", status);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		
		String xmlSql=""; //认证  配置   认证sql
		if(attestTypeID==12){ //营业执照认证
			xmlSql="EnterpriseCAXML.EnterpriseBLCertification";
		}else if(attestTypeID==13){//工商执照认证
			xmlSql="EnterpriseCAXML.EnterprisebusinessLC";
		}else if(attestTypeID==14){//组织机构认证
			xmlSql="EnterpriseCAXML.EnterpriseOrganizationCode";
		}else if(attestTypeID==15){//开户许可证认证
			xmlSql="EnterpriseCAXML.accountLicenseCode";
		}else if(attestTypeID==18){//税务登记认证
			xmlSql="EnterpriseCAXML.EnterprisebusinessSW";
		}else if(attestTypeID==22){//房产认证
			xmlSql="EnterpriseCAXML.HouseAuthentication";
		}else if(attestTypeID==23){//车产认证
			xmlSql="EnterpriseCAXML.CarAuthentication";
		}else {//其他认证
			xmlSql="EnterpriseCAXML.EnterpriseCommonCertification";
		}
		map.put("xmlSql", xmlSql);
		pager.setMap(map);
		certificationAuditService.EnterpriseOrganizationCode(pager);
		return pager;
	}
	
	/**
	 * 企业认证详情
	 * TODO
	 * 创建日期：2016-5-10下午5:15:26
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return EnterpriseAttestEntity
	 */
	@RequestMapping(value ="/identyDetail", method = RequestMethod.POST)
	@ResponseBody
	public EnterpriseAttestEntity identyDetail(HttpServletRequest req){
		long   certificationID = IntegerAndString.StringToLong(req.getParameter("content"), 0); //认证id
		long   certificationType = IntegerAndString.StringToLong(req.getParameter("start"), 12); //认证类型
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("certificationID", certificationID);
		map.put("certificationType", certificationType);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		return certificationAuditService.sEnterpriseLicenseAttestByID(map);
	}
	
	/**
	 * 提交营业执照认证
	 * TODO
	 * 创建日期：2016-5-11下午2:20:14
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
    @RequestMapping(value ="/submitDobusiness", method = RequestMethod.POST)
	@ResponseBody
	public int submitDobusiness(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberID = IntegerAndString.StringToLong(request.getParameter("memberID"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		String endDate = request.getParameter("sEndDate");
		if(endDate!=null && !endDate.equals("")){
			endDate +=" 11:59:59";
		}else{
			endDate = null;
		}
		map.put("certificationID", attestId);
		map.put("memberID", memberID);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("sfirmBLN", "");
		map.put("sfirmAddress", "");
		map.put("regCapital", "");
		map.put("sregBusiness", "");
		map.put("personalId", 0);
		map.put("spersonalName", "");
		map.put("companyID", 0);
		IdGeneratorUtil idGeneratorUtil = new IdGeneratorUtil();
		map.put("creditIntegralID", idGeneratorUtil.GetId());
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)request.getSession().getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
			map.put("adminID", userInfo.getId());
		}
		entity.setlOptId(10201);
		entity.setlModuleId(102);
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
	    Map<String, Object> Ma=  certificationAuditService.handleEnterpriseCerAudit(map, entity, sIpInfo);
	    int iResult =(int) Ma.get("rulest");
		return iResult;
	}
	/**
	 * 提交工商管理认证
	 * TODO
	 * 创建日期：2016-5-11下午3:28:53
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
    @RequestMapping(value ="/submitBusinessManage", method = RequestMethod.POST)
	@ResponseBody
	public int submitBusinessManage(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberID = IntegerAndString.StringToLong(request.getParameter("memberID"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		String endDate = request.getParameter("sEndDate");
		if(endDate!=null && !endDate.equals("")){
			endDate +=" 11:59:59";
		}else{
			endDate = null;
		}
		map.put("certificationID", attestId);
		map.put("memberID", memberID);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("regCapital", "");
		map.put("sregBusiness", "");
		map.put("personalId", 0);
		map.put("spersonalName", "");
		map.put("companyID", 0);
		IdGeneratorUtil idGeneratorUtil = new IdGeneratorUtil();
		map.put("creditIntegralID", idGeneratorUtil.GetId());
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)request.getSession().getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
			map.put("adminID", userInfo.getId());
		}
		entity.setlOptId(10201);
		entity.setlModuleId(102);
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
	    Map<String, Object> Ma=  certificationAuditService.handleEnterpriseBLAttest(map, entity, sIpInfo);
	    int iResult =(int) Ma.get("rulest");
		return iResult;
	}
	/**
	 * 提交企业会员其他认证
	 * TODO
	 * 创建日期：2016-5-11下午3:30:56
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
    @RequestMapping(value ="/submitCompanyOthers", method = RequestMethod.POST)
	@ResponseBody
	public int submitCompanyOthers(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberID = IntegerAndString.StringToLong(request.getParameter("memberID"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		String endDate = request.getParameter("sEndDate");
		if(endDate!=null && !endDate.equals("")){
			endDate +=" 11:59:59";
		}else{
			endDate = null;
		}
		map.put("certificationID", attestId);
		map.put("memberID", memberID);
		map.put("memberType", 1);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		IdGeneratorUtil idGeneratorUtil = new IdGeneratorUtil();
		map.put("creditIntegralID", idGeneratorUtil.GetId());
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)request.getSession().getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
			map.put("adminID", userInfo.getId());
		}
		entity.setlOptId(10201);
		entity.setlModuleId(102);
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
	    Map<String, Object> Ma=  certificationAuditService.handleAttest(map, entity, sIpInfo);
	    int iResult =(int) Ma.get("rulest");
		return iResult;
	}   
}

