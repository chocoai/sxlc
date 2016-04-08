package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.HomeBannerEntity;
/**
 * 
* @author 刘利 
* @Description: 首页轮播图的查询接口类 
* @since 
* @date 2016-3-19 下午8:17:13
 */
public interface HomeBannerListDao {
	/**
	 * 查询该名称的首页轮播图是否存在
	 * @param entity 首页轮播图实体
	 * @return  homeBannerEntity 
	 */
	public  HomeBannerEntity  selectHomeBannerIsExistByNAme(HomeBannerEntity entity);
	/**
	 * 分页查询首页轮播图
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<HomeBannerEntity> selectHomeBannerAllpage(PageEntity pageEntity); 
	/**
	 * 根据id查询首页轮播图
	 * @param id 首页轮播图id
	 * @return  homeBannerEntity 
	 */
	public  HomeBannerEntity  selectHomeBannerByID(int id);
	/**
	 * 前台查询首页轮播图 
	 * @return
	 */
	public List<HomeBannerEntity> selectHomeBannerfront(); 
	/**
	 * 查询首页轮播图 序号
	 * @return
	 */
	public int selectHomeBannerindex(); 
}
