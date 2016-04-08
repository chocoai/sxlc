package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.IntegralMallBannerEntity;
/**
 * 
* @author 刘利 
* @Description: 积分商城查询功能
* @since 
* @date 2016-3-19 下午8:26:13
 */
public interface IntegralMallBannerListDao {
	/**
	 * 查询该名称的积分商城轮播图是否存在
	 * @param entity 积分商城轮播图实体
	 * @return  integralMallBannerEntity 
	 */
	public  IntegralMallBannerEntity  selectIntegralMallBannerIsExistByNAme(IntegralMallBannerEntity entity);
	/**
	 * 分页查询积分商城轮播图
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<IntegralMallBannerEntity> selectIntegralMallBannerAllpage(PageEntity pageEntity); 
	/**
	 * 根据id查询积分商城轮播图
	 * @param id 积分商城轮播图id
	 * @return  integralMallBannerEntity 
	 */
	public  IntegralMallBannerEntity  selectIntegralMallBannerByID(int id);
	/**
	 * 查询积分商城轮播图 前台
	 * @return
	 */
	public List<IntegralMallBannerEntity> selectIntegralMallBannerfront(); 
	/**
	 * 查询积分商城轮播图 序号
	 * @return
	 */
	public int selectIntegralMallBannerindex(); 

	
}
