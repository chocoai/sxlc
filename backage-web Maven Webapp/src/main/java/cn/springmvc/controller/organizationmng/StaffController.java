 package cn.springmvc.controller.organizationmng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.dictionaries.model.EducationInfoEntity;
import cn.dictionaries.model.NationInfoEntity;
import cn.springmvc.dao.impl.DictionariesCore;
import cn.springmvc.model.StaffInfo;
import cn.springmvc.service.IPostInfoServer;
import cn.springmvc.service.IStaffInfoService;

/** 
* @author 唐国峰
* @Description:员工管理控制器
* @since 
* @date 2016-3-31 上午9:45:01  
*/
@Controller
@RequestMapping("/role")
public class StaffController {
	
	@Autowired
	private IStaffInfoService iStaffInfoService;
	
	@Autowired
	private IPostInfoServer iPostInfoServer;
	
	@Autowired
	private DictionariesCore dictionariesCore;
	
	/** 
	* @author 唐国峰  
	* @Description: 跳转到员工管理页面
	* @return String
	* @date 2016-3-31 上午11:11:04
	* @throws 
	*/
	@RequestMapping("/emp")
	public String toRoleEmpList(HttpServletRequest req){
		List<EducationInfoEntity> eduList = dictionariesCore.GetEducationList();
		List<NationInfoEntity> nationsList = dictionariesCore.GetNationInfoList();
		PageEntity entity = new PageEntity();
//		List<DeptInfo> depts = iDeptInfoServer.findall();
//		List<PostInfo> posts = iPostInfoServer.getListByParam(entity);
		req.setAttribute("educations", eduList);
		req.setAttribute("nations", nationsList);
//		req.setAttribute("depts", depts);
//		req.setAttribute("posts", posts);
		return "role/role-emp";
	}
	
	@RequestMapping("/test")
	public String test(HttpServletRequest req){
		return "role/test";
	}
	
	
	
	/** 
	* getStaffList(获取员工信息列表) 
	* @author 唐国峰  
	* @Description: 
	* @return PageEntity
	* @date 2016-4-5 下午2:18:41
	* @throws 
	*/
	@RequestMapping("/getAllStaff")
	@ResponseBody
	public PageEntity getStaffList(int start,int length,String personalName,String personalPhone,String personalIDCard,Long postId,
			HttpServletRequest request,HttpServletResponse res){

		//获取前台额外传递过来的查询条件  
//		String extra_search = request.getParameter("extra_search");
		int sType = IntegerAndString.StringToInt(request.getParameter("sType"), 0);		// 非员工中的管理员  1

		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String sKey = DbKeyUtil.GetDbCodeKey();
		param.put("personalName", personalName);
		param.put("personalPhone", personalPhone);
		param.put("personalIDCard", personalIDCard);
		param.put("postId", postId);
		param.put("sType", sType);
		param.put("sKey", sKey);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		iStaffInfoService.StaffInfosByParam(pager);
		return pager;
	}
	
	
	/** 
	* addStaff(增加员工) 
	* @author 唐国峰  
	* @Description: 
	* @return int 1:成功 0：失败
	* @date 2016-4-5 下午2:18:59
	* @throws 
	*/
	@RequestMapping("/addStaff")
	@ResponseBody
	public int addStaff(StaffInfo info,HttpServletRequest req,HttpServletResponse res){
		String graduatedDate = req.getParameter("graduatedDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		int result=0;
		try {
			if(graduatedDate !=null){
				date = format.parse(graduatedDate);
			}
			info.getBaseInfo().setGraduatedDATE(date);
			Date joinDate = new Date(); 
			String deptId= "1";
			String postId="1";
			result = iStaffInfoService.saveStaff(info, deptId, postId, joinDate);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	
	/** 
	* editStaff(修改员工信息) 
	* @author 唐国峰  
	* @Description: 
	* @return void
	* @date 2016-4-5 下午2:19:13
	* @throws 
	*/
	@RequestMapping("/editStaff")
	@ResponseBody
	public int editStaff(StaffInfo info,HttpServletRequest req,HttpServletResponse res){
		String graduatedDate = req.getParameter("graduatedDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		int result=0;
		try {
			if(graduatedDate !=null){
				date = format.parse(graduatedDate);
			}
			info.getBaseInfo().setGraduatedDATE(date);
			Date joinDate = new Date(); 
			String deptId= "1";
			String postId="1";
			result = iStaffInfoService.editStaff(info, deptId, postId, joinDate);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	
	/** 
	* delStaff(删除员工) 
	* @author 唐国峰  
	* @Description: 
	* @param ids 要删除的员工ids
	* @return void
	* @date 2016-4-5 下午2:20:40
	* @throws 
	*/
	@RequestMapping("/delStaff")
	@ResponseBody
	public int delStaff(String ids,HttpServletRequest req){
		int result=0;
		try {
			ids = ids.substring(1, ids.length()-1);
			String[] all = ids.split(",");
			for(String id : all){
				StaffInfo info = new StaffInfo();
				info.setId(Long.parseLong(id));
				result = iStaffInfoService.quit(info);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
}

