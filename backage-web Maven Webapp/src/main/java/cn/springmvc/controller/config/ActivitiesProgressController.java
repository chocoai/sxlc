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
import cn.springmvc.model.Admin;
import cn.springmvc.model.ProcessProjectEntity;
import cn.springmvc.service.ProcessProjectService;
import cn.springmvc.util.LoadUrlUtil;


/**
 * @author pengran
 * 配置中心
 * 项目审批流程配置
 *  2 项目审批流程配置
 * @date:2016-4-27 上午9:53:45
 **/


@Controller
@RequestMapping("/activityprocess")
public class ActivitiesProgressController {
	
	@Autowired
	private  ProcessProjectService processProjectService;
	
	/**
	 * 查询审批流程
	 * TODO
	 * 创建日期：2016-5-13下午4:57:45
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return PageEntity
	 */
	@RequestMapping(value ="/getProcessList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getProcessList(HttpServletRequest request){
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		processProjectService.selectProcessProjectListpage(pageEntity);
		return pageEntity;
	}
	/**
	 * 添加审批活动点
	 * TODO
	 * 创建日期：2016-5-13下午6:34:20
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/addProgress")
	@ResponseBody
	public int addProgress(HttpServletRequest request){
		int apId = IntegerAndString.StringToInt(request.getParameter("apId"),0);
		ProcessProjectEntity entitys = new ProcessProjectEntity();
		entitys.setApID(apId);
		entitys.setBatch(0);
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
		entity.setlOptId(60805);
		int iResult = processProjectService.insertProcessProject(entitys, entity, sIpInfo);
		return  iResult;
	}	
	/**
	 * 上移下移审批活动点
	 * TODO
	 * 创建日期：2016-5-13下午6:31:13
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/upOrDownProgress")
	@ResponseBody
	public int upOrDownProgress(HttpServletRequest request){
		int id = IntegerAndString.StringToInt(request.getParameter("id"),0);
		int flag = IntegerAndString.StringToInt(request.getParameter("statu"),0);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("iid", id);
		map.put("flag", flag);
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
		entity.setlOptId(60806);
		int iResult = processProjectService.moveAndDownProcessProjectByID(map, entity, sIpInfo);
		return  iResult;
	}
	/**
	 * 删除审批活动点
	 * TODO
	 * 创建日期：2016-5-13下午4:33:03
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/deleteProgress")
	@ResponseBody
	public int deleteProgress(HttpServletRequest request){
		int id = IntegerAndString.StringToInt(request.getParameter("id"), 0);
		
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
		entity.setlOptId(60807);
		int iResult = processProjectService.deleteProcessProjectByID(id, entity, sIpInfo);
		return  iResult;
	}
		
	
}
