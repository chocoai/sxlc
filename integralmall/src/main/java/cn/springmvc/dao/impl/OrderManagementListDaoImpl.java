package  cn.springmvc.dao.impl;
 
import java.util.List; 

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.integralmall.model.OrderRecordsEntity; 
import cn.integralmall.model.ShippingAddress;
import cn.springmvc.dao.OrderManagementListDao;

import product_p2p.kit.pageselect.PageEntity;
/**
 * 
 * @author 刘利 
 * @Description: 订单管理
 * @since 
 * @date 2016-4-11 上午11:59:07
 */
@Repository("orderManagementListDaoImpl")
public class OrderManagementListDaoImpl extends SqlSessionDaoSupport implements OrderManagementListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
 
	@Override
	public List<OrderRecordsEntity> selectalldOrder(PageEntity pageEntity) {
		
		return getSqlSession().selectList("OrderManage.selectalldOrder",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public  ShippingAddress  ShippingAddressByID(long orderID) {
		
		return getSqlSession().selectOne("OrderManage.ShippingAddressByID",orderID);
		
	}
	
}
