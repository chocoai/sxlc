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
		return getSqlSession().insert("safetyCertificationSet.insertSafetyCertificationSet", entity); 
	}

	@Override
	public int updateSafetyCertificationSetByID(SafetyCertificationSetEntity entity) {
		
		return getSqlSession().update("safetyCertificationSet.updateSafetyCertificationSetByID", entity);
		 
	}

	@Override
	public int deleteSafetyCertificationSetByID(long id) {
		
		return getSqlSession().delete("safetyCertificationSet.deleteSafetyCertificationSetByID", id);
	 
	}

	@Override
	public int updateSafetyCertificationSetStatuByID(SafetyCertificationSetEntity entity) {
		
		return getSqlSession().update("safetyCertificationSet.updateSafetyCertificationSetStatuByID", entity);
		 
	}

}
