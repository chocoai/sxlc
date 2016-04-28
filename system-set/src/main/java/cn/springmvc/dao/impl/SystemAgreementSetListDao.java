package cn.springmvc.dao.impl;

import java.util.List; 

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.SystemAgreementSetEntity;
/**
 * 系统协议
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:50:34
 */
public interface SystemAgreementSetListDao {
	/**
	 * 查询该类型的系统协议是否存在
	 * @param entity 系统协议实体
	 * @return  systemAgreementSetEntity 
	 */
	public  SystemAgreementSetEntity  selectSystemAgreementSetIsExistBytype(SystemAgreementSetEntity entity);
	/**
	 * 分页查询系统协议
	 * @param pageEntity 分页实体类
	 * @return
	 */
	public List<SystemAgreementSetEntity> selectSystemAgreementSetAllpage(
			PageEntity pageEntity);
	/**
	 * 根据协议类型查询系统协议  
	 * @param agreementType 协议类型
	 * @return  systemAgreementSetEntity 
	 */
	public  SystemAgreementSetEntity  selectSystemAgreementSetBytype(int agreementType);

 
}
