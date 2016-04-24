package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.NewHandDao;
import cn.springmvc.dao.NewHandListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.NewHandEntity;
import cn.springmvc.service.NewHandService;
@Service("newHandServiceImpl")
public class NewHandServiceImpl implements NewHandService {
	@Resource(name="newHandDaoImpl")
	private NewHandDao newHandDaoImpl;  
	@Resource(name="newHandListDaoImpl")
	private NewHandListDao newHandListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertNewHand(NewHandEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询平台简介是否存在，不存在就新增，存在则修改
		int count = newHandListDaoImpl.selectNewHandIsExist();
		if(count == 0) { 
			count = newHandDaoImpl.insertNewHand(entity); 
			logentity.setsDetail("添加新手指南");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else{
			count =  newHandDaoImpl.updateNewHand(entity); 
			logentity.setsDetail("修改新手指南");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		} 
		return count;
	} 
	
	@Override
	public int deleteNewHand(InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = newHandDaoImpl.deleteNewHand();
		if(result == 1) {
		  logentity.setsDetail("删除新手指南");
		  optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
  
	@Override
	public NewHandEntity selectNewHandList() {
		
		NewHandEntity newHandEntity = newHandListDaoImpl.selectNewHand();
		return newHandEntity;
	}

}
