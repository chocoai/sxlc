package cn.springmvc.dao;
 
import java.util.Map;

import cn.springmvc.model.ProcessProjectEntity;
/**
 * 项目审批流程
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:42:31
 */
public interface ProcessProjectDao {
	/**
	 * 添加项目审批流程
	 * @param entity  项目审批流程实体类
	 * @return	0：失败	1：成功  
	 */
	public int insertProcessProject(ProcessProjectEntity entity);
	/**
	 * 通过ID删除项目审批流程
	 * @param id 项目审批流程id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteProcessProjectByID(int id);
	/**
	 * 停用或启用项目审批流程
	 * @param entity 项目审批流程实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProcessProjectStatuByID(ProcessProjectEntity entity);
	/**
	 * 上移或下移项目审批流程
	 * @param entity 项目审批流程实体
	 * @return -1:失败 1：成功 
	 */
	public  int  moveAndDownProcessProjectByID(Map<String, Object> map);
	
}
