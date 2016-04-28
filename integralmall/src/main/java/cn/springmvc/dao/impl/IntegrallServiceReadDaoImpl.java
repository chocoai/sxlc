package cn.springmvc.dao.impl; 

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.integralmall.model.CommodityInfo;
import cn.integralmall.model.CommodityType;
import cn.integralmall.model.ShippingAddress;
import cn.springmvc.dao.IIntegrallServiceReadDao;


/***
* 
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-8 上午11:39:47 
*
*/
@Repository
public class IntegrallServiceReadDaoImpl extends SqlSessionDaoSupport implements IIntegrallServiceReadDao{

	
	
	public List<CommodityType> indexList() {
		
		return getSqlSession().selectList("IntegrallServiceReadDaoImpl.indexList");
	}
	
	
	public List<CommodityInfo> goodsTop4(long commodityTypeId) {
		
		return getSqlSession().selectList("IntegrallServiceReadDaoImpl.goods_4", commodityTypeId);
	}
	
	
	
	public CommodityInfo commodityInfo(long commodityId) {
		
		return getSqlSession().selectOne("IntegrallServiceReadDaoImpl.commodityInfo",commodityId);
	}
	
	
	public List<CommodityInfo> goods(PageEntity entity) {
		
		return getSqlSession().selectList("IntegrallServiceReadDaoImpl.goods", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	public List<ShippingAddress> ShippingAddressList(long memberId) {
		
		return getSqlSession().selectList("IntegrallServiceReadDaoImpl.ShippingAddressList",memberId);
	}
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
}

