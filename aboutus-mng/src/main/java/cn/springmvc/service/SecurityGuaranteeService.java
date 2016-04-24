package cn.springmvc.service;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.SecurityGuaranteeEntity;
/**
 * 
* @author 刘利 
* @Description: 安全保障 
* @since 
* @date 2016-3-19 下午10:08:43
 */
public interface SecurityGuaranteeService {
	/**
	 * 新增安全保障
	 * @param entity 安全保障实体
	 * @return -1：数据为空;0：添加失败;1:添加成功
	 */
	public int insertSecurityGuarantee(SecurityGuaranteeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除安全保障
	 * @param id 安全保障id
	 * @return 0：失败；1成功
	 */
	public int deleteSecurityGuarantee(int id,InsertAdminLogEntity 
			logentity,String[] sIpInfo);  
	/**
	 * 停用或启用安全保障信息
	 * @param entity 安全保障实体 statu(0:无效 1：有效) ,id
	 * @return 0:失败 1：成功 
	 */
	public  int  updateSecurityGuaranteeStatuByID(SecurityGuaranteeEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 查询安全保障 
	 * param statu状态 statu(0:无效 1：有效,-1全部)
	 * @return SecurityGuaranteeEntity 安全保障实体
	 */
	public  SecurityGuaranteeEntity selectSecurityGuaranteeList(int statu);
}
