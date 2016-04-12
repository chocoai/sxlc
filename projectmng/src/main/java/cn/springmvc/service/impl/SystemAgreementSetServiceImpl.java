package  cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.SystemAgreementSetDao;
import cn.springmvc.dao.SystemAgreementSetListDao;
import cn.springmvc.dao.impl.SystemAgreementSetDaoImpl;
import cn.springmvc.dao.impl.SystemAgreementSetListDaoImpl;
import cn.springmvc.model.SystemAgreementSetEntity;
import cn.springmvc.service.SystemAgreementSetService;

import product_p2p.kit.pageselect.PageEntity; 
@Service("systemAgreementSetServiceImpl")
public class SystemAgreementSetServiceImpl implements SystemAgreementSetService {
	@Resource(name="systemAgreementSetDaoImpl")
	private SystemAgreementSetDao systemAgreementSetDaoImpl;  
	@Resource(name="systemAgreementSetListDaoImpl")
	private SystemAgreementSetListDao systemAgreementSetListDaoImpl;  
 
	@Override
	public int deleteSystemAgreementSetByID(int id) {
		
		int result=systemAgreementSetDaoImpl.deleteSystemAgreementSetByType(id); 
		return result;
	}

	@Override
	public int updateSystemAgreementSetByType(SystemAgreementSetEntity entity) {
		
		int result=systemAgreementSetDaoImpl.updateSystemAgreementSetByType(entity); 
		return result;
	}

	@Override
	public int updateSystemAgreementSetStatuByType(SystemAgreementSetEntity entity) {
		
		int result=systemAgreementSetDaoImpl.updateSystemAgreementSetStatuByType(entity); 
		return result;
	}

	@Override
	public List<SystemAgreementSetEntity> selectSystemAgreementSetListpage(
			PageEntity pageEntity) {
		List<SystemAgreementSetEntity> systemAgreementSetList=null;    
	 	systemAgreementSetList = systemAgreementSetListDaoImpl.selectSystemAgreementSetAllpage(pageEntity);  
		return systemAgreementSetList; 
	}

	@Override
	public int insertSystemAgreementSet(SystemAgreementSetEntity entity) {
		if(entity == null){
			return 0;
		} 
		// 查询该类型的协议是否存在,如果已存在则不插入  
		SystemAgreementSetEntity systemAgreementSetEntity= systemAgreementSetListDaoImpl.selectSystemAgreementSetIsExistBytype(entity);
		if(systemAgreementSetEntity != null){
			return -1;
		} 
		return systemAgreementSetDaoImpl.insertSystemAgreementSet(entity);
	}

	@Override
	public SystemAgreementSetEntity selectSystemAgreementSetBytype(
			int agreementType) {
		
		return systemAgreementSetListDaoImpl.selectSystemAgreementSetBytype(agreementType);
		
	}

}
