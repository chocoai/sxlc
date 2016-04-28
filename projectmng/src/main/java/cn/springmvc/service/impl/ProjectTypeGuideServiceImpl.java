package  cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.ProjectTypeGuideDao;
import cn.springmvc.dao.ProjectTypeGuideListDao;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.ProjectTypeGuideEntity;
import cn.springmvc.service.ProjectTypeGuideService;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
@Service("projectTypeGuideServiceImpl")
public class ProjectTypeGuideServiceImpl implements ProjectTypeGuideService {
	@Resource(name="projectTypeGuideDaoImpl")
	private ProjectTypeGuideDao projectTypeGuideDaoImpl;  
	@Resource(name="projectTypeGuideListDaoImpl")
	private ProjectTypeGuideListDao projectTypeGuideListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
 
	@Override
	public int deleteProjectTypeGuideByIndex(int index,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		ProjectTypeGuideEntity projectTypeGuideEntity= projectTypeGuideListDaoImpl.
				selectProjectTypeGuideByindex(index);
		int result=projectTypeGuideDaoImpl.deleteProjectTypeGuideByIndex(index); 
		if(result == 1) {
		    logentity.setsDetail("删除项目类型申请指南:"+projectTypeGuideEntity.getContent());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateProjectTypeGuideByIndex(ProjectTypeGuideEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目类型申请指南是否存在,如果已存在则不修改  
		ProjectTypeGuideEntity projectTypeGuideEntity= projectTypeGuideListDaoImpl.selectProjectTypeGuideIsExistByNAme(entity);
		if(projectTypeGuideEntity != null){
			return -1;
		} 
		int result=projectTypeGuideDaoImpl.updateProjectTypeGuideByIndex(entity);
		
		if(result == 1) {
		    logentity.setsDetail("修改项目类型申请指南:"+entity.getContent());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
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
	public int insertProjectTypeGuide(ProjectTypeGuideEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
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
		int result = projectTypeGuideDaoImpl.insertProjectTypeGuide(entity);
		if(result == 1) {
		    logentity.setsDetail("添加项目类型申请指南:"+entity.getContent());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public ProjectTypeGuideEntity selectProjectTypeGuideByindex(int index) {
		 
		 return  projectTypeGuideListDaoImpl.selectProjectTypeGuideByindex(index); 
	}

	@Override
	public  ProjectTypeGuideEntity  selectProjectTypeGuideListfront(
			long projectType) {
		
		return projectTypeGuideListDaoImpl.selectProjectTypeGuideListfront(projectType);
		
	} 
}
