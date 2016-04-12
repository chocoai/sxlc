package cn.springmvc.dao;

import cn.springmvc.model.ProductIntroduceEntity;
/**
 * 
* @author 刘利 
* @Description: 产品介绍
* @since 
* @date 2016-3-19 下午9:48:08
 */
public interface productIntroduceListDao {
	/**
	 * 查询产品介绍
	 * @param statu 状态
	 * @return
	 */
	public  ProductIntroduceEntity  selectProductIntroduce(int statu); 
	/**
	 * 查询产品介绍是否存在 
	 * @return  0：不存在	大于0：存在
	 */
	public  int  selectProductIntroduceIsExist();
}
