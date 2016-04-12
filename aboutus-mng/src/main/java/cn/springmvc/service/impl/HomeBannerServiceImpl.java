package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
  

import cn.springmvc.dao.HomeBannerDao;
import cn.springmvc.dao.HomeBannerListDao;
import cn.springmvc.dao.impl.HomeBannerDaoImpl;
import cn.springmvc.dao.impl.HomeBannerListDaoImpl; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.model.HomeBannerEntity; 
import cn.springmvc.service.HomeBannerService;
/**
 * 
* @author 刘利 
* @Description: 首页轮播图的增加，删除，修改，查询 
* @since 
* @date 2016-3-19 下午8:21:22
 */
@Service("homeBannerServiceImpl")
public class HomeBannerServiceImpl implements HomeBannerService {
	@Resource(name="homeBannerListDaoImpl")
	private HomeBannerListDao homeBannerListDaoImpl;  
	@Resource(name="homeBannerDaoImpl")
	private HomeBannerDao homeBannerDaoImpl; 
	@Override
	public int insertHomeBanner(HomeBannerEntity entity) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		HomeBannerEntity homeBannerEntity = homeBannerListDaoImpl.selectHomeBannerIsExistByNAme(entity);
		if(homeBannerEntity != null) {
			return -1;
		} 
		 
		int indexs = homeBannerListDaoImpl.selectHomeBannerindex(); 
		entity.setIndexs(indexs+1);  
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = homeBannerDaoImpl.insertHomeBanner(entity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return result;
	}

	@Override
	public int deleteHomeBannerByID(int id) {
		int result = homeBannerDaoImpl.deleteHomeBannerByID(id); 
		return result;
	}

	@Override
	public int updateHomeBannerByID(HomeBannerEntity entity) {
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		HomeBannerEntity homeBannerEntity= homeBannerListDaoImpl.selectHomeBannerIsExistByNAme(entity);
		if(homeBannerEntity != null) {
			return -1;
		} 
		int result = homeBannerDaoImpl.updateHomeBannerByID(entity); 
		return result;
	}

	@Override
	public int updateHomeBannerStatuByID(HomeBannerEntity entity) {
		
		int result = homeBannerDaoImpl.updateHomeBannerStatuByID(entity); 
		return result;
	}

	@Override
	public List<HomeBannerEntity> selectHomeBannerListpage(PageEntity pageEntity) {
		
		List<HomeBannerEntity> homeBannerList = null;    
	 	homeBannerList = homeBannerListDaoImpl.selectHomeBannerAllpage(pageEntity);   
		return homeBannerList; 
	}

	@Override
	public int moveAndDownHomeBannerByID(Map<String, Object> map) {
		
		int result = homeBannerDaoImpl.moveAndDownHomeBannerByID(map);
		return result;
	}

	@Override
	public HomeBannerEntity selectHomeBannerByID(int id) {
		
	    HomeBannerEntity homeBannerEntity = homeBannerListDaoImpl.selectHomeBannerByID(id);
 		return  homeBannerEntity;
	}

	@Override
	public List<HomeBannerEntity> selectHomeBannerfront() {
		
		return homeBannerListDaoImpl.selectHomeBannerfront();
		
	}

}
