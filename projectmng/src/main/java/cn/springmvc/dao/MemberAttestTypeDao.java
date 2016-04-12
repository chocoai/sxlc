package cn.springmvc.dao; 

import cn.springmvc.model.MemberAttestTypeEntity;

/**
 * 
* @author 刘利 
* @Description: 会员认证类型 
* @since 
* @date 2016-3-19 下午10:21:57
 */
public interface MemberAttestTypeDao {
	/**
	 * 添加会员认证类型
	 * @param entity  会员认证类型实体类
	 * @return	0：失败	1：成功
	 */
	public int insertMemberAttestType(MemberAttestTypeEntity entity); 
	
	/**
	 * 通过ID修改会员认证类型信息
	 * @param entity 会员认证类型实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateMemberAttestTypeByID(MemberAttestTypeEntity entity); 
	/**
	 * 通过ID删除会员认证类型信息
	 * @param id 会员认证类型id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteMemberAttestTypeByID(int id); 
	/**
	 * 停用或启用会员认证类型
	 * @param entity 会员认证类型实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateMemberAttestTypeStatuByID(MemberAttestTypeEntity entity);
}
