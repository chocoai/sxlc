package  cn.springmvc.service.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
  
import cn.springmvc.dao.ProjectBaseInfoDao;
import cn.springmvc.dao.ProjectBaseInfoListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectTypeDatumEntity;
import cn.springmvc.model.ProjectTypeTermEntity;
import cn.springmvc.service.ProjectBaseInfoService;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import product_p2p.kit.pageselect.PageUtil;
@Service("projectBaseInfoServiceImpl")
public class ProjectBaseInfoServiceImpl implements ProjectBaseInfoService {
	@Resource(name="projectBaseInfoDaoImpl")
	private ProjectBaseInfoDao projectBaseInfoDaoImpl;  
	@Resource(name="projectBaseInfoListDaoImpl") 
	private ProjectBaseInfoListDao projectBaseInfoListDaoImpl;  
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
 
	@Override
	public int deleteProjectBaseInfoByID(long id,InsertAdminLogEntity 
			adminlogentity, String[] sIpInfo) {
		
		ProjectBaseInfoEntity projectBaseInfoEntity = projectBaseInfoListDaoImpl.
				selectProjectBaseInfoentitybyID(id);
		int result=projectBaseInfoDaoImpl.deleteProjectBaseInfoByID(id); 
		if(result == 1) {
			adminlogentity.setsDetail("删除项目类型  :"+projectBaseInfoEntity.getProjectName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(adminlogentity, sIpInfo);
		}
		return result;
	}
 

	@Override
	public int updateProjectBaseInfoStatuByID(ProjectBaseInfoEntity entity,InsertAdminLogEntity 
			adminlogentity, String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		int result=projectBaseInfoDaoImpl.updateProjectBaseInfoStatuByID(entity); 
		
		ProjectBaseInfoEntity projectBaseInfoEntity= projectBaseInfoListDaoImpl.
				selectProjectBaseInfoentitybyID(entity.getId());
		if(result == 1 && entity.getStatu() == 1) {
			adminlogentity.setsDetail("启用项目类型  :"+projectBaseInfoEntity.getProjectName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(adminlogentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			adminlogentity.setsDetail("停用项目类型  :"+projectBaseInfoEntity.getProjectName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(adminlogentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoListpage(
			PageEntity pageEntity) {
		List<ProjectBaseInfoEntity> list = projectBaseInfoListDaoImpl.selectProjectBaseInfoAllpage(pageEntity);
	 	PageUtil.ObjectToPage(pageEntity, list); 
		return list; 
	}
 

	@Override
	public ProjectBaseInfoEntity selectProjectBaseInfoById(long id) { 
		
		 ProjectBaseInfoEntity projectBaseInfoEntity= projectBaseInfoListDaoImpl.
				 selectProjectBaseInfoentitybyID(id);
		 return projectBaseInfoEntity;
	}

 	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoList() {
		
		return projectBaseInfoListDaoImpl.selectProjectBaseInfoList();
		
	}

	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoCombox() {
		
		return projectBaseInfoListDaoImpl.selectProjectBaseInfoCombox();
		
	}

	@Override
	public int addProjectBaseType(Map<String, Object> map,
			InsertAdminLogEntity adminlogentity, String[] sIpInfo) {
		
		if(map == null){
			return 0;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		map.put("lId", id);
		int result= projectBaseInfoDaoImpl.addProjectBaseType(map);
		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
			adminlogentity.setsDetail("添加项目类型  :"+map.get("projectName"));
			optRecordWriteDaoImpl.InsertAdminOptRecord(adminlogentity, sIpInfo);
		}else{
			generatorUtil.SetIdUsedFail(id);
		}  
		return result;
	}

	@Override
	public int updateProjectBaseType(Map<String, Object> map,
			InsertAdminLogEntity adminlogentity, String[] sIpInfo) {
		
		if(map == null) {
			return 0;
		}  
		int result=projectBaseInfoDaoImpl.updateProjectBaseType(map); 
		if(result == 1) {
			adminlogentity.setsDetail("修改项目类型  :"+map.get("projectName"));
			optRecordWriteDaoImpl.InsertAdminOptRecord(adminlogentity, sIpInfo);
		}
		return result;
		
	}
	
	@Override
	public List<MemberAttestTypeEntity> selectMemberAttestByprojectType(
			long projectType) {
		
		return projectBaseInfoListDaoImpl.selectMemberAttestByprojectType(projectType);
		
	}
	@Override
	public List<ProjectTypeDatumEntity> selectMemberAttestTypeList(
			ProjectTypeDatumEntity projectTypeDatumEntity) {
		
		return projectBaseInfoListDaoImpl.selectProjectTypeDatumAllpage(projectTypeDatumEntity); 
	}
	@Override
	public ProjectTypeTermEntity selectProjectTypeTermById(
			ProjectTypeTermEntity entity) {
		
		return projectBaseInfoListDaoImpl.selectProjectTypeTermById(entity); 
	}


	@Override
	public List<ProjectTypeTermEntity> selectProjectTypeTermByID(long projectID) {
		
		return projectBaseInfoListDaoImpl.selectProjectTypeTermByID(projectID); 
		
	}

}
