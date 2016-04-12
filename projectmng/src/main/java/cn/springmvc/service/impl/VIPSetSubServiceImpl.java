package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.VIPSetSubDao;
import cn.springmvc.dao.VIPSetSubListDao;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.VIPSetSubDaoImpl;
import cn.springmvc.dao.impl.VIPSetSubListDaoImpl;
import cn.springmvc.model.VIPSetSubEntity; 
import cn.springmvc.service.VIPSetSubService;
@Service("vipSetSubServiceImpl")
public class VIPSetSubServiceImpl implements VIPSetSubService {
	@Resource(name="vipSetSubDaoImpl")
	private VIPSetSubDao vipSetSubDaoImpl;  
	@Resource(name="vipSetSubListDaoImpl")
	private VIPSetSubListDao vipSetSubListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertVIPSetSub(VIPSetSubEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		int result = 0;
		if(entity == null){
			return 0;
		} 
		// 查询VIP会员设置是否存在，不存在就新增，存在则修改
		int count = vipSetSubListDaoImpl.selectVIPSetSubIsExist();
		if(count == 0){
			result = vipSetSubDaoImpl.insertVIPSetSub(entity); 
		}else{
			result = vipSetSubDaoImpl.updateVIPSetSub(entity); 
		} 
		if(result == 1) {
			entityLog.setsDetail("修改VIP配置");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public int deleteVIPSetSub(int id) {
		int result=vipSetSubDaoImpl.deleteVIPSetSub(id);
		return result;
	}

	@Override
	public VIPSetSubEntity selectVIPSetSubList() {
		VIPSetSubEntity vipSetSubEntity= vipSetSubListDaoImpl.selectVIPSetSub();
		return vipSetSubEntity;
	}

}
