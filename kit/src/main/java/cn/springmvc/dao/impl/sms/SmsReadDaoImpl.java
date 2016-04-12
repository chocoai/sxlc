package cn.springmvc.dao.impl.sms;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("smsReadDaoImpl")
public class SmsReadDaoImpl extends SqlSessionDaoSupport{
	
	public SmsSetInfoEntity GetSmsInfo(){
		return getSqlSession().selectOne("SmsDao.getSmsSetInfo");
	}
	
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
