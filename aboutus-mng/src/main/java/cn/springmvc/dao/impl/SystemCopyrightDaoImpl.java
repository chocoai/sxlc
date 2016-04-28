package cn.springmvc.dao.impl;
 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.springmvc.dao.SystemCopyrightDao; 
@Repository("systemCopyrightDaoImpl")
public class SystemCopyrightDaoImpl extends SqlSessionDaoSupport implements SystemCopyrightDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
 
	@Override
	public int insertSystemCopyright(String content) {
		
		return getSqlSession().insert("SystemCopyright.insertSystemCopyright",content);
		
	}
	@Override
	public int updateSystemCopyright(String content) {
		
		return getSqlSession().insert("SystemCopyright.updateSystemCopyright",content);
		
	}
 

}
