

/** 
* @Title: GenerateRepayListDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:50:46 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 
 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;  

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
  
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.InvestRepaymentEntity;
import cn.invitemastermng.model.InvitationRecordEntity;
import cn.invitemastermng.model.InviteMasterAwardRecordEntity;
import cn.springmvc.dao.FinancialAdvisorListDao; 

/** 
 * @author 刘利 
 * @Description: 理财顾问
 * @since 
 * @date 2016-4-1 下午1:50:46  */
@Repository("financialAdvisorListDaoImpl")
public class FinancialAdvisorListDaoImpl extends SqlSessionDaoSupport implements FinancialAdvisorListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
   
	@Override
	public List<InviteMasterAwardRecordEntity> getFinancialAdvisorAward(
			PageEntity page) {
		
		return getSqlSession().selectList("FinancialAdvisor.getFinancialAdvisorAward",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}


	@Override
	public List<AwardPaymentRecordEntity> getFinancialMasterHistoryBack(
			PageEntity page) {
		
		return getSqlSession().selectList("FinancialAdvisor.getFinancialMasterHistoryBack",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}


	@Override
	public List<InvitationRecordEntity> getFinancialInvitationRecord(
			PageEntity page) {
		
		return getSqlSession().selectList("FinancialAdvisor.getFinancialInvitationRecord",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}


	@Override
	public List<BorrowingDetailedEntity> selectFinancialBorrowing(
			PageEntity page) {
		
		return getSqlSession().selectList("FinancialAdvisor.selectFinancialBorrowing",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}


	@Override
	public List<InvestDetailedEntity> getFinancialInvest(PageEntity page) {
		
		return getSqlSession().selectList("FinancialAdvisor.getFinancialInvest",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}


	@Override
	public List<BayVIPEntity> getFinancialVipPay(PageEntity page) {
		
		return getSqlSession().selectList("FinancialAdvisor.getFinancialVipPay",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<InvestRepaymentEntity> getRepaymentAdvisor(PageEntity page) {
		
		return getSqlSession().selectList("FinancialAdvisor.getRepaymentAdvisor",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public InviteMasterAwardRecordEntity selectFinancialMasterStatistic(
			Map<String, Object> map) {
		
		 return  getSqlSession().selectOne("FinancialAdvisor.selectFinancialMasterStatistic",map);
		
	}

	@Override
	public List<InviteMasterAwardRecordEntity> getFinancialAdvisorAwardExcel(
			Map<String, Object> map) {
		
		 return  getSqlSession().selectList("FinancialAdvisorExcel.getFinancialAdvisorAwardExcel",map);
		
	}

	@Override
	public List<AwardPaymentRecordEntity> getFinancialHistoryBackExcel(
			Map<String, Object> map) {
		
		 return  getSqlSession().selectOne("FinancialAdvisorExcel.getFinancialHistoryBackExcel",map);
		
	} 
}

