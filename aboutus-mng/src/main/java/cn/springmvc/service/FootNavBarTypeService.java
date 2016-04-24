package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.FootNavBarTypeEntity;
  /**
   * 
  * @author 刘利 
  * @Description: 底部导航条类型的增删改查功能 
  * @since 
  * @date 2016-3-19 下午7:52:56
   */
public interface FootNavBarTypeService {
	/**
	 * 新增底部导航条类型
	 * @param entity 底部导航条类型实体
	 * @return 0：数据为空;-1：该名称的底部导航条类型已存在;1:添加成功
	 */
	public int insertFootNavBarType(FootNavBarTypeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除底部导航条类型
	 * @param id 底部导航条类型id
	 * @return 0：失败；1成功
	 */
	public int deleteFootNavBarTypeByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 修改底部导航条类型
	 * @param entity 底部导航条类型实体
	 * @return 0：失败；1成功;-1：该名称的底部导航条类型已存在;
	 */
	public int updateFootNavBarTypeByID(FootNavBarTypeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	 /**
	 * 停用或启用底部导航条类型信息
	 * @param entity 底部导航条类型实体 传statu(0无效，1有效),与id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateFootNavBarTypeStatuByID(FootNavBarTypeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 分页查询底部导航条类型
	 * @param pageEntity 分页实体类  map 包含(name,statu：(0无效，1有效,-1全部))
	 * @return
	 */
	public List<FootNavBarTypeEntity> selectFootNavBarTypeListpage(
			PageEntity pageEntity);
	/**
	 * 根据ID查询的底部导航条类型
	 * @param id 底部导航条类型ID
	 * @return  FootNavBarTypeEntity 
	 */
	public  FootNavBarTypeEntity  selectFootNavBarTypeByID(long id);
}
