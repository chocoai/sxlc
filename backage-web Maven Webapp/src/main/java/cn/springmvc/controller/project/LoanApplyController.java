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

import cn.springmvc.model.Admin;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectPurposeEntity;
import cn.springmvc.service.IFinancialAdvisorServer;
import cn.springmvc.service.ProjectAppRecordService;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.service.ProjectPurposeService;
import cn.springmvc.util.LoadUrlUtil;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

/** 
* @author 唐国峰
* @Description: 借款申请控制器 
* @date 2016-5-4 上午10:18:41 
*/
@Controller
@RequestMapping("/project")
public class LoanApplyController {
	 
	@Resource(name="projectAppRecordServiceImpl")
	private ProjectAppRecordService projectAppRecordService;
	
	@Resource(name="projectPurposeServiceImpl")
	private ProjectPurposeService projectPurposeService;
	
	@Resource(name="projectBaseInfoServiceImpl")
	private ProjectBaseInfoService projectBaseInfoService;
	
	@Autowired
	private IFinancialAdvisorServer iFinancialAdvisorServer;
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到借款意向列表查询页面
	 * @param req
	 * @return String  
	 * @date 2016-5-4 上午10:19:46
	 * @throws 
	 */
	@RequestMapping("/toLoanApplyList")
	public String toLoanApplyList(HttpServletRequest req){
		return "project/loan_intention_1";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到直接意向借款页面
	 * @param req
	 * @return String  
	 * @date 2016-5-4 下午3:48:04
	 * @throws 
	 */
	@RequestMapping("/toLoanApplyPg")
	public String toLoanApplyPg(HttpServletRequest req){
		List<ProjectBaseInfoEntity> proTypes = projectBaseInfoService.selectProjectBaseInfoCombox();
		req.setAttribute("proTypes", proTypes);
		return "project/loan_intention_2";
	}
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取借款意向分页数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-5-4 下午2:41:26
	 * @throws 
	 */
	@RequestMapping("/getLoanPurposeData")
	@ResponseBody
	public PageEntity getLoanPurposeData(HttpServletRequest req){
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String memberNo = req.getParameter("memberNo");
		String logname = req.getParameter("logname");
		String personalPhone = req.getParameter("personalPhone");
		String repayWay = req.getParameter("repayWay");
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memberNo", memberNo);
		param.put("logname", logname);
		param.put("personalPhone", personalPhone);
		param.put("repayWay", repayWay);
		param.put("adminid", admin.getId());//当前登录者id
		//设置排序参数
   		param.put("recordDate", 1);
   		param.put("orderKey", 1);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		projectAppRecordService.selectAllProjectPurpose(pager);
		return pager;
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 添加意向借款
	 * @param req
	 * @return int  
	 * @date 2016-5-4 下午4:47:25
	 * @throws 
	 */
	@RequestMapping("/addLoanPurpose")
	@ResponseBody
	public int addLoanPurpose(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=302(借款申请管理)
		//optID=30201(添加）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(302);
		logEntity.setlOptId(30201);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		//获取解密参数
		Map<String,Object> param=new HashMap<String,Object>();
		ProjectPurposeEntity entity = new ProjectPurposeEntity();
		Long projectID = Long.parseLong(req.getParameter("projectID"));
		entity.setProjectID(projectID);
		Long amount = Long.parseLong(req.getParameter("amount"));
		entity.setAmount(amount);
		String uses = req.getParameter("uses");
		entity.setUses(uses);
		String repaySource = req.getParameter("repaySource");
		entity.setRepaySource(repaySource);
		String projectDescript = req.getParameter("projectDescript");
		entity.setProjectDescript(projectDescript);
		Integer deadline = Integer.parseInt(req.getParameter("deadline"));
		entity.setDeadline(deadline);
		Integer deadlineType = Integer.parseInt(req.getParameter("deadlineType"));
		entity.setDeadlineType(deadlineType);
		Integer repayWay = Integer.parseInt(req.getParameter("repayWay"));
		entity.setRepayWay(repayWay);
		Integer yearRate = Integer.parseInt(req.getParameter("yearRate"));
		entity.setYearRate(yearRate);
		entity.setAdminId(admin.getId());
		
//		param.put("maxRate",IntegerAndString.StringToInt(maxRate));
		int result=0;
		result = projectPurposeService.insertProjectPurpose(entity, logEntity, sIpInfo);
		return result;
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 跳转到项目分配理财顾问页面
	 * @param req
	 * @return String  
	 * @date 2016-5-4 下午6:17:07
	 * @throws 
	 */
	@RequestMapping("/toDistributionPg")
	public String toDistributionPg(HttpServletRequest req){
		return "project/loan_intention_2";
	}
	
	
}

