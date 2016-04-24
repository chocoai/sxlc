package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.SecurityGuaranteeDao;
import cn.springmvc.dao.SecurityGuaranteeListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.SecurityGuaranteeEntity;
import cn.springmvc.service.SecurityGuaranteeService;
@Service("securityGuaranteeServiceImpl")
public class SecurityGuaranteeServiceImpl implements SecurityGuaranteeService {
	@Resource(name="securityGuaranteeDaoImpl")
	private SecurityGuaranteeDao securityGuaranteeDaoImpl;  
	@Resource(name="securityGuaranteeListDaoImpl")
	private SecurityGuaranteeListDao securityGuaranteeListDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertSecurityGuarantee(SecurityGuaranteeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) { 
		
		if(entity == null) {
			return -1;
		} 
		
		int result = 0;
		// 查询安全保障是否存在，不存在就新增，存在则修改
		int count = securityGuaranteeListDaoImpl.selectSecurityGuaranteeIsExist();
		if(count == 0) {
			
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
			long id = generatorUtil.GetId();
			entity.setId((int)id);
			result = securityGuaranteeDaoImpl.insertSecurityGuarantee(entity);
			if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
			}else{
				generatorUtil.SetIdUsed(id);
				logentity.setsDetail("添加安全保障");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			}
			
		}else{
			result = securityGuaranteeDaoImpl.updateSecurityGuaranteeByID(entity); 
			if(result == 1) {
			    logentity.setsDetail("修改安全保障  ");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			}
		} 
		return result;  
	}

	@Override
	public int deleteSecurityGuarantee(int id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = securityGuaranteeDaoImpl.deleteSecurityGuaranteeByID(id);
		if(result == 1) {
		    logentity.setsDetail("删除安全保障  ");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
 

	@Override
	public int updateSecurityGuaranteeStatuByID(SecurityGuaranteeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = securityGuaranteeDaoImpl.updateSecurityGuaranteeStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用安全保障");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用安全保障");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public SecurityGuaranteeEntity selectSecurityGuaranteeList(int statu) {
		
		SecurityGuaranteeEntity securityGuaranteeEntity = securityGuaranteeListDaoImpl.selectSecurityGuarantee(statu);
		return securityGuaranteeEntity;
	}

}
