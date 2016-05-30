
package cn.springmvc.controller.organizationmng;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.DeptInfo;
import cn.springmvc.model.Trui;
import cn.springmvc.service.IDeptInfoServer;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/**
 * 
* @author 杨翰林
* @Description: 部门管理控制层 
* @since 
* @date 2016-4-5 上午10:35:10
 */
@Controller
@RequestMapping("/role")
public class DeptController {
	
	@Autowired
	private IDeptInfoServer deptInfoServer;
	
	//日志信息
	Log logger = LogFactory.getLog(DeptController.class);
	
	/**
	 * 
	* list查询部门列表 
	* TODO查询部门列表 
	* @author 杨翰林  
	* * @Title: list 
	* @Description: 查询部门列表  
	* @param @param req
	* @param @param pageNum
	* @param @param pageSize
	* @param @param deptNo
	* @param @param deptName
	* @param @param principalName
	* @param @param principalPhone
	* @param @param statu 设定文件 
	* @return void 返回类型 
	* @date 2016-4-5 下午12:02:15
	* @throws
	 */
	@RequestMapping("/role-dept")
	@ResponseBody
	public PageEntity list(HttpServletRequest request) {
		
		//日志信息
		logger.info("查询部门列表");
		
		PageEntity pager = new PageEntity();
		Map<String, Object> req = new HashMap<String, Object>();
		
		//参数接收
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String principalName = request.getParameter("principalName");
		String principalPhone = request.getParameter("principalPhone");
		int start = Integer.valueOf(request.getParameter("start"));
		int length = Integer.valueOf(request.getParameter("length"));
		long spreDeptId = IntegerAndString.StringToLong(request.getParameter("spreDeptId"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"),-1);
		if(deptNo != null && deptNo != "") {
			req.put("deptNo", deptNo);
		}
		if (deptName != null && deptName != "") {
			req.put("deptName", deptName);
		}
		if (principalName != null && principalName != "") {
			req.put("principalName", principalName);
		}
		if (principalPhone != null && principalPhone != "") {
			req.put("principalPhone", principalPhone);
		}
		req.put("spreDeptId", spreDeptId);
		req.put("deptStatu", statu);
		req.put("", spreDeptId);
		pager.setPageNum(start / length + 1);
		pager.setPageSize(length);
		pager.setMap(req);
		
		logger.info("开始调用查询部门列表接口......req=" + req);
		deptInfoServer.getListByParam(pager);
		logger.info("结束调用查询部门列表接口......接口返回：result=" + pager);
		
		return pager;
		
	}
	
	/**
	 * 
	* save	添加部门 
	* TODO添加部门 
	* @author 杨翰林  
	* * @Title: save 
	* @Description: 添加部门 
	* @param @param deptNo
	* @param @param deptName
	* @param @param principalName
	* @param @param principalPhone
	* @param @param deptRemark
	* @param @param deptLevel
	* @param @param preDeptId 设定文件 
	* @return void 返回类型 
	* @date 2016-4-5 下午1:57:09
	* @throws
	 */
	@RequestMapping(value ="/save", method = RequestMethod.POST)
	@ResponseBody
	public int save(HttpServletRequest request) {
		
		//日志信息
		logger.info("添加部门");
		
		DeptInfo deptInfo = new DeptInfo();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		//获取参数
		
		String deptRemark = request.getParameter("deptRemark");
		String deptName = request.getParameter("deptName");
		String principalName = request.getParameter("principalName");
		String principalPhone = request.getParameter("principalPhone");
		String preDeptId = request.getParameter("preDeptId");
		
		deptInfo.setDeptNo("AAA123bbb");
		if (deptRemark != null && deptRemark != "") {
			deptInfo.setDeptRemark(deptRemark);
		}
		if (deptName != null && deptName != "") {
			deptInfo.setDeptName(deptName);
		}
		if (principalName != null && principalName != "") {
			deptInfo.setPrincipalName(principalName);
		}
		if (principalPhone != null && principalPhone != "") {
			deptInfo.setPrincipalPhone(principalPhone);
		}
		if (preDeptId != null && preDeptId != "") {
			deptInfo.setPreDeptId(Long.valueOf(preDeptId));
		}
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10101);
		entity.setlModuleId(101);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		logger.info("开始调用添加部门接口......deptInfo=" + deptInfo);
		int num = deptInfoServer.saveDept(deptInfo, entity, sIpInfo);
		logger.info("结束调用添加部门接口......接口返回：result=" + num);
		
		return num;
	}
	
	/**
	 * 
	* update编辑部门 
	* TODO编辑部门
	* @author 杨翰林  
	* * @Title: update 
	* @Description: 编辑部门 
	* @param @param deptNo
	* @param @param deptName
	* @param @param principalName
	* @param @param principalPhone
	* @param @param deptRemark
	* @param @param deptLevel
	* @param @param deptStatus 设定文件 
	* @return void 返回类型 
	* @date 2016-4-5 下午1:58:22
	* @throws
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public int update(HttpServletRequest request) {
		
		//日志信息
		logger.info("修改部门");
		
		DeptInfo deptInfo = new DeptInfo();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		//获取参数
		
		String deptId = request.getParameter("deptId");
		String deptRemark = request.getParameter("deptRemark");
		String deptName = request.getParameter("deptName");
		String principalName = request.getParameter("principalName");
		String principalPhone = request.getParameter("principalPhone");
		
		if (deptId != null && deptId != "") {
			deptInfo.setId(Long.valueOf(deptId));
		}
		if (deptName != null && deptName != "") {
			deptInfo.setDeptName(deptName);
		}
		if (deptRemark != null && deptRemark != "") {
			deptInfo.setDeptRemark(deptRemark);
		}
		if (principalName != null && principalName != "") {
			deptInfo.setPrincipalName(principalName);
		}
		if (principalPhone != null && principalPhone != "") {
			deptInfo.setPrincipalPhone(principalPhone);
		}
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10102);
		entity.setlModuleId(101);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		logger.info("开始调用修改部门接口......deptInfo=" + deptInfo);
		int num = deptInfoServer.editDept(deptInfo, entity, sIpInfo);
		logger.info("结束调用修改部门接口......接口返回：result=" + num);
		
		return num;
	}
	
	/**
	 * 
	* delete删除部门 
	* TODO删除部门
	* @author 杨翰林  
	* * @Title: delete 
	* @Description: 删除部门 
	* @param @param deptId 设定文件 
	* @return void 返回类型 
	* @date 2016-4-5 下午1:58:51
	* @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(HttpServletRequest request) {
		
		//日志信息
		logger.info("删除部门");
		
		DeptInfo deptInfo = new DeptInfo();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String deptId = request.getParameter("deptId");
		if (deptId != null && deptId != "") {
			deptInfo.setId(Long.valueOf(deptId));
		}
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10103);
		entity.setlModuleId(101);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		logger.info("开始调用删除部门接口......deptInfo=" + deptInfo);
		int num = deptInfoServer.delDept(deptInfo, entity, sIpInfo);
		logger.info("开始调用删除部门接口......接口返回：result=" + num);
		
		return num;
	}
	
	/**
	 * 
	* ofOrOpenDept停用启用部门 
	* TODO停用启用部门
	* @author 杨翰林  
	* * @Title: ofDept 
	* @Description: 停用启用部门 
	* @param @param deptId
	* @param @param deptStatus 设定文件 
	* @return void 返回类型 
	* @date 2016-4-5 下午1:59:17
	* @throws
	 */
	@RequestMapping("/ofOrOpenDept")
	@ResponseBody
	public int ofOrOpenDept(HttpServletRequest request) {
		
		//日志信息
		logger.info("启用停用部门");
		DeptInfo deptInfo = new DeptInfo();
		HttpSession session = HttpSessionUtil.getSession(request);
		InsertAdminLogEntity entity = new InsertAdminLogEntity();
		
		String deptId = request.getParameter("deptId");
		String deptStatu = request.getParameter("deptStatu");
		
		deptInfo.setId(Long.valueOf(deptId));
		deptInfo.setDeptStatu(Integer.valueOf(deptStatu));
		
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			entity.setiAdminId(userInfo.getId());
		}
		entity.setlOptId(10104);
		entity.setlModuleId(101);
		entity.setsDetail("");
		entity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		entity.setsMac(null);
		entity.setsUrl(LoadUrlUtil.getFullURL(request));
		
		int num = deptInfoServer.ofDept(deptInfo, entity, sIpInfo);
		return num;
	}
	
	@RequestMapping("/treeList")
	@ResponseBody
	public List<Trui> treeList(HttpServletRequest request){
		
		List<DeptInfo> deptlist = null;
		//获取参数
		String parentId = request.getParameter("deptId");
		if (parentId != null && parentId != "") {
			deptlist = deptInfoServer.findDeptInfoByParentId(Long.valueOf(parentId));
		}else {
			deptlist = deptInfoServer.findall();
		}
		
	    List<Trui> treeList= new ArrayList<Trui>(); 
		Trui entity = null;
		String sPath = "";
		
		if(deptlist!=null && deptlist.size()>0){
			for (DeptInfo deptInfo : deptlist) {
				sPath = "/role/treeList.do?deptId=" + parentId;
				entity = new Trui();
				entity.setResourceID(deptInfo.getId());
				entity.setParentID(deptInfo.getPreDeptId());
				entity.setResourceCode("");
				entity.setResourceDesc("");
				entity.setResourceOrder(0);
				entity.setResourceType("0");
				entity.setAccessPath(sPath);
				entity.setResourceName(deptInfo.getDeptName());
				entity.setResourceGrade(deptInfo.getDeptLevel());
				treeList.add(entity);
			}
		}
		return	treeList;
	}
}

