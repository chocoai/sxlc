package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
 

import cn.springmvc.dao.PlatformAnnouncementDao;
import cn.springmvc.dao.PlatformAnnouncementListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;  
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.PlatformAnnouncementEntity;
import cn.springmvc.service.PlatformAnnouncementService;
 
@Service("platformAnnouncementServiceImpl")
public class PlatformAnnouncementServiceImpl implements PlatformAnnouncementService{
	@Resource(name="platformAnnouncementDaoImpl")
	private PlatformAnnouncementDao platformAnnouncementDaoImpl; 
	@Resource(name="platformAnnouncementListDaoImpl")
	private PlatformAnnouncementListDao platformAnnouncementListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertPlatform(PlatformAnnouncementEntity entity
			,InsertAdminLogEntity logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		/**
		 * 查询该平台公告是否存在
		 */
		PlatformAnnouncementEntity platformAnnouncementEntity= platformAnnouncementListDaoImpl.
				selectPlatformIsExistByNAme(entity);
		if(platformAnnouncementEntity != null){
			return -1;
		}
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = platformAnnouncementDaoImpl.insertPlatform(entity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("新增平台公告 :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
		
	}

	@Override
	public int deletePlatform(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		PlatformAnnouncementEntity platformAnnouncementEntity = 
				platformAnnouncementListDaoImpl.selectPlatformByID(id);
		
		int result = platformAnnouncementDaoImpl.deletePlatformByID(id);
		if(result == 1) { 
			logentity.setsDetail("删除平台公告 :"+platformAnnouncementEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updatePlatform(PlatformAnnouncementEntity entity,
			InsertAdminLogEntity logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		/**
		 * 查询该平台公告是否存在
		 */
		PlatformAnnouncementEntity platformAnnouncementEntity = platformAnnouncementListDaoImpl.
				selectPlatformIsExistByNAme(entity);
		if(platformAnnouncementEntity != null){
			return -1;
		}
		int result = platformAnnouncementDaoImpl.updatePlatformByID(entity);
		
		if(result == 1) { 
			logentity.setsDetail("修改平台公告 :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		
		return result;
	}
 

	@Override
	public int updatePlatformStatuByID(PlatformAnnouncementEntity entity,
			InsertAdminLogEntity logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		if(entity.getStatu() == 1) {
			entity.setStatu(0);
		}else{
			entity.setStatu(1);
		}
		PlatformAnnouncementEntity platformAnnouncementEntity = 
				platformAnnouncementListDaoImpl.selectPlatformByID(entity.getId());
		
		int result = platformAnnouncementDaoImpl.updatePlatformStatuByID(entity);
		if(result == 1 && entity.getStatu() == 1) { 
			
			logentity.setsDetail("启用平台公告 :"+platformAnnouncementEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用平台公告 :"+platformAnnouncementEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<PlatformAnnouncementEntity> selectPlatformList(PageEntity pageEntity) {
		
		List<PlatformAnnouncementEntity> platformList = null; 
	 	platformList = platformAnnouncementListDaoImpl.selectPlatformList(pageEntity);  
		return platformList; 
		
	}

	 
	@Override
	public PlatformAnnouncementEntity selectPlatformByID(long id) {
		
		PlatformAnnouncementEntity platformAnnouncementEntity = platformAnnouncementListDaoImpl.
				selectPlatformByID(id);
		return platformAnnouncementEntity;
		
	}

	@Override
	public List<PlatformAnnouncementEntity> selectPlatformListIndex() {
		
		return platformAnnouncementListDaoImpl.selectPlatformListIndex();
		
	}

}
