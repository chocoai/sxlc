package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.Admin;


/**
 * @author pengran
 *  管理员登录逻辑层
 * @date:2016-3-29 下午6:53:38
 **/
public interface IAdminLoginService {
	
	
	
	/**
	 * 管理员登录
	 * 创建日期：2016-3-29下午6:54:08
	 * 修改日期：
	 * 作者：pengran
	 * return int
	 */
	public int adminLogin(Map<String,Object> param);
	
	
	/**
	 * 登录人信息
	 * 创建日期：2016-3-30下午7:15:17
	 * 修改日期：
	 * 作者：pengran
	 * @param
	 * return Admin
	 */
	public Admin adminMess(Map<String,Object> param);
	/**
	 * 修改管理员密码
	 * 创建日期：2016-3-29下午6:54:18
	 * 修改日期：
	 * 作者：pengran
	 * return int
	 */
	public int updatePwd(String adminName,String oldPwd,String newPwd);

}
