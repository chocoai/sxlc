package  cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectTypeGuideListDao;
import cn.springmvc.model.ProjectTypeGuideEntity;

import product_p2p.kit.pageselect.PageEntity; 
@Repository("projectTypeGuideListDaoImpl")
public class ProjectTypeGuideListDaoImpl extends SqlSessionDaoSupport implements ProjectTypeGuideListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public ProjectTypeGuideEntity selectProjectTypeGuideIsExistByNAme(
			ProjectTypeGuideEntity entity) {
		ProjectTypeGuideEntity projectTypeGuideEntity=null;
		projectTypeGuideEntity=(ProjectTypeGuideEntity) getSqlSession().selectOne("projectTypeGuide.selectProjectTypeGuideIsExistByNAme",entity);
		return projectTypeGuideEntity;
	}

	@Override
	public List<ProjectTypeGuideEntity> selectProjectTypeGuideList(
			PageEntity pageEntity) {
		List<ProjectTypeGuideEntity> projectTypeGuideList=null;
		projectTypeGuideList=getSqlSession().selectList("projectTypeGuide.selectProjectTypeGuideList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return projectTypeGuideList;
	}
	@Override
	public ProjectTypeGuideEntity selectProjectTypeGuideByindex(int id) {
		ProjectTypeGuideEntity projectTypeGuideEntity=null;
		projectTypeGuideEntity=(ProjectTypeGuideEntity) getSqlSession().selectOne("projectTypeGuide.selectProjectTypeGuideEntityByindex",id);
		return projectTypeGuideEntity;
	}
	@Override
	public int selectProjectTypeGuideEntityindex() {
		
		Integer index = getSqlSession().selectOne("projectTypeGuide.selectProjectTypeGuideEntityindex");
		if(index == null) {
			index = 0;
		}
		return index;
	}

}
