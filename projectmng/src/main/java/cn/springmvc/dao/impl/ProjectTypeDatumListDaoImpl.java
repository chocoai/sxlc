package  cn.springmvc.dao.impl;
 
import java.util.List;

import javax.annotation.Resource;
 
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectTypeDatumListDao; 
import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectTypeDatumEntity; 
@Repository("projectTypeDatumListDaoImpl")
public class ProjectTypeDatumListDaoImpl extends SqlSessionDaoSupport implements ProjectTypeDatumListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
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

}
