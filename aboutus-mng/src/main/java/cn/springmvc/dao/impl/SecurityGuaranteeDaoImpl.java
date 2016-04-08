package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.SecurityGuaranteeDao;
import cn.springmvc.model.SecurityGuaranteeEntity; 
@Repository("securityGuaranteeDaoImpl")
public class SecurityGuaranteeDaoImpl extends SqlSessionDaoSupport implements SecurityGuaranteeDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertSecurityGuarantee(SecurityGuaranteeEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("securityGuarantee.insertSecurityGuarantee", entity);
		return iResult;
	} 
	@Override
	public int updateSecurityGuaranteeByID(SecurityGuaranteeEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("securityGuarantee.updateSecurityGuaranteeByID", entity);
		return result;
	}

	@Override
	public int deleteSecurityGuaranteeByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("securityGuarantee.deleteSecurityGuaranteeByID", id);
		return result;
	}

	@Override
	public int updateSecurityGuaranteeStatuByID(SecurityGuaranteeEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("securityGuarantee.updateSecurityGuaranteeStatuByID", entity);
		return result;
	}
 

}
