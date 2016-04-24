package cn.springmvc.dao;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.SafetyCertificationSetEntity;
/**
 * 首页全屏弹出框配置
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:50:19
 */
public interface SafetyCertificationSetListDao {
	/**
	 * 分页查询首页全屏弹出框配置
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<SafetyCertificationSetEntity> selectSafetyCertificationSetAllpage(
			PageEntity pageEntity);
	/**
	 * 通过id查询首页全屏弹出框配置
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public  SafetyCertificationSetEntity selectSafetyCertificationSetbyID(long id);
	/**
	 * 查询首页全屏弹出框配置 (首页显示)
	 * @return
	 */
	public List<SafetyCertificationSetEntity> selectSafetyCertificationSetIndex();
}
