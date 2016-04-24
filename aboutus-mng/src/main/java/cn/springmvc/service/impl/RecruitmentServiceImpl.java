package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
 

import cn.springmvc.dao.RecruitmentDao;
import cn.springmvc.dao.RecruitmentListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.RecruitmentEntity;
import cn.springmvc.service.RecruitmentListService;
@Service("recruitmentServiceImpl")
public class RecruitmentServiceImpl implements RecruitmentListService {
	@Resource(name="recruitmentDaoImpl")
	private RecruitmentDao recruitmentDaoImpl; 
	@Resource(name="recruitmentListDaoImpl")
	private RecruitmentListDao recruitmentListDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertRecruitments(RecruitmentEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		//查询该职位是否存在 
		RecruitmentEntity recruitmentEntity = recruitmentListDaoImpl.
				selectRecruitmentIsExistByNAme(entity);
		
		if(recruitmentEntity != null) {
			return -1;
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		int result =  recruitmentDaoImpl.insertRecruitment(entity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加招贤纳士:"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
	}

	@Override
	public int deleteRecruitments(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		RecruitmentEntity recruitmentEntity = recruitmentListDaoImpl.selectRecruitmentByID(id);
		int result = recruitmentDaoImpl.deleteRecruitmentByID(id);
		if(result == 1) {
			logentity.setsDetail("删除招贤纳士:"+recruitmentEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateRecruitments(RecruitmentEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		//查询该职位是否存在 
		RecruitmentEntity recruitmentEntity = recruitmentListDaoImpl.
				selectRecruitmentIsExistByNAme(entity);
		
		if(recruitmentEntity != null) {
			return -1;
		}
		int result = recruitmentDaoImpl.updateRecruitmentByID(entity);
		if(result == 1) {
			logentity.setsDetail("修改招贤纳士:"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateRecruitmentStatuByID(RecruitmentEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		RecruitmentEntity recruitmentEntity = recruitmentListDaoImpl.
				selectRecruitmentByID(entity.getId());
		
		int result = recruitmentDaoImpl.updateRecruitmentStatuByID(entity);
		
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用招贤纳士  :"+recruitmentEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用招贤纳士  :"+recruitmentEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<RecruitmentEntity> selectRecruitmentsList(PageEntity pageEntity) {
		List<RecruitmentEntity> recruitmentList = null;    
		recruitmentList = recruitmentListDaoImpl.selectRecruitmentList(pageEntity);    
		return recruitmentList; 
	}
 
	@Override
	public RecruitmentEntity selectRecruitmentByID(long id) {
		
		RecruitmentEntity recruitmentEntity = recruitmentListDaoImpl.selectRecruitmentByID(id);
		return recruitmentEntity;
		
	}

}
