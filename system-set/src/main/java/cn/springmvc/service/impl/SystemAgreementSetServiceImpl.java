package  cn.springmvc.service.impl;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.SystemAgreementSetDao;
import cn.springmvc.dao.SystemAgreementSetListDao;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.SystemAgreementSetEntity;
import cn.springmvc.service.SystemAgreementSetService;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import product_p2p.kit.pageselect.PageUtil;
@Service("systemAgreementSetServiceImpl")
public class SystemAgreementSetServiceImpl implements SystemAgreementSetService {
	@Resource(name="systemAgreementSetDaoImpl")
	private SystemAgreementSetDao systemAgreementSetDaoImpl;  
	@Resource(name="systemAgreementSetListDaoImpl")
	private SystemAgreementSetListDao systemAgreementSetListDaoImpl;  
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
 
	@Override
	public int deleteSystemAgreementSetByType(int type,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result=systemAgreementSetDaoImpl.deleteSystemAgreementSetByType(type); 
		if(result == 1) {
		    logentity.setsDetail("删除系统协议");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateSystemAgreementSetByType(SystemAgreementSetEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result=systemAgreementSetDaoImpl.updateSystemAgreementSetByType(entity); 
		if(result == 1) {
		    logentity.setsDetail("修改系统协议");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateSystemAgreementSetStatuByType(SystemAgreementSetEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result=systemAgreementSetDaoImpl.updateSystemAgreementSetStatuByType(entity); 
		if(result == 1 && entity.getAgreementStatu() == 1) {
			logentity.setsDetail("启用系统协议  ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getAgreementStatu() == 0){
			logentity.setsDetail("停用系统协议 ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<SystemAgreementSetEntity> selectSystemAgreementSetListpage(
			PageEntity pageEntity) {
		List<SystemAgreementSetEntity> systemAgreementSetList=null;    
	 	systemAgreementSetList = systemAgreementSetListDaoImpl.selectSystemAgreementSetAllpage(pageEntity);  
		PageUtil.ObjectToPage(pageEntity, systemAgreementSetList);
	 	return systemAgreementSetList; 
	}

	@Override
	public int insertSystemAgreementSet(SystemAgreementSetEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		if(entity == null){
			return 0;
		} 
		// 查询该类型的协议是否存在,如果已存在则不插入  
		SystemAgreementSetEntity systemAgreementSetEntity= systemAgreementSetListDaoImpl.
				selectSystemAgreementSetIsExistBytype(entity);
		if(systemAgreementSetEntity != null){
			return -1;
		} 
		int result = systemAgreementSetDaoImpl.insertSystemAgreementSet(entity);
		if(result == 1) {
		    logentity.setsDetail("添加系统协议");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public SystemAgreementSetEntity selectSystemAgreementSetBytype(
			int agreementType) {
		
		return systemAgreementSetListDaoImpl.selectSystemAgreementSetBytype(agreementType);
		
	}

}
