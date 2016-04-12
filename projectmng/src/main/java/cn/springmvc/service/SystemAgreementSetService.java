package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.SystemAgreementSetEntity;
 
import product_p2p.kit.pageselect.PageEntity; 
public interface SystemAgreementSetService {
	/**
	 * 新增系统协议
	 * @param entity 系统协议实体
	 * @return 0：数据为空;-1：该名称的系统协议已存在;1:添加成功
	 */
	public int insertSystemAgreementSet(SystemAgreementSetEntity entity); 
	/**
	 * 删除系统协议
	 * @param type 系统协议type
	 * @return 0：失败；1成功
	 */
	public int deleteSystemAgreementSetByID(int type); 
	/**
	 * 修改系统协议
	 * @param entity 系统协议实体 agreementDetail，agreementType
	 * @return 0：失败；1成功
	 */
	public int updateSystemAgreementSetByType(SystemAgreementSetEntity entity);
	 /**
	 * 停用或启用系统协议信息
	 * @param entity 系统协议实体 agreementStatu,agreementType
	 * @return 0:失败 1：成功 
	 */
	public  int  updateSystemAgreementSetStatuByType(SystemAgreementSetEntity entity);
	/**
	 * 分页查询系统协议
	 * @param pageEntity 分页实体   agreementType -1全部
	 * @return 系统协议列表
	 */
	public List<SystemAgreementSetEntity> selectSystemAgreementSetListpage(PageEntity pageEntity);
	/**
	 * 根据协议类型查询系统协议  
	 * @param agreementType 协议类型
	 * @return  systemAgreementSetEntity 
	 */
	public  SystemAgreementSetEntity  selectSystemAgreementSetBytype(int agreementType);
}
