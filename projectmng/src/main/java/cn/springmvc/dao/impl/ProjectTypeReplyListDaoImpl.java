package  cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectTypeReplyListDao;
import cn.springmvc.model.ProjectTypeReplyEntity;

import product_p2p.kit.pageselect.PageEntity; 
@Repository("projectTypeReplyListDaoImpl")
public class ProjectTypeReplyListDaoImpl extends SqlSessionDaoSupport implements ProjectTypeReplyListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public ProjectTypeReplyEntity selectProjectTypeReplyIsExistByNAme(
			ProjectTypeReplyEntity entity) {
		ProjectTypeReplyEntity projectTypeReplyEntity=null;
		projectTypeReplyEntity=(ProjectTypeReplyEntity) getSqlSession().selectOne("projectTypeReply.selectProjectTypeReplyIsExistByNAme",entity);
		return projectTypeReplyEntity;
	}

	@Override
	public List<ProjectTypeReplyEntity> selectProjectTypeReplyList(
			PageEntity pageEntity) {
		List<ProjectTypeReplyEntity> projectTypeReplyList=null;
		projectTypeReplyList=getSqlSession().selectList("projectTypeReply.selectProjectTypeReplyList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return projectTypeReplyList;
	}
	@Override
	public ProjectTypeReplyEntity selectProjectTypeReplyByindex(int id) {
		ProjectTypeReplyEntity projectTypeReplyEntity=null;
		projectTypeReplyEntity=(ProjectTypeReplyEntity) getSqlSession().selectOne("projectTypeReply.selectProjectTypeReplyByindex",id);
		return projectTypeReplyEntity;
	}
	@Override
	public int selectProjectTypeReplyEntityindex() {
		
		Integer index =  getSqlSession().selectOne("projectTypeReply.selectProjectTypeReplyEntityindex");
		if(index == null) {
			index = (int)0;
		}
		return index;
	}

}
