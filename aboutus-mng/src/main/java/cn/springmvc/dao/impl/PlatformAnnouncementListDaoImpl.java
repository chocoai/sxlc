package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository; 

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.dao.PlatformAnnouncementListDao;
import cn.springmvc.model.PlatformAnnouncementEntity;

@Repository("platformAnnouncementListDaoImpl")
public class PlatformAnnouncementListDaoImpl extends SqlSessionDaoSupport implements PlatformAnnouncementListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public PlatformAnnouncementEntity selectPlatformIsExistByNAme(
			PlatformAnnouncementEntity entity) {
		
		PlatformAnnouncementEntity platformAnnouncementEntity=null;
		platformAnnouncementEntity = (PlatformAnnouncementEntity) getSqlSession().selectOne("Mapper.selectPlatformIsExistByNAme",entity);
		return platformAnnouncementEntity;
	}
	@Override
	public List<PlatformAnnouncementEntity> selectPlatformList(PageEntity pageEntity) {
		
		List<PlatformAnnouncementEntity> platformAnnouncementList=null;
		platformAnnouncementList = getSqlSession().selectList("Mapper.selectPlatformListpage",pageEntity.getMap(),new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return platformAnnouncementList;
	
	}
 
	@Override
	public PlatformAnnouncementEntity selectPlatformByID(int id) {
		
		PlatformAnnouncementEntity platformAnnouncementEntity=null;
		platformAnnouncementEntity = (PlatformAnnouncementEntity) getSqlSession().selectOne("Mapper.selectPlatformByID",id);
	    return platformAnnouncementEntity;
	    
	} 
}
