package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.SafetyCertificationEntity;
  /**
   * 
  * @author 刘利 
  * @Description: 底部网站认证
  * @since 
  * @date 2016-3-19 下午10:08:35
   */
public interface SafetyCertificationService {
	/**
	 * 新增底部网站认证
	 * @param entity 底部网站认证实体
	 * @return 0：数据为空;-1：该名称的底部网站认证已存在;1:添加成功
	 */
	public int insertSafetyCertification(SafetyCertificationEntity entity); 
	/**
	 * 删除底部网站认证
	 * @param id 底部网站认证id
	 * @return 0：失败；1成功
	 */
	public int deleteSafetyCertificationByID(int id); 
	/**
	 * 修改底部网站认证
	 * @param entity 底部网站认证实体
	 * @return 0：失败；1成功;-1：该名称的底部网站认证已存在
	 */
	public int updateSafetyCertificationByID(SafetyCertificationEntity entity);
	 /**
	 * 停用或启用底部网站认证信息
	 * @param entity 底部网站认证实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateSafetyCertificationStatuByID(SafetyCertificationEntity entity);
	/**
	 * 分页查询底部网站认证
	 * @param pageEntity 分页实体类  map{title,statu(0:无效 1：有效,-1全部)}
	 */
	public List<SafetyCertificationEntity> selectSafetyCertificationList(
			PageEntity pageEntity);
	/**
	 * 根据查询底部网站认证
	 * @param id 底部网站认证id
	 * @return  safetyCertificationEntity 
	 */
	public  SafetyCertificationEntity  selectSafetyCertificationByID(int id);
	/**
	 * 前台查询底部网站认证 
	 * @return
	 */
	public List<SafetyCertificationEntity> selectSafetyCertificationfront(); 
}
