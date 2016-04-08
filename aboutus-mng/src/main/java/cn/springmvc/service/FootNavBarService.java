package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.FootNavBarEntity;
/**
 *   
* @author 刘利 
* @Description: 实现底部导航条增删改查功能
* @since 
* @date 2016-3-19 下午7:40:58
 */
public interface FootNavBarService {
	/**
	 * 新增底部导航条
	 * @param entity 底部导航条实体
	 * @return 0：数据为空;-1：该名称的底部导航条已存在;1:添加成功
	 */
	public int insertFootNavBar(FootNavBarEntity entity); 
	/**
	 * 删除底部导航条
	 * @param id 底部导航条id
	 * @return 0：失败；1成功
	 */
	public int deleteFootNavBarByID(int id); 
	/**
	 * 修改底部导航条
	 * @param entity 底部导航条实体
	 * @return 0：失败；1成功;-1：该名称的底部导航条已存在
	 */
	public int updateFootNavBarByID(FootNavBarEntity entity);
	 /**
	 * 停用或启用底部导航条信息
	 * @param entity 底部导航条实体 传statu(0无效，1有效),与id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateFootNavBarStatuByID(FootNavBarEntity entity);
	/**
	 * 分页查询底部导航条
	 * @param pageEntity 分页实体类  map 包含(title,statu(0无效，1有效,-1全部)) 
	 * @return
	 */
	public List<FootNavBarEntity> selectFootNavBarListpage(
			PageEntity pageEntity);
	/**
	 * 根据id查询底部导航条 
	 * @param id 底部导航条id
	 * @return  FootNavBarEntity 
	 */
	public  FootNavBarEntity  selectFootNavBarByID(int id);
	/**
	 * 前台显示底部导航条 
	 * @return
	 */
	public List<FootNavBarEntity> selectFootNavBarfront(); 
}
