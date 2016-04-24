package cn.springmvc.dao;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.MngTeamEntity;
/**
 * 
* @author 刘利 
* @Description: 管理团队
* @since 
* @date 2016-3-19 下午9:46:05
 */
public interface MngTeamListDao {
	/**
	 * 查询该名称的管理团队是否存在
	 * @param entity 管理团队实体
	 * @return  mngTeamEntity 
	 */
	public  MngTeamEntity  selectMngTeamIsExistByNAme(MngTeamEntity entity);
	/**
	 * 分页查询管理团队
	 * @param pageEntity 分页实体
	 * @return
	 */
	public List<MngTeamEntity> selectMngTeamAllpage(
			PageEntity pageEntity);
	/**
	 * 根据id查询管理团队
	 * @param id 管理团队id
	 * @return  mngTeamEntity 
	 */
	public  MngTeamEntity  selectMngTeamByID(long id);
}
