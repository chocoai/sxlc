package cn.springmvc.dao;
import  cn.springmvc.model.ActivitiesProjectEntity;
/** 
* 项目审批配置
* @author 刘利
* @Description: 实现项目审批点的增加、修改、删除功能
* @since 
* @date 2016-3-15 下午9:30:00 
*  */
public interface ActivitiesProjectDao {
	/**
	 * 添加项目审批活动点
	 * @param entity  项目审批活动点实体类
	 * @return	0：失败	1：成功,-1该名称已存在，-2该权限已被绑定
	 */
	public int insertActivitiesProject(ActivitiesProjectEntity entity); 
	
	/**
	 * 通过ID修改项目审批活动点信息
	 * @param entity 项目审批活动点实体
	 * @return  0:失败 1：成功 ,-1该名称已存在，-2该权限已被绑定
	 */
	public  int  updateActivitiesProjectByID(ActivitiesProjectEntity entity); 
	/**
	 * 通过ID删除项目审批活动点信息
	 * @param id 项目审批活动点id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteActivitiesProjectByID(int id); 
	/**
	 * 停用或启用项目审批活动点
	 * @param entity 项目审批活动点实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateActivitiesProjectStatuByID(ActivitiesProjectEntity entity);
}
