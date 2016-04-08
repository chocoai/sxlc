package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.MediaReportsListDao;
import cn.springmvc.model.MediaReportsEntity;
@Repository("mediaReportsListDaoImpl")
public class MediaReportsListDaoImpl extends SqlSessionDaoSupport implements MediaReportsListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public MediaReportsEntity selectMediaReportsIsExistByNAme(
			MediaReportsEntity entity) {
		
		MediaReportsEntity mediaReportsEntity = null;
		mediaReportsEntity = (MediaReportsEntity) getSqlSession().selectOne("mediaReports.selectMediaReportsIsExistByNAme",entity);
		return mediaReportsEntity;
	} 
	@Override
	public List<MediaReportsEntity> selectMediaReportsAllpage(PageEntity pageEntity) {
		
		List<MediaReportsEntity> mediaReportsList = null;
		mediaReportsList = getSqlSession().selectList("mediaReports.selectMediaReportsListpage",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return mediaReportsList;
	}
	
    @Override
	public MediaReportsEntity selectMediaReportsByID(int id) {
		
	    MediaReportsEntity mediaReportsEntity = null;
		mediaReportsEntity = (MediaReportsEntity) getSqlSession().selectOne("mediaReports.selectMediaReportsByID",id);
		return mediaReportsEntity;
	 
	}

}
