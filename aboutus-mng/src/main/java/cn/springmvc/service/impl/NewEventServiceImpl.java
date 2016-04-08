package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
 
import cn.springmvc.dao.NewEventDao;
import cn.springmvc.dao.NewEventListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.NewEventDaoImpl;
import cn.springmvc.dao.impl.NewEventListDaoImpl; 
import cn.springmvc.model.NewEventEntity; 
import cn.springmvc.service.NewEventService;
@Service("newEventServiceImpl")
public class NewEventServiceImpl implements NewEventService {
	@Resource(name="newEventDaoImpl")
	private NewEventDao newEventDaoImpl;  
	@Resource(name="newEventListDaoImpl")
	private NewEventListDao newEventListDaoImpl;  
	@Override
	public int insertNewEvent(NewEventEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的最新动态是否存在,如果已存在则不插入  
		NewEventEntity mngTeamEntity = newEventListDaoImpl.selectNewEventIsExistByNAme(entity);
		if(mngTeamEntity != null){
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = newEventDaoImpl.insertNewEvent(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return result;  
	}

	@Override
	public int deleteNewEventByID(int id) {
		
		int result = newEventDaoImpl.deleteNewEventByID(id); 
		return result;
	}

	@Override
	public int updateNewEventByID(NewEventEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的最新动态是否存在,如果已存在则不插入  
		NewEventEntity mngTeamEntity = newEventListDaoImpl.selectNewEventIsExistByNAme(entity);
		if(mngTeamEntity != null) {
			return -1;
		} 
		int result = newEventDaoImpl.updateNewEventByID(entity); 
		return result;
	}

	@Override
	public int updateNewEventStatuByID(NewEventEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		int result = newEventDaoImpl.updateNewEventStatuByID(entity); 
		return result;
	}

	@Override
	public List<NewEventEntity> selectNewEventListpage(
			PageEntity pageEntity) {
		
		List<NewEventEntity> newEventList = null;   
	 	newEventList = newEventListDaoImpl.selectNewEventList(pageEntity);  
		return newEventList; 
	}

 
	@Override
	public NewEventEntity selectNewEventByID(int id) {
		
		NewEventEntity mngTeamEntity = newEventListDaoImpl.selectNewEventByID(id);
		return mngTeamEntity;
	}

}
