package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
 
import cn.springmvc.dao.ProjectPurposeSetDao;
import cn.springmvc.dao.ProjectPurposeSetListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.ProjectPurposeSetEntity;
import cn.springmvc.service.ProjectPurposeSetService;
@Service("projectPurposeSetServiceImpl")
public class ProjectPurposeSetServiceImpl implements ProjectPurposeSetService {
	@Resource(name="projectPurposeSetListDaoImpl")
	private ProjectPurposeSetListDao projectPurposeSetListDaoImpl;  
	@Resource(name="projectPurposeSetDaoimpl")
	private ProjectPurposeSetDao projectPurposeSetDaoimpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertProjectPurposeSet(List<ProjectPurposeSetEntity> entity,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		if(entity == null){
			return 0;
		}   
		int result =0;
		for (ProjectPurposeSetEntity en : entity) {
			 result =  projectPurposeSetDaoimpl.insertProjectPurposeSet(en);
		}
		if(result == 1) {
			entityLog.setsDetail("添加借款意向配置");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public int deleteProjectPurposeSetByType() {
		int result=projectPurposeSetDaoimpl.deleteProjectPurposeSetBytype(); 
		return result;
	}

	@Override
	public int updateProjectPurposeSetByType(List<Integer> list,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		
		projectPurposeSetDaoimpl.updateProjectPurposeSetStatu();
		int result=projectPurposeSetDaoimpl.updateProjectPurposeSetStatuCheck(list);
		if(result > 1) {
			entityLog.setsDetail("配置借款意向");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public List<ProjectPurposeSetEntity> selectProjectPurposeSetListpage() {
		List<ProjectPurposeSetEntity> projectPurposeSetList=null;    
		projectPurposeSetList = projectPurposeSetListDaoImpl.selectProjectPurposeSetAllpage();   
		return projectPurposeSetList; 
	}

	@Override
	public List<ProjectPurposeSetEntity> selectProjectPurposeSetValid() {
		
		return projectPurposeSetListDaoImpl.selectProjectPurposeSetValid();
		
	} 
}
