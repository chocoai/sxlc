package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.NewHandDao;
import cn.springmvc.dao.NewHandListDao;
import cn.springmvc.dao.impl.ExpertTeamDaoImpl;
import cn.springmvc.dao.impl.ExpertTeamListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.NewHandDaoImpl;
import cn.springmvc.dao.impl.NewHandListDaoImpl;
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.NewHandEntity;
import cn.springmvc.service.NewHandService;
@Service("newHandServiceImpl")
public class NewHandServiceImpl implements NewHandService {
	@Resource(name="newHandDaoImpl")
	private NewHandDao newHandDaoImpl;  
	@Resource(name="newHandListDaoImpl")
	private NewHandListDao newHandListDaoImpl;  
	@Override
	public int insertNewHand(NewHandEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询平台简介是否存在，不存在就新增，存在则修改
		int count = newHandListDaoImpl.selectNewHandIsExist();
		if(count == 0) { 
			return newHandDaoImpl.insertNewHand(entity); 
		}else{
			return newHandDaoImpl.updateNewHand(entity); 
		} 
		
	} 
	
	@Override
	public int deleteNewHand() {
		
		int result = newHandDaoImpl.deleteNewHand(); 
		return result;
	}
  
	@Override
	public NewHandEntity selectNewHandList() {
		
		NewHandEntity newHandEntity = newHandListDaoImpl.selectNewHand();
		return newHandEntity;
	}

}
