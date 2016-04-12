package cn.springmvc.dao;
import  cn.springmvc.model.ProjectTypeReplyEntity;
/**
 * 项目类型还款指南
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:49:27
 */
public interface ProjectTypeReplyDao {
	/**
	 * 添加项目类型还款指南
	 * @param entity  项目类型还款指南实体类
	 * @return	0：失败	1：成功
	 */
	public int insertProjectTypeReply(ProjectTypeReplyEntity entity); 
	
	/**
	 * 通过index修改项目类型还款指南
	 * @param entity 项目类型还款指南实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateProjectTypeReplyByID(ProjectTypeReplyEntity entity); 
	/**
	 * 通过index删除项目类型还款指南
	 * @param id 项目类型还款指南id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteProjectTypeReplyByID(int id); 
	
}
