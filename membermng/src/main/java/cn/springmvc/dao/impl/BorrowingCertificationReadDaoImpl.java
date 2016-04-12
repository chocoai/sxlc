
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.dbkey.DbKeyUtil;

import cn.springmvc.dao.IBorrowingCertificationReadDao;



@Repository
public class BorrowingCertificationReadDaoImpl extends SqlSessionDaoSupport implements IBorrowingCertificationReadDao {


	@Override
	public Map<String, Object> showAuthRealName(Map<String, Object> param) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthRealName",param);
	}
	
	
	
	
	
	
	
	
	@Override
	public Map<String, Object> showCurrencyAuth(Map<String,Object> param) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showCurrencyAuth",param);
	}
	
	
	
	
	
	
	

	@Override
	public Map<String, Object> showAuthAddress(Map<String, Object> param) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthAddress",param);
	}
	
	
	
	
	
	
	

	@Override
	public List<Map<String, Object>> showAuthHousing(Map<String, Object> param) {
		
		return getSqlSession().selectList("borrowingCertificationDaoImpl.showAuthHousing",param);
	}



	
	

	@Override
	public List<Map<String, Object>> showAuthProduction(long memberId) {
		return getSqlSession().selectList("borrowingCertificationDaoImpl.showAuthProduction", memberId);
	}
	
		
	
	
	
	
	
	@Override
	public Map<String, Object> showAuthMarriage(Long memberId) {
		
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthMarriage", memberId);
	}
	
	
	@Override
	public Map<String, Object> showAuthEducation(long memberId) {
		return getSqlSession().selectOne("borrowingCertificationDaoImpl.showAuthEducation", memberId);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	

	
}

