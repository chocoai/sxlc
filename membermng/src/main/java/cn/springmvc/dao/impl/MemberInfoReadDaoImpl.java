package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.IntegralRecords;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberVouchers;
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
		return getSqlSession().selectList("memberInfoDaoImpl.friendInvitation",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	
	@Override
	public List<IntegralRecords> addPoints(PageEntity entity) {
	
		return getSqlSession().selectList("memberInfoDaoImpl.addPoints", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public Map<String,Object> points(Map<String,Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.points", param);
	}
	
	
	@Override
	public List rePoints(Map<String,Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.rePoints", param);
	}
	
	
	@Override
	public MyRedPackage myRedPackage(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.myRedPackage", param);
	}
	
	@Override
	public List<RadPackage> redPackages(PageEntity entity) {
		
		return getSqlSession().selectList("memberInfoDaoImpl.redPackages", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public MemberVouchers myVouchers(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberInfoDaoImpl.myVouchers", param);
	}
	
	
	@Override
	public List<MemberVouchers> vouchers(PageEntity entity) {
		
		return getSqlSession().selectList("memberInfoDaoImpl.vouchers", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public MemberInfo findMemberInfoByParam(Map<String, Object> param) {
		return getSqlSession().selectOne("memberInfoDaoImpl.findMemberInfoByParam",param);
	}
	
	
	@Override
	public SecurityInfo securityInfo(Map<String, Object> param) {
		return getSqlSession().selectOne("memberInfoDaoImpl.securityInfo",param);
	}
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	


}
