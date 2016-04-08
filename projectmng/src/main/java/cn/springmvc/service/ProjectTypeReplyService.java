package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.ProjectTypeReplyEntity;
 
import product_p2p.kit.pageselect.PageEntity; 
public interface ProjectTypeReplyService {
	/**
	 * 新增项目类型还款指南
	 * @param entity 项目类型还款指南实体
	 * @return 0：数据为空;-1：该名称的项目类型还款指南已存在;1:添加成功
	 */
	public int insertProjectTypeReply(ProjectTypeReplyEntity entity); 
	/**
	 * 删除项目类型还款指南
	 * @param id 项目类型还款指南id
	 * @return 0：失败；1成功
	 */
	public int deleteProjectTypeReplyByID(int id); 
	/**
	 * 修改项目类型还款指南
	 * @param entity 项目类型还款指南实体
	 * @return 0：失败；1成功;-1：该名称的项目类型还款指南已存在;
	 */
	public int updateProjectTypeReplyByID(ProjectTypeReplyEntity entity); 
	/**
	 * 分页查询项目类型还款指南
	 * @param pageEntity 分页实体  
	 * @return 项目类型还款指南列表
	 */
	public List<ProjectTypeReplyEntity> selectProjectTypeReplyListpage(PageEntity pageEntity);
	/**
	 * 更具id查询项目类型还款指南
	 * @param entity 项目类型还款指南实体
	 * @return  PartnersEntity 
	 */
	public  ProjectTypeReplyEntity  selectProjectTypeReplyById(int id);
}
