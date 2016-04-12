package  cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
  
import cn.springmvc.dao.ProjectBaseInfoDao;
import cn.springmvc.dao.ProjectBaseInfoListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.ProjectBaseInfoDaoImpl;
import cn.springmvc.dao.impl.ProjectBaseInfoListDaoImpl;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.service.ProjectBaseInfoService;
 
import product_p2p.kit.pageselect.PageEntity; 
@Service("projectBaseInfoServiceImpl")
public class ProjectBaseInfoServiceImpl implements ProjectBaseInfoService {
	@Resource(name="projectBaseInfoDaoImpl")
	private ProjectBaseInfoDao projectBaseInfoDaoImpl;  
	@Resource(name="projectBaseInfoListDaoImpl") 
	private ProjectBaseInfoListDao projectBaseInfoListDaoImpl;  
 
	@Override
	public int deleteProjectBaseInfoByID(int id) {
		
		int result=projectBaseInfoDaoImpl.deleteProjectBaseInfoByID(id); 
		return result;
	}

	@Override
	public int updateProjectBaseInfoByID(ProjectBaseInfoEntity entity) {
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的项目类型是否存在,如果已存在则不修改  
		ProjectBaseInfoEntity projectBaseInfoEntity= projectBaseInfoListDaoImpl.selectProjectBaseInfoIsExistByNAme(entity);
		if(projectBaseInfoEntity != null){
			return -1;
		} 
		int result=projectBaseInfoDaoImpl.updateProjectBaseInfoByID(entity); 
		return result;
	}

	@Override
	public int updateProjectBaseInfoStatuByID(ProjectBaseInfoEntity entity) {
		if(entity == null) {
			return 0;
		}
		int result=projectBaseInfoDaoImpl.updateProjectBaseInfoStatuByID(entity); 
		return result;
	}

	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoListpage(
			PageEntity pageEntity) {
		List<ProjectBaseInfoEntity> projectBaseInfoList=null;    
	 	projectBaseInfoList = projectBaseInfoListDaoImpl.selectProjectBaseInfoAllpage(pageEntity);  
		return projectBaseInfoList; 
	}

	@Override
	public int insertProjectBaseInfo(ProjectBaseInfoEntity entity,ProjectBaseInfoEntity adminlogentity,String[] sIpInfo) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目类型是否存在,如果已存在则不插入  
		ProjectBaseInfoEntity projectBaseInfoEntity= projectBaseInfoListDaoImpl.selectProjectBaseInfoIsExistByNAme(entity);
		if(projectBaseInfoEntity != null){
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		int result= projectBaseInfoDaoImpl.insertProjectBaseInfo(entity);
		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
		}else{
			generatorUtil.SetIdUsedFail(id);
		}  
		return result;
	}

	@Override
	public ProjectBaseInfoEntity selectProjectBaseInfoById(int id) {
		 if(id == 0){
			return null;
		 } 
		 ProjectBaseInfoEntity projectBaseInfoEntity= projectBaseInfoListDaoImpl.selectProjectBaseInfoIsExistById(id);
		 return projectBaseInfoEntity;
	}

 	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoList() {
		
		return projectBaseInfoListDaoImpl.selectProjectBaseInfoList();
		
	}

}
