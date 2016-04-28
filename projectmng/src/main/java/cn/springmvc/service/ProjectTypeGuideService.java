package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.ProjectTypeGuideEntity;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
public interface ProjectTypeGuideService {
	/**
	 * 新增项目类型申请指南
	 * @param entity 项目类型申请指南实体
	 * @return 0：数据为空;-1：该名称的项目类型申请指南已存在;1:添加成功
	 */
	public int insertProjectTypeGuide(ProjectTypeGuideEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除项目类型申请指南
	 * @param index 指南序号
	 * @return 0：失败；1成功
	 */
	public int deleteProjectTypeGuideByIndex(int index,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 修改项目类型申请指南
	 * @param entity 项目类型申请指南实体
	 * @return 0：失败；1成功;-1：该名称的项目类型申请指南已存在;
	 */
	public int updateProjectTypeGuideByIndex(ProjectTypeGuideEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 分页查询项目类型申请指南
	 * @param pageEntity 分页实体  {projectType:项目类型ID}
	 * @return 项目类型申请指南列表
	 */
	public List<ProjectTypeGuideEntity> selectProjectTypeGuideListpage(PageEntity pageEntity);
	/**
	 * 更具index查询项目类型申请指南
	 * @param index 指南序号
	 * @return  PartnersEntity 
	 */
	public  ProjectTypeGuideEntity  selectProjectTypeGuideByindex(int index);
	/**
	 * 前台查询项目类型 申请指南列表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param projectType 项目申请ID
	 * @param @return 设定文件 
	 * @return List<ProjectTypeGuideEntity> 返回类型 
	 * @date 2016-4-22 下午2:00:45
	 */
	public  ProjectTypeGuideEntity  selectProjectTypeGuideListfront(long projectType);
}
