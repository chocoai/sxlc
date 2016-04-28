package cn.springmvc.dao.impl;
 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
 
import cn.springmvc.dao.SystemCopyrightListDao; 
@Repository("systemCopyrightListDaoImpl")
public class SystemCopyrightListDaoImpl  extends SqlSessionDaoSupport  implements SystemCopyrightListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int selectSystemCopyrightIsExist() {
		
		return getSqlSession().selectOne("SystemCopyright.selectSystemCopyrightIsExist");
		
	}

	@Override
	public String selectSystemCopyright() {
		
		return getSqlSession().selectOne("SystemCopyright.selectSystemCopyright");
		
	}
	 
}
