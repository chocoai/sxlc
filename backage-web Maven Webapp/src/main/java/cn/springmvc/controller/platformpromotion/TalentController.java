
package cn.springmvc.controller.platformpromotion; 


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.Admin;
import cn.springmvc.service.ExtensionModuleService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;
/**
 * 
* @author 杨翰林 
* @Description: 推荐达人控制层 
* @since 
* @date 2016-5-24 下午4:49:58
 */
@Controller
@RequestMapping("/talent")
public class TalentController {
	
	@Resource(name="extensionModuleServiceImpl")
	private ExtensionModuleService extensionModuleService;
	
	/**
	 * 
	* yearLimit查询推荐关系年限 
	* TODO查询推荐关系年限
	* @author 杨翰林  
	* * @Title: yearLimit 
	* @Description: 查询推荐关系年限 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-11 上午9:17:33
	* @throws
	 */
	@RequestMapping("/yearLimit")
	@ResponseBody
	public int yearLimit() {
		
		int num = extensionModuleService.getInviteMasterSet();
		
		return num;
	}
	
	/**
	 * 
	* addOrmod添加修改推荐年限 
	* TODO添加修改推荐年限
	* @author 杨翰林  
	* * @Title: addOrmod 
	* @Description: 添加修改推荐年限 
	* @param @param request
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-11 上午9:30:12
	* @throws
	 */
	@RequestMapping("/addOrmod")
	@ResponseBody
	public int addOrmod(HttpServletRequest request) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String limit = request.getParameter("limit");
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(100201);
		entity.setlModuleId(1002);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		int num = extensionModuleService.inviteMasterSet(IntegerAndString.StringToInt(limit), entity, sIpInfo);
		
		return num;
	}
	
	/**
	 * 
	* applyRecord查询推荐达人邀请记录
	* TODO查询推荐达人邀请记录
	* @author 杨翰林  
	* * @Title: applyRecord 
	* @Description: 查询推荐达人邀请记录 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-11 上午9:46:57
	* @throws
	 */
	@RequestMapping("/recordList")
	@ResponseBody
	public PageEntity applyRecord (HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		extensionModuleService.getIMInvite(pager);
		return pager;
	}
	
	/**
	 * 
	* applyChecked推荐达人申请审核 
	* TODO推荐达人申请审核
	* @author 杨翰林  
	* * @Title: applyChecked 
	* @Description: 推荐达人申请审核 
	* @param @param request
	* @param @param req
	* @param @return 设定文件 
	* @return PageEntity 返回类型 
	* @date 2016-5-11 上午9:59:19
	* @throws
	 */
	@RequestMapping("/applyChecked")
	@ResponseBody
	public PageEntity applyChecked (HttpServletRequest request, Map<String, Object> req) {
		
		PageEntity pager = new PageEntity();
		
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String memberNo = request.getParameter("memberNo");
		String logname = request.getParameter("logname");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String personalName = request.getParameter("personalName");
		String checkStatu = request.getParameter("checkStatu");
		String houseAddress = request.getParameter("houseAddress");
		
		req.put("Member_No", memberNo);
		req.put("Logname", logname);
		req.put("Reg_Date_Min", startDate);
		req.put("Reg_Date_Max", endDate);
		req.put("Personal_Name", personalName);
		req.put("House_Address", houseAddress);
		req.put("Check_Statu", checkStatu);
		
		pager.setPageNum(Integer.valueOf(start) / Integer.valueOf(length) + 1);
		pager.setPageSize(Integer.valueOf(length));
		
		extensionModuleService.getIMapply(pager);
		return pager;
	}
	
	/**
	 * 
	* inviteMasterApplyCheck推荐达人审核 
	* TODO推荐达人审核
	* @author 杨翰林  
	* * @Title: inviteMasterApplyCheck 
	* @Description: 推荐达人审核 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-24 下午5:09:49
	* @throws
	 */
	@RequestMapping("/verify")
	@ResponseBody
	public int inviteMasterApplyCheck(HttpServletRequest request, Map<String, Object> req) {
		
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		
		String imApplyID = request.getParameter("imApplyID");
		String checkStatu = request.getParameter("checkStatu");
		String remark = request.getParameter("remark");
		
		req.put("apply_ID", imApplyID);
		req.put("checkStatu", checkStatu);
		req.put("remark", remark);
		req.put("attach_Name", "");
		req.put("attach_Url", "");
		req.put("aimID", 0);
		req.put("adminID", userInfo.getId());
		
		String [] sIpInfo = new String[6];
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(100301);
		entity.setlModuleId(1003);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = extensionModuleService.inviteMasterApplyCheck(req, entity, sIpInfo);
		return num;
	}

}

