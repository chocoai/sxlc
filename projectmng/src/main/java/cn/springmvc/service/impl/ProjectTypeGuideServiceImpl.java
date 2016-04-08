package  cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.ProjectTypeGuideDao;
import cn.springmvc.dao.ProjectTypeGuideListDao;
import cn.springmvc.dao.impl.ProjectTypeGuideDaoImpl;
import cn.springmvc.dao.impl.ProjectTypeGuideListDaoImpl;
import cn.springmvc.model.ProjectTypeGuideEntity;
import cn.springmvc.service.ProjectTypeGuideService;

import product_p2p.kit.pageselect.PageEntity; 
@Service("projectTypeGuideServiceImpl")
public class ProjectTypeGuideServiceImpl implements ProjectTypeGuideService {
	@Resource(name="projectTypeGuideDaoImpl")
	private ProjectTypeGuideDao projectTypeGuideDaoImpl;  
	@Resource(name="projectTypeGuideListDaoImpl")
	private ProjectTypeGuideListDao projectTypeGuideListDaoImpl;  
 
	@Override
	public int deleteProjectTypeGuideByID(int id) {
		
		int result=projectTypeGuideDaoImpl.deleteProjectTypeGuideByID(id); 
		return result;
	}

	@Override
	public int updateProjectTypeGuideByID(ProjectTypeGuideEntity entity) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目类型申请指南是否存在,如果已存在则不修改  
		ProjectTypeGuideEntity projectTypeGuideEntity= projectTypeGuideListDaoImpl.selectProjectTypeGuideIsExistByNAme(entity);
		if(projectTypeGuideEntity != null){
			return -1;
		} 
		int result=projectTypeGuideDaoImpl.updateProjectTypeGuideByID(entity); 
		return result;
	}
 
	@Override
	public List<ProjectTypeGuideEntity> selectProjectTypeGuideListpage(
			PageEntity pageEntity) {
		List<ProjectTypeGuideEntity> projectTypeGuideList=null;    
	 	projectTypeGuideList = projectTypeGuideListDaoImpl.selectProjectTypeGuideList(pageEntity);  
		return projectTypeGuideList; 
	}

	@Override
	public int insertProjectTypeGuide(ProjectTypeGuideEntity entity) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目类型申请指南是否存在,如果已存在则不插入  
		ProjectTypeGuideEntity projectTypeGuideEntity= projectTypeGuideListDaoImpl.selectProjectTypeGuideIsExistByNAme(entity);
		if(projectTypeGuideEntity != null){
			return -1;
		}  
		int index =projectTypeGuideListDaoImpl.selectProjectTypeGuideEntityindex(); 
		entity.setPtIndex(index+1); 
		return projectTypeGuideDaoImpl.insertProjectTypeGuide(entity);
	}

	@Override
	public ProjectTypeGuideEntity selectProjectTypeGuideById(int id) {
		 if(id == 0){
			return null;
		 } 
		 ProjectTypeGuideEntity projectTypeGuideEntity= projectTypeGuideListDaoImpl.selectProjectTypeGuideByindex(id);
		 return projectTypeGuideEntity;
	} 
}
