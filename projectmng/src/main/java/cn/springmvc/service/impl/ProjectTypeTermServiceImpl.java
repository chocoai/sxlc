package  cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.ProjectTypeTermDao;
import cn.springmvc.dao.ProjectTypeTermListDao;
import cn.springmvc.dao.impl.ProjectTypeTermDaoImpl;
import cn.springmvc.dao.impl.ProjectTypeTermListDaoImpl;
import cn.springmvc.model.ProjectTypeTermEntity;
import cn.springmvc.service.ProjectTypeTermService; 
@Service("projectTypeTermServiceImpl")
public class ProjectTypeTermServiceImpl implements ProjectTypeTermService {
	@Resource(name="projectTypeTermDaoImpl")
	private ProjectTypeTermDao projectTypeTermDaoImpl;  
	@Resource(name="projectTypeTermListDaoImpl")
	private ProjectTypeTermListDao projectTypeTermListDaoImpl;  
  

	@Override
	public int updateProjectTypeTermByID(ProjectTypeTermEntity entity) {
		if(entity == null){
			return 0;
		} 
		int  result;
		//根据项目类型id，与借款类型（天、月、年）查询项目类型期限是否存在，已存在修改，不存在新增
		ProjectTypeTermEntity projectTypeTermEntity= projectTypeTermListDaoImpl.selectProjectTypeTermById(entity);
		if(projectTypeTermEntity != null){
			result=projectTypeTermDaoImpl.updateProjectTypeTermByID(entity);
		}else{
			result=projectTypeTermDaoImpl.insertProjectTypeTerm(entity);
		}  
		return result;
	}
  
	@Override
	public int insertProjectTypeTerm(ProjectTypeTermEntity entity) {
		if(entity == null){
			return 0;
		} 
		int  result;
		//根据项目类型id，与借款类型（天、月、年）查询项目类型期限是否存在，已存在修改，不存在新增
		ProjectTypeTermEntity projectTypeTermEntity= projectTypeTermListDaoImpl.selectProjectTypeTermById(entity);
		if(projectTypeTermEntity != null){
			result=projectTypeTermDaoImpl.updateProjectTypeTermByID(entity);
		}else{
			result=projectTypeTermDaoImpl.insertProjectTypeTerm(entity);
		}  
		return result;
	}
 
	@Override
	public ProjectTypeTermEntity selectProjectTypeTermById(
			ProjectTypeTermEntity entity) {
		ProjectTypeTermEntity projectTypeTermEntity=null;
		projectTypeTermEntity=projectTypeTermListDaoImpl.selectProjectTypeTermById(entity);
		return projectTypeTermEntity;
	}

}
