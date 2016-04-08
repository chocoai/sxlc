package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.NewEventDao;
import cn.springmvc.model.NewEventEntity; 
@Repository("newEventDaoImpl")
public class NewEventDaoImpl extends SqlSessionDaoSupport implements NewEventDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertNewEvent(NewEventEntity entity) {
		
		int iResult = 0;
		if(entity == null){
			return iResult;
		}
		iResult = getSqlSession().insert("newEvent.insertNewEvent", entity);
		return iResult;
	}
 
	@Override
	public int updateNewEventByID(NewEventEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("newEvent.updateNewEventByID", entity);
		return result;
	}

	@Override
	public int deleteNewEventByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("newEvent.deleteNewEventByID", id);
		return result;
	}

	 
	@Override
	public int updateNewEventStatuByID(NewEventEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("newEvent.updateNewEventStatuByID", entity);
		return result;
	}
 
}
