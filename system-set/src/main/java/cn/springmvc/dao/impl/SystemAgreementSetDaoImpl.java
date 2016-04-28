package  cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.SystemAgreementSetDao;
import cn.springmvc.model.SystemAgreementSetEntity;
 
@Repository("systemAgreementSetDaoImpl")
public class SystemAgreementSetDaoImpl extends SqlSessionDaoSupport  implements SystemAgreementSetDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertSystemAgreementSet(SystemAgreementSetEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("systemAgreementSet.insertSystemAgreementSet", entity);
		return iResult;
	}

	@Override
	public int updateSystemAgreementSetByType(SystemAgreementSetEntity entity) {
		int result=0;
		result=getSqlSession().update("systemAgreementSet.updateSystemAgreementSetByType", entity);
		return result;
	}

	@Override
	public int deleteSystemAgreementSetByType(int agreementType) {
		
		int result=0;
		result=getSqlSession().delete("systemAgreementSet.deleteSystemAgreementSetByType", agreementType);
		return result;
	}

	@Override
	public int updateSystemAgreementSetStatuByType(SystemAgreementSetEntity entity) {
		
		int result=0;
		result=getSqlSession().update("systemAgreementSet.updateSystemAgreementSetStatuByType", entity);
		return result;
	}

}
