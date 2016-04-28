package cn.springmvc.dao;

import java.util.List;  

import cn.springmvc.model.MemberAttestTypeEntity;
import cn.springmvc.model.ProjectTypeDatumEntity;
/**
 * 项目类型申请条件
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:49:01
 */
public interface ProjectTypeDatumListDao { 
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
}
