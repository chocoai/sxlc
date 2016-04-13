
package cn.springmvc.service.impl; 


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
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
	public int updateSystemSet(SystemSetEntity systemSetEntity,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("操作系统设置 :"+systemSetEntity.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		int retu=0;
		retu=IntegerAndString.StringToInt(systemSetEntity.getSautoBackRate(), -1);
		if (retu>-1) {
			systemSetEntity.setAutoBackRate(retu*10000);
		}
		retu=IntegerAndString.StringToInt(systemSetEntity.getSredpacketsRateMax(), -1);
		if (retu>-1) {
			systemSetEntity.setRedpacketsRateMax(retu*10000);
		}
		retu=IntegerAndString.StringToInt(systemSetEntity.getSriskMarginRateMax(), -1);
		if (retu>-1) {
			systemSetEntity.setRiskMarginRateMax(retu*10000);
		}
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
		//optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.insertSystemInfoSet(systemInfoSetEntity);
	}
	
	@Override
	public String findInterestMngFee() {
		// TODO Auto-generated method stub return null;
		Integer isdInteger= selectSystemSetDaoImpl.findInterestMngFee();
		int i=0;
		if (isdInteger==null) {
			i=0;
		}else {
			i=isdInteger;
		}
		return IntegerAndString.IntToString(i);
	}
	@Override
	public int setInterestMngFee(String PriceDatum,
			InsertAdminLogEntity entity, String[] sIpInfo) {
		
		// TODO Auto-generated method stub return 0;
		entity.setsDetail("设置利息管理费 :"+IntegerAndString.StringToInt(PriceDatum, 0));
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("PriceDatum", IntegerAndString.StringToInt(PriceDatum, 0)*10000);
		map=handleSystemSetDaoImpl.setInterestMngFee(map);
		int i=IntegerAndString.StringToInt(map.get("rulet").toString(),0);
		// TODO Auto-generated method stub return 0;
		return i;
	}
}

