package cn.springmvc.dao.impl;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.MngTeamDao;
import cn.springmvc.model.MngTeamEntity; 
@Repository("mngTeamDaoImpl")
public class MngTeamDaoImpl extends SqlSessionDaoSupport implements MngTeamDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertMngTeam(MngTeamEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("mngTeam.insertMngTeam", entity);
		return iResult;
	}
 
	@Override
	public int updateMngTeamByID(MngTeamEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("mngTeam.updateMngTeamByID", entity);
		return result;
	}

	@Override
	public int deleteMngTeamByID(int id) {
		
		int result = 0;
		result=getSqlSession().delete("mngTeam.deleteMngTeamByID", id);
		return result;
	}
 
	@Override
	public int updateMngTeamStatuByID(MngTeamEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("mngTeam.updateMngTeamStatuByID", entity);
		return result;
	}

	
}
