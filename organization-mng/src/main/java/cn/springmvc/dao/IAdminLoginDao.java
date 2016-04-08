package cn.springmvc.dao;

import java.util.Map;

import cn.springmvc.model.Admin;

public interface IAdminLoginDao {

	
	/**
	 * 管理员登录
	 * 创建日期：2016-3-29下午6:39:55
	 * 修改日期：
	 * 作者：pengran
	 * @param adminName adminPwd  
	 * return int
	 */
	public int Login(Map<String, Object> param);
	
	
	/**
	 * 登录人信息
	 * 创建日期：2016-3-30下午7:15:17
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return Admin
	 */
	public Admin adminMess(Map<String, Object> param);
	/**
	 * 
	 * 创建日期：2016-3-29下午7:45:19
	 * 修改日期：
	 * 作者：pengran
	 * @param adminName oldPwd  newPwd
	 * return int
	 */
	public int updatePwd(String adminName,String oldPwd,String newPwd);
}
