package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.LawsRegulationsDao;
import cn.springmvc.dao.LawsRegulationsListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.LawsRegulationsEntity;
import cn.springmvc.service.LawsRegulationsService;
@Service("lawsRegulationsServiceImpl")
public class LawsRegulationsServiceImpl implements LawsRegulationsService {
	@Resource(name="lawsRegulationsDaoImpl")
	private LawsRegulationsDao lawsRegulationsDaoImpl;  
	@Resource(name="lawsRegulationsListDaoImpl")
	private LawsRegulationsListDao lawsRegulationsListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertLawsRegulations(LawsRegulationsEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = 0;
		if(entity == null) {
			return -1;
		} 
		// 查询法律法规是否存在，不存在就新增，存在则修改
		int count = lawsRegulationsListDaoImpl.selectLawsRegulationsIsExist();
		if(count == 0) {
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
			long id = generatorUtil.GetId();
			entity.setId((int)id);
			
			result = lawsRegulationsDaoImpl.insertLawsRegulations(entity); 
			
			if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
			}else{
				generatorUtil.SetIdUsed(id);
				logentity.setsDetail("添加法律法规");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			}
			
		}else{
			result = lawsRegulationsDaoImpl.updateLawsRegulationsByID(entity); 
			if(result ==1 ) {
				logentity.setsDetail("修改法律法规");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			}
		} 
		
		return result; 
	}

	@Override
	public int deleteLawsRegulations(int id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result=lawsRegulationsDaoImpl.deleteLawsRegulationsByID(id); 
		if(result ==1 ) {
			logentity.setsDetail("删除法律法规");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
 

	@Override
	public int updateLawsRegulationsStatuByID(LawsRegulationsEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = lawsRegulationsDaoImpl.updateLawsRegulationsStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用法律法规");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用法律法规");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public LawsRegulationsEntity selectLawsRegulationsList(int statu) {
		
		LawsRegulationsEntity lawsRegulationsEntity = lawsRegulationsListDaoImpl.selectLawsRegulations(statu);
		return lawsRegulationsEntity;
	}

}
