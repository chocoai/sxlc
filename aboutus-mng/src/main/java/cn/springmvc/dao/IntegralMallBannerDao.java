package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.IntegralMallBannerEntity;

public interface  IntegralMallBannerDao {
	/**
	 * 添加积分商城轮播图
	 * @param entity  积分商城轮播图实体类
	 * @return	0：失败	1：成功
	 */
	public int insertIntegralMallBanner(IntegralMallBannerEntity entity); 
	
	/**
	 * 通过ID修改积分商城轮播图
	 * @param entity 积分商城轮播图实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateIntegralMallBannerByID(IntegralMallBannerEntity entity); 
	/**
	 * 通过ID删除积分商城轮播图
	 * @param id 积分商城轮播图id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteIntegralMallBannerByID(int id);
	/**
	 * 查询积分商城轮播图列表
	 * @param map查询条件集合
	 * @return List<PartnersEntity> 
	 */
	public  List<IntegralMallBannerEntity>  selectIntegralMallBannerAll(Map<String, Object> map);
	
	/**
	 * 停用或启用积分商城轮播图
	 * @param entity 积分商城轮播图实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateIntegralMallBannerStatuByID(IntegralMallBannerEntity entity);
	/**
	 * 上移或下移积分商城轮播图
	 * @param entity 积分商城轮播图实体
	 * @return -1:失败 1：成功 
	 */
	public  int  moveAndDownIntegralMallBanner(Map<String, Object> map);
}
