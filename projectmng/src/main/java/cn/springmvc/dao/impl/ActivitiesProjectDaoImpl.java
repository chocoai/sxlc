package  cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ActivitiesProjectDao;
import cn.springmvc.model.ActivitiesProjectEntity;
 
@Repository("activitiesProjectDaoImpl")
public class ActivitiesProjectDaoImpl extends SqlSessionDaoSupport  implements ActivitiesProjectDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertActivitiesProject(ActivitiesProjectEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("activitiesProject.insertActivitiesProject", entity);
		return iResult;
	}

	@Override
	public int updateActivitiesProjectByID(ActivitiesProjectEntity entity) {
		int result=0;
		result=getSqlSession().update("activitiesProject.updateActivitiesProjectByID", entity);
		return result;
	}

	@Override
	public int deleteActivitiesProjectByID(int id) {
		int result=0;
		result=getSqlSession().delete("activitiesProject.deleteActivitiesProjectByID", id);
		return result;
	}

	@Override
	public int updateActivitiesProjectStatuByID(ActivitiesProjectEntity entity) {
		int result=0;
		result=getSqlSession().update("activitiesProject.updateActivitiesProjectStatuByID", entity);
		return result;
	}

}
