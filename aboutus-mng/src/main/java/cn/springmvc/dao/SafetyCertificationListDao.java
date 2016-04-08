package cn.springmvc.dao;

import java.util.List; 
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.SafetyCertificationEntity;
/**
 * 
* @author 刘利 
* @Description: 底部网站认证 
* @since 
* @date 2016-3-19 下午9:49:09
 */
public interface SafetyCertificationListDao {
	/**
	 * 查询该名称的底部网站认证是否存在
	 * @param entity 底部网站认证实体
	 * @return  safetyCertificationEntity 
	 */
	public  SafetyCertificationEntity  selectSafetyCertificationIsExistByNAme(SafetyCertificationEntity entity);
	/**
	 * 分页查询底部网站认证
	 * @param page分页实体类
	 * @return
	 */
	public List<SafetyCertificationEntity> selectSafetyCertificationList(PageEntity page); 
	
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
