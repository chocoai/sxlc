package cn.springmvc.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.IFinancialAdvisorWriteDao;

@Repository
public class FinancialAdvisorWriteDaoImpl extends SqlSessionDaoSupport implements IFinancialAdvisorWriteDao {

	
	

	@Override
	public int saveFinancialAdvisor(Map<String,Object> param) {
		
		getSqlSession().selectOne("financialAdvisorDaoImpl.bind", param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}
	
	

	@Override
	public int removeFinancialAdvisor(Map<String,Object> param) {
		
		getSqlSession().selectOne("financialAdvisorDaoImpl.removeFinancialAdvisor", param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}
	
	
	
	
	
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}
