package cn.springmvc.controller.organizationmng;

import java.io.PrintWriter;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.RSA.RSAPlugn;
import cn.springmvc.model.Admin;
import cn.springmvc.model.Module;
import cn.springmvc.model.Operation;
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
	public int  adminLogin(HttpServletRequest request){
		String adminName = request.getParameter("adminName"); 
		String adminPwd = request.getParameter("adminPwd");
		HttpSession session = request.getSession();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("adminName", adminName);
		param.put("adminPwd", adminPwd);
		int iResult = adminLoginService.adminLogin(param);
		//登录成功
		Admin admin = new Admin();
		
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
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("result", iResult);
		session.setAttribute("LoginPerson", admin);
		session.setAttribute("modulelist", moduleList);
		session.setAttribute("operationList",operationList );
		return iResult;
	}

	
	/**
	 * 保存admin
	 * 创建日期：2016-3-29下午8:33:28
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping("/saveAdmin")
	@ResponseBody
	public int saveAdmin(String roles){
		Admin admin = new Admin();
		
		int result = adminService.saveAdmin(admin, roles);
		return 0;
	}
}
