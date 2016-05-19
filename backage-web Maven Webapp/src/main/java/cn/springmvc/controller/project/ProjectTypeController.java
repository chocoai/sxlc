package cn.springmvc.controller.project; 

import java.util.ArrayList;
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
import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.service.MemberAttestTypeService;
import cn.springmvc.service.ProjectBaseInfoService;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description:  项目管理控制器
* @date 2016-4-28 下午12:35:19 
*/
@Controller
@RequestMapping("/project")
public class ProjectTypeController {
	
	@Resource(name="projectBaseInfoServiceImpl")
	private ProjectBaseInfoService projectBaseInfoService;
	
	@Resource(name="memberAttestTypeServiceImpl")
	private MemberAttestTypeService memberAttestTypeService;
	
	
	/** 
	 * @author 唐国峰 
	 * @Description:跳转到项目类型管理页面 
	 * @param req
	 * @return String  
	 * @date 2016-4-28 下午12:38:13
	 * @throws 
	 */
	@RequestMapping("/toProTypePg")
	public String toProTypePg(HttpServletRequest req){
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		return "project/pro_type";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 加载项目类型详细页面
	 * @param req
	 * @return String  
	 * @date 2016-4-29 下午1:46:47
	 * @throws 
	 */
	@RequestMapping("/toProTypeDetail")
	public String toProTypeDetail(HttpServletRequest req){
		//获取FTP服务器地址（用于展示图片）
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		//获取认证项列表
		MemberAttestTypeEntity entity = new MemberAttestTypeEntity();
		entity.setStatu(1);//只查询已启用的认证列表
		List<MemberAttestTypeEntity> authentication = new ArrayList<MemberAttestTypeEntity>();
		entity.setMemberType(0);
		authentication = memberAttestTypeService.selectMemberAttestTypeByMemberType(entity);
		req.setAttribute("person", authentication);//个人
		entity.setMemberType(1);
		authentication = memberAttestTypeService.selectMemberAttestTypeByMemberType(entity);
		req.setAttribute("enterprise", authentication);//企业
		
		//如果是修改操作，获取要修改的项目类型id
		String id = req.getParameter("content");
		if(id !=null && !"".equals(id)){
			//项目类型所需认证项
			authentication = projectBaseInfoService.selectMemberAttestByprojectType(Long.parseLong(id));
			req.setAttribute("authValue", authentication);
			//项目类型详细信息
			ProjectBaseInfoEntity project = projectBaseInfoService.selectProjectBaseInfoById(Long.parseLong(id));
			req.setAttribute("project", project);
		}
		return "project/pro-add/add_type";
	}
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 修改项目类型信息时获取该类型所需的认证项目
	 * @return List<MemberAttestTypeEntity>  
	 * @date 2016-5-3 上午10:16:48
	 * @throws 
	 */
	@RequestMapping("/getAuthentication")
	@ResponseBody
	public List<MemberAttestTypeEntity> getAuthentication(HttpServletRequest req){
		Long id = Long.parseLong(req.getParameter("id"));//项目类型id
		List<MemberAttestTypeEntity> authentication = new ArrayList<MemberAttestTypeEntity>();
		authentication = projectBaseInfoService.selectMemberAttestByprojectType(id);
		return authentication;
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description: 获取分页项目类型数据
	 * @param req
	 * @return PageEntity  
	 * @date 2016-4-28 下午3:00:05
	 * @throws 
	 */
	@RequestMapping("/getProTypeData")
	@ResponseBody
	public PageEntity getProTypeData(HttpServletRequest req){
		//获取解密后参数
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String projectName = req.getParameter("projectName");
		String statu = req.getParameter("statu");
		//设置查询参数
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("projectName", projectName);
		param.put("statu", statu);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		projectBaseInfoService.selectProjectBaseInfoListpage(pager);
		return pager;
	}
	
	/** 
	* @author 唐国峰  
	* @Description: 启用或停用功能
	* @return int
	* @date 2016-5-3 上午9:34:50
	* @throws 
	*/
	@RequestMapping("/enableProType")
	@ResponseBody
	public int enableProType(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=301(项目类型管理)
		//optID=30103(停用/启用）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(301);
		logEntity.setlOptId(30103);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		ProjectBaseInfoEntity entity = new  ProjectBaseInfoEntity();
		int statu = Integer.parseInt(req.getParameter("statu"));
		entity.setStatu(statu);
		Long id = Long.parseLong(req.getParameter("id"));
		entity.setId(id);
		int result=0;
		result = projectBaseInfoService.updateProjectBaseInfoStatuByID(entity,logEntity,sIpInfo);
		return result;
	}
	
	
	
	/** 
	 * @author 唐国峰 
	 * @Description:新增或修改项目类型 
	 * @param req
	 * @return int  
	 * @date 2016-5-3 下午2:03:18
	 * @throws 
	 */
	@RequestMapping("/addOrUpdateProType")
	@ResponseBody
	public int addOrUpdateProType(HttpServletRequest req){
		//操作日志参数
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=301(项目类型管理)
		//optID=30101(添加） 30102(修改）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(60106);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		//获取解密参数
		Map<String,Object> param=new HashMap<String,Object>();
		String projectName = req.getParameter("projectName");
		param.put("projectName",projectName);
		String minAmount = req.getParameter("minAmount");
		param.put("minAmount",IntegerAndString.StringToInt(minAmount));
		String maxAmount = req.getParameter("maxAmount");
		param.put("maxAmount",IntegerAndString.StringToInt(maxAmount));
		String minRate = req.getParameter("minRate");
		param.put("minRate",IntegerAndString.StringToInt(minRate));
		String maxRate = req.getParameter("maxRate");
		param.put("maxRate",IntegerAndString.StringToInt(maxRate));
		Integer minDaytimeY = Integer.parseInt(req.getParameter("minDaytimeY"));
		param.put("minDaytimeY",minDaytimeY);
		Integer maxDaytimeY = Integer.parseInt(req.getParameter("maxDaytimeY"));
		param.put("maxDaytimeY",maxDaytimeY);
		param.put("unitY", 0);
		Integer minDaytimeM = Integer.parseInt(req.getParameter("minDaytimeM"));
		param.put("minDaytimeM",minDaytimeM );
		Integer maxDaytimeM = Integer.parseInt(req.getParameter("maxDaytimeM"));
		param.put("maxDaytimeM",maxDaytimeM);
		param.put("unitM", 1);
		Integer minDaytimeD = Integer.parseInt(req.getParameter("minDaytimeD"));
		param.put("minDaytimeD",minDaytimeD);
		Integer maxDaytimeD = Integer.parseInt(req.getParameter("maxDaytimeD"));
		param.put("maxDaytimeD",maxDaytimeD);
		param.put("unitD", 2);
		String isMortgage = req.getParameter("isMortgage");
		param.put("isMortgage",isMortgage);
		String applyMember = req.getParameter("applyMember");
		param.put("applyMember",applyMember);
		String Datum = req.getParameter("Datum");
		param.put("Datum",Datum);
		String picIcon = req.getParameter("picIcon");
		param.put("picIcon",picIcon);
		String picUrl = req.getParameter("picUrl");
		param.put("picUrl",picUrl);
		String briefIntroduction = req.getParameter("briefIntroduction");
		param.put("briefIntroduction",briefIntroduction);
		String contentg = req.getParameter("contentg");
		param.put("contentg",contentg);
		String contentr = req.getParameter("contentr");
		param.put("contentr",contentr);
		
		int result=0;
		String type = req.getParameter("type");//操作类型
		if(type.equals("1")){//增加操作
			logEntity.setlOptId(30101);
			result = projectBaseInfoService.addProjectBaseType(param,logEntity,sIpInfo);
		}else if(type.equals("2")){//修改操作
			logEntity.setlOptId(30102);
			String lId = req.getParameter("lId");
			param.put("lId", lId);
			result = projectBaseInfoService.updateProjectBaseType(param,logEntity,sIpInfo);
		}
		return result;
	}
	
	
	
}

