package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.redisPlug.Core;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.PersonalBaseInfo;
import cn.springmvc.dao.impl.sms.SendSmsUtil;
import cn.springmvc.service.IMemberService;

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
	public String toRegPage(){
		return "loginRegister/register";
	}
	
	
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
	@RequestMapping(value="checkPhone")
	@ResponseBody
	public String checkPhone(HttpServletRequest request,String phone){
		Map<String,Object> message = new HashMap<String, Object>();
		if(phone == null || phone.trim().length() > 0){
			message.put("message", "请输入有效电话号码");
			message.put("statu", 1);
			return JSONObject.toJSONString(message);
		}
		int result = memberService.chechPhone(phone);
		if(result == 0){
			message.put("statu", 0);
			message.put("message", "可以使用该电话号码");
		}
		return JSONObject.toJSONString(message);
	}
	
	/*** 
	 * 检查用户名是否存在
	 * @return
	 */
	@RequestMapping(value="checkName")
	@ResponseBody
	public String checkName(HttpServletRequest request,String userName){
		Map<String,Object> message = new HashMap<String, Object>();
		if(userName == null || userName.trim().length() < 6 || userName.trim().length() > 16){
			message.put("message", "用户名无效");
			message.put("statu", 1);
			return JSONObject.toJSONString(message);
		}
		int result = memberService.countName(userName);
		if(result == 0){
			message.put("statu", 0);
			message.put("message", "可以使用该昵称");
		}
		return JSONObject.toJSONString(message);
	}
	
	
	/*** 
	 * 检查邀请码是否存在
	 * @return
	 */
	@RequestMapping(value="countInvitateCode")
	@ResponseBody
	public String countInvitateCode(HttpServletRequest request,String invitateCode){
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
	
	
	
}

