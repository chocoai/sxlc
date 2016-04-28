package cn.springmvc.controller.frontconfig;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
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
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.RecruitmentEntity;
import cn.springmvc.service.RecruitmentListService;
import cn.springmvc.util.HttpSessionUtil;
import cn.springmvc.util.LoadUrlUtil;

@Controller
@RequestMapping(value ="/RecruitmentController")
public class RecruitmentController {
	
	@Resource(name="recruitmentServiceImpl")

	private RecruitmentListService recruitmentListService;
	/**
	 * 新增
	 * @param entity 媒体报道实体
	 * @return 0：数据为空;-1：该名称的媒体报道已存在;1:添加成功
	 */
	@RequestMapping(value ="/insertRecruitments")
	@ResponseBody
	public int insertRecruitments(HttpServletRequest request){
		String name = request.getParameter("name");
		String area = request.getParameter("area");
		String jobResponsibilities = request.getParameter("jobResponsibilities");
		String jobRequirements = request.getParameter("jobRequirements");
		
		RecruitmentEntity reEntity =new RecruitmentEntity();
		reEntity.setName(name);
		reEntity.setArea(area);
		reEntity.setJobRequirements(jobRequirements);
		reEntity.setJobResponsibilities(jobResponsibilities);
		reEntity.setStatu(1);
		
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			reEntity.setOptId(userInfo.getId());
			logentity.setiAdminId(userInfo.getId());
		}
		logentity.setlModuleId(508);
		logentity.setlOptId(50801);
		logentity.setsDetail("");
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac(null);
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		int    iResult=recruitmentListService.insertRecruitments(reEntity, logentity, sIpInfo);
		return iResult;
	}
	
	/**
	 * 修改招贤
	 * @param entity  
	 * @return 0：失败；1成功
	 */
	@RequestMapping(value ="/updateRecruitments")
	@ResponseBody
	public int updateRecruitments(HttpServletRequest request){
		long id =IntegerAndString.StringToLong(request.getParameter("id"),0);
		String name = request.getParameter("name");
		String area = request.getParameter("area");
		String jobResponsibilities = request.getParameter("jobResponsibilities");
		String jobRequirements = request.getParameter("jobRequirements");
		
		RecruitmentEntity reEntity =new RecruitmentEntity();
		reEntity.setId(id);
		reEntity.setName(name);
		reEntity.setArea(area);
		reEntity.setJobRequirements(jobRequirements);
		reEntity.setJobResponsibilities(jobResponsibilities);
		reEntity.setStatu(1);
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			reEntity.setOptId(userInfo.getId());
			logentity.setiAdminId(userInfo.getId());
		}
		logentity.setlModuleId(508);
		logentity.setlOptId(50802);
		logentity.setsDetail("");
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac(null);
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		int    iResult=recruitmentListService.updateRecruitments(reEntity, logentity, sIpInfo);
		return iResult;
	}
	
	/**
	 * 分页查询招贤
	 * @param entity 
	 * @return 0：失败；1成功
	 */
	@RequestMapping(value ="/selectRecruitmentsList")
	@ResponseBody
	public PageEntity selectRecruitmentsList(HttpServletRequest request){
		PageEntity pageEntity = new PageEntity();
		int pageSize = IntegerAndString.StringToInt(request.getParameter("length"), 10) ;//每页显示行数
		int page = IntegerAndString.StringToInt(request.getParameter("start"), 1) ;
		page = page/pageSize + 1;	//当前页数
		pageEntity.setPageNum(page);
		pageEntity.setPageSize(pageSize);
		pageEntity.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
		recruitmentListService.selectRecruitmentsList(pageEntity);
		return pageEntity;
	}
	 /**
	 * 停用或启用招贤报道信息
	 * @param entity  statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	@RequestMapping(value ="/updateRecruitmentStatuByID")
	@ResponseBody
	public int updateRecruitmentStatuByID(HttpServletRequest request){
		long id = IntegerAndString.StringToLong(request.getParameter("id"),0);
		int statu = IntegerAndString.StringToInt(request.getParameter("statu"),0);
		RecruitmentEntity reEntity =new RecruitmentEntity();
		reEntity.setId(id);
		reEntity.setStatu(statu);
		
		InsertAdminLogEntity logentity = new InsertAdminLogEntity();
		HttpSession session = HttpSessionUtil.getSession(request);
		String [] sIpInfo = new String[6];
		Admin userInfo = (Admin)session.getAttribute("LoginPerson");
		if (userInfo != null) {
			logentity.setiAdminId(userInfo.getId());
		}
		logentity.setlModuleId(508);
		logentity.setlOptId(50802);
		logentity.setsDetail("");
		logentity.setsIp(AddressUtils.GetRemoteIpAddr(request, sIpInfo));
		logentity.setsMac(null);
		logentity.setsUrl(LoadUrlUtil.getFullURL(request));
		int iResult =recruitmentListService.updateRecruitmentStatuByID(reEntity, logentity, sIpInfo);
		return iResult;
	}
	
	/**
	 * 查询单个 
	 */
	@RequestMapping(value ="/selectRecruitmentByID")
	@ResponseBody
	public RecruitmentEntity selectRecruitmentByID(Integer id){
		RecruitmentEntity reEntity =recruitmentListService.selectRecruitmentByID(id);
		System.out.println(reEntity.getJobResponsibilities());
		return reEntity;
	}
	
}
