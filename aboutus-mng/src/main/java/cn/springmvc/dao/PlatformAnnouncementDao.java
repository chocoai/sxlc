package cn.springmvc.dao;
 

import cn.springmvc.model.PlatformAnnouncementEntity; 
/**
 * 
* @author 刘利 
* @Description:  平台公告接口类
* @since 
* @date 2016-3-19 下午9:47:23
 */
public interface PlatformAnnouncementDao {
	/**
	 * 添加平台公告
	 * @param entity  平台公告实体类
	 * @return	0：失败	1：成功
	 */
	public int insertPlatform(PlatformAnnouncementEntity entity); 
	/**
	 * 通过ID修改平台公告
	 * @param entity 平台公告实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updatePlatformByID(PlatformAnnouncementEntity entity); 
	/**
	 * 通过ID删除平台公告
	 * @param id 平台公告id
	 * @return 0:失败 1：成功 
	 */
	public  int  deletePlatformByID(long id); 
	/**
	 * 停用或启用平台公告
	 * @param entity 平台公告实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updatePlatformStatuByID(PlatformAnnouncementEntity entity); 
}
