package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.NewEventEntity;
/**
 * 
* @author 刘利 
* @Description: 最新动态
* @since 
* @date 2016-3-19 下午9:46:24
 */
public interface NewEventListDao {
	/**
	 * 查询该名称的最新动态是否存在
	 * @param entity 最新动态实体
	 * @return  NewEventEntity 
	 */
	public  NewEventEntity  selectNewEventIsExistByNAme(NewEventEntity entity);
	/**
	 * 分页查询最新动态
	 * @param entity 最新动态实体
	 * @return
	 */
	public List<NewEventEntity> selectNewEventList(
			PageEntity pageEntity); 
	/**
	 * 根据id查询最新动态
	 * @param id 最新动态id
	 * @return  NewEventEntity 
	 */
	public  NewEventEntity  selectNewEventByID(long id);
}
