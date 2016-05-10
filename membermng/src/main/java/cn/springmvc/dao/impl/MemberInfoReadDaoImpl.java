package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.ExchangeRecords;
import cn.membermng.model.Friends;
import cn.membermng.model.IntegralGETRecord;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberVouchers;
import cn.membermng.model.MyPoint;
import cn.membermng.model.MyRedPackage;
import cn.membermng.model.RadPackage;
import cn.membermng.model.SecurityInfo;
import cn.springmvc.dao.IMemberReadDao;


@Repository
public class MemberInfoReadDaoImpl extends SqlSessionDaoSupport implements IMemberReadDao{

	
	@Override
	public int countPhone(Map<String,Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.countPhone",param);
	}
	
	
	@Override
	public int countName(String userName) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.countName",userName);
	}
	
	
	
	@Override
	public int countInvitateCode(String invitateCode) {

		return getSqlSession().selectOne("memberInfoDaoImpl.countInvitateCode",invitateCode);
	}

	
	@Override
	public MemberInfo memberPersonalInfo(Map<String,Object> param)  {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.memberPersonalInfo",param);
	}
	
	
	
	@Override
	public MemberInfo memberComplanyInfo(Map<String,Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.memberComplanyInfo",param);
	}
	
	
	@Override
	public List<MemberInfo> friendInvitation(PageEntity entity) {
		return getSqlSession().selectList("memberInfoDaoImpl.friendInvitation",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	@Override
	public List<Friends> friendList(PageEntity entity) {
		
		return getSqlSession().selectList("memberInfoDaoImpl.friendList",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<Friends> selectConfirmFriendList(PageEntity entity) {
		
		return getSqlSession().selectList("memberInfoDaoImpl.selectConfirmFriendList",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	@Override
	public List<IntegralGETRecord> addPoints(PageEntity entity) {
	
		return getSqlSession().selectList("memberInfoDaoImpl.addPoints", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public MyPoint points(Map<String,Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.points", param);
	}
	
	
	
	@Override
	public List<ExchangeRecords> exchangeRecords(PageEntity entity) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.rePoints", entity);
	}
	
	@Override
	public MyRedPackage myRedPackage(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.myRedPackage", param);
	}
	
	@Override
	public List<RadPackage> redPackages(PageEntity entity) {
		
		return getSqlSession().selectList("memberInfoDaoImpl.redPackages", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public MemberVouchers myVouchers(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.myVouchers", param);
	}
	
	
	@Override
	public List<MemberVouchers> vouchers(PageEntity entity) {
		
		return getSqlSession().selectList("memberInfoDaoImpl.vouchers", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	@Override
	public List<MemberVouchers> useVochers(PageEntity entity) {
		return getSqlSession().selectList("memberInfoDaoImpl.addMyVouchers", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public long getRemainderTotal(Map<String, Object> param) {
		
		getSqlSession().selectOne("memberInfoDaoImpl.getRemainderTotal",param);
		return IntegerAndString.StringToLong(param.get("result").toString(), 0);
	}
	
	
	@Override
	public MemberInfo findMemberInfoByParam(Map<String, Object> param) {
		return getSqlSession().selectOne("memberInfoDaoImpl.findMemberInfoByParam",param);
	}
	
	
	@Override
	public SecurityInfo securityInfo(Map<String, Object> param) {
		return getSqlSession().selectOne("memberInfoDaoImpl.securityInfo",param);
	}
	
	@Override
	public List<MemberInfo> serachMemberByParam(PageEntity entity) {
		
		return getSqlSession().selectList("memberInfoDaoImpl.serachMemberByParam",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	@Override
	public int selectMemberIsExist(Map<String, Object> param) {
		getSqlSession().selectOne("memberInfoDaoImpl.selectMemberIsExist", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),0);
	}
	
	@Override
	public Long selectMemberIdByPhone(Map<String, Object> param) {
		getSqlSession().selectOne("memberInfoDaoImpl.selectMemberIdByPhone", param);
		return Long.parseLong(param.get("result").toString());
	}
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		
		super.setSqlSessionFactory(sqlSessionFactory);
	}



}
