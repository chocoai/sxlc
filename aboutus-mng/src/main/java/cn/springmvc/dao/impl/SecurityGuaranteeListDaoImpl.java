package cn.springmvc.dao.impl;
 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.SecurityGuaranteeListDao; 
import cn.springmvc.model.SecurityGuaranteeEntity;
@Repository("securityGuaranteeListDaoImpl")
public class SecurityGuaranteeListDaoImpl  extends SqlSessionDaoSupport  implements SecurityGuaranteeListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public SecurityGuaranteeEntity selectSecurityGuarantee(int statu) {
		
		SecurityGuaranteeEntity platroductIntroduceentity = new  SecurityGuaranteeEntity();
		platroductIntroduceentity = getSqlSession().selectOne("securityGuarantee.selectSecurityGuarantee",statu);
		return platroductIntroduceentity;
	}
	@Override
	public int selectSecurityGuaranteeIsExist() {
		
		int result = 0;
		result = getSqlSession().selectOne("securityGuarantee.selectSecurityGuaranteeIsExist");
		return result;
	}
}
