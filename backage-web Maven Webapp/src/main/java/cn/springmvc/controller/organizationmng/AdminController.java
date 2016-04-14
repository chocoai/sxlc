package cn.springmvc.controller.organizationmng;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.RSA.RSAPlugn;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;
import cn.springmvc.model.RoleInfo;
import cn.springmvc.service.IAdminLoginService;
import cn.springmvc.service.IAdminService;
import cn.springmvc.service.IRoleInfoServer;


/**
 * @author pengran
 * 组织机构
 * 管理员控制层 
 * @date:2016-3-29 下午8:24:15
 **/

@Controller
public class AdminController {
	
	//登录
	@Resource(name="adminLoginServerImpl")
	private  IAdminLoginService adminLoginService;
	
	//角色 模块和操作
	@Resource(name="roleInfoServerImpl")
	private  IRoleInfoServer roleInfoServer;

	//管理员
	@Resource(name="adminServiceImpl")
	private  IAdminService adminService;
	
	/**
	 * TODO 登录  
	 * 创建日期：2016-3-30上午10:12:01
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	@ResponseBody
	public int  adminLogin(HttpServletRequest request,HttpServletResponse response){
		String adminName = request.getParameter("adminName"); 
		String adminPwd = request.getParameter("adminPwd");
		String vCode = request.getParameter("code");//输入验证码
		HttpSession session = request.getSession();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("adminName", adminName);
		param.put("adminPwd", adminPwd);
		int iResult = adminLoginService.adminLogin(param);
		//登录成功
		Admin admin = new Admin();
		String cookieName="UserName"; 
		String cUserName =null;
		try {
			cUserName = URLEncoder.encode(adminName,"utf-8");
			Cookie cookie=new Cookie(cookieName, cUserName); 
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie); 
			List<Module> moduleList = new ArrayList<Module>();
			List<Operation> operationList = new ArrayList<Operation>();
			if(iResult ==0 ){
				//登录人信息
				
				admin = adminLoginService.adminMess(param);
				KeyPair keyPair = RSAPlugn.GetKeyPair();
				PublicKey publicK = keyPair.getPublic();
				PrivateKey privatek =   keyPair.getPrivate();
				String publicKey=new  String(Base64.encodeBase64((publicK.getEncoded())));
				String privatekey=new  String(Base64.encodeBase64((privatek.getEncoded())));
				session.setAttribute("publicKey", publicKey);
				session.setAttribute("privatekey", privatekey);
				
				 moduleList = roleInfoServer.getModuleList();	//模块权限
				 operationList = roleInfoServer.getOperationList(); //操作权限
			}
			//设置session
			//session.setAttribute("", );
			//map.put("result", iResult);
			session.setAttribute("LoginPerson", admin);
			session.setAttribute("modulelist", moduleList);
			session.setAttribute("operationList",operationList );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("登录:"+e.getLocalizedMessage());
		}
		return iResult;
	}

	
	/**
	 * 保存admin
	 * 创建日期：2016-4-8下午3:10:05
	 * 修改日期：
	 * 作者：pengran
	 * @param adminName adminPwd adminRole
	 * return int
	 */
	@RequestMapping("/saveOrEditAdmin")
	@ResponseBody
	public int saveAdmin(HttpServletRequest request,String adminName,String adminPwd,String adminRole,String adminRemark,String staffId){
		
		Admin admin = new Admin();
		admin.setAdminName(adminName);
		admin.setAdminPwd(adminPwd);
		admin.setAdminRemark(adminRemark);
		admin.setStaffType(0);
		admin.setAdminCure(0);
		long staff_Id = IntegerAndString.StringToLong(staffId, 0);
		admin.setStaffId(staff_Id);
		admin.setAdminStatu(1);
		int addOrUpdate = IntegerAndString.StringToInt(request.getParameter("type"), 0);
		int iResult = 0;
		long roleId = IntegerAndString.StringToLong(adminRole, 0);
		if(addOrUpdate ==0 ){ //添加
			iResult = adminService.saveAdmin(admin, roleId);
		}else{//修改
			long adminId= IntegerAndString.StringToLong(request.getParameter("adminId"), 0);
			admin.setId(adminId);
			iResult = adminService.editAdmin(admin, roleId);
		}
		return  iResult;
	}
	
	/**
	 * TODO 角色列表
	 * 创建日期：2016-3-31下午7:30:22
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return pageEntity
	 */
	@RequestMapping(value ="/getRoleListToReq", method = RequestMethod.GET)
	public String showRoleList(HttpServletRequest request){
		List<RoleInfo>  list  = roleInfoServer.getRoleList();
		request.setAttribute("roleList", list);
		//return new ModelAndView("web/role/role.jsp");
		return "role/role-manage-in";
	}
	
	
	/**
	 * TODO 获取管理员列表
	 * 创建日期：2016-4-7下午3:44:00
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/getAdminList", method = RequestMethod.GET)
	@ResponseBody
	public PageEntity getAdminList(String adminName,String userName,String startTime,String endTime,HttpServletRequest request){
		Map<String ,Object> param = new HashMap<String, Object>();
		if(adminName!=null && adminName!=""){
			param.put("adminName", adminName);
		}
		if(userName!=null&& userName!=""){
			param.put("userName", userName);
		}
		if(startTime!=null && startTime!=""){
			param.put("startTime", startTime);
		}
		if(endTime!=null && endTime!=""){
			param.put("endTime", endTime);
		}
		String sKey = DbKeyUtil.GetDbCodeKey();
		param.put("sKey", sKey);
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		PageEntity pageEntity = new PageEntity();
		pageEntity.setMap(param);
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		adminService.adminsByParam(pageEntity);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		return pageEntity;
	}
	
	/**
	 * TODO 停用启用管理员
	 * 创建日期：2016-4-7下午7:32:43
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/ofAdmin", method = RequestMethod.POST)
	@ResponseBody
	public int ofRole(HttpServletRequest request){
		long id =IntegerAndString.StringToLong(request.getParameter("adminId"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"), 0);
		int result = adminService.ofAdmin(id, statu);
		return result;
	}
}
