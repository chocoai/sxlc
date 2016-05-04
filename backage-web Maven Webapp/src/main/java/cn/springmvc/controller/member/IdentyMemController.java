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
import cn.membermng.model.MemberAttestTypeEntity;
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
		map.put("certificationID", attestId);
		map.put("memberId", memberId);
		map.put("memberType", 0);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", null);
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
	    int iResult =(int) Ma.get("result");
		return iResult;
	}
	/*************************实名认证end*************************************************************/
	/*************************现场认证start*************************************************************/		
	/**
	 * 个人会员现场认证详情
	 * TODO
	 * 创建日期：2016-5-3下午4:04:57
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * 
	 */
	@RequestMapping(value ="/spotIdenty", method = RequestMethod.POST)
	@ResponseBody
	public RealNameAuth spotIdenty(HttpServletRequest req){
		long   memberId = IntegerAndString.StringToLong(req.getParameter("content"), 1);
		RealNameAuth realNameAuth =  borrowingCertificationServer.showAuthRealName(memberId);
		return realNameAuth;
	}
	/**
	 * 提交现场认证
	 * TODO
	 * 创建日期：2016-5-3下午6:57:08
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/submitspot", method = RequestMethod.POST)
	@ResponseBody
	public int submitSpot(HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		long attestId = IntegerAndString.StringToLong(request.getParameter("attestId"), 0);
		long memberId = IntegerAndString.StringToLong(request.getParameter("memberId"), 0);
		int  statusT = IntegerAndString.StringToInt(request.getParameter("statu"), 2);
		map.put("certificationID", attestId);
		map.put("memberId", memberId);
		map.put("memberType", 0);
		map.put("statusT", statusT);
		map.put("remark", "");
		map.put("endDate", "");
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
	    int iResult =(int) Ma.get("result");
		return iResult;
	}
	/*************************实名认证end*************************************************************/
	
/*************************会员认证操作 end *************************************************************/		
}

