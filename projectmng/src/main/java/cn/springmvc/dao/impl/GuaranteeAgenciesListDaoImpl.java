

/** 
* @Title: GuaranteeAgenciesListDao.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午5:23:01 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.GuaranteeAgenciesListDao;
import cn.springmvc.model.GuranteeRecordEntity;
import cn.springmvc.model.MemberTradingRecordsEntity;

/** 
 * @author 刘利 
 * @Description: 担保项目
 * @since 
 * @date 2016-4-13 下午5:23:01  */
@Repository("guaranteeAgenciesListDaoImpl")
public class GuaranteeAgenciesListDaoImpl extends SqlSessionDaoSupport implements
		 GuaranteeAgenciesListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<GuranteeRecordEntity> getGuaranteeproject(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Guarantee_agencies.getGuarantee_project",pageEntity.getMap()
				,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

		
	}

	@Override
	public List<GuranteeRecordEntity> getCompensatoryrecord(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("Guarantee_agencies.getCompensatory_record",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

 	}

	@Override
	public List<GuranteeRecordEntity> getReceivablerecords(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Guarantee_agencies.getReceivable_records",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	 }

	@Override
	public List<MemberTradingRecordsEntity> getTransaction(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Guarantee_agencies.getTransaction",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
 	
	}
}

