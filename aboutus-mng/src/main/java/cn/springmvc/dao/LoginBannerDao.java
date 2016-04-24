package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.LoginBannerEntity;
/**
 * 
* @author 刘利 
* @Description: 登录界面轮播
* @since 
* @date 2016-3-19 下午9:44:08
 */
public interface LoginBannerDao {
	/**
	 * 添加登录界面轮播图
	 * @param entity  登录界面轮播图实体类
	 * @return	0：失败	1：成功
	 */
	public int insertLoginBanner(LoginBannerEntity entity); 
	
	/**
	 * 通过ID修改登录界面轮播图
	 * @param entity 登录界面轮播图实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateLoginBannerByID(LoginBannerEntity entity); 
	/**
	 * 通过ID删除登录界面轮播图
	 * @param id 登录界面轮播图id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteLoginBannerByID(long id);
	/**
	 * 查询登录界面轮播图列表
	 * @param map查询条件集合
	 * @return List<PartnersEntity> 
	 */
	public  List<LoginBannerEntity>  selectLoginBannerAll(Map<String, Object> map);
	
	/**
	 * 停用或启用登录界面轮播图
	 * @param entity 登录界面轮播图实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateLoginBannerStatuByID(LoginBannerEntity entity);
	/**
	 * 上移或下移登录界面轮播图
	 * @param entity 登录界面轮播图实体
	 * @return -1:失败 1：成功 
	 */
	public  int  moveAndDownLoginBannerByID(Map<String, Object> map);
	
	
}
