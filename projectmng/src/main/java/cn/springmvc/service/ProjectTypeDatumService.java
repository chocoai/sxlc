package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
 
import cn.springmvc.model.MemberAttestTypeEntity;
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
	public int insertProjectTypeDatum(List<ProjectTypeDatumEntity> list,int projectType,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	  
	/**
	 * 查询项目类型申请条件列表
	 * @param projectType 项目类型ID
	 * @return
	 */
	public List<ProjectTypeDatumEntity> selectMemberAttestTypeList(ProjectTypeDatumEntity projectTypeDatumEntity);
	
	/**
	 * 查询项目类型所需认证项
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param projectType项目类型ID
	 * @param @return 设定文件 
	 * @return List<MemberAttestTypeEntity> 返回类型 
	 * @date 2016-4-22 下午2:17:30
	 */
	public List<MemberAttestTypeEntity> selectMemberAttestByprojectType(long projectType);
}
