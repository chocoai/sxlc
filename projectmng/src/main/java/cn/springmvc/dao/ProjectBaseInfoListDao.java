package cn.springmvc.dao;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ProjectBaseInfoEntity;
/**
 * 项目类型
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:47:31
 */
public interface ProjectBaseInfoListDao {
	/**
	 * 查询该名称的项目类型是否存在
	 * @param entity 项目类型实体
	 * @return  ProjectBaseInfoEntity 
	 */
	public  ProjectBaseInfoEntity  selectProjectBaseInfoIsExistByNAme(ProjectBaseInfoEntity entity);
	/**
	 * 分页查询项目类型
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoAllpage(
			PageEntity pageEntity);
	/**
	 * 根据id查询项目类型
	 * @param entity 项目类型实体
	 * @return  PartnersEntity 
	 */
	public  ProjectBaseInfoEntity  selectProjectBaseInfoIsExistById(int id);
	/**
	 * 查询项目类型列表
	 * @param 
	 * @return
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoList();
	
}
