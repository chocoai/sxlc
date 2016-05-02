package cn.springmvc.controller.organizationmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.Util.HttpSessionUtil;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;
import cn.springmvc.model.RoleAuth;
import cn.springmvc.model.RoleInfo;
import cn.springmvc.service.IRoleInfoServer;


/**
 * @author pengran
 * 组织机构
 * 角色控制层 
 * @date:2016-3-31 下午19:24:15
 **/

@Controller
public class RoleController {
	//角色 
	@Resource(name="roleInfoServerImpl")
	private  IRoleInfoServer roleInfoServer;
	
	/**
	 * TODO 模块  与 操作
	 * 创建日期：2016-3-31下午7:30:22
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return void
	 */
	@RequestMapping(value ="/getModuleAndOperation", method = RequestMethod.GET)
	public String getModuleAndOperation(HttpServletRequest request,String deptNo,Model model){
		List<Module> moduleList = roleInfoServer.getModuleList();	//模块权限
		List<Module> moduleThree = roleInfoServer.getModuleListThree();	//第三级模块权限
		List<Operation> operationList = roleInfoServer.getOperationList(); //操作权限
		request.setAttribute("modulelist", moduleList);
		request.setAttribute("moduleThree", moduleThree);
		request.setAttribute("operationList",operationList );
		//return new ModelAndView("web/role/role.jsp");
		return "role/role";
	}

	
	/**
	 * TODO 角色列表
	 * 创建日期：2016-3-31下午7:30:22
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return pageEntity
	 */
	@RequestMapping(value ="/getRoleList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity showRoleList(HttpServletRequest request,String deptNo,Model model){
		String roleNo = request.getParameter("roleNo");
		String roleName = request.getParameter("roleName");
		String startTime = request.getParameter("startTime");
		String endTime =request.getParameter("endTime");
		Map<String ,Object> param = new HashMap<String, Object>();
		if(roleNo!=null && !roleNo.equals("")){
			param.put("roleNo", roleNo);
		}
		if(roleName!=null && !roleName.equals("")){
			param.put("roleName", roleName);
		}
		if(startTime!=null && !startTime.equals("")){
			param.put("startTime", startTime);
		}
		if(endTime!=null && !endTime.equals("")){
			param.put("endTime", endTime);
		}
		
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		/*pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);*/
		 roleInfoServer.getListByParam(param,pageEntity);
		return pageEntity;
	}
	
	/**
	 * TODO 添加角色
	 * 创建日期：2016-3-31下午7:58:41
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return void
	 */
	@RequestMapping(value ="/saveRole", method = RequestMethod.POST)
	@ResponseBody
	public int  saveRole(HttpServletRequest request,Model model){
		String roleName = request.getParameter("roleName");
		String rolediscribe= request.getParameter("rolediscribe");
		
		RoleInfo info = new RoleInfo();
		IdGeneratorUtil generatorUtil = new IdGeneratorUtil();
		long id = generatorUtil.GetId();
		info.setId(id);
		info.setRoleName(roleName);
		info.setRoleNo(id+"");
		info.setRoleStatu(0);
		info.setRoleRemark(rolediscribe);
		String auths =request.getParameter("auth");
		
		
		String [] sIpInfo = new String[5];
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null && userInfo.getId()>0) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(105);
		entity.setlModuleId(10501);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int result = roleInfoServer.saveRole(info, auths,entity,sIpInfo);
		return result;
	}
	/**
	 * TODO 修改角色
	 * 创建日期：2016-3-31下午7:58:41
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return void
	*/
	 @RequestMapping(value ="/editRole", method = RequestMethod.POST)
	 @ResponseBody
	public int  editRole(HttpServletRequest request,String deptNo,Model model){
		String roleName = request.getParameter("roleName");
		String rolediscribe = request.getParameter("rolediscribe");
		RoleInfo info = new RoleInfo();
		long id =IntegerAndString.StringToLong(request.getParameter("roleId"),0);
		info.setId(id);
		info.setRoleName(roleName);
		info.setRoleRemark(rolediscribe);
		info.setRoleStatu(0);
		String auths =request.getParameter("auth");
		
		String [] sIpInfo = new String[5];
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(105);
		entity.setlModuleId(10502);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int result = roleInfoServer.editRole(info,auths,entity,sIpInfo);
		return result;
	}	
	
	/**
	 * TODO 移除角色
	 * 创建日期：2016-3-31下午8:39:10
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return void
	 */
	@RequestMapping(value ="/removeRole", method = RequestMethod.POST)
	@ResponseBody
	public int   removeRole(HttpServletRequest request,Model model){
		long id =IntegerAndString.StringToLong(request.getParameter("roleId"),0);
		RoleInfo info = new RoleInfo();
		info.setId(id);
		
		String [] sIpInfo = new String[5];
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(105);
		entity.setlModuleId(10503);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int result = roleInfoServer.remove(info,entity, sIpInfo);
		return result;
	}	
	/**
	 * 停用启用角色信息
	 * 创建日期：2016-3-31下午8:42:34
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/ofRole", method = RequestMethod.POST)
	@ResponseBody
	public int ofRole(HttpServletRequest request){
		long id =IntegerAndString.StringToLong(request.getParameter("roleId"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), 0);
		RoleInfo info = new RoleInfo();
		info.setId(id);
		info.setRoleStatu(statu);
		
		String [] sIpInfo = new String[5];
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(105);
		entity.setlModuleId(10504);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int result = roleInfoServer.ofRole(info,entity,sIpInfo);
		return result;
	}

	/**
	 * TODO  获取角色权限
	 * 创建日期：2016-4-5下午4:30:45
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return map
	 */
	@RequestMapping(value ="/getLimitById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getLimitById(HttpServletRequest request){
		long roleId =IntegerAndString.StringToLong(request.getParameter("roleId"),0);
		Map<String, Object> map = new HashMap<String, Object> ();
		List<Module> modulelist = roleInfoServer.getModuleListByID(roleId);
		List<Operation> operationList = roleInfoServer.getOperationListByID(roleId); 
		map.put("modulelist", modulelist);
		map.put("operationList", operationList);
		return map;
	}
	
	/**
	 * TODO 获取角色信息
	 * 创建日期：2016-4-5下午5:13:57
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return Map<String,Object>
	 */
	@RequestMapping(value ="/getRoleMess", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getRoleMess(HttpServletRequest request){
		long roleId =IntegerAndString.StringToLong(request.getParameter("roleId"),0);
		Map<String, Object> map = new HashMap<String, Object> ();
		List<RoleInfo> roleInfo = roleInfoServer.getRoleInfoById(roleId);
		List<RoleAuth> roleAuth = roleInfoServer.getRoleAuthById(roleId);
		map.put("roleInfo", roleInfo);
		map.put("roleAuth", roleAuth);
		return map;
	}
}
