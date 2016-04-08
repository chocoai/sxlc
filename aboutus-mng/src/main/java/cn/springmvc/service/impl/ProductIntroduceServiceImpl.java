package cn.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.ProductIntroduceDao;
import cn.springmvc.dao.productIntroduceListDao;
import cn.springmvc.dao.impl.ExpertTeamDaoImpl;
import cn.springmvc.dao.impl.ExpertTeamListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.ProductIntroduceDaoImpl;
import cn.springmvc.dao.impl.ProductIntroduceListDaoImpl;
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.ProductIntroduceEntity;
import cn.springmvc.service.ProductIntroduceService;
@Service("productIntroduceServiceImpl")
public class ProductIntroduceServiceImpl implements ProductIntroduceService {
	@Resource(name="productIntroduceDaoImpl")
	private ProductIntroduceDao productIntroduceDaoImpl;  
	@Resource(name="productIntroduceListDaoImpl")
	private productIntroduceListDao productIntroduceListDaoImpl;  
	@Override
	public int insertProductIntroduce(ProductIntroduceEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询产品介绍是否存在，不存在就新增，存在则修改
		int count = productIntroduceListDaoImpl.selectProductIntroduceIsExist();
		if(count == 0) {
			IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
			long id = generatorUtil.GetId();
			entity.setId((int)id);
			
			int result = productIntroduceDaoImpl.insertProductIntroduce(entity);
			
			if(result == 0) {
				generatorUtil.SetIdUsedFail(id);
			}else{
				generatorUtil.SetIdUsed(id);
			}
			return result; 
		}else{
			return productIntroduceDaoImpl.updateProductIntroduceByID(entity); 
		} 
		
	}

	@Override
	public int deleteProductIntroduce(int id) {
		
		int result = productIntroduceDaoImpl.deleteProductIntroduceByID(id); 
		return result;
	}
 

	@Override
	public int updateProductIntroduceStatuByID(ProductIntroduceEntity entity) {
		
		int result = productIntroduceDaoImpl.updateProductIntroduceStatuByID(entity); 
		return result;
	}

	@Override
	public ProductIntroduceEntity selectProductIntroduceList(int statu) {
		
		ProductIntroduceEntity productIntroduceEntity = productIntroduceListDaoImpl.selectProductIntroduce(statu);
		return productIntroduceEntity;
	}

}
