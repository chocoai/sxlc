package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.ExpertTeamEntity;

import com.github.pagehelper.PageInfo;
/**
 * 
* @author 刘利 
* @Description: 实现专家顾问的增删改查功能
* @since 
* @date 2016-3-19 下午7:28:53
 */
public interface ExpertTeamService {
	/**
	 * 新增专家顾问
	 * @param entity 专家顾问实体
	 * @return 0：数据为空;-1：该名称的专家顾问已存在;1:添加成功
	 */
	public int insertExpertTeam(ExpertTeamEntity entity); 
	/**
	 * 删除专家顾问
	 * @param id 专家顾问id
	 * @return 0：失败；1成功
	 */
	public int deleteExpertTeamByID(int id); 
	/**
	 * 修改专家顾问
	 * @param entity 专家顾问实体
	 * @return 0：失败；1成功;-1：该名称的专家顾问已存在;
	 */
	public int updateExpertTeamByID(ExpertTeamEntity entity);
	 /**
	 * 停用或启用专家顾问信息
	 * @param entity 专家顾问实体,传statu (0无效，1有效) ,与id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateExpertTeamStatuByID(ExpertTeamEntity entity);
	/**
	 * 分页查询专家顾问
	 * @param pageEntity 分页实体 map 包含(mngName,statu:(0无效，1有效,-1全部)) 
	 * @return 专家顾问列表
	 */
	public List<ExpertTeamEntity> selectExpertTeamListpage(PageEntity pageEntity);
	/**
	 * 根据ID查询的专家顾问
	 * @param id 专家顾问id
	 * @return  expertTeamEntity 专家顾问实体
	 */
	public  ExpertTeamEntity  selectExpertTeamByID(int id);
	/**
	 * 前台显示专家顾问 
	 * @return 专家顾问列表
	 */
	public List<ExpertTeamEntity> selectExpertTeamfront();
}
