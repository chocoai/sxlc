package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.FootNavBarTypeDao;
import cn.springmvc.dao.FootNavBarTypeListDao;
import cn.springmvc.dao.impl.FriendshipLinkDaoImpl;
import cn.springmvc.dao.impl.FriendshipLinkListDaoImpl;
import cn.springmvc.dao.impl.FootNavBarTypeDaoImpl;
import cn.springmvc.dao.impl.FootNavBarTypeListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.FriendshipUnitEntity;
import cn.springmvc.model.FootNavBarTypeEntity;
import cn.springmvc.service.FootNavBarTypeService;
@Service("footNavBarTypeServiceImpl")
public class FootNavBarTypeServiceImpl implements FootNavBarTypeService {
	@Resource(name="footNavBarTypeDaoImpl")
	private FootNavBarTypeDao footNavBarTypeDaoImpl;  
	@Resource(name="footNavBarTypeListDaoImpl")
	private FootNavBarTypeListDao footNavBarTypeListDaoImpl; 
	@Override
	public int insertFootNavBarType(FootNavBarTypeEntity entity) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的底部导航条是否存在,如果已存在则不插入  
		FootNavBarTypeEntity footNavBarTypeEntity = footNavBarTypeListDaoImpl.selectFootNavBarTypeIsExistByNAme(entity);
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
		}
		return result; 
	}

	@Override
	public int deleteFootNavBarTypeByID(int id) {
		
		int result = footNavBarTypeDaoImpl.deleteFootNavBarTypeByID(id); 
		return result;
	}

	@Override
	public int updateFootNavBarTypeByID(FootNavBarTypeEntity entity) {
		
		// 查询该名称的底部导航条是否存在,如果已存在则不插入  
		FootNavBarTypeEntity footNavBarTypeEntity = footNavBarTypeListDaoImpl.selectFootNavBarTypeIsExistByNAme(entity);
		if(footNavBarTypeEntity != null) {
			return -1;
		} 
		int result = footNavBarTypeDaoImpl.updateFootNavBarTypeByID(entity);
		
		return result;
	}

	@Override
	public int updateFootNavBarTypeStatuByID(FootNavBarTypeEntity entity) {
		
		int result = footNavBarTypeDaoImpl.updateFootNavBarTypeStatuByID(entity); 
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
			int id) {
		
		FootNavBarTypeEntity footNavBarTypeEntity = footNavBarTypeListDaoImpl.selectFootNavBarTypeByID(id);
		return footNavBarTypeEntity;
		
	}

}
