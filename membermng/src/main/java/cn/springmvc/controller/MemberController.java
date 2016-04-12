package cn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.StringUtil.StringUtils;
import product_p2p.kit.redisPlug.Core;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.PersonalBaseInfo;
import cn.springmvc.service.IMemberService;

import com.alibaba.fastjson.JSONObject;


@Controller
public class MemberController {
	public Logger logger = Logger.getLogger(MemberController.class);

	@Resource
	private IMemberService memberService;
	
	
	/***
	 * 用户注册
	 * @param model
	 * @param requst
	 * @return
	 */
	@RequestMapping(value="signUp",method=RequestMethod.POST)
	public String signUp(Model model,
			@ModelAttribute @Valid MemberInfo info,BindingResult result,
			@ModelAttribute @Valid PersonalBaseInfo baseInfo,BindingResult result2,
			HttpServletRequest requst){
		if(result.hasErrors() || result2.hasErrors()){
			
		}
		
		memberService.individualMember(info, baseInfo);
		return "asdad";
	}
	
	
	/***
	 * 用户登录
	 * @param model
	 * @param userName						登录会员名
	 * @param password						登录密码
	 * @param checkCoede					登录验证码
	 * @param userType						会员类型
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,Model model,String userName,String password,String checkCoede,int userType,String referer){
		Map<String,String> message = new HashMap<String, String>();
		//验证输入信息---------------------------------------------->
		if(userName == null || userName.trim().length() < 6 || userName.trim().length() > 16){
			message.put("userName", "请输入合法用户名");
		}
		if(password == null || password == ""){
			message.put("password", "请输入登录密码");
		}
		if(checkCoede == null || checkCoede == "" || checkCoede.trim().length() != 6){
			message.put("checkCoede", "请输入有效验证码");
		}
		if(userType < 0 || userType > 1){
			message.put("checkCoede", "请求参数无效");
		}
		if(message.keySet().size() > 0){
			return JSONObject.toJSONString(message);
		}
		
		if(!checkCoede.equals(Core.getVerCodeByUserLognName(userName))){//验证码匹配失败
			message.put("checkCoede", "验证码无效");
			return JSONObject.toJSONString(message);
		}
		
		String[] ipinfo = null;
		String ipAddress = AddressUtils.GetRemoteIpAddr(request, ipinfo);
		if(ipAddress == null || ipAddress.trim().length() == 0 || ipinfo == null || ipinfo.length != 6){
			message.put("login","网络出现问题,登录失败");
			return JSONObject.toJSONString(message);
		}
		
		int result = memberService.login(userName,password,userType,ipAddress,ipinfo,referer);
		if(result == -1){
			message.put("login", "用户名或密码错误");
			return JSONObject.toJSONString(message);
		}else if(result == 0){//登录成功
			//获取信息存入Session
			
			message.put("login", "登录成功");
			if(referer != null && referer.trim().length() > 5){//http:都有五个字
				message.put("referer", referer);
			}
			return JSONObject.toJSONString(message);
		}
		return JSONObject.toJSONString(message);
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
	
	
	/*** 检查电话号码是否存在
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
	
	
	/*** 检查邀请码是否存在
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
	* 发送短信验证码
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
	
	
	
	
}
