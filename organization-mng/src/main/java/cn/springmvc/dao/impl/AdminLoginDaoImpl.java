package cn.springmvc.dao.impl;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.springmvc.dao.IAdminLoginDao;
import cn.springmvc.model.Admin;



@Repository("AdminLoginDaoImpl")
public class AdminLoginDaoImpl extends SqlSessionDaoSupport implements IAdminLoginDao {

	@Override
	public int Login(Map<String, Object> param) {
		//param.put("result", 1);
		getSqlSession().selectOne("adminLoginDaoImpl.loginAdmin",param);
		
		return IntegerAndString.StringToInt(param.get("result").toString(),1);
	}
	@Override
	public Admin adminMess(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("adminLoginDaoImpl.adminMessage",param);
	}

	
	
	@Override
	public int updatePwd(String adminName, String oldPwd, String newPwd) {
		return 0;
	}

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}


	
}
