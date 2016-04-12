package cn.springmvc.dao;
import java.util.List;

import  cn.springmvc.model.ProjectTypeDatumEntity;
/**
 * 项目类型申请
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:48:19
 */
public interface ProjectTypeDatumDao {
	/**
	 * 添加项目类型申请条件
	 * @param list  项目类型申请条件列表
	 * @return	0：失败	1：成功
	 */
	public int insertProjectTypeDatum(List<ProjectTypeDatumEntity> list);  
	/**
	 * 通过项目类型ID删除项目类型申请条件信息
	 * @param id 项目类型ID
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteProjectTypeDatumByID(int id);  
}
