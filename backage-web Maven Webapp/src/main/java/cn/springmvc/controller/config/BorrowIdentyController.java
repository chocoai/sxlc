package cn.springmvc.controller.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.service.MemberAttestTypeService;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 配置中心
 * 借款认证配置
 * @date:2016-4-27 上午10:43:44
 **/

@Controller
@RequestMapping("/identyConfig")
public class BorrowIdentyController {
	
	@Resource(name="memberAttestTypeServiceImpl")
	private  MemberAttestTypeService memberAttestTypeService;
	
	
	/**
	 * 借款认证配置列表
	 * TODO
	 * 创建日期：2016-4-27上午10:46:06
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getIdentyList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getIdentyList(HttpServletRequest request){
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		String identyName =  request.getParameter("identyName");
		int iStatu = IntegerAndString.StringToInt(request.getParameter("iStatu"), -1);
		int memberType = IntegerAndString.StringToInt(request.getParameter("membertype1"), -1);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("attestTypeName",identyName);
		param.put("statu",iStatu);
		param.put("memberType",memberType);
		pageEntity.setMap(param);
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		memberAttestTypeService.selectMemberAttestTypeListpage(pageEntity);
		return pageEntity;
	}
	
	
	/**
	 * 保存借款认证配置
	 * TODO
	 * 创建日期：2016-4-27上午10:46:31
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveIdenty")
	@ResponseBody
	public int saveMemberIdenty(HttpServletRequest request){
		MemberAttestTypeEntity memberAttestTypeEntity = new MemberAttestTypeEntity();
		int memberType = IntegerAndString.StringToInt(request.getParameter("memberType"),0);
		String centifyName =request.getParameter("centifyName");
		int score = IntegerAndString.StringToInt(request.getParameter("score"),0);
		int attachType = IntegerAndString.StringToInt(request.getParameter("attachType"),0);
		memberAttestTypeEntity.setAttestTypeName(centifyName);
		memberAttestTypeEntity.setStatu(1);
		memberAttestTypeEntity.setTypeCure(0);
		memberAttestTypeEntity.setMemberType(memberType);
		memberAttestTypeEntity.setCreditScore(score);
		memberAttestTypeEntity.setNeedCheck(0);
		memberAttestTypeEntity.setAttachType(attachType);
		InsertAdminLogEntity  entity = new InsertAdminLogEntity(); //以后加
		HttpSession session = request.getSession();
	    Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin !=null && admin.getId()>0){
			entity.setiAdminId(admin.getId());
			memberAttestTypeEntity.setOptId(1L);
		}
		String[] sIpInfo = new String[6];
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac("");
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		entity.setlModuleId(612);
		entity.setlOptId(61201);
		int iResult = memberAttestTypeService.insertMemberAttestType(memberAttestTypeEntity,entity, sIpInfo);
		return  iResult;
	}
	
	/**
	 * 修改借款认证配置
	 * TODO
	 * 创建日期：2016-4-27上午11:24:27
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/updateMemberIdenty")
	@ResponseBody
	public int updateMemberIdenty(HttpServletRequest request){
		
		int id =IntegerAndString.StringToInt(request.getParameter("id"),0);
		MemberAttestTypeEntity memberAttestTypeEntity = new MemberAttestTypeEntity();
		int memberType = IntegerAndString.StringToInt(request.getParameter("memberType"),0);
		String centifyName =request.getParameter("centifyName");
		int score = IntegerAndString.StringToInt(request.getParameter("score"),0);
		int attachType = IntegerAndString.StringToInt(request.getParameter("attachType"),0);
		memberAttestTypeEntity.setAttestTypeName(centifyName);
		memberAttestTypeEntity.setStatu(1);
		memberAttestTypeEntity.setAttestTypeID(id);
		memberAttestTypeEntity.setTypeCure(0);
		memberAttestTypeEntity.setMemberType(memberType);
		memberAttestTypeEntity.setCreditScore(score);
		memberAttestTypeEntity.setNeedCheck(0);
		memberAttestTypeEntity.setAttachType(attachType);
		InsertAdminLogEntity  entity = new InsertAdminLogEntity(); //以后加
		HttpSession session = request.getSession();
	    Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin !=null && admin.getId()>0){
			entity.setiAdminId(admin.getId());
		}
		String[] sIpInfo = new String[6];
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac("");
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		entity.setlModuleId(612);
		entity.setlOptId(61202);
		int iResult = memberAttestTypeService.updateMemberAttestTypeByID(memberAttestTypeEntity,entity, sIpInfo);
		return  iResult;
	}
	/**
	 * 停用启用协议
	 * TODO
	 * 创建日期：2016-4-27上午10:03:15
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/changeIdentyStatu")
	@ResponseBody
	public int changeIdentyStatu(HttpServletRequest request){
		
		int id = IntegerAndString.StringToInt(request.getParameter("id"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"),0);
		MemberAttestTypeEntity memberAttestTypeEntity = new MemberAttestTypeEntity();
		memberAttestTypeEntity.setAttestTypeID(id);
		memberAttestTypeEntity.setStatu(statu);
		InsertAdminLogEntity  entity = new InsertAdminLogEntity(); //以后加
		HttpSession session = request.getSession();
	    Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin !=null && admin.getId()>0){
			entity.setiAdminId(admin.getId());
		}
		String[] sIpInfo = new String[6];
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac("");
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		entity.setlModuleId(612);
		entity.setlOptId(61203);
		int iResult = memberAttestTypeService.updateMemberAttestTypeStatuByID(memberAttestTypeEntity, entity, sIpInfo);
		return  iResult;
	}	
}
