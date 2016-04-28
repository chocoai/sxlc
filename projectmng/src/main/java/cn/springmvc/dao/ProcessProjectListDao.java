package cn.springmvc.dao;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ProcessProjectEntity;
/**
 * 项目审批流程
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:42:42
 */
public interface ProcessProjectListDao { 
	/**
	 * 分页查询项目审批流程
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<ProcessProjectEntity> selectProcessProjectAllpage(PageEntity pageEntity);
	/**
	 * 根据id查询审批流程
	 * @param ProcessProjectEntity 审批流程实体
	 * @return
	 */
	public  ProcessProjectEntity  selectProcessProjectbyid(int id); 
	/**
	 * 查询该查询改项目审批点是否有效
	 * @param apID 项目审批活动点ID
	 * @return  0 :无效，大于0：有效
	 */
	public  int  selectActivitiesProjectStatu(int apID);
	/**
	 * 查询审批流程的最大序号
	 * @return 
	 */
	public  int  selectProcessProjectindex();
}
