package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.model.PlatformAnnouncementEntity;
/**
 * 
* @author 刘利 
* @Description: 媒体报道接口
* @since 
* @date 2016-3-19 下午9:45:18
 */
public interface MediaReportsDao {
	/**
	 * 添加媒体报道
	 * @param entity  媒体报道实体类
	 * @return	0：失败	1：成功
	 */
	public int insertMediaReports(MediaReportsEntity entity); 
	/**
	 * 通过ID修改媒体报道
	 * @param entity 媒体报道实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateMediaReportsByID(MediaReportsEntity entity); 
	/**
	 * 通过ID删除媒体报道
	 * @param id 媒体报道id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteMediaReportsByID(int id); 
	
	/**
	 * 停用或启用媒体报道
	 * @param entity 媒体报道实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateMediaReportsStatuByID(MediaReportsEntity entity);
	
}
