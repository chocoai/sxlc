package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.ProjectPurposeSetEntity;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity; 
public interface ProjectPurposeSetService {
	/**
	 * 新增借款意向配置
	 * @param entity 借款意向配置实体
	 * @return 0：数据为空;-1：该名称的借款意向配置已存在;1:添加成功
	 */
	public int insertProjectPurposeSet(List<ProjectPurposeSetEntity> entity,
			InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 * 删除借款意向配置
	 * @param type 借款意向配置类型
	 * @return 0：失败；1成功
	 */
	public int deleteProjectPurposeSetByType(); 
	/**
	 * 选择借款意向配置
	 * @param list 借款意向配置Type
	 * @return 0：失败；1成功
	 */
	public int updateProjectPurposeSetByType(List<Integer> list,InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 *  查询借款意向配置列表 
	 * @return 借款意向配置列表
	 */
	public List<ProjectPurposeSetEntity> selectProjectPurposeSetListpage();
	/**
	 * 查询有效的借款意向配置列表 
	 * @return
	 */
	public List<ProjectPurposeSetEntity>  selectProjectPurposeSetValid();
	 
}
