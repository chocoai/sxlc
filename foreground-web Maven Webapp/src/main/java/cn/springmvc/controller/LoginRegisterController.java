package cn.springmvc.controller; 

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.RSA.RSAPlugn;
import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.constant.Constant;
import product_p2p.kit.redisPlug.Core;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.PersonalBaseInfo;
import cn.springmvc.dao.impl.sms.SendSmsUtil;
import cn.springmvc.service.IMemberService;
import cn.springmvc.service.UpdatePasswordService;

import com.alibaba.fastjson.JSONObject;

/****
* 用户注册、登录控制器
* 
* 
* @author 李杰
* @since 
* @date 2016-4-14 下午2:12:20 
*
*/
@Controller
public class LoginRegisterController {

	private Logger logger = Logger.getLogger(LoginRegisterController.class);
	
	
	@Resource(name="memberInfoServiceImpl")
	private IMemberService memberService;
	
	@Resource
	private SendSmsUtil sendSmsUtil;
	
	/***
	* 引导用户去注册页面
	* @author 李杰
	* @date 2016-4-14 下午2:18:38
	*/
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String toRegPage(){return "loginRegister/register";}
	
	
	/***
	* 用户注册控制器
	* @author 李杰
	* @Title: register
	* @return
	* @date 2016-4-14 下午2:14:06
	 */
	@RequestMapping(value="register",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String register(HttpServletRequest request,String logname,String memberPwd,String confirmPassword,String beinvitateCode,String personalPhone,String checkCoede,String phoneCheckCode,int memberType){
		logger.debug("注册会员:logname(登录名)="+logname+",memberPwd(登录密码)="+memberPwd+",confirmPassword(确认密码)="+confirmPassword+",beinvitateCode(被邀请码)="+beinvitateCode+",personalPhone(手机号)="+personalPhone+",checkCoede(验证码)="+checkCoede+",phoneCheckCode(手机验证码)="+phoneCheckCode+",memberType(会员类型)="+memberType);
		Map<String,Object> param = new HashMap<String,Object>();
		String message = "";
		if(logname == null || logname.trim().length() == 0){
			message = "请输入用户名";
		}else if(!StringUtils.checkCarLogName(logname)){
			message = "用户名由6~16位的数字、字母、或汉字至少包含2种组成";
		}else if(memberPwd == null || memberPwd.trim().length() == 0){
			message = "请输入密码";
		}else if(confirmPassword == null || confirmPassword.trim().length() == 0){
			message = "请输入确认密码";
		}else if(!memberPwd.equals(confirmPassword)){
			message = "两次输入密码不一致";
		}else if(StringUtils.checkInviteCode(beinvitateCode)){
			message = "请输入有效邀请码";
		}else if(personalPhone == null || personalPhone.trim().length() == 0){
			message = "请输入联系电话";
		}else if(!StringUtils.checkPhone(personalPhone)){
			message = "请输入有效联系电话";
		}else if(checkCoede == null || checkCoede.trim().length() == 0){
			message = "请输入验证码";
		}else if(!checkCoede.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())){
			message = "验证码不正确";
		}else if(phoneCheckCode == null || phoneCheckCode.trim().length() == 0){
			message = "请输入短信验证码";
		}else if(phoneCheckCode.equals(Core.getRegisterPhoneCode(phoneCheckCode))){
			message = "短信验证码错误";
		}
		
		if(!message.equals("")){
			param.put("statu",-4);
			param.put("message", message);
			return JSONObject.toJSONString(param);
		}
		
		MemberInfo info = new MemberInfo();
		info.setLogname(logname);
		info.setMemberPwd(memberPwd);
		info.setBeinvitateCode(beinvitateCode);
		info.setMemberType(memberType);
		PersonalBaseInfo baseInfo = new PersonalBaseInfo();
		baseInfo.setPersonalPhone(personalPhone);
		int optionCode = memberService.individualMember(info, baseInfo);
		if(optionCode == -1){
			message = "用户名重复";
		}else if(optionCode == -2){
			message = "电话号码重复";
		}else if(optionCode == -3){
			message = "邀请码无效";
		}
		param.put("statu",optionCode);
		param.put("message", message);
		return JSONObject.toJSONString(param);
	}
	
	
	/***
	 * 检查电话号码是否存在
	 * @return
	 */
	@RequestMapping(value="checkPhone",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkPhone(HttpServletRequest request){
		String phone = request.getParameter("param");
		Map<String,Object> message = new HashMap<String, Object>();
		if(phone == null || phone.trim().length() <= 0){
			message.put("info", "请输入有效电话号码");
			message.put("status", "n");
			return JSONObject.toJSONString(message);
		}
		int result = memberService.chechPhone(phone);
		if(result == 0){
			message.put("status", "y");
			message.put("info", "");
		}else{
			message.put("status", "n");
			message.put("info", "已被使用");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	/*** 
	 * 检查用户名是否存在
	 * @return
	 */
	@RequestMapping(value="checkName",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkName(HttpServletRequest request){
		String param = request.getParameter("param");
		Map<String,Object> message = new HashMap<String, Object>();
		if(param == null || !StringUtils.checkCarLogName(param)){
			message.put("info", "用户名无效");
			message.put("status", "n");
			return JSONObject.toJSONString(message);
		}
		int result = memberService.countName(param);
		if(result == 0){
			message.put("status", "y");
			message.put("info", "");
		}else{
			message.put("status", "n");
			message.put("info", "用户名已被使用");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	/*** 
	 * 检查邀请码是否存在
	 * @return
	 */
	@RequestMapping(value="countInvitateCode")
	@ResponseBody
	public String countInvitateCode(HttpServletRequest request){
		String invitateCode = request.getParameter("param");
		Map<String,Object> message = new HashMap<String, Object>();
		if(invitateCode == null || invitateCode.trim().length() != 12){
			message.put("message", "邀请码无效");
			message.put("statu", 1);
			return JSONObject.toJSONString(message);
		}
		int result = memberService.countInvitateCode(invitateCode);
		if(result == 0){
			message.put("statu", 0);
			message.put("message", "可以使用该邀请码");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	/***
	* 发送登录短信验证码
	* @author 李杰 
	* @Title: sendPhoneVarCode 
	* @param request
	* @param codePhone					目标手机号
	* @return String 返回类型  JSON
	* @date 2016-3-21 上午9:35:01
	* @throws
	 */
	@RequestMapping(value="sendPhoneCode")
	@ResponseBody
	public Object sendPhoneVarCode(HttpServletRequest request,String codePhone){
		Map<String,Object> message = new HashMap<String, Object>();
		if(codePhone == null || StringUtils.checkPhone(codePhone)){
			message.put("statu", "2");
			message.put("message", "请输入有效手机号");
		}
		if(message.keySet().size() > 0){
			return message;
		}
		String code = StringUtils.varCode();
		Core.putVerCodeByPhone(codePhone, code);
		logger.debug("用户登录手机短信验证码发送成功："+codePhone+" : "+code);
		message.put("statu", 1);
		message.put("message", "验证码发送成功，请注意查收");
		return message;
	}
	
	
	/***
	* 发送注册短信验证码
	* @author 李杰 
	* @Title: sendPhoneVarCode 
	* @param request
	* @param codePhone					目标手机号
	* @return String 返回类型  JSON
	* @date 2016-3-21 上午9:35:01
	* @throws
	 */
	@RequestMapping(value="sendRegisterPhoneVarCode",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sendRegisterPhoneVarCode(HttpServletRequest request,String codePhone){
		Map<String,Object> message = new HashMap<String, Object>();
		if(codePhone == null || !StringUtils.checkPhone(codePhone)){
			message.put("statu", "-1");
			message.put("message", "请输入有效手机号");
		}
		if(message.keySet().size() > 0){
			return JSONObject.toJSONString(message);
		}
		//首先判断此号是否已经发送了
		String sCode = Core.getRegisterPhoneCode(codePhone);
		if(sCode != null){
			logger.debug("用户注册手机短信验证码发送成功："+codePhone+" : "+sCode);
			message.put("statu", 1);
			message.put("message", "验证码发送成功,请注意查收");
			return JSONObject.toJSONString(message);
		}else{
			String code = StringUtils.varCode();
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("phone", codePhone);
			param.put("code", code);
			int iresult = Core.putRegisterPhoneCode(codePhone, code);
			if(iresult == 1){
				String[] result = {"0",""};//sendSmsUtil.SendSms(param,0,0,null);
				if(result[0].equals("0")){
					logger.debug("用户注册手机短信验证码发送成功："+codePhone+" : "+code);
					message.put("statu", 1);
					message.put("message", "验证码发送成功,请注意查收");
				}else{
					logger.debug("用户注册手机短信验证码发送失败："+codePhone+" : "+code);
					message.put("statu", -2);
					message.put("message", "验证码发送失败,请重试!");
				}
			}else{
				logger.debug("用户注册手机短信验证码发送失败："+codePhone+" : "+code);
				message.put("statu", -2);
				message.put("message", "验证码发送失败,请重试!");
			}
			return JSONObject.toJSONString(message);
		}
	}
	
	/***
	* 去登录界面
	* 
	* @author 李杰
	* @Title: loginUser
	* @return
	* @date 2016-4-18 上午10:12:11
	*/
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String loginUser(HttpServletRequest request){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		if(memberInfo != null){
			return "redirect:accountOverview/accountOverview.html";
		}else{
			return "loginRegister/login";
		}
	}
	
	/***
	* 用户登录
	* 
	* @author 李杰
	* @Title: login
	* @param memberType				会员类型
	* @param memberName				会员名称
	* @param password				会员登录密码
	* @param checkCode				验证码
	* @param rememberMe				是否记住我
	* @return
	* @date 2016-4-18 上午10:27:55
	 */
	@RequestMapping(value="login",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response,
			int memberType,String memberName,String password,String checkCode,
			int rememberMe,@RequestHeader String referer){
		logger.debug("会员登录:memberName(用户名)="+memberName+",password(登录密码)="+password+",memberType(会员类型)="+memberType+",checkCode(验证码)="+checkCode+"rememberMe(记住我)="+rememberMe);
		
		Map<String,Object> param = new HashMap<String, Object>();
		boolean isExit = false;
		if(memberType > 1){
			isExit = true;
			param.put("memberType", "请选择正确的会员类型");
		}else{
			param.put("memberType", "");
		}
		
		if(memberName == null || memberName.trim().length() == 0){
			isExit = true;
			param.put("memberName", "请输入用户名");
		}else if(!StringUtils.checkCarLogName(memberName) && !StringUtils.checkPhone(memberName)){
			isExit = true;
			param.put("memberName", "请输入正确用户名");
		}else{
			param.put("memberName", "");
		}
		
		if(password == null || password.trim().length() == 0){
			isExit = true;
			param.put("password", "请输入登录密码");
		}else{
			param.put("password", "");
		}
		
		if(checkCode == null || checkCode.trim().length() == 0){
			isExit = true;
			param.put("checkCode", "请输入验证码");
		}else if(!checkCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION").toString())){
			isExit = true;
			param.put("message", "验证码错误");
		}else{
			param.put("checkCode", "");
		}
		
		if(isExit){
			param.put("statu", -2);
			return JSONObject.toJSONString(param);
		}
		
		String[] sIpInfo = new String[6];
		String ip = AddressUtils.GetRemoteIpAddr(request, sIpInfo);
		String sSessionId = request.getSession().getId();
		int result = memberService.login(memberName, password, memberType, ip, sIpInfo, referer,sSessionId);
		if(result == 0){
			//查询个人信息
			param.put("statu", 1);
			param.put("message", "登录成功");
			MemberInfo memberinfo = memberService.findMemberInfoByParam(memberName, password, memberType);
			if(rememberMe == 1 || memberinfo != null){
				request.getSession().setAttribute(Constant.LOGINUSER, memberinfo);
				KeyPair keyPair =  RSAPlugn.GetKeyPair();
				request.getSession().setAttribute(Constant.publicKey, RSAPlugn.PublicKeyToString((RSAPublicKey)keyPair.getPublic()));
				request.getSession().setAttribute(Constant.privateKey, RSAPlugn.PrivateKeyToString((RSAPrivateKey)keyPair.getPrivate()));
				
				Cookie cookie = new Cookie("rememberMeInfo", memberName+"-"+memberType);
				cookie.setMaxAge(30*24*60*60);
				response.addCookie(cookie);
			}else{
				param.put("statu", 0);
				param.put("message", "登录失败");
			}
		}else{
			param.put("statu", -3);
			param.put("message", "账号或密码错误");
		}
		return JSONObject.toJSONString(param);
	}
	
	/***
	* 去注册成功界面
	* 
	* @author 黄鑫
	* @Title: registerSuccess
	* @return
	* @date 2016-4-18 上午10:12:11
	*/
	@RequestMapping(value="forgetPWDSuccess",method=RequestMethod.GET)
	public String forgetPWDSuccess(){return "loginRegister/forgetPWDSuccess";}
	
	@RequestMapping(value="forgetPWD",method=RequestMethod.GET)
	public String forgetPWD(){return "loginRegister/forgetPWD";}
	
	@RequestMapping(value="registerSuccess",method=RequestMethod.GET)
	public String registerSuccess(){return "loginRegister/registerSuccess";}
	
	
	
	
	/**
	 * 忘记密码发送手机验证码
	* sendForgetPWDPhoneVarCode
	* @author 邱陈东  
	* * @Title: sendForgetPWDPhoneVarCode 
	* @param @param request
	* @param @param codePhone
	* @param @return 设定文件 
	* @return Object 返回类型 
	* @date 2016-5-6 下午3:48:32
	* @throws
	 */
	@RequestMapping(value="sendForgetPWDPhoneVarCode")
	@ResponseBody
	public Object sendForgetPWDPhoneVarCode(HttpServletRequest request,String loginName,String phone,Integer imgCode){
		Map<String,Object> message = new HashMap<String, Object>();
		if(phone == null || StringUtils.checkPhone(phone)){
			message.put("statu", "2");
			message.put("message", "请输入有效手机号");
		}
		
		if(imgCode == null ){
			message.put("statu", "3");
			message.put("checkCode", "请输入图片验证码");
		}else if(!imgCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION_FORGETPWD").toString())){
			message.put("statu", "4");
			message.put("message", "图片验证码错误");
		}
		
		if(message.keySet().size() > 0){
			return message;
		}
		int result = memberService.selectMemberIsExist(loginName, phone);
		if(result!=1){
			message.put("statu", 0);
			message.put("message", "您的用户名或手机号错误");
			return message;
		}
		String code = StringUtils.varCode();
		Core.putForgetPWDPhoneCode(phone, code);
		logger.debug("忘记密码发送手机验证码发送成功："+phone+" : "+code);
		message.put("statu", 1);
		message.put("message", "验证码发送成功，请注意查收");
		return message;
	}
	/**
	 * 提交忘记密码申请
	* checkForgetPWD
	* @author 邱陈东  
	* * @Title: checkForgetPWD 
	* @param @param request
	* @param @param phone
	* @param @param code
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-6 下午4:13:45
	* @throws
	 */
	@RequestMapping(value="checkForgetPWD")
	@ResponseBody
	public String checkForgetPWD(HttpServletRequest request , String phone,String code,String imgCode){
		Map<String,Object> message = new HashMap<String, Object>();
		//根据手机号取出验证码
		String  s = Core.getForgetPWDPhoneCode(phone);
		
		if(code.equals(s) && imgCode.equals(request.getSession().getAttribute("AUTH_IMG_CODE_IN_SESSION_FORGETPWD").toString())){
			//验证通过  把状态存到缓存中
			logger.debug("忘记密码手机验证码 验证通过："+phone+" : "+code);
			Core.putForgetPWDStatu(phone, "true");
			message.put("statu", 1);
			message.put("message", "验证码正确");
		}else{
			//验证码错误
			logger.debug("忘记密码手机验证码 验证未通过："+phone+" : "+code+";realCode:"+s);
			message.put("statu", -1);
			message.put("message", "验证码错误");
		}
		
		return JSONObject.toJSONString(message);
	}
	
	
	@Resource(name="updatePasswordServiceImpl")
	UpdatePasswordService updatePasswordService;
	/**
	 * 设置新密码
	* setNewPassWord
	* @author 邱陈东  
	* * @Title: setNewPassWord 
	* @param @param request
	* @param @param phone
	* @param @param newPassWord
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-6 下午5:43:34
	* @throws
	 */
	@RequestMapping(value="setNewPassWord")
	@ResponseBody
	public String setNewPassWord(HttpServletRequest request,String loginName , String phone , String newPassWord){
		Map<String,Object> message = new HashMap<String, Object>();
		//根据手机号取出 是否通过 忘记密码的手机验证
		String  s = Core.getForgetPWDStatu(phone);
		
		if(!s.equals("true")){
			message.put("statu", -1);
			message.put("message", "请重新验证你的手机验证码");
			return JSONObject.toJSONString(message);
		}
		//根据手机号查询用户ID
		long memberId = memberService.selectMemberIdByPhone(loginName,phone);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("newPassWord", newPassWord);
		map.put("memberID", memberId);
		int result = updatePasswordService.updatepersonPassword(map);
		
		message.put("statu", result);
		message.put("message", "请重新验证你的手机验证码");
		
		return JSONObject.toJSONString(message);
	}
	
}

