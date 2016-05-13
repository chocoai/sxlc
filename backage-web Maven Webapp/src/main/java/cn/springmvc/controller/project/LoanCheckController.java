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
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.springmvc.model.Admin;
import cn.springmvc.model.ProcessProjectEntity;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.service.ProcessProjectService;
import cn.springmvc.service.ProjectAuitService;
import cn.springmvc.service.ProjectPublishService;
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
	 * @Description: 发布项目页面
	 * @param req
	 * @return String  
	 * @date 2016-5-13 下午12:37:46
	 * @throws 
	 */
	@RequestMapping("/toLoanProPostPg")
	public String toLoanProPostPg(HttpServletRequest req){
		return "project/pro-add/loan_pro_post";
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
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("dealStatu", -1);//意向处理状态 -1:打回
		String id = req.getParameter("id");
		param.put("id", id);
		
		int result=0;
		result = projectPublishService.publishProject(param, logEntity, sIpInfo);
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
}

