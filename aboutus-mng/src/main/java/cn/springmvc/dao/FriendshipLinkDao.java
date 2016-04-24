package cn.springmvc.dao;
 

import cn.springmvc.model.FriendshipUnitEntity; 
/**
 * 
* @author 刘利 
* @Description: 实现友情链接增加、删除、修改功能
* @since 
* @date 2016-3-19 下午8:06:20
 */
public interface FriendshipLinkDao {
	/**
	 * 添加友情链接
	 * @param entity  友情链接实体类
	 * @return	0：失败	1：成功
	 */
	public int insertFriendshipLink(FriendshipUnitEntity entity); 
	/**
	 * 通过ID修改友情链接信息
	 * @param entity 友情链接实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateFriendshipLinkByID(FriendshipUnitEntity entity); 
	/**
	 * 通过ID删除友情链接信息
	 * @param id 友情链接id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteFriendshipLinkByID(long id);
	 	/**
	 * 停用或启用友情链接
	 * @param entity 友情链接实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateFriendShipLinkStatuByID(FriendshipUnitEntity entity);
	
}
