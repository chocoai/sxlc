package cn.springmvc.dao;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ActivitiesProjectEntity;
/**
 * 
* @author 刘利 
* @Description: 审批活动 
* @since 
* @date 2016-3-19 下午10:21:22
 */
public interface ActivitiesProjectListDao {
	/**
	 * 查询该名称的项目审批活动点是否存在
	 * @param entity 项目审批活动点实体
	 * @return  activitiesProjectEntity  null不存在
	 */
	public  ActivitiesProjectEntity  selectActivitiesProjectIsExistByNAme(ActivitiesProjectEntity entity);
	/**
	 * 分页查询项目审批活动点
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<ActivitiesProjectEntity> selectActivitiesProjectAllpage(
			PageEntity pageEntity);
	/**
	 * 查询该名称的权限是否被其他的项目审批活动点绑定
	 * @param entity 项目审批活动点实体
	 * @return  0 :没有被绑定，大于0：已被绑定 
	 */
	public  int  selectActivitiesProjectRoleIsExist(ActivitiesProjectEntity entity);
	/**
	 * 根据id查询审批活动点
	 * @param entity 项目审批活动点实体
	 * @return  PartnersEntity  null不存在
	 */
	public  ActivitiesProjectEntity  selectActivitiesProjectByID(long id); 
	
}
