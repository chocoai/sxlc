

/** 
* @Title: RecommendedTalentColltroller.java 
* @Package cn.springmvc.controller 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-3 上午10:05:18 
* @version V5.0 */
 
package cn.springmvc.controller; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity; 
import product_p2p.kit.pageselect.PageUtil;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
  
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.InvestRepaymentEntity;
import cn.invitemastermng.model.InvitationRecordEntity;
import cn.invitemastermng.model.InviteMasterAwardRecordEntity;
import cn.springmvc.service.InviteMasterApplyService;
import cn.springmvc.util.MemberSessionMng;

/** 
 * @author 刘利 
 * @Description: 推荐达人
 * @since 
 * @date 2016-5-3 上午10:05:18  */
@Controller
@RequestMapping("recommendedTalentc")
public class RecommendedTalentColltroller {
	
	@Autowired
	private InviteMasterApplyService inviteMasterApplyService;
	
	/**
	 * 顶部统计
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-4 下午3:54:00
	 */
	@RequestMapping(value="/inviteStatistic")
	@ResponseBody
	public String inviteStatistic(HttpServletRequest request){
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		InviteMasterAwardRecordEntity entity = inviteMasterApplyService.selectInviteMasterStatistic(lMemberInfo[0]);
	    return JSONObject.toJSONString(entity);
	}
	
	
	
	/**
	 * 推荐达人提奖记录
	 * @author 刘利   
	 * @Description: TODO  
	 * @return String 返回类型 
	 * @date 2016-5-3 上午10:17:44
	 */
	@RequestMapping(value="inviteAwardRecord",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String inviteAwardRecord(HttpServletRequest request){ 
		
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		
		String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		
		//dateStart(1今天，2近一本周，3近一月，4近6月)
		int dateStart    = IntegerAndString.StringToInt(request.getParameter("dateStart"),-1) ; 
	   
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID", lMemberInfo[0]);
		param.put("skey",     DbKeyUtil.GetDbCodeKey());
		param.put("startTime",   startTime);
		param.put("endTime",       endTime);
		param.put("dateStart",   dateStart);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<InviteMasterAwardRecordEntity> list = inviteMasterApplyService.getInviteMasterAwardRecord(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity,SerializerFeature.WriteNullStringAsEmpty); 
	}
	
	
	
	/**
	 * 推荐达人历史返现
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-4 下午4:10:09
	 */
	@RequestMapping(value="inviteHistoryBack",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public  String inviteHistoryBack(HttpServletRequest request) {
		
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),10);
		String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		String month     = request.getParameter("month") ; //(提奖统计月份一月：01，二月:02)
		
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID", lMemberInfo[0]); 
		param.put("startTime",   startTime);
		param.put("endTime",       endTime);
		param.put("month",           month);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<AwardPaymentRecordEntity> list = inviteMasterApplyService.getInviteMasterHistoryBack(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 推荐达人邀请记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-4 下午4:10:09
	 */
	@RequestMapping(value="/inviteInvitation",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public  String inviteInvitation(HttpServletRequest request) {
		
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),3);

		String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		String name      = request.getParameter("name");//name(会员/用户名)
		//isopenThird(1开户，2未开户，-1全部)
		int isopenThird  =  IntegerAndString.StringToInt(request.getParameter("isopenThird"),-1);
		//（1降序,2升序）
		int order        = IntegerAndString.StringToInt(request.getParameter("order"),-1);
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID", lMemberInfo[0]); 
		param.put("startTime",     startTime);
		param.put("endTime",         endTime);
		param.put("isopenThird", isopenThird);
		param.put("name",               name);
		param.put("order",              order);
		param.put("skey",              DbKeyUtil.GetDbCodeKey());
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<InvitationRecordEntity> list = inviteMasterApplyService.getInviteInvitationRecord(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 推荐达人推荐借款明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-4 下午4:10:09
	 */
	@RequestMapping(value="/inviteBorrowing",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public  String inviteBorrowing(HttpServletRequest request) {
		
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),10);
		String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		String name      = request.getParameter("name");//name(会员/用户名)
		String projectTitle      = request.getParameter("projectTitle");//借款名称
		//（1降序,2升序）
		int order        = IntegerAndString.StringToInt(request.getParameter("order"),-1);
		
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID",   lMemberInfo[0]); 
		param.put("startTime",       startTime);
		param.put("endTime",           endTime);
		param.put("projectTitle", projectTitle);
		param.put("name",                 name);
		param.put("order",               order);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<BorrowingDetailedEntity> list = inviteMasterApplyService.selectInviteBorrowing(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity); 
	}
	
	
	
	/**
	 * 推荐达人推荐投资明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-4 下午4:10:09
	 */
	@RequestMapping(value="/inviteInvest",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public  String inviteInvest(HttpServletRequest request) {
		
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),10);
		String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		String name      = request.getParameter("name");//name(会员/用户名)
		String projectTitle      = request.getParameter("projectTitle");//借款名称
		//（1降序,2升序）
		int order        = IntegerAndString.StringToInt(request.getParameter("order"),-1);
		
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID",   lMemberInfo[0]); 
		param.put("startTime",       startTime);
		param.put("endTime",           endTime);
		param.put("projectTitle", projectTitle);
		param.put("name",                 name);
		param.put("order",               order);
		param.put("skey",              DbKeyUtil.GetDbCodeKey());
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<InvestDetailedEntity> list = inviteMasterApplyService.getInviteInvest(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 推荐达人推荐还本明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-4 下午4:10:09
	 */
	@RequestMapping(value="/repaymentInvite",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public  String repaymentInvite(HttpServletRequest request) {
		
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),10);
		String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		String name      = request.getParameter("name");//name(会员/用户名)
		String projectTitle      = request.getParameter("projectTitle");//借款名称
		//（1降序,2升序）
		int order        = IntegerAndString.StringToInt(request.getParameter("order"),-1);
		//(1逾期，2未逾期，-1全部)
		int over         = IntegerAndString.StringToInt(request.getParameter("over"),-1);
		
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID",   lMemberInfo[0]); 
		param.put("startTime",       startTime);
		param.put("endTime",           endTime);
		param.put("projectTitle", projectTitle);
		param.put("name",                 name);
		param.put("order",               order);
		param.put("over",                 over);
		param.put("skey",              DbKeyUtil.GetDbCodeKey());
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<InvestRepaymentEntity> list = inviteMasterApplyService.getRepaymentInvite(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity); 
	}
	
	/**
	 * 推荐达人VIP购买明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-4 下午4:10:09
	 */
	@RequestMapping(value="/inviteVipPay",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public  String inviteVipPay(HttpServletRequest request) {
		
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),10);
		String startTime = request.getParameter("startTime");
		String endTime   = request.getParameter("endTime");
		String name      = request.getParameter("name");//name(会员/用户名) 
		//（1降序,2升序）
		int order        = IntegerAndString.StringToInt(request.getParameter("order"),-1); 
		
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberID",   lMemberInfo[0]); 
		param.put("startTime",       startTime);
		param.put("endTime",           endTime); 
		param.put("name",                 name);
		param.put("order",               order); 
		param.put("skey",              DbKeyUtil.GetDbCodeKey());
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<BayVIPEntity> list = inviteMasterApplyService.getInviteVipPay(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 申请成为推荐达人
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-4 下午4:10:09
	 */
	@RequestMapping(value="/applyInviteMaster",produces="text/html;charset=UTF-8")
	@ResponseBody
	public  String applyInviteMaster(HttpServletRequest request) { 
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);    
		int result = inviteMasterApplyService.insertInviteMasterApply(lMemberInfo[0]);
		Map<String,Object> message =  new HashMap<String, Object>();
		if(result == 1) {
			message.put("result",     result);
			message.put("message",   "申请成功");
		}else if(result == 0) {
			message.put("result",     result);
			message.put("message",   "申请失败");
		}else if(result == -1) {
			message.put("result",     result);
			message.put("message",   "该会员已是推荐达人，或存在未审核的申请记录");
		}
		   
	    return JSONObject.toJSONString(message); 
	}
}

