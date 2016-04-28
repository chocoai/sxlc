package  cn.springmvc.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.integralmall.model.CommodityInfoEntity;
import cn.integralmall.model.InventoryRecordsEntity;
import cn.springmvc.dao.CommodityInfoDao; 
 
@Repository("commodityInfoDaoImpl")
public class CommodityInfoDaoImpl extends SqlSessionDaoSupport  implements CommodityInfoDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertCommodityInfo(CommodityInfoEntity commodityInfoEntity) {
		
		 getSqlSession().selectOne("CommodityInfo.insertCommodityInfocall",commodityInfoEntity);
		 return commodityInfoEntity.getResult(); 
	}
	@Override
	public int updateCommodityInfo(CommodityInfoEntity commodityInfoEntity) {
		
		return getSqlSession().update("CommodityInfo.updateCommodityInfo",commodityInfoEntity);
		
	}
	@Override
	public int updateCommodityStatu(Map<String, Object> map) {
		
		return getSqlSession().update("CommodityInfo.updateCommodityStatu",map);
		
	}
	@Override
	public int insertInventoryrecords(
			InventoryRecordsEntity inventoryRecordsEntity) {
		
	    getSqlSession().selectOne("CommodityInfo.insertInventoryrecords",inventoryRecordsEntity);
	    return inventoryRecordsEntity.getResult(); 
		
	}
	@Override
	public int updateCommodityISPush(Map<String, Object> map) {
		
	  getSqlSession().selectOne("CommodityInfo.updateCommodityISPush",map);
	  return IntegerAndString.StringToInt(map.get("result").toString(),0);  
	}
	@Override
	public int updateCommodityVIPDiscount(Map<String, Object> map) {
		
	  return getSqlSession().update("CommodityInfo.updateCommodityVIPDiscount",map); 
	}
	@Override
	public int insertCommodityUpDown(Map<String, Object> map) {
		
	  return getSqlSession().insert("CommodityInfo.insertCommodityUpDown",map); 
		
	}
 
}
