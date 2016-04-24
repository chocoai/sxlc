package cn.springmvc.service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.ProductIntroduceEntity;
 
/**
 * 
* @author 刘利 
* @Description: 产品介绍 
* @since 
* @date 2016-3-19 下午10:08:10
 */
public interface ProductIntroduceService {
	/**
	 * 新增产品介绍
	 * @param entity 产品介绍实体
	 * @return -1：数据为空;0：添加失败;1:添加成功
	 */
	public int insertProductIntroduce(ProductIntroduceEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除产品介绍
	 * @param id 产品介绍id
	 * @return 0：失败；1成功
	 */
	public int deleteProductIntroduce(int id,InsertAdminLogEntity 
			logentity,String[] sIpInfo);  
	/**
	 * 停用或启用产品介绍信息
	 * @param entity 产品介绍实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProductIntroduceStatuByID(ProductIntroduceEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 查询产品介绍 
	 * @param statu状态 statu(0:无效 1：有效 -1:全部)
	 * @return ProductIntroduceEntity 产品介绍实体
	 */
	public  ProductIntroduceEntity selectProductIntroduceList(int statu);
}
