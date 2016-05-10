

package cn.springmvc.dao.impl; 

import java.util.List; 

import javax.annotation.Resource;  

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.CommissionPaymentRecordsEntity;
import cn.invitemastermng.model.PlatformAccountRecordEntity;
import cn.springmvc.dao.SelectCommissionPaymentDao;


/**
 * 佣金发放统计 
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-26 下午2:11:34  */
@Repository("selectCommissionPaymentDaoImpl")
public class SelectCommissionPaymentDaoImpl extends SqlSessionDaoSupport implements SelectCommissionPaymentDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	
	@Override
	public List<CommissionPaymentRecordsEntity> CommissionPaymentRecords(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("CommissionPayment.CommissionPaymentRecords",
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}

	@Override
	public List<CommissionPaymentRecordsEntity> CommissionStatisticsCount(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("CommissionPayment.CommissionStatisticsCount", pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	} 
	@Override
	public List<PlatformAccountRecordEntity> PlatformAccountRecord(
			PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("CommissionPayment.PlatformAccountRecord", pageEntity,
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}
}

