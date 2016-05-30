package cn.springmvc.controller;

import java.text.ParseException;
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

import product_p2p.kit.Upload.FtpClientUtil;
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
import cn.springmvc.model.LoanRealRepayEntity;
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
	
	private SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	
	
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
		
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.getSession().setAttribute("imgProfix", hostPath);//图片前缀
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
		Date cTime 		= new Date();										//系统当前时间
		//借款项目信息
		ProjectAppRecordEntity appRecordEntity = detailService.selectProjectDetailByID(sprojectId);
		if(appRecordEntity == null){return null;}					//借款项目为空
		request.setAttribute("appRecordEntity", appRecordEntity);
		
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		request.getSession().setAttribute("imgProfix", hostPath);//图片前缀
		
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
		
			request.setAttribute("sSumAount", IntegerAndString.LongToString(sumAount));
			request.setAttribute("userBalances", IntegerAndString.LongToString(memberService.getRemainderTotal(memberInfo.getId())));
			request.setAttribute("sVouchers", sVouchers); 
			request.setAttribute("redPackList", redPackList);
			request.setAttribute("redPackCount", redPackList.size());
			request.setAttribute("proportion", proportion);
		}
		//借款人基本信息、处理借款人信息
		LoanMemberInfoEntity projectMemberInfo = projectDetailService.selectMemberInfo(sprojectId);
		if(projectMemberInfo != null && projectMemberInfo.getPersonalName() != null && projectMemberInfo.getPersonalName().length() > 0){
			projectMemberInfo.setPersonalName(projectMemberInfo.getPersonalName().substring(0,1)+"**");
		}
		if(projectMemberInfo != null && projectMemberInfo.getPersonalPhone() != null && projectMemberInfo.getPersonalPhone().length() >= 11){
			projectMemberInfo.setPersonalPhone(projectMemberInfo.getPersonalPhone().substring(0,3)+" **** "+projectMemberInfo.getPersonalPhone().substring(8, 11));
		}
		if(projectMemberInfo != null && projectMemberInfo.getPersonalIdCard() != null){
			if(projectMemberInfo.getPersonalIdCard().length() == 18){
				String years  = projectMemberInfo.getPersonalIdCard().substring(6,10);
				String mothd  = projectMemberInfo.getPersonalIdCard().substring(10,12);
				String day	  = projectMemberInfo.getPersonalIdCard().substring(12,14);
				Date userBirthDay = null;
				try {
					userBirthDay = yyyy_MM_dd.parse(years+"-"+mothd+"-"+day);
				} catch (ParseException e) {
					logger.info("投资详情：计算借款人生日出现异常");
				}
				if(userBirthDay != null){
					long time = cTime.getTime()-userBirthDay.getTime();
					int age = (int) ((time)/1000/60/60/24/365);
					request.setAttribute("projectMemberInfoAge", age);
				}else{
					request.setAttribute("projectMemberInfoAge", 0);
				}
			}
		}
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
			Date endTime 	= sdf.parse(appRecordEntity.getEndDate());			//投资最晚时间
			
			logger.debug("项目开标时间："+sdf.format(startTime)+", 项目结束时间："+sdf.format(endTime)+",系统当前时间："+sdf.format(cTime));
			
			//重新定义项目状态
			//项目状态的等于投标中 并且项目开标时间大于当前时间  项目为预热中
			if(appRecordEntity.getInvestStatu() == 0 && startTime.after(cTime)){
				//预热中 
				request.setAttribute("investmentStatus", "1");
				request.setAttribute("endTime", sdf.format(startTime));
			//项目状态的等于投标中 开标时间大于当前时间 并且投资进度不为10%.10 并且 结束时间小于当前时间
			}else if(appRecordEntity.getInvestStatu() == 0 && startTime.before(cTime) && appRecordEntity.getInvestRate() < 1000000 && endTime.after(cTime)){
				//投标中(融资中)
				request.setAttribute("investmentStatus", "2");
				request.setAttribute("endTime", sdf.format(endTime));
			//项目状态等于投标完成 或者 
			}else if(appRecordEntity.getInvestStatu() == 2 || (appRecordEntity.getInvestStatu() == 0 && appRecordEntity.getInvestRate() >= 1000000)
					|| (appRecordEntity.getInvestStatu() == 0 && (endTime.before(cTime) || endTime.equals(cTime)))){
				//投标完成
				request.setAttribute("investmentStatus", "5");
				request.setAttribute("endTime", "");
				if(appRecordEntity.getHoldDate()!=null){
					request.setAttribute("endTime",sdf.format(sdf.parse(appRecordEntity.getHoldDate())));	//放款时间
				}else{
					request.setAttribute("endTime",sdf.format(endTime));									//放款时间
				}
			}else if(appRecordEntity.getInvestStatu() == 1 || appRecordEntity.getInvestStatu() == -3){
				//流标
				request.setAttribute("investmentStatus", "6");
				request.setAttribute("endTime", sdf.format(endTime));
			}else if(appRecordEntity.getCheckStatu() == -1){
				//申请失败
				request.setAttribute("investmentStatus", "7");
				request.setAttribute("endTime", sdf.format(endTime));
			}else if(appRecordEntity.getInvestStatu() == 3 || appRecordEntity.getInvestStatu() == 4){
				//还款中 Or 已结清
				request.setAttribute("investmentStatus", appRecordEntity.getInvestStatu());
				if(appRecordEntity.getHoldDate() != null){
					request.setAttribute("endTime",sdf.format(sdf.parse(appRecordEntity.getHoldDate())));	//放款时间
				}
			}else{
				request.setAttribute("investmentStatus", appRecordEntity.getInvestStatu());
				request.setAttribute("endTime",sdf.format(sdf.parse(appRecordEntity.getHoldDate())));	//放款时间
			}
		} catch (Exception e) {
			request.setAttribute("investmentStatus", "0");
			logger.error("投标计算投标开始(结束)时间异常->投标名为："+appRecordEntity.getProjectName()+",开始时间为："+appRecordEntity.getStartDate()+",结束时间为："+appRecordEntity.getEndDate()+" ,错误信息："+e.getLocalizedMessage());
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
			long vouchers = 0;//accountSupportService.getRemainderVouchers(memberInfo.getId());
			String sVouchers = IntegerAndString.LongToString(vouchers);
			
			//查询出红包
			List<UnUsedRedpacketsEntity> redPackList = accountSupportService.getMemberUnUsedRedPackets(memberInfo.getId());
			
			//查询红包使用比例
			int proportion = projectInvestService.GetRedpacketsInvestRate();
			result.put("sSumAount", IntegerAndString.LongToString(sumAount));
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
		String logName = "";
		for (int i = 0; i < list.size(); i++) {
			logName = list.get(i).getLogname();
			list.get(i).setLogname(logName.charAt(0)+" *** "+logName.charAt(logName.length()-1));
			list.get(i).setMemberNo("");
			list.get(i).setMembername("");
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("info", list);
		param.put("availableAmount", appRecordEntity.getProjectBaseInfoentity().getAmounts());
		param.put("investTotals", appRecordEntity.getInvestTotals());
		param.put("shenYuKeTou", appRecordEntity.getAvailableaAmounts());
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
	* 项目历程-项目还款
	* 
	* @author 李杰
	* @return
	* @date 2016-5-19 下午5:51:07
	 */
	@RequestMapping(value="projectCourseRepayment/{projectId:[0-9]+}",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String projectCourseRepayment(HttpServletRequest request,@PathVariable long projectId){
		List<LoanRepayEntity> list = projectDetailService.selectLoanRealReplayprocess(projectId);
		return JSONObject.toJSONString(list,SerializerFeature.WriteMapNullValue);
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
			LoanTransferEntity entity = interfaceServerTestI.PreInvestmentTreatment(projectId, memberInfo.getId(), 
						(short)0, lAmount, redPacks, lVouchers, sDirectPwd,(short)0,request,"invest/memberInvestmentPage.html","invest/memberInvestmentvoid.html");
			request.setAttribute("loanTransferEntity", entity);
			if(entity.getStatu() == 0){		//成功
				return "dryLot/loantransfertest";
			}else{							//失败
				request.setAttribute("loanTransferReturnEntity", entity);
				return "invest/investFalse";
			}
		} catch (Exception e) {//转换参数出错!不响应
			e.printStackTrace();
		}
		return "invest/investFalse";
	}
	
	
	/***
	* 投資囘調頁面
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-17 下午4:57:24
	 */
	@RequestMapping("/memberInvestmentPage")
	public String memberInvestmentPage(HttpServletRequest request,HttpServletResponse response){
		String result = interfaceServerTestI.testInvestmentReturn(request, response);
		if(result.equals("SUCCESS")){
			return "invest/investSuccess";
		}else{
			return "invest/investFalse";
		}
	}
	
	
	/***
	* 投資無頁面囘調
	* 
	* @author 李杰
	* @param request
	* @return
	* @date 2016-5-17 下午4:58:11
	 */
	@RequestMapping("/memberInvestmentvoid")
	public void memberInvestmentvoid(HttpServletRequest request,HttpServletResponse response){
		interfaceServerTestI.testInvestmentNotify(request,response);
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
		
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		request.getSession().setAttribute("imgProfix", hostPath);//图片前缀
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
		Date now 		= new Date();
		CreditorTransferListEntity creditorTransferListEntity =	creditorTransferService.selectCreditorTransferDetail(ctaId);
		
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		request.getSession().setAttribute("imgProfix", hostPath);//图片前缀
		
		if(creditorTransferListEntity == null){
			return "invest/debtDetail";
		}else{
			//查询出原借款信息
			ProjectAppRecordEntity appRecordEntity = detailService.selectProjectDetailByID(creditorTransferListEntity.getApplyId());
			
			request.setAttribute("appRecordEntity", appRecordEntity);
			request.setAttribute("creditorTransferListEntity", creditorTransferListEntity);
			//借款人基本信息
			LoanMemberInfoEntity projectMemberInfo = projectDetailService.selectMemberInfo(creditorTransferListEntity.getApplyId());
			request.setAttribute("projectMemberInfo", projectMemberInfo);
			
			//统计信息
			LoanCreditStatisticsEntity creditStatisticsEntity =	balanceService.selectLoanCreditStatistics(projectMemberInfo.getMemberID());
				if(projectMemberInfo.getPersonalName() != null && projectMemberInfo.getPersonalName().length() > 0){
					projectMemberInfo.setPersonalName(projectMemberInfo.getPersonalName().substring(0,1)+"**");
				}
				if(projectMemberInfo.getPersonalPhone() != null && projectMemberInfo.getPersonalPhone().length() >= 11){
					projectMemberInfo.setPersonalPhone(projectMemberInfo.getPersonalPhone().substring(0,3)+" **** "+projectMemberInfo.getPersonalPhone().substring(8, 11));
				}
				if(projectMemberInfo.getPersonalIdCard() != null){
					if(projectMemberInfo.getPersonalIdCard().length() == 18){
						String years  = projectMemberInfo.getPersonalIdCard().substring(6,10);
						String mothd  = projectMemberInfo.getPersonalIdCard().substring(10,12);
						String day	  = projectMemberInfo.getPersonalIdCard().substring(12,14);
						Date userBirthDay = null;
						try {
							userBirthDay = yyyy_MM_dd.parse(years+"-"+mothd+"-"+day);
						} catch (ParseException e) {
							logger.info("投资详情：计算借款人生日出现异常");
						}
						if(userBirthDay != null){
							long time = now.getTime()-userBirthDay.getTime();
							int age = (int) ((time)/1000/60/60/24/365);
							request.setAttribute("projectMemberInfoAge", age);
						}else{
							request.setAttribute("projectMemberInfoAge", 0);
						}
					}
				}
			request.setAttribute("creditStatisticsEntity", creditStatisticsEntity);
			
			//认证信息
			List<BorrowingTypeInfo> borrowingList = borrowingCertificationServer.getAllByMemberAndLoanType(creditorTransferListEntity.getApplyId());
			request.setAttribute("borrowingList", borrowingList);
			
			MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
			if(memberInfo != null){
				//查询出本次可投金额
				long sumAount = creditorTransInvestService.getCreditorMaxInvestAmount(creditorTransferListEntity.getApplyId(), memberInfo.getId(), ctaId, DbKeyUtil.GetDbCodeKey());
				if(sumAount < 0){
					sumAount = 0;
				}
				//查询出代金券
				long vouchers = accountSupportService.getRemainderVouchers(memberInfo.getId());
				String sVouchers = IntegerAndString.LongToString(vouchers);
				
				//查询出红包
				List<UnUsedRedpacketsEntity> redPackList = accountSupportService.getMemberUnUsedRedPackets(memberInfo.getId());
				
				//查询出会员总余额
				request.setAttribute("sSumAount", IntegerAndString.LongToString(sumAount));
				request.setAttribute("userBalances", IntegerAndString.LongToString(memberService.getRemainderTotal(memberInfo.getId())));
				request.setAttribute("sVouchers", sVouchers);
				request.setAttribute("redPackList", redPackList);
				request.setAttribute("redPackCount", redPackList.size());
			}
			
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				request.setAttribute("sysTime", sdf.format(new Date()));
				Date maxTime 	= sdf.parse(creditorTransferListEntity.getTransMaxTime());						//债权到期时间
				//重新定义债权状态
				if(creditorTransferListEntity.getTransStatu() == 0 && creditorTransferListEntity.getCtaInvestRate() < 1000000 && maxTime.before(now)){
					//投标中
					request.setAttribute("investmentStatus", "0");
					request.setAttribute("endTime", sdf.format(maxTime));
				}else if(creditorTransferListEntity.getTransStatu() == 1 || creditorTransferListEntity.getTransStatu() == -1){
					//流标
					request.setAttribute("investmentStatus", "1");
					request.setAttribute("endTime", sdf.format(maxTime));
				}else if(creditorTransferListEntity.getTransStatu() == 2 || 
							(creditorTransferListEntity.getTransStatu() == 0 && (creditorTransferListEntity.getCtaInvestRate() >= 1000000 || (maxTime.before(now) || maxTime.equals(now))))){
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
				logger.error("投标计算债权到期时间(结束)时间异常->债券名为："+creditorTransferListEntity.getProjectTitle()+",结束时间为："+creditorTransferListEntity.getTransMaxTime());
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
			if(sumAount < 0){
				sumAount = 0;
			}
			
			//查询出代金券
			long vouchers = accountSupportService.getRemainderVouchers(memberInfo.getId());
			String sVouchers = IntegerAndString.LongToString(vouchers);
			
			//查询出红包
			List<UnUsedRedpacketsEntity> redPackList = accountSupportService.getMemberUnUsedRedPackets(memberInfo.getId());
			
			//查询红包使用比例
			int proportion = projectInvestService.GetRedpacketsInvestRate();
			result.put("sSumAount", IntegerAndString.LongToString(sumAount));
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
		LoanTransferEntity loanTran = interfaceServerTestI.TransferOfCreditorsRights(projectId, memberInfo.getId(), lCreditorTransAppId, (short)0, lAmount, sRedPacketsInfo, lVouchers, (short)0, request, "invest/memberInvestmentPage.html", "invest/debtInvestmentBack.html");
		request.setAttribute("loanTransferEntity", loanTran);
		if(loanTran.getStatu() == 0){		//成功
			return "dryLot/loantransfertest";
		}else{								//失败
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
		String logName = "";
		for (int i = 0; i < list.size(); i++) {
			logName = list.get(i).getLogname();
			list.get(i).setLogname(logName.charAt(0)+" *** "+logName.charAt(logName.length()-1));
			list.get(i).setMemberNo("");
			list.get(i).setMembername("");
		}
		CreditorTransferListEntity appRecordEntity = creditorTransferService.selectCreditorAvailableaAmount(ctaId);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("info", list);
		param.put("availableAmount", appRecordEntity.getTransPrincipals());
		param.put("investTotals", appRecordEntity.getInvestTotals());
		param.put("shenYuKeTou", appRecordEntity.getAvailableaAmounts());
		return JSONObject.toJSONString(param,SerializerFeature.WriteMapNullValue);
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
