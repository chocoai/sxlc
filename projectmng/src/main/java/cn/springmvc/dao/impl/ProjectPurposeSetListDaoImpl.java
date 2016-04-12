package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectPurposeSetListDao;
import cn.springmvc.model.ProcessProjectEntity;
import cn.springmvc.model.ProjectPurposeSetEntity;
@Repository("projectPurposeSetListDaoImpl")
public class ProjectPurposeSetListDaoImpl extends SqlSessionDaoSupport implements ProjectPurposeSetListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<ProjectPurposeSetEntity> selectProjectPurposeSetAllpage() {
		List<ProjectPurposeSetEntity> projectPurposeSetList=null;
		projectPurposeSetList=getSqlSession().selectList("projectPurposeSet.selectProjectPurposeSetList");
		return projectPurposeSetList;
	}

}
