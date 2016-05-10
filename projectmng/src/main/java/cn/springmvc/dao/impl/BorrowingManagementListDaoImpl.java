

/** 
* @Title: BorrowingManagementListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午1:51:12 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.BorrowingManagementListDao;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 借款管理 
 * @since 
 * @date 2016-4-13 下午1:51:12  */
@Repository("borrowingManagementListDaoImpl")
public class BorrowingManagementListDaoImpl extends SqlSessionDaoSupport
		implements BorrowingManagementListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<ProjectAppRecordEntity> getApplyFailure(PageEntity pageEntity) {

		return getSqlSession().selectList("Borrowing_management.getApplyFailure",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));

	}
	@Override
	public List<ProjectAppRecordEntity> getInReview(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getInReview",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	@Override
	public List<ProjectAppRecordEntity> getNotRelease(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getNotRelease",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	@Override
	public List<ProjectAppRecordEntity> getInvestment(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getInvestment",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<ProjectAppRecordEntity> getForLending(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getForLending",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	@Override
	public List<ProjectAppRecordEntity> getInvestFailure(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getInvestFailure",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}
	@Override
	public List<ProjectAppRecordEntity> getInPayment(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getInPayment",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	@Override
	public List<ProjectAppRecordEntity> getSettlementOff(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getSettlementOff",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	@Override
	public List<ProjectAppRecordEntity> getBorrowing(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getBorrowing",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	@Override
	public List<InvestEntity> getInvestmentProject(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getInvestmentProject",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}
	@Override
	public List<InvestEntity> getInvestmentRecord(PageEntity pageEntity) {
		
		return getSqlSession().selectList("Borrowing_management.getInvestmentRecord",pageEntity.getMap(),
				new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	
	}

}

