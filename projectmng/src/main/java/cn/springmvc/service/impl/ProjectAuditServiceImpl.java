

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
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;  
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.ProjectAuitDao;
import cn.springmvc.dao.ProjectAuitListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.ProjectAppAttachmentEntity; 
import cn.springmvc.model.ProjectAppRecordEntity;
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
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public List<ProjectAppRecordEntity> selectProjectAuitList(
			PageEntity pageEntity) { 
		
		List<ProjectAppRecordEntity>  projectAppRecordList = null ;
		projectAppRecordList = projectAuditListDaoImpl.selectProjectAuitList(pageEntity); 
        return projectAppRecordList;
	}
	@Override
	public ProjectAppRecordEntity selectProjectDetailByID(long id) {
		
		ProjectAppRecordEntity projectAppRecordEntity = null;
		projectAppRecordEntity = projectAuditListDaoImpl.selectProjectDetailByID(id);  
		return projectAppRecordEntity;
		
	}
  
	@Override
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachment(
			long projectID) {
		
	 	return projectAuditListDaoImpl.selectProjectAppAttachment(projectID);
		
	}
		
	 
	@Override
	public List<ProjectCheckRecordEntity> selectProjectCheckRecord(
			PageEntity pageEntity) {
		List<ProjectCheckRecordEntity> list =  projectAuditListDaoImpl.selectProjectCheckRecord(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list); 
		return list;
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
	public int projectAudit(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) { 
		
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
		    StringBuffer detail =new StringBuffer("审核项目:"+map.get("projectTitle"));
		    if(map.get("checkStatu").toString().equals("1")) {
		    	detail.append("通过");
		    }else if(map.get("checkStatu").toString().equals("-1")){
		    	detail.append("打回");
		    }else if(map.get("checkStatu").toString().equals("2")){
		    	detail.append("通过需补齐资料");
		    }
		    logentity.setsDetail(detail.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
	
	 	
	@Override
	public List<ProjectCheckAttachEntity> selectProjectCheckAttachTotal(
			long projectID) {
		
		return projectAuditListDaoImpl.selectProjectCheckAttachTotal(projectID);
		
	}
	@Override
	public int insertProjectCheckAttach(List<ProjectCheckAttachEntity> projectCheckAttachList) {
		  
		return	projectAuditDaoImpl.insertProjectCheckAttach(projectCheckAttachList);  
	}
 
	@Override
	public int deleteProjectCheckAttachone(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result =  projectAuditDaoImpl.deleteProjectCheckAttachone(map);
		if(result == 1) {
		    logentity.setsDetail("删除审核附件");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
 	
	@Override
	public int insertCheckAttachone(
			ProjectCheckAttachDealEntity projectCheckAttachDealEntity) {
		
		return projectAuditDaoImpl.insertCheckAttachone(projectCheckAttachDealEntity);
		
	}
	@Override
	public int updateProjectDetail(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = projectAuditDaoImpl.updateProjectDetail(map);
		if(result == 1) {
		    logentity.setsDetail("修改项目基本信息：项目标题"+map.get("projectTitle"));
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
		
	}
	@Override
	public int updateaffix(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) { 
		int result = projectAuditDaoImpl.updateaffix(map);
		if(result == 1) {
		    logentity.setsDetail("修改项目附件");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
	}
	@Override
	public List<ProjectCheckAttachEntity> selectProjectAttachTotal(
			long projectID) {
		
		return projectAuditListDaoImpl.selectProjectAttachTotal(projectID);
		
	}
}

