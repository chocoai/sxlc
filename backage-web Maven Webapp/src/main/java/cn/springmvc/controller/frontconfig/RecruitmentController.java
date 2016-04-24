//package cn.springmvc.controller.frontconfig;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import product_p2p.kit.pageselect.PageEntity;
//
//import cn.springmvc.model.ExpertTeamEntity;
//import cn.springmvc.model.RecruitmentEntity;
//import cn.springmvc.service.RecruitmentListService;
//
//@Controller
//@RequestMapping(value ="/RecruitmentController")
//public class RecruitmentController {
//	
//	@Resource(name="recruitmentServiceImpl")
//
//	private RecruitmentListService recruitmentListService;
//	/**
//	 * 新增
//	 * @param entity 媒体报道实体
//	 * @return 0：数据为空;-1：该名称的媒体报道已存在;1:添加成功
//	 */
//	@RequestMapping(value ="/insertRecruitments")
//	@ResponseBody
//	public int insertRecruitments(Map<String ,Object> req,Integer id,
//			String name,String area,String jobResponsibilities,String jobRequirements,String statu){
//		RecruitmentEntity reEntity =new RecruitmentEntity();
//		reEntity.setName(name);
//		reEntity.setArea(area);
//		reEntity.setJobRequirements(jobRequirements);
//		reEntity.setJobResponsibilities(jobResponsibilities);
//		reEntity.setOptId(1);
//		reEntity.setStatu(2);
//		int    iResult=recruitmentListService.insertRecruitments(reEntity);
//		return iResult;
//	}
//	/**
//	 * 修改招贤
//	 * @param entity  
//	 * @return 0：失败；1成功
//	 */
//	@RequestMapping(value ="/updateRecruitments")
//	@ResponseBody
//	public int updateRecruitments(Integer id,
//			String name,String area,String jobResponsibilities,String jobRequirements,String statu,String adminName){
//		RecruitmentEntity reEntity =new RecruitmentEntity();
//		reEntity.setId(id);
//		reEntity.setName(name);
//		reEntity.setArea(area);
//		reEntity.setJobRequirements(jobRequirements);
//		reEntity.setJobResponsibilities(jobResponsibilities);
//		int    iResult=recruitmentListService.updateRecruitments(reEntity);
//		return iResult;
//	}
//	
//	/**
//	 * 分页查询招贤
//	 * @param entity 
//	 * @return 0：失败；1成功
//	 */
//	@RequestMapping(value ="/selectRecruitmentsList")
//	@ResponseBody
//	public PageEntity selectRecruitmentsList(Map<String ,Object> req,Integer pageNum,Integer pageSize,Integer id,
//			String name,String area,String jobResponsibilities,String jobRequirements,String statu,String adminName){
//		PageEntity page =new PageEntity();
////		req.put("mngName", null);
//		req.put("statu", -1);
//		if (pageNum != null) {
//			page.setPageNum(pageNum);
//		}
//		if (pageSize != null) {
//			page.setPageSize(pageSize);
//		}
//		page.setMap(req);
//		List<RecruitmentEntity> list  = recruitmentListService.selectRecruitmentsList(page);
//		page.setResults(list);
//		return page;
//	}
//	 /**
//		 * 停用或启用招贤报道信息
//		 * @param entity  statu(0:无效 1：有效),id
//		 * @return 0:失败 1：成功 
//		 */
//	@RequestMapping(value ="/updateRecruitmentStatuByID")
//	@ResponseBody
//	public int updateRecruitmentStatuByID(Integer id ,Integer statu){
//		RecruitmentEntity reEntity =new RecruitmentEntity();
//		reEntity.setId(id);
//		reEntity.setStatu(statu);
//		int iResult =recruitmentListService.updateRecruitmentStatuByID(reEntity);
//		return iResult;
//	}
//	
//	/**
//	 * 查询单个 
//	 */
//	@RequestMapping(value ="/selectRecruitmentByID")
//	@ResponseBody
//	public RecruitmentEntity selectRecruitmentByID(Integer id){
//		RecruitmentEntity reEntity =recruitmentListService.selectRecruitmentByID(id);
//		System.out.println(reEntity.getJobResponsibilities());
//		return reEntity;
//	}
//	
//}
