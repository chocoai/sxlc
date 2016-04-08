package  cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.SafetyCertificationSetDao;
import cn.springmvc.dao.SafetyCertificationSetListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SafetyCertificationSetDaoImpl;
import cn.springmvc.dao.impl.SafetyCertificationSetListDaoImpl;
import cn.springmvc.model.SafetyCertificationSetEntity;
import cn.springmvc.service.SafetyCertificationSetService;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
@Service("safetyCertificationSetServiceImpl")
public class SafetyCertificationSetServiceImpl implements SafetyCertificationSetService {
	@Resource(name="safetyCertificationSetDaoImpl")
	private SafetyCertificationSetDao safetyCertificationSetDaoImpl;  
	@Resource(name="safetyCertificationSetListDaoImpl")
	private SafetyCertificationSetListDao safetyCertificationSetListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
 
	@Override
	public int deleteSafetyCertificationSetByID(int id,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		
		int result=safetyCertificationSetDaoImpl.deleteSafetyCertificationSetByID(id); 
		if(result == 1) {
			entityLog.setsDetail("删除首页弹出公告");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateSafetyCertificationSetByID(SafetyCertificationSetEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		if(entity == null){
			return 0;
		}  
		int result=safetyCertificationSetDaoImpl.updateSafetyCertificationSetByID(entity);
		if(result == 1) {
			entityLog.setsDetail("修改首页弹出公告");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateSafetyCertificationSetStatuByID(SafetyCertificationSetEntity entity) {
		
		int result=safetyCertificationSetDaoImpl.updateSafetyCertificationSetStatuByID(entity); 
		return result;
	}

	@Override
	public List<SafetyCertificationSetEntity> selectSafetyCertificationSetListpage(
			PageEntity pageEntity) {
		List<SafetyCertificationSetEntity> safetyCertificationSetList=null;    
	 	safetyCertificationSetList = safetyCertificationSetListDaoImpl.selectSafetyCertificationSetAllpage(pageEntity);  
		return safetyCertificationSetList; 
	}

	@Override
	public int insertSafetyCertificationSet(SafetyCertificationSetEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo) {
		if(entity == null){
			return 0;
		}  
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		int result = safetyCertificationSetDaoImpl.insertSafetyCertificationSet(entity);
		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
		}else{
			generatorUtil.SetIdUsedFail(id);
		} 
		if(result == 1) {
			entityLog.setsDetail("添加首页弹出公告");
			optRecordWriteDaoImpl.InsertAdminOptRecord(entityLog, sIpInfo);
		}
		return result;
	}

	@Override
	public SafetyCertificationSetEntity selectSafetyCertificationSetbyID(int id) {
		 SafetyCertificationSetEntity  safetyCertificationSet=null;
		 safetyCertificationSet=safetyCertificationSetListDaoImpl.selectSafetyCertificationSetbyID(id);
		 return safetyCertificationSet;
	}

}
