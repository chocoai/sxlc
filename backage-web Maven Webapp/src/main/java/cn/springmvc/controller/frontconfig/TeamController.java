package cn.springmvc.controller.frontconfig; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.HttpIp.AddressUtils;
import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.Admin;
import cn.springmvc.model.MngTeamEntity;
import cn.springmvc.model.Operation;
import cn.springmvc.service.MngTeamService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

/** 
* @author 唐国峰
* @Description:管理团队控制器
* @since 
* @date 2016-4-7 上午9:37:43  
*/
@Controller
@RequestMapping("/front")
public class TeamController {
	
	@Resource(name="mngTeamServiceImpl")
	private MngTeamService mngTeamService;
	
	/** 
	* @author 唐国峰  
	* @Description: 跳转到管理团队页面
	* @return String
	* @date 2016-4-7 上午9:45:09
	* @throws 
	*/
	@RequestMapping("/toTeamList")
	public String toManagementTeamList(HttpServletRequest req){
		HttpSession session = HttpSessionUtil.getSession(req);
		List<Operation> operations = null;
		if(session.getAttribute("operationList") != null){
			operations=(List<Operation>)session.getAttribute("operationList");
		}
		req.setAttribute("operations", operations);
		String hostPath = FtpClientUtil.getFtpFilePath();
		hostPath = hostPath.substring(0, hostPath.length()-1);
		req.setAttribute("hostPath", hostPath);
		return "frontconfig/cf-managementTeam";
	}
	
	
	/** 
	* @author 唐国峰  
	* @Description: 获取所有管理团队信息
	* @return PageEntity
	* @date 2016-4-7 上午11:24:39
	* @throws 
	*/
	@RequestMapping("/getTeamData")
	@ResponseBody
	public PageEntity getTeamData(HttpServletRequest req){
		int start = Integer.parseInt(req.getParameter("start"));
		int length = Integer.parseInt(req.getParameter("length"));
		String mngName = req.getParameter("mngName");
		String startTime = req.getParameter("startTime");
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("mngName", mngName);
		param.put("startTime", startTime);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		mngTeamService.selectMngTeamListpage(pager);
		return pager;
	}
	
	
	/** 
	* @author 唐国峰  
	* @Description: 添加或修改管理团队人员
	* @return int
	* @date 2016-4-7 上午11:27:19
	* @throws 
	*/
	@RequestMapping("/addOrUpdateTeam")
	@ResponseBody
	public int addMngTeam(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=504(管理团队管理)
		//optID=50401(添加) 50402 修改
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(504);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		MngTeamEntity entity = new  MngTeamEntity();
		//获取解密参数
		String mngName = req.getParameter("mngName");
		entity.setMngName(mngName);
		String mngPost = req.getParameter("mngPost");
		entity.setMngPost(mngPost);
		String portraitUrl = req.getParameter("portraitUrl");
		entity.setPortraitUrl(portraitUrl);
		String profile = req.getParameter("profile");
		entity.setProfile(profile);
		
		entity.setStatu(1);//状态
		entity.setOptId(admin.getId());//操作者id
		
		int result=0;
		String type = req.getParameter("type");
		if(type.equals("1")){//增加操作
			logEntity.setlOptId(50401);
			result = mngTeamService.insertMngTeam(entity,logEntity,sIpInfo);
		}else if(type.equals("2")){//修改操作
			logEntity.setlOptId(50402);
			Long teamId = Long.parseLong(req.getParameter("teamId"));
			entity.setId(teamId);
			result = mngTeamService.updateMngTeamByID(entity,logEntity,sIpInfo);
		}
		return result;
	}
	
	/** 
	* @author 唐国峰  
	* @Description: 启用或停用功能
	* @return int
	* @date 2016-4-7 下午2:14:50
	* @throws 
	*/
	@RequestMapping("/enableMngTeam")
	@ResponseBody
	public int enableMngTeam(HttpServletRequest req){
		//操作日志参数
		HttpSession session = HttpSessionUtil.getSession(req);
		Admin admin = (Admin)session.getAttribute("LoginPerson");
		//moduleID=504(管理团队管理)
		//optID=50403(停用/启用）
		InsertAdminLogEntity logEntity = new InsertAdminLogEntity();
		String [] sIpInfo = new String[8];
		logEntity.setiAdminId(admin.getId());
		logEntity.setlModuleId(504);
		logEntity.setlOptId(50403);
		logEntity.setsIp(AddressUtils.GetRemoteIpAddr(req, sIpInfo));
		logEntity.setsMac(null);
		logEntity.setsUrl(LoadUrlUtil.getFullURL(req));
		
		MngTeamEntity entity = new  MngTeamEntity();
		int statu = Integer.parseInt(req.getParameter("statu"));
		entity.setStatu(statu);
		Long id = Long.parseLong(req.getParameter("id"));
		entity.setId(id);
		int result=0;
		result = mngTeamService.updateMngTeamStatuByID(entity,logEntity,sIpInfo);
		return result;
	}
	
	
	
}

