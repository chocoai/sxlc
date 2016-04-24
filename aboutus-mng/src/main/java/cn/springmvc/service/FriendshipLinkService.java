package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.model.FriendshipUnitEntity; 
 /**
  * 
 * @author 刘利 
 * @Description: 实现友情链接的增删改
 * @since 
 * @date 2016-3-19 下午8:07:52
  */
public interface FriendshipLinkService {
	/**
	 * 新增友情链接
	 * @param entity 友情链接实体
	 * @return 0：数据为空;-1：该名称的友情链接已存在;1:添加成功
	 */
	public int insertFriendshipLink(FriendshipUnitEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除友情链接
	 * @param id 友情链接id
	 * @return 0：失败；1成功
	 */
	public int deleteFriendshipLinkByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 修改友情链接
	 * @param entity 友情链接实体
	 * @return 0：失败；1成功；-1：该名称的友情链接已存在;
	 */
	public int updateFriendshipLinkByID(FriendshipUnitEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	 /**
	 * 停用或启用友情链接信息
	 * @param entity 友情链接实体 传statu(0:无效 1：有效) ，id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateFriendShipLinkStatuByID(FriendshipUnitEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 分页查询友情链接
	 * @param pageEntity 分页实体类 map(name,statu(0:无效 1：有效,-1全部))
	 * @return
	 */
	public List<FriendshipUnitEntity> selectFriendshipLinkListpage(
			PageEntity pageEntity);
	/**
	 * 根据id查询友情链接
	 * @param id 友情链接ID
	 * @return  PartnersEntity  友情链接实体
	 */
	public  FriendshipUnitEntity  selectFriendshipLinkByID(long id);
	/**
	 * 前台查询友情链接 
	 * @return
	 */
	public List<FriendshipUnitEntity> selectFriendShipLinkfront();
}
