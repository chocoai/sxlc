package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.PlatformIntroduceDao;
import cn.springmvc.dao.PlatformIntroduceListDao;
import cn.springmvc.dao.impl.ExpertTeamDaoImpl;
import cn.springmvc.dao.impl.ExpertTeamListDaoImpl;
import cn.springmvc.dao.impl.PlatformIntroduceDaoImpl;
import cn.springmvc.dao.impl.PlatformIntroduceListDaoImpl;
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.PlatformIntroduceEntity;
import cn.springmvc.service.PlatformIntroduceService;
@Service("platformIntroduceServiceImpl")
public class PlatformIntroduceServiceImpl implements PlatformIntroduceService {
	@Resource(name="platformIntroduceDaoImpl")
	private PlatformIntroduceDao platformIntroduceDaoImpl;  
	@Resource(name="platformIntroduceListDaoImpl")
	private PlatformIntroduceListDao platformIntroduceListDaoImpl;  
	@Override
	public int insertPlatformIntroduce(PlatformIntroduceEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询平台简介是否存在，不存在就新增，存在则修改
		int count = platformIntroduceListDaoImpl.selectPlatformIntroducesIsExist();
		if(count == 0) {
			return platformIntroduceDaoImpl.insertPlatformIntroduce(entity); 
		}else{
			return platformIntroduceDaoImpl.updatePlatformIntroduce(entity); 
		} 
		
	}

	@Override
	public int deletePlatformIntroduce(int id) {
		
		int result = platformIntroduceDaoImpl.deletePlatformIntroduce(id); 
		return result;
	}
  
	@Override
	public PlatformIntroduceEntity selectPlatformIntroduceList() {
		
		PlatformIntroduceEntity platformIntroduceEntity = platformIntroduceListDaoImpl.selectPlatformIntroduce();
		return platformIntroduceEntity;
	}

}
