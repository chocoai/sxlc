package  cn.springmvc.dao.impl;
 
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
		
		return getSqlSession().selectOne("projectTypeGuide.selectProjectTypeGuideIsExistByNAme",entity); 
	}

	@Override
	public List<ProjectTypeGuideEntity> selectProjectTypeGuideList(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("projectTypeGuide.selectProjectTypeGuideList",
				pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize())); 
	}
	@Override
	public ProjectTypeGuideEntity selectProjectTypeGuideByindex(int ptIndex) {
		
		return getSqlSession().selectOne("projectTypeGuide.selectProjectTypeGuideEntityByindex",ptIndex); 
	}
	@Override
	public int selectProjectTypeGuideEntityindex() {
		
		Integer index = getSqlSession().selectOne("projectTypeGuide.selectProjectTypeGuideEntityindex");
		if(index == null) {
			index = 0;
		}
		return index;
	}
	@Override
	public  ProjectTypeGuideEntity  selectProjectTypeGuideListfront(
			long projectType) {
		
		return getSqlSession().selectOne("projectTypeGuide.selectProjectTypeGuideListfront",projectType);
		
	}

}
