package cn.springmvc.service;
  
import cn.springmvc.model.ProjectTypeTermEntity;
/**
 * 
 * @author 刘利 
 * @Description: 项目类型期限
 */
public interface ProjectTypeTermService {
	/**
	 * 根据项目类型id，与借款类型（天、月、年）查询项目类型期限
	 * @param entity 项目类型期限实体
	 * @return  PartnersEntity 
	 */
	public  ProjectTypeTermEntity  selectProjectTypeTermById(ProjectTypeTermEntity entity);
	/**
	 * 添加项目类型期限
	 * @param entity  项目类型期限实体类
	 * @return	0：失败	1：成功
	 */
	public int insertProjectTypeTerm(ProjectTypeTermEntity entity); 
	
	/**
	 * 通过ID，与借款类型天、月、年标修改项目类型期限信息
	 * @param entity 项目类型期限实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateProjectTypeTermByID(ProjectTypeTermEntity entity); 
}
