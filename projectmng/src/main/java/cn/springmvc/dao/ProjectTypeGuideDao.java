package cn.springmvc.dao;
import  cn.springmvc.model.ProjectTypeGuideEntity;
/**
 * 项目类型申请指南
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:49:11
 */
public interface ProjectTypeGuideDao {
	/**
	 * 添加项目类型申请指南
	 * @param entity  项目类型申请指南实体类
	 * @return	0：失败	1：成功
	 */
	public int insertProjectTypeGuide(ProjectTypeGuideEntity entity); 
	
	/**
	 * 通过index修改项目类型申请指南
	 * @param entity 项目类型申请指南实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateProjectTypeGuideByID(ProjectTypeGuideEntity entity); 
	/**
	 * 通过index删除项目类型申请指南
	 * @param id 项目类型申请指南id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteProjectTypeGuideByID(int id); 
	
}
