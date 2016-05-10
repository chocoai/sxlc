

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
import cn.springmvc.dao.InviteMasterApplyListDao;

/** 
 * @author 刘利 
 * @Description: 推荐达人
 * @since 
 * @date 2016-4-1 下午1:50:46  */
@Repository("inviteMasterApplyListDaoImpl")
public class InviteMasterApplyListDaoImpl extends SqlSessionDaoSupport implements InviteMasterApplyListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
 
	@Override
	public int selectInviteMasterApplyIsExist(long memberID) {
		
		return getSqlSession().selectOne("InviteMasterApply.selectInviteMasterApplyIsExist",memberID);
		
	}

	@Override
	public List<InviteMasterAwardRecordEntity> getInviteMasterAwardRecord(
			PageEntity page) {
		
		return getSqlSession().selectList("InviteMasterApply.getInviteMasterAwardRecord",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<AwardPaymentRecordEntity> getInviteMasterHistoryBack(
			PageEntity page) {
		
		return getSqlSession().selectList("InviteMasterApply.getInviteMasterHistoryBack",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<InvitationRecordEntity> getInviteInvitationRecord(
			PageEntity page) {
		
		return getSqlSession().selectList("InviteMasterApply.getInviteInvitationRecord",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<BorrowingDetailedEntity> selectInviteBorrowing(PageEntity page) {
		
		return getSqlSession().selectList("InviteMasterApply.selectInviteBorrowing",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<InvestDetailedEntity> getInviteInvest(PageEntity page) {
		
		return getSqlSession().selectList("InviteMasterApply.getInviteInvest",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<BayVIPEntity> getInviteVipPay(PageEntity page) {
		
		return getSqlSession().selectList("InviteMasterApply.getInviteVipPay",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public List<InvestRepaymentEntity> getRepaymentInvite(PageEntity page) {
		
		return getSqlSession().selectList("InviteMasterApply.getRepaymentInvite",page,
				new RowBounds(page.getPageNum(),page.getPageSize()));
		
	}

	@Override
	public InviteMasterAwardRecordEntity selectInviteMasterStatistic(
			Map<String, Object> map) {
		
	   return  getSqlSession().selectOne("InviteMasterApply.selectInviteMasterStatistic",map);
		
	}

	@Override
	public List<InviteMasterAwardRecordEntity> getInviteMasterAwardRecordExcel(
			Map<String, Object> map) {
		
		return getSqlSession().selectList("InviteMasterExcel.getInviteMasterAwardRecordExcel",map);
		
	} 
	
	@Override
	public List<AwardPaymentRecordEntity> getInviteMasterHistoryBackExcel(
			Map<String, Object> map) {
		
		return getSqlSession().selectList("InviteMasterExcel.getInviteMasterHistoryBackExcel",map);
		
	} 
}

