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

	
	
	
	
	
	
}
