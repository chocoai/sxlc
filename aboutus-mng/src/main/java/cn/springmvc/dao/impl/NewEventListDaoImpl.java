package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.NewEventListDao;
import cn.springmvc.model.NewEventEntity;

@Repository("newEventListDaoImpl")
public class NewEventListDaoImpl extends SqlSessionDaoSupport implements NewEventListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public NewEventEntity selectNewEventIsExistByNAme(NewEventEntity entity) {
		
		NewEventEntity platformAnnouncementEntity = null;
		platformAnnouncementEntity = (NewEventEntity) getSqlSession().selectOne("newEvent.selectNewEventIsExistByNAme",entity);
		return platformAnnouncementEntity;
	} 

	@Override
	public List<NewEventEntity> selectNewEventList(PageEntity pageEntity) {
		
		List<NewEventEntity> newEventList = null;
		newEventList = getSqlSession().selectList("newEvent.selectNewEventListpage",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return newEventList;
	}
    @Override
	public NewEventEntity selectNewEventByID(int id) {
    	
    	NewEventEntity platformAnnouncementEntity = null;
    	platformAnnouncementEntity = (NewEventEntity) getSqlSession().selectOne("newEvent.selectNewEventByID",id);
		return platformAnnouncementEntity;
	 
	}
}
