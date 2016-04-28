package cn.springmvc.dao;
  
import cn.springmvc.model.VIPSetSubEntity;
/**
 * VIP会员设置
* @author 刘利 
* @Description: TODO 
* @since 
* @date 2016-3-21 上午8:50:41
 */
public interface VIPSetSubDao {
	/**
	 * 添加VIP会员设置
	 * @param entity  VIP会员设置实体类
	 * @return	0：失败	1：成功
	 */
	public int insertVIPSetSub(VIPSetSubEntity entity);
 
	/**
	 * 修改VIP会员设置
	 * @param entity VIP会员设置实体
	 * @return  0:失败 1：成功 
	 */
	public  int  updateVIPSetSub(VIPSetSubEntity entity); 
	/**
	 * 删除VIP会员设置 
	 * @return 0:失败 1：成功 
	 */
	public  int  deleteVIPSetSub();

}
