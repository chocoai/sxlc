package cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.FootNavBarDao;
import cn.springmvc.dao.FootNavBarListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.FootNavBarEntity;
import cn.springmvc.service.FootNavBarService;
/**
 * 
* @author 刘利 
* @Description: 实现底部导航条增删改查功能
* @since 
* @date 2016-3-19 下午7:46:34
 */
@Service("footNavBarServiceImpl")
public class FootNavBarServiceImpl implements FootNavBarService {
	@Resource(name="footNavBarDaoImpl")
	private FootNavBarDao footNavBarDaoImpl;  
	@Resource(name="footNavBarListDaoImpl")
	private FootNavBarListDao footNavBarListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertFootNavBar(FootNavBarEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的底部导航条是否存在,如果已存在则不插入  
		FootNavBarEntity footNavBarEntity = footNavBarListDaoImpl.selectFootNavBarIsExistByNAme(entity);
		if(footNavBarEntity != null) {
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = footNavBarDaoImpl.insertFootNavBar(entity); 
		if(result == 0){
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加底部导航条 :"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
	}

	@Override
	public int deleteFootNavBarByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		FootNavBarEntity footNavBarEntity = footNavBarListDaoImpl.selectFootNavBarByID(id);
		int result = footNavBarDaoImpl.deleteFootNavBarByID(id);
		if(result == 1) {
			logentity.setsDetail("删除底部导航条 :"+footNavBarEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateFootNavBarByID(FootNavBarEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的底部导航条是否存在,如果已存在则不插入  
		FootNavBarEntity footNavBarEntity = footNavBarListDaoImpl.selectFootNavBarIsExistByNAme(entity);
		if(footNavBarEntity != null) {
			return -1;
		} 
		int result = footNavBarDaoImpl.updateFootNavBarByID(entity);
		if(result == 1) {
			logentity.setsDetail("修改底部导航条 :"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateFootNavBarStatuByID(FootNavBarEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		FootNavBarEntity footNavBarEntity = footNavBarListDaoImpl.selectFootNavBarByID(entity.getId()); 
		int result=footNavBarDaoImpl.updateFootNavBarStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用底部导航条 :"+footNavBarEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用底部导航条 :"+footNavBarEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<FootNavBarEntity> selectFootNavBarListpage(
			PageEntity pageEntity) {
		
		List<FootNavBarEntity> footNavBarList = null;    
	 	footNavBarList = footNavBarListDaoImpl.selectFootNavBarList(pageEntity);   
		return footNavBarList; 
	}
 
	@Override
	public FootNavBarEntity selectFootNavBarByID(long id) {
		
		FootNavBarEntity footNavBarEntity = footNavBarListDaoImpl.selectFootNavBarByID(id); 
		return  footNavBarEntity;
	}

	@Override
	public List<FootNavBarEntity> selectFootNavBarfront() {
		
		return footNavBarListDaoImpl.selectFootNavBarfront();
		
	}

}
