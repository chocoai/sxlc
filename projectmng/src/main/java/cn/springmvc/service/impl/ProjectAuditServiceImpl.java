

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
	public ProjectAppRecordEntity selectProjectDetailByID(int id) {
		
		ProjectAppRecordEntity projectAppRecordEntity = null;
		projectAppRecordEntity = projectAuditListDaoImpl.selectProjectDetailByID(id);  
		return projectAppRecordEntity;
		
	}
	 
	@Override
	public int projectAudit(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		return projectAuditDaoImpl.projectAudit(map);
		
	}
	
	@Override
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachment(
			long projectID) {
		
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
	public int projectAudit(Map<String, Object> map,String affix,long adminID,InsertAdminLogEntity 
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
		//审核通过插入附件
		if(result == 1) { 
			List<ProjectCheckAttachEntity> projectCheckAttachList = new ArrayList<ProjectCheckAttachEntity>();
		 	if(affix != null && affix != ""){
				String[] num = affix.split(";");
				for(int i = 0;i< num.length;i++) {//循环截取字符串
					String[] num1 = num[i].split(",");
					String attachName= num1[0];//附件名称
					String attachUrl=num1[1];//附件路径
				 	ProjectCheckAttachEntity ProjectCheckAttachEntity = new ProjectCheckAttachEntity();  
					ProjectCheckAttachEntity.setAdminID(adminID);
					ProjectCheckAttachEntity.setAppCheckId(id);
					ProjectCheckAttachEntity.setAttachIndex(i);
					ProjectCheckAttachEntity.setAttachUrl(attachUrl); 
					ProjectCheckAttachEntity.setDealType(0); 
					ProjectCheckAttachEntity.setAttachTitle(attachName); 
					projectCheckAttachList.add(ProjectCheckAttachEntity); 
				}
			}
		    projectAuditDaoImpl.insertProjectCheckAttach(projectCheckAttachList); 
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
}

