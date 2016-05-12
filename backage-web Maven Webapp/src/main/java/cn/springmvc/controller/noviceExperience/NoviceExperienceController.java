
package cn.springmvc.controller.noviceExperience; 

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
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.invitemastermng.model.NewbieExperienceSetEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.service.NewbieExperienceService;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林 
* @Description: 新手体验管理 
* @since 
* @date 2016-5-12 下午2:11:00
 */
@Controller
@RequestMapping("/noviceExperience")
public class NoviceExperienceController {

	@Resource(name="newbieExperienceServiceImpl")
	private NewbieExperienceService newbieExperienceService;
	
	@Resource(name="projectBaseInfoServiceImpl")
	private ProjectBaseInfoService projectBaseInfoService;
	
	/**
	 * 
	* getExperienceIncome查询会员体验记录 
	* TODO查询会员体验记录
	* @author 杨翰林  
	* * @Title: getExperienceIncome 
	* @Description: 查询会员体验记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-12 下午2:22:49
	* @throws
	 */
	@RequestMapping("/vipRecord")
	@ResponseBody
	public PageEntity getExperienceIncome(HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String memberNo = request.getParameter("memberNo");
		String logname = request.getParameter("logname");
		String personalName = request.getParameter("personalName");
		String prizeWorth = request.getParameter("prizeWorth");
		String startDate1 = request.getParameter("startDate1");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String endDate1 = request.getParameter("endDate1");
		
		req.put("Member_No", memberNo);
		req.put("Logname", logname);
		req.put("Personal_Name", personalName);
		req.put("Reg_Date_Min", startDate);
		req.put("Reg_Date_Max", endDate);
		req.put("Experience_Date_Min", startDate1);
		req.put("Experience_Date_Max", endDate1);
		req.put("Statu", prizeWorth);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		newbieExperienceService.getExperienceIncome(pager);
		return pager;
	}
	
	/**
	 * 
	* queryType查询项目类型 
	* TODO查询项目类
	* @author 杨翰林  
	* * @Title: queryType 
	* @Description: 查询项目类 
	* @param @return 设定文件 
	* @return List<ProjectBaseInfoEntity> 返回类型 
	* @date 2016-5-12 下午3:12:40
	* @throws
	 */
	@RequestMapping("/queryType")
	@ResponseBody
	public List<ProjectBaseInfoEntity> queryType() {
		 
		List<ProjectBaseInfoEntity> list = projectBaseInfoService
				.selectProjectBaseInfoCombox();
		return list;
	}
	
	/**
	 * 
	* NewbieExperienceSet修改新手体验标
	* TODO修改新手体验标
	* @author 杨翰林  
	* * @Title: NewbieExperienceSet 
	* @Description: 修改新手体验标 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-12 下午3:31:47
	* @throws
	 */
	@RequestMapping("/modNew")
	@ResponseBody
	public int NewbieExperienceSet(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String statu = request.getParameter("statu");
		String experienceDescribe = request.getParameter("experienceDescribe");
		String experienceName = request.getParameter("experienceName");
		String productType = request.getParameter("productType");
		String repayWay = request.getParameter("repayWay");
		String yearRates = request.getParameter("yearRates");
		String deadline = request.getParameter("deadline");
		String deadlineType = request.getParameter("deadlineType");
		String vouchersAmounts = request.getParameter("vouchersAmounts");
		String experienceUrl = request.getParameter("experienceUrl");
		
		req.put("project_ID", productType);
		req.put("Experience_Name", experienceName);
		req.put("Experience_Describe", experienceDescribe);
		req.put("Experience_Url", experienceUrl);
		req.put("Repay_Way", repayWay);
		req.put("Year_Rate", yearRates);
		req.put("Deadline", deadline);
		req.put("Deadline_Type", deadlineType);
		req.put("Vouchers_Amount", vouchersAmounts);
		req.put("Statu", statu);
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(1201);
		entity.setlModuleId(2);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = newbieExperienceService.NewbieExperienceSet(req, entity, sIpInfo);
		
		return num;
	}
	
	/**
	 * 
	* getNewbieExperienceSet查询新手体验 
	* TODO查询新手体验
	* @author 杨翰林  
	* * @Title: getNewbieExperienceSet 
	* @Description: 查询新手体验 
	* @param @return 设定文件 
	* @return NewbieExperienceSetEntity 返回类型 
	* @date 2016-5-12 下午3:56:01
	* @throws
	 */
	@RequestMapping("/query")
	@ResponseBody
	public NewbieExperienceSetEntity getNewbieExperienceSet() {
		
		NewbieExperienceSetEntity entity = newbieExperienceService
				.getNewbieExperienceSet();
		return entity;
	}
	
	/**
	 * 
	* getFtp获取服务器地址 
	* TODO获取服务器地址
	* @author 杨翰林  
	* * @Title: getFtp 
	* @Description: 获取服务器地址 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-12 下午4:32:44
	* @throws
	 */
	@RequestMapping("/getFtp")
	@ResponseBody
	public String getFtp() {
		
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		
		return hostPath;
	}
}

