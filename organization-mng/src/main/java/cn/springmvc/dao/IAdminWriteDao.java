package cn.springmvc.dao;

import java.util.Map;

public interface IAdminWriteDao {

	
	
	/****
	 * 添加一个管理员实体信息
	 * @return
	 */
	public int saveAdmin(Map<String,Object> param);
	
	
	
	
	/***
	 * 修改管理员信息
	 * @param param				管理员信息
	 * @return
	 */
	public int editAdmin(Map<String,Object> param);
	
	
	
	
	/***
	 * 停用启用管理员
	 * @param param				管理员信息
	 * @return
	 */
	public int ofAdmin(Map<String,Object> param);




	/***
	* 修改管理员密码
	* 
	* @author 李杰
	* @Title: editAdminPassword
	* @param param
	* @return
	* @date 2016-4-6 上午10:38:22
	 */
	public int editAdminPassword(Map<String, Object> param);
	
	
}
