package  cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.ProjectTypeReplyDao;
import cn.springmvc.dao.ProjectTypeReplyListDao; 
import cn.springmvc.model.ProjectTypeReplyEntity;
import cn.springmvc.service.ProjectTypeReplyService;

import product_p2p.kit.pageselect.PageEntity; 
@Service("projectTypeReplyServiceImpl")
public class ProjectTypeReplyServiceImpl implements ProjectTypeReplyService {
	@Resource(name="projectTypeReplyDaoImpl")
	private ProjectTypeReplyDao projectTypeReplyDaoImpl;  
	@Resource(name="projectTypeReplyListDaoImpl")
	private ProjectTypeReplyListDao projectTypeReplyListDaoImpl;  
 
	@Override
	public int deleteProjectTypeReplyByID(int id) {
		
		int result=projectTypeReplyDaoImpl.deleteProjectTypeReplyByID(id); 
		return result;
	}

	@Override
	public int updateProjectTypeReplyByID(ProjectTypeReplyEntity entity) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目类型还款指南是否存在,如果已存在则不修改  
		ProjectTypeReplyEntity projectTypeGuideEntity= projectTypeReplyListDaoImpl.selectProjectTypeReplyIsExistByNAme(entity);
		if(projectTypeGuideEntity != null){
			return -1;
		} 
		int result=projectTypeReplyDaoImpl.updateProjectTypeReplyByID(entity); 
		return result;
	}
 
	@Override
	public List<ProjectTypeReplyEntity> selectProjectTypeReplyListpage(
			PageEntity pageEntity) {
		List<ProjectTypeReplyEntity> projectTypeGuideList=null;    
	 	projectTypeGuideList = projectTypeReplyListDaoImpl.selectProjectTypeReplyList(pageEntity);  
		return projectTypeGuideList; 
	}

	@Override
	public int insertProjectTypeReply(ProjectTypeReplyEntity entity) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目类型还款指南是否存在,如果已存在则不插入  
		ProjectTypeReplyEntity projectTypeGuideEntity= projectTypeReplyListDaoImpl.selectProjectTypeReplyIsExistByNAme(entity);
		if(projectTypeGuideEntity != null){
			return -1;
		}  
		int index =projectTypeReplyListDaoImpl.selectProjectTypeReplyEntityindex(); 
	    entity.setPtIndex(index+1); 
		return projectTypeReplyDaoImpl.insertProjectTypeReply(entity);
	}

	@Override
	public ProjectTypeReplyEntity selectProjectTypeReplyById(int id) {
		 if(id == 0){
			return null;
		 } 
		 ProjectTypeReplyEntity projectTypeGuideEntity= projectTypeReplyListDaoImpl.selectProjectTypeReplyByindex(id);
		 return projectTypeGuideEntity;
	} 
}
