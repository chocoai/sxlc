package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.FootNavBarTypeEntity; 
/**
 * 
* @author 刘利 
* @Description: 实现底部导航条类型模块新增，修改，删除功能
* @since 
* @date 2016-3-19 下午9:43:11
 */
public interface FootNavBarTypeDao {
	/**
	 * 添加底部导航条类型
	 * @param entity  底部导航条类型实体类
	 * @return	0：失败	1：成功
	 */
	public int insertFootNavBarType(FootNavBarTypeEntity entity);
 
	/**
	 * 通过ID修改底部导航条类型信息
	 * @param entity 底部导航条类型实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateFootNavBarTypeByID(FootNavBarTypeEntity entity); 
	/**
	 * 通过ID删除底部导航条类型信息
	 * @param id 底部导航条类型id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteFootNavBarTypeByID(int id); 
	
	/**
	 * 停用或启用底部导航条类型
	 * @param id 底部导航条类型ID
	 * @return 0:失败 1：成功 
	 */
	public  int  updateFootNavBarTypeStatuByID(FootNavBarTypeEntity entity);
 
	
}
