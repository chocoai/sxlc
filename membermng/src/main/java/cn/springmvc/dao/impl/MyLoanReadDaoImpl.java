package cn.springmvc.dao.impl; 

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.Financing;
import cn.membermng.model.FlowLabel;
import cn.membermng.model.InvestmentRecord;
import cn.membermng.model.LoanRepay;
import cn.membermng.model.RepaymentIn;

/***
* 我的借款查询实现
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-31 上午10:23:05 
*
 */
@Repository
public class MyLoanReadDaoImpl extends SqlSessionDaoSupport implements IMyLoanReadDao{

	
	
	@Override
	public List<Financing> financings(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.financings", entity.getMap(), new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	
	@Override
	public List<Financing> endOfFinancing(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.endOfFinancing",entity.getMap(), new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<RepaymentIn> repaymentIns(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.repaymentIns",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<InvestmentRecord> investRecord(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.investRecord",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<LoanRepay> loanRepay(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.loanRepay",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<FlowLabel> flowLabelS(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.flowLabelS",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	} 
	
	
	
	
	
	
	
	
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
}

