

/** 
* @Title: RecordsBalanceServiceImpl.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-22 下午1:58:23 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;

import cn.membermng.model.MemberRedpacketsEntity;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.membermng.model.OwnTradingRecordsBalanceEntity;
import cn.springmvc.dao.impl.RecordsBalanceDaoImpl;
import cn.springmvc.service.RecordsBalanceService;

/** 
 * @author 刘利 
 * @Description: 查询会员账户信息 ,与红包信息，投资与借款收还款信息
 * @since 
 * @date 2016-3-22 下午1:58:23  */
@Service("recordsBalanceServiceImpl")
public class RecordsBalanceServiceImpl implements RecordsBalanceService {
	@Resource(name="recordsBalanceDaoImpl")
	private RecordsBalanceDaoImpl recordsBalanceDaoImpl;
	
	@Override
	public OwnTradingRecordsBalanceEntity selectMemberBalance(
			Map<String, Object> map) {

		OwnTradingRecordsBalanceEntity ownTradingRecordsBalanceEntity=null;
		ownTradingRecordsBalanceEntity = recordsBalanceDaoImpl.selectMemberBalance(map);
		return ownTradingRecordsBalanceEntity;

	}

 	
	@Override
	public List<MemberRedpacketsEntity> selectMembergift(int memberID) {
		
		List<MemberRedpacketsEntity>  memberRedpacketsList = null;
		memberRedpacketsList = recordsBalanceDaoImpl.selectMembergift(memberID);
		return memberRedpacketsList;
		
	}

 
	@Override
	public int selectMembergiftCount(int memberID) {
		
		return recordsBalanceDaoImpl.selectMembergiftCount(memberID);
		
	}
	 
	
	@Override
	public int selectTotalreplay(int membereID) {
		
		return recordsBalanceDaoImpl.selectTotalreplay(membereID);
		
	}


	@Override
	public int selectAdvanceReplay(int membereID) {
		
		return recordsBalanceDaoImpl.selectAdvanceReplay(membereID);
		
	}

	@Override
	public int selectTotalReplayOver(int membereID) {
		
		return recordsBalanceDaoImpl.selectTotalReplayOver(membereID);
		
	}

	@Override
	public int selectTotalInvest(int membereID) {
		
		return recordsBalanceDaoImpl.selectTotalInvest(membereID);
		
	}

	@Override
	public int selectReplayOverLimit(int membereID) {
		
		return recordsBalanceDaoImpl.selectReplayOverLimit(membereID);
		
	}


	 
	@Override
	public int selectTotalOverNotReplay(int membereID) {
		
		return  recordsBalanceDaoImpl.selectTotalOverNotReplay(membereID);
		
	}


 	@Override
	public long selectMemberInvestTotal(int memberID) {
 		
 		Map<String, Object> map =new HashMap<String, Object>();
	    map.put("sKey", DbKeyUtil.GetDbCodeKey());
	    map.put("memberID", memberID);
 		return  recordsBalanceDaoImpl.selectMemberInvestTotal(map);
		
	}


	 	
	@Override
	public long selectRecvPrincipalTotal(int membereID) {
		
		Map<String, Object> map =new HashMap<String, Object>();
	    map.put("sKey", DbKeyUtil.GetDbCodeKey());
	    map.put("memberID", membereID);
		return  recordsBalanceDaoImpl.selectRecvPrincipalTotal(map);
		
	}


	 	
	@Override
	public long selectMemberReIncomeTotal(int membereID) {
		
		Map<String, Object> map =new HashMap<String, Object>();
	    map.put("sKey", DbKeyUtil.GetDbCodeKey());
	    map.put("memberID", membereID);
		return  recordsBalanceDaoImpl.selectMemberReIncomeTotal(map);
		
	}


 	@Override
	public long selectSDRecvPrincipalTotal(int membereID) {
 		
 		Map<String, Object> map =new HashMap<String, Object>();
	    map.put("sKey", DbKeyUtil.GetDbCodeKey());
	    map.put("memberID", membereID);
 		return  recordsBalanceDaoImpl.selectSDRecvPrincipalTotal(map);
		
	}


	 	
	@Override
	public long selectMemberSDIncomeTotal(int membereID) {
		
		Map<String, Object> map =new HashMap<String, Object>();
	    map.put("sKey", DbKeyUtil.GetDbCodeKey());
	    map.put("memberID", membereID);
		return  recordsBalanceDaoImpl.selectMemberSDIncomeTotal(map);
		
	}


	@Override
	public MemberThirdAuthInfoEntity selectMemberThirdAuthInfo(
			Map<String, Object> map) { 
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return recordsBalanceDaoImpl.selectMemberThirdAuthInfo(map); 
	}

 

}

