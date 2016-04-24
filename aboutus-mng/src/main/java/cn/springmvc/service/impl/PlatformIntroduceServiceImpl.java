package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.PlatformIntroduceDao;
import cn.springmvc.dao.PlatformIntroduceListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.PlatformIntroduceEntity;
import cn.springmvc.service.PlatformIntroduceService;
@Service("platformIntroduceServiceImpl")
public class PlatformIntroduceServiceImpl implements PlatformIntroduceService {
	@Resource(name="platformIntroduceDaoImpl")
	private PlatformIntroduceDao platformIntroduceDaoImpl;  
	@Resource(name="platformIntroduceListDaoImpl")
	private PlatformIntroduceListDao platformIntroduceListDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertPlatformIntroduce(PlatformIntroduceEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询平台简介是否存在，不存在就新增，存在则修改
		int count = platformIntroduceListDaoImpl.selectPlatformIntroducesIsExist();
		if(count == 0) {
			count = platformIntroduceDaoImpl.insertPlatformIntroduce(entity);
			logentity.setsDetail("添加平台简介");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else{
			count = platformIntroduceDaoImpl.updatePlatformIntroduce(entity);
			logentity.setsDetail("修改平台简介");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		} 
		return count;
	}

	@Override
	public int deletePlatformIntroduce(InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = platformIntroduceDaoImpl.deletePlatformIntroduce(); 
		if(result == 1) {
		    logentity.setsDetail("删除平台简介");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
  
	@Override
	public PlatformIntroduceEntity selectPlatformIntroduceList() {
		
		PlatformIntroduceEntity platformIntroduceEntity = platformIntroduceListDaoImpl.selectPlatformIntroduce();
		return platformIntroduceEntity;
	}

}
