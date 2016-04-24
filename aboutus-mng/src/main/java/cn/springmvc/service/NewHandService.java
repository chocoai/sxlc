package cn.springmvc.service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.NewHandEntity;
/**
 *  
* @author 刘利 
* @Description: 新手指南
* @since 
* @date 2016-3-19 下午10:07:35
 */

public interface NewHandService {
	/**
	 * 新增新手指南
	 * @param entity 新手指南实体
	 * @return -1：数据为空;0：添加失败;1:添加成功
	 */
	public int insertNewHand(NewHandEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除新手指南
	 * @param id 新手指南id
	 * @return 0：失败；1成功
	 */
	public int deleteNewHand(InsertAdminLogEntity 
			logentity,String[] sIpInfo);  
	/**
	 * 查询新手指南 
	 * @return NewHandEntity 新手指南实体
	 */
	public  NewHandEntity selectNewHandList();
}
