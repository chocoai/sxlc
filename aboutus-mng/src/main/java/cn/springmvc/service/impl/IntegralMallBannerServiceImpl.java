package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.IntegralMallBannerDao;
import cn.springmvc.dao.IntegralMallBannerListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.IntegralMallBannerDaoImpl;
import cn.springmvc.dao.impl.IntegralMallBannerListDaoImpl; 
import cn.springmvc.model.IntegralMallBannerEntity; 
import cn.springmvc.service.IntegralMallBannerService;
/**
 * 
* @author 刘利 
* @Description: 实现积分商城轮播图增加删除功能
* @since 
* @date 2016-3-19 下午8:29:53
 */
@Service("integralMallBannerServiceImpl")
public class IntegralMallBannerServiceImpl implements IntegralMallBannerService {
	@Resource(name="integralMallBannerListDaoImpl")
	private IntegralMallBannerListDao integralMallBannerListDaoImpl;  
	@Resource(name="integralMallBannerDaoImpl")
	private IntegralMallBannerDao integralMallBannerDaoImpl; 
	@Override
	public int insertIntegralMallBanner(IntegralMallBannerEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		IntegralMallBannerEntity mediaReportsEntity = integralMallBannerListDaoImpl.selectIntegralMallBannerIsExistByNAme(entity);
		if(mediaReportsEntity != null) {
			return -1;
		} 
		int index = integralMallBannerListDaoImpl.selectIntegralMallBannerindex(); 
		entity.setIndexs(index+1); 
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = integralMallBannerDaoImpl.insertIntegralMallBanner(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return integralMallBannerDaoImpl.insertIntegralMallBanner(entity);
	}

	@Override
	public int deleteIntegralMallBannerByID(int id) {
		
		int result = integralMallBannerDaoImpl.deleteIntegralMallBannerByID(id); 
		return result;
	}

	@Override
	public int updateIntegralMallBannerByID(IntegralMallBannerEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		IntegralMallBannerEntity mediaReportsEntity= integralMallBannerListDaoImpl.selectIntegralMallBannerIsExistByNAme(entity);
		if(mediaReportsEntity != null){
			return -1;
		} 
		int result = integralMallBannerDaoImpl.updateIntegralMallBannerByID(entity); 
		return result;
	}

	@Override
	public int updateIntegralMallBannerStatuByID(IntegralMallBannerEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		int result = integralMallBannerDaoImpl.updateIntegralMallBannerStatuByID(entity); 
		return result;
	}

	@Override
	public List<IntegralMallBannerEntity> selectIntegralMallBannerListpage(
			PageEntity pageEntity) {
		
		List<IntegralMallBannerEntity> loginBannerList = null;   
	 	loginBannerList = integralMallBannerListDaoImpl.selectIntegralMallBannerAllpage(pageEntity);     
		return loginBannerList; 
	}

	@Override
	public int moveAndDownIntegralMallBannerByID(Map<String, Object> map) {
		
		int result = integralMallBannerDaoImpl.moveAndDownIntegralMallBanner(map);
		return result;
	}

 
	@Override
	public IntegralMallBannerEntity selectIntegralMallBannerByID(int id) {
		
		IntegralMallBannerEntity mediaReportsEntity = integralMallBannerListDaoImpl.selectIntegralMallBannerByID(id);
		return mediaReportsEntity;
		
	}

	@Override
	public List<IntegralMallBannerEntity> selectIntegralMallBannerfront() {
		
		return integralMallBannerListDaoImpl.selectIntegralMallBannerfront();
		
	}

}
