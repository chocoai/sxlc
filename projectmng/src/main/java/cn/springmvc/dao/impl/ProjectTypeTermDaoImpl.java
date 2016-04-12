package  cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectTypeTermDao;
import cn.springmvc.model.ProjectTypeTermEntity;
 
@Repository("projectTypeTermDaoImpl")
public class ProjectTypeTermDaoImpl extends SqlSessionDaoSupport  implements ProjectTypeTermDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProjectTypeTerm(ProjectTypeTermEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("projectTypeTerm.insertProjectTypeTerm", entity);
		return iResult;
	}

	@Override
	public int updateProjectTypeTermByID(ProjectTypeTermEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		} 
		iResult=getSqlSession().update("projectTypeTerm.updateProjectTypeTermByID", entity);
		return iResult;
	}
 
}
