package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.RegisterBannerEntity;
/**
 * 注册界面轮播图
* @author 刘利 
* @Description: 注册界面轮播图 
* @since 
* @date 2016-3-19 下午9:48:37
 */
public interface RegisterBannerDao {
	/**
	 * 添加注册界面轮播图
	 * @param entity  注册界面轮播图实体类
	 * @return	0：失败	1：成功
	 */
	public int insertRegisterBanner(RegisterBannerEntity entity); 
	
	/**
	 * 通过ID修改注册界面轮播图
	 * @param entity 注册界面轮播图实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateRegisterBannerByID(RegisterBannerEntity entity); 
	/**
	 * 通过ID删除注册界面轮播图
	 * @param id 注册界面轮播图id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteRegisterBannerByID(int id);
	/**
	 * 查询注册界面轮播图列表
	 * @param map查询条件集合
	 * @return List<PartnersEntity> 
	 */
	public  List<RegisterBannerEntity>  selectRegisterBannerAll(Map<String, Object> map);
	
	/**
	 * 停用或启用注册界面轮播图
	 * @param entity 注册界面轮播图实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateRegisterBannerStatuByID(RegisterBannerEntity entity);
	/**
	 * 上移或下移注册界面轮播图
	 * @param entity 注册界面轮播图实体
	 * @return -1:失败 1：成功 
	 */
	public  int  moveAndDownRegisterBannerByID(Map<String, Object> map);
}
