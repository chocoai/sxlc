
package cn.springmvc.service.impl; 


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.impl.HandleSystemSetDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectSystemSetDaoImpl;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.service.SystemSetService;

/** 
 * 系统、平台设置 接口实现
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午9:38:07  */
@Service("systemSetServiceImpl")
public class SystemSetServiceImpl implements
 SystemSetService {
	@Resource(name="selectSystemSetDaoImpl")
	private SelectSystemSetDaoImpl  selectSystemSetDaoImpl;
	
	@Resource(name="handleSystemSetDaoImpl")
	private HandleSystemSetDaoImpl  handleSystemSetDaoImpl;

	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public SystemSetEntity findSystemSet() {
		
		// TODO Auto-generated method stub return null;
		return selectSystemSetDaoImpl.findSystemSet();
	}

	@Override
	public int updateSystemSet(SystemSetEntity systemSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.updateSystemSet(systemSetEntity);
	}

	@Override
	public int insertSystemSet(SystemSetEntity systemSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.insertSystemSet(systemSetEntity);
	}

	@Override
	public SystemInfoSetEntity findSystemInfoSet() {
		
		// TODO Auto-generated method stub return null;
		return selectSystemSetDaoImpl.findSystemInfoSet();
	}

	@Override
	public int updateSystemInfoSet() {
		
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.updateSystemInfoSet();
	}

	@Override
	public int insertSystemInfoSet(SystemInfoSetEntity systemInfoSetEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("操作平台设置 :"+systemInfoSetEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.insertSystemInfoSet(systemInfoSetEntity);
	}
	

}

