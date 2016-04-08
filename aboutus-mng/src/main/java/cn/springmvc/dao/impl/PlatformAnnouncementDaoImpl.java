package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.PlatformAnnouncementDao; 
import cn.springmvc.model.PlatformAnnouncementEntity;
@Repository("platformAnnouncementDaoImpl")
public class PlatformAnnouncementDaoImpl extends SqlSessionDaoSupport implements PlatformAnnouncementDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertPlatform(PlatformAnnouncementEntity entity) {
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("Mapper.insertPlatform", entity);
		return iResult;
	} 
	@Override
	public int updatePlatformByID(PlatformAnnouncementEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updatePlatformByID", entity);
		return result;
	}

	@Override
	public int deletePlatformByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("Mapper.deletePlatformByID", id);
		return result;
	}
	@Override
	public int updatePlatformStatuByID(PlatformAnnouncementEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("Mapper.updatePlatformStatuByID", entity);
		return result;
	} 
}
