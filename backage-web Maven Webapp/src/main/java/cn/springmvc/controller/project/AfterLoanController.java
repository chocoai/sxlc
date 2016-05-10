
package cn.springmvc.controller.project; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.LoanRepayUrgedRecordEntity;
import cn.springmvc.service.PostLoanManageService;
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
	@RequestMapping("/toLatePaymentPg")
	public String toLatePaymentPg(HttpServletRequest req){
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
	
	
	
}

