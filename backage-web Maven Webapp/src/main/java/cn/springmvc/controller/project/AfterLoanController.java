
package cn.springmvc.controller.project; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.LoanRepayUrgedRecordEntity;
import cn.springmvc.model.PostProjectEntity;
import cn.springmvc.model.ProjectAfterLoanAttachmentEntity;
import cn.springmvc.model.ProjectAfterLoanInfoEntity;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectDetailTYEntity;
import cn.springmvc.model.ProjectInvestRedPackageEntity;
import cn.springmvc.service.IMyLoanService;
import cn.springmvc.service.PostLoanManageService;
import cn.springmvc.service.ProjectAppRecordService;
import cn.springmvc.service.projectDetailService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description: 贷后管理控制器 
* @date 2016-5-9 下午4:36:26 
*/
@Controller
@RequestMapping("/project")
public class AfterLoanController {
	
	@Resource(name="postLoanManageServiceImpl")
	private PostLoanManageService postLoanManageService;
	
	@Resource(name="projectDetailServiceImpl")
	private projectDetailService proDetailService;
	
	@Resource(name="projectAppRecordServiceImpl")
	private ProjectAppRecordService projectAppRecordService;
	
	@Autowired
	private IMyLoanService iMyLoanService;
	/** 
	 * @author 唐国峰 
	 * @Description: 打开成交项目管理页面
	 * @param req
	 * @return String  
	 * @date 2016-5-9 下午4:39:16
	 * @throws 
	 */
	@RequestMapping("/toDealProPg")
	public String toDealProPg(HttpServletRequest req){
		return "project/deal_pro_list";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取成交项目管理分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-9 下午4:41:52
	 * @throws 
	 */
	@RequestMapping("/getProjectLoanData")
	@ResponseBody
	public PageEntity getProjectLoanData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String Project_No = req.getParameter("Project_No");
		String Personal_Name = req.getParameter("Personal_Name");
		String Logname = req.getParameter("Logname");
		String Deadline = req.getParameter("Deadline");
		String Deadline_Type = req.getParameter("Deadline_Type");
		String Real_Amount_Min = req.getParameter("Real_Amount_Min");
		String Real_Amount_Max = req.getParameter("Real_Amount_Max");
		String Repay_Way = req.getParameter("Repay_Way");
		String ordercolumn = req.getParameter("ordercolumn");
		String orderDsec = req.getParameter("orderDsec");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("Project_No", Project_No);
		param.put("Personal_Name", Personal_Name);
		param.put("Logname", Logname);
		param.put("Deadline", Deadline);
		param.put("Deadline_Type", Deadline_Type);
		param.put("Real_Amount_Min", Real_Amount_Min);
		param.put("Real_Amount_Max", Real_Amount_Max);
		param.put("Repay_Way", Repay_Way);
		//设置排序参数
		param.put("ordercolumn", ordercolumn);//排序字段 
   		param.put("orderDsec", orderDsec);//1:ASC 0:DESC
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		postLoanManageService.getProjectLoanList(pager);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 即将还款统计页面 
	 * @param req
	 * @return String  
	 * @date 2016-5-10 上午9:48:40
	 * @throws 
	 */
	@RequestMapping("/toSoonPayPg")
	public String toSoonPayPg(HttpServletRequest req){
		return "project/soon_pay_count";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取即将还款分页数据 
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-10 上午9:58:33
	 * @throws 
	 */
	@RequestMapping("/getSoonPayData")
	@ResponseBody
	public PageEntity getSoonPayData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String Project_No = req.getParameter("Project_No");
		String Project_Title = req.getParameter("Project_Title");
		String Personal_Name = req.getParameter("Personal_Name");
		String Logname = req.getParameter("Logname");
		String day = req.getParameter("day");
		String ordercolumn = req.getParameter("ordercolumn");
		String orderDsec = req.getParameter("orderDsec");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("Project_No", Project_No);
		param.put("Project_Title", Project_Title);
		param.put("Personal_Name", Personal_Name);
		param.put("Logname", Logname);
		param.put("day", day);
		//设置排序参数
		param.put("ordercolumn", ordercolumn);//排序字段 
   		param.put("orderDsec", orderDsec);//1:ASC 0:DESC
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		postLoanManageService.getMaturingBillThiree(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 发送消息
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-10 上午10:55:09
	 * @throws 
	 */
	@RequestMapping("/sendMessage")
	@ResponseBody
	public int sendMessage(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=103(员工管理)
		//optID=10301(添加) 10302(修改)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(103);
		logEntity.setlOptId(10302);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		//获取解密后参数
		Integer urgedType = Integer.parseInt(req.getParameter("urgedType"));
		String urgedDetail = req.getParameter("urgedDetail");
		Long applyID = Long.parseLong(req.getParameter("applyID"));
		Long repayId = Long.parseLong(req.getParameter("repayId"));
		
		//设置查询参数
		LoanRepayUrgedRecordEntity entity = new LoanRepayUrgedRecordEntity();
		entity.setAdminID(admin.getId());
		entity.setApplyID(applyID);
		entity.setRepayId(repayId);
		entity.setUrgedType(urgedType);
		entity.setUrgedDetail(urgedDetail);
		int result = 0;
		result = postLoanManageService.insertLoanRepayUrgedRecord(entity,logEntity,sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 逾期还款统计页面
	 * @param req
	 * @return String  
	 * @date 2016-5-10 上午11:41:50
	 * @throws 
	 */
	@RequestMapping("/toLatePayCountPg")
	public String toLatePayCountPg(HttpServletRequest req){
		return "project/late_pay_count";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 逾期还款统计分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-10 上午11:42:31
	 * @throws 
	 */
	@RequestMapping("/getLatePayments")
	@ResponseBody
	public PageEntity getLatePayments(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String Project_No = req.getParameter("Project_No");
		String Project_Title = req.getParameter("Project_Title");
		String Personal_Name = req.getParameter("Personal_Name");
		String Logname = req.getParameter("Logname");
		String Overdue_Day_Min = req.getParameter("Overdue_Day_Min");
		String Overdue_Day_Max = req.getParameter("Overdue_Day_Max");
		String Repay_MaxTime_Min = req.getParameter("Repay_MaxTime_Min");
		String Repay_MaxTime_Max = req.getParameter("Repay_MaxTime_Max");
		String ordercolumn = req.getParameter("ordercolumn");
		String orderDsec = req.getParameter("orderDsec");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("Project_No", Project_No);
		param.put("Project_Title", Project_Title);
		param.put("Personal_Name", Personal_Name);
		param.put("Logname", Logname);
		param.put("Overdue_Day_Min", Overdue_Day_Min);
		param.put("Overdue_Day_Max", Overdue_Day_Max);
		param.put("Repay_MaxTime_Min", Repay_MaxTime_Min);
		param.put("Repay_MaxTime_Max", Repay_MaxTime_Max);
		//设置排序参数
		param.put("ordercolumn", ordercolumn);//排序字段 
   		param.put("orderDsec", orderDsec);//1:ASC 0:DESC
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		postLoanManageService.getLatePayments(pager);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description:即将到期借款催收页面 
	 * @param req
	 * @return String  
	 * @date 2016-5-11 上午9:50:24
	 * @throws 
	 */
	@RequestMapping("/toSoonDueBillPg")
	public String toSoonDueBillPg(HttpServletRequest req){
		return "project/soon_due_bill";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取即将到期账单分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-11 上午9:51:31
	 * @throws 
	 */
	@RequestMapping("/getMaturingBill")
	@ResponseBody
	public PageEntity getMaturingBill(HttpServletRequest req){
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String Project_No = req.getParameter("Project_No");
		String Project_Title = req.getParameter("Project_Title");
		String Personal_Name = req.getParameter("Personal_Name");
		String Repay_MaxTime_Min = req.getParameter("Repay_MaxTime_Min");
		String Repay_MaxTime_Max = req.getParameter("Repay_MaxTime_Max");
		String ordercolumn = req.getParameter("ordercolumn");
		String orderDsec = req.getParameter("orderDsec");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("Project_No", Project_No);
		param.put("Project_Title", Project_Title);
		param.put("Personal_Name", Personal_Name);
		param.put("Repay_MaxTime_Min", Repay_MaxTime_Min);
		param.put("Repay_MaxTime_Max", Repay_MaxTime_Max);
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("staffType", admin.getStaffType());//管理员类型
		param.put("Admin_ID", admin.getId());
		//设置排序参数
		param.put("ordercolumn", ordercolumn);//排序字段 
   		param.put("orderDsec", orderDsec);//1:ASC 0:DESC
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		postLoanManageService.getMaturingBill(pager);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取账单详情数据
	 * @param req
	 * @return String  
	 * @date 2016-5-11 上午10:43:06
	 * @throws 
	 */
	@RequestMapping("/getBillDetailData")
	@ResponseBody
	public PostProjectEntity getBillDetailData(HttpServletRequest req){
		Integer repayID = Integer.parseInt(req.getParameter("repayID"));
		PostProjectEntity details = new PostProjectEntity();
		details = postLoanManageService.getBillingDetails(repayID);
		String r = postLoanManageService.getProjectBill(repayID);
		if(details!=null){
			return details;
		}else{
			return new PostProjectEntity();
		}
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 逾期借款催收页面
	 * @param req
	 * @return String  
	 * @date 2016-5-11 下午12:32:00
	 * @throws 
	 */
	@RequestMapping("/toOverdueCollectionPg")
	public String toOverdueCollectionPg(HttpServletRequest req){
		return "project/overdue_collection";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取逾期借款催收分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-11 下午12:32:54
	 * @throws 
	 */
	@RequestMapping("/getOverdueCollectionData")
	@ResponseBody
	public PageEntity getOverdueCollectionData(HttpServletRequest req){
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String Project_No = req.getParameter("Project_No");
		String Project_Title = req.getParameter("Project_Title");
		String Personal_Name = req.getParameter("Personal_Name");
		String Repay_MaxTime_Min = req.getParameter("Repay_MaxTime_Min");
		String Repay_MaxTime_Max = req.getParameter("Repay_MaxTime_Max");
		String orderDsec = req.getParameter("orderDsec");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("projectNo", Project_No);
		param.put("projectTitle", Project_Title);
		param.put("personalName", Personal_Name);
		param.put("startTime", Repay_MaxTime_Min);
		param.put("endTime", Repay_MaxTime_Max);
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("adminID", admin.getId());
		//设置排序参数
   		param.put("orderDsec", orderDsec);//1还款时间升序,-1还款时间降序,2逾期天数升序,-2逾期天数降序
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		postLoanManageService.getOverdueCollection(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 催收已还账单页面
	 * @param req
	 * @return String  
	 * @date 2016-5-11 下午2:23:04
	 * @throws 
	 */
	@RequestMapping("/toCollectionHasBillPg")
	public String toCollectionHasBillPg(HttpServletRequest req){
		return "project/collection_has_bill";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 查询催收已还分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-11 下午2:25:29
	 * @throws 
	 */
	@RequestMapping("/getRepaySettledData")
	@ResponseBody
	public PageEntity getRepaySettledData(HttpServletRequest req){
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String Project_No = req.getParameter("Project_No");
		String Project_Title = req.getParameter("Project_Title");
		String Personal_Name = req.getParameter("Personal_Name");
		String Merbill_No = req.getParameter("Merbill_No");
		String orderDsec = req.getParameter("orderDsec");
		String ordercolumn = req.getParameter("ordercolumn");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("Project_No", Project_No);
		param.put("Project_Title", Project_Title);
		param.put("Personal_Name", Personal_Name);
		param.put("Merbill_No", Merbill_No);
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("AdminID", admin.getId());
		//设置排序参数
		param.put("ordercolumn", ordercolumn);
   		param.put("orderDsec", orderDsec);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		postLoanManageService.getRepaySettled(pager);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 项目详情页面
	 * @param req
	 * @return String  
	 * @date 2016-5-11 下午5:05:37
	 * @throws 
	 */
	@RequestMapping("/toProjectdetailPg")
	public String toProjectdetailPg(HttpServletRequest req){
		Map<String,Object> param=new HashMap<String,Object>();
		Long applyId = Long.parseLong(req.getParameter("content"));
		param.put("applyId", applyId);
		//根据申请id获取项目详情
		ProjectDetailTYEntity proDetail = proDetailService.selectProjectdetailByIDbc(applyId);
		//根据申请id获取惊喜红包
		List<ProjectInvestRedPackageEntity> redPackage = projectAppRecordService.selectProjectInvestRedPackageById(param);
		//根据申请id获取附件
		List<ProjectAppAttachmentEntity> attaches = projectAppRecordService.selectProjectAppAttachmentById(param);
		//FTP服务器地址
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		req.setAttribute("proDetail", proDetail);
		req.setAttribute("redPackage", redPackage);
		req.setAttribute("attaches", attaches);
		return "project/pro-add/loan_pro_detail";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 贷后监管页面
	 * @param req
	 * @return String  
	 * @date 2016-5-12 下午1:57:47
	 * @throws 
	 */
	@RequestMapping("/toDealListSupervicePg")
	public String toDealListSupervicePg(HttpServletRequest req){
		String projectID = req.getParameter("content");
		req.setAttribute("projectID", projectID);
		//FTP服务器地址
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		return "project/deal_list_supervice_list";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取贷后监管分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-12 下午1:59:19
	 * @throws 
	 */
	@RequestMapping("/getProAfterLoanListData")
	@ResponseBody
	public PageEntity getProAfterLoanListData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String startTime = req.getParameter("startTime");
		String endTime = req.getParameter("endTime");
		String projectID = req.getParameter("projectID");
		
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		param.put("projectID", projectID);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		postLoanManageService.selectProjectAfterLoanList(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 新增贷后监管信息
	 * @param req
	 * @return int  
	 * @date 2016-5-12 下午3:21:37
	 * @throws 
	 */
	@RequestMapping("/insertProjectAfterLoanInfo")
	@ResponseBody
	public int insertProjectAfterLoanInfo(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=103(员工管理)
		//optID=10301(添加) 10302(修改)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(103);
		logEntity.setlOptId(10302);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		//获取解密后参数
		Long applyID = Long.parseLong(req.getParameter("applyID"));
		String abstractMain = req.getParameter("abstractMain");
		String details = req.getParameter("details");
		String affix = req.getParameter("affix");
		
		//设置参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("applyID", applyID);
		param.put("abstractMain", abstractMain);
		param.put("details", details);
		param.put("affix", affix);
		param.put("adminID", admin.getId());
		
		int result = 0;
		result = postLoanManageService.insertProjectAfterLoanInfo(param,logEntity,sIpInfo);
		return result;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 贷后信息详情查询
	 * @param req
	 * @return PostProjectEntity  
	 * @date 2016-5-12 下午3:40:02
	 * @throws 
	 */
	@RequestMapping("/getProjectAfterLoandetail")
	@ResponseBody
	public ProjectAfterLoanInfoEntity getProjectAfterLoandetail(HttpServletRequest req){
		Long infoId = Long.parseLong(req.getParameter("infoId"));
		ProjectAfterLoanInfoEntity details = new ProjectAfterLoanInfoEntity();
		details = postLoanManageService.selectProjectAfterLoandetail(infoId);
		List<ProjectAfterLoanAttachmentEntity> attaches = postLoanManageService.selectProjectAfterLoanAttach(infoId);
		if(details!=null){
			details.setAttaches(attaches);
			return details;
		}else{
			return new ProjectAfterLoanInfoEntity();
		}
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 删除某条贷后监管信息
	 * @param req
	 * @return int  
	 * @date 2016-5-12 下午5:59:42
	 * @throws 
	 */
	@RequestMapping("/delProAfterLoanInfo")
	@ResponseBody
	public int delProAfterLoanInfo(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=103(员工管理)
		//optID=10301(添加) 10302(修改)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(103);
		logEntity.setlOptId(10302);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		//获取解密后参数
		Long infoId = Long.parseLong(req.getParameter("infoId"));
		int result = 0;
		result = postLoanManageService.deleteProjectAfterLoanInfoByID(infoId,logEntity,sIpInfo);
		return result;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 还款详情页面
	 * @param req
	 * @return String  
	 * @date 2016-5-12 下午6:26:38
	 * @throws 
	 */
	@RequestMapping("/toDealListPayDetailPg")
	public String toDealListPayDetailPg(HttpServletRequest req){
		String applyId = req.getParameter("content");
		req.setAttribute("applyId", applyId);
		return "project/deal_list_pay_detail";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取还款详情分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-12 下午6:30:07
	 * @throws 
	 */
	@RequestMapping("/getDealListPayDetailData")
	@ResponseBody
	public PageEntity getDealListPayDetailData(HttpServletRequest req){
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
		iMyLoanService.loanRepayDetail(pager);
		return pager;
	}
}

