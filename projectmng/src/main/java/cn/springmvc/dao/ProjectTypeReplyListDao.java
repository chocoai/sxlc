package cn.springmvc.dao;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ProjectTypeReplyEntity;
/**
 * 项目类型还款指南
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:49:44
 */
public interface ProjectTypeReplyListDao {
	/**
	 * 查询该名称的项目类型还款指南是否存在
	 * @param entity 项目类型还款指南实体
	 * @return  ProjectTypeReplyEntity 
	 */
	public  ProjectTypeReplyEntity  selectProjectTypeReplyIsExistByNAme(ProjectTypeReplyEntity entity);
	/**
	 * 分页查询项目类型还款指南
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<ProjectTypeReplyEntity> selectProjectTypeReplyList(
			PageEntity pageEntity);
	/**
	 * 根据index查询项目类型还款指南
	 * @param index 序号
	 * @return  ProjectTypeReplyEntity 
	 */
	public  ProjectTypeReplyEntity  selectProjectTypeReplyByindex(int index);
	/**
	 * 查询还款指南序号
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-7 下午9:12:47
	 */
    public int selectProjectTypeReplyEntityindex();
    /**
	 * 前台查询项目类型还款指南列表 
	 * @param projectType 项目类型ID
	 * @return
	 */
	public  ProjectTypeReplyEntity  selectProjectTypeReplyListfront(long projectType);
	
}
