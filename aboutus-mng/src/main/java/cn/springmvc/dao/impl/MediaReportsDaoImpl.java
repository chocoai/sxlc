package cn.springmvc.dao.impl;
  
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.MediaReportsDao;
import cn.springmvc.model.MediaReportsEntity; 
@Repository("mediaReportsDaoImpl")
public class MediaReportsDaoImpl extends SqlSessionDaoSupport implements MediaReportsDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int insertMediaReports(MediaReportsEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("mediaReports.insertMediaReports", entity);
		return iResult;
	}
	@Override
	public int updateMediaReportsByID(MediaReportsEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("mediaReports.updateMediaReportsByID", entity);
		return result;
	}

	@Override
	public int deleteMediaReportsByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("mediaReports.deleteMediaReportsByID", id);
		return result;
	}
 
	@Override
	public int updateMediaReportsStatuByID(MediaReportsEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("mediaReports.updateMediaReportsStatuByID", entity);
		return result;
	}
	
}
