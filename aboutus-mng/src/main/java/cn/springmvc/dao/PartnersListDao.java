package cn.springmvc.dao;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.PartnersEntity;
/**
 * 
* @author 刘利 
* @Description: 合作伙伴列表查询接口
* @since 
* @date 2016-3-19 下午9:47:14
 */
public interface PartnersListDao {
	/**
	 * 分页查询合作伙伴
	 * @param  pageEntity 分页查询实体类
	 * @return
	 */
	public List<PartnersEntity> selectPartnerList(PageEntity pageEntity); 
	/**
	 * 查询该名称的合作伙伴是否存在
	 * @param entity 合作伙伴实体
	 * @return  PartnersEntity 
	 */
	public  PartnersEntity  selectPartnerIsExistByNAme(PartnersEntity entity);
	/**
	 * 根据id查询合作伙伴
	 * @param id 合作伙伴id
	 * @return  PartnersEntity 
	 */
	public  PartnersEntity  selectPartnerByID(long id);
	/**
	 * 首页查询合作伙伴 
	 * @return
	 */
	public List<PartnersEntity> selectPartnersListIndex(); 
}
