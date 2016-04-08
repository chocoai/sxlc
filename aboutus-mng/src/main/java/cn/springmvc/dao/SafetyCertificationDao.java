package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.SafetyCertificationEntity; 
/**
 * 
* @author 刘利 
* @Description: 实现底部网站认证模块新增，修改，删除功能
* @since 
* @date 2016-3-19 下午9:48:58
 */
public interface SafetyCertificationDao {
	/**
	 * 添加底部网站认证
	 * @param entity  底部网站认证实体类
	 * @return	0：失败	1：成功
	 */
	public int insertSafetyCertification(SafetyCertificationEntity entity);
 
	/**
	 * 通过ID修改底部网站认证信息
	 * @param entity 底部网站认证实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateSafetyCertificationByID(SafetyCertificationEntity entity); 
	/**
	 * 通过ID删除底部网站认证信息
	 * @param id 底部网站认证id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteSafetyCertificationByID(int id); 
	
	/**
	 * 停用或启用底部网站认证
	 * @param entity 底部网站认证实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateSafetyCertificationStatuByID(SafetyCertificationEntity entity);
	
}
