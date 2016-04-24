package cn.springmvc.dao;
import  cn.springmvc.model.SafetyCertificationSetEntity;
/**
 * 首页全屏弹出框配置
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:50:09
 */
public interface SafetyCertificationSetDao {
	/**
	 * 添加首页全屏弹出框配置
	 * @param entity  首页全屏弹出框配置实体类
	 * @return	0：失败	1：成功
	 */
	public int insertSafetyCertificationSet(SafetyCertificationSetEntity entity); 
	
	/**
	 * 通过ID修改首页全屏弹出框配置信息
	 * @param entity 首页全屏弹出框配置实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateSafetyCertificationSetByID(SafetyCertificationSetEntity entity); 
	/**
	 * 通过ID删除首页全屏弹出框配置信息
	 * @param id 首页全屏弹出框配置id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteSafetyCertificationSetByID(long id); 
	/**
	 * 停用或启用首页全屏弹出框配置
	 * @param entity 首页全屏弹出框配置实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateSafetyCertificationSetStatuByID(SafetyCertificationSetEntity entity);
}
