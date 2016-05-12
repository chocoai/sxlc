package cn.springmvc.controller.project; 

import java.util.ArrayList;
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
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.service.BorrowingManagementService;
import cn.springmvc.service.IMyLoanService;
import cn.springmvc.service.ProjectAuitService;
import cn.springmvc.service.projectDetailService;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description: 借款管理控制器 
* @date 2016-5-7 下午1:41:26 
*/
@Controller
@RequestMapping("/project")
public class LoanManageController {
	
	@Resource(name="borrowingManagementServiceImpl")
	private BorrowingManagementService borrowingManagementService;
	
	@Resource(name="projectDetailServiceImpl")
	private projectDetailService projectDetailService;
	
	@Autowired
	private IMyLoanService iMyLoanService;
	
	@Resource(name="projectAuditServiceImpl")
	private ProjectAuitService projectAuitService;
	
	/** 
	 * @author 唐国峰 
	 * @Description: 申请失败项目管理页面
	 * @param req
	 * @return String  
	 * @date 2016-5-7 下午1:42:49
	 * @throws 
	 */
	@RequestMapping("/toApplyFailedPg")
	public String toApplyFailedPg(HttpServletRequest req){
		return "project/apply_failed";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 打开审核中项目管理页面
	 * @param req
	 * @return String  
	 * @date 2016-5-9 上午10:09:50
	 * @throws 
	 */
	@RequestMapping("/toInReviewPg")
	public String toInReviewPg(HttpServletRequest req){
		return "project/examing";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 打开未发布项目管理页面
	 * @param req
	 * @return String  
	 * @date 2016-5-9 上午10:09:50
	 * @throws 
	 */
	@RequestMapping("/toNotReleasePg")
	public String toNotReleasePg(HttpServletRequest req){
		return "project/not_released";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 打开投资中项目管理页面
	 * @param req
	 * @return String  
	 * @date 2016-5-9 上午10:09:50
	 * @throws 
	 */
	@RequestMapping("/toInvestingPg")
	public String toInvestingPg(HttpServletRequest req){
		//FTP服务器地址
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		return "project/investing";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 打开待放款项目管理页面
	 * @param req
	 * @return String  
	 * @date 2016-5-9 上午11:34:05
	 * @throws 
	 */
	@RequestMapping("/toBeLendingPg")
	public String toBeLendingPg(HttpServletRequest req){
		return "project/tobe_lending";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description:打开已流标项目管理页面	 
	 * @param req
	 * @return String  
	 * @date 2016-5-9 上午11:55:18
	 * @throws 
	 */
	@RequestMapping("/toInvestFailurePg")
	public String toInvestFailurePg(HttpServletRequest req){
		return "project/have_bids";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 打开还款中项目管理页面
	 * @param req
	 * @return String  
	 * @date 2016-5-9 下午12:32:56
	 * @throws 
	 */
	@RequestMapping("/toInPaymentPg")
	public String toInPaymentPg(HttpServletRequest req){
		return "project/repayment";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 打开已结清项目管理页面
	 * @param req
	 * @return String  
	 * @date 2016-5-9 下午12:51:01
	 * @throws 
	 */
	@RequestMapping("/toSettledPg")
	public String toSettledPg(HttpServletRequest req){
		return "project/settled";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取借款管理各个页面的分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-7 下午4:02:54
	 * @throws 
	 */
	@RequestMapping("/getLoanManageData")
	@ResponseBody
	public PageEntity getApplyFailureData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String Project_No = req.getParameter("Project_No");
		String Amount_Min = req.getParameter("Amount_Min");
		String Amount_Max = req.getParameter("Amount_Max");
		String Personal_Name = req.getParameter("Personal_Name");
		String Record_Date_Min = req.getParameter("Record_Date_Min");
		String Record_Date_Max = req.getParameter("Record_Date_Max");
		String Logname = req.getParameter("Logname");
		String Check_Date_Min = req.getParameter("Check_Date_Min");
		String Check_Date_Max = req.getParameter("Check_Date_Max");
		String ordercolumn = req.getParameter("ordercolumn");
		String orderDsec = req.getParameter("orderDsec");
		String Deadline = req.getParameter("Deadline");
		String Deadline_Type = req.getParameter("Deadline_Type");
		String Real_End_Date_Min = req.getParameter("Real_End_Date_Min");
		String Real_End_Date_Max = req.getParameter("Real_End_Date_Max");
		String Invest_Amount_Valid_Min = req.getParameter("Invest_Amount_Valid_Min");
		String Invest_Amount_Valid_MAX = req.getParameter("Invest_Amount_Valid_MAX");
		String Repay_Time_Min = req.getParameter("Repay_Time_Min");
		String Repay_Time_Max = req.getParameter("Repay_Time_Max");
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("Project_No", Project_No);
		param.put("Amount_Min", Amount_Min);
		param.put("Amount_Max", Amount_Max);
		param.put("Personal_Name", Personal_Name);
		param.put("Record_Date_Min", Record_Date_Min);
		param.put("Record_Date_Max", Record_Date_Max);
		param.put("Logname", Logname);
		param.put("Check_Date_Min", Check_Date_Min);
		param.put("Check_Date_Max", Check_Date_Max);
		param.put("Deadline", Deadline);
		param.put("Deadline_Type", Deadline_Type);
		param.put("Real_End_Date_Min", Real_End_Date_Min);
		param.put("Real_End_Date_Max", Real_End_Date_Max);
		param.put("Invest_Amount_Valid_Min", Invest_Amount_Valid_Min);
		param.put("Invest_Amount_Valid_MAX", Invest_Amount_Valid_MAX);
		param.put("Repay_Time_Min", Repay_Time_Min);
		param.put("Repay_Time_Max", Repay_Time_Max);
		//设置排序参数
		param.put("ordercolumn", ordercolumn);//排序字段 AMOUNT  RECORD_DATE CHECK_DATE
   		param.put("orderDsec", orderDsec);//1:ASC 0:DESC
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		
		Integer pgType = Integer.parseInt(req.getParameter("pgType"));//查询页面类型代号
		if(pgType == 1){//申请失败项目
			borrowingManagementService.getApplyFailure(pager);
		}else if(pgType == 2){//审核中项目
			borrowingManagementService.getInReview(pager);
		}else if(pgType == 3){//未发布项目
			borrowingManagementService.getNotRelease(pager);
		}else if(pgType == 4){//投资中项目
			borrowingManagementService.getInvestment(pager);
		}else if(pgType == 5){//待放款项目
			borrowingManagementService.getForLending(pager);
		}else if(pgType == 6){//已流标项目
			borrowingManagementService.getInvestFailure(pager);
		}else if(pgType == 7){//还款中项目
			borrowingManagementService.getInPayment(pager);
		}else if(pgType == 8){//已结清项目
			borrowingManagementService.getSettlementOff(pager);
		}
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 查看投资记录
	 * @param req
	 * @return String  
	 * @date 2016-5-9 下午12:51:01
	 * @throws 
	 */
	@RequestMapping("/toInvestRecordPg")
	public String toInvestRecordPg(HttpServletRequest req){
		return "project/investing_invest_record";
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取投资记录分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-9 下午1:55:39
	 * @throws 
	 */
	@RequestMapping("/getInvestmentRecordData")
	@ResponseBody
	public PageEntity getInvestmentRecordData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String applyID = req.getParameter("applyID");
		String Personal_Name = req.getParameter("Personal_Name");
		String Logname = req.getParameter("Logname");
		String Hold_Date_Min = req.getParameter("Hold_Date_Min");
		String Hold_Date_Max = req.getParameter("Hold_Date_Max");
		String orderDsec = req.getParameter("orderDsec");
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String skey = DbKeyUtil.GetDbCodeKey();
		param.put("skey", skey);
		param.put("applyID", applyID);
		param.put("Personal_Name", Personal_Name);
		param.put("Logname", Logname);
		param.put("Hold_Date_Min", Hold_Date_Min);
		param.put("Hold_Date_Max", Hold_Date_Max);
		//设置排序参数
   		param.put("orderDsec", orderDsec);//1:ASC 0:DESC
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		borrowingManagementService.getInvestmentRecord(pager);
		return pager;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description:打开还款计划页面 
	 * @param req
	 * @return String  
	 * @date 2016-5-9 下午3:45:15
	 * @throws 
	 */
	@RequestMapping("/toRepaymentPlanPg")
	public String toRepaymentPlanPg(HttpServletRequest req){
		return "project/repayment_plan";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取还款计划分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-9 下午3:47:48
	 * @throws 
	 */
	@RequestMapping("/getRepayPlanData")
	@ResponseBody
	public PageEntity getRepayPlanData(HttpServletRequest req){
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
		iMyLoanService.loanRepayback(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 根据项目申请id查询项目的所有附件
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-10 下午2:49:35
	 * @throws 
	 */
	@RequestMapping("/getChkAttachData")
	@ResponseBody
	public  List<ProjectCheckAttachEntity>  getChkAttachData(HttpServletRequest req){
		Long projectID = Long.parseLong(req.getParameter("projectID"));
		List<ProjectCheckAttachEntity> result = new ArrayList<ProjectCheckAttachEntity>();
		result = projectAuitService.selectProjectAttachTotal(projectID);
		return result;
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 
	 * @param req
	 * @return int  
	 * @date 2016-5-10 下午5:12:52
	 * @throws 
	 */
	@RequestMapping("/updateAffix")
	@ResponseBody
	public int updateAffix(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=103(员工管理)
		//optID=10301(添加) 10302(修改)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(103);
		logEntity.setlOptId(10302);
		logEntity.setsDetail("");
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		//获取解密后参数
		Map<String,Object> param=new HashMap<String,Object>();
		String ProjectAppId = req.getParameter("ProjectAppId");
		String affix = req.getParameter("affix");
		String deleteaffix = req.getParameter("deleteaffix");
		param.put("ProjectAppId", ProjectAppId);
		param.put("affix", affix);
		param.put("deleteaffix", deleteaffix);
		param.put("adminID", admin.getId());
		int result = 0;
		result = projectAuitService.updateaffix(param,logEntity,sIpInfo);
		return result;
	}
	
}

