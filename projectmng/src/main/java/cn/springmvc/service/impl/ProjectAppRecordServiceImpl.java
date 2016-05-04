package  cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.impl.HandleProjectAppRecrdDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.dao.impl.SelectProjectAppRecordDaoImpl;
import cn.springmvc.model.ProjectAppAttachmentEntity;
import cn.springmvc.model.ProjectAppAutoSetEntity;
import cn.springmvc.model.ProjectAppMngFeeEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectInvestRedPackageEntity;
import cn.springmvc.model.ProjectPurposeEntity;
import cn.springmvc.service.ProjectAppRecordService;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import product_p2p.kit.pageselect.PageUtil;

/** 
 * 意向借款提交申请相关实现
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-23 上午11:14:40  */
@Service("projectAppRecordServiceImpl")
public class ProjectAppRecordServiceImpl implements ProjectAppRecordService {
	@Resource(name="handleProjectAppRecrdDaoImpl")
	private HandleProjectAppRecrdDaoImpl handleProjectAppRecrdDaoImpl;  
	@Resource(name="selectProjectAppRecordDaoImpl")
	private SelectProjectAppRecordDaoImpl selectProjectAppRecordDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	/* *  *  * @param map
	/* *  *  * @param entity
	/* *  *  * @param sIpInfo
	/* *  *  * @return * @see cn.springmvc.service.ProjectAppRecordService#updateProjectPurposeById(java.util.Map, product_p2p.kit.optrecord.InsertAdminLogEntity, java.lang.String[]) */
	@Override
	public int updateProjectPurposeById(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleProjectAppRecrdDaoImpl.updateProjectPurposeById(map);
	}
	@Override
	public int distributionOfFC(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleProjectAppRecrdDaoImpl.distributionOfFC(map);
	}
	@Override
	public Map<String, Object> handleProjectAppRecord(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return null;
		return handleProjectAppRecrdDaoImpl.handleProjectAppRecord(map);
	}
	@Override
	public int insertProjectInvestRedPackage(
			List<ProjectInvestRedPackageEntity> lEntities,InsertAdminLogEntity entity, String[] sIpInfo) {
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleProjectAppRecrdDaoImpl.insertProjectInvestRedPackage(lEntities);
	}
	@Override
	public int deleteProjectInvestRedPackageById(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleProjectAppRecrdDaoImpl.deleteProjectInvestRedPackageById(map);
	}
	@Override
	public int insertProjectAppAttachment(List<ProjectAppAttachmentEntity> list,InsertAdminLogEntity entity, String[] sIpInfo) {
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleProjectAppRecrdDaoImpl.insertProjectAppAttachment(list);
	}
	@Override
	public int deleteProjectAppAttachment(Map<String, Object> map,InsertAdminLogEntity entity, String[] sIpInfo) {
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		return handleProjectAppRecrdDaoImpl.deleteProjectAppAttachment(map);
	}
	@Override
	public List<ProjectPurposeEntity> selectAllProjectPurpose(PageEntity page) {
		List<ProjectPurposeEntity> list =  selectProjectAppRecordDaoImpl.selectAllProjectPurpose(page);
		PageUtil.ObjectToPage(page, list); 
		return list;
	}
	@Override
	public ProjectPurposeEntity selectProjectPurposeById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectProjectAppRecordDaoImpl.selectProjectPurposeById(map);
	}
	@Override
	public ProjectAppRecordEntity selectProjectAppRecordById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectProjectAppRecordDaoImpl.selectProjectAppRecordById(map);
	}
	@Override
	public ProjectBaseInfoEntity selectProjectBaseInfoById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectProjectAppRecordDaoImpl.selectProjectBaseInfoById(map);
	}
	@Override
	public ProjectAppMngFeeEntity selectProjectAppMngFeeById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectProjectAppRecordDaoImpl.selectProjectAppMngFeeById(map);
	}
	@Override
	public ProjectAppAutoSetEntity selectProjectAppAutoSetById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectProjectAppRecordDaoImpl.selectProjectAppAutoSetById(map);
	}
	@Override
	public List<ProjectInvestRedPackageEntity> selectProjectInvestRedPackageById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectProjectAppRecordDaoImpl.selectProjectInvestRedPackageById(map);
	}
	@Override
	public List<ProjectAppAttachmentEntity> selectProjectAppAttachmentById(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return selectProjectAppRecordDaoImpl.selectProjectAppAttachmentById(map);
	}  
 
}
