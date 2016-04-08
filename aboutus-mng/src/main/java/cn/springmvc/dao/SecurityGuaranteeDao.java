package cn.springmvc.dao;
  
import cn.springmvc.model.SecurityGuaranteeEntity;
/**
 * 
* @author 刘利 
* @Description: 安全保障体
* @since 
* @date 2016-3-19 下午9:49:16
 */
public interface SecurityGuaranteeDao {
	/**
	 * 添加安全保障
	 * @param entity  安全保障体类
	 * @return	0：失败	1：成功
	 */
	public int insertSecurityGuarantee(SecurityGuaranteeEntity entity);
 
	/**
	 * 通过ID修改安全保障
	 * @param entity 安全保障体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateSecurityGuaranteeByID(SecurityGuaranteeEntity entity); 
	/**
	 * 通过ID删除安全保障
	 * @param id 安全保障id
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteSecurityGuaranteeByID(int id);   
	/**
	 * 停用或启用安全保障
	 * @param entity 安全保障体
	 * @return 0:失败 1：成功 
	 */
	public  int  updateSecurityGuaranteeStatuByID(SecurityGuaranteeEntity entity);

}
