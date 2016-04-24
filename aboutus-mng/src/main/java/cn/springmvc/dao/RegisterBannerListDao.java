package cn.springmvc.dao;

import java.util.List; 
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.RegisterBannerEntity;
/**
 * 注册界面轮播图
* @author 刘利 
* @Description: 注册界面轮播图 
* @since 
* @date 2016-3-19 下午9:48:47
 */
public interface RegisterBannerListDao {
	/**
	 * 查询该名称的注册界面轮播图是否存在
	 * @param entity 注册界面轮播图实体
	 * @return  registerBannerEntity 
	 */
	public  RegisterBannerEntity  selectRegisterBannerIsExistByNAme(RegisterBannerEntity entity);
	/**
	 * 分页查询注册界面轮播图
	 * @param  pageEntity 分页实体类
	 * @return
	 */
	public List<RegisterBannerEntity> selectRegisterBannerAllpage(PageEntity pageEntity);
	/**
	 * 根据id查询注册界面轮播图
	 * @param id 注册界面轮播图id
	 * @return  registerBannerEntity 
	 */
	public  RegisterBannerEntity  selectRegisterBannerByID(int id);
	/**
	 * 前台查询注册界面轮播图
	 * @param  pageEntity 分页实体类
	 * @return
	 */
	public List<RegisterBannerEntity> selectRegisterBannerfront();
	/**
	 * 前台查询注册界面轮播图序号
	 * @return
	 */
	public int selectRegisterBannerindex();

}
