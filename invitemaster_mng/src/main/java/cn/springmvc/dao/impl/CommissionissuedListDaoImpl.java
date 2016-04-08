

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
import cn.invitemastermng.model.AwardRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.springmvc.dao.CommissionissuedListDao;
import cn.springmvc.dao.InviteMasterApplyDao;
import cn.springmvc.dao.InviteMasterApplyListDao;

/** 
 * @author 刘利 
 * @Description: 推荐达人统计
 * @since 
 * @date 2016-4-1 下午1:50:46  */
@Repository("commissionissuedListDaoImpl")
public class CommissionissuedListDaoImpl extends SqlSessionDaoSupport implements CommissionissuedListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
  
	@Override
	public List<AwardRecordEntity> getAwardAdvisor(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getAward_Advisor",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<AwardRecordEntity> getAwardInvite(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getAward_Invite",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<BorrowingDetailedEntity> getBorrowingAdvisor(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getBorrowing_Advisor",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<BorrowingDetailedEntity> getBorrowingInvite(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getBorrowing_Invite",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<InvestDetailedEntity> getInvestAdvisor(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getInvest_Advisor",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<InvestDetailedEntity> getInvestInvite(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getInvest_Invite",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<BayVIPEntity> getBayVIPAdvisor(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getBayVIP_Advisor",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<BayVIPEntity> getBayVIPInvite(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getBayVIP_Invite",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<AwardPaymentRecordEntity> getAwardRecordAdvisor(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getAwardRecord_Advisor",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<AwardPaymentRecordEntity> getAwardRecordsInvite(PageEntity page) {
		
		return getSqlSession().selectList("Commissionissued.getAwardRecord_Invite",page.getMap(),new RowBounds(page.getPageNum(),page.getPageSize()));
		
	} 
}

