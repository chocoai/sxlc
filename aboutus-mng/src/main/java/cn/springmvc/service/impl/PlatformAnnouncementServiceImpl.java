package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
 

import cn.springmvc.dao.PlatformAnnouncementDao;
import cn.springmvc.dao.PlatformAnnouncementListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;  
import cn.springmvc.model.PlatformAnnouncementEntity;
import cn.springmvc.service.PlatformAnnouncementService;
 
@Service("platformAnnouncementServiceImpl")
public class PlatformAnnouncementServiceImpl implements PlatformAnnouncementService{
	@Resource(name="platformAnnouncementDaoImpl")
	private PlatformAnnouncementDao platformAnnouncementDaoImpl; 
	@Resource(name="platformAnnouncementListDaoImpl")
	private PlatformAnnouncementListDao platformAnnouncementListDaoImpl; 
	@Override
	public int insertPlatform(PlatformAnnouncementEntity entity) {
		
		if(entity == null) {
			return 0;
		}
		/**
		 * 查询该平台公告是否存在
		 */
		PlatformAnnouncementEntity platformAnnouncementEntity= platformAnnouncementListDaoImpl.selectPlatformIsExistByNAme(entity);
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
		}
		return result; 
		
	}

	@Override
	public int deletePlatform(int id) {
		
		int result = platformAnnouncementDaoImpl.deletePlatformByID(id);
		return result;
	}

	@Override
	public int updatePlatform(PlatformAnnouncementEntity entity) {
		
		if(entity == null) {
			return 0;
		}
		/**
		 * 查询该平台公告是否存在
		 */
		PlatformAnnouncementEntity platformAnnouncementEntity = platformAnnouncementListDaoImpl.selectPlatformIsExistByNAme(entity);
		if(platformAnnouncementEntity != null){
			return -1;
		}
		int result = platformAnnouncementDaoImpl.updatePlatformByID(entity);
		return result;
	}
 

	@Override
	public int updatePlatformStatuByID(PlatformAnnouncementEntity entity) {
		
		if(entity == null) {
			return 0;
		}
		if(entity.getStatu() == 1) {
			entity.setStatu(0);
		}else{
			entity.setStatu(1);
		}
		int result = platformAnnouncementDaoImpl.updatePlatformStatuByID(entity);
		return result;
	}

	@Override
	public List<PlatformAnnouncementEntity> selectPlatformList(PageEntity pageEntity) {
		
		List<PlatformAnnouncementEntity> platformList = null; 
	 	platformList = platformAnnouncementListDaoImpl.selectPlatformList(pageEntity);  
		return platformList; 
		
	}

	 
	@Override
	public PlatformAnnouncementEntity selectPlatformByID(int id) {
		
		PlatformAnnouncementEntity platformAnnouncementEntity = platformAnnouncementListDaoImpl.selectPlatformByID(id);
		return platformAnnouncementEntity;
		
	}

	@Override
	public List<PlatformAnnouncementEntity> selectPlatformListIndex() {
		
		return platformAnnouncementListDaoImpl.selectPlatformListIndex();
		
	}

}
