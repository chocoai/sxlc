

/** 
* @Title: ProjectAuditServiceImpl.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-23 下午1:02:03 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;  
import cn.springmvc.dao.ProjectAuitDao;
import cn.springmvc.dao.ProjectAuitListDao;
import cn.springmvc.dao.ProjectDetailListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.ProjectAuditDaoImpl;
import cn.springmvc.dao.impl.ProjectAuditListDaoImpl;
import cn.springmvc.dao.impl.ProjectDetailListDaoImpl;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectAppProcessEntity; 
import cn.springmvc.model.ProjectCheckAttachDealEntity;
import cn.springmvc.model.ProjectCheckAttachEntity;
import cn.springmvc.model.ProjectCheckRecordEntity;
import cn.springmvc.service.ProjectAuitService;

/** 
 * @author 刘利 
 * @Description: 项目审核模块
 * @since 
 * @date 2016-3-23 下午1:02:03  */
@Service("projectAuditServiceImpl")
public class ProjectAuditServiceImpl implements ProjectAuitService {

	@Resource(name="projectAuditDaoImpl")
	private ProjectAuitDao projectAuditDaoImpl;
	@Resource(name="projectAuditListDaoImpl")
	private ProjectAuitListDao projectAuditListDaoImpl;
	@Resource(name="projectDetailListDaoImpl")
	private ProjectDetailListDao projectDetailListDaoImpl;  
	
	@Override
	public List<ProjectAppProcessEntity> selectProjectAuitList(
			PageEntity pageEntity) { 
		
		List<ProjectAppProcessEntity>  ProjectAppProcesslist = null ;
		ProjectAppProcesslist = projectAuditListDaoImpl.selectProjectAuitList(pageEntity); 
        return ProjectAppProcesslist;
	}
	@Override
	public ProjectAppProcessEntity selectProjectDetailByID(int id) {
		
		ProjectAppProcessEntity projectAppProcessEntity = null;
		projectAppProcessEntity = projectAuditListDaoImpl.selectProjectDetailByID(id);  
		return projectAppProcessEntity;
		
	}
	 
	@Override
	public int projectAudit(Map<String, Object> map) {
		
		return projectAuditDaoImpl.projectAudit(map);
		
	}
	
	@Override
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachment(
			int projectID) {
		
	 	return projectAuditListDaoImpl.selectProjectAppAttachment(projectID);
		
	}
		
	 
	@Override
	public List<ProjectCheckRecordEntity> selectProjectCheckRecord(
			PageEntity pageEntity) {
		
		return projectAuditListDaoImpl.selectProjectCheckRecord(pageEntity);
		
	}
	
	 	
	@Override
	public List<ProjectCheckAttachEntity> selectCheckAttachDeal(
			PageEntity pageEntity) {
		
		return projectAuditListDaoImpl.selectCheckAttachDeal(pageEntity);
		
	}
	
	 
	@Override
	public List<ProjectCheckAttachEntity> selectCheckAttachDealDelete(
			PageEntity pageEntity) {
		
		return projectAuditListDaoImpl.selectCheckAttachDealDelete(pageEntity);
		
	}
	
	 	
	@Override
	public int projectAudit(Map<String, Object> map,
			List<ProjectCheckAttachEntity> projectCheckAttachList) {
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		map.put("checkid", id);
		int result=projectAuditDaoImpl.projectAudit(map);
		
		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
		}else{
			generatorUtil.SetIdUsedFail(id);
		} 
		if(result == 1) { 
			
		 projectAuditDaoImpl.insertProjectCheckAttach(projectCheckAttachList); 
			 
		}
		return result;
	}
	
	 	
	@Override
	public List<ProjectCheckAttachEntity> selectProjectCheckAttachTotal(
			int projectID) {
		
		return projectAuditListDaoImpl.selectProjectCheckAttachTotal(projectID);
		
	}
	@Override
	public int insertProjectCheckAttach(List<ProjectCheckAttachEntity> projectCheckAttachList) {
		  
		return	projectAuditDaoImpl.insertProjectCheckAttach(projectCheckAttachList);  
	}
 
	@Override
	public int deleteProjectCheckAttachone(Map<String,Object> map) {
		
		return  projectAuditDaoImpl.deleteProjectCheckAttachone(map);
		
	}
 	
	@Override
	public int insertCheckAttachone(
			ProjectCheckAttachDealEntity projectCheckAttachDealEntity) {
		
		return projectAuditDaoImpl.insertCheckAttachone(projectCheckAttachDealEntity);
		
	}
}

