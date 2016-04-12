package  cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectBaseInfoListDao;
import cn.springmvc.model.ProjectBaseInfoEntity;

import product_p2p.kit.pageselect.PageEntity; 
@Repository("projectBaseInfoListDaoImpl")
public class ProjectBaseInfoListDaoImpl extends SqlSessionDaoSupport implements ProjectBaseInfoListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public ProjectBaseInfoEntity selectProjectBaseInfoIsExistByNAme(
			ProjectBaseInfoEntity entity) {
		ProjectBaseInfoEntity projectBaseInfoEntity=null;
		projectBaseInfoEntity=(ProjectBaseInfoEntity) getSqlSession().selectOne("projectBaseInfo.selectProjectBaseInfoIsExistByNAme",entity);
		return projectBaseInfoEntity;
	}

	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoAllpage(
			PageEntity pageEntity) {
		List<ProjectBaseInfoEntity> projectBaseInfoList=null;
		projectBaseInfoList=getSqlSession().selectList("projectBaseInfo.selectProjectBaseInfoList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return projectBaseInfoList;
	}
	@Override
	public ProjectBaseInfoEntity selectProjectBaseInfoIsExistById(int id) {
		ProjectBaseInfoEntity projectBaseInfoEntity=null;
		projectBaseInfoEntity=(ProjectBaseInfoEntity) getSqlSession().selectOne("projectBaseInfo.selectProjectBaseInfoentity",id);
		return projectBaseInfoEntity;
	}
	
	 	
	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoList() {
		
		return getSqlSession().selectOne("projectBaseInfo.selectProjectBaseInfo");
		
	}

}
