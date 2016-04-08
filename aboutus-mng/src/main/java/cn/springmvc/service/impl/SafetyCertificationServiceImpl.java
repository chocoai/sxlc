package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.SafetyCertificationDao;
import cn.springmvc.dao.SafetyCertificationListDao;
import cn.springmvc.dao.impl.FriendshipLinkDaoImpl;
import cn.springmvc.dao.impl.FriendshipLinkListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.SafetyCertificationDaoImpl;
import cn.springmvc.dao.impl.SafetyCertificationListDaoImpl;
import cn.springmvc.model.FriendshipUnitEntity;
import cn.springmvc.model.SafetyCertificationEntity;
import cn.springmvc.service.SafetyCertificationService;
@Service("safetyCertificationServiceImpl")
public class SafetyCertificationServiceImpl implements SafetyCertificationService {
	@Resource(name="safetyCertificationDaoImpl")
	private SafetyCertificationDao safetyCertificationDaoImpl;  
	@Resource(name="safetyCertificationListDaoImpl")
	private SafetyCertificationListDao safetyCertificationListDaoImpl; 
	@Override
	public int insertSafetyCertification(SafetyCertificationEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的底部网站认证是否存在,如果已存在则不插入  
		SafetyCertificationEntity safetyCertificationEntity = safetyCertificationListDaoImpl.selectSafetyCertificationIsExistByNAme(entity);
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
		}
		return result; 
	}

	@Override
	public int deleteSafetyCertificationByID(int id) {
		
		int result = safetyCertificationDaoImpl.deleteSafetyCertificationByID(id); 
		return result;
	}

	@Override
	public int updateSafetyCertificationByID(SafetyCertificationEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的底部网站认证是否存在,如果已存在则不插入  
		SafetyCertificationEntity safetyCertificationEntity = safetyCertificationListDaoImpl.selectSafetyCertificationIsExistByNAme(entity);
		if(safetyCertificationEntity != null){
			return -1;
		} 
		int result = safetyCertificationDaoImpl.updateSafetyCertificationByID(entity); 
		return result;
	}

	@Override
	public int updateSafetyCertificationStatuByID(SafetyCertificationEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		int result = safetyCertificationDaoImpl.updateSafetyCertificationStatuByID(entity); 
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
	public SafetyCertificationEntity selectSafetyCertificationByID(int id) {
		
		SafetyCertificationEntity safetyCertificationEntity = safetyCertificationListDaoImpl.selectSafetyCertificationByID(id);
		return safetyCertificationEntity;
		
	}

	@Override
	public List<SafetyCertificationEntity> selectSafetyCertificationfront() {
		
		return safetyCertificationListDaoImpl.selectSafetyCertificationfront();
		
	}

}
