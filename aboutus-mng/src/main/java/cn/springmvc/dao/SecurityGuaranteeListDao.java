package cn.springmvc.dao;

import cn.springmvc.model.SecurityGuaranteeEntity;
/**
 * 
* @author 刘利 
* @Description: 安全保障体类
* @since 
* @date 2016-3-19 下午9:49:26
 */
public interface SecurityGuaranteeListDao {
	/**
	 * 查询安全保障
	 * @param entity 安全保障实体
	 * @return
	 */
	public  SecurityGuaranteeEntity  selectSecurityGuarantee(int statu); 
	/**
	 * 查询安全保障是否存在 
	 * @return  0：不存在	大于0：存在
	 */
	public  int  selectSecurityGuaranteeIsExist();
}
