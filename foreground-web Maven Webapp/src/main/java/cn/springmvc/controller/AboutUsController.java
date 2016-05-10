package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import com.alibaba.fastjson.JSONObject;
 
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.FrequentlyAskedQuestionsEntity;
import cn.springmvc.model.LawsRegulationsEntity;
import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.model.MngTeamEntity;
import cn.springmvc.model.NewHandEntity;
import cn.springmvc.model.PlatformAnnouncementEntity;
import cn.springmvc.model.PlatformIntroduceEntity;
import cn.springmvc.model.ProductIntroduceEntity;
import cn.springmvc.model.RecruitmentEntity;
import cn.springmvc.model.SecurityGuaranteeEntity;
import cn.springmvc.service.ExpertTeamService;
import cn.springmvc.service.FrequentlyAskedQuestionsService;
import cn.springmvc.service.LawsRegulationsService;
import cn.springmvc.service.MediaReportsService;
import cn.springmvc.service.MngTeamService;
import cn.springmvc.service.NewHandService;
import cn.springmvc.service.PlatformAnnouncementService;
import cn.springmvc.service.PlatformIntroduceService; 
import cn.springmvc.service.ProductIntroduceService;
import cn.springmvc.service.RecruitmentListService;
import cn.springmvc.service.SecurityGuaranteeService;

@Controller
@RequestMapping("aboutUs")
public class AboutUsController {
	
	@Autowired
	private PlatformIntroduceService platformIntroduceService;
	
	@Autowired
	private MngTeamService mngTeamService;
	
	@Autowired
	private ExpertTeamService expertTeamService;
	
	@Autowired
	private PlatformAnnouncementService platformAnnouncementService;
	
	@Autowired
	private MediaReportsService mediaReportsService;
	
	@Autowired
	private SecurityGuaranteeService securityGuaranteeService;
	
	@Autowired
	private NewHandService newHandService;
	
	@Autowired
	private FrequentlyAskedQuestionsService frequentlyAskedQuestionsService;
	
	@Autowired
	private LawsRegulationsService lawsRegulationsService;
	
	@Autowired
	private RecruitmentListService recruitmentListService;
	
	@Autowired
	private ProductIntroduceService productIntroduceService;
	 
	/**
	 * 查询产品介绍
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/ProductIntroduce",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ProductIntroduce(HttpServletRequest request) { 
		ProductIntroduceEntity entity = productIntroduceService.selectProductIntroduceList(1);
	    return JSONObject.toJSONString(entity);
	}
	
	
	
	/**
	 * 查询平台简介
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/PlatformIntroduce",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String PlatformIntroduce(HttpServletRequest request) { 
		PlatformIntroduceEntity entity = platformIntroduceService.selectPlatformIntroduceList();
	    return JSONObject.toJSONString(entity);
	}
	
	
	
	/**
	 * 查询专家顾问
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/ExpertTeam",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ExpertTeam(HttpServletRequest request) {  
		List<ExpertTeamEntity> list = expertTeamService.selectExpertTeamfront(); 
		return JSONObject.toJSONString(list);  
	}
	
	/**
	 * 查询管理团队
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/MngTeam",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String MngTeam(HttpServletRequest request) { 
		int start       =  IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length      =  IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		PageEntity pageEntity    = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>(); 
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<MngTeamEntity> list = mngTeamService.selectMngTeamListpage(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity);  
	}
	
	
	/**
	 * 根据ID查询专家顾问详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午4:50:07
	 */
	@RequestMapping(value="/ExpertTeamDetail_{id:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ExpertTeamDetail(HttpServletRequest request,@PathVariable String id){
		
		long ExpertTeamID = 0;//专家顾问ID
		try {
			ExpertTeamID = Long.parseLong(id);
		} catch (Exception e) {
			return null;
		} 
		ExpertTeamEntity entity = expertTeamService.selectExpertTeamByID(ExpertTeamID);
		return JSONObject.toJSONString(entity);  
	}
	
	/**
	 * 网站公告
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/Platform",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String Platform(HttpServletRequest request) { 
		int start       =  IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length      =  IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		PageEntity pageEntity    = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>(); 
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<PlatformAnnouncementEntity> list = platformAnnouncementService.selectPlatformList(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity);  
	}
	
	/**
	 * 根据ID查询网站公告详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午4:50:07
	 */
	@RequestMapping(value="/PlatformDetail_{id:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String PlatformDetail(HttpServletRequest request,@PathVariable String id){
		
		long PlatformID = 0;//网站公告ID
		try {
			PlatformID = Long.parseLong(id);
		} catch (Exception e) {
			return null;
		} 
		PlatformAnnouncementEntity entity = platformAnnouncementService.selectPlatformByID(PlatformID);
		return JSONObject.toJSONString(entity);  
	}
	
	
	/**
	 * 查询媒体报道
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/MediaReports",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String MediaReports(HttpServletRequest request) { 
		int start       =  IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length      =  IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		PageEntity pageEntity    = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>(); 
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<MediaReportsEntity> list = mediaReportsService.selectMediaReportsListpage(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity);  
	}
	
	/**
	 * 根据ID查询媒体报道详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午4:50:07
	 */
	@RequestMapping(value="/MediaReport_{id:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String MediaReport(HttpServletRequest request,@PathVariable String id){
		
		long MediaReportsID = 0;//网站公告ID
		try {
			MediaReportsID = Long.parseLong(id);
		} catch (Exception e) {
			return null;
		} 
		MediaReportsEntity entity = mediaReportsService.selectMediaReportsByID(MediaReportsID);
		return JSONObject.toJSONString(entity);  
	}
	
	/**
	 * 查询新手指南
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/newHand",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String newHand(HttpServletRequest request) { 
		NewHandEntity entity = newHandService.selectNewHandList();
	    return JSONObject.toJSONString(entity);
	}
	
	/**
	 * 查询常见问题
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/frequentlyAskedQuestion",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String frequentlyAskedQuestion(HttpServletRequest request) { 
		FrequentlyAskedQuestionsEntity entity = frequentlyAskedQuestionsService.selectFrequentlyAskedQuestionsList();
	    return JSONObject.toJSONString(entity);
	}
	
	/**
	 * 查询安全保障
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/securityGuaranteef",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String securityGuaranteef(HttpServletRequest request) { 
		SecurityGuaranteeEntity entity = securityGuaranteeService.selectSecurityGuaranteeList(1);
	    return JSONObject.toJSONString(entity);
	}
	
	
	/**
	 * 查询法律法规
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/LawsRegula",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String LawsRegula(HttpServletRequest request) { 
		LawsRegulationsEntity entity = lawsRegulationsService.selectLawsRegulationsList();
	    return JSONObject.toJSONString(entity);
	}
	
	/**
	 * 查询招贤纳士
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午8:13:58
	 */
	@RequestMapping(value="/Recruitment",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String Recruitment(HttpServletRequest request) { 
		int start       =  IntegerAndString.StringToInt(request.getParameter("start"),1) ;
		int length      =  IntegerAndString.StringToInt(request.getParameter("length"),10) ; 
		PageEntity pageEntity    = new PageEntity();
		Map<String,Object> param =  new HashMap<String, Object>(); 
		pageEntity.setPageNum(start);
		pageEntity.setPageSize(length);
		pageEntity.setMap(param);
		List<RecruitmentEntity> list = recruitmentListService.selectRecruitmentsList(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return JSONObject.toJSONString(pageEntity);  
	}
	
	
	
	/**
	 * 根据ID查询招贤纳士详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param request
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-5-3 下午4:50:07
	 */
	@RequestMapping(value="/RecruitmentDetail_{id:[0-9]+}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String RecruitmentDetail(HttpServletRequest request,@PathVariable String id){
		
		long RecruitmentID = 0;//网站公告ID
		try {
			RecruitmentID = Long.parseLong(id);
		} catch (Exception e) {
			return null;
		} 
		RecruitmentEntity entity = recruitmentListService.selectRecruitmentByID(RecruitmentID);
		return JSONObject.toJSONString(entity);  
	}
	
	 
	@RequestMapping("/platformIntroduction")
	public String platformIntroduction(){
		return "aboutUs/platformIntroduction";
	}
	@RequestMapping("/managementTeam")
	public String managementTeam(){
		return "aboutUs/managementTeam";
	}
	@RequestMapping("/expertAdvisor")
	public String expertAdvisor(){
		return "aboutUs/expertAdvisor";
	}
	@RequestMapping("/productIntroduction")
	public String productIntroduction(){
		return "aboutUs/productIntroduction";
	}
	@RequestMapping("/webBoard")
	public String webBoard(){
		return "aboutUs/webBoard";
	}
	@RequestMapping("/webBoardDetail")
	public String webBoardDetail(){
		return "aboutUs/webBoardDetail";
	}
	@RequestMapping("/mediaCoverage")
	public String mediaCoverage(){
		return "aboutUs/mediaCoverage";
	}
	@RequestMapping("/mediaCoverageDetail")
	public String mediaCoverageDetail(){
		return "aboutUs/mediaCoverageDetail";
	}
	@RequestMapping("/securityGuarantee")
	public String securityGuarantee(){
		return "aboutUs/securityGuarantee";
	}
	@RequestMapping("/newbieGuide")
	public String newbieGuide(){
		return "aboutUs/newbieGuide";
	}
	@RequestMapping("/commonProblem")
	public String commonProblem(){
		return "aboutUs/commonProblem";
	}
	@RequestMapping("/legalRegulation")
	public String legalRegulation(){
		return "aboutUs/legalRegulation";
	}
	@RequestMapping("/recruitmentInformation")
	public String recruitmentInformation(){
		return "aboutUs/recruitmentInformation";
	}
}
