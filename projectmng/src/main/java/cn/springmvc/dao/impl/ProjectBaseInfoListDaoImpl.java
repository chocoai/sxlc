package  cn.springmvc.dao.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectBaseInfoListDao;
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectTypeDatumEntity;
import cn.springmvc.model.ProjectTypeTermEntity;

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
		
		return getSqlSession().selectOne("projectBaseInfo.selectProjectBaseInfoIsExistByNAme",entity); 
	}

	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoAllpage(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("projectBaseInfo.selectProjectBaseInfoList",
				pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize())); 
	}
	@Override
	public ProjectBaseInfoEntity selectProjectBaseInfoentitybyID(long id) {
		
		return getSqlSession().selectOne("projectBaseInfo.selectProjectBaseInfoentitybyID",id); 
	}
	
	 	
	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoList() {
		
		return getSqlSession().selectList("projectBaseInfo.selectProjectBaseInfo");
		
	}
	@Override
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoCombox() {
		
		return getSqlSession().selectList("projectBaseInfo.selectProjectBaseInfoCombox");
		
	}
	@Override
	public List<ProjectTypeDatumEntity> selectProjectTypeDatumAllpage(
			ProjectTypeDatumEntity projectTypeDatumEntity) {
		
		return getSqlSession().selectList("projectTypeDatum.selectProjectTypeDatumList",projectTypeDatumEntity); 
	}
	@Override
	public List<MemberAttestTypeEntity> selectMemberAttestByprojectType(
			long projectType) {
		
		return getSqlSession().selectList("projectTypeDatum.selectMemberAttestByprojectType",projectType); 
		
	}
	@Override
	public ProjectTypeTermEntity selectProjectTypeTermById(
			ProjectTypeTermEntity entity) {
		
		return getSqlSession().selectOne("projectTypeTerm.selectProjectTypeTermentity",entity);
		 
	}
	@Override
	public List<ProjectTypeTermEntity> selectProjectTypeTermByID(long projectID) {
		
		return getSqlSession().selectList("projectTypeTerm.selectProjectTypeTermByID",projectID);
		
	} 
}
