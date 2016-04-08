package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.PlatformIntroduceDao;
import cn.springmvc.model.PlatformIntroduceEntity; 
@Repository("platformIntroduceDaoImpl")
public class PlatformIntroduceDaoImpl extends SqlSessionDaoSupport implements PlatformIntroduceDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertPlatformIntroduce(PlatformIntroduceEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("platformIntroduce.insertPlatformIntroduce", entity);
		return iResult;
	} 
	@Override
	public int updatePlatformIntroduce(PlatformIntroduceEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("platformIntroduce.updatePlatformByID", entity);
		return result;
	}

	@Override
	public int deletePlatformIntroduce(int id) {
		
		int result = 0;
		result = getSqlSession().delete("platformIntroduce.deleteplatformIntroduce", id);
		return result;
	}
 
}
