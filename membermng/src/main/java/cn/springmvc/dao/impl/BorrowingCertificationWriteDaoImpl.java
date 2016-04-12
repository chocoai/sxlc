
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.springmvc.dao.IBorrowingCertificationWriteDao;



@Repository
public class BorrowingCertificationWriteDaoImpl extends SqlSessionDaoSupport implements IBorrowingCertificationWriteDao {

	@Override
	public int autnRealName(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.authRealName",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	@Override
	public int editAuthRealName(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editAuthRealName",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	
	
	@Override
	public int currencyAuth(Map<String, Object> param) {
	
		getSqlSession().selectOne("borrowingCertificationDaoImpl.currencyAuth", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	@Override
	public int editCurrencyAuth(Map<String, Object> param) {
		
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editCurrencyAuth", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	
	
	
	@Override
	public int authAddress(Map<String, Object> param) {
		
		getSqlSession().selectOne("borrowingCertificationDaoImpl.authAddress",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}

	
	@Override
	public int editAuthAddress(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editAuthAddress", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	
	
	
	@Override
	public int authHousing(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.authHousing", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}


	@Override
	public int editAuthHousing(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editAuthHousing",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}


	
	
	
	@Override
	public int authProduction(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.authProduction", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}

	
	@Override
	public int editAuthProduction(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editAuthProduction",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
		
	
	
	
	
	
	@Override
	public int authMarriage(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.authMarriage", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	@Override
	public int editAuthMarriage(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editAuthMarriage",param);
		
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	
	@Override
	public int authEducation(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.authEducation", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	@Override
	public int editAuthEducation(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editAuthEducation", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
/******************************************************************************************************************************************************************************************************************
* 
* 						a ha ha 我是华丽丽的分界线、下面的都是企业会员的了
* 
* 
*******************************************************************************************************************************************************************************************************************/

	
	
	@Override
	public int businessLicense(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.businessLicense", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	@Override
	public int editBusinessLicense(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editBusinessLicense", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	
	
	@Override
	public int commercialLicense(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.commercialLicense", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	@Override
	public int editCommercialLicense(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editCommercialLicense", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	
	@Override
	public int organizational(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.organizational",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	@Override
	public int editOrganizational(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editOrganizational",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	@Override
	public int accountOpening(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.accountOpening", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	@Override
	public int editAccountOpening(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editAccountOpening", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	@Override
	public int taxRegistration(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.taxRegistration", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	@Override
	public int editTaxRegistration(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editTaxRegistration", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	@Override
	public int authApproval(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.authApproval", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	@Override
	public int editAuthApproval(Map<String, Object> param) {
		getSqlSession().selectOne("borrowingCertificationDaoImpl.editAuthApproval", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),-1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	

	
}

