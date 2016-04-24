package cn.springmvc.service;

import java.util.List;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.model.PartnersEntity;
 
/**
 * 
* @author 刘利 
* @Description: 合作伙伴 
* @since 
* @date 2016-3-19 下午10:07:44
 */
public interface PartnersService { 
	
	/**
	 * 新增合作伙伴
	 * @param entity 合作伙伴实体
	 * @return 0：数据为空;-1：该名称的合作伙伴已存在;1:添加成功
	 */
	public int insertPartners(PartnersEntity entity,
			InsertAdminLogEntity logentity,String[] sIpInfo); 
	
	/**
	 * 删除合作伙伴
	 * @param id 合作伙伴id
	 * @return 0：失败；1成功
	 */
	public int deletePartners(long id,InsertAdminLogEntity logentity,
			String[] sIpInfo); 
	
	/**
	 * 修改合作伙伴信息
	 * @param entity 合作伙伴实体
	 * @return 0：失败；1成功;-1：该名称的合作伙伴已存在
	 */
	public int updatePartners(PartnersEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);  
	
	/**
	 * 停用或启用合作伙伴信息
	 * @param entity 合作伙伴实体 statu(0:无效 1：有效),id
	 * @return 0:失败 1：成功 
	 */
	public  int  updatePartnerStatuByID(PartnersEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 分页查询合作伙伴
	 * @param  pageEntity 分页实体类  map{name,statu(0:无效 1：有效,-1全部)}
	 * @return
	 */
	public List<PartnersEntity> selectPartnersList(PageEntity pageEntity);
	
	/**
	 * 根据id查询合作伙伴
	 * @param id 合作伙伴id
	 * @return  PartnersEntity 
	 */
	public  PartnersEntity  selectPartnerByID(int id);
	
	/**
	 * 首页查询合作伙伴 
	 * @return
	 */
	public List<PartnersEntity> selectPartnersListIndex(); 
}
