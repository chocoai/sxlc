package cn.springmvc.dao.impl;
 
import java.util.List;

import javax.annotation.Resource;
 
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectPurposeSetListDao; 
import cn.springmvc.model.ProjectPurposeSetEntity;
@Repository("projectPurposeSetListDaoImpl")
public class ProjectPurposeSetListDaoImpl extends SqlSessionDaoSupport implements ProjectPurposeSetListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<ProjectPurposeSetEntity> selectProjectPurposeSetAllpage() {
		
		return getSqlSession().selectList("projectPurposeSet.selectProjectPurposeSetList"); 
	}
	@Override
	public List<ProjectPurposeSetEntity> selectProjectPurposeSetValid() {
		
		return getSqlSession().selectList("projectPurposeSet.selectProjectPurposeSetValid"); 
		
	}

}
