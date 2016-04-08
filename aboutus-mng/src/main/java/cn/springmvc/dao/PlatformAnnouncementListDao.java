package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.PlatformAnnouncementEntity;
/**
 * 
* @author 刘利 
* @Description:  平台公告接口类 
* @since 
* @date 2016-3-19 下午9:47:30
 */
public interface PlatformAnnouncementListDao {
	/**
	 * 查询该名称的平台公告是否存在
	 * @param entity 平台公告实体
	 * @return  PlatformAnnouncementEntity 
	 */
	public  PlatformAnnouncementEntity  selectPlatformIsExistByNAme(PlatformAnnouncementEntity entity);
	/**
	 * 分页查询平台公告
	 * @param  pageEntity 分页实体类
	 * @return
	 */
	public List<PlatformAnnouncementEntity> selectPlatformList(
			PageEntity pageEntity); 
	/**
	 * 根据id查询平台公告
	 * @param id 平台公告id
	 * @return  PlatformAnnouncementEntity 
	 */
	public  PlatformAnnouncementEntity  selectPlatformByID(int id);

}
