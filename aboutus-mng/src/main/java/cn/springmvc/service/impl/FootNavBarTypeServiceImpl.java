package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.FootNavBarTypeDao;
import cn.springmvc.dao.FootNavBarTypeListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.FootNavBarTypeEntity;
import cn.springmvc.service.FootNavBarTypeService;
@Service("footNavBarTypeServiceImpl")
public class FootNavBarTypeServiceImpl implements FootNavBarTypeService {
	@Resource(name="footNavBarTypeDaoImpl")
	private FootNavBarTypeDao footNavBarTypeDaoImpl;  
	@Resource(name="footNavBarTypeListDaoImpl")
	private FootNavBarTypeListDao footNavBarTypeListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertFootNavBarType(FootNavBarTypeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的底部导航条是否存在,如果已存在则不插入  
		FootNavBarTypeEntity footNavBarTypeEntity = footNavBarTypeListDaoImpl.
				selectFootNavBarTypeIsExistByNAme(entity);
		
		if(footNavBarTypeEntity != null) {
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = footNavBarTypeDaoImpl.insertFootNavBarType(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加底部导航条类型 :"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
	}

	@Override
	public int deleteFootNavBarTypeByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		FootNavBarTypeEntity footNavBarTypeEntity = footNavBarTypeListDaoImpl.
				selectFootNavBarTypeByID(id);
		
	    int result = footNavBarTypeDaoImpl.deleteFootNavBarTypeByID(id); 
		if(result == 1) {
		    logentity.setsDetail("删除底部导航条类型  :"+footNavBarTypeEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateFootNavBarTypeByID(FootNavBarTypeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		// 查询该名称的底部导航条是否存在,如果已存在则不插入  
		FootNavBarTypeEntity footNavBarTypeEntity = footNavBarTypeListDaoImpl.
				selectFootNavBarTypeIsExistByNAme(entity);
		
		if(footNavBarTypeEntity != null) {
			return -1;
		} 
		int result = footNavBarTypeDaoImpl.updateFootNavBarTypeByID(entity);
		if(result == 1) {
		    logentity.setsDetail("修改底部导航条类型  :"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateFootNavBarTypeStatuByID(FootNavBarTypeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		FootNavBarTypeEntity footNavBarTypeEntity = footNavBarTypeListDaoImpl.
				selectFootNavBarTypeByID(entity.getId());
		
	    int result = footNavBarTypeDaoImpl.updateFootNavBarTypeStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用底部导航条类型 :"+footNavBarTypeEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用底部导航条类型 :"+footNavBarTypeEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<FootNavBarTypeEntity> selectFootNavBarTypeListpage(
			PageEntity pageEntity) {
		
		List<FootNavBarTypeEntity> footNavBarTypeList = null;    
	 	footNavBarTypeList = footNavBarTypeListDaoImpl.selectFootNavBarTypeList(pageEntity);   
		return footNavBarTypeList; 
	}

 
	@Override
	public FootNavBarTypeEntity selectFootNavBarTypeByID(
			long id) {
		
		FootNavBarTypeEntity footNavBarTypeEntity = footNavBarTypeListDaoImpl.selectFootNavBarTypeByID(id);
		return footNavBarTypeEntity;
		
	}

	@Override
	public List<FootNavBarTypeEntity> selectFootNavBarType() {
		
		return footNavBarTypeListDaoImpl.selectFootNavBarType();
		
	}

}
