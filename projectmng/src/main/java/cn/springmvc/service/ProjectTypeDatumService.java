package cn.springmvc.service;

import java.util.List;
 
import cn.springmvc.model.ProjectTypeDatumEntity;
  /**
   * 
   * @author 刘利 
   * @Description: 项目类型申请条件
   */
public interface ProjectTypeDatumService {
	/**
	 * 添加项目类型申请条件
	 * @param list  项目类型申请条件列表,projectType 项目类型ID
	 * @return	0：失败	1：成功
	 */
	public int insertProjectTypeDatum(List<ProjectTypeDatumEntity> list,int projectType); 
	  
	/**
	 * 查询项目类型申请条件列表
	 * @param projectType 项目类型ID
	 * @return
	 */
	public List<ProjectTypeDatumEntity> selectMemberAttestTypeList(ProjectTypeDatumEntity projectTypeDatumEntity);
 
}
