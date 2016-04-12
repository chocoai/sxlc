package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.HomeBannerEntity;
/**
 * 
* @author 刘利 
* @Description: 首页轮播图 
* @since 
* @date 2016-3-19 下午9:43:30
 */
public interface HomeBannerDao {
	/**
	 * 添加首页轮播图
	 * @param entity  首页轮播图实体类
	 * @return	0：失败	1：成功
	 */
	public int insertHomeBanner(HomeBannerEntity entity); 
	
	/**
	 * 通过ID修改首页轮播图
	 * @param entity 首页轮播图实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateHomeBannerByID(HomeBannerEntity entity); 
	/**
	 * 通过ID删除首页轮播图
	 * @param id 首页轮播图id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteHomeBannerByID(int id);
	/**
	 * 停用或启用首页轮播图
	 * @param entity 首页轮播图实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateHomeBannerStatuByID(HomeBannerEntity entity);
	/**
	 * 上移或下移首页轮播图
	 * @param entity 首页轮播图实体
	 * @return -1:失败 1：成功 
	 */
	public  int  moveAndDownHomeBannerByID(Map<String, Object> map);
	
}
