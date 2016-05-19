package cn.springmvc.controller.project; 

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
import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.membermng.model.InvestmentstatisticsEntity;
import cn.membermng.model.LoanCreditStatisticsEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.LoanMemberInfoEntity;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProcessProjectEntity;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectCheckAttachDealEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.service.GenerateRepayListService;
import cn.springmvc.service.ProcessProjectService;
import cn.springmvc.service.ProjectAppRecordService;
import cn.springmvc.service.ProjectAuitService;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.service.ProjectPublishService;
import cn.springmvc.service.RecordsBalanceService;
import cn.springmvc.service.projectDetailService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description: 借款审核控制器 
* @date 2016-5-6 上午9:59:19 
*/
@Controller
@RequestMapping("/project")
public class LoanCheckController {
	
	@Resource(name="projectAuditServiceImpl")
	private ProjectAuitService projectAuitService;

	@Resource(name="projectPublishServiceImpl")
	private ProjectPublishService projectPublishService;
	
	@Resource(name="processProjectServiceImpl")
	private ProcessProjectService processProjectService;
	
	@Resource(name="projectDetailServiceImpl")
	private projectDetailService proDetailService;
	
	@Resource(name="projectAppRecordServiceImpl")
	private ProjectAppRecordService projectAppRecordService;
	
	@Resource(name="recordsBalanceServiceImpl")
	private RecordsBalanceService recordsBalanceService;
	
	@Resource(name="projectBaseInfoServiceImpl")
	private ProjectBaseInfoService projectBaseInfoService;
	
	@Resource(name="generateRepayListServiceImpl")
	private GenerateRepayListService generateRepayListService;
	/** 
	 * @author 唐国峰 
	 * @Description: 借款审核页面
	 * @param req
	 * @return String  
	 * @date 2016-5-13 下午2:10:23
	 * @throws 
	 */
	@RequestMapping("/toLoanChkList")
	public String toLoanChkList(HttpServletRequest req){
		//审核流程查询
		List<ProcessProjectEntity> process = processProjectService.selectProcessProjectList();
		req.setAttribute("process", process);
		//审批流程序号
		String sIndexs = req.getParameter("content");
		if(sIndexs ==null || "".equals(sIndexs)){//默认展示第一个审批节点
			sIndexs=process.get(0).getFirstIndex()+"";
		}
		req.setAttribute("sIndexs", sIndexs);
		//发布节点序号
		int pushIndex = process.get(0).getPushIndex();
		req.setAttribute("pushIndex", pushIndex);
		return "project/loan_exam";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 项目发布页面
	 * @param req
	 * @return String  
	 * @date 2016-5-13 上午10:05:21
	 * @throws 
	 */
	@RequestMapping("/toPostListPg")
	public String toPostListPg(HttpServletRequest req){
		//审核流程查询
		List<ProcessProjectEntity> process = processProjectService.selectProcessProjectList();
		req.setAttribute("process", process);
		//发布节点序号
		if(process.size()>0){
			int pushIndex = process.get(0).getPushIndex();
			req.setAttribute("pushIndex", pushIndex);
		}
		return "project/post_list";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取项目发布分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-13 上午10:07:47
	 * @throws 
	 */
	@RequestMapping("/getProPublishData")
	@ResponseBody
	public PageEntity getProPublishData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String ProjectTitle = req.getParameter("ProjectTitle");
		String Logname = req.getParameter("Logname");
		String memberNo = req.getParameter("memberNo");
		String name= req.getParameter("name");
		String checkStatu = req.getParameter("checkStatu");
		String projectNO = req.getParameter("projectNo");
		String pushstartTime = req.getParameter("pushstartTime");
		String pushendTime = req.getParameter("pushendTime");
		String order = req.getParameter("order");
		String sIndexs = req.getParameter("sIndexs");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String keys = DbKeyUtil.GetDbCodeKey();
		param.put("ProjectTitle", ProjectTitle);
		param.put("Logname", Logname);
		param.put("memberNo", memberNo);
		param.put("name", name);
		param.put("investStatu", checkStatu);
		param.put("projectNO", projectNO);
		param.put("pushstartTime", pushstartTime);
		param.put("pushendTime", pushendTime);
		param.put("keys", keys);
		param.put("sIndexs", sIndexs);
		//设置排序参数
		param.put("order", order);//  1:Amount desc  -1:Amount asc  2:Release_Date desc -2:Release_Date asc
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<ProjectAppRecordEntity>  list = projectPublishService.selectProjectPublishList(pager);
		PageUtil.ObjectToPage(pager, list);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 打回借款申请
	 * @param req
	 * @return int  
	 * @date 2016-5-13 下午5:06:24
	 * @throws 
	 */
	@RequestMapping("/refuseProBorrow ")
	@ResponseBody
	public int refuseProBorrow(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=20110(个人会员分配理财顾问)
		//optID=2011001(分配理财顾问）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setsDetail("");
		logEntity.setlModuleId(20110);
		logEntity.setlOptId(2011001);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsDetail("");
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		//获取解密参数
		Long applyId = Long.parseLong(req.getParameter("applyId"));//申请ID
		
		int result=0;
		result = projectPublishService.Refuse(applyId);
		return result;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 修改借款结束时间（项目借款结束日期延长）
	 * @param req
	 * @return int  
	 * @date 2016-5-13 下午5:19:27
	 * @throws 
	 */
	@RequestMapping("/updateEndtime")
	@ResponseBody
	public int updateEndtime(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=308(债权转让延期)
		//optID=30801(债权转让延期)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(308);
		logEntity.setlOptId(30801);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		//获取解密后参数
		ProjectAppProcessEntity param = new ProjectAppProcessEntity();
		Long projectID = Long.parseLong(req.getParameter("applyId"));//申请ID
		String endDate = req.getParameter("endDate");
		param.setProjectID(projectID);
		param.setEndDate(endDate);
		
		int result = 0;
		result = projectPublishService.updateEndtime(param,logEntity,sIpInfo);
		return result;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 发布/审核项目页面
	 * @param req
	 * @return String  
	 * @date 2016-5-13 下午12:37:46
	 * @throws 
	 */
	@RequestMapping("/toLoanProPostPg")
	public String toLoanProPostPg(HttpServletRequest req){
		Map<String,Object> param=new HashMap<String,Object>();
		Long Indexsnow = Long.parseLong(req.getParameter("start"));//发布审批流程序号
		req.setAttribute("Indexsnow", Indexsnow);
		req.setAttribute("pgType", req.getParameter("length"));//页面类型：1：项目审核 2：项目发布
		Long applyId = Long.parseLong(req.getParameter("content"));
		param.put("applyId", applyId);
		
		//根据申请id获取项目详情
//		ProjectDetailTYEntity proDetail = proDetailService.selectProjectdetailByIDbc(applyId);
		//查询项目详情
		ProjectAppRecordEntity proRecord = projectAuitService.selectProjectDetailByID(applyId);
		req.setAttribute("proRecord", proRecord);
		//根据申请id获取会员信息
		LoanMemberInfoEntity  memberInfo = proDetailService.selectMemberInfo(applyId);
		req.setAttribute("memberInfo", memberInfo);
		//根据会员id获取会员借款信用统计selectProjectAppAttachmentById
		LoanCreditStatisticsEntity  credit = recordsBalanceService.selectLoanCreditStatistics(memberInfo.getMemberID());
		req.setAttribute("credit", credit);
		//根据会员id获取会员投资统计信息
		InvestmentstatisticsEntity  invest = recordsBalanceService.selectInvestmentstatistics(memberInfo.getMemberID());
		req.setAttribute("invest", invest);
		//根据项目类型ID查询项目类型所需认证项
		List<MemberAttestTypeEntity> authentication =  projectBaseInfoService.selectMemberAttestByprojectType(proRecord.getProjectID());
		req.setAttribute("authentication", authentication);
		//根据申请id获取附件
		List<ProjectAppAttachmentEntity> attaches = projectAppRecordService.selectProjectAppAttachmentById(param);
		req.setAttribute("attaches", attaches);
		
		//根据申请id获取惊喜红包
//		List<ProjectInvestRedPackageEntity> redPackage = projectAppRecordService.selectProjectInvestRedPackageById(param);
//		req.setAttribute("redPackage", redPackage);
		
		//FTP服务器地址
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		return "project/pro-add/loan_pro_post";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取历史审核记录分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-16 上午11:07:47
	 * @throws 
	 */
	@RequestMapping("/getProChkRecordData")
	@ResponseBody
	public PageEntity getProChkRecordData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String applyId = req.getParameter("applyId");
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("applyId", applyId);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		projectAuitService.selectProjectCheckRecord(pager);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取历史审核附件分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-16 上午11:27:42
	 * @throws 
	 */
	@RequestMapping("/getCheckAttachData")
	@ResponseBody
	public PageEntity getCheckAttachData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String applyId = req.getParameter("applyId");
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("applyId", applyId);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<ProjectCheckAttachEntity> list = projectAuitService.selectCheckAttachDeal(pager);
		PageUtil.ObjectToPage(pager, list); 
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取附件删除记录分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-16 上午11:47:48
	 * @throws 
	 */
	@RequestMapping("/getChkAttachDelData")
	@ResponseBody
	public PageEntity getChkAttachDelData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String applyId = req.getParameter("applyId");
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("applyId", applyId);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<ProjectCheckAttachEntity> list = projectAuitService.selectCheckAttachDealDelete(pager);
		PageUtil.ObjectToPage(pager, list);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 根据附件编号,与审核记录ID删除审核附件
	 * @param req
	 * @return int  
	 * @date 2016-5-16 下午3:14:54
	 * @throws 
	 */
	@RequestMapping("/delProChkAttach")
	@ResponseBody
	public int delProChkAttach(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=20110(个人会员分配理财顾问)
		//optID=2011001(分配理财顾问）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(20110);
		logEntity.setlOptId(2011001);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		//获取解密参数
		Map<String,Object> param=new HashMap<String,Object>();
		Integer attachIndex = Integer.parseInt(req.getParameter("attachIndex"));
		param.put("attachIndex", attachIndex);
		Long appCheckId = Long.parseLong(req.getParameter("appCheckId"));
		param.put("appCheckId", appCheckId);
		
		int result=0;
		//删除附件
		result = projectAuitService.deleteProjectCheckAttachone(param,logEntity,sIpInfo);
		ProjectCheckAttachDealEntity entity = new ProjectCheckAttachDealEntity();
		entity.setAppCheckId(appCheckId);
		entity.setAttachIndex(attachIndex);
		entity.setDealType(1);//操作类型 0：添加 1：删除
		entity.setAdminID(admin.getId());
		if(result>0){
			//插入附件操作记录
			projectAuitService.insertCheckAttachone(entity);
		}
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 发布项目 
	 * @param req
	 * @return int  
	 * @date 2016-5-16 下午3:32:17
	 * @throws 
	 */
	@RequestMapping("/publishProject")
	@ResponseBody
	public int publishProject(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=20110(个人会员分配理财顾问)
		//optID=2011001(分配理财顾问）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(20110);
		logEntity.setlOptId(2011001);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		//获取解密参数
		Map<String,Object> param=new HashMap<String,Object>();
		String ApplyId = req.getParameter("ApplyId");////项目申请ID
		param.put("ApplyId", ApplyId);
		String Indexsnow = req.getParameter("Indexsnow");//审批流程序号
		param.put("Indexsnow", Indexsnow);
		String checkStatu = req.getParameter("checkStatu");//审核结果 1：通过 -1：打回
		param.put("checkStatu", checkStatu);
//		String CheckRemark = req.getParameter("CheckRemark");
//		param.put("CheckRemark", CheckRemark);
		String startDate = req.getParameter("startDate");
		param.put("startDate", startDate);
		String endDate = req.getParameter("endDate");
		param.put("endDate2", endDate);
		String affix = req.getParameter("affix");
		param.put("affix", affix);
		String ImageUrl = req.getParameter("ImageUrl");
		param.put("ImageUrl", ImageUrl);
		param.put("adminID", admin.getId());
		int result=0;
		//发布项目
		result = projectPublishService.publishProject(param,logEntity,sIpInfo);
		if(result>0){
			//生成该项目的还款计划
			generateRepayListService.GenerateRepayList(Long.parseLong(ApplyId));
		}
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 修改项目基本信息
	 * @param req
	 * @return int  
	 * @date 2016-5-16 下午4:26:05
	 * @throws 
	 */
	@RequestMapping("/updateProjectDetail")
	@ResponseBody
	public int updateProjectDetail(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=20110(个人会员分配理财顾问)
		//optID=2011001(分配理财顾问）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(20110);
		logEntity.setlOptId(2011001);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		//获取解密参数
		Map<String,Object> param=new HashMap<String,Object>();
		String ApplyId = req.getParameter("ApplyId");////项目申请ID
		param.put("ApplyId", ApplyId);
		String projectTitle = req.getParameter("projectTitle");
		param.put("projectTitle", projectTitle);
		String uses = req.getParameter("uses");
		param.put("uses", uses);
		String repaySource = req.getParameter("repaySource");
		param.put("repaySource", repaySource);
		String amount = req.getParameter("amount");
		param.put("amount", StringToLong(amount,0));
		String projectDescript = req.getParameter("projectDescript");
		param.put("projectDescript", projectDescript);
		String deadline = req.getParameter("deadline");
		param.put("deadline", deadline);
		String deadlineType = req.getParameter("deadlineType");
		param.put("deadlineType", deadlineType);
		String repayWay = req.getParameter("repayWay");
		param.put("repayWay", repayWay);
		String yearRate = req.getParameter("yearRate");
		param.put("yearRate", StringToLong(yearRate,0));
		String minStart = req.getParameter("minStart");
		param.put("minStart", StringToLong(minStart,0));
		String increaseRange = req.getParameter("increaseRange");
		param.put("increaseRange", StringToLong(increaseRange,0));
		String investMax = req.getParameter("investMax");
		param.put("investMax", StringToLong(investMax,0));
		String investCountMax = req.getParameter("investCountMax");
		param.put("investCountMax", investCountMax);
		String RepayGuarantee = req.getParameter("RepayGuarantee");
		param.put("RepayGuarantee", RepayGuarantee);
		
		int result=0;
		result = projectAuitService.updateProjectDetail(param,logEntity,sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取项目审核分页数据
	 * @return PageEntity  
	 * @date 2016-5-16 下午5:14:55
	 * @throws 
	 */
	@RequestMapping("/getProAuitData")
	@ResponseBody
	public PageEntity getProAuitData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String ProjectTitle = req.getParameter("ProjectTitle");
		String Logname = req.getParameter("Logname");
//		String memberNo = req.getParameter("memberNo");
		String name= req.getParameter("name");
//		String checkStatu = req.getParameter("checkStatu");
//		String projectNO = req.getParameter("projectNo");
		String startTime = req.getParameter("startTime");
		String endTime = req.getParameter("endTime");
//		String order = req.getParameter("order");
		String sIndexs = req.getParameter("sIndexs");
		String statu = req.getParameter("statu");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String keys = DbKeyUtil.GetDbCodeKey();
		param.put("ProjectTitle", ProjectTitle);
		param.put("Logname", Logname);
//		param.put("memberNo", memberNo);
		param.put("name", name);
//		param.put("investStatu", checkStatu);
//		param.put("projectNO", projectNO);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		param.put("keys", keys);
		param.put("sIndexs", sIndexs);
		param.put("statu", statu);
		//设置排序参数
//		param.put("order", order);//  1:Amount desc  -1:Amount asc  2:Release_Date desc -2:Release_Date asc
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<ProjectAppRecordEntity> list = projectAuitService.selectProjectAuitList(pager);
		PageUtil.ObjectToPage(pager, list);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 审核项目 
	 * @param req
	 * @return int  
	 * @date 2016-5-17 上午10:32:07
	 * @throws 
	 */
	@RequestMapping("/projectAudit")
	@ResponseBody
	public int projectAudit(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=20110(个人会员分配理财顾问)
		//optID=2011001(分配理财顾问）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(20110);
		logEntity.setlOptId(2011001);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		//获取解密参数
		Map<String,Object> param=new HashMap<String,Object>();
		String ApplyId = req.getParameter("ApplyId");////项目申请ID
		param.put("ApplyId", ApplyId);
		String Indexsnow = req.getParameter("Indexsnow");//审批流程序号
		param.put("Indexsnow", Indexsnow);
		String checkStatu = req.getParameter("checkStatu");//审核结果 1：通过 -1：打回
		param.put("checkStatu", checkStatu);
		String CheckRemark = req.getParameter("CheckRemark");
		param.put("CheckRemark", CheckRemark);
//		String startDate = req.getParameter("startDate");
//		param.put("startDate", startDate);
//		String endDate = req.getParameter("endDate");
//		param.put("endDate", endDate);
		String affix = req.getParameter("affix");
		param.put("affix", affix);
//		String ImageUrl = req.getParameter("ImageUrl");
//		param.put("ImageUrl", ImageUrl);
		param.put("adminID", admin.getId());
		int result=0;
		result = projectAuitService.projectAudit(param,logEntity,sIpInfo);
		return result;
	}
	
	/**
	 * @author 唐国峰 
	 * @Description: string转化为long,乘以10000且有默认值。
	 * @param value
	 * @param iDefault
	 * @return long  
	 * @date 2016-5-19 上午11:58:18
	 * @throws
	 */
	public long StringToLong(String value,int iDefault){
		long iResult = iDefault;
    	if(value == null || value.equals("")){
    		return iResult;
    	}
    	try {
			iResult = IntegerAndString.StringToLong(value);
		} catch (Exception e) {
		}
    	return iResult;
	}
	
	
}

