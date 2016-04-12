package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.IMemberManagerDao;
import cn.springmvc.model.BankCardInfo;
import cn.springmvc.model.MemberAttestInfo;
import cn.springmvc.model.MemberBankCard;
import cn.springmvc.model.MemberInfo;
import cn.springmvc.model.MemberThirdInfo;


/***
 * 
* @author 李杰
* @Description: TODO 
* @since 5.0
* @date 2016-3-18 下午6:50:58
 */
@Repository
public class MemberManagerDaoImpl extends SqlSessionDaoSupport implements IMemberManagerDao {
	
	
	@Override
	public List<MemberInfo> getMembersByParam(PageEntity entity) {
		
		return getSqlSession().selectList("memberManagerDao.members",entity.getMap(),new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public MemberInfo memberInfoById(Long memberId) {
		
		return getSqlSession().selectOne("memberManagerDao.memberInfoById", memberId);
	}


	@Override
	public MemberThirdInfo memberThirdInfo(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.memberThirdInfo", param);
	}


	@Override
	public MemberAttestInfo memberAttestInfo(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.memberConfInfo", param);
	}


	@Override
	public Map<String, Object> borrowers(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.borrowers", param);
	}


	@Override
	public Map<String, Object> investment(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.investment", param);
	}


	@Override
	public List<MemberBankCard> bankCards(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.investment",param);
	}


	@Override
	public int resetPassword(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.bankCards",param);
	}


	@Override
	public List<MemberInfo> invitationsByParam(Map<String, Object> param) {
		
		return getSqlSession().selectOne("memberManagerDao.invitationsByParam", param);
	}
	
	@Override
	public int pullBlack(Map<String,Object> param) {
		getSqlSession().selectOne("memberManagerDao.pullBlack",param);
		return Integer.parseInt(param.get("result").toString());
	}
	
	@Override
	public List<MemberInfo> vipMembersByParam(Map<String, Object> param) {
		
		return getSqlSession().selectList("memberManagerDao.vipMembers",param);
	}
	
	
	@Override
	public List<MemberInfo> registers(Map<String, Object> param) {
		
		return getSqlSession().selectList("memberManagerDao.registers", param);
	}
	
	
	@Override
	public List<MemberInfo> authenticationMember(Map<String, Object> param) {
		
		return getSqlSession().selectList("memberManagerDao.authenticationMember", param);
	}
	
	
	@Override
	public List<MemberInfo> loanMember(Map<String, Object> param) {
		
		return getSqlSession().selectList("memberManagerDao.loanMember",param);
	}
	
	
	@Override
	public List<MemberInfo> investmentMember(Map<String, Object> param) {
		
		return getSqlSession().selectList("memberManagerDao.investmentMember", param);
	}
	
	
	
	@Override
	public List<MemberInfo> blackList(Map<String, Object> param) {
		
		return getSqlSession().selectList("memberManagerDao.blackList", param);
	}
	
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
}
