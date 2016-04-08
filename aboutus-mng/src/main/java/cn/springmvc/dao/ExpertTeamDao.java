package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.ExpertTeamEntity;
/**
 * 
* @author 刘利 
* @Description: 专家顾问增删改接口
* @since 
* @date 2016-3-19 下午7:39:18
 */
public interface ExpertTeamDao {
	/**
	 * 添加专家顾问
	 * @param entity  专家顾问实体类
	 * @return	0：失败	1：成功
	 */
	public int insertExpertTeam(ExpertTeamEntity entity); 
	
	/**
	 * 通过ID修改专家顾问信息
	 * @param entity 专家顾问实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateExpertTeamByID(ExpertTeamEntity entity); 
	/**
	 * 通过ID删除专家顾问信息
	 * @param id 专家顾问id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteExpertTeamByID(int id); 
	/**
	 * 停用或启用专家顾问
	 * @param entity 专家顾问实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateExpertTeamStatuByID(ExpertTeamEntity entity);
	
}
