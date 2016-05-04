package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import cn.membermng.model.MemberThirdAuthInfoEntity;
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
import cn.springmvc.service.GenerateRepayListService;
import cn.springmvc.service.IBorrowingCertificationServer;
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
	
	private GenerateRepayListService generateRepayListService;
	
	@Autowired
	private IBorrowingCertificationServer borrowingCertificationServer;
	
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
	
	/**
	* 债权转让列表
	* 
	* @author 李杰
	* @Title: debtCession
	* @return
	* @date 2016-4-29 下午1:54:08
	 */
	@RequestMapping("/debtCession")
	public String debtCession(){
		return "invest/debtCession";
	}
	
	/***
	* 投资详细信息
	* 
	* @author 李杰
	* @return
	* @date 2016-4-27 下午4:01:48
	 */
	@RequestMapping("/investmentDetail/{sprojectId:[0-9]+}")
	public String investmentDetail(HttpServletRequest request,@PathVariable String sprojectId){
		long projectId = 0;
		try {
			projectId = Long.parseLong(sprojectId);
		} catch (Exception e) {
			return null;
		}
		//借款项目信息
		ProjectAppRecordEntity appRecordEntity = detailService.selectProjectDetailByID(projectId);
		request.setAttribute("appRecordEntity", appRecordEntity);
		MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(Constant.LOGINUSER);
		if(memberInfo != null){//------------已登录
			//查询出可投金额
			long sumAount = projectInvestService.GetMaxInvestAmount(projectId, memberInfo.getId(), DbKeyUtil.GetDbCodeKey(),(short)0);
			//查询出可用余额
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("memberID", memberInfo.getId());
			param.put("memberType", memberInfo.getMemberType());
			MemberThirdAuthInfoEntity authInfoEntity = balanceService.selectMemberThirdAuthInfo(param);
			//查询出代金券
			long vouchers = accountSupportService.getRemainderVouchers(memberInfo.getId());
			String sVouchers = IntegerAndString.LongToString(vouchers);
			//查询出红包
			List<UnUsedRedpacketsEntity> redPackList = accountSupportService.getMemberUnUsedRedPackets(memberInfo.getId());
		
			request.setAttribute("sSumAount", sumAount);
			request.setAttribute("authInfoEntity", authInfoEntity);
			request.setAttribute("sVouchers", sVouchers);
			request.setAttribute("redPackList", redPackList);
			request.setAttribute("redPackCount", redPackList.size());
		}
		//借款人基本信息
		LoanMemberInfoEntity projectMemberInfo = projectDetailService.selectMemberInfo(projectId);
		request.setAttribute("projectMemberInfo", projectMemberInfo);
		
		//统计信息
		LoanCreditStatisticsEntity creditStatisticsEntity =	balanceService.selectLoanCreditStatistics(projectMemberInfo.getMemberID());
		request.setAttribute("creditStatisticsEntity", creditStatisticsEntity);
		//认证信息
		List<BorrowingTypeInfo> borrowingList = borrowingCertificationServer.getAllByMemberAndLoanType(projectId);
		request.setAttribute("borrowingList", borrowingList);
		return "invest/investmentDetail";
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
	@RequestMapping(value="postLoanSupervisionDetail/{projectId:[0-9]+}",produces = "text/html;charset=UTF-8")
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
	@RequestMapping(value="memberInvestment",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
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
			
		}
		return null;
	}
	

	
	
	
	
	
	
	
	
	
	@RequestMapping("/debtDetail")
	public String debtDetail(){
		return "invest/debtDetail";
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
