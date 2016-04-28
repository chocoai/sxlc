package cn.springmvc.dao;

import java.util.List;  

import cn.springmvc.model.ProjectPurposeSetEntity;
/**
 * 借款意向
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:48:09
 */
public interface ProjectPurposeSetListDao { 
	/**
	 * 查询借款意向配置列表 
	 * @return
	 */
	public List<ProjectPurposeSetEntity> selectProjectPurposeSetAllpage();
	/**
	 * 查询有效的借款意向配置列表 
	 * @return
	 */
	public List<ProjectPurposeSetEntity>  selectProjectPurposeSetValid();
}
