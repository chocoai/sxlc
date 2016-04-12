package cn.springmvc.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.HandleCertificationAuditDao;



@Component("handleCertificationAuditDaoImpl")
public class HandleCertificationAuditDaoImpl extends SqlSessionDaoSupport implements HandleCertificationAuditDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Map<String, Object> handleEnterpriseCerAudit(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("EnterpriseCAXML.handleEnterpriseCerAudit", map);
	}

	@Override
	public Map<String, Object> handleEnterpriseBLAttest(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("EnterpriseCAXML.handleEnterpriseBLAttest", map);
	}

	@Override
	public Map<String, Object> handleAttest(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("EnterpriseCAXML.handleAttest", map);
	}

	@Override
	public Map<String, Object> handlequalification(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("EnterpriseCAXML.handlequalification", map);
	}

	@Override
	public Map<String, Object> handlenameAuthentication(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("EnterpriseCAXML.handlenameAuthentication", map);
	}

	@Override
	public Map<String, Object> handlemarriage(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("EnterpriseCAXML.handlemarriage", map);
	}

	@Override
	public Map<String, Object> handleAddress(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("EnterpriseCAXML.handleAddress", map);
	}


}
