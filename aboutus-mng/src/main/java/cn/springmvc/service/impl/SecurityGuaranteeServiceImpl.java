package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.SecurityGuaranteeDao;
import cn.springmvc.dao.SecurityGuaranteeListDao;
import cn.springmvc.dao.impl.ExpertTeamDaoImpl;
import cn.springmvc.dao.impl.ExpertTeamListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.SecurityGuaranteeDaoImpl;
import cn.springmvc.dao.impl.SecurityGuaranteeListDaoImpl;
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.SecurityGuaranteeEntity;
import cn.springmvc.service.SecurityGuaranteeService;
@Service("securityGuaranteeServiceImpl")
public class SecurityGuaranteeServiceImpl implements SecurityGuaranteeService {
	@Resource(name="securityGuaranteeDaoImpl")
	private SecurityGuaranteeDao securityGuaranteeDaoImpl;  
	@Resource(name="securityGuaranteeListDaoImpl")
	private SecurityGuaranteeListDao securityGuaranteeListDaoImpl;  
	@Override
	public int insertSecurityGuarantee(SecurityGuaranteeEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询安全保障是否存在，不存在就新增，存在则修改
		int count = securityGuaranteeListDaoImpl.selectSecurityGuaranteeIsExist();
		if(count == 0) {
			
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
			long id = generatorUtil.GetId();
			entity.setId((int)id);
			int result = securityGuaranteeDaoImpl.insertSecurityGuarantee(entity);
			if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
			}else{
				generatorUtil.SetIdUsed(id);
			}
			return result; 
		}else{
			return securityGuaranteeDaoImpl.updateSecurityGuaranteeByID(entity); 
		} 
		
	}

	@Override
	public int deleteSecurityGuarantee(int id) {
		
		int result = securityGuaranteeDaoImpl.deleteSecurityGuaranteeByID(id);
		
		return result;
	}
 

	@Override
	public int updateSecurityGuaranteeStatuByID(SecurityGuaranteeEntity entity) {
		
		int result = securityGuaranteeDaoImpl.updateSecurityGuaranteeStatuByID(entity); 
		return result;
	}

	@Override
	public SecurityGuaranteeEntity selectSecurityGuaranteeList(int statu) {
		
		SecurityGuaranteeEntity securityGuaranteeEntity = securityGuaranteeListDaoImpl.selectSecurityGuarantee(statu);
		return securityGuaranteeEntity;
	}

}
