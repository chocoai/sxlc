package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.RegisterBannerDao;
import cn.springmvc.dao.RegisterBannerListDao;
import cn.springmvc.dao.impl.RegisterBannerDaoImpl;
import cn.springmvc.dao.impl.RegisterBannerListDaoImpl; 
import cn.springmvc.model.RegisterBannerEntity; 
import cn.springmvc.service.RegisterBannerService;
@Service("registerBannerServiceImpl")
public class RegisterBannerServiceImpl implements RegisterBannerService {
	@Resource(name="registerBannerListDaoImpl")
	private RegisterBannerListDao registerBannerListDaoImpl;  
	@Resource(name="registerBannerDaoImpl")
	private RegisterBannerDao registerBannerDaoImpl; 
	@Override
	public int insertRegisterBanner(RegisterBannerEntity entity) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		RegisterBannerEntity registerBannerEntity= registerBannerListDaoImpl.selectRegisterBannerIsExistByNAme(entity);
		if(registerBannerEntity != null) {
			return -1;
		}
		
		int index = registerBannerListDaoImpl.selectRegisterBannerindex();
		entity.setIndexs(index+1); 
	 
		return registerBannerDaoImpl.insertRegisterBanner(entity);
	}

	@Override
	public int deleteRegisterBannerByID(int id) {
		
		int result = registerBannerDaoImpl.deleteRegisterBannerByID(id); 
		return result;
	}

	@Override
	public int updateRegisterBannerByID(RegisterBannerEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		RegisterBannerEntity registerBannerEntity= registerBannerListDaoImpl.selectRegisterBannerIsExistByNAme(entity);
		if(registerBannerEntity != null) {
			return -1;
		} 
		int result=registerBannerDaoImpl.updateRegisterBannerByID(entity); 
		return result;
	}

	@Override
	public int updateRegisterBannerStatuByID(RegisterBannerEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		int result = registerBannerDaoImpl.updateRegisterBannerStatuByID(entity); 
		return result;
	}

	@Override
	public List<RegisterBannerEntity> selectRegisterBannerListpage(PageEntity pageEntity) {
		
		List<RegisterBannerEntity> registerBannerList = null;   
		registerBannerList = registerBannerListDaoImpl.selectRegisterBannerAllpage(pageEntity);     
		return registerBannerList; 
	}

	@Override
	public int moveAndDownRegisterBannerByID(Map<String, Object> map) {
		
		int result = registerBannerDaoImpl.moveAndDownRegisterBannerByID(map);
		return result;
	}

	 
	@Override
	public RegisterBannerEntity selectRegisterBannerByID(int id) {
		
		RegisterBannerEntity registerBannerEntity = registerBannerListDaoImpl.selectRegisterBannerByID(id);
		return registerBannerEntity;
		
	}

	@Override
	public List<RegisterBannerEntity> selectRegisterBannerfront() {
		
		return registerBannerListDaoImpl.selectRegisterBannerfront();
		
	}

}
