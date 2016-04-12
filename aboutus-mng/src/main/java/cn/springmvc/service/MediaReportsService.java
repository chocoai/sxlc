package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.MediaReportsEntity;

import com.github.pagehelper.PageInfo;
/**
 * 媒体报道
* @author 刘利 
* @Description: 媒体报道
* @since 
* @date 2016-3-19 下午10:07:02
 */
public interface MediaReportsService {
	/**
	 * 新增媒体报道
	 * @param entity 媒体报道实体
	 * @return 0：数据为空;-1：该名称的媒体报道已存在;1:添加成功
	 */
	public int insertMediaReports(MediaReportsEntity entity); 
	/**
	 * 删除媒体报道
	 * @param id 媒体报道id
	 * @return 0：失败；1成功
	 */
	public int deleteMediaReportsByID(int id); 
	/**
	 * 修改媒体报道
	 * @param entity 媒体报道实体 
	 * @return 0：失败；1成功
	 */
	public int updateMediaReportsByID(MediaReportsEntity entity);
	 /**
	 * 停用或启用媒体报道信息
	 * @param entity 媒体报道实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateMediaReportsStatuByID(MediaReportsEntity entity);
	/**
	 * 分页查询媒体报道
	 * @param pageEntity 分页实体  map{title,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<MediaReportsEntity> selectMediaReportsListpage(
			PageEntity pageEntity);
	/**
	 * 根据id查询媒体报道
	 * @param id 媒体报道ID
	 * @return  mediaReportsEntity 
	 */
	public  MediaReportsEntity  selectMediaReportsByID(int id);
}
