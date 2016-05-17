
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.dbkey.DbKeyUtil;

import cn.membermng.model.MemberTradingIdEntity;
import cn.springmvc.dao.BalanceDealDao;
@Repository("balanceDealDaoImpl")
public class BalanceDealDaoImpl extends SqlSessionDaoSupport implements BalanceDealDao  {

	@Override
	public List<MemberTradingIdEntity> GetUnDealRecordList() {
		List<MemberTradingIdEntity> list = null;
		list = getSqlSession().selectList("balanceDeal.getMemberUnDealRecord", null);
		return list;
	}

	@Override
	public void MemberBalanceDeal(long lRecordId) {
		String sKey = DbKeyUtil.GetDbCodeKey();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tradeID", lRecordId);
		param.put("sKey", sKey);
		
		getSqlSession().update("balanceDeal.DealTradeRecord",param);
	}

	@Override
	public List<MemberTradingIdEntity> GetUnDealAccountRecordList() {
		
		List<MemberTradingIdEntity> list = null;
		list = getSqlSession().selectList("balanceDeal.getMemberUnDealAccountRecord", null);
		return list;
		
	}

	@Override
	public void MemberAccountDeal(long lRecordId) {
		
		String sKey = DbKeyUtil.GetDbCodeKey();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tradeID", lRecordId);
		param.put("sKey", sKey);
		
		getSqlSession().update("balanceDeal.DealTradeRecordAccount",param);
		
	}
	
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}

