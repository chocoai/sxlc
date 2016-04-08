package cn.springmvc.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.springmvc.dao.IAdminWriteDao;

@Repository
public class AdminWriteDaoImpl extends SqlSessionDaoSupport implements IAdminWriteDao {

	@Override
	public int saveAdmin(Map<String, Object> param) {
		
		getSqlSession().selectOne("adminDaoImpl.saveAdmin", param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}


	@Override
	public int editAdmin(Map<String, Object> param) {
		
		getSqlSession().selectOne("adminDaoImpl.editAdmin", param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}

	@Override
	public int ofAdmin(Map<String, Object> param) {
		
		getSqlSession().selectOne("adminDaoImpl.ofAdmin",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}

	
	@Override
	public int editAdminPassword(Map<String, Object> param) {
		
		getSqlSession().selectOne("adminDaoImpl.editAdminPassword",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), -1);
	}
	
	
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
