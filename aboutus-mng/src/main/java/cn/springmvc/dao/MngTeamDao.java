package cn.springmvc.dao;
 
import cn.springmvc.model.MngTeamEntity;
/**
 * 
* @author 刘利 
* @Description: 管理团队
* @since 
* @date 2016-3-19 下午9:45:59
 */
public interface MngTeamDao {
	/**
	 * 添加管理团队
	 * @param entity  管理团队实体类
	 * @return	0：失败	1：成功
	 */
	public int insertMngTeam(MngTeamEntity entity); 
	/**
	 * 通过ID修改管理团队信息
	 * @param entity 管理团队实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateMngTeamByID(MngTeamEntity entity); 
	/**
	 * 通过ID删除管理团队信息
	 * @param id 管理团队id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteMngTeamByID(long id); 
	/**
	 * 停用或启用管理团队
	 * @param entity 管理团队实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateMngTeamStatuByID(MngTeamEntity entity);
	
}
