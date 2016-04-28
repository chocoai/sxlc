package  cn.springmvc.dao.impl;
 
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
		
		return getSqlSession().selectOne("projectTypeReply.selectProjectTypeReplyIsExistByNAme",entity); 
	}

	@Override
	public List<ProjectTypeReplyEntity> selectProjectTypeReplyList(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("projectTypeReply.selectProjectTypeReplyList",
				pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize())); 
	}
	@Override
	public ProjectTypeReplyEntity selectProjectTypeReplyByindex(int ptIndex) {
		
		return getSqlSession().selectOne("projectTypeReply.selectProjectTypeReplyByindex",ptIndex); 
	}
	@Override
	public int selectProjectTypeReplyEntityindex() {
		
		Integer index =  getSqlSession().selectOne("projectTypeReply.selectProjectTypeReplyEntityindex");
		if(index == null) {
			index = (int)0;
		}
		return index;
	}
	@Override
	public  ProjectTypeReplyEntity  selectProjectTypeReplyListfront(
			long projectType) {
		
		return getSqlSession().selectOne("projectTypeReply.selectProjectTypeReplyListfront",projectType);
		
	}

}
