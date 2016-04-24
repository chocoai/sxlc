package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.FootNavBarTypeEntity;
 
/**
 * 
* @author 刘利 
* @Description: 底部导航条类型列表查询接口
* @since 
* @date 2016-3-19 下午7:52:03
 */
public interface FootNavBarTypeListDao {
	/**
	 * 分页查询底部导航条类型
	 * @param page 分页实体实体
	 * @return
	 */
	public List<FootNavBarTypeEntity> selectFootNavBarTypeList(PageEntity page); 
	/**
	 * 查询该名称的底部导航条类型是否存在
	 * @param entity 底部导航条类型实体
	 * @return  FootNavBarTypeEntity 
	 */
	public  FootNavBarTypeEntity  selectFootNavBarTypeIsExistByNAme(FootNavBarTypeEntity entity);
	/**
	 * 根据ID查询的底部导航条类型
	 * @param id 底部导航条类型ID
	 * @return  FootNavBarTypeEntity 
	 */
	public  FootNavBarTypeEntity  selectFootNavBarTypeByID(long id);
}
