package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.ProductIntroduceDao;
import cn.springmvc.dao.productIntroduceListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl; 
import cn.springmvc.model.ProductIntroduceEntity;
import cn.springmvc.service.ProductIntroduceService;
@Service("productIntroduceServiceImpl")
public class ProductIntroduceServiceImpl implements ProductIntroduceService {
	@Resource(name="productIntroduceDaoImpl")
	private ProductIntroduceDao productIntroduceDaoImpl;  
	@Resource(name="productIntroduceListDaoImpl")
	private productIntroduceListDao productIntroduceListDaoImpl; 
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public int insertProductIntroduce(ProductIntroduceEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return -1;
		} 
		int result = 0;
		// 查询产品介绍是否存在，不存在就新增，存在则修改
		int count = productIntroduceListDaoImpl.selectProductIntroduceIsExist();
		if(count == 0) {
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
			long id = generatorUtil.GetId();
			entity.setId((int)id);
			
			result = productIntroduceDaoImpl.insertProductIntroduce(entity);
			
			if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
			}else{
				generatorUtil.SetIdUsed(id);
				logentity.setsDetail("添加产品介绍");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			}
			
		}else{
			result = productIntroduceDaoImpl.updateProductIntroduceByID(entity); 
			if(result == 1) {
				logentity.setsDetail("修改产品介绍");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			}
		} 
		return result; 
	}

	@Override
	public int deleteProductIntroduce(int id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = productIntroduceDaoImpl.deleteProductIntroduceByID(id); 
		if(result == 1) {
			logentity.setsDetail("删除产品介绍");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
 

	@Override
	public int updateProductIntroduceStatuByID(ProductIntroduceEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		 
		int result = productIntroduceDaoImpl.updateProductIntroduceStatuByID(entity); 
		if(result == 1 && entity.getStatu() == 1) {
			logentity.setsDetail("启用产品介绍");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && entity.getStatu() == 0){
			logentity.setsDetail("停用产品介绍");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public ProductIntroduceEntity selectProductIntroduceList(int statu) {
		
		ProductIntroduceEntity productIntroduceEntity = productIntroduceListDaoImpl.selectProductIntroduce(statu);
		return productIntroduceEntity;
	}

}
