

/** 
* @Title: RecordsBalanceDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 下午1:55:11 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.membermng.model.MemberRedpacketsEntity;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.membermng.model.OwnTradingRecordsBalanceEntity;
import cn.springmvc.dao.RecordsBalanceDao;

/** 
 * @author 刘利 
 * @Description: 查询会员账户信息 ,与红包信息，投资与借款收还款信息
 * @since 
 * @date 2016-3-22 下午1:55:11  */
@Repository("recordsBalanceDaoImpl")
public class RecordsBalanceDaoImpl extends SqlSessionDaoSupport implements RecordsBalanceDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
 
	@Override
	public OwnTradingRecordsBalanceEntity selectMemberBalance(
			Map<String, Object> map) {

		OwnTradingRecordsBalanceEntity ownTradingRecordsBalanceEntity=null;
		ownTradingRecordsBalanceEntity=getSqlSession().selectOne("tradingRecordsBalance.selectMemberBalance",map);
        return ownTradingRecordsBalanceEntity;
	}

	 
	
	@Override
	public List<MemberRedpacketsEntity> selectMembergift(int memberID) {
		
		List<MemberRedpacketsEntity> memberRedpacketsList = null;
		memberRedpacketsList = getSqlSession().selectList("giftAmount.selectMembergift",memberID);
		return memberRedpacketsList;
	}

	 
	@Override
	public int selectMembergiftCount(int memberID) {
		
		return getSqlSession().selectOne("giftAmount.selectMembergiftCount",memberID);
		
	}
	@Override
	public int selectTotalreplay(int membereID) {
		
		int totalreplay = getSqlSession().selectOne("statistic.selectTotalreplay",membereID);
		return totalreplay;
	}

	 
	
	@Override
	public int selectAdvanceReplay(int membereID) {
		
		int advanceReplay = getSqlSession().selectOne("statistic.selectAdvanceReplay",membereID);
		return advanceReplay;
		
	}

	 
	
	@Override
	public int selectTotalReplayOver(int membereID) {
		
		int  totalReplayOver = getSqlSession().selectOne("statistic.selectTotalReplayOver",membereID);
		return totalReplayOver;
		
	}
 
	
	@Override
	public int selectTotalInvest(int membereID) {
		
		int  totalInvest = getSqlSession().selectOne("statistic.selectTotalInvest",membereID);
		return totalInvest;
		
	}

	 
	
	@Override
	public int selectReplayOverLimit(int membereID) {
		
		int  replayOverLimit = getSqlSession().selectOne("statistic.selectReplayOverLimit",membereID);
		return replayOverLimit;
		
	}

	
	@Override
	public int selectTotalOverNotReplay(int membereID) {
		
		int totalOverNotReplay = getSqlSession().selectOne("statistic.selectTotalOverNotReplay",membereID);
		return totalOverNotReplay;
		
	}

   @Override
	public long selectMemberInvestTotal(Map<String, Object> map) {
		
		return getSqlSession().selectOne("statistic.selectMemberInvestTotal",map);
		
	}

	 
	@Override
	public long selectRecvPrincipalTotal(Map<String, Object> map) {
		
		return getSqlSession().selectOne("statistic.selectRecvPrincipalTotal",map);
		
	}

	 	
	@Override
	public long selectMemberReIncomeTotal(Map<String, Object> map) {
		
		return getSqlSession().selectOne("statistic.selectMemberReIncomeTotal",map);
		
	}

 	
	@Override
	public long selectSDRecvPrincipalTotal(Map<String, Object> map) {
		
		return getSqlSession().selectOne("statistic.selectSDRecvPrincipalTotal",map);
		
	}

	
	@Override
	public long selectMemberSDIncomeTotal(Map<String, Object> map) {
		
	 		return getSqlSession().selectOne("statistic.selectMemberSDIncomeTotal",map);
		
	}

	@Override
	public MemberThirdAuthInfoEntity selectMemberThirdAuthInfo(
			Map<String, Object> map) {
		
		return getSqlSession().selectOne("tradingRecordsBalance.selectMemberTradeInfo",map);
		
	}


}

