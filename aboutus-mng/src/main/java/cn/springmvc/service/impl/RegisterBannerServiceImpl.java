package cn.springmvc.service.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
 

import cn.springmvc.dao.RegisterBannerDao;
import cn.springmvc.dao.RegisterBannerListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.RegisterBannerEntity; 
import cn.springmvc.service.RegisterBannerService;
@Service("registerBannerServiceImpl")
public class RegisterBannerServiceImpl implements RegisterBannerService {
	@Resource(name="registerBannerListDaoImpl")
	private RegisterBannerListDao registerBannerListDaoImpl;  
	@Resource(name="registerBannerDaoImpl")
	private RegisterBannerDao registerBannerDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertRegisterBanner(RegisterBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
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
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId((int)id);
		
		int result = registerBannerDaoImpl.insertRegisterBanner(entity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加注册界面轮播图:"+entity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int deleteRegisterBannerByID(int id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		RegisterBannerEntity registerBannerEntity = registerBannerListDaoImpl.
				selectRegisterBannerByID(id);
		
		int result = registerBannerDaoImpl.deleteRegisterBannerByID(id); 
		if(result ==1 ) {
			
			logentity.setsDetail("删除注册界面轮播图:"+registerBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateRegisterBannerByID(RegisterBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		RegisterBannerEntity registerBannerEntity= registerBannerListDaoImpl.selectRegisterBannerIsExistByNAme(entity);
		if(registerBannerEntity != null) {
			return -1;
		} 
		int result=registerBannerDaoImpl.updateRegisterBannerByID(entity);
		if(result ==1 ) {
			
			logentity.setsDetail("修改注册界面轮播图:"+entity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateRegisterBannerStatuByID(RegisterBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		RegisterBannerEntity registerBannerEntity = registerBannerListDaoImpl.
				selectRegisterBannerByID(entity.getId());
		
		int result = registerBannerDaoImpl.updateRegisterBannerStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用注册界面轮播图  :"+registerBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用注册界面轮播图  :"+registerBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<RegisterBannerEntity> selectRegisterBannerListpage(PageEntity pageEntity) {
		
		List<RegisterBannerEntity> registerBannerList = null;   
		registerBannerList = registerBannerListDaoImpl.selectRegisterBannerAllpage(pageEntity);     
		return registerBannerList; 
	}

	@Override
	public int moveAndDownRegisterBannerByID(Map<String, Object> map,InsertAdminLogEntity 
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
		
		int ID = IntegerAndString.StringToInt(map.get("iid").toString(), 0);
		RegisterBannerEntity registerBannerEntity = registerBannerListDaoImpl.
				selectRegisterBannerByID(ID);
		
		int result = registerBannerDaoImpl.moveAndDownRegisterBannerByID(map);
		if(result == 1 && type > 0) {
			logentity.setsDetail("上移注册界面轮播图  :"+registerBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && type < 0){
			logentity.setsDetail("下移注册界面轮播图  :"+registerBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
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
