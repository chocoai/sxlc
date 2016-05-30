package cn.springmvc.controller.config; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.MailSettingsEntity;
import cn.springmvc.model.MessageTypeEntity;
import cn.springmvc.model.SmsSettingsEntity;
import cn.springmvc.service.ChannelSetService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description:  消息设置控制器
* @date 2016-4-26 下午3:27:48 
*/
@Controller
@RequestMapping("/config")
public class MsgSetController {
	
	@Resource(name="channelSetServiceImpl")
	private ChannelSetService channelSetService;
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到消息内容配置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-26 下午3:31:49
	 * @throws 
	 */
	@RequestMapping("/toMsgContentSet")
	public String toMsgContentSet(HttpServletRequest req){
		List<MessageTypeEntity> result = channelSetService.selectChannelSet();
		req.setAttribute("msgs", result);
		return "config/msg-content";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取消息内容配置表格数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-4-26 下午3:34:48
	 * @throws 
	 */
	@RequestMapping("/getMsgSetData")
	@ResponseBody
	public PageEntity getMsgSetData(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		channelSetService.selectChannelSetByPage(pager);
		return pager;
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 新增/修改
	 * @param req
	 * @return int  
	 * @date 2016-4-27 上午10:21:03
	 * @throws 
	 */
	@RequestMapping("/addOrUpdateMsgContent")
	@ResponseBody
	public int addOrUpdateMsgContent(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin==null){
			return -2;//用户未登录
		}
		//moduleID=60301(消息内容配置)
		//optID= 6030101(修改）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60301);
		logEntity.setlOptId(6030101);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		Map<String, Object> map =new HashMap<String,Object>();
		String typeID = req.getParameter("typeID");
		map.put("typeID",typeID);
		String messageMsgDetail = req.getParameter("messageMsgDetail");
		map.put("messageMsgDetail",messageMsgDetail);
		String statu = req.getParameter("statu");
		if(statu != null && !"".equals(statu)){
			map.put("statu",statu);
		}else{
			map.put("statu",1);
		}
		int result=0;
		result = channelSetService.updateMessage(map, logEntity, sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 启用/停用
	 * @param req
	 * @return int  
	 * @date 2016-4-27 上午10:21:03
	 * @throws 
	 */
	@RequestMapping("/enableMsgContent")
	@ResponseBody
	public int enableMsgContent(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin==null){
			return -2;//用户未登录
		}
		//moduleID=60301(消息内容配置)
		//optID= 6030101(修改）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60301);
		logEntity.setlOptId(6030101);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		Map<String, Object> map =new HashMap<String,Object>();
		String typeID = req.getParameter("typeID");
		map.put("typeID",typeID);
		String statu = req.getParameter("statu");
		map.put("statu",statu);
		int result=0;
		result = channelSetService.SetEnableDisable(map, logEntity, sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到消息接口配置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-26 下午4:46:15
	 * @throws 
	 */
	@RequestMapping("/toMsgInterface")
	public String toMsgInterface(HttpServletRequest req){
		MailSettingsEntity mailSet = channelSetService.selectMailSettings();
		req.setAttribute("mailSet", mailSet);
		return "config/msg-interface";
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 修改邮件接口地址
	 * @param req
	 * @return int  
	 * @date 2016-4-28 上午10:08:44
	 * @throws 
	 */
	@RequestMapping("/updateMailSettings")
	@ResponseBody
	public int updateMailSettings(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin==null){
			return -2;//用户未登录
		}
		//moduleID=60304(消息接口配置)
		//optID=6030402（邮件接口设置）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60304);
		logEntity.setlOptId(6030402);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		//参数
		MailSettingsEntity entity = new  MailSettingsEntity();
		String smtpservice = req.getParameter("smtpservice");
		entity.setSmtpservice(smtpservice);
		String portNumber = req.getParameter("portNumber");
		entity.setPortNumber(portNumber);
		String emailAddress = req.getParameter("emailAddress");
		entity.setEmailAddress(emailAddress);
		String emailPassword = req.getParameter("emailPassword");
		entity.setEmailPassword(emailPassword);
		
		int result=0;
		result = channelSetService.updateMailSettings(entity, logEntity, sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取消息接口配置表格数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-4-27 上午11:20:58
	 * @throws 
	 */
	@RequestMapping("/getMsgInterfaceData")
	@ResponseBody
	public PageEntity getMsgInterfaceData(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		channelSetService.selectSmsSettings(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 增加或修改或启用/停用短信接口地址
	 * @param req
	 * @return int  
	 * @date 2016-4-27 下午12:01:42
	 * @throws 
	 */
	@RequestMapping("/addOrUpdateMsgInterface")
	@ResponseBody
	public int addOrUpdateMsgInterface(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin==null){
			return -2;//用户未登录
		}
		//moduleID=60304(消息接口配置)
		//optID=6030401（短信接口设置）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60304);
		logEntity.setlOptId(6030401);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		SmsSettingsEntity entity = new  SmsSettingsEntity();
		String smsInterface = req.getParameter("smsInterface");
		entity.setSmsInterface(smsInterface);
		String smsSerialNumber = req.getParameter("smsSerialNumber");
		entity.setSmsSerialNumber(smsSerialNumber);
		String smsPassword = req.getParameter("smsPassword");
		entity.setSmsPassword(smsPassword);
		
		int result=0;
		entity.setStatu(1);
		
		String type = req.getParameter("type");//操作类型
		if(type.equals("1")){//增加操作
			result = channelSetService.insertSmsSettings(entity, logEntity, sIpInfo);
		}else if(type.equals("2")){//修改操作
			Long id = Long.parseLong(req.getParameter("id"));
			entity.setId(id);
			result = channelSetService.updateSmsSettingsById(entity, logEntity, sIpInfo);
		}else if(type.equals("3")){//启用/停用操作
			Map<String,Object> param=new HashMap<String,Object>();
			Long id = Long.parseLong(req.getParameter("id"));
			String statu = req.getParameter("statu");
			param.put("ID", id);
			param.put("statu", statu);
			param.put("optId", admin.getId());
			result = channelSetService.updteSmsSettingsStatu(param, logEntity, sIpInfo);
		}
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到消息提醒设置页面
	 * @param req
	 * @return String  
	 * @date 2016-4-27 下午1:56:55
	 * @throws 
	 */
	@RequestMapping("/toMsgAlertPg")
	public String toMsgAlertPg(HttpServletRequest req){
		List<MessageTypeEntity> result = channelSetService.selectChannelSet();
		req.setAttribute("msgs", result);
		return "config/msg-alert";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 修改消息提醒设置
	 * @param req
	 * @return int  
	 * @date 2016-4-28 上午9:54:42
	 * @throws 
	 */
	@RequestMapping("/updateMsgSet")
	@ResponseBody
	public int updateMsgSet(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		if(admin==null){
			return -2;//用户未登录
		}
		//moduleID=60302(消息提醒设置)
		//optID=6030201（修改）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60302);
		logEntity.setlOptId(6030201);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		Map<String,Object> param=new HashMap<String,Object>();
		String ids = req.getParameter("content");
		String type = req.getParameter("type");//操作类型
		param.put("messagetypes", ids);
		param.put("type", type);
		int result=0;
		result = channelSetService.updateChannelSet(param, logEntity, sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 消息发送历史页面 
	 * @param req
	 * @return String  
	 * @date 2016-5-11 下午6:25:03
	 * @throws 
	 */
	@RequestMapping("/toMsgPostPg")
	public String toMsgPostPg(HttpServletRequest req){
		return "config/msg-post";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取消息发送历史分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-11 下午6:32:05
	 * @throws 
	 */
	@RequestMapping("/getMsgSendHistoryData")
	@ResponseBody
	public PageEntity getMsgSendHistoryData(HttpServletRequest req){
		//获取加密参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String MemberNo = req.getParameter("MemberNo");
		String personalPhone = req.getParameter("personalPhone");
		String personalName = req.getParameter("personalName");
		String logname = req.getParameter("logname");
		//设置参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("MemberNo", MemberNo);
		param.put("personalPhone", personalPhone);
		param.put("personalName", personalName);
		param.put("logname", logname);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		Integer pgType = Integer.parseInt(req.getParameter("pgType"));//标签页类型
		if(pgType == 1 ){//站内信
			channelSetService.SendHistory(pager);
		}else if(pgType == 2){//短信
			channelSetService.SMSHistory(pager);
		}else if(pgType == 3){//邮件
			channelSetService.MailHistory(pager);
		}
		return pager;
	}
	
}

