
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
 
import cn.springmvc.dao.ProjectPurposeDao;
import cn.springmvc.dao.SelectProjectAppRecordDao;
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.ProjectPurposeEntity;
import cn.springmvc.service.ProjectPurposeService;
/**
 * 
* @author 刘利 
* @Description: 实现新增借款意向
* @since 
* @date 2016-3-18 下午7:13:25
 */
@Service("projectPurposeServiceImpl")
public class ProjectPurposeServiceImpl implements ProjectPurposeService {
	@Resource(name="projectPurposeDaoImpl")
	private ProjectPurposeDao projectPurposeDaoImpl;  
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Resource(name="selectProjectAppRecordDaoImpl")
	private SelectProjectAppRecordDao selectProjectAppRecordDao;
	
	@Override
	public int insertProjectPurpose(ProjectPurposeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) { 
		if(entity == null) {
			return 0;
		}
		Map<String,Object> map =new HashMap<String,Object>(); 
		map.put("memberID",     entity.getMemberID());
		map.put("memberType", entity.getMemberType());
		Integer isopen = selectProjectAppRecordDao.getIsopen(map);
		if(isopen == null) {
			return -1;//该会员未开通第三方
		}
		if(isopen == 0) {
			return -2;//该会员未授权二次分配授权
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
        int result= projectPurposeDaoImpl.insertProjectPurposeDao(entity);
        if(result == 1) {
			generatorUtil.SetIdUsed(id); 
			logentity.setsDetail("添加借款意向");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else{
			generatorUtil.SetIdUsedFail(id);
		}  
        return result;

	}

	@Override
	public int insertProjectPurposeFront(ProjectPurposeEntity entity) {
		
		if(entity == null) {
			return 0;
		}
		Map<String,Object> map =new HashMap<String,Object>(); 
		map.put("memberID",     entity.getMemberID());
		map.put("memberType", entity.getMemberType());
		Integer isopen = selectProjectAppRecordDao.getIsopen(map);
		if(isopen == null) {
			return -1;//该会员未开通第三方
		}
		if(isopen == 0) {
			return -2;//该会员未授权二次分配授权
		}
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
        int result= projectPurposeDaoImpl.insertProjectPurposeDao(entity);
        if(result == 1) {
			generatorUtil.SetIdUsed(id);  
		}else{
			generatorUtil.SetIdUsedFail(id);
		}  
        return result; 
	} 
}

