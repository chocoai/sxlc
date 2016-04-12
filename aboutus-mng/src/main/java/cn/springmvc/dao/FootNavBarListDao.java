package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.FootNavBarEntity;
/**
 * 
* @author 刘利 
* @Description: 底部导航条列表查询接口
* @since 
* @date 2016-3-19 下午9:42:59
 */
public interface FootNavBarListDao {
	/**
	 * 分页查询底部导航条
	 * @param page 分页实体实体
	 * @return
	 */
	public List<FootNavBarEntity> selectFootNavBarList(PageEntity page); 
	/**
	 * 查询该名称的底部导航条是否存在
	 * @param entity 底部导航条实体
	 * @return  FootNavBarEntity 
	 */
	public  FootNavBarEntity  selectFootNavBarIsExistByNAme(FootNavBarEntity entity);
	/**
	 * 根据id查询底部导航条 
	 * @param id 底部导航条id
	 * @return  FootNavBarEntity 
	 */
	public  FootNavBarEntity  selectFootNavBarByID(int id);
	/**
	 * 前台显示底部导航条 
	 * @return
	 */
	public List<FootNavBarEntity> selectFootNavBarfront(); 
}
