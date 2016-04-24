package cn.springmvc.service.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
  
import cn.springmvc.dao.LoginBannerDao;
import cn.springmvc.dao.LoginBannerListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.LoginBannerEntity; 
import cn.springmvc.service.LoginBannerService;
@Service("loginBannerServiceImpl")
public class LoginBannerServiceImpl implements LoginBannerService {
	@Resource(name="loginBannerListDaoImpl")
	private LoginBannerListDao loginBannerListDaoImpl;  
	@Resource(name="loginBannerDaoImpl")
	private LoginBannerDao loginBannerDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertLoginBanner(LoginBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
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
			logentity.setsDetail("添加登录界面轮播图:"+entity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int deleteLoginBannerByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		LoginBannerEntity loginBannerEntity = loginBannerListDaoImpl.selectLoginBannerByID(id);
		int result = loginBannerDaoImpl.deleteLoginBannerByID(id);
		if(result == 1) {
		    logentity.setsDetail("删除登录界面轮播图  :"+loginBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateLoginBannerByID(LoginBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		LoginBannerEntity loginBannerEntity= loginBannerListDaoImpl.selectLoginBannerIsExistByNAme(entity);
		if(loginBannerEntity != null) {
			return -1;
		} 
		int result=loginBannerDaoImpl.updateLoginBannerByID(entity); 
		if(result == 1) {
		    logentity.setsDetail("修改登录界面轮播图  :"+entity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateLoginBannerStatuByID(LoginBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		LoginBannerEntity loginBannerEntity = loginBannerListDaoImpl.
				selectLoginBannerByID(entity.getId());
		
		int result = loginBannerDaoImpl.updateLoginBannerStatuByID(entity);
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用登录界面轮播图  :"+loginBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用登录界面轮播图  :"+loginBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
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
	public int moveAndDownLoginBannerByID(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(map == null) {
			return -1;
		}
		
		if(map.get("flag") == null) {
			return -1;
		}
		
		if(map.get("iid") == null) {
			return -1;
		}
		
		//type 大于0上移,小于0下移
		int type = IntegerAndString.StringToInt(map.get("flag").toString(), 0);
		
		long ID = IntegerAndString.StringToLong(map.get("iid").toString(), 0);
		LoginBannerEntity loginBannerEntity = loginBannerListDaoImpl.
				selectLoginBannerByID(ID);
		
		int result = loginBannerDaoImpl.moveAndDownLoginBannerByID(map);
		if(result == 1 && type > 0) {
			logentity.setsDetail("上移登录界面轮播图  :"+loginBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && type < 0){
			logentity.setsDetail("下移登录界面轮播图  :"+loginBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

 
	@Override
	public LoginBannerEntity selectLoginBannerByID(long id) {
		
		LoginBannerEntity loginBannerEntity = loginBannerListDaoImpl.selectLoginBannerByID(id);
		return loginBannerEntity; 
	}

	@Override
	public List<LoginBannerEntity> selectLoginBannerfront() {
		
		return loginBannerListDaoImpl.selectLoginBannerfront();
		
	}

}
