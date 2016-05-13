package  cn.springmvc.dao.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ActivitiesProjectListDao;
import cn.springmvc.model.ActivitiesProjectEntity;

import product_p2p.kit.pageselect.PageEntity; 
@Repository("activitiesProjectListDaoImpl")
public class ActivitiesProjectListDaoImpl extends SqlSessionDaoSupport implements ActivitiesProjectListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public ActivitiesProjectEntity selectActivitiesProjectIsExistByNAme(
			ActivitiesProjectEntity entity) {
		ActivitiesProjectEntity activitiesProjectEntity=null;
		activitiesProjectEntity = (ActivitiesProjectEntity) getSqlSession().
				selectOne("activitiesProject.selectActivitiesProjectIsExistByNAme",entity);
		return activitiesProjectEntity;
	}

	@Override
	public List<ActivitiesProjectEntity> selectActivitiesProjectAllpage(
			PageEntity pageEntity) {
		List<ActivitiesProjectEntity> activitiesProjectList=null;
		activitiesProjectList = getSqlSession().selectList("activitiesProject.selectActivitiesProjectList"
				,pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return activitiesProjectList;
	}
	@Override
	public int selectActivitiesProjectRoleIsExist(ActivitiesProjectEntity entity) {
		int result = getSqlSession().selectOne("activitiesProject.selectActivitiesProjectRoleIsExist"
				,entity);
		return result;
	}
	@Override
	public ActivitiesProjectEntity selectActivitiesProjectByID(long id) {
		ActivitiesProjectEntity activitiesProjectEntity=null;
		activitiesProjectEntity = (ActivitiesProjectEntity) getSqlSession()
				.selectOne("activitiesProject.selectActivitiesProjectByID",id);
		return activitiesProjectEntity;
	} 
}
