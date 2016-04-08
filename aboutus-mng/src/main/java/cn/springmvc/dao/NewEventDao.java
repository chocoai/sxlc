package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.NewEventEntity;
/**
 * 
* @author 刘利 
* @Description: 最新动态
* @since 
* @date 2016-3-19 下午9:46:16
 */
public interface NewEventDao {
	/**
	 * 添加最新动态
	 * @param entity  最新动态实体类
	 * @return	0：失败	1：成功
	 */
	public int insertNewEvent(NewEventEntity entity); 
	/**
	 * 通过ID修改最新动态
	 * @param entity 最新动态实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateNewEventByID(NewEventEntity entity); 
	/**
	 * 通过ID删除最新动态
	 * @param id 最新动态id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteNewEventByID(int id); 
	/**
	 * 停用或启用最新动态
	 * @param entity 最新动态实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateNewEventStatuByID(NewEventEntity entity); 
}
