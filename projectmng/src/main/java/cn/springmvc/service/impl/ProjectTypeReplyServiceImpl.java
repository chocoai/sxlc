package  cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.ProjectTypeReplyDao;
import cn.springmvc.dao.ProjectTypeReplyListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.ProjectTypeReplyEntity;
import cn.springmvc.service.ProjectTypeReplyService;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
@Service("projectTypeReplyServiceImpl")
public class ProjectTypeReplyServiceImpl implements ProjectTypeReplyService {
	@Resource(name="projectTypeReplyDaoImpl")
	private ProjectTypeReplyDao projectTypeReplyDaoImpl;  
	@Resource(name="projectTypeReplyListDaoImpl")
	private ProjectTypeReplyListDao projectTypeReplyListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
 
	@Override
	public int deleteProjectTypeReplyByIndex(int index,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		ProjectTypeReplyEntity projectTypeReplyEntity= projectTypeReplyListDaoImpl.
				 selectProjectTypeReplyByindex(index);
		int result=projectTypeReplyDaoImpl.deleteProjectTypeReplyByIndex(index); 
		if(result == 1) {
		    logentity.setsDetail("删除项目类型还款指南:"+projectTypeReplyEntity.getContent());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateProjectTypeReplyByIndex(ProjectTypeReplyEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目类型还款指南是否存在,如果已存在则不修改  
		ProjectTypeReplyEntity projectTypeGuideEntity= projectTypeReplyListDaoImpl.
				selectProjectTypeReplyIsExistByNAme(entity);
		
		if(projectTypeGuideEntity != null){
			return -1;
		} 
		int result=projectTypeReplyDaoImpl.updateProjectTypeReplyByIndex(entity); 
		if(result == 1) {
		    logentity.setsDetail("修改项目类型还款指南:"+entity.getContent());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
 
	@Override
	public List<ProjectTypeReplyEntity> selectProjectTypeReplyListpage(
			PageEntity pageEntity) {
		
		return projectTypeReplyListDaoImpl.selectProjectTypeReplyList(pageEntity);   
	}

	@Override
	public int insertProjectTypeReply(ProjectTypeReplyEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的项目类型还款指南是否存在,如果已存在则不插入  
		ProjectTypeReplyEntity projectTypeGuideEntity= projectTypeReplyListDaoImpl.
				selectProjectTypeReplyIsExistByNAme(entity);
		if(projectTypeGuideEntity != null){
			return -1;
		}  
		int index =projectTypeReplyListDaoImpl.selectProjectTypeReplyEntityindex(); 
	    entity.setPtIndex(index+1); 
	    int result = projectTypeReplyDaoImpl.insertProjectTypeReply(entity);
		if(result == 1) {
		    logentity.setsDetail("添加项目类型还款指南:"+entity.getContent());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public ProjectTypeReplyEntity selectProjectTypeReplyByindex(int index) { 
		
		return projectTypeReplyListDaoImpl.selectProjectTypeReplyByindex(index); 
	}

	@Override
	public  ProjectTypeReplyEntity  selectProjectTypeReplyListfront(
			long projectType) {
		
		return projectTypeReplyListDaoImpl.selectProjectTypeReplyListfront(projectType);
		
	} 
}
