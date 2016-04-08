package cn.springmvc.dao;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ProjectTypeGuideEntity;
/**
 * 项目类型申请指南
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:49:21
 */
public interface ProjectTypeGuideListDao {
	/**
	 * 查询该名称的项目类型申请指南是否存在
	 * @param entity 项目类型申请指南实体
	 * @return  ProjectTypeGuideEntity 
	 */
	public  ProjectTypeGuideEntity  selectProjectTypeGuideIsExistByNAme(ProjectTypeGuideEntity entity);
	/**
	 * 分页查询项目类型申请指南
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<ProjectTypeGuideEntity> selectProjectTypeGuideList(
			PageEntity pageEntity);
	/**
	 * 更具index查询项目类型申请指南
	 * @param entity 项目类型申请指南实体
	 * @return  ProjectTypeGuideEntity 
	 */
	public  ProjectTypeGuideEntity  selectProjectTypeGuideByindex(int id);
    /**
     * 查询项目类型申请指南序号
     * @author 刘利   
     * @Description: TODO 
     * @param @return 设定文件 
     * @return int 返回类型 
     * @date 2016-4-7 下午9:27:07
     */
	public int selectProjectTypeGuideEntityindex();
}
