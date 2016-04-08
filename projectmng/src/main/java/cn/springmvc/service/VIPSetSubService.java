package cn.springmvc.service; 

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.VIPSetSubEntity;

public interface VIPSetSubService {
	/**
	 * 新增VIP会员设置
	 * @param entity VIP会员设置实体
	 * @return -1：数据为空;0：添加失败;1:添加成功
	 */
	public int insertVIPSetSub(VIPSetSubEntity entity,InsertAdminLogEntity entityLog, String[] sIpInfo); 
	/**
	 * 删除VIP会员设置
	 * @param id VIP会员设置id
	 * @return 0：失败；1成功
	 */
	public int deleteVIPSetSub(int id);  
	/**
	 * 查询VIP会员设置 
	 * @return VIPSetSubEntity VIP会员设置实体
	 */
	public  VIPSetSubEntity selectVIPSetSubList();
}
