package cn.springmvc.dao;
import  cn.springmvc.model.ProjectTypeTermEntity;
/**
 * 项目类型期限
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:49:50
 */
public interface ProjectTypeTermDao {
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
