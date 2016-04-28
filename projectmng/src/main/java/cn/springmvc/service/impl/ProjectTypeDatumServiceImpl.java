package  cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
 
import cn.springmvc.dao.ProjectTypeDatumDao;
import cn.springmvc.dao.ProjectTypeDatumListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectTypeDatumEntity;
import cn.springmvc.service.ProjectTypeDatumService;
 
@Service("projectTypeDatumServiceImpl")
public class ProjectTypeDatumServiceImpl implements ProjectTypeDatumService {
	@Resource(name="projectTypeDatumDaoImpl")
	private ProjectTypeDatumDao projectTypeDatumDaoImpl;  
	@Resource(name="projectTypeDatumListDaoImpl")
	private ProjectTypeDatumListDao projectTypeDatumListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
  
	@Override
	public int insertProjectTypeDatum(List<ProjectTypeDatumEntity> list,int projectType,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		 
		projectTypeDatumDaoImpl.deleteProjectTypeDatumByID(projectType);
		int result=0;
		if(list.size() > 0) { 
			result=projectTypeDatumDaoImpl.insertProjectTypeDatum(list); 
		}
		if(result > 0) {
		    logentity.setsDetail("添加项目类型申请条件");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo); 
		}
		return result;
	}

	@Override
	public List<ProjectTypeDatumEntity> selectMemberAttestTypeList(
			ProjectTypeDatumEntity projectTypeDatumEntity) {
		
		return projectTypeDatumListDaoImpl.selectProjectTypeDatumAllpage(projectTypeDatumEntity); 
	}

	@Override
	public List<MemberAttestTypeEntity> selectMemberAttestByprojectType(
			long projectType) {
		
		return projectTypeDatumListDaoImpl.selectMemberAttestByprojectType(projectType);
		
	}
 
}
