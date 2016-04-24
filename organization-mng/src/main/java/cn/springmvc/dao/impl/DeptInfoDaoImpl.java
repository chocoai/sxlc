package cn.springmvc.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.springmvc.dao.IDeptInfoDao;

/**
 * @author Administrator
 *
 */
@Repository
public class DeptInfoDaoImpl extends SqlSessionDaoSupport implements IDeptInfoDao{
	

	

	@Override
	public int saveDept(Map<String,Object> param) {
		getSqlSession().selectOne("DeptInfoDaoImpl.saveDept", param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}

	@Override
	public int editDept(Map<String,Object> param) {
		getSqlSession().selectOne("DeptInfoDaoImpl.editDept", param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}

	@Override
	public int delDept(Map<String,Object> param) {
		getSqlSession().selectOne("DeptInfoDaoImpl.delDept",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1); 
	}


	@Override
	public int ofDept(Map<String,Object> param) {

		getSqlSession().selectOne("DeptInfoDaoImpl.ofDept",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}
	
	
	
	
	
	
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	

	
}
