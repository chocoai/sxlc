package cn.springmvc.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import cn.springmvc.dao.impl.sms.SendSmsUtil;
import cn.springmvc.service.IMemberManangerService;


/**
 * @author pengran
 * 
 *  忘记密码
 * @date:2016-5-12 下午1:45:35
 **/

@Controller
public class FogetPasswordController {
	private Logger logger = Logger.getLogger(FogetPasswordController.class);
		
	//忘记密码
	@Autowired
	private IMemberManangerService memberManangerService;
	
	
	@Autowired
	private SendSmsUtil sendSmsUtil;
	
	/**
	 * 发送验证码
	 * TODO
	 * 创建日期：2016-5-12下午1:56:08
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/sendIdentyMess", method = RequestMethod.POST)
	@ResponseBody
	public int sendIdentyMess(HttpServletRequest request){
		
		String phone =request.getParameter("adminPhone");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		
		int iResult = memberManangerService.getAdminIdByPhone(map);
		if(iResult>0){ //管理员id
			String code = StringUtils.varCode(); //验证码
			System.out.println("验证码：=========== "+code);
			map.put("code", code);
			sendSmsUtil.SendSms(map,0,0,null);
			request.getSession().setAttribute("IdentyCoDe", code);
		}
		return iResult;
	}
	
	/**
	 * 判断验证码对错并修改
	 * TODO
	 * 创建日期：2016-5-12下午2:48:36
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return int
	 */
	@RequestMapping(value ="/IdentyMess", method = RequestMethod.POST)
	@ResponseBody
	public int IdentyMess(HttpServletRequest request){
		
		String code =request.getParameter("identyCode");
		long  adminId = IntegerAndString.StringToLong(request.getParameter("adminId"),0);
		String newpwd = request.getParameter("newpwd");
		HttpSession session = request.getSession();
		String identCode = (String)session.getAttribute("IdentyCoDe");
		int iResult = -1;
		if(identCode == null || identCode.equals("")){
			iResult = -2 ;//验证码已失效
		}
		if(identCode!= null && code.equals(identCode)){
			  Map<String,Object> map = new HashMap<String, Object>();
			  map.put("adminId", adminId);
			  map.put("newpwd", newpwd);
			 iResult = memberManangerService.getAdminIdByPhone(map);
		}
		return iResult;
	}	
	
}
