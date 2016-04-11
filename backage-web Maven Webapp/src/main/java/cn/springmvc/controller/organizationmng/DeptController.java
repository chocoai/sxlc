
package cn.springmvc.controller.organizationmng;


import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.DeptInfo;
import cn.springmvc.service.IDeptInfoServer;

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
	public PageEntity list(Map<String, Object> req, Integer start, Integer length,
			String deptNo, String deptName, String principalName,
			String principalPhone, Integer deptStatu) {
		
		//日志信息
		logger.info("查询部门列表");
		
		PageEntity pager = new PageEntity();
		
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
		
		if (deptStatu != null) {
			req.put("deptStatu", deptStatu);
		}
		
		if (start != null) {
			pager.setPageNum(start / length + 1);
		}
		if (length != null) {
			pager.setPageSize(length);
		}
		pager.setMap(req);
		
		logger.info("开始调用查询部门列表接口......req=" + req);
		List<DeptInfo> deptList = deptInfoServer.getListByParam(pager);
		logger.info("结束调用查询部门列表接口......接口返回：result=" + deptList);
		pager.setResults(deptList);
		
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
	public int save(String deptName, String principalName, 
			String principalPhone, String preDeptId,
			String deptRemark) {
		
		//日志信息
		logger.info("添加部门");
		
		DeptInfo deptInfo = new DeptInfo();
		
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
		
		logger.info("开始调用添加部门接口......deptInfo=" + deptInfo);
		int num = deptInfoServer.saveDept(deptInfo);
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
	public int update(String deptId, String deptName, String deptRemark, String principalName,
			String principalPhone) {
		
		//日志信息
		logger.info("修改部门");
		
		DeptInfo deptInfo = new DeptInfo();
		
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
		
		logger.info("开始调用修改部门接口......deptInfo=" + deptInfo);
		int num = deptInfoServer.editDept(deptInfo);
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
	public int delete(String deptId) {
		
		//日志信息
		logger.info("删除部门");
		
		DeptInfo deptInfo = new DeptInfo();
		
		if (deptId != null && deptId != "") {
			deptInfo.setId(Long.valueOf(deptId));
		}
		
		logger.info("开始调用删除部门接口......deptInfo=" + deptInfo);
		int num = deptInfoServer.delDept(deptInfo);
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
	public void ofOrOpenDept(String deptId, String deptStatu) {
		
		//日志信息
		logger.info("启用停用部门");
		DeptInfo deptInfo = new DeptInfo();
		
		deptInfo.setId(Long.valueOf(deptId));
		deptInfo.setDeptStatu(Integer.valueOf(deptStatu));
		
		deptInfoServer.ofDept(deptInfo);
	}
}

