//package cn.springmvc.controller.frontconfig;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import cn.springmvc.model.ExpertTeamEntity;
//import cn.springmvc.service.ExpertTeamService;
//import product_p2p.kit.pageselect.PageEntity;
//
//
//@Controller
//@RequestMapping(value ="/ExpertsController")
//public class ExpertTeamController {
//	
//	
//	@Resource(name="expertTeamServiceImpl")
//	private ExpertTeamService expertTeamService;
//	/**
//	 * 增加
//	 */
//	@RequestMapping(value ="/insertExpertTeam")
//	@ResponseBody
//	public int insertExpertTeam(Map<String ,Object> req,Integer id,String mngName,
//			String mngPost,String portraitUrl,String profile){
//		ExpertTeamEntity expertTeamEntity = new ExpertTeamEntity();
//		expertTeamEntity.setMngName(mngName);
//		expertTeamEntity.setMngPost(mngPost);
//		expertTeamEntity.setPortraitUrl(portraitUrl);
//		expertTeamEntity.setProfile(profile);
//		expertTeamEntity.setOptId(1);
//		expertTeamEntity.setStatu(1);
//		int    iResult =expertTeamService.insertExpertTeam(expertTeamEntity);
//		return iResult;
//	}
//	/**
//	 * TODO 修改专家顾问
//	 * 修改日期：
//	 * return int
//	 */
//	@RequestMapping(value ="/updateExpertTeamByID")
//	@ResponseBody
//	public int updateExpertTeamByID(Integer id,String mngName,String mngPost,String portraitUrl,String profile){
//			ExpertTeamEntity expertTeamEntity = new ExpertTeamEntity();
//			expertTeamEntity.setId(id);
//			expertTeamEntity.setMngName(mngName);
//			expertTeamEntity.setMngPost(mngPost);
//			expertTeamEntity.setPortraitUrl(portraitUrl);
//			expertTeamEntity.setProfile(profile);
//			expertTeamEntity.setOptId(1);
//		int iResult =expertTeamService.updateExpertTeamByID(expertTeamEntity);
//		return iResult;
//	}
//	/*
//	 * TODO 查询专家顾问
//	 * 修改日期：
//	 * return int
//	 * */
//	@RequestMapping(value ="/selectExpertTeamListpage")
//	@ResponseBody
//	public PageEntity selectExpertTeamListpage(Map<String ,Object> req,Integer pageNum,Integer pageSize,Integer id,
//			String mngName,String mngPost,String portraitUrl,String profile,String optDate,String adminName){
//		PageEntity page =new PageEntity();
//		req.put("mngName", null);
//		req.put("statu", -1);
//		if (pageNum != null) {
//			page.setPageNum(1);
//		}
//		if (pageSize != null) {
//			page.setPageSize(6);
//		}
//		page.setMap(req);
//		List<ExpertTeamEntity> list  = expertTeamService.selectExpertTeamListpage(page);
//		page.setResults(list);
//		return page;
//	}
//	/* @author  
//	* @Description: 修改状态
//	* @return int
//	* @date 
//	* @throws 
//	*/
//	@RequestMapping("/updateExpertTeamStatuByID")
//	@ResponseBody
//	public int updateExpertTeamStatuByID( Integer id ,Integer statu){
//		ExpertTeamEntity expertTeamEntity = new ExpertTeamEntity();
//		expertTeamEntity.setId(id);
//		expertTeamEntity.setStatu(statu);
//		int iResult =expertTeamService.updateExpertTeamStatuByID(expertTeamEntity);
//		return iResult;
//	}
//	
//}
