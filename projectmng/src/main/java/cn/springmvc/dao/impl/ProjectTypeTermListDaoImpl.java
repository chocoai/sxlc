package  cn.springmvc.dao.impl;
 

import javax.annotation.Resource;
 
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectTypeTermListDao;
import cn.springmvc.model.ProjectTypeTermEntity; 
@Repository("projectTypeTermListDaoImpl")
public class ProjectTypeTermListDaoImpl extends SqlSessionDaoSupport implements ProjectTypeTermListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
   
	@Override
	public ProjectTypeTermEntity selectProjectTypeTermById(
			ProjectTypeTermEntity entity) {
		
		ProjectTypeTermEntity projectTypeTermEntity=null;
		projectTypeTermEntity=(ProjectTypeTermEntity) getSqlSession().selectOne("projectTypeTerm.selectProjectTypeTermentity",entity);
		return projectTypeTermEntity;
	} 
}
