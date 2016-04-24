package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.Admin;

public interface IAdminReadDao {

	
	

	
	
	/***
	 * 根据条件获取管理率列表
	 * @param param				条件
	 * @return
	 */
	public List<Admin> getAdminsByParam(PageEntity entity);

	
	/***
	* 获取管理员详细信息
	* 
	* @author 李杰
	* @param adminId			管理员编号
	* @return
	* @date 2016-4-19 下午5:56:30
	 */
	public Admin findAdminById(long adminId);

	
	
	
	
	
	
}
