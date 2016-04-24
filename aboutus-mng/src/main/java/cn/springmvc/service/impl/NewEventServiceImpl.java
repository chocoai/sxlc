package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
 
 
import cn.springmvc.dao.NewEventDao;
import cn.springmvc.dao.NewEventListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.NewEventEntity; 
import cn.springmvc.service.NewEventService;
@Service("newEventServiceImpl")
public class NewEventServiceImpl implements NewEventService {
	@Resource(name="newEventDaoImpl")
	private NewEventDao newEventDaoImpl;  
	@Resource(name="newEventListDaoImpl")
	private NewEventListDao newEventListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertNewEvent(NewEventEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的最新动态是否存在,如果已存在则不插入  
		NewEventEntity mngTeamEntity = newEventListDaoImpl.selectNewEventIsExistByNAme(entity);
		if(mngTeamEntity != null) {
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = newEventDaoImpl.insertNewEvent(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加最新动态 :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;  
	}

	@Override
	public int deleteNewEventByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		NewEventEntity mngTeamEntity = newEventListDaoImpl.selectNewEventByID(id);
		int result = newEventDaoImpl.deleteNewEventByID(id); 
		if(result == 1) {
		    logentity.setsDetail("删除最新动态 :"+mngTeamEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateNewEventByID(NewEventEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的最新动态是否存在,如果已存在则不插入  
		NewEventEntity mngTeamEntity = newEventListDaoImpl.selectNewEventIsExistByNAme(entity);
		if(mngTeamEntity != null) {
			return -1;
		} 
		int result = newEventDaoImpl.updateNewEventByID(entity);
		
		if(result == 1) {
			
		    logentity.setsDetail("修改最新动态 :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateNewEventStatuByID(NewEventEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		if(entity.getStatu() == 1) {
			
			entity.setStatu(0);
		}else {
			entity.setStatu(1);
		}
		int result = newEventDaoImpl.updateNewEventStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) { 
				
			logentity.setsDetail("启用最新动态 :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
				
		}else if(result == 1 && entity.getStatu() == 0){
				
			logentity.setsDetail("停用最新动态 :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<NewEventEntity> selectNewEventListpage(
			PageEntity pageEntity) {
		
		List<NewEventEntity> newEventList = null;   
	 	newEventList = newEventListDaoImpl.selectNewEventList(pageEntity);  
		return newEventList; 
	}

 
	@Override
	public NewEventEntity selectNewEventByID(long id) {
		
		NewEventEntity mngTeamEntity = newEventListDaoImpl.selectNewEventByID(id);
		return mngTeamEntity;
	}

}
