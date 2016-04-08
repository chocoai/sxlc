package cn.springmvc.dao;

import cn.springmvc.model.NewHandEntity;
 
/**
 * 
* @author 刘利 
* @Description: 查询新手指南
* @since 
* @date 2016-3-19 下午9:46:39
 */
public interface NewHandListDao {
	/**
	 * 查询新手指南
	 * @param entity 新手指南实体
	 * @return
	 */
	public  NewHandEntity  selectNewHand (); 
	/**
	 * 查询新手指南是否存在 
	 * @return  0：不存在	大于0：存在
	 */
	public  int  selectNewHandIsExist();
}
