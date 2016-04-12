package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.ProcessProjectEntity;
import cn.springmvc.model.ProcessProjectEntity;
 

public interface ProcessProjectService {
	/**
	 * 新增项目审批流程
	 * @param entity 项目审批流程实体
	 * @return -1：该审批点已被停用;0：添加失败;1:添加成功
	 */
	public int insertProcessProject(ProcessProjectEntity entity,
			InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 * 删除项目审批流程
	 * @param id 项目审批流程id
	 * @return 0：失败；1成功
	 */
	public int deleteProcessProjectByID(int id);   
   /**
	 * 停用或启用项目审批流程信息
	 * @param entity 项目审批流程实体,实体里包含审批流程ID,与审批流程状态
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProcessProjectStatuByID(ProcessProjectEntity entity);
	/**
	 * 分页查询项目审批流程
	 * @param pageEntity 分页实体 
	 * @return
	 */
	public List<ProcessProjectEntity> selectProcessProjectListpage(PageEntity pageEntity);
	/**
	 * 上移或下移项目审批流程
	 * @param map集合 map集合   {iid(ID),flag(大于0上移,小于0下移)} 
	 * @return -1失败，1成功
	 */
	public int moveAndDownProcessProjectByID(Map<String, Object> map); 
	/**
	 * 根据id查询审批流程
	 * @param ProcessProjectEntity 审批流程实体
	 * @return
	 */
	public  ProcessProjectEntity  selectProcessProjectbyid(int id); 
}
