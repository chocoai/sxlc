package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.ActivitiesProjectEntity;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
public interface ActivitiesProjectService {
	/**
	 * 新增项目审批活动点
	 * @param entity 项目审批活动点实体
	 * @return 0：数据为空;-1：该名称的项目审批活动点已存在;1:添加成功 ,-2该权限已被绑定
	 */
	public int insertActivitiesProject(ActivitiesProjectEntity entity,
			InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 * 删除项目审批活动点
	 * @param id 项目审批活动点id 
	 * @return 0：失败；1成功
	 */
	public int deleteActivitiesProjectByID(int id,InsertAdminLogEntity 
			entityLog, String[] sIpInfo); 
	/**
	 * 修改项目审批活动点
	 * @param entity 项目审批活动点实体
	 * @return 0：失败；1成功 ,-1该名称已存在，-2该权限已被绑定
	 */
	public int updateActivitiesProjectByID(ActivitiesProjectEntity entity,
			InsertAdminLogEntity entityLog, String[] sIpInfo);
	 /**
	 * 停用或启用项目审批活动点信息
	 * @param entity 项目审批活动点实体 (statu 0：无效 1：有效)
	 * @return 0:失败 1：成功 
	 */
	public  int  updateActivitiesProjectStatuByID(ActivitiesProjectEntity entity,InsertAdminLogEntity 
			entityLog, String[] sIpInfo);
	/**
	 * 分页查询项目审批活动点
	 * @param pageEntity 分页实体  map{apName(活动点名称),statu( 0：无效 1：有效-1全部)}
	 * @return 项目审批活动点列表
	 */
	public List<ActivitiesProjectEntity> selectActivitiesProjectListpage(PageEntity pageEntity);
	/**
	 * 根据id查询审批活动点
	 * @param entity 项目审批活动点实体
	 * @return  ActivitiesProjectEntity  null不存在
	 */
	public  ActivitiesProjectEntity  selectActivitiesProjectByID(int id);
}
