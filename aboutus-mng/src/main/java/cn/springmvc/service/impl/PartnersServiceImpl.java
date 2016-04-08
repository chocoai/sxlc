package cn.springmvc.service.impl;

import java.util.ArrayList; 
import java.util.List; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.PartnersDao;
import cn.springmvc.dao.PartnersListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.PartnerDaoImpl; 
import cn.springmvc.dao.impl.PartnerListDaoImpl;
import cn.springmvc.model.PartnersEntity;
import cn.springmvc.service.PartnersService;
@Service("partnersServiceImpl")
public class PartnersServiceImpl implements PartnersService {
	@Resource(name="partnerDaoImpl")
	private PartnersDao partnerDaoImpl; 
	@Resource(name="partnerListDaoImpl")
	private PartnersListDao partnerListDaoImpl; 
	@Override 
	public int insertPartners(PartnersEntity entity) {
		
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
		}else{
			generatorUtil.SetIdUsed(id);
		}
		return result; 
	}
	@Override
	public int deletePartners(int id) {
		
		int result = partnerDaoImpl.deletePartnerByID(id);
		return result;
	}
	@Override
	public int updatePartners(PartnersEntity entity) {
		
		if(entity == null) {
			return 0;
		}
		// 查询该合作伙伴是否存在 
		PartnersEntity partnersEntity = partnerListDaoImpl.selectPartnerIsExistByNAme(entity);
		if(partnersEntity != null){
			return -1;
		}
		int result = partnerDaoImpl.updatePartnerByID(entity);
		return result;
	}

	@Override
	public int updatePartnerStatuByID(PartnersEntity entity) {
		
		if(entity == null) {
			return 0;
		}
		int result = partnerDaoImpl.updatePartnerStatuByID(entity);
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
}
