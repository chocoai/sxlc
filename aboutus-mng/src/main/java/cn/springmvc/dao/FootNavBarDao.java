package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.FootNavBarEntity; 
/**
 * 
* @author 刘利 
* @Description: 实现底部导航条模块新增，修改，删除功能 
* @since 
* @date 2016-3-19 下午7:39:00
 */
public interface FootNavBarDao {
	/**
	 * 添加底部导航条
	 * @param entity  底部导航条实体类
	 * @return	0：失败	1：成功
	 */
	public int insertFootNavBar(FootNavBarEntity entity);
 
	/**
	 * 通过ID修改底部导航条信息
	 * @param entity 底部导航条实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateFootNavBarByID(FootNavBarEntity entity); 
	/**
	 * 通过ID删除底部导航条信息
	 * @param id 底部导航条id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteFootNavBarByID(int id); 
	
	/**
	 * 停用或启用底部导航条
	 * @param entity 底部导航条实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateFootNavBarStatuByID(FootNavBarEntity entity);
	
}
