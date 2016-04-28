package  cn.springmvc.service.impl;
 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.ProjectTypeTermDao;
import cn.springmvc.dao.ProjectTypeTermListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.ProjectTypeTermEntity;
import cn.springmvc.service.ProjectTypeTermService; 
@Service("projectTypeTermServiceImpl")
public class ProjectTypeTermServiceImpl implements ProjectTypeTermService {
	@Resource(name="projectTypeTermDaoImpl")
	private ProjectTypeTermDao projectTypeTermDaoImpl;  
	@Resource(name="projectTypeTermListDaoImpl")
	private ProjectTypeTermListDao projectTypeTermListDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
  

	@Override
	public int updateProjectTypeTermByID(ProjectTypeTermEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		if(entity == null){
			return 0;
		} 
		int  result;
		//根据项目类型id，与借款类型（天、月、年）查询项目类型期限是否存在，已存在修改，不存在新增
		ProjectTypeTermEntity projectTypeTermEntity= projectTypeTermListDaoImpl.
				selectProjectTypeTermById(entity);
		
		if(projectTypeTermEntity != null){
			result=projectTypeTermDaoImpl.updateProjectTypeTermByID(entity);
		}else{
			result=projectTypeTermDaoImpl.insertProjectTypeTerm(entity);
		} 
		if(result == 1) {
			StringBuffer details = new StringBuffer("设置项目类型期限 ");
			if(entity.getUnit() == 0) {
				details.append("天标最小借款期限："+entity.getMinDaytime()+"最大借款期限"+entity.getMaxDaytime());
			}
			if(entity.getUnit() == 1) {
				details.append("月标最小借款期限："+entity.getMinDaytime()+"最大借款期限"+entity.getMaxDaytime());
			}
			if(entity.getUnit() == 2) {
				details.append("年标最小借款期限："+entity.getMinDaytime()+"最大借款期限"+entity.getMaxDaytime());
			}
		    logentity.setsDetail(details.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
  
	@Override
	public int insertProjectTypeTerm(ProjectTypeTermEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
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
		if(result == 1) {
			StringBuffer details = new StringBuffer("设置项目类型期限 ");
			if(entity.getUnit() == 0) {
				details.append("天标最小借款期限："+entity.getMinDaytime()+"最大借款期限"+entity.getMaxDaytime());
			}
			if(entity.getUnit() == 1) {
				details.append("月标最小借款期限："+entity.getMinDaytime()+"最大借款期限"+entity.getMaxDaytime());
			}
			if(entity.getUnit() == 2) {
				details.append("年标最小借款期限："+entity.getMinDaytime()+"最大借款期限"+entity.getMaxDaytime());
			}
		    logentity.setsDetail(details.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
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
