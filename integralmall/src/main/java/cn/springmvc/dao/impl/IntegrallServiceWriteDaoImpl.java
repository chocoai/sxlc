package cn.springmvc.dao.impl; 

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.IIntegrallServiceWriteDao;

@Repository
public class IntegrallServiceWriteDaoImpl extends SqlSessionDaoSupport implements IIntegrallServiceWriteDao{

	
	
	public int saveShippingAddress(Map<String,Object> param) {
		
		getSqlSession().selectOne("IntegrallServiceReadDaoImpl.saveShippingAddress",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),0);
	}
	
	
	
	public int pointxchange(Map<String, Object> param) {
		
		getSqlSession().selectOne("IntegrallServiceReadDaoImpl.pointxchange", param);
		return IntegerAndString.StringToInt(param.get("result").toString(),0);
	}
	
	
	
	public int editShippingAddress(Map<String, Object> param) {
		
		getSqlSession().selectOne("IntegrallServiceReadDaoImpl.editShippingAddress",param);
		return IntegerAndString.StringToInt(param.get("result").toString(),0);
	}
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}

