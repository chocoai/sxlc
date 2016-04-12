package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.PartnersEntity; 
/**
 * 
* @author 刘利 
* @Description: 实现合作伙伴模块新增，修改，删除功能
* @since 
* @date 2016-3-19 下午9:47:02
 */
public interface PartnersDao {
	/**
	 * 添加合作伙伴
	 * @param entity  合作伙伴实体类
	 * @return	0：失败	1：成功
	 */
	public int insertPartners(PartnersEntity entity);
 
	/**
	 * 通过ID修改合作伙伴信息
	 * @param entity 合作伙伴实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updatePartnerByID(PartnersEntity entity); 
	/**
	 * 通过ID删除合作伙伴信息
	 * @param id 合作伙伴id
	 * @return 0:失败 1：成功 
	 */
	public  int  deletePartnerByID(int id); 
	
	/**
	 * 停用或启用合作伙伴
	 * @param entity 合作伙伴实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updatePartnerStatuByID(PartnersEntity entity);
	
}
