package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.MediaReportsEntity;
/**
 * 
* @author 刘利 
* @Description: 查询媒体报道
* @since 
* @date 2016-3-19 下午9:45:29
 */
public interface MediaReportsListDao {
	/**
	 * 查询该名称的媒体报道是否存在
	 * @param entity 媒体报道实体
	 * @return mediaReportsEntity 
	 */
	public  MediaReportsEntity  selectMediaReportsIsExistByNAme(MediaReportsEntity entity);
	/**
	 * 分页查询媒体报道
	 * @param pageEntity 分页实体
	 * @return
	 */
	public List<MediaReportsEntity> selectMediaReportsAllpage(PageEntity pageEntity); 
	/**
	 * 根据id查询媒体报道
	 * @param id 媒体报道实体
	 * @return  mediaReportsEntity 
	 */
	public  MediaReportsEntity  selectMediaReportsByID(int id);

}
