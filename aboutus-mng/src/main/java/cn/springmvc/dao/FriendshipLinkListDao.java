package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.FriendshipUnitEntity;
/**
 * 
* @author 刘利 
* @Description: 友情链接查询功能 
* @since 
* @date 2016-3-19 下午8:06:10
 */
public interface FriendshipLinkListDao {
	/**
	 * 查询该名称的友情链接是否存在
	 * @param entity 友情链接实体
	 * @return  friendshipUnitEntity 友情链接实体
	 */
	public  FriendshipUnitEntity  selectFriendshipLinkIsExistByNAme(FriendshipUnitEntity entity);
	/**
	 * 分页查询友情链接
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<FriendshipUnitEntity> selectFriendshipLinkAllpage(
			PageEntity pageEntity);
	/**
	 * 根据id查询友情链接
	 * @param id 友情链接ID
	 * @return  PartnersEntity  友情链接实体
	 */
	public  FriendshipUnitEntity  selectFriendshipLinkByID(int id);
	/**
	 * 前台查询友情链接 
	 * @return
	 */
	public List<FriendshipUnitEntity> selectFriendShipLinkfront();
	
}
