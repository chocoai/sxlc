package cn.springmvc.dao;

import cn.springmvc.model.PlatformIntroduceEntity;
 
/**
 * 
* @author 刘利 
* @Description: 平台简介 
* @since 
* @date 2016-3-19 下午9:47:47
 */
public interface PlatformIntroduceListDao {
	/**
	 * 查询平台简介
	 * @param entity 平台简介实体
	 * @return
	 */
	public  PlatformIntroduceEntity  selectPlatformIntroduce (); 
	/**
	 * 查询平台简介是否存在 
	 * @return  0：不存在	大于0：存在
	 */
	public  int  selectPlatformIntroducesIsExist();
}
