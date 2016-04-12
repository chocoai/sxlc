package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ExpertTeamEntity;
/**
 * 
* @author 刘利 
* @Description: 专家顾问查询接口
* @since 
* @date 2016-3-19 下午7:24:01
 */
public interface ExpertTeamListDao {
	/**
	 * 查询该名称的专家顾问是否存在
	 * @param entity 专家顾问实体
	 * @return  expertTeamEntity  专家顾问实体
	 */
	public  ExpertTeamEntity  selectExpertTeamIsExistByNAme(ExpertTeamEntity entity);
	/**
	 * 分页查询专家顾问
	 * @param pageEntity 分页实体类
	 * @return 专家顾问实体 列表
	 */
	public List<ExpertTeamEntity> selectExpertTeamAllpage(
			PageEntity pageEntity);
	/**
	 * 根据ID查询的专家顾问
	 * @param id 专家顾问id
	 * @return  expertTeamEntitys  专家顾问实体
	 */
	public  ExpertTeamEntity  selectExpertTeamByID(int id);
	/**
	 * 前台显示专家顾问 
	 * @return 专家顾问列表
	 */
	public List<ExpertTeamEntity> selectExpertTeamfront();
}
