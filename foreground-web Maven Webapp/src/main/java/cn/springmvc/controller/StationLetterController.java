package cn.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.membermng.model.MemberMsgRecordEntity;
import cn.membermng.model.MemberStationLetterEntity;
import cn.springmvc.service.MemberMsgRecordService;
import cn.springmvc.service.MemberStationService;
import cn.springmvc.util.MemberSessionMng;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping(value="/message")
public class StationLetterController {
	private Logger logger = Logger.getLogger(LoginRegisterController.class);
	
	
	//站内信
	@Resource(name="memberStationServiceImpl")
	MemberStationService memberStationService;
	
	//站内消息
	@Resource(name="memberMsgRecordServiceImpl")
	MemberMsgRecordService memberMsgRecordService; 
	
	/**
	 * 站内消息（平台发送给会员）
	 * @author 邱陈东
	 * @date 2016年4月25日15:08:53
	 */
	@RequestMapping(value="/loadStationMessageList",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loadStationMessageList(HttpServletRequest req){
		int start = IntegerAndString.StringToInt(req.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(req.getParameter("length"),10) ; 
		int Read_Statu = IntegerAndString.StringToInt(req.getParameter("Read_Statu"),-1);
		long[] lMemberInfo = new long[2] ;
		
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberID",lMemberInfo[0]);
		param.put("memberID",1);
		param.put("readStatu", Read_Statu);
		PageEntity pager = new PageEntity();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<MemberMsgRecordEntity> list = memberMsgRecordService.selectMemberMsgList(pager);
		PageUtil.ObjectToPage(pager, list);
		return JSONObject.toJSONString(pager);
	}
	/**
	 * 把站内消息设为已读
	 * @author 邱陈东
	 * @date 2016年4月25日16:48:30
	 */
	@RequestMapping(value="/updateMemberMsgIsRead",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateMemberMsgIsRead(HttpServletRequest req,
			@RequestParam(value="recordDate", required=false)String recordDate){
		Map<String, Object> map = new HashMap<String,Object>();
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		//map.put("memberID", lMemberInfo[0]);
		map.put("memberID", 1);
		map.put("recordDate", recordDate.substring(0,recordDate.length()-2));
		map.put("msgType", 2);
		int result = memberMsgRecordService.updateMemberMsgIsRead(map);
		
		Map<String,Object> message = new HashMap<String, Object>();

		
		message.put("statu", result);
		message.put("message", "已经成功的把这条信息设为已读");
		return JSONObject.toJSONString(message);
	}
	
	
	
	
	/**
	 * 读取站内信  发件箱列表（会员发送给会员）
	 * @return
	 */
	@RequestMapping(value="loadSendLetterList",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loadSendLetterList(HttpServletRequest req){
		int start = IntegerAndString.StringToInt(req.getParameter("start"),1);//第几页
		int length = IntegerAndString.StringToInt(req.getParameter("length"),10);//读取多少条
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		
		Map<String,Object> param=new HashMap<String,Object>();
		
		param.put("memberID", lMemberInfo[0]);
		param.put("memberID", 1);
		PageEntity pager = new PageEntity();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<MemberStationLetterEntity> list = memberStationService.selectSendLetter(pager);
		PageUtil.ObjectToPage(pager, list);
		return JSONObject.toJSONString(pager);
	}
	/**
	 * 读取站内信 收件箱列表（会员发送给会员）
	 * @return
	 */
	@RequestMapping(value="loadRecLetterList",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loadRecLetterList(HttpServletRequest req){
		int start = IntegerAndString.StringToInt(req.getParameter("start"),1);//第几页
		int length = IntegerAndString.StringToInt(req.getParameter("length"),10);//读取多少条
		int isRead = IntegerAndString.StringToInt(req.getParameter("isRead"),-1);//-1全部  0未读  1已读
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("keys", DbKeyUtil.GetDbCodeKey());//加密解密用的秘钥
		param.put("memberID", lMemberInfo[0]);
		param.put("memberID", 1);
		param.put("isRead", isRead);
		PageEntity pager = new PageEntity();
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<MemberStationLetterEntity> list = memberStationService.selectRecLetter(pager);
		PageUtil.ObjectToPage(pager, list);
		return JSONObject.toJSONString(pager);
	}
	
	/**
	 * 
	* selectSendLetterDetail(查询发件箱邮件的内容) 
	* @author 邱陈东  
	*  根据站内信的letterId查询发送的站内信的内容
	* * @Title: selectSendLetterDetail 
	* @param @param req
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-26 下午2:13:11
	* @throws
	 */
	@RequestMapping(value="selectSendLetterDetail",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectSendLetterDetail(HttpServletRequest req){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		int letterID = IntegerAndString.StringToInt(req.getParameter("letterId"),0);
		
		Map<String,Object> param=new HashMap<String,Object>();
		
		param.put("memberID", lMemberInfo[0]);
		param.put("memberID", 1);
		param.put("letterID", letterID);
		param.put("keys", DbKeyUtil.GetDbCodeKey());//加密解密用的秘钥
		
		MemberStationLetterEntity entity = memberStationService.selectSendLetterDetail(param);
		return JSONObject.toJSONString(entity);
	}
	/**
	 * 
	* selectRecLetterDetail(查询收到的站内信的内容) 
	* 根据站内信的letterId查询收到的站内信的内容
	* @author 邱陈东  
	* * @Title: selectRecLetterDetail 
	* @param @param req
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-26 下午2:18:37
	* @throws
	 */
	@RequestMapping(value="selectRecLetterDetail",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectRecLetterDetail(HttpServletRequest req){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		int letterId = IntegerAndString.StringToInt(req.getParameter("letterId"),0);
		
		Map<String,Object> param=new HashMap<String,Object>();
		
		param.put("memberID", lMemberInfo[0]);
		param.put("memberID", 1);
		param.put("letterID", letterId);
		param.put("keys", DbKeyUtil.GetDbCodeKey());//加密解密用的秘钥
		
		MemberStationLetterEntity entity = memberStationService.selectRecLetterDetail(param);
		return JSONObject.toJSONString(entity);
	}
	
	
	/**
	 * 
	* updateRecStationRead(把点击查看后的站内信标记为已读) 
	* @author 邱陈东  
	* * @Title: updateRecStationRead 
	* @param @param req
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-26 下午2:30:35
	* @throws
	 */
	@RequestMapping(value="updateRecStationRead",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateRecStationRead(HttpServletRequest req){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		int letterId = IntegerAndString.StringToInt(req.getParameter("letterId"),0);
		Map<String,Object> message = new HashMap<String, Object>();

		int result =memberStationService.updateRecStationRead(letterId);
		
		message.put("statu", result);
		message.put("message", "已经成功的把这条信息设为已读");
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* updateRecStationReadlist
	*把站内信批量标记为已读 
	* @author 邱陈东  
	* * @Title: updateRecStationReadlist 
	* @param @param req
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-26 下午2:44:31
	* @throws
	 */
	@RequestMapping(value="updateRecStationReadlist",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateRecStationReadlist(HttpServletRequest req){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		String letterIds = req.getParameter("letterIds");
		Map<String,Object> message = new HashMap<String, Object>();
		String[] strs = letterIds.split(",");
		List<Integer> list = new ArrayList<Integer>();
		//把string数组转化为需要的int的List
		for(int i=0;i<strs.length;i++){
			list.add(IntegerAndString.StringToInt(strs[i],0));
		}
		int result =memberStationService.updateRecStationReadlist(list);
		
		message.put("statu", result);
		message.put("message", "已经成功的把这些站内信设为已读");
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* updateRecStationNotReadlist
	* 把站内信批量设为未读
	* @author 邱陈东  
	* * @Title: updateRecStationNotReadlist 
	* @param @param req
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-26 下午2:46:38
	* @throws
	 */
	@RequestMapping(value="updateRecStationNotReadlist",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateRecStationNotReadlist(HttpServletRequest req){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		String letterIds = req.getParameter("letterIds");
		Map<String,Object> message = new HashMap<String, Object>();
		String[] strs = letterIds.split(",");
		List<Integer> list = new ArrayList<Integer>();
		//把string数组转化为需要的int的List
		for(int i=0;i<strs.length;i++){
			list.add(IntegerAndString.StringToInt(strs[i],0));
		}
		int result =memberStationService.updateRecStationNotReadlist(list);
		
		message.put("statu", result);
		message.put("message", "已经成功的把这些站内信设为未读");
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* addStationLetter(发送站内信) 
	* @author 邱陈东  
	* * @Title: addStationLetter 
	* @param @param req request
	* @param @param title	标题
	* @param @param detail 内容
	* @param @param memberName 收件人登录名
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-26 下午3:16:32
	* @throws
	 */
	@RequestMapping(value="addStationLetter",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addStationLetter(HttpServletRequest req,String title,String detail,String memberName){
		
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(req,lMemberInfo); 
		Map<String,Object> message = new HashMap<String, Object>();
		
		
		MemberStationLetterEntity entity = new MemberStationLetterEntity();
		entity.setMemberID(lMemberInfo[0]);
		entity.setMemberID(1);
		entity.setTitle(title);
		entity.setDetail(detail);
		entity.setPreID(0);
		long recMemberId = memberStationService.selectMemberID(memberName);
		entity.setMemberIDRec(recMemberId);
		int result = memberStationService.addStationLetter(entity);
		message.put("statu", result);
		message.put("message", "站内信发送成功");
		return JSONObject.toJSONString(message);
	}
	/**
	 * 
	* deleteSendStationLetter
	* 批量删除发送方已发送的信息
	* @author 邱陈东  
	* * @Title: deleteSendStationLetter 
	* @param @param request
	* @return String 返回类型 
	* @date 2016-4-27 上午9:55:09
	* @throws
	 */
	@RequestMapping(value="deleteSendStationLetter",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteSendStationLetter(HttpServletRequest request){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		String letterIds = request.getParameter("letterIds");
		Map<String,Object> message = new HashMap<String, Object>();
		String[] strs = letterIds.split(",");
		List<Integer> list = new ArrayList<Integer>();
		//把string数组转化为需要的int的List
		for(int i=0;i<strs.length;i++){
			list.add(IntegerAndString.StringToInt(strs[i],0));
		}
		int result =memberStationService.deleteSendStationLetter(list);
		
		message.put("statu", result);
		message.put("message", "已经成功的把这些站内信删除");
		return JSONObject.toJSONString(message);
	}
	
	/**
	 * 
	* deleteRecStationLetter
	*批量删除接收方信息 
	* @author 邱陈东  
	* * @Title: deleteRecStationLetter 
	* @param @param request
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-27 上午10:00:44
	* @throws
	 */
	@RequestMapping(value="deleteRecStationLetter",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteRecStationLetter(HttpServletRequest request){
		long[] lMemberInfo = new long[2] ;
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		String letterIds = request.getParameter("letterIds");
		Map<String,Object> message = new HashMap<String, Object>();
		String[] strs = letterIds.split(",");
		List<Integer> list = new ArrayList<Integer>();
		//把string数组转化为需要的int的List
		for(int i=0;i<strs.length;i++){
			list.add(IntegerAndString.StringToInt(strs[i],0));
		}
		int result =memberStationService.deleteRecStationLetter(list);
		
		message.put("statu", result);
		message.put("message", "已经成功的把这些站内信删除");
		return JSONObject.toJSONString(message);
	}
}
