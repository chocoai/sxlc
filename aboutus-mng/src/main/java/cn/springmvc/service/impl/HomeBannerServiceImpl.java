package cn.springmvc.service.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
  

import cn.springmvc.dao.HomeBannerDao;
import cn.springmvc.dao.HomeBannerListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.HomeBannerEntity; 
import cn.springmvc.service.HomeBannerService;
/**
 * 
* @author 刘利 
* @Description: 首页轮播图管理
* @since 
* @date 2016-3-19 下午8:21:22
 */
@Service("homeBannerServiceImpl")
public class HomeBannerServiceImpl implements HomeBannerService {
	@Resource(name="homeBannerListDaoImpl")
	private HomeBannerListDao homeBannerListDaoImpl;  
	@Resource(name="homeBannerDaoImpl")
	private HomeBannerDao homeBannerDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertHomeBanner(HomeBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		if(entity == null){
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		HomeBannerEntity homeBannerEntity = homeBannerListDaoImpl.
				selectHomeBannerIsExistByNAme(entity);
		
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
			logentity.setsDetail("添加首页轮播图:"+entity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int deleteHomeBannerByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		HomeBannerEntity homeBannerEntity = homeBannerListDaoImpl.selectHomeBannerByID(id);
		int result = homeBannerDaoImpl.deleteHomeBannerByID(id); 
		if(result == 1) {
		    logentity.setsDetail("删除首页轮播图  :"+homeBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateHomeBannerByID(HomeBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的轮播图是否存在,如果已存在则不插入  
		HomeBannerEntity homeBannerEntity= homeBannerListDaoImpl.selectHomeBannerIsExistByNAme(entity);
		if(homeBannerEntity != null) {
			return -1;
		} 
		int result = homeBannerDaoImpl.updateHomeBannerByID(entity); 
		if(result == 1) {
		    logentity.setsDetail("修改首页轮播图  :"+entity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateHomeBannerStatuByID(HomeBannerEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		HomeBannerEntity homeBannerEntity = homeBannerListDaoImpl.selectHomeBannerByID(entity.getId());
		int result = homeBannerDaoImpl.updateHomeBannerStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用首页轮播图  :"+homeBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用首页轮播图  :"+homeBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<HomeBannerEntity> selectHomeBannerListpage(PageEntity pageEntity) {
		
		List<HomeBannerEntity> homeBannerList = homeBannerListDaoImpl.selectHomeBannerAllpage(pageEntity);   
		PageUtil.ObjectToPage(pageEntity, homeBannerList);
	 	return homeBannerList; 
	}

	@Override
	public int moveAndDownHomeBannerByID(Map<String, Object> map,InsertAdminLogEntity 
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
		HomeBannerEntity homeBannerEntity = homeBannerListDaoImpl.selectHomeBannerByID(ID);
		
		int result = homeBannerDaoImpl.moveAndDownHomeBannerByID(map);
		if(result == 1 && type > 0) {
			logentity.setsDetail("上移首页轮播图  :"+homeBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && type < 0){
			logentity.setsDetail("下移首页轮播图  :"+homeBannerEntity.getBannerTitle());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public HomeBannerEntity selectHomeBannerByID(long id) {
		
	    HomeBannerEntity homeBannerEntity = homeBannerListDaoImpl.selectHomeBannerByID(id);
 		return  homeBannerEntity;
	}

	@Override
	public List<HomeBannerEntity> selectHomeBannerfront() {
		
		return homeBannerListDaoImpl.selectHomeBannerfront();
		
	}

}
