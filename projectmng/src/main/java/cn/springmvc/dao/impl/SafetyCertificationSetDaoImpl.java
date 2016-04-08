package  cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.SafetyCertificationSetDao;
import cn.springmvc.model.SafetyCertificationSetEntity;
 
@Repository("safetyCertificationSetDaoImpl")
public class SafetyCertificationSetDaoImpl extends SqlSessionDaoSupport  implements SafetyCertificationSetDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertSafetyCertificationSet(SafetyCertificationSetEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("safetyCertificationSet.insertSafetyCertificationSet", entity);
		return iResult;
	}

	@Override
	public int updateSafetyCertificationSetByID(SafetyCertificationSetEntity entity) {
		int result=0;
		result=getSqlSession().update("safetyCertificationSet.updateSafetyCertificationSetByID", entity);
		return result;
	}

	@Override
	public int deleteSafetyCertificationSetByID(int id) {
		int result=0;
		result=getSqlSession().delete("safetyCertificationSet.deleteSafetyCertificationSetByID", id);
		return result;
	}

	@Override
	public int updateSafetyCertificationSetStatuByID(SafetyCertificationSetEntity entity) {
		int result=0;
		result=getSqlSession().update("safetyCertificationSet.updateSafetyCertificationSetStatuByID", entity);
		return result;
	}

}
