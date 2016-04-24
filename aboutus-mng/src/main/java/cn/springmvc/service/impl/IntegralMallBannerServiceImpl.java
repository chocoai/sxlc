package cn.springmvc.service.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.IntegralMallBannerDao;
import cn.springmvc.dao.IntegralMallBannerListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
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
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertIntegralMallBanner(IntegralMallBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		IntegralMallBannerEntity integralMallBannerEntity = integralMallBannerListDaoImpl.selectIntegralMallBannerIsExistByNAme(entity);
		if(integralMallBannerEntity != null) {
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
			logentity.setsDetail("添加积分商城轮播图:"+entity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return integralMallBannerDaoImpl.insertIntegralMallBanner(entity);
	}

	@Override
	public int deleteIntegralMallBannerByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		IntegralMallBannerEntity integralMallBannerEntity = integralMallBannerListDaoImpl.
				selectIntegralMallBannerByID(id);
		
		int result = integralMallBannerDaoImpl.deleteIntegralMallBannerByID(id); 
		if(result == 1) {
		    logentity.setsDetail("删除积分商城轮播图  :"+integralMallBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateIntegralMallBannerByID(IntegralMallBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		IntegralMallBannerEntity integralMallBannerEntity= integralMallBannerListDaoImpl.selectIntegralMallBannerIsExistByNAme(entity);
		if(integralMallBannerEntity != null){
			return -1;
		}  
		int result = integralMallBannerDaoImpl.updateIntegralMallBannerByID(entity); 
		if(result == 1) {
		    logentity.setsDetail("修改积分商城轮播图  :"+entity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateIntegralMallBannerStatuByID(IntegralMallBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		IntegralMallBannerEntity integralMallBannerEntity = integralMallBannerListDaoImpl.
				selectIntegralMallBannerByID(entity.getId());
		int result = integralMallBannerDaoImpl.updateIntegralMallBannerStatuByID(entity);
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用积分商城轮播图  :"+integralMallBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用积分商城轮播图  :"+integralMallBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
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
	public int moveAndDownIntegralMallBannerByID(Map<String, Object> map,InsertAdminLogEntity 
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
		IntegralMallBannerEntity integralMallBannerEntity = integralMallBannerListDaoImpl.
				selectIntegralMallBannerByID(ID);
		
		int result = integralMallBannerDaoImpl.moveAndDownIntegralMallBanner(map);
		if(result == 1 && type > 0) {
			logentity.setsDetail("上移积分商城轮播图  :"+integralMallBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && type < 0){
			logentity.setsDetail("下移积分商城轮播图  :"+integralMallBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

 
	@Override
	public IntegralMallBannerEntity selectIntegralMallBannerByID(long id) {
		
		return integralMallBannerListDaoImpl.selectIntegralMallBannerByID(id); 
		
	}

	@Override
	public List<IntegralMallBannerEntity> selectIntegralMallBannerfront() {
		
		return integralMallBannerListDaoImpl.selectIntegralMallBannerfront();
		
	}

}
