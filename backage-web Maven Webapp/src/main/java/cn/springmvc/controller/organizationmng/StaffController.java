 package cn.springmvc.controller.organizationmng;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.dictionaries.model.EducationInfoEntity;
import cn.dictionaries.model.NationInfoEntity;
import cn.springmvc.Util.HttpSessionUtil;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.dao.impl.DictionariesCore;
import cn.springmvc.model.Admin;
import cn.springmvc.model.PersonalBaseInfo;
import cn.springmvc.model.StaffInfo;
import cn.springmvc.service.IPostInfoServer;
import cn.springmvc.service.IStaffInfoService;
import cn.springmvc.service.SystemSetService;

/** 
* @author 唐国峰
* @Description:员工管理控制器
* @since 
* @date 2016-3-31 上午9:45:01  
*/
@Controller
@RequestMapping("/role")
public class StaffController  {
	
	@Autowired
	private IStaffInfoService iStaffInfoService;
	
	@Autowired
	private IPostInfoServer iPostInfoServer;
	
	@Autowired
	private DictionariesCore dictionariesCore;
	
	/**
	 * 操作日志记录
	 */
	@Resource(name="systemSetServiceImpl")
	private SystemSetService systemSetService;
	
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
		req.setAttribute("educations", eduList);
		req.setAttribute("nations", nationsList);
		return "role/role-emp";
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
	public PageEntity getStaffList(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
//		int sType = IntegerAndString.StringToInt(req.getParameter("sType"), 0);		// 1:非员工中的管理员    2: 非理财顾问中的员工
		String personalName = req.getParameter("personalName");
		String personalPhone = req.getParameter("personalPhone");
		String personalIDCard = req.getParameter("personalIDCard");
		String postId = req.getParameter("postId");

		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		String sKey = DbKeyUtil.GetDbCodeKey();
		param.put("personalName", personalName);
		param.put("personalPhone", personalPhone);
		param.put("personalIDCard", personalIDCard);
		param.put("postId", postId);
//		param.put("sType", sType);
		param.put("sKey", sKey);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		iStaffInfoService.StaffInfosByParam(pager);
		return pager;
	}
	
	
	/** 
	* @author 唐国峰  
	* @Description: 增加或修改员工信息
	* @return int 1:成功 0：失败
	* @date 2016-4-5 下午2:18:59
	* @throws 
	*/
	@RequestMapping("/addOrUpdateStaff")
	@ResponseBody
	public int addStaff(HttpServletRequest req){
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
		
		//获取解密参数
		StaffInfo info = new StaffInfo();
		PersonalBaseInfo baseInfo = new PersonalBaseInfo();
		String personalName = req.getParameter("personalName");
		baseInfo.setPersonalName(personalName);
		Long sexId = Long.parseLong(req.getParameter("sexId"));
		baseInfo.setId(sexId);
		String personalIDCard = req.getParameter("personalIDCard");
		baseInfo.setPersonalIDCard(personalIDCard);
		Integer nationId = Integer.parseInt(req.getParameter("nationId"));
		baseInfo.setNationId(nationId);
		String personalPhone = req.getParameter("personalPhone");
		baseInfo.setPersonalPhone(personalPhone);
		String qq = req.getParameter("qq");
		baseInfo.setQq(qq);
		String personalEmail = req.getParameter("personalEmail");
		baseInfo.setPersonalEmail(personalEmail);
		String homeTown = req.getParameter("homeTown");
		baseInfo.setHomeTown(homeTown);
		String houseAddress = req.getParameter("houseAddress");
		baseInfo.setHouseAddress(houseAddress);
		baseInfo.setHomeAddress(houseAddress);
		Integer education = Integer.parseInt(req.getParameter("education"));
		baseInfo.setEducation(education);
		String emerName = req.getParameter("emerName");
		info.setEmerName(emerName);
		String emerPhone = req.getParameter("emerPhone");
		info.setEmerPhone(emerPhone);
		
		info.setBaseInfo(baseInfo);
		String postId = req.getParameter("postId");
		String deptId= req.getParameter("deptId");
		String graduatedDate = req.getParameter("graduatedDate");
		String type = req.getParameter("type");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		int result=0;
		try {
			if(graduatedDate !=null){
				date = format.parse(graduatedDate);
			}
			info.getBaseInfo().setGraduatedDATE(date);
			Date joinDate = new Date(); 
			if(type.equals("1")){//增加操作
				logEntity.setlOptId(10301);
				result = iStaffInfoService.saveStaff(info, deptId, postId, joinDate,logEntity,sIpInfo);
			}else if(type.equals("2")){//修改操作
				logEntity.setlOptId(10302);
				result = iStaffInfoService.editStaff(info, deptId, postId, joinDate,logEntity,sIpInfo);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	/** 
	* delStaff(删除员工) 
	* @author 唐国峰  
	* @Description: 删除员工
	* @return void
	* @date 2016-4-5 下午2:20:40
	* @throws 
	*/
	@RequestMapping("/delStaff")
	@ResponseBody
	public int delStaff(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=103(员工管理)
		//optID=10303(离职)
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(103);
		logEntity.setlOptId(10303);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		int result=0;
		String ids = req.getParameter("ids");
		try {
			ids = ids.substring(1, ids.length()-1);
			String[] all = ids.split(",");
			for(String id : all){
				StaffInfo info = new StaffInfo();
				info.setId(Long.parseLong(id));
				result = iStaffInfoService.quit(info,logEntity,sIpInfo);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取所有职务信息
	 * @param request
	 * @return PageEntity  
	 * @date 2016-4-28 上午9:30:24
	 * @throws 
	 */
	@RequestMapping(value ="/getPostAll")
	@ResponseBody
	public PageEntity getPostAll(HttpServletRequest req){
		int start = 0;
		int length = 10000;//模拟不分页效果
		PageEntity pager = new PageEntity();
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		iPostInfoServer.getListByParam(pager);
		return pager;
	}
	
	
}

