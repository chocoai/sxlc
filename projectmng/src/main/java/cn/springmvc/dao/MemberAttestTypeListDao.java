package cn.springmvc.dao;

import java.util.List; 

import cn.springmvc.model.MemberAttestTypeEntity;

import product_p2p.kit.pageselect.PageEntity;
 
/**
 * 会员认证类型
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:42:17
 */
public interface MemberAttestTypeListDao {
	/**
	 * 查询该名称的会员认证类型是否存在
	 * @param entity 会员认证类型实体
	 * @return  MemberAttestTypeEntity 
	 */
	public  MemberAttestTypeEntity  selectMemberAttestTypeIsExistByNAme(MemberAttestTypeEntity entity);
	/**
	 * 分页查询会员认证类型
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<MemberAttestTypeEntity> selectMemberAttestTypeAllpage(
			PageEntity pageEntity);
	/**
	 * 更具id查询会员认证类型
	 * @param entity 会员认证类型实体
	 * @return  MemberAttestTypeEntity 
	 */
	public  MemberAttestTypeEntity  selectMemberAttestTypeIsExistById(int id);
	/**
	 * 根据会员类型查询认证项列表
	 * @param entity 会员认证类型实体
	 * @return  MemberAttestTypeEntity 
	 */
	public  List<MemberAttestTypeEntity>  selectMemberAttestTypeByMemberType(MemberAttestTypeEntity entity);

	
}
