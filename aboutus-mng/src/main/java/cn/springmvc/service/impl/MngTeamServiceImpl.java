package cn.springmvc.service.impl;
 
import java.util.List; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
 

import cn.springmvc.dao.MngTeamDao;
import cn.springmvc.dao.MngTeamListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.MngTeamEntity; 
import cn.springmvc.service.MngTeamService;
@Service("mngTeamServiceImpl")
public class MngTeamServiceImpl implements MngTeamService {
	@Resource(name="mngTeamDaoImpl")
	private MngTeamDao mngTeamDaoImpl;  
	@Resource(name="mngTeamListDaoImpl")
	private MngTeamListDao mngTeamListDaoImpl;  
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertMngTeam(MngTeamEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的媒体报道是否存在,如果已存在则不插入  
		MngTeamEntity mngTeamEntity = mngTeamListDaoImpl.selectMngTeamIsExistByNAme(entity);
		if(mngTeamEntity != null) {
			return -1;
		} 
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = mngTeamDaoImpl.insertMngTeam(entity);
		
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加管理团队 :"+entity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;  
	}

	@Override
	public int deleteMngTeamByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		MngTeamEntity mngTeamEntity = mngTeamListDaoImpl.selectMngTeamByID(id);
		int result = mngTeamDaoImpl.deleteMngTeamByID(id); 
		if(result == 1) {
			logentity.setsDetail("删除管理团队 :"+mngTeamEntity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateMngTeamByID(MngTeamEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的媒体报道是否存在,如果已存在则不插入  
		MngTeamEntity mngTeamEntity = mngTeamListDaoImpl.selectMngTeamIsExistByNAme(entity);
		if(mngTeamEntity != null) {
			return -1;
		} 
		int result=mngTeamDaoImpl.updateMngTeamByID(entity); 
		if(result == 1) {
			logentity.setsDetail("修改管理团队 :"+entity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateMngTeamStatuByID(MngTeamEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null){
			return 0;
		} 
		MngTeamEntity mngTeamEntity = mngTeamListDaoImpl.selectMngTeamByID(entity.getId());
		int result = mngTeamDaoImpl.updateMngTeamStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用管理团队 :"+mngTeamEntity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用管理团队 :"+mngTeamEntity.getMngName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public List<MngTeamEntity> selectMngTeamListpage(PageEntity pageEntity) {
		List<MngTeamEntity> list = mngTeamListDaoImpl.selectMngTeamAllpage(pageEntity);
	 	PageUtil.ObjectToPage(pageEntity, list);
		return list; 
	}
 
	
	@Override
	public MngTeamEntity selectMngTeamByID(long id) {
		
		MngTeamEntity mngTeamEntity = mngTeamListDaoImpl.selectMngTeamByID(id);
		return mngTeamEntity;
	}

}
