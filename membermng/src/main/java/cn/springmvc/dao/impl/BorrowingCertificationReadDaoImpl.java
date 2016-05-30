
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.dbkey.DbKeyUtil;
import cn.membermng.model.BorrowingType;
import cn.membermng.model.BorrowingTypeInfo;
import cn.membermng.model.CurrencyAuth;
import cn.membermng.model.RealNameAuth;
import cn.springmvc.dao.IBorrowingCertificationReadDao;



@Repository
public class BorrowingCertificationReadDaoImpl extends SqlSessionDaoSupport implements IBorrowingCertificationReadDao {


	@Override
	public List<BorrowingType> getAllByMember(Map<String, Object> param) {
		
		return getSqlSession().selectList("borrowingCertificationDaoImpl.allAuthType",param);
	}
	
	@Override
	public RealNameAuth showAuthRealName(Map<String, Object> param) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthRealName",param);
	}
	
	
	@Override
	public CurrencyAuth showCurrencyAuth(Map<String,Object> param) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showCurrencyAuthById",param);
	}
	

	@Override
	public CurrencyAuth showAuthAddress(Map<String, Object> param) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthAddress",param);
	}
	

	@Override
	public List<CurrencyAuth> showAuthHousing(Map<String, Object> param) {
		
		return getSqlSession().selectList("borrowingCertificationDaoImpl.showAuthHousing",param);
	}


	@Override
	public CurrencyAuth showAuthHousingOne(Map<String, Object> param) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthHousingOne",param);
	}	
	
	
	@Override
	public List<CurrencyAuth> showAuthProduction(long memberId) {
		return getSqlSession().selectList("borrowingCertificationDaoImpl.showAuthProduction", memberId);
	}
	
	@Override
	public CurrencyAuth showAuthProductionOne(Map<String, Object> param) {
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthProductionOne", param);
	}
	
	@Override
	public CurrencyAuth showAuthMarriage(Long memberId) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthMarriage", memberId);
	}
	
	
	@Override
	public CurrencyAuth showAuthEducation(Map<String, Object> param) {
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthEducation", param);
	}
	
	
	
	
/******************************************************************************************************************************************************************************************************************
* 
* 						a ha ha 我是华丽丽的分界线、下面的都是企业会员的了
* 
* 
*******************************************************************************************************************************************************************************************************************/

	
	
	@Override
	public Map<String, Object> showBusinessLicense(long memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showBusinessLicense", param);
	}
	
	
	@Override
	public Map<String, Object> showCommercialLicense(Map<String, Object> param) {
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showCommercialLicense", param);
	}
	
	
	@Override
	public Map<String, Object> showOrganizational(Map<String,Object> param) {
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showOrganizational",param);
	}
	
	
	
	@Override
	public Map<String, Object> showACcountOpening(Map<String, Object> param) {
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAccountOpening", param);
	}
	
	
	@Override
	public Map<String, Object> showTaxRegistration(Map<String, Object> param) {
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showTaxRegistration", param);
	}
	
	
	@Override
	public Map<String, Object> showAuthApproval(long memberId) {
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthApproval", memberId);
	}
	
	
	
	@Override
	public List<BorrowingTypeInfo> getAllByMemberAndLoanType(Map<String, Object> param) {
		
		return getSqlSession().selectList("borrowingCertificationDaoImpl.getAllByMemberAndLoanType",param);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	

	
}

