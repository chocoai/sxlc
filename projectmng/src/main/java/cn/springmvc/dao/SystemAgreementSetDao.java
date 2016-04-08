package cn.springmvc.dao;
import  cn.springmvc.model.SystemAgreementSetEntity;
/**
 * 系统协议
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:50:27
 */
public interface SystemAgreementSetDao {
	/**
	 * 添加系统协议
	 * @param entity  系统协议实体类
	 * @return	0：失败	1：成功
	 */
	public int insertSystemAgreementSet(SystemAgreementSetEntity entity); 
	
	/**
	 * 通过协议类型修改系统协议信息
	 * @param entity 系统协议实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateSystemAgreementSetByType(SystemAgreementSetEntity entity); 
	/**
	 * 通过协议类型删除系统协议信息
	 * @param agreementType 系统协议id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteSystemAgreementSetByType(int agreementType); 
	/**
	 * 停用或启用系统协议
	 * @param entity 系统协议实体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateSystemAgreementSetStatuByType(SystemAgreementSetEntity entity);
}
