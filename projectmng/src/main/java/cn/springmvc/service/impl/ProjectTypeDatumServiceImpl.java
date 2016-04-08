package  cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.ProjectTypeDatumDao;
import cn.springmvc.dao.ProjectTypeDatumListDao; 
import cn.springmvc.model.ProjectTypeDatumEntity;
import cn.springmvc.service.ProjectTypeDatumService;
 
@Service("projectTypeDatumServiceImpl")
public class ProjectTypeDatumServiceImpl implements ProjectTypeDatumService {
	@Resource(name="projectTypeDatumDaoImpl")
	private ProjectTypeDatumDao projectTypeDatumDaoImpl;  
	@Resource(name="projectTypeDatumListDaoImpl")
	private ProjectTypeDatumListDao projectTypeDatumListDaoImpl;  
  
	@Override
	public int insertProjectTypeDatum(List<ProjectTypeDatumEntity> list,int projectType) {
		 
		projectTypeDatumDaoImpl.deleteProjectTypeDatumByID(projectType);
		int result=0;
		if(list.size() > 0) { 
			result=projectTypeDatumDaoImpl.insertProjectTypeDatum(list); 
		}
		 
		return result;
	}

	@Override
	public List<ProjectTypeDatumEntity> selectMemberAttestTypeList(
			ProjectTypeDatumEntity projectTypeDatumEntity) {
		List<ProjectTypeDatumEntity> projectTypeDatumList=null;
		projectTypeDatumList=projectTypeDatumListDaoImpl.selectProjectTypeDatumAllpage(projectTypeDatumEntity);
		return projectTypeDatumList;
	}
 
}
