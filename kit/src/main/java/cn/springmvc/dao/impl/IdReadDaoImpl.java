package cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("idReadDaoImpl")
public class IdReadDaoImpl extends SqlSessionDaoSupport{
	
	/**
	 * 获取未使用id个数
	 * @return
	 */
	public int GetUnUsedIdCount(){
		int iResult = 0;
		
		iResult = getSqlSession().selectOne("IdWriteDao.getUnUsedCount");
		
		return iResult;
	}
	
	@Override
	@Resource(name="sqlSessionFactoryR")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
