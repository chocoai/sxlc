package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.LoginBannerDao;
import cn.springmvc.dao.LoginBannerListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.LoginBannerDaoImpl;
import cn.springmvc.dao.impl.LoginBannerListDaoImpl; 
import cn.springmvc.model.LoginBannerEntity; 
import cn.springmvc.service.LoginBannerService;
@Service("loginBannerServiceImpl")
public class LoginBannerServiceImpl implements LoginBannerService {
	@Resource(name="loginBannerListDaoImpl")
	private LoginBannerListDao loginBannerListDaoImpl;  
	@Resource(name="loginBannerDaoImpl")
	private LoginBannerDao loginBannerDaoImpl; 
	@Override
	public int insertLoginBanner(LoginBannerEntity entity) {
		
		if(entity == null){
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		LoginBannerEntity loginBannerEntity = loginBannerListDaoImpl.selectLoginBannerIsExistByNAme(entity);
		if(loginBannerEntity != null){
			return -1;
		} 
		int index = loginBannerListDaoImpl.selectLoginBannerindex();
		entity.setIndexs(index+1);  
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = loginBannerDaoImpl.insertLoginBanner(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return result;
	}

	@Override
	public int deleteLoginBannerByID(int id) {
		
		int result = loginBannerDaoImpl.deleteLoginBannerByID(id); 
		return result;
	}

	@Override
	public int updateLoginBannerByID(LoginBannerEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		LoginBannerEntity loginBannerEntity= loginBannerListDaoImpl.selectLoginBannerIsExistByNAme(entity);
		if(loginBannerEntity != null) {
			return -1;
		} 
		int result=loginBannerDaoImpl.updateLoginBannerByID(entity); 
		return result;
	}

	@Override
	public int updateLoginBannerStatuByID(LoginBannerEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		int result = loginBannerDaoImpl.updateLoginBannerStatuByID(entity); 
		return result;
	}

	@Override
	public List<LoginBannerEntity> selectLoginBannerListpage(
			PageEntity pageEntity) {
		
		List<LoginBannerEntity> loginBannerList = null;    
	 	loginBannerList = loginBannerListDaoImpl.selectLoginBannerAllpage(pageEntity);   
		return loginBannerList; 
	}

	@Override
	public int moveAndDownLoginBannerByID(Map<String, Object> map) {
		
		int result = loginBannerDaoImpl.moveAndDownLoginBannerByID(map);
		return result;
	}

 
	@Override
	public LoginBannerEntity selectLoginBannerByID(int id) {
		
		LoginBannerEntity loginBannerEntity = loginBannerListDaoImpl.selectLoginBannerByID(id);
		return loginBannerEntity; 
	}

	@Override
	public List<LoginBannerEntity> selectLoginBannerfront() {
		
		return loginBannerListDaoImpl.selectLoginBannerfront();
		
	}

}
