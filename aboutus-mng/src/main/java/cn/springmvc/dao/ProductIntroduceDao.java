package cn.springmvc.dao;
  
import cn.springmvc.model.ProductIntroduceEntity;
/**
 * 
* @author 刘利 
* @Description: 产品介绍
* @since 
* @date 2016-3-19 下午9:48:01
 */
public interface ProductIntroduceDao {
	/**
	 * 添加产品介绍
	 * @param entity  产品介绍实体类
	 * @return	0：失败	1：成功
	 */
	public int insertProductIntroduce(ProductIntroduceEntity entity);
 
	/**
	 * 通过ID修改产品介绍
	 * @param entity 产品介绍实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateProductIntroduceByID(ProductIntroduceEntity entity); 
	/**
	 * 通过ID删除产品介绍
	 * @param id 产品介绍id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteProductIntroduceByID(int id);   
	/**
	 * 停用或启用产品介绍
	 * @param entity 产品介绍实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProductIntroduceStatuByID(ProductIntroduceEntity entity);

}
