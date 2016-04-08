package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.LoginBannerEntity;
/**
 * 
* @author 刘利 
* @Description: 登录界面轮播图
* @since 
* @date 2016-3-19 下午9:44:29
 */
public interface LoginBannerListDao {
	/**
	 * 查询该名称的登录界面轮播图是否存在
	 * @param entity 登录界面轮播图实体
	 * @return  LoginBannerEntity 
	 */
	public  LoginBannerEntity  selectLoginBannerIsExistByNAme(LoginBannerEntity entity);
	/**
	 * 分页查询登录界面轮播图
	 * @param pageEntity 分页实体
	 * @return
	 */
	public List<LoginBannerEntity> selectLoginBannerAllpage(PageEntity pageEntity); 
	/**
	 * 根据id查询登录界面轮播图
	 * @param id 登录界面轮播图id
	 * @return  LoginBannerEntity 
	 */
	public  LoginBannerEntity  selectLoginBannerByID(int id);
	/**
	 * 登录界面轮播图前台 
	 * @return
	 */
	public List<LoginBannerEntity> selectLoginBannerfront(); 
	/**
	 * 查询登录界面轮播图序号
	 * @return
	 */
	public int selectLoginBannerindex(); 
}
