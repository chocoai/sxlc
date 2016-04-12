package cn.springmvc.dao;

import cn.springmvc.model.VIPSetSubEntity; 
/**
 * VIP会员设置
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:50:45
 */
public interface VIPSetSubListDao {
	/**
	 * 查询VIP会员设置
	 * @param entity VIP会员设置实体
	 * @return
	 */
	public  VIPSetSubEntity  selectVIPSetSub (); 
	/**
	 * 查询VIP会员设置是否存在 
	 * @return  0：不存在	大于0：存在
	 */
	public  int  selectVIPSetSubIsExist();
}
