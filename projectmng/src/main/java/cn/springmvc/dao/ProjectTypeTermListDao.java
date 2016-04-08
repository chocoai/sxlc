package cn.springmvc.dao;
 

import cn.springmvc.model.ProjectTypeTermEntity;
/**
 * 项目类型期限
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:50:03
 */
public interface ProjectTypeTermListDao { 
	/**
	 * 根据项目类型id，与借款类型（天、月、年）查询项目类型期限
	 * @param entity 项目类型期限实体
	 * @return  PartnersEntity 
	 */
	public  ProjectTypeTermEntity  selectProjectTypeTermById(ProjectTypeTermEntity entity);

	
}
