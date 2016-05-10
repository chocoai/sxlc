package cn.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.constant.Constant;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.BorrowingTypeInfo;
import cn.membermng.model.LoanCreditStatisticsEntity;
import cn.membermng.model.MemberInfo;
import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.LoanMemberInfoEntity;
import cn.springmvc.model.LoanRepayEntity;
import cn.springmvc.model.ProjectAfterLoanAttachmentEntity;
import cn.springmvc.model.ProjectAfterLoanInfoEntity;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.service.AccountSupportService;
import cn.springmvc.service.CreditorTransInvestService;
import cn.springmvc.service.CreditorTransferService;
import cn.springmvc.service.GenerateRepayListService;
import cn.springmvc.service.IBorrowingCertificationServer;
import cn.springmvc.service.IMemberService;
import cn.springmvc.service.InvestListService;
import cn.springmvc.service.ManagedInterfaceServerTestI;
import cn.springmvc.service.PostLoanManageService;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.service.ProjectInvestService;
import cn.springmvc.service.RecordsBalanceService;
import cn.springmvc.service.projectDetailService;
import cn.sxlc.account.manager.model.LoanTransferEntity;
import cn.sxlc.account.manager.model.UnUsedRedpacketsEntity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/***
* 
* 投资专区信息
* 
* @author 李杰
* @since 
* @date 2016-4-27 下午2:03:14 
*
*/
@Controller
@RequestMapping("invest")
public class InvestController {
	
	private Logger logger = Logger.getLogger(InvestController.class);
	
	@Autowired
 	private InvestListService investListService;
	
	@Autowired
	private projectDetailService detailService;
	
	@Autowired
	private ProjectBaseInfoService baseInfoService;
	
	@Autowired
	private ManagedInterfaceServerTestI interfaceServerTestI;
	
	@Autowired
	private AccountSupportService accountSupportService;
	
	@Autowired
	private ProjectInvestService projectInvestService;
	
	@Autowired
	private projectDetailService projectDetailService;
	
	@Autowired
	private RecordsBalanceService balanceService;
	
	@Autowired
	private PostLoanManageService loanManageService;
	
	@Autowired
	private GenerateRepayListService generateRepayListService;
	
	@Autowired
	private IBorrowingCertificationServer borrowingCertificationServer;
	
	@Autowired
	private IMemberService memberService;
	//---------------------------------债权
	@Autowired
	private CreditorTransferService creditorTransferService;
	
	@Autowired
	private CreditorTransInvestService creditorTransInvestService;
	
	
//===================================================================================
//
//		项目投资
//
//===================================================================================
		
	
	/***
	* 投资专区首页
	* <br>查询出广告列表 然后去页面显示
	* @author 李杰
	* @Title: investmentZone
	* @return
	* @date 2016-4-27 下午2:02:22
	 */
	@RequestMapping(value="/investmentZone",method=RequestMethod.GET)
 	public String investmentZone(HttpServletRequest req){
		//加载广告列表
		
		//查询出借款类型
		List<ProjectBaseInfoEntity> project = baseInfoService.selectProjectBaseInfoCombox();
		req.setAttribute("projectBaseInfos", project);
		return "invest/investmentZone";
	}

	/***
	* 根据条件查询投资列表
	* 
	* @author 李杰
	* @return
	* @date 2016-4-27 下午2:17:23
	 */
	@RequestMapping(value="fundList",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String fundList(HttpServletRequest request){
		String wd				=	request.getParameter("wd");						//赛选条件名称(项目名称)
		String projectStatu		= 	request.getParameter("projectStatu");			//项目状态
		String reward			=	request.getParameter("reward");					//奖励
		String loanType			=	request.getParameter("loanType");				//借款类型
		String annualInterest	=	request.getParameter("annualInterest");			//年利率
		String repayment 		=	request.getParameter("repayment");				//还款方式
		String deadlineType		= 	request.getParameter("deadlineType");			//借款期限
		String deadlinemin		= 	request.getParameter("deadlinemin");			//最小期限
		String deadlinemax		= 	request.getParameter("deadlinemax");			//最大期限
		int page				=	Integer.parseInt(request.getParameter("page"));	//页码
		
		PageEntity pageEntity = new PageEntity();
		Map<String,String> param =  new HashMap<String, String>();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(6);
		pageEntity.setMap(param);
		
		if(wd != null && wd.trim().length() > 0){
			param.put("projectinfo", wd);
		}
		
		param.put("investStatu", projectStatu);
		param.put("reward", reward);
		param.put("projectType", loanType);
		if(annualInterest.equals("-1")){
			param.put("yearratemin", "-1");
		}else if(annualInterest.equals("8")){
			param.put("yearratemin", "0");
			param.put("yearratemax", "8");
		}else if(annualInterest.equals("8-12")){
			param.put("yearratemin", "8");
			param.put("yearratemax", "12");
		}else if(annualInterest.equals("12")){
			param.put("yearratemin", "12");
		}
		param.put("deadlinemin", deadlinemin);
		param.put("deadlinemax", deadlinemax);
		
		param.put("deadlineType", deadlineType);
		param.put("repayment", repayment);
		List<ProjectAppRecordEntity> list = investListService.selectInvestList(pageEntity);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", pageEntity.getPageNum());
		result.put("pageSize", pageEntity.getPageSize());
		result.put("tol", pageEntity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	* 投资详细信息
	* 
	* @author 李杰
	* @return
	* @date 2016-4-27 下午4:01:48
	 */
	@RequestMapping("/investmentDetail/{sprojectId:[0-9]+}")
	public String investmentDetail(HttpServletRequest request,@PathVariable long sprojectId){
		//借款项目信息
		ProjectAppRecordEntity appRecordEntity = detailService.selectProjectDetailByID(sprojectId);
		request.setAttribute("appRecordEntity", appRecordEntity);
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		if(memberInfo != null){//------------已登录
			//查询出可投金额
			long sumAount = projectInvestService.GetMaxInvestAmount(sprojectId, memberInfo.getId(), DbKeyUtil.GetDbCodeKey(),(short)0);
			
			//查询出代金券
			long vouchers = accountSupportService.getRemainderVouchers(memberInfo.getId());
			String sVouchers = IntegerAndString.LongToString(vouchers);
			
			//查询出红包
			List<UnUsedRedpacketsEntity> redPackList = accountSupportService.getMemberUnUsedRedPackets(memberInfo.getId());
			
			//查询红包使用比例
			int proportion = projectInvestService.GetRedpacketsInvestRate();
		
			request.setAttribute("sSumAount", sumAount);
			request.setAttribute("userBalances", IntegerAndString.LongToString(memberService.getRemainderTotal(memberInfo.getId())));
			request.setAttribute("sVouchers", sVouchers); 
			request.setAttribute("redPackList", redPackList);
			request.setAttribute("redPackCount", redPackList.size());
			request.setAttribute("proportion", proportion);
		}
		//借款人基本信息
		LoanMemberInfoEntity projectMemberInfo = projectDetailService.selectMemberInfo(sprojectId);
		request.setAttribute("projectMemberInfo", projectMemberInfo);
		
		//统计信息
		LoanCreditStatisticsEntity creditStatisticsEntity =	balanceService.selectLoanCreditStatistics(projectMemberInfo.getMemberID());
		request.setAttribute("creditStatisticsEntity", creditStatisticsEntity);
		
		//认证信息
		List<BorrowingTypeInfo> borrowingList = borrowingCertificationServer.getAllByMemberAndLoanType(sprojectId);
		request.setAttribute("borrowingList", borrowingList);

		//获取系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		request.setAttribute("sysTime", sdf.format(new Date()));
		
		//判断项目状态、如果项目融资状态为0、开标时间大于当前时间即为预热中，就会有个预热倒计时
		try {
			Date startTime 	= sdf.parse(appRecordEntity.getStartDate());		//项目开标时间
			Date cTime 		= new Date();										//系统当前时间
			Date endTime 	= sdf.parse(appRecordEntity.getEndDate());			//投资最晚时间
			
			
			//真是TM郁闷,这也不晓得那也不晓得
			//重新定义项目状态
			if(appRecordEntity.getInvestStatu() == 0 && startTime.after(cTime)){
				//预热中
				request.setAttribute("investmentStatus", "1");
				request.setAttribute("endTime", sdf.format(startTime));
			}else if(appRecordEntity.getInvestStatu() == 0 && startTime.after(cTime) && appRecordEntity.getInvestRate() < 1000000){
				//投标中(融资中)
				request.setAttribute("investmentStatus", "2");
				request.setAttribute("endTime", sdf.format(endTime));
			}else if(appRecordEntity.getInvestStatu() == 2 || (appRecordEntity.getInvestStatu() == 0 && appRecordEntity.getInvestRate() >= 1000000)
					|| (appRecordEntity.getCheckStatu() == 1 && appRecordEntity.getPublishStatu() == 2 && appRecordEntity.getInvestStatu() == 0 && (endTime.after(cTime) || endTime.equals(cTime)))){
				//投标完成
				request.setAttribute("investmentStatus", "5");
				request.setAttribute("endTime",sdf.parse(appRecordEntity.getHoldDate()));	//放款时间
			}else if(appRecordEntity.getInvestStatu() == 1 || appRecordEntity.getInvestStatu() == -3){
				//流标
				request.setAttribute("investmentStatus", "6");
				request.setAttribute("endTime", sdf.format(endTime));
			}else if(appRecordEntity.getCheckStatu() == -1){
				//申请失败s
				request.setAttribute("investmentStatus", "7");
				request.setAttribute("endTime", sdf.format(endTime));
			}else if(appRecordEntity.getInvestStatu() == 3 || appRecordEntity.getInvestStatu() == 4){
				//还款中 Or 已结清
				request.setAttribute("investmentStatus", appRecordEntity.getInvestStatu());
				request.setAttribute("endTime",sdf.parse(appRecordEntity.getHoldDate()));	//放款时间
			}else{
				request.setAttribute("investmentStatus", appRecordEntity.getInvestStatu());
				request.setAttribute("endTime",sdf.parse(appRecordEntity.getHoldDate()));	//放款时间
			}
		} catch (Exception e) {
			request.setAttribute("investmentStatus", "0");
			logger.error("投标计算投标开始(结束)时间异常->投标名为："+appRecordEntity.getProjectName()+",开始时间为："+appRecordEntity.getStartDate()+",结束时间为："+appRecordEntity.getEndDate());
		}
		return "invest/investmentDetail";
	}

	
	/***
	* 投资获取账户信息
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 上午10:23:11
	 */
	@RequestMapping("/accountInfo/{projectId:[0-9]+}")
	@ResponseBody
	public String accountInfo(HttpServletRequest request,@PathVariable long projectId){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		Map<String,Object> result = new HashMap<String,Object>();
		if(memberInfo == null){
			result.put("sSumAount", "0.00");
			result.put("sVouchers", "0.00");
			result.put("redPackList", "[]");
			result.put("userBalances", "0.00");
			result.put("proportion", "");
		}else{
			//查询出可投金额
			long sumAount = projectInvestService.GetMaxInvestAmount(projectId, memberInfo.getId(), DbKeyUtil.GetDbCodeKey(),(short)0);
			/*//查询出可用余额
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("memberID", memberInfo.getId());
			param.put("memberType", memberInfo.getMemberType());
			MemberThirdAuthInfoEntity authInfoEntity = balanceService.selectMemberThirdAuthInfo(param);*/
			
			//查询出代金券
			long vouchers = accountSupportService.getRemainderVouchers(memberInfo.getId());
			String sVouchers = IntegerAndString.LongToString(vouchers);
			
			//查询出红包
			List<UnUsedRedpacketsEntity> redPackList = accountSupportService.getMemberUnUsedRedPackets(memberInfo.getId());
			
			//查询红包使用比例
			int proportion = projectInvestService.GetRedpacketsInvestRate();
			result.put("sSumAount", sumAount);
			result.put("sVouchers", sVouchers);
			result.put("redPackList", redPackList);
			result.put("userBalances", IntegerAndString.LongToString(memberService.getRemainderTotal(memberInfo.getId())));
			result.put("proportion", proportion);
		}
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}  
	
	
	/***
	* 风控措施
	* 
	* @author 李杰
	* @Title: riskManagement
	* @return
	* @date 2016-4-29 下午1:46:05
	 */
	@RequestMapping(value="riskManagement/{projectId:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String riskManagement(HttpServletRequest request,@PathVariable long projectId){
		List<ProjectCheckAttachEntity> list = projectDetailService.selectProjectCheckAttach(projectId);
		String	projectDetall = projectDetailService.selectProjectDescript(projectId);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("info", list);
		param.put("detail", projectDetall);
		return JSONObject.toJSONString(param,SerializerFeature.WriteMapNullValue);
	}
	
	/***
	* 获取某个项目的还款计划信息
	* 
	* @author 李杰
	* @Title: repaymentPlan
	* @return
	* @date 2016-4-29 下午1:56:22
	 */
	@RequestMapping(value="repaymentPlan/{sProjectId:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String repaymentPlan(HttpServletRequest request,@PathVariable String sProjectId){
		long projectId = 0;
		try {
			projectId = Long.parseLong(sProjectId);
		} catch (Exception e) {
			return null;
		}
		List<LoanRepayEntity> list = detailService.selectReplayByProjectID(projectId);
		return JSONObject.toJSONString(list,SerializerFeature.WriteMapNullValue);
	}
	
	/***
	* 获取投资记录
	* 
	* @author 李杰
	* @param request
	* @param sProjectId
	* @return
	* @date 2016-4-29 下午2:08:34
	 */
	@RequestMapping(value="investmentList/{sProjectId:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String investmentList(HttpServletRequest request,@PathVariable String sProjectId){
		long projectId = 0;
		try {
			projectId = Long.parseLong(sProjectId);
		} catch (Exception e) {
			return null;
		}
		List<InvestEntity> list = detailService.selectInvestRecordByProjectID(projectId);
		ProjectAppRecordEntity appRecordEntity = projectDetailService.selectInvestAvailableaAmount(projectId);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("info", list);
		param.put("availableAmount", appRecordEntity.getAvailableaAmounts());
		param.put("investTotals", appRecordEntity.getInvestTotals());
		param.put("shenYuKeTou", IntegerAndString.LongToString(appRecordEntity.getAvailableaAmount()-appRecordEntity.getInvestTotal()));
		return JSONObject.toJSONString(param,SerializerFeature.WriteMapNullValue);
	}
	
	/***
	* 获取项目历程
	* 
	* @author 李杰
	* @param request
	* @param sProjectId
	* @return
	* @date 2016-4-29 下午2:08:57
	 */
	@RequestMapping(value="projectCourse/{sProjectId:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String projectCourse(HttpServletRequest request,@PathVariable String sProjectId){
		long projectId = 0;
		try {
			projectId = Long.parseLong(sProjectId);
		} catch (Exception e) {
			return null;
		}
		ProjectAppProcessEntity appProcessEntity = projectDetailService.selectProjectAppProcess(projectId);
		return JSONObject.toJSONString(appProcessEntity,SerializerFeature.WriteMapNullValue);
	}
	
	/***
	* 贷后监管
	* 
	* @author 李杰
	* @return
	* @date 2016-5-3 下午1:52:17
	*/
	@RequestMapping(value="postLoanSupervision/{projectId:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String postLoanSupervision(HttpServletRequest request,@PathVariable long projectId){
		List<ProjectAfterLoanInfoEntity> list = loanManageService.selectProjectAfterLoanFront(projectId);
		return JSONObject.toJSONString(list,SerializerFeature.WriteMapNullValue);
	}
	
	/***
	* 贷后监管详细信息
	* 
	* @author 李杰
	* @param request
	* @param detailId
	* @return
	* @date 2016-5-3 下午2:23:01
	 */
	@RequestMapping(value="postLoanSupervisionDetail/{detailId:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String postLoanSupervisionDetail(HttpServletRequest request,@PathVariable long detailId){
		List<ProjectAfterLoanAttachmentEntity> list = loanManageService.selectProjectAfterLoanAttach(detailId);
		return JSONObject.toJSONString(list,SerializerFeature.WriteMapNullValue);
	}
	
	/***
	* 获取投资预计收益
	* 
	* @author 李杰
	* @return
	* @date 2016-5-3 上午10:08:23
	 */
	@RequestMapping(value="revenuePlan",method=RequestMethod.POST)
	@ResponseBody
	public String revenuePlan(HttpServletRequest request){
		long proId = IntegerAndString.StringToLong(request.getParameter("proId"), 0);
		long amount= IntegerAndString.StringToLong(request.getParameter("amount"));
		long profit= generateRepayListService.GetForecastIncome(proId, amount);
		String sProfit = IntegerAndString.LongToString(profit);
		return sProfit;
	}
	
	
	/***
	* 会员借款投资
	* 
	* @author 李杰
	* @return
	* @date 2016-4-29 下午1:38:37
	*/
	@RequestMapping(value="/memberInvestment",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String memberInvestment(HttpServletRequest request){
		try {
			String sprojectId = request.getParameter("projectId");					//项目编号
			String sAmount	  = request.getParameter("lAmount");					//投资金额
			String slVouchers = request.getParameter("slVouchers");					//使用代金券金额
			String sDirectPwd = request.getParameter("sDirectPwd");					//定向标密码
			String redPacks	  = request.getParameter("redPacks");					//红包编号集合
			
			long projectId = Long.parseLong(sprojectId);
			MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
			long lAmount   = IntegerAndString.StringToLong(sAmount);
			long lVouchers = IntegerAndString.StringToLong(slVouchers);
			LoanTransferEntity entity = interfaceServerTestI.PreInvestmentTreatment(projectId, memberInfo.getId(), (short)0, lAmount, redPacks, lVouchers, sDirectPwd,(short)0);
			request.setAttribute("loanTransferEntity", entity);
			if(entity.getStatu() == 0){		//成功
				return "dryLot/loantransfertest";
			}else{							//失败
				request.setAttribute("message", entity.getMassage());
				return "invest/investFalse";
			}
		} catch (Exception e) {//转换参数出错!不响应
			e.printStackTrace();
		}
		return "invest/investFalse";
	}
	
	
	/**
	* 债权转让列表
	* 
	* @author 李杰
	* @Title: debtCession
	* @return
	* @date 2016-4-29 下午1:54:08
	 */
	@RequestMapping("/debtCession")
	public String debtCession(HttpServletRequest request){
		
		//加载广告列表

		//查询出借款类型
		List<ProjectBaseInfoEntity> project = baseInfoService.selectProjectBaseInfoCombox();
		request.setAttribute("projectBaseInfos", project);
		return "invest/debtCession";
	}
	
	
	/***
	* 债权列表
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 下午1:51:40
	 */
	@RequestMapping(value="loanList",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loanList(HttpServletRequest request){
		String wd				=	request.getParameter("wd");						//赛选条件名称(项目名称)
		String projectStatu		= 	request.getParameter("projectStatu");			//项目状态
		String projectType		=	request.getParameter("loanType");				//借款类型
		String annualInterest	=	request.getParameter("annualInterest");			//年利率
		String repayment 		=	request.getParameter("repayment");				//还款方式
		String deadlineType		= 	request.getParameter("deadlineType");			//借款期限
		String deadlinemin		= 	request.getParameter("deadlinemin");			//最小期限
		String deadlinemax		= 	request.getParameter("deadlinemax");			//最大期限
		int page				=	Integer.parseInt(request.getParameter("page"));	//页码
		
		PageEntity pageEntity = new PageEntity();
		Map<String,String> param =  new HashMap<String, String>();
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(6);
		pageEntity.setMap(param);
		
		if(wd != null && wd.trim().length() > 0){
			param.put("projectinfo", wd);
		}
		
		param.put("investStatu", projectStatu);
		param.put("projectType", projectType);
		if(annualInterest.equals("-1")){
			param.put("yearratemin", "-1");
		}else if(annualInterest.equals("8")){
			param.put("yearratemin", "0");
			param.put("yearratemax", "8");
		}else if(annualInterest.equals("8-12")){
			param.put("yearratemin", "8");
			param.put("yearratemax", "12");
		}else if(annualInterest.equals("12")){
			param.put("yearratemin", "12");
		}
		param.put("deadlinemin", deadlinemin);
		param.put("deadlinemax", deadlinemax);
		
		param.put("deadlineType", deadlineType);
		param.put("repayWay", repayment);
		
		List<CreditorTransferListEntity> list = creditorTransferService.selectCreditorTransferList(pageEntity);
		
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("cpage", pageEntity.getPageNum());
		result.put("pageSize", pageEntity.getPageSize());
		result.put("tol", pageEntity.getRecordsTotal());
		result.put("infos", list);
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}
	
	
	/***
	* 债权详情
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 下午2:21:28
	*/
	@RequestMapping("/debtDetail/{ctaId:[0-9]+}")
	public String debtDetail(HttpServletRequest request,@PathVariable long ctaId){
		CreditorTransferListEntity creditorTransferListEntity =	creditorTransferService.selectCreditorTransferDetail(ctaId);
		if(creditorTransferListEntity == null){
			return "invest/debtDetail";
		}else{
			request.setAttribute("creditorTransferListEntity", creditorTransferListEntity);
			//借款人基本信息
			LoanMemberInfoEntity projectMemberInfo = projectDetailService.selectMemberInfo(creditorTransferListEntity.getApplyId());
			request.setAttribute("projectMemberInfo", projectMemberInfo);
			
			//统计信息
			LoanCreditStatisticsEntity creditStatisticsEntity =	balanceService.selectLoanCreditStatistics(projectMemberInfo.getMemberID());
			request.setAttribute("creditStatisticsEntity", creditStatisticsEntity);
			
			//认证信息
			List<BorrowingTypeInfo> borrowingList = borrowingCertificationServer.getAllByMemberAndLoanType(creditorTransferListEntity.getApplyId());
			request.setAttribute("borrowingList", borrowingList);
			
			//查询出本次可投金额
			
			MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
			if(memberInfo != null){
				//查询出代金券
				long vouchers = accountSupportService.getRemainderVouchers(memberInfo.getId());
				String sVouchers = IntegerAndString.LongToString(vouchers);
				
				//查询出红包
				List<UnUsedRedpacketsEntity> redPackList = accountSupportService.getMemberUnUsedRedPackets(memberInfo.getId());
				
				//查询出会员总余额
				request.setAttribute("userBalances", IntegerAndString.LongToString(memberService.getRemainderTotal(memberInfo.getId())));
				request.setAttribute("sVouchers", sVouchers);
				request.setAttribute("redPackList", redPackList);
				request.setAttribute("redPackCount", redPackList.size());
			}
			
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date maxTime 	= sdf.parse(creditorTransferListEntity.getEndDate());						//债权到期时间
				Date now 		= new Date();
				//重新定义债权状态
				if(creditorTransferListEntity.getTransStatu() == 0){
					//投标中
					request.setAttribute("investmentStatus", "0");
					request.setAttribute("endTime", sdf.format(maxTime));
				}else if(creditorTransferListEntity.getTransStatu() == 1 || creditorTransferListEntity.getTransStatu() == -1){
					//流标
					request.setAttribute("investmentStatus", "1");
					request.setAttribute("endTime", sdf.format(maxTime));
				}else if(creditorTransferListEntity.getTransStatu() == 2 || 
							(creditorTransferListEntity.getTransStatu() == 0 && (creditorTransferListEntity.getCtaInvestRate() >= 1000000 || (maxTime.after(now) || maxTime.equals(now))))){
					//投标完成
					request.setAttribute("investmentStatus", "2");
					request.setAttribute("endTime", sdf.format(maxTime));
				}else if(creditorTransferListEntity.getTransStatu() == 3 || creditorTransferListEntity.getTransStatu() == 4){
					//还款中  Or 已结清
					request.setAttribute("investmentStatus", creditorTransferListEntity.getTransStatu());
					request.setAttribute("endTime", sdf.format(maxTime));
				}else{
					request.setAttribute("investmentStatus", creditorTransferListEntity.getTransStatu());
					request.setAttribute("endTime", sdf.format(maxTime));
				}
				
			} catch (Exception e) {
				request.setAttribute("investmentStatus", 2);
				logger.error("投标计算债权到期时间(结束)时间异常->债券名为："+creditorTransferListEntity.getProjectTitle()+",结束时间为："+creditorTransferListEntity.getEndDate());
				request.setAttribute("investmentStatus", 0);
			}		
			
			return "invest/debtDetail";
		}
	}
	
	/***
	* 债权投资获取账户信息
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 上午10:23:11
	 */
	@RequestMapping("/accountInfos/{projectId:[0-9]+}/{ctid:[0-9]+}")	
	@ResponseBody
	public String accountInfos(HttpServletRequest request,@PathVariable long projectId,@PathVariable long ctid){
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		Map<String,Object> result = new HashMap<String,Object>();
		if(memberInfo == null){
			result.put("sSumAount", "0.00");
			result.put("sVouchers", "0.00");
			result.put("redPackList", "[]");
			result.put("userBalances", "0.00");
			result.put("proportion", "");
		}else{
			//查询出可投金额
			long sumAount = creditorTransInvestService.getCreditorMaxInvestAmount(projectId, memberInfo.getId(), ctid, DbKeyUtil.GetDbCodeKey());
					//projectInvestService.GetMaxInvestAmount(projectId, memberInfo.getId(), DbKeyUtil.GetDbCodeKey(),(short)0);
			/*//查询出可用余额
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("memberID", memberInfo.getId());
			param.put("memberType", memberInfo.getMemberType());
			MemberThirdAuthInfoEntity authInfoEntity = balanceService.selectMemberThirdAuthInfo(param);*/
			
			//查询出代金券
			long vouchers = accountSupportService.getRemainderVouchers(memberInfo.getId());
			String sVouchers = IntegerAndString.LongToString(vouchers);
			
			//查询出红包
			List<UnUsedRedpacketsEntity> redPackList = accountSupportService.getMemberUnUsedRedPackets(memberInfo.getId());
			
			//查询红包使用比例
			int proportion = projectInvestService.GetRedpacketsInvestRate();
			result.put("sSumAount", sumAount);
			result.put("sVouchers", sVouchers);
			result.put("redPackList", redPackList);
			result.put("userBalances", IntegerAndString.LongToString(memberService.getRemainderTotal(memberInfo.getId())));
			result.put("proportion", proportion);
		}
		return JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
	}  
	
	/***
	* 债权投资
	* 
	* @author 李杰
	* @return
	* @date 2016-5-9 下午7:11:11
	*/
	@RequestMapping(value="debtInvestment",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String debtInvestment(HttpServletRequest request){
		MemberInfo memberInfo 		= (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		long projectId				= IntegerAndString.StringToLong(request.getParameter("projectId"),-1);
		long lCreditorTransAppId	= IntegerAndString.StringToLong(request.getParameter("lCreditorTransAppId"), -1);
		long lAmount				= IntegerAndString.StringToLong(request.getParameter("lAmount"));
		String	sRedPacketsInfo		= request.getParameter("sRedPacketsInfo");
		long lVouchers				= IntegerAndString.StringToLong(request.getParameter("lVouchers"));
		LoanTransferEntity loanTran = interfaceServerTestI.TransferOfCreditorsRights(projectId, memberInfo.getId(), lCreditorTransAppId, (short)0, lAmount, sRedPacketsInfo, lVouchers, (short)0);
		request.setAttribute("loanTransferEntity", loanTran);
		if(loanTran.getStatu() == 0){		//成功
			return "dryLot/loantransfertest";
		}else{							//失败
			request.setAttribute("message", loanTran.getMassage());
			return "invest/investFalse";
		}
	}
	
	/***
	* 债权投资回调
	* 
	* @author 李杰
	* @date 2016-5-9 下午9:16:08
	 */
	@RequestMapping("debtInvestmentBack")
	public void debtInvestmentBack(HttpServletRequest request,HttpServletResponse response){
		interfaceServerTestI.TransferOfCreditorsInvest(request, response);
	}
	
	
	
	
	/***
	* 债权投资记录
	* 
	* @author 李杰
	* @return
	* @date 2016-5-5 下午3:16:22
	*/
	@RequestMapping(value="debtsInvestmentRecord/{ctaId:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String debtsInvestmentRecord(HttpServletRequest request,@PathVariable long ctaId){
		List<InvestEntity> list = creditorTransferService.selectCreditorInvestRecordByctaId(ctaId);
		
		CreditorTransferListEntity appRecordEntity = creditorTransferService.selectCreditorAvailableaAmount(ctaId);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("info", list);
		param.put("availableAmount", appRecordEntity.getAvailableaAmounts());
		param.put("investTotals", appRecordEntity.getInvestTotals());
		param.put("shenYuKeTou", IntegerAndString.LongToString(appRecordEntity.getAvailableaAmount()-appRecordEntity.getInvestTotal()));
		return JSONObject.toJSONString(param,SerializerFeature.WriteMapNullValue);
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/projectDetail")
	public String projectDetail(){
		return "invest/projectDetail";
	}
	@RequestMapping("/riskControl")
	public String riskControl(){
		return "invest/riskControl";
	}
	@RequestMapping("/repaymentPlan")
	public String repaymentPlan(){
		return "invest/repaymentPlan";
	}
	@RequestMapping("/investmentList")
	public String investmentList(){
		return "invest/investmentList";
	}
	@RequestMapping("/projectCourse")
	public String projectCourse(){
		return "invest/projectCourse";
	}
	@RequestMapping("/postLoanSupervision")
	public String postLoanSupervision(){
		return "invest/postLoanSupervision";
	}
	@RequestMapping("/proDetail")
	public String proDetail(){
		return "invest/proDetail";
	}
	@RequestMapping("/riskCtrl")
	public String riskCtrl(){
		return "invest/riskCtrl";
	}
	@RequestMapping("/repayArrang")
	public String repayArrang(){
		return "invest/repayArrang";
	}
	@RequestMapping("/proCourse")
	public String proCourse(){
		return "invest/proCourse";
	}
	@RequestMapping("/bidRecord")
	public String bidRecord(){
		return "invest/bidRecord";
	}
	@RequestMapping("/investSuccess")
	public String investSuccess(){
		return "invest/investSuccess";
	}
	@RequestMapping("/investFalse")
	public String investFalse(){
		return "invest/investFalse";
	}
}
