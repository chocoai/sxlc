package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.BlackLimitEntity;
import cn.membermng.model.BlackRecordEntity;
import cn.membermng.model.BorrowingStatistics;
import cn.membermng.model.ComplanyInfoEntity;
import cn.membermng.model.InvitationMembers;
import cn.membermng.model.MemberAll;
import cn.membermng.model.MemberAttestInfo;
import cn.membermng.model.MemberBankICardInfos;
import cn.membermng.model.MemberDetaileInfo;
import cn.membermng.model.MemberInfo;
import cn.membermng.model.MemberInvestmentInfo;
import cn.membermng.model.MemberResetPwdEntity;
import cn.membermng.model.MemberThirdInfo;
import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MyRecommand;
import cn.membermng.model.TradingTypeEntity;
import cn.membermng.model.VIPMemberInfos;
import cn.springmvc.dao.IMemberManagerReadDao;


/***
 * 
* @author 李杰
* @Description: TODO 
* @since 5.0
* @date 2016-3-18 下午6:50:58
 */
@Repository
public class MemberManagerReadDaoImpl extends SqlSessionDaoSupport implements IMemberManagerReadDao {
	
	


	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	
	@Override
	public List<MemberAll> getMembersByParam(PageEntity entity) {
		if(entity.getMap().get("memberType") != null && entity.getMap().get("memberType").equals("1")){//企业会员
			return getSqlSession().selectList("memberManagerDao.complayMembers",entity,new RowBounds(entity.getPageNum(),entity.getPageSize()));
		}else{
			return getSqlSession().selectList("memberManagerDao.members",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}
	}
	
	
	@Override
	public MemberDetaileInfo memberInfoById(Map<String,Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.memberInfoById", param);
	}

	
	@Override
	public ComplanyInfoEntity companyInfo(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.complanyInfo", param);
	}
	
	

	@Override
	public MemberThirdInfo memberThirdInfo(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.memberThirdInfo", param);
	}


	@Override
	public List<MemberAttestInfo> memberAttestInfo(Map<String, Object> param) {
		
		return getSqlSession().selectList("memberManagerDao.memberConfInfo", param);
	}


	@Override
	public BorrowingStatistics borrowers(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.borrowers", param);
	}


	@Override
	public MemberInvestmentInfo investment(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.investment", param);
	}


	@Override
	public List<MemberBankICardInfos> bankCards(PageEntity entity) {
		
		return getSqlSession().selectList("memberManagerDao.bankCards",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}


	@Override
	public int resetPassword(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.bankCards",param);
	}


	@Override
	public List<InvitationMembers> invitationsByParam(PageEntity entity) {
		
		return getSqlSession().selectList("memberManagerDao.invitationsByParam", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<VIPMemberInfos> vipMembersByParam(PageEntity entity) {
		if(entity.getMap().get("memberType") !=null && entity.getMap().get("memberType").equals("1")){
			return getSqlSession().selectList("memberManagerDao.complayVipMembers",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}else{
			return getSqlSession().selectList("memberManagerDao.vipMembers",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}
	}
	
	
	@Override
	public List<MemberInfo> registers(PageEntity entity) {
		if(entity.getMap().get("memberType") != null && entity.getMap().get("memberType").equals("1")){
			return getSqlSession().selectList("memberManagerDao.companlyRegisters", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}else{
			return getSqlSession().selectList("memberManagerDao.registers", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}
	}
	
	
	@Override
	public List<MemberInfo> authenticationMember(PageEntity entity) {
		if(entity.getMap().get("memberType") != null && entity.getMap().get("memberType").equals("1")){
			return getSqlSession().selectList("memberManagerDao.companlyAuthenticationMember", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}else{
			return getSqlSession().selectList("memberManagerDao.authenticationMember", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}
	}
	
	@Override
	public List<MemberInfo> loanMember(PageEntity entity) {
		if(entity.getMap().get("memberType") != null && entity.getMap().get("memberType").equals("1")){
			return getSqlSession().selectList("memberManagerDao.complanyLoanMember", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}else{
			return getSqlSession().selectList("memberManagerDao.loanMember", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}
	}
	
	@Override
	public List<MemberInfo> investmentMember(PageEntity entity) {
		if(entity.getMap().get("memberType") != null && entity.getMap().get("memberType").equals("1")){
			return getSqlSession().selectList("memberManagerDao.complanyInvestmentMember",  entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}else{
			return getSqlSession().selectList("memberManagerDao.investmentMember",  entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}
	}
	
	@Override
	public List<MemberInfo> componentMembers(PageEntity entity) {
		if(entity.getMap().get("memberType") != null && entity.getMap().get("memberType").equals("1")){
			return getSqlSession().selectList("memberManagerDao.complanyComponentMember",  entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}else{
			return getSqlSession().selectList("memberManagerDao.componentMember",  entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}
	}
	
	@Override
	public List<MemberInfo> blackList(PageEntity entity) {
		if(entity.getMap().get("memberType") != null && entity.getMap().get("memberType").equals("1")){
			return getSqlSession().selectList("memberManagerDao.complanyBlackList",  entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}else{
			return getSqlSession().selectList("memberManagerDao.blackList", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		}
	}
	
	/**
	 * 交易类型
	 */
	@Override
	public List<TradingTypeEntity> memberTradingTypes() {
		return getSqlSession().selectList("memberManagerDao.memberTradingType");
	}

	/**
	 * 会员交易记录 
	 */
	@Override
	public List<MemberTradingRecordsEntity> memberTradingList(
			PageEntity entity) {
		return getSqlSession().selectList("memberManagerDao.memberTradingList", entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	/**
	 * 会员重置密码记录
	 */
	@Override
	public List<MemberResetPwdEntity> memberResetPwdList(PageEntity entity) {
		return getSqlSession().selectList("memberManagerDao.resetPwdList",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	@Override
	public List<BlackRecordEntity> blackRecord(PageEntity entity) {
		return getSqlSession().selectList("memberManagerDao.removeBlackList",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		
	}
	@Override
	public MyRecommand MyRecommandMan(Map<String, Object> map) {
		return getSqlSession().selectOne("memberManagerDao.myRecommand",map);
	}
	@Override
	public List<MyRecommand> ExceptMyRecommandMan(PageEntity entity) {
		return getSqlSession().selectList("memberManagerDao.ExceptMyRecommandMan",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
		
	}

	@Override
	public List<BlackLimitEntity> blackLimtList() {
		return getSqlSession().selectList("memberManagerDao.blackLimtList");
	}


	@Override
	public int countLimit() {
		return getSqlSession().selectOne("memberManagerDao.countblackLimt");
	}
	
}
