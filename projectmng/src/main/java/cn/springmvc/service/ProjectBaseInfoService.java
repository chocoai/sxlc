package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.ProjectBaseInfoEntity;
  
import product_p2p.kit.pageselect.PageEntity; 
public interface ProjectBaseInfoService {
	/**
	 * 新增项目类型
	 * @param entity 项目类型实体,adminlogentity 后台会员操作日志实体 ,sIpInfo ip 详情
	 * @return 0：数据为空;-1：该名称的项目类型已存在;1:添加成功
	 */
	int insertProjectBaseInfo(ProjectBaseInfoEntity entity,
			ProjectBaseInfoEntity adminlogentity, String[] sIpInfo);
	/**
	 * 删除项目类型
	 * @param id 项目类型id
	 * @return 0：失败；1成功
	 */
	public int deleteProjectBaseInfoByID(int id); 
	/**
	 * 修改项目类型
	 * @param entity 项目类型实体 
	 * @return 0：失败；1成功;-1：该名称的项目类型已存在;
	 */
	public int updateProjectBaseInfoByID(ProjectBaseInfoEntity entity);
	 /**
	 * 停用或启用项目类型信息
	 * @param entity 项目类型实体 statu id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProjectBaseInfoStatuByID(ProjectBaseInfoEntity entity);
	/**
	 * 分页查询项目类型
	 * @param pageEntity 分页实体   map{projectName,statu(-1全部  0：停用 1：启用)}
	 * @return 项目类型列表
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoListpage(PageEntity pageEntity);
	/**
	 * 更具id查询项目类型
	 * @param entity 项目类型实体
	 * @return  PartnersEntity 
	 */
	public  ProjectBaseInfoEntity  selectProjectBaseInfoById(int id);
	/**
	 * 查询项目类型列表
	 * @param 
	 * @return
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoList();
	
}
