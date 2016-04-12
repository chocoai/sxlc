package cn.springmvc.dao.impl; 
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.SafetyCertificationDao;
import cn.springmvc.model.SafetyCertificationEntity; 
@Repository("safetyCertificationDaoImpl")
public class SafetyCertificationDaoImpl extends SqlSessionDaoSupport implements SafetyCertificationDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertSafetyCertification(SafetyCertificationEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("safetyCertification.insertSafetyCertification", entity);
		return iResult;
	} 
	@Override
	public int updateSafetyCertificationByID(SafetyCertificationEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("safetyCertification.updateSafetyCertificationByID", entity);
		return result;
	}

	@Override
	public int deleteSafetyCertificationByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("safetyCertification.deleteSafetyCertificationByID", id);
		return result;
	} 
	@Override
	public int updateSafetyCertificationStatuByID(SafetyCertificationEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("safetyCertification.updateSafetyCertificationStatuByID", entity);
		return result;
	}
 
}
