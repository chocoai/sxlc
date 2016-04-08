package cn.springmvc.controller.frontconfig; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.Upload.FtpClientUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.controller.organizationmng.DeptController;
import cn.springmvc.model.MngTeamEntity;
import cn.springmvc.service.MngTeamService;

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
	public PageEntity getTeamData(int start,int length,String addDate,String name,HttpServletRequest request,HttpServletResponse res){
		PageEntity pager = new PageEntity();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("mngName", name);
		param.put("startTime", addDate);
		pager.setMap(param);
		pager.setPageNum(start/length+1);
		pager.setPageSize(length);
		List<MngTeamEntity> teams = mngTeamService.selectMngTeamListpage(pager);
		pager.setResults(teams);
		return pager;
	}
	
	
	/** 
	* @author 唐国峰  
	* @Description: 添加管理团队人员
	* @return int
	* @date 2016-4-7 上午11:27:19
	* @throws 
	*/
	@RequestMapping("/addMngTeam")
	@ResponseBody
	public int addMngTeam( MngTeamEntity entity,HttpServletRequest req,HttpServletResponse res){
		int result=0;
		entity.setStatu(1);
		entity.setOptId(1);
		result = mngTeamService.insertMngTeam(entity);
		return result;
	}
	
	
	/** 
	* @author 唐国峰  
	* @Description: 修改数据
	* @return int
	* @date 2016-4-7 下午2:10:16
	* @throws 
	*/
	@RequestMapping("/editMngTeam")
	@ResponseBody
	public int editMngTeam( MngTeamEntity entity,HttpServletRequest req,HttpServletResponse res){
		int result=0;
		entity.setStatu(1);
		entity.setOptId(1);
		result = mngTeamService.updateMngTeamByID(entity);
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
	public int enableMngTeam( MngTeamEntity entity,HttpServletRequest req,HttpServletResponse res){
		int result=0;
		result = mngTeamService.updateMngTeamStatuByID(entity);
		return result;
	}
	
	
	
}

