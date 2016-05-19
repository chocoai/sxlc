package cn.springmvc.controller.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.ActivitiesProjectEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.service.ActivitiesProjectService;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 配置中心
 * 项目审批流程配置
 * 审批活动点
 * @date:2016-4-27 上午9:53:45
 **/


@Controller
@RequestMapping("/activity")
public class ActivitiesProjectController {
	
	@Autowired
	private  ActivitiesProjectService activitiesProjectService;
	
	/**
	 * 查询审批活动点
	 * TODO
	 * 创建日期：2016-5-13下午2:31:00
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getactivityList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getactivityList(HttpServletRequest request){
		
		int statu = IntegerAndString.StringToInt(request.getParameter("content"),0);
		String autu =request.getParameter("auth");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statu", statu);
		map.put("apName", autu);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setMap(map);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		activitiesProjectService.selectActivitiesProjectListpage(pageEntity);
		return pageEntity;
	}
	
	/**
	 * 保存审批活动点
	 * TODO
	 * 创建日期：2016-5-13下午2:39:53
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveActivity")
	@ResponseBody
	public int saveActivity(HttpServletRequest request){
		IdGeneratorUtil idGeneratorUtil = new IdGeneratorUtil();
		long id =idGeneratorUtil.GetId();
		int roleType = IntegerAndString.StringToInt(request.getParameter("roleType"),0);
		String apName = request.getParameter("apName"); //审批活动点
		
		ActivitiesProjectEntity activityentity  = new ActivitiesProjectEntity();
		activityentity.setId(id);
		activityentity.setRoleType(roleType);
		activityentity.setApName(apName);
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
		entity.setlModuleId(608);
		entity.setlOptId(60801);
		int iResult = activitiesProjectService.insertActivitiesProject(activityentity, entity,sIpInfo);
		return  iResult;
	}
	/**
	 * 修改审批活动点
	 * TODO
	 * 创建日期：2016-5-13下午4:33:03
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/updateActivity")
	@ResponseBody
	public int updateActivity(HttpServletRequest request){
		long id = IntegerAndString.StringToLong(request.getParameter("id"), 0);
		int roleType = IntegerAndString.StringToInt(request.getParameter("roleType"),0);
		String apName = request.getParameter("apName"); //审批活动点
		
		ActivitiesProjectEntity activityentity  = new ActivitiesProjectEntity();
		activityentity.setId(id);
		activityentity.setRoleType(roleType);
		activityentity.setApName(apName);
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
		entity.setlModuleId(608);
		entity.setlOptId(60802);
		int iResult = activitiesProjectService.updateActivitiesProjectByID(activityentity, entity, sIpInfo);
		return  iResult;
	}
		
	/**
	 * 停用启用审批活动点
	 * TODO
	 * 创建日期：2016-5-13下午4:34:08
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/ofActivity")
	@ResponseBody
	public int ofActivity(HttpServletRequest request){
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"),0);
		long id = IntegerAndString.StringToLong(request.getParameter("id"), 0);
		ActivitiesProjectEntity activityentity  = new ActivitiesProjectEntity();
		activityentity.setId(id);
		activityentity.setStatu(statu);
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
		entity.setlModuleId(608);
		entity.setlOptId(60803);
		int iResult = activitiesProjectService.updateActivitiesProjectStatuByID(activityentity, entity, sIpInfo);
		return  iResult;
	}	
	
}
