package  cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.ActivitiesProjectDao;
import cn.springmvc.dao.ActivitiesProjectListDao;
import cn.springmvc.dao.impl.ActivitiesProjectDaoImpl;
import cn.springmvc.dao.impl.ActivitiesProjectListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.ActivitiesProjectEntity;
import cn.springmvc.service.ActivitiesProjectService;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
@Service("activitiesProjectServiceImpl")
public class ActivitiesProjectServiceImpl implements ActivitiesProjectService {
	@Resource(name="activitiesProjectDaoImpl")
	private ActivitiesProjectDao activitiesProjectDaoImpl;  
	@Resource(name="activitiesProjectListDaoImpl")
	private ActivitiesProjectListDao activitiesProjectListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
 
	@Override
	public int deleteActivitiesProjectByID(int id,String apname,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		
		int result=activitiesProjectDaoImpl.deleteActivitiesProjectByID(id);
		if(result == 1) {
			entityLog.setsDetail("删除审批活动点"+apname);
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateActivitiesProjectByID(ActivitiesProjectEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目审批活动点是否存在,如果已存在则不插入  
		ActivitiesProjectEntity activitiesProjectEntity= activitiesProjectListDaoImpl.selectActivitiesProjectIsExistByNAme(entity);
		if(activitiesProjectEntity != null) {
			return -1;
		} 
		//查询该权限是否被其他的项目审批点绑定
		int result = activitiesProjectListDaoImpl.selectActivitiesProjectRoleIsExist(entity);
		if(result > 0) {
			return -2;
		} 
		result = activitiesProjectDaoImpl.updateActivitiesProjectByID(entity); 
		if(result == 1) {
			entityLog.setsDetail("修改审批活动点"+entity.getApName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;  
	}

	@Override
	public int updateActivitiesProjectStatuByID(ActivitiesProjectEntity entity) {
		
		int result=activitiesProjectDaoImpl.updateActivitiesProjectStatuByID(entity); 
		return result;
	}

	@Override
	public List<ActivitiesProjectEntity> selectActivitiesProjectListpage(
			PageEntity pageEntity) {
		List<ActivitiesProjectEntity> activitiesProjectList=null;    
	 	activitiesProjectList = activitiesProjectListDaoImpl.selectActivitiesProjectAllpage(pageEntity);  
		return activitiesProjectList; 
	}

	@Override
	public int insertActivitiesProject(ActivitiesProjectEntity entity,InsertAdminLogEntity 
			entityLog, String[] sIpInfo) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目审批活动点是否存在,如果已存在则不插入  
		ActivitiesProjectEntity activitiesProjectEntity= activitiesProjectListDaoImpl.
				selectActivitiesProjectIsExistByNAme(entity);
		if(activitiesProjectEntity != null) {
			return -1;
		} 
		int result=activitiesProjectListDaoImpl.selectActivitiesProjectRoleIsExist(entity);
		if(result > 0) {
			return -2;
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId((int)id);
		result = activitiesProjectDaoImpl.insertActivitiesProject(entity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		} 
		if(result == 1) {
			entityLog.setsDetail("添加审批活动点"+entity.getApName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public ActivitiesProjectEntity selectActivitiesProjectByID(int id) {
		 ActivitiesProjectEntity  activitiesProjectentity=null;    
		 activitiesProjectentity = activitiesProjectListDaoImpl.selectActivitiesProjectByID(id);  
		return activitiesProjectentity; 
	}

}
