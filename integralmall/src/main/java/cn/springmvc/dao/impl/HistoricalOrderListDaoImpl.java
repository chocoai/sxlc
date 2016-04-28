package  cn.springmvc.dao.impl;
 
import java.util.List; 
import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.integralmall.model.OrderRecordsEntity; 
import cn.springmvc.dao.HistoricalOrderListDao;

import product_p2p.kit.pageselect.PageEntity;
/**
 * 
 * @author 刘利 
 * @Description: 历史订单
 * @since 
 * @date 2016-4-22 上午11:59:07
 */
@Repository("historicalOrderListDaoImpl")
public class HistoricalOrderListDaoImpl extends SqlSessionDaoSupport implements HistoricalOrderListDao {
	
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
 
	@Override
	public List<OrderRecordsEntity> selectCompletedOrder(PageEntity pageEntity) {
		
		return getSqlSession().selectList("HistoricalOrder.selectCompletedOrder",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<OrderRecordsEntity> selectFailedOrder(PageEntity pageEntity) {
		
		return getSqlSession().selectList("HistoricalOrder.selectFailedOrder",pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	
}
