package cn.springmvc.dao;
import java.util.List;

import  cn.springmvc.model.ProjectPurposeSetEntity;
/**
 * 借款意向
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:47:51
 */
public interface ProjectPurposeSetDao {
	/**
	 * 添加借款意向配置
	 * @param entity  借款意向配置实体类
	 * @return	0：失败	1：成功
	 */
	public int insertProjectPurposeSet(ProjectPurposeSetEntity entity); 
	 
	/**
	 * 通过借款意向类型删除借款意向配置信息
	 * @param optionType 借款意向配置id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteProjectPurposeSetBytype(); 
	/**
	 * 选择借款意向配置
	 * @param entity 借款意向配置实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProjectPurposeSetStatuCheck(List<Integer> list);
	/**
	 * 停用全部借款意向
	 * @param entity 借款意向配置实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateProjectPurposeSetStatu();
}
