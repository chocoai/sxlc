package  cn.springmvc.dao.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.integralmall.model.CommodityInfoEntity;
import cn.integralmall.model.CommodityTypeEntity;
import cn.integralmall.model.InventoryRecordsEntity;
import cn.springmvc.dao.CommodityInfoListDao; 

import product_p2p.kit.pageselect.PageEntity;
/**
 * 
 * @author 刘利 
 * @Description: 商品管理
 * @since 
 * @date 2016-4-11 上午11:59:07
 */
@Repository("commodityInfoListDaoImpl")
public class CommodityInfoListDaoImpl extends SqlSessionDaoSupport implements CommodityInfoListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	@Override
	public List<CommodityInfoEntity> selectCommodityInfoList(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("CommodityInfo.selectCommodityInfoList",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<CommodityTypeEntity> selectCommodityType(Map<String, Object> map) {
		
		return getSqlSession().selectList("CommodityInfo.selectCommodityType",map);
		
	}
	@Override
	public List<CommodityTypeEntity> selectCommodityTypeDiCT(String tcode) {
		
		return getSqlSession().selectList("CommodityInfo.selectCommodityTypeDiCT",tcode);
		
	}
	@Override
	public CommodityInfoEntity selectCommodityInfoByID(long commodityID) {
		
		return getSqlSession().selectOne("CommodityInfo.selectCommodityInfoByID",commodityID);
		
	}
	@Override
	public List<InventoryRecordsEntity> selectInventoryrecordsIn(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("CommodityInfo.selectInventoryrecordsIn",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	
}
