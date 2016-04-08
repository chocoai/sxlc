package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.ExpertTeamDao;
import cn.springmvc.model.ExpertTeamEntity; 
/**
 * 
 * @author 刘利 
 * @Description: 专家顾问
 * @since 
 * @date 2016-3-26 下午12:15:25
 */
@Repository("expertTeamDaoImpl")
public class ExpertTeamDaoImpl extends SqlSessionDaoSupport  implements ExpertTeamDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertExpertTeam(ExpertTeamEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("expertTeam.insertExpertTeam", entity);
		return iResult;
	}


	@Override
	public int updateExpertTeamByID(ExpertTeamEntity entity) {
		
		int result=0;
		result = getSqlSession().update("expertTeam.updateExpertTeamByID", entity);
		return result;
	}

	@Override
	public int deleteExpertTeamByID(int id) {
		
		int result=0;
		result = getSqlSession().delete("expertTeam.deleteExpertTeamByID", id);
		return result;
	}
 
	@Override
	public int updateExpertTeamStatuByID(ExpertTeamEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("expertTeam.updateExpertTeamStatuByID", entity);
		return result;
	}
}
