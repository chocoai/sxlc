package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.NewHandDao;
import cn.springmvc.model.NewHandEntity; 
@Repository("newHandDaoImpl")
public class NewHandDaoImpl extends SqlSessionDaoSupport implements NewHandDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertNewHand(NewHandEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("newHand.insertNewHand", entity);
		return iResult;
	} 
	@Override
	public int updateNewHand(NewHandEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("newHand.updateNewHand", entity);
		return result;
	}

	@Override
	public int deleteNewHand() {
		
		int result = 0;
		result = getSqlSession().delete("newHand.deleteNewHand");
		return result;
	}
 
}
