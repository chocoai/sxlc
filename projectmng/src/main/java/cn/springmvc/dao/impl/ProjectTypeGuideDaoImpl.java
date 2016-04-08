package  cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectTypeGuideDao; 
import cn.springmvc.model.ProjectTypeGuideEntity;
 
@Repository("projectTypeGuideDaoImpl")
public class ProjectTypeGuideDaoImpl extends SqlSessionDaoSupport  implements ProjectTypeGuideDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProjectTypeGuide(ProjectTypeGuideEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		} 
		iResult = getSqlSession().insert("projectTypeGuide.insertProjectTypeGuide", entity);
		return iResult;
	}

	@Override
	public int updateProjectTypeGuideByID(ProjectTypeGuideEntity entity) {
		int result=0;
		result=getSqlSession().update("projectTypeGuide.updateProjectTypeGuideByIndex", entity);
		return result;
	}

	@Override
	public int deleteProjectTypeGuideByID(int id) {
		int result=0;
		result=getSqlSession().delete("projectTypeGuide.deleteProjectTypeGuideByIndex", id);
		return result;
	}
 

}
