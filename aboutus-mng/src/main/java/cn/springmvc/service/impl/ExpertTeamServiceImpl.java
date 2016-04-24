package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.ExpertTeamDao;
import cn.springmvc.dao.ExpertTeamListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.ExpertTeamEntity;  
import cn.springmvc.service.ExpertTeamService;
/**
 * 
* @author 刘利 
* @Description: 实现专家顾问的增删改查功能
* @since 
* @date 2016-3-19 下午7:32:30
 */
@Service
public class ExpertTeamServiceImpl implements ExpertTeamService {
	@Resource(name="expertTeamDaoImpl")
	private ExpertTeamDao expertTeamDaoImpl;  
	@Resource(name="expertTeamListDaoImpl")
	private ExpertTeamListDao expertTeamListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertExpertTeam(ExpertTeamEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的专家顾问是否存在,如果已存在则不插入  
		ExpertTeamEntity expertTeamEntity= expertTeamListDaoImpl.selectExpertTeamIsExistByNAme(entity);
		if(expertTeamEntity != null){
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		entity.setId(id);
		
        int result = expertTeamDaoImpl.insertExpertTeam(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加专家顾问 :"+entity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
	} 
	@Override
	public int deleteExpertTeamByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		ExpertTeamEntity expertTeamEntity= expertTeamListDaoImpl.selectExpertTeamByID(id);
		int result = expertTeamDaoImpl.deleteExpertTeamByID(id); 
		if(result == 1) {
			logentity.setsDetail("删除专家顾问 :"+expertTeamEntity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateExpertTeamByID(ExpertTeamEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的专家顾问是否存在,如果已存在则修改
		ExpertTeamEntity expertTeamEntity = expertTeamListDaoImpl.selectExpertTeamIsExistByNAme(entity);
		if(expertTeamEntity != null){
			return -1;
		} 
		int result = expertTeamDaoImpl.updateExpertTeamByID(entity);
		if(result == 1) {
			logentity.setsDetail("修改专家顾问 :"+entity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateExpertTeamStatuByID(ExpertTeamEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		ExpertTeamEntity expertTeamEntity= expertTeamListDaoImpl.selectExpertTeamByID(entity.getId());
		int result = expertTeamDaoImpl.updateExpertTeamStatuByID(entity);
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用专家顾问 :"+expertTeamEntity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用专家顾问 :"+expertTeamEntity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<ExpertTeamEntity> selectExpertTeamListpage(PageEntity pageEntity) {
		
		List<ExpertTeamEntity> expertTeamList = null;    
	 	expertTeamList = expertTeamListDaoImpl.selectExpertTeamAllpage(pageEntity);  
		return expertTeamList; 
	}
	 
	@Override
	public ExpertTeamEntity selectExpertTeamByID(long id) {
		
		ExpertTeamEntity expertTeamEntity= expertTeamListDaoImpl.selectExpertTeamByID(id);
		return expertTeamEntity;
		
	}
	@Override
	public List<ExpertTeamEntity> selectExpertTeamfront() {
		
		return expertTeamListDaoImpl.selectExpertTeamfront();
		
	}

}
