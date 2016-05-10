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
import cn.membermng.model.CurrencyAuth;
import cn.membermng.model.RealNameAuth;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.service.CertificationAuditService;
import cn.springmvc.service.IBorrowingCertificationServer;
import cn.springmvc.util.LoadUrlUtil;

/**
 * @author pengran
 *  会员认证
 * @date:2016-5-2 下午2:36:49
 **/
@Controller
@RequestMapping("/memberidety")
public class IdentyMemController {
	
	@Autowired
	private CertificationAuditService certificationAuditService;
	
	@Autowired
	private IBorrowingCertificationServer borrowingCertificationServer;
	/**
	 * 
	 * TODO
	 * 创建日期：2016-5-2下午4:43:40
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return MemberAttestTypeEntity
	 */
	@RequestMapping(value ="/getIdentyTypeList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getIdentyTypeList(HttpServletRequest req){
		//查询条件
		Map<String,Object> map = new HashMap<String, Object>();
		int memberType = IntegerAndString.StringToInt(req.getParameter("content"),0);
		map.put("memberType", memberType);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		PageEntity pager = new PageEntity();
		pager.setPageNum(1);
		pager.setPageSize(50);
		pager.setMap(map);
		certificationAuditService.selectAllMemberAttestType(pager);
		return pager;
	}	
	
/*************************查询会员认证列表 start*************************************************************/	
	
	
	/**
	 * 根据认证类型id 查询认证列表
	 * TODO
	 * 创建日期：2016-5-2下午4:48:01
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getIdetyListByType", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getMemberIdetyListByType(HttpServletRequest req){
		//查询条件
		int   attestTypeID = IntegerAndString.StringToInt(req.getParameter("attestTypeID"), 1);
		String realName = req.getParameter("memberName");
		String userName = req.getParameter("userName");
		String idcard = req.getParameter("idcard");
		int status  = IntegerAndString.StringToInt( req.getParameter("statu"), 1);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("realName", realName);
		map.put("logname", userName);
		map.put("idcard", idcard);
		map.put("attestTypeID", attestTypeID);
		map.put("memberType", 0);
		map.put("status", status);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		
		String xmlSql=""; //认证  配置   认证sql
		if(attestTypeID==1){ //实名认证  配置   认证sql
			xmlSql="EnterpriseCAXML.realNameAuthentication";
		}else if(attestTypeID==4){//住址认证
			xmlSql="EnterpriseCAXML.AddressAuthentication";
		}else if(attestTypeID==7){//房产
			xmlSql="EnterpriseCAXML.selectMemberAttestByType";
		}else if(attestTypeID==8){//车产
			xmlSql="EnterpriseCAXML.selectMemberAttestByType";
		}else if(attestTypeID==10){//婚姻认证
			xmlSql="EnterpriseCAXML.marriageCertification";
		}else if(attestTypeID==11){//学历认证
			xmlSql="EnterpriseCAXML.EducationCertification";
		}else {//其他认证
			xmlSql="EnterpriseCAXML.selectMemberAttestByType";
		}
		map.put("xmlSql", xmlSql);
		pager.setMap(map);
		certificationAuditService.selectMemberAttestByType(pager);
		return pager;
	}
	
	/*************************实名认证start*************************************************************/		
	/**
	 * 个人会员实名认证详情
	 * TODO
	 * 创建日期：2016-5-3下午4:04:57
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * 
	 */
	@RequestMapping(value ="/realNameIdenty", method = RequestMethod.POST)
	@ResponseBody
	public RealNameAuth RealNameIdenty(HttpServletRequest req){
		long   memberId = IntegerAndString.StringToLong(req.getParameter("content"), 1);
		RealNameAuth realNameAuth =  borrowingCertificationServer.showAuthRealName(memberId);
		return realNameAuth;
	}
	/**
	 * 提交实名认证
	 * TODO
	 * 创建日期：2016-5-3下午6:57:08
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/submitRealName", method = RequestMethod.POST)
	@ResponseBody
	public int submitRealName(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		String endDate = request.getParameter("sEndDate");
		if(endDate!=null && !endDate.equals("")){
			endDate +=" 11:59:59";
		}
		map.put("certificationID", attestId);
		map.put("memberID", memberId);
		map.put("memberType", 0);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("personalID", memberId);
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
	    Map<String, Object> Ma=  certificationAuditService.handlenameAuthentication(map, entity, sIpInfo);
	    int iResult =(int) Ma.get("rulest");
		return iResult;
	}
	/*************************实名认证end*************************************************************/
	/*************************公用认证 （现场认证，征信认证，职称认证，社保认证，银行流水认证 等）start*************************************************************/		
	/**
	 * 公用认证 详情
	 * TODO
	 * 创建日期：2016-5-4下午2:06:20
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	@RequestMapping(value ="/conmonIdenty", method = RequestMethod.POST)
	@ResponseBody
	public CurrencyAuth conmonIdenty(HttpServletRequest req){
		long   memberId = IntegerAndString.StringToLong(req.getParameter("memberId"), 0);
		int typeId = IntegerAndString.StringToInt(req.getParameter("typeId"), 1);
		CurrencyAuth auth=  borrowingCertificationServer.showCurrencyAuth(memberId, 0, typeId);
		return auth;
	}
	/**
	 * 提交公共认证
	 * TODO
	 * 创建日期：2016-5-4下午2:06:27
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/submitCommonIdty", method = RequestMethod.POST)
	@ResponseBody
	public int submitCommonIdty(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		String endDate = request.getParameter("sEndDate");
		if(endDate!=null && !endDate.equals("")){
			endDate +=" 11:59:59";
		}else{
			endDate =null;
		}
		map.put("certificationID", attestId);
		map.put("memberId", memberId);
		map.put("memberType", 0);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("personalID", memberId);
		
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
	/*************************公共认证end*************************************************************/
	/*************************住址认证 start*************************************************************/		
	/**
	 * 住址认证 详情
	 * TODO
	 * 创建日期：2016-5-4下午3:05:00
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	@RequestMapping(value ="/addressIdenty", method = RequestMethod.POST)
	@ResponseBody
	public CurrencyAuth addressIdenty(HttpServletRequest req){
		long   memberId = IntegerAndString.StringToLong(req.getParameter("rid"), 0);
		CurrencyAuth auth=  borrowingCertificationServer.showAuthAddress(memberId);
		return auth;
	}
	/**
	 * 提交住址认证 
	 * TODO
	 * 创建日期：2016-5-4下午3:05:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/submitAddress", method = RequestMethod.POST)
	@ResponseBody
	public int submitAddressIdty(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		String endDate = request.getParameter("sEndDate");
		if(endDate!=null && !endDate.equals("")){
			endDate +=" 11:59:59";
		}else{
			endDate=null;
		}
		map.put("certificationID", attestId);
		map.put("memberId", memberId);
		map.put("memberType", 0);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("personalID", 0);
		
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
	    Map<String, Object> Ma=  certificationAuditService.handleAddress(map, entity, sIpInfo);
	    int iResult =(int) Ma.get("rulest");
		return iResult;
	}
	/*************************住址认证 end*************************************************************/
	
	/*************************房产认证 start*************************************************************/		
	/**
	 * 房产认证详情
	 * TODO
	 * 创建日期：2016-5-4下午4:00:37
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	@RequestMapping(value ="/houseIdenty", method = RequestMethod.POST)
	@ResponseBody
	public CurrencyAuth houseIdenty(HttpServletRequest req){
		long   rid = IntegerAndString.StringToLong(req.getParameter("rid"), 0);
		CurrencyAuth auth=  borrowingCertificationServer.showAuthHousingOne(rid);
		return auth;
	}
	/*************************房产认证 end*************************************************************/
	
	
	/*************************车产认证 start*************************************************************/		
	/**
	 * 车产认证详情
	 * TODO
	 * 创建日期：2016-5-4下午4:07:16
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	@RequestMapping(value ="/carIdenty", method = RequestMethod.POST)
	@ResponseBody
	public CurrencyAuth carIdenty(HttpServletRequest req){
		long   rid = IntegerAndString.StringToLong(req.getParameter("rid"), 0);
		CurrencyAuth auth=  borrowingCertificationServer.showAuthProductionOne(rid);
		return auth;
	}
	/*************************车产认证 end*************************************************************/

	/*************************婚姻认证 start*************************************************************/		
	/**
	 * 婚姻认证详情
	 * TODO
	 * 创建日期：2016-5-4下午8:33:39
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	@RequestMapping(value ="/marryIdenty", method = RequestMethod.POST)
	@ResponseBody
	public CurrencyAuth marryIdenty(HttpServletRequest req){
		long   memberId = IntegerAndString.StringToLong(req.getParameter("memberId"), 0);
		
		CurrencyAuth auth=  borrowingCertificationServer.showAuthMarriage(memberId);
		return auth;
	}
	/**
	 * 提交婚姻认证 
	 * TODO
	 * 创建日期：2016-5-5上午11:44:58
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/submitMarry", method = RequestMethod.POST)
	@ResponseBody
	public int submitMarry(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		String endDate = request.getParameter("sEndDate");
		if(endDate!=null && !endDate.equals("")){
			endDate +=" 11:59:59";
		}else{
			endDate=null;
		}
		map.put("certificationID", attestId);
		map.put("memberId", memberId);
		map.put("memberType", 0);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("personalID",memberId);
		
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
	    Map<String, Object> Ma=  certificationAuditService.handlemarriage(map, entity, sIpInfo);
	    int iResult =(int) Ma.get("rulest");
		return iResult;
	}
	/*************************婚姻认证 end*************************************************************/

	
	/*************************学历认证 start*************************************************************/		
	/**
	 * 学历认证详情
	 * TODO
	 * 创建日期：2016-5-4下午8:33:39
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return CurrencyAuth
	 */
	@RequestMapping(value ="/graduateIdenty", method = RequestMethod.POST)
	@ResponseBody
	public CurrencyAuth graduateIdenty(HttpServletRequest req){
		long   memberId = IntegerAndString.StringToLong(req.getParameter("memberId"), 0);
		CurrencyAuth auth=  borrowingCertificationServer.showAuthEducation(memberId);
		return auth;
	}
	/**
	 * 提交学历认证 
	 * TODO
	 * 创建日期：2016-5-5上午11:46:12
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/submitEducation", method = RequestMethod.POST)
	@ResponseBody
	public int submitEducation(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		String endDate = request.getParameter("sEndDate");
		if(endDate!=null && !endDate.equals("")){
			endDate +=" 11:59:59";
		}else{
			endDate=null;
		}
		map.put("certificationID", attestId);
		map.put("memberId", memberId);
		map.put("memberType", 0);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", endDate);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		map.put("personalID", memberId);
		
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
	    Map<String, Object> Ma=  certificationAuditService.handlemarriage(map, entity, sIpInfo);
	    int iResult =(int) Ma.get("rulest");
		return iResult;
	}
	/*************************学历认证 end*************************************************************/
		/**
/*************************会员认证操作 end *************************************************************/		
}

