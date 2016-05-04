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

import com.alibaba.fastjson.JSONObject;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.membermng.model.AdvanceEntity;
import cn.membermng.model.Cleared;
import cn.membermng.model.ConfirmationLoan;
import cn.membermng.model.Financing;
import cn.membermng.model.FlowLabel;
import cn.membermng.model.InvestmentRecord;
import cn.membermng.model.LoanApplyRecord;
import cn.membermng.model.LoanRepay;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.RepaymentIn;
import cn.membermng.model.RepaymentOfBorrowings;
import cn.membermng.model.RepaymentOfBorrowingsRM;
import cn.membermng.model.StayStillPlan;
import cn.springmvc.service.IMyLoanService;
import cn.springmvc.util.MemberSessionMng;
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
	
	/**
	 * 我的借款-借款记录-融资中
	 * @author 刘利   
	 * @Description: TODO 
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
		PageUtil.ObjectToPage(pageEntity, list); 
	    return JSONObject.toJSONString(pageEntity); 
	}
	
	/**
	 * 我的借款-借款记录-融资结束
	 * @author 刘利   
	 * @Description: TODO 
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
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
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
	 * @Description: TODO 
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
	 * @Description: TODO 
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
	 * @Description: TODO 
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
	 * @Description: TODO 
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
	 * @Description: TODO 
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
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午4:22:32
	 */
	@RequestMapping(value="/repayRecord",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String repayRecord(HttpServletRequest request){
		
		int start = IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length = IntegerAndString.StringToInt(request.getParameter("length"),10) ;
	  
		long applyId	 =  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID  
		 
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("applyId",applyId);
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
	 * @Description: TODO 
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
	 * @Description: TODO 
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
		return JSONObject.toJSONString(pageEntity); 
	}
	/**
	 * 还款管理-还款中的借款-还款计划
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午5:51:34
	 */
	@RequestMapping(value="/RMrepayPlan",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
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
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午2:54:42
	 */
	@RequestMapping(value="/getAdvanceReplay",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAdvanceReplay(HttpServletRequest request) { 
		
		long applyId	=  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID  
		AdvanceEntity advanceEntity = imyLoanService.getAdvanceReplay(applyId);
		//平台收取违约金
		advanceEntity.setPenaltyPingTai(advanceEntity.getRepayPrincipal()*advanceEntity.getPenaltyPingTaiRate()/1000000); 
		//投资人收取违约金
		advanceEntity.setPenaltyInvest(advanceEntity.getRepayPrincipal()*advanceEntity.getPenaltyInvestRate()/1000000);
		//总的违约金
		advanceEntity.setPenaltyTotal(advanceEntity.getPenaltyPingTai()+advanceEntity.getPenaltyInvest());
		//总的还款金额
		advanceEntity.setReplayTotal(advanceEntity.getRepayInterest()+advanceEntity.getRepayPrincipal()
				+advanceEntity.getPenaltyTotal());
		
		return JSONObject.toJSONString(advanceEntity);
		
	}
	
	
	
	/**
	 * 正常还款详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午2:54:42
	 */
	@RequestMapping(value="/ReplayDetail",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String  ReplayDetail(HttpServletRequest request) { 
		
		long replyaID	    =  IntegerAndString.StringToLong(request.getParameter("replyaID"), 0);	//项目申请ID  
		LoanRepay loanRepay =  imyLoanService.selectReplayDetail(replyaID); 
		return JSONObject.toJSONString(loanRepay);
		
	}
	
	/**
	 * 自动还款 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午5:52:42
	 */
	@RequestMapping(value="/autoRepaySet",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public String autoRepaySet(HttpServletRequest request){
		return "account/loanManagement/autoRepay";
	}
	
	
	/**
	 * 我的借款-投资记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-29 下午5:55:46
	 */
	@RequestMapping(value="/investRecord",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String investRecord(HttpServletRequest request){
		
		int start       =  IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length      =  IntegerAndString.StringToInt(request.getParameter("length"),10) ;
		long applyId	=  IntegerAndString.StringToLong(request.getParameter("applyId"), 0);	//项目申请ID  
		 
		PageEntity pageEntity = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>();
		param.put("applyId", applyId);
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<InvestmentRecord> list = imyLoanService.investRecord(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity); 
	}
	
	@RequestMapping("/LR_financing")
	public String LR_financing(){
		return "account/loanManagement/LR_financing";
	}
	@RequestMapping("/LR_financed")
	public String LR_financed(){
		return "account/loanManagement/LR_financed";
	}
	@RequestMapping("/LR_repay")
	public String LR_repay(){
		return "account/loanManagement/LR_repay";
	}
	@RequestMapping("/LR_failure")
	public String LR_failure(){
		return "account/loanManagement/LR_failure";
	}
	@RequestMapping("/LR_clearing")
	public String LR_clearing(){
		return "account/loanManagement/LR_clearing";
	}
	@RequestMapping("/applyRecord")
	public String applyRecord(){
		return "account/loanManagement/applyRecord";
	}
	@RequestMapping("/TBC_apply")
	public String TBC_apply(){
		return "account/loanManagement/TBC_apply";
	}
	@RequestMapping("/repayPlan")
	public String repayPlan(){
		return "account/loanManagement/repayPlan";
	}
	@RequestMapping("/repayRecord")
	public String repayRecord(){
		return "account/loanManagement/repayRecord";
	}
	@RequestMapping("/repayManagement")
	public String repayManagement(){
		return "account/loanManagement/repayManagement";
	}
	@RequestMapping("/RM_repayPlan")
	public String RM_repayPlan(){
		return "account/loanManagement/RM_repayPlan";
	}
	@RequestMapping("/autoRepay")
	public String autoRepay(){
		return "account/loanManagement/autoRepay";
	}
}
