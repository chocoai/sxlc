package cn.springmvc.dao;



import cn.springmvc.model.RoleInfo;

/***
 * 角色
 * @author LiJie
 *
 */
public interface IRoleInfoDao {

	

	/****
	 * 添加角色
	 * @param info					角色实体信息			
	 * @param auths					权限
	 * @return
	 */
	public int saveRole(RoleInfo info,String auths);
	
	
	/****
	 * 修改角色
	 * @param info					角色信息
	 * @param auths					权限
	 * @return
	 */
	public int editRole(RoleInfo info,String auths);
	
	
	/***
	 * 移除角色信息
	 * 如果当前角色有用户使用则不能移除
	 * @param info					角色信息
	 * @return	
	 */
	public int remove(RoleInfo info);
	
	
	/***
	 * 停用启用角色信息
	 * @param info
	 * @return
	 */
	public int ofRole(RoleInfo info);
	
}
