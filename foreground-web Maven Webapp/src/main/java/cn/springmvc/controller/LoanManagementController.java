package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import product_p2p.kit.constant.Constant;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.membermng.model.AdvanceEntity;
import cn.membermng.model.Cleared;
import cn.membermng.model.ComfirLoanInfo;
import cn.membermng.model.ConfirmationLoan;
import cn.membermng.model.Financing;
import cn.membermng.model.FlowLabel;
import cn.membermng.model.InvestmentRecord;
import cn.membermng.model.LoanApplyRecord;
import cn.membermng.model.LoanRepay;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.membermng.model.RepaymentIn;
import cn.membermng.model.RepaymentOfBorrowings;
import cn.membermng.model.RepaymentOfBorrowingsRM;
import cn.membermng.model.ReplayDetailEntity;
import cn.membermng.model.StayStillPlan;
import cn.springmvc.service.IMyLoanService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.RepaymentInterfaceServer;
import cn.springmvc.util.MemberSessionMng;
import cn.sxlc.account.manager.model.AuthorizeInterfaceEntity;
import cn.sxlc.account.manager.model.LoanTransferEntity;
import cn.sxlc.account.manager.model.RepayInterfaceEntity;
/**
 * 
 * @author 刘利 
 * @Description: 我的账户-借款管理
 * @since 
 * @date 2016-4-29 上午10:39:44
 */
@Controller
@RequestMapping("loanManagement")
public class LoanManagementController {
	@Autowired
	private IMyLoanService imyLoanService;
	
	@Autowired
	private ManagedInterfaceServerTestI interfaceServerTestI;
	
	@Autowired
	private RepaymentInterfaceServer repaymentInterfaceServer;
	
	/**
	 * 我的借款-借款记录-融资中
	 * @author 刘利
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 上午10:39:35
	 */
	@RequestMapping(value="/financing",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String financing(HttpServletRequest request){ 
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
	    long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<Financing> list = imyLoanService.financings(pageEntity);
		//Financing fi = new Financing(20160503, "20160503", "测试名称", 1, "测试类型", 2, 1, 100000, "10000.00", 1010,"10.10","2016-05-01 10:00","2016-05-01 08:00","2016-05-01 12:00","2016-05-01 13:00",10000);
		//list.add(0, fi);
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity); 
	}
	
	
	
	/**
	 * 我的借款-借款记录-融资结束
	 * @author 刘利
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 上午11:39:31
	 */
	@RequestMapping(value="/financed",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String financed(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
	    long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<Financing> list = imyLoanService.endOfFinancing(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	
	/**
	 * 
	 * 我的借款-借款记录-还款中
	 * @author 刘利
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 上午11:41:09
	 */
	@RequestMapping(value="/RepaymentIn",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String RepaymentIn(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
	    long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<RepaymentIn> list = imyLoanService.repaymentIns(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	
	/**
	 * 我的借款-借款记录-已流标
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 上午11:47:21
	 */
	@RequestMapping(value="/flowLabelS",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String flowLabelS(HttpServletRequest request){ 
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
	    long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<FlowLabel> list = imyLoanService.flowLabelS(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	
	/**
	 * 我的借款-借款记录-已结清
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 上午11:48:53
	 */
	@RequestMapping(value="/cleared",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String cleared(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ;
	    long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<Cleared> list = imyLoanService.cleared(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	
	/**
	 * 我的借款-借款申请记录
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 上午11:53:43
	 */
	@RequestMapping(value="/loanApplyRecord",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loanApplyRecord(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ;
	    long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<LoanApplyRecord> list = imyLoanService.loanApplyRecord(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	
	/**
	 * 我的借款-待确认借款申请 
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 上午11:58:43
	 */
	@RequestMapping(value="/TBCapply",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String TBCapply(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ;
	    long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<ConfirmationLoan> list = imyLoanService.confirmationLoans(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	
	
	/**
	 * 还款中的借款-还款计划
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午4:18:43
	 */
	@RequestMapping(value="/loanRepaying",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loanRepaying(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ;
	  
		long applyId	 =  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("applyId", applyId);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<LoanRepay> list = imyLoanService.loanRepay(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 已结清的-还款记录
	 * @author 刘利   
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午4:22:32
	 */
	@RequestMapping(value="/loanRepayend",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loanRepayend(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ;
	  
		long applyId	 =  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID  
		 
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("applyId",applyId);
		param.put("skey",DbKeyUtil.GetDbCodeKey());
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<LoanRepay> list = imyLoanService.loanRepay(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 还款管理-待还计划
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午4:30:32
	 */
	@RequestMapping(value="/stayStillPlans",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String stayStillPlans(HttpServletRequest request){ 
		
		int start  = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ;
		
		long[] lMemberInfo = new long[2] ;		
	    MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]); 
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<StayStillPlan> list = imyLoanService.stayStillPlans(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 还款管理-还款中的借款
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 上午9:48:42
	 */
	@RequestMapping(value="/repayManagementin",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String repayManagementin(HttpServletRequest request){
		
		int start        = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       = IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		long[] lMemberInfo = new long[2] ;		
	   
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]); 
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<RepaymentOfBorrowings> list = imyLoanService.RepaymentOfBorrowings(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity,SerializerFeature.WriteMapNullValue); 
	}
	
	
	/**
	 * 还款管理-还款中的借款-还款计划
	 * @author 刘利   
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午5:51:34
	 */
	@RequestMapping(value="/RMrepayPlan",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String RMrepayPlan(HttpServletRequest request){
		
		int start        =  IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length       =  IntegerAndString.StringToInt(request.getParameter("length"),10) ;
		long applyId	 =  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID  
		
		long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("memberId", lMemberInfo[0]);
		param.put("applyId",  applyId);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<RepaymentOfBorrowingsRM> list = imyLoanService.LoanRements(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 提前还款详情
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午2:54:42
	 */
	@RequestMapping(value="/getAdvanceReplay",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAdvanceReplay(HttpServletRequest request) { 
		
		long applyId	=  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID  
		AdvanceEntity advanceEntity = imyLoanService.getAdvanceReplay(applyId);
	
		return JSONObject.toJSONString(advanceEntity);
		
	}
	
	
	
	/**
	 * 正常还款详情
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午2:54:42
	 */
	@RequestMapping(value="/ReplayDetail_{replyaID:[0-9]+}")
	@ResponseBody
	public String  ReplayDetail(HttpServletRequest request,@PathVariable long replyaID) { 
 
		long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		ReplayDetailEntity loanRepay =  imyLoanService.selectReplayDetail(replyaID,lMemberInfo[0],
				(int)lMemberInfo[1]); 
		return JSONObject.toJSONString(loanRepay);
		
	}
	 
	
	/**
	 * 我的借款-投资记录
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午5:55:46
	 */
	@RequestMapping(value="/investRecord",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String investRecord(HttpServletRequest request){
		
		int start       =  IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length      =  IntegerAndString.StringToInt(request.getParameter("length"),10) ;
		long applyId	=  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID  
		 
		PageEntity pageEntity    = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("applyId", applyId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<InvestmentRecord> list = imyLoanService.investRecord(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	
	/**
	 * 点击提前还款确认
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午4:50:07
	 */
	@RequestMapping(value="/AdvcancePost_{sprojectId:[0-9]+}") 
	public String AdvcancePost(HttpServletRequest request,@PathVariable long sprojectId){
		 
	 	long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		long lonmemberId   =  lMemberInfo[0];
		int  lonmembertype =  (int) lMemberInfo[1];
		int[] results       =  new int[1];
		RepayInterfaceEntity entity = repaymentInterfaceServer
				.EarlyRepaymentProcessing(lonmemberId, lonmembertype, sprojectId, results);
		LoanTransferEntity loanEntity = repaymentInterfaceServer.earlyRepaymentSubm(entity,request,"loanManagement/ReplayCallBackReturn.html","loanManagement/ReplayCallBackNotify.html");
		if(results[0] == 0){
		    request.setAttribute("loanTransferEntity", loanEntity);
		}else if(results[0] == -1) {
			request.setAttribute("message", "该项目已结清");
			return "account/loanManagement/replayFalse";
		}else if(results[0] == -2) {
			request.setAttribute("message", "存在逾期未还的项目");
			return "account/loanManagement/replayFalse";
		}
	    return "dryLot/loantransfertest"; 
	}
	
	
	/**
	 * 还款页面返回
	 * @author 刘利   
	 * @param @param request
	 * @param @param response
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午5:25:50
	 */
	@RequestMapping(value="ReplayCallBackReturn")
	public String ReplayCallBackReturn(HttpServletRequest request,HttpServletResponse response) {
		String results = repaymentInterfaceServer.testRepaymentReturn(request,response);
		request.setAttribute("title", "还款");
		if(results == "SUCCESS" || results.equals("SUCCESS")){
			request.setAttribute("detail", "还款成功"); 
			return "account/loanManagement/optionSuccess";
		}else{
			request.setAttribute("detail", "还款失败");
			return "account/loanManagement/optionFall";
		} 
	}
	
	
	/**
	 * 还款后台返回
	 * @author 刘利   
	 * @param @param request
	 * @param @param response 设定文件 
	 * @return void 返回类型 
	 * @date 2016-5-3 下午5:43:27
	 */
	@RequestMapping(value="ReplayCallBackNotify",produces = "text/html;charset=UTF-8")
	public void ReplayCallBackNotify(HttpServletRequest request,HttpServletResponse response){
		repaymentInterfaceServer.testRepaymentNotify(request,response);
	}
	
	
	
	/**
	 * 正常还款
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午5:49:59
	 */
	@RequestMapping(value="/RepaymentPost",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String RepaymentPost(HttpServletRequest request){
		
		long applyId	=  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID 
		long repalyId	=  IntegerAndString.StringToLong(request.getParameter("repalyId"), 0);	//还款计划ID 
	 	long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);  
		long lonmemberId   =  lMemberInfo[0];
		int  lonmembertype =  (int) lMemberInfo[1];
		int[] results       =  new int[1];
		
		RepayInterfaceEntity entity = repaymentInterfaceServer.RepaymentProcessing
				(lonmemberId, lonmembertype, applyId, repalyId, results); 
		LoanTransferEntity loanEntity = repaymentInterfaceServer.earlyRepaymentSubm(entity,request,"loanManagement/ReplayCallBackReturn.html","loanManagement/ReplayCallBackNotify.html");
		if(results[0] == 0){
		    request.setAttribute("loanTransferEntity", loanEntity);
		}else if(results[0] == 1) {
			request.setAttribute("message", "还款中");
			return "account/loanManagement/replayFalse";
		}else if(results[0] == 3) {
			request.setAttribute("message", "已还款");
			return "account/loanManagement/replayFalse";
		}
	    return "dryLot/loantransfertest";
		
	}
	
	
	
	/**
	 * 查询该会员的自动还款设置
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/MemberIsOpenAutoPay")
	@ResponseBody
	public String MemberIsOpenAutoPay(HttpServletRequest request) {
		
		long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);   
		MemberThirdAuthInfoEntity entity = imyLoanService.
				selectMemberIsOpenAutoPay(lMemberInfo[0], (int)lMemberInfo[1]);
	    return JSONObject.toJSONString(entity);
	}
	
	@RequestMapping("/autoRepay")
	public String autoRepay(HttpServletRequest request) {
		long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo);   
		MemberThirdAuthInfoEntity entity = imyLoanService.
				selectMemberIsOpenAutoPay(lMemberInfo[0], (int)lMemberInfo[1]);
		request.setAttribute("thirdAuthInfo", entity);
		return "account/loanManagement/autoRepay";
	}
	
	/**
	 * 修改自动还款设置
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:48:46
	 */
	@RequestMapping(value="/updateIsAutoPay",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateIsAutoPay(HttpServletRequest request) {
		
		int statu	    =  IntegerAndString.StringToInt(request.getParameter("statu"), 0);	//自动投标状态 
		long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("memberID",   lMemberInfo[0]);
		map.put("memberType", lMemberInfo[1]);
		map.put("statu",               statu);
		int result = imyLoanService.updateIsAutoPay(map);
        Map<String,Object> message = new HashMap<String, Object>(); 
		message.put("result", result);
		if(result == 1) {
		  message.put("message", "设置成功");
		}else {
		  message.put("message", "设置失败");
		}
		return JSONObject.toJSONString(message);  
	}
	
	/**
	 * 自动还款授权
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 ActivitiesProjectEntity
	 * @date 2016-5-3 下午8:58:18
	 */
	@RequestMapping(value="/openAutoPay") 
	public String openAutoPay(HttpServletRequest request){
		
		AuthorizeInterfaceEntity entity = new AuthorizeInterfaceEntity();
		MemberInfo memberInfo = (MemberInfo)request.getSession().getAttribute(Constant.LOGINUSER);
 		entity.setMemberId(memberInfo.getId());
 		entity.setMemberType(memberInfo.getMemberType());  
		entity.setAuthorizeTypeOpen("2"); 
		interfaceServerTestI.testLoanAuthorize(entity,"personalCenter/authorizedCallBackPage.html","personalCenter/authorizedCallBack.html",request);
		request.setAttribute("accountInterfaceEntity", entity);
		return "dryLot/loanauthorizetest";
		
	}
	 
	/**
	 * 借款人确认详情
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午2:54:42
	 */
 	@RequestMapping(value="/confirmationLoanInfo_{applyIds:[0-9]+}",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String  confirmationLoanInfo(HttpServletRequest request,@PathVariable long applyIds) { 

	 
		long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		
		ComfirLoanInfo LoanInfo =  imyLoanService.confirmationLoanInfo(lMemberInfo[0],applyIds); 
		return JSONObject.toJSONString(LoanInfo);
		
	}
	
	/**
	 * 借款人确认
	 * @author 刘利   
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-12 下午6:00:42
	 */
	@RequestMapping(value="confirmationLoan",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String confirmationLoan(HttpServletRequest request) { 
		
		long applyId	    =  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);//项目申请ID
		int optionvalue	    =  IntegerAndString.StringToInt(request.getParameter("optionvalue"), 0);//操作  -1取消  2确认
		int sysId	        =  IntegerAndString.StringToInt(request.getParameter("sysId"), 0);//0前台确认  1短信确认
		long[] lMemberInfo = new long[2] ;	 
		MemberSessionMng.GetLoginMemberInfo(request,lMemberInfo); 
		int  info= imyLoanService.confirmationLoan(lMemberInfo[0],applyId,optionvalue,sysId);  
		Map<String,Object> message =  new HashMap<String, Object>();
		if(info == 1) {
			message.put("result",     info);
			message.put("message",   "成功");
		}else if(info == 0) {
			message.put("result",     info);
			message.put("message",   "失败");
		} 
		return JSONObject.toJSONString(message);
	} 
	@RequestMapping("/LR_financing")
	public String LR_financing() {
		return "account/loanManagement/LR_financing";
	}
	@RequestMapping("/LR_financed")
	public String LR_financed() {
		return "account/loanManagement/LR_financed";
	}
	@RequestMapping("/LR_repay")
	public String LR_repay() {
		return "account/loanManagement/LR_repay";
	}
	@RequestMapping("/LR_failure")
	public String LR_failure() {
		return "account/loanManagement/LR_failure";
	}
	@RequestMapping("/LR_clearing")
	public String LR_clearing() {
		return "account/loanManagement/LR_clearing";
	}
	@RequestMapping("/applyRecord")
	public String applyRecord() {
		return "account/loanManagement/applyRecord";
	}
	@RequestMapping("/TBC_apply")
	public String TBC_apply() {
		return "account/loanManagement/TBC_apply";
	}
	@RequestMapping("/repayPlan")
	public String repayPlan() {
		return "account/loanManagement/repayPlan";
	}
	@RequestMapping("/repayRecord")
	public String repayRecord(){
		return "account/loanManagement/repayRecord";
	}
	@RequestMapping("/repayManagement")
	public String repayManagement() {
		return "account/loanManagement/repayManagement";
	}
	@RequestMapping("/RM_repayPlan")
	public String RM_repayPlan() {
		return "account/loanManagement/RM_repayPlan";
	}
	/*@RequestMapping("/autoRepay")
	public String autoRepay() {
		return "account/loanManagement/autoRepay";
	}*/
}
