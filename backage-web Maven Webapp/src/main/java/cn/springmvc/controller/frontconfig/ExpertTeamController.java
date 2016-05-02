package cn.springmvc.controller.frontconfig;

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
import cn.springmvc.Util.HttpSessionUtil;
import cn.springmvc.Util.LoadUrlUtil;
import cn.springmvc.model.Admin;
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.service.ExpertTeamService;


@Controller
@RequestMapping(value ="/ExpertsController")
public class ExpertTeamController {
	
	
	@Resource(name="expertTeamServiceImpl")
	private ExpertTeamService expertTeamService;
	/**
	 * 增加
	 */
	@RequestMapping(value ="/insertExpertTeam")
	@ResponseBody
	public int insertExpertTeam(HttpServletRequest request){
		//Map<String ,Object> req,String mngName,String mngPost,String portraitUrl,String profile
		
		String mngName =request.getParameter("mngName");
		String mngPost =request.getParameter("mngPost");
		String portraitUrl =request.getParameter("portraitUrl");
		String profile = request.getParameter("profile");
		ExpertTeamEntity entity = new ExpertTeamEntity();
		entity.setMngName(mngName);
		entity.setMngPost(mngPost);
		entity.setPortraitUrl(portraitUrl);
		entity.setProfile(profile);
		entity.setOptId(1);
		entity.setStatu(1);
		
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			logentity.setiAdminId(userInfo.getId());
		}
		logentity.setlModuleId(505);
		logentity.setlOptId(50501);
		logentity.setsDetail("");
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac(null);
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		int    iResult =expertTeamService.insertExpertTeam(entity, logentity, sIpInfo);
		return iResult;
	}
	/**
	 * TODO 修改专家顾问
	 * 修改日期：
	 * return int
	 */
	@RequestMapping(value ="/updateExpertTeamByID")
	@ResponseBody
	public int updateExpertTeamByID(HttpServletRequest request){
		ExpertTeamEntity expertTeamEntity = new ExpertTeamEntity();
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		String mngName =request.getParameter("mngName");
		String mngPost =request.getParameter("mngPost");
		String portraitUrl =request.getParameter("portraitUrl");
		String profile = request.getParameter("profile");
		expertTeamEntity.setId(id);
		expertTeamEntity.setMngName(mngName);
		expertTeamEntity.setMngPost(mngPost);
		expertTeamEntity.setPortraitUrl(portraitUrl);
		expertTeamEntity.setProfile(profile);
		expertTeamEntity.setOptId(1);
		
		String[] sIpinfo = new String[6];
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			logentity.setiAdminId(userInfo.getId());
		}
		logentity.setlModuleId(505);
		logentity.setlOptId(50502);
		logentity.setsDetail("");
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac(null);
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		int iResult =expertTeamService.updateExpertTeamByID(expertTeamEntity, logentity, sIpinfo);
		return iResult;
	}
	/*
	 * TODO 查询专家顾问
	 * 修改日期：
	 * return int
	 * */
	@RequestMapping(value ="/selectExpertTeamListpage")
	@ResponseBody
	public PageEntity selectExpertTeamListpage(HttpServletRequest request){
		PageEntity pageEntity = new PageEntity();
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		 expertTeamService.selectExpertTeamListpage(pageEntity);
		return pageEntity;
	}
	/* @author  
	* @Description: 修改状态
	* @return int
	* @date 
	* @throws 
	*/
	@RequestMapping("/updateExpertTeamStatuByID")
	@ResponseBody
	public int updateExpertTeamStatuByID(HttpServletRequest request){
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"),0);
		ExpertTeamEntity expertTeamEntity = new ExpertTeamEntity();
		expertTeamEntity.setId(id);
		expertTeamEntity.setStatu(statu);
		
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			logentity.setiAdminId(userInfo.getId());
		}
		logentity.setlModuleId(505);
		logentity.setlOptId(50503);
		logentity.setsDetail("");
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac(null);
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		int iResult =expertTeamService.updateExpertTeamStatuByID(expertTeamEntity, logentity, sIpInfo);
		return iResult;
	}
	
}
