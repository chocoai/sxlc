package  cn.springmvc.service.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.integralmall.model.CommodityInfoEntity;
import cn.integralmall.model.CommodityTypeEntity;
import cn.integralmall.model.InventoryRecordsEntity;
import cn.springmvc.dao.CommodityInfoDao;
import cn.springmvc.dao.CommodityInfoListDao;  
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.service.CommodityInfoService;
 
import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import product_p2p.kit.pageselect.PageUtil;
@Service("commodityInfoServiceImpl")
public class CommodityInfoServiceImpl implements CommodityInfoService {
	@Resource(name="commodityInfoDaoImpl")
	private CommodityInfoDao commodityInfoDao;  
	@Resource(name="commodityInfoListDaoImpl")
	private CommodityInfoListDao commodityInfoListDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public List<CommodityInfoEntity> selectCommodityInfoList(PageEntity pageEntity) {
		List<CommodityInfoEntity> list = commodityInfoListDao.selectCommodityInfoList(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return  list;
		
	}
	@Override
	public List<CommodityTypeEntity> selectCommodityType(int commodityType,
			long superID) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("commodityType", commodityType);
		map.put("superID",             superID);
		return commodityInfoListDao.selectCommodityType(map);
		
	}
	@Override
	public List<CommodityTypeEntity> selectCommodityTypeDiCT(String tcode) {
		
		return commodityInfoListDao.selectCommodityTypeDiCT(tcode);
		
	}
	@Override
	public int insertCommodityInfo(CommodityInfoEntity commodityInfoEntity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(commodityInfoEntity == null) {
			return 0;
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		Long id = generatorUtil.GetId();
		commodityInfoEntity.setCommodityID(id);
		
        int result = commodityInfoDao.insertCommodityInfo(commodityInfoEntity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加商品:"+commodityInfoEntity.getCommodityName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
	@Override
	public CommodityInfoEntity selectCommodityInfoByID(long commodityID) {
		
		return commodityInfoListDao.selectCommodityInfoByID(commodityID);
		
	}
	@Override
	public int updateCommodityInfo(CommodityInfoEntity commodityInfoEntity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(commodityInfoEntity == null) {
			return 0;
		}
		int result = commodityInfoDao.updateCommodityInfo(commodityInfoEntity);
		if(result == 1) {
			logentity.setsDetail("修改商品:"+commodityInfoEntity.getCommodityName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);	
		}
		return result;
	}
	@Override
	public int updateCommodityStatu(int commodityStatu, long commodityID,long adminID,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("commodityID",       commodityID);
		map.put("commodityStatu", commodityStatu);
		map.put("adminID",               adminID);
		int result = commodityInfoDao.updateCommodityStatu(map); 
		if(result == 1) {
			
			CommodityInfoEntity commodityInfoEntity = commodityInfoListDao.
					selectCommodityInfoByID(commodityID);
			
			if(commodityStatu == 1) {
			 
				logentity.setsDetail("上架商品:"+commodityInfoEntity.getCommodityName());
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);	
			}else {
				logentity.setsDetail("下架商品:"+commodityInfoEntity.getCommodityName());
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);	
			}
			
			result = commodityInfoDao.insertCommodityUpDown(map);
		}
		
		return result;
		
	}
	@Override
	public List<InventoryRecordsEntity> selectInventoryrecordsIn(PageEntity pageEntity) {
		List<InventoryRecordsEntity> list = commodityInfoListDao.selectInventoryrecordsIn(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
		
	}
	@Override
	public int insertInventoryrecords(InventoryRecordsEntity inventoryRecordsEntity
			,InsertAdminLogEntity logentity,String[] sIpInfo) {
		
		CommodityInfoEntity commodityInfoEntity = commodityInfoListDao.
				selectCommodityInfoByID(inventoryRecordsEntity.getCommodityID());
		
		int result = commodityInfoDao.insertInventoryrecords(inventoryRecordsEntity);
		if(result == 1) {
			logentity.setsDetail("商品入库:"+commodityInfoEntity.getCommodityName()+"，入库数量："+commodityInfoEntity.getQuantity());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);	
		}
		return result;
		
	}
	@Override
	public int updateCommodityISPush(long commodityID, int isPush,
			InsertAdminLogEntity logentity,String[] sIpInfo) { 
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("commodityID", commodityID);
		map.put("isPush",           isPush);
		int result = commodityInfoDao.updateCommodityISPush(map);
		
		CommodityInfoEntity commodityInfoEntity = commodityInfoListDao.
				selectCommodityInfoByID(commodityID);
		
		if(result == 1&& isPush == 1) {
			logentity.setsDetail("推送商品:"+commodityInfoEntity.getCommodityName()+"到商城首页");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);	
		}else if(result == 1&& isPush == 0) {
			logentity.setsDetail("取消推送商品:"+commodityInfoEntity.getCommodityName()+"到商城首页");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);	
		}
		return result;
	}
	@Override
	public int updateCommodityVIPDiscount(long commodityID, String vipDiscount,
			InsertAdminLogEntity logentity,String[] sIpInfo) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("commodityID", commodityID);
		map.put("vipDiscount", IntegerAndString.StringToInt(vipDiscount));
		int reslut = commodityInfoDao.updateCommodityVIPDiscount(map);
		if(reslut == 1) {
			CommodityInfoEntity commodityInfoEntity = commodityInfoListDao.
					selectCommodityInfoByID(commodityID);
			logentity.setsDetail("设置商品:"+commodityInfoEntity.getCommodityName()+"的VIP折扣为："+vipDiscount+"%");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);	
		}
		return reslut;
	} 
  
}
