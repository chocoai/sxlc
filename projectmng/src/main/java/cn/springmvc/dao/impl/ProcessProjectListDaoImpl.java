package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.ProcessProjectDao;
import cn.springmvc.dao.ProcessProjectListDao;
import cn.springmvc.model.ProcessProjectEntity;
@Repository("processProjectListDaoImpl")
public class ProcessProjectListDaoImpl extends SqlSessionDaoSupport implements ProcessProjectListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<ProcessProjectEntity> selectProcessProjectAllpage(
			PageEntity pageEntity) {
		List<ProcessProjectEntity> processProjectList=null;
		processProjectList=getSqlSession().selectList("processProject.selectProcessProjectListpage",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return processProjectList;
	}
	@Override
	public ProcessProjectEntity selectProcessProjectbyid(int id) {
		 ProcessProjectEntity  processProject=null;
		 processProject=getSqlSession().selectOne("processProject.selectProcessProjectbyid",id);
		 return processProject;
	}
	@Override
	public int selectActivitiesProjectStatu(int apID) {
		int result = 0;
		result = getSqlSession().selectOne("processProject.selectActivitiesProjectStatu",apID);
		return result;
	}
	@Override
	public int selectProcessProjectindex() { 
		 Integer index = getSqlSession().selectOne("processProject.selectProcessProjectindex");
		 if (index == null) {
			 index = 0;
		 }
		 return index;
		
	}

}
