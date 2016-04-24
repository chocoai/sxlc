package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
 

import cn.springmvc.dao.SafetyCertificationDao;
import cn.springmvc.dao.SafetyCertificationListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.SafetyCertificationEntity;
import cn.springmvc.service.SafetyCertificationService;
@Service("safetyCertificationServiceImpl")
public class SafetyCertificationServiceImpl implements SafetyCertificationService {
	@Resource(name="safetyCertificationDaoImpl")
	private SafetyCertificationDao safetyCertificationDaoImpl;  
	@Resource(name="safetyCertificationListDaoImpl")
	private SafetyCertificationListDao safetyCertificationListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertSafetyCertification(SafetyCertificationEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的底部网站认证是否存在,如果已存在则不插入  
		SafetyCertificationEntity safetyCertificationEntity = safetyCertificationListDaoImpl.
				selectSafetyCertificationIsExistByNAme(entity);
		
		if(safetyCertificationEntity != null){
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = safetyCertificationDaoImpl.insertSafetyCertification(entity); 
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加底部网站认证:"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
	}

	@Override
	public int deleteSafetyCertificationByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		SafetyCertificationEntity safetyCertificationEntity = safetyCertificationListDaoImpl.
				selectSafetyCertificationByID(id);
	    int result = safetyCertificationDaoImpl.deleteSafetyCertificationByID(id);
		if(result == 1) {
		    logentity.setsDetail("删除底部网站认证  :"+safetyCertificationEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateSafetyCertificationByID(SafetyCertificationEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的底部网站认证是否存在,如果已存在则不插入  
		SafetyCertificationEntity safetyCertificationEntity = safetyCertificationListDaoImpl.
				selectSafetyCertificationIsExistByNAme(entity);
		if(safetyCertificationEntity != null){
			return -1;
		} 
		int result = safetyCertificationDaoImpl.updateSafetyCertificationByID(entity); 
		if(result == 1) {
		    logentity.setsDetail("修改底部网站认证  :"+entity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateSafetyCertificationStatuByID(SafetyCertificationEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		SafetyCertificationEntity safetyCertificationEntity = safetyCertificationListDaoImpl.
				selectSafetyCertificationByID(entity.getId());
		
		int result = safetyCertificationDaoImpl.updateSafetyCertificationStatuByID(entity);
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用底部网站认证  :"+safetyCertificationEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用底部网站认证 :"+safetyCertificationEntity.getTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<SafetyCertificationEntity> selectSafetyCertificationList(
			PageEntity pageEntity) {
		
		List<SafetyCertificationEntity> safetyCertificationList = null;    
	 	safetyCertificationList = safetyCertificationListDaoImpl.selectSafetyCertificationList(pageEntity);   
		return safetyCertificationList; 
	}
 
	@Override
	public SafetyCertificationEntity selectSafetyCertificationByID(long id) {
		
		SafetyCertificationEntity safetyCertificationEntity = safetyCertificationListDaoImpl.
				selectSafetyCertificationByID(id);
		
		return safetyCertificationEntity;
		
	}

	@Override
	public List<SafetyCertificationEntity> selectSafetyCertificationfront() {
		
		return safetyCertificationListDaoImpl.selectSafetyCertificationfront();
		
	}

}
