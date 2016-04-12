package cn.springmvc.service;

import java.util.List; 

import cn.springmvc.model.MemberAttestTypeEntity;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
public interface MemberAttestTypeService {
	/**
	 * 新增会员认证类型
	 * @param entity 会员认证类型实体
	 * @return 0：数据为空;-1：该名称的会员认证类型已存在;1:添加成功
	 */
	public int insertMemberAttestType(MemberAttestTypeEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 * 删除会员认证类型
	 * @param id 会员认证类型id
	 * @return 0：失败；1成功
	 */
	public int deleteMemberAttestTypeByID(int id,InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 * 修改会员认证类型
	 * @param entity 会员认证类型实体
	 * @return 0：失败；1成功;-1：该名称的会员认证类型已存在;
	 */
	public int updateMemberAttestTypeByID(MemberAttestTypeEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo);
	 /**
	 * 停用或启用会员认证类型信息
	 * @param entity 会员认证类型实体 (attestTypeID,statu)
	 * @return 0:失败 1：成功 
	 */
	public  int  updateMemberAttestTypeStatuByID(MemberAttestTypeEntity entity);
	/**
	 * 分页查询会员认证类型
	 * @param pageEntity 分页实体  map{attestTypeName,statu(状态 0：停用 1：启用-1全部)}
	 * @return 会员认证类型列表
	 */
	public List<MemberAttestTypeEntity> selectMemberAttestTypeListpage(PageEntity pageEntity);
	/**
	 * 更具id查询会员认证类型
	 * @param entity 会员认证类型实体
	 * @return  PartnersEntity 
	 */
	public  MemberAttestTypeEntity  selectMemberAttestTypeById(int id);
	/**
	 * 根据会员类型查询认证项列表
	 * @param entity 会员认证类型实体 传入(memberType(0：个人会员 1：企业会员-1全部),statu(状态 0：停用 1：启用-1全部))
	 * @return  MemberAttestTypeEntity 
	 */
	public  List<MemberAttestTypeEntity>  selectMemberAttestTypeByMemberType(MemberAttestTypeEntity entity);

	
}
