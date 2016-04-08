package cn.springmvc.dao;

import java.util.List;  

import cn.springmvc.model.ProjectTypeDatumEntity;
/**
 * 项目类型申请条件
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:49:01
 */
public interface ProjectTypeDatumListDao { 
	/**
	 * 查询项目类型申请条件列表
	 * @param projectTypeDatumEntity 项目类型实体
	 * @return
	 */
	public List<ProjectTypeDatumEntity> selectProjectTypeDatumAllpage(ProjectTypeDatumEntity projectTypeDatumEntity);  
}
