package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.RecruitmentDao;
import cn.springmvc.model.RecruitmentEntity; 
@Repository("recruitmentDaoImpl")
public class RecruitmentDaoImpl  extends SqlSessionDaoSupport implements RecruitmentDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertRecruitment(RecruitmentEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("Mapper.insertRecruitment", entity);
		return iResult;
	} 
	
	@Override
	public int updateRecruitmentByID(RecruitmentEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updateRecruitmentByID", entity);
		return result;
	}

	@Override
	public int deleteRecruitmentByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("Mapper.deleteRecruitmentByID", id);
		return result;
	}
 
	@Override
	public int updateRecruitmentStatuByID(RecruitmentEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updateRecruitmentStatuByID", entity);
		return result;
	} 
}
