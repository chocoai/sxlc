package  cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectTypeReplyDao; 
import cn.springmvc.model.ProjectTypeReplyEntity;
 
@Repository("projectTypeReplyDaoImpl")
public class ProjectTypeReplyDaoImpl extends SqlSessionDaoSupport  implements ProjectTypeReplyDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProjectTypeReply(ProjectTypeReplyEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		} 
		iResult = getSqlSession().insert("projectTypeReply.insertProjectTypeReply", entity);
		return iResult;
	}

	@Override
	public int updateProjectTypeReplyByID(ProjectTypeReplyEntity entity) {
		int result=0;
		result=getSqlSession().update("projectTypeReply.updateProjectTypeReplyByIndex", entity);
		return result;
	}

	@Override
	public int deleteProjectTypeReplyByID(int id) {
		int result=0;
		result=getSqlSession().delete("projectTypeReply.deleteProjectTypeReplyByIndex", id);
		return result;
	}
 

}
