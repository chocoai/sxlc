package cn.springmvc.dao;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectBaseInfoEntity;
import cn.springmvc.model.ProjectTypeDatumEntity;
import cn.springmvc.model.ProjectTypeTermEntity;
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
	public  ProjectBaseInfoEntity  selectProjectBaseInfoentitybyID(long id);
	/**
	 * 查询项目类型列表
	 * @param 
	 * @return
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoList();
	/**
	 * 项目类型列表 下拉
	 * @param 
	 * @return
	 */
	public List<ProjectBaseInfoEntity> selectProjectBaseInfoCombox();
	/**
	 * 查询项目类型申请条件列表
	 * @param projectTypeDatumEntity 项目类型实体
	 * @return
	 */
	public List<ProjectTypeDatumEntity> selectProjectTypeDatumAllpage(ProjectTypeDatumEntity projectTypeDatumEntity);
	
	/**
	 * 查询项目类型所需认证项
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectType
	 * @param @return 设定文件 
	 * @return List<MemberAttestTypeEntity> 返回类型 
	 * @date 2016-4-22 下午2:17:30
	 */
	public List<MemberAttestTypeEntity> selectMemberAttestByprojectType(long projectType);
	/**
	 * 根据项目类型id，与借款类型（天、月、年）查询项目类型期限
	 * @param entity 项目类型期限实体
	 * @return  ProjectTypeTermEntity 
	 */
	public  ProjectTypeTermEntity  selectProjectTypeTermById(ProjectTypeTermEntity entity);

	/**
	 * 根据项目类型id查询项目类型期限
	 * @param projectID 项目类型ID
	 * @return  List<ProjectTypeTermEntity>
	 */
	public  List<ProjectTypeTermEntity>  selectProjectTypeTermByID(long projectID);
}
