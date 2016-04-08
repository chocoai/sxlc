package  cn.springmvc.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ProjectBaseInfoDao;
import cn.springmvc.model.ProjectBaseInfoEntity;
 
@Repository("projectBaseInfoDaoImpl")
public class ProjectBaseInfoDaoImpl extends SqlSessionDaoSupport  implements ProjectBaseInfoDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertProjectBaseInfo(ProjectBaseInfoEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("projectBaseInfo.insertProjectBaseInfo", entity);
		return iResult;
	}

	@Override
	public int updateProjectBaseInfoByID(ProjectBaseInfoEntity entity) {
		int result=0;
		result=getSqlSession().update("projectBaseInfo.updateProjectBaseInfoByID", entity);
		return result;
	}

	@Override
	public int deleteProjectBaseInfoByID(int id) {
		int result=0;
		result=getSqlSession().delete("projectBaseInfo.deleteProjectBaseInfoByID", id);
		return result;
	}

	@Override
	public int updateProjectBaseInfoStatuByID(ProjectBaseInfoEntity entity) {
		int result=0;
		result=getSqlSession().update("projectBaseInfo.updateProjectBaseInfoStatuByID", entity);
		return result;
	}

}
