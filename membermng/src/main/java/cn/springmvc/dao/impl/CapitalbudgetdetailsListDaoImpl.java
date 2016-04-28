

/** 
* @Title: CapitalbudgetdetailsListDaoImpl.java 
* @Package cn.capitalbudgetdetails.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-30 下午4:51:41 
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
import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MemberWithdrawalRechargeEntity;
import cn.springmvc.dao.CapitalbudgetdetailsListDao;

/** 
 * @author 刘利 
 * @Description: 会员资金收支明细
 * @since 
 * @date 2016-3-30 下午4:51:41  */
@Repository("capitalbudgetdetailsListDaoImpl")
public class CapitalbudgetdetailsListDaoImpl extends SqlSessionDaoSupport  implements CapitalbudgetdetailsListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<MemberTradingRecordsEntity> selectMemberTradingRecords(
			PageEntity pageEntity) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectList("memberTradingMap.selectMemberTradingRecords",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public MemberTradingRecordsEntity selectTradingRecordsdetail(
			Map<String, Object> map) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectOne("memberTradingMap.selectTradingRecordsdetail",map);
		
	}

	@Override
	public List<MemberWithdrawalRechargeEntity> selectRechargeList(
			PageEntity pageEntity) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectList("memberTradingMap.selectRechargeList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public List<MemberWithdrawalRechargeEntity> selectWithdrawalList(
			PageEntity pageEntity) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectList("memberTradingMap.selectWithdrawalList",pageEntity);
		
	}

	@Override
	public long selectTotalRechargeFee(Map<String, Object> map) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectOne("memberTradingMap.selectTotalRechargeFee",map); 
		
	}

	@Override
	public long selectTotalRechargeReal(Map<String, Object> map) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectOne("memberTradingMap.selectTotalRechargeReal",map);
		
	}

	@Override
	public long selectTotalWithdrawalFee(Map<String, Object> map) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectOne("memberTradingMap.selectTotalWithdrawalFee",map);
		
	}

	@Override
	public long selectTotalWithdrawalReal(Map<String, Object> map) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectOne("memberTradingMap.selectTotalWithdrawalReal",map);
		
	}

	@Override
	public Map<String,Object> selectTotalRechargeInfo(Map<String, Object> map) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectOne("memberTradingMap.selectTotalRechargeInfo",map);
		
	}

	@Override
	public Map<String, Object> selectTotalWithdrawalInfo(Map<String, Object> map) {
		
		//memberTradingMap MemberTradingRecords.xml
		return getSqlSession().selectOne("memberTradingMap.selectTotalWithdrawalInfo",map);
		
	}

}

