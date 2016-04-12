package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.NewEventEntity;

import com.github.pagehelper.PageInfo;
/**
 * 
* @author 刘利 
* @Description: 最新动态
* @since 
* @date 2016-3-19 下午10:07:26
 */
public interface NewEventService {
	/**
	 * 新增最新动态
	 * @param entity 最新动态实体
	 * @return 0：数据为空;-1：该名称的最新动态已存在;1:添加成功
	 */
	public int insertNewEvent(NewEventEntity entity); 
	/**
	 * 删除最新动态
	 * @param id 最新动态id
	 * @return 0：失败；1成功
	 */
	public int deleteNewEventByID(int id); 
	/**
	 * 修改最新动态
	 * @param entity 最新动态实体
	 * @return 0：失败；1成功;-1：该名称的最新动态已存在
	 */
	public int updateNewEventByID(NewEventEntity entity);
	 /**
	 * 停用或启用最新动态信息
	 * @param entity 最新动态实体  statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 ;
	 */
	public  int  updateNewEventStatuByID(NewEventEntity entity);
	/**
	 * 分页查询最新动态
	 * @param pageEntity 分页查询实体类 map{title,startTime,endTime,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<NewEventEntity> selectNewEventListpage(PageEntity pageEntity);
	/**
	 * 根据id查询最新动态
	 * @param id 最新动态id
	 * @return  NewEventEntity 
	 */
	public  NewEventEntity  selectNewEventByID(int id);
}
