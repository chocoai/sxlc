package cn.springmvc.dao;
import  cn.springmvc.model.ProjectBaseInfoEntity;
/**
 * 项目类型
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:42:50
 */
public interface ProjectBaseInfoDao {
	/**
	 * 添加项目类型
	 * @param entity  项目类型实体类
	 * @return	0：失败	1：成功
	 */
	public int insertProjectBaseInfo(ProjectBaseInfoEntity entity); 
	
	/**
	 * 通过ID修改项目类型信息
	 * @param entity 项目类型实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateProjectBaseInfoByID(ProjectBaseInfoEntity entity); 
	/**
	 * 通过ID删除项目类型信息
	 * @param id 项目类型id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteProjectBaseInfoByID(int id); 
	/**
	 * 停用或启用项目类型
	 * @param entity 项目类型实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProjectBaseInfoStatuByID(ProjectBaseInfoEntity entity);
}
