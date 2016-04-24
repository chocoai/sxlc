package cn.springmvc.service.impl;
 
import java.util.List; 

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.PartnersDao;
import cn.springmvc.dao.PartnersListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.PartnersEntity;
import cn.springmvc.service.PartnersService;
@Service("partnersServiceImpl")
public class PartnersServiceImpl implements PartnersService {
	
	@Resource(name="partnerDaoImpl")
	private PartnersDao partnerDaoImpl; 
	@Resource(name="partnerListDaoImpl")
	private PartnersListDao partnerListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override 
	public int insertPartners(PartnersEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		// 查询该合作伙伴是否存在 
		PartnersEntity partnersEntity = partnerListDaoImpl.selectPartnerIsExistByNAme(entity);
		if(partnersEntity != null) {
			return -1;
		}
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		
		int result = partnerDaoImpl.insertPartners(entity);
		
		if(result == 0) {
			
			generatorUtil.SetIdUsedFail(id);
		}else {
			
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加合作伙伴 :"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
	}
	
	
	@Override
	public int deletePartners(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		PartnersEntity partnersEntity = partnerListDaoImpl.selectPartnerByID(id);
		
		int result = partnerDaoImpl.deletePartnerByID(id); 
		if(result == 1) {
			
			logentity.setsDetail("删除合作伙伴 :"+partnersEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			
		}
		return result;
	}
	
	
	@Override
	public int updatePartners(PartnersEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		// 查询该合作伙伴是否存在 
		PartnersEntity partnersEntity = partnerListDaoImpl.selectPartnerIsExistByNAme(entity);
		if(partnersEntity != null) {
			return -1;
		}
		int result = partnerDaoImpl.updatePartnerByID(entity);
		
		if(result == 1) {
			
			logentity.setsDetail("修改合作伙伴 :"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			
		}
		return result;
	}

	@Override
	public int updatePartnerStatuByID(PartnersEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		}
		if(entity.isStatu()) {
			entity.setStatu(false);
		}else {
			entity.setStatu(true);
		}
		PartnersEntity partnersEntity = partnerListDaoImpl.selectPartnerByID(entity.getId());
		int result = partnerDaoImpl.updatePartnerStatuByID(entity);
        if(result == 1 && entity.isStatu()) { 
			
			logentity.setsDetail("启用合作伙伴 :"+partnersEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			
		}else if(result == 1 && !entity.isStatu()){
			
			logentity.setsDetail("停用合作伙伴 :"+partnersEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
		
	} 
	@Override
	public List<PartnersEntity>  selectPartnersList(PageEntity pageEntity) {
		
		List<PartnersEntity> partnersList = null;    
	 	partnersList = partnerListDaoImpl.selectPartnerList(pageEntity);   
		return partnersList;  
		
	}
	 
	
	@Override
	public PartnersEntity selectPartnerByID(int id) {
		 
	    PartnersEntity partnersEntity = partnerListDaoImpl.selectPartnerByID(id);
		return partnersEntity;
		
	}
	@Override
	public List<PartnersEntity> selectPartnersListIndex() {
		
		return partnerListDaoImpl.selectPartnersListIndex();
		
	} 
}
