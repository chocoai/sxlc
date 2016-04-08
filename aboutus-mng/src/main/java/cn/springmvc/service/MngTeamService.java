package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.MngTeamEntity;

import com.github.pagehelper.PageInfo;
/**
 * 管理团队
* @author 刘利 
* @Description: 管理团队 
* @since 
* @date 2016-3-19 下午10:07:10
 */
public interface MngTeamService {
	/**
	 * 新增管理团队
	 * @param entity 管理团队实体
	 * @return 0：数据为空;-1：该名称的管理团队已存在;1:添加成功
	 */
	public int insertMngTeam(MngTeamEntity entity); 
	/**
	 * 删除管理团队
	 * @param id 管理团队id
	 * @return 0：失败；1成功
	 */
	public int deleteMngTeamByID(int id); 
	/**
	 * 修改管理团队
	 * @param entity 管理团队实体
	 * @return 0：失败；1成功
	 */
	public int updateMngTeamByID(MngTeamEntity entity);
	 /**
	 * 停用或启用管理团队信息
	 * @param entity 管理团队实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateMngTeamStatuByID(MngTeamEntity entity);
	/**
	 * 分页查询管理团队
	 * @param pageEntity 分页实体   map{mngName,startTime,endTime,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<MngTeamEntity> selectMngTeamListpage(
			PageEntity pageEntity);
	/**
	 * 根据id查询管理团队
	 * @param id 管理团队id
	 * @return  mngTeamEntity 
	 */
	public  MngTeamEntity  selectMngTeamByID(int id);
}
