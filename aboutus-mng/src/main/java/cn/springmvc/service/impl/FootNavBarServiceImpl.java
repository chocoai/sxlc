package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.FootNavBarDao;
import cn.springmvc.dao.FootNavBarListDao;
import cn.springmvc.dao.impl.FootNavBarDaoImpl;
import cn.springmvc.dao.impl.FootNavBarListDaoImpl; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
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
	@Override
	public int insertFootNavBar(FootNavBarEntity entity) {
		
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
		}
		return result; 
	}

	@Override
	public int deleteFootNavBarByID(int id) {
		
		int result = footNavBarDaoImpl.deleteFootNavBarByID(id); 
		return result;
	}

	@Override
	public int updateFootNavBarByID(FootNavBarEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的底部导航条是否存在,如果已存在则不插入  
		FootNavBarEntity footNavBarEntity = footNavBarListDaoImpl.selectFootNavBarIsExistByNAme(entity);
		if(footNavBarEntity != null) {
			return -1;
		} 
		int result = footNavBarDaoImpl.updateFootNavBarByID(entity);
		
		return result;
	}

	@Override
	public int updateFootNavBarStatuByID(FootNavBarEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		int result=footNavBarDaoImpl.updateFootNavBarStatuByID(entity); 
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
	public FootNavBarEntity selectFootNavBarByID(int id) {
		
		FootNavBarEntity footNavBarEntity = footNavBarListDaoImpl.selectFootNavBarByID(id); 
		return  footNavBarEntity;
	}

	@Override
	public List<FootNavBarEntity> selectFootNavBarfront() {
		
		return footNavBarListDaoImpl.selectFootNavBarfront();
		
	}

}
