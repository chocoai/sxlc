package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
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
		
		return getSqlSession().selectList("IntegrallServiceReadDaoImpl.goods", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	public List<ShippingAddress> ShippingAddressList(long memberId) {
		
		return getSqlSession().selectList("IntegrallServiceReadDaoImpl.ShippingAddressList",memberId);
	}
	
	
	@Override
	public int BlackMemberJudgmentTre(long memberId, int mType) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("mType", mType);
		// TODO Auto-generated method stub return 0;
		getSqlSession().selectOne("IntegrallServiceReadDaoImpl.BlackMemberJudgmentTre",map);
		int result = IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return result;
		
	}
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
}

