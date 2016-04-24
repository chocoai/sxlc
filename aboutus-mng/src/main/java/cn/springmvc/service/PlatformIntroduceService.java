package cn.springmvc.service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import cn.springmvc.model.PlatformIntroduceEntity;
 
/**
 * 
* @author 刘利 
* @Description: 平台简介
* @since 
* @date 2016-3-19 下午10:08:01
 */
public interface PlatformIntroduceService {
	/**
	 * 新增平台简介
	 * @param entity 平台简介实体
	 * @return -1：数据为空;0：添加失败;1:添加成功
	 */
	public int insertPlatformIntroduce(PlatformIntroduceEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo); 
	/**
	 * 删除平台简介
	 * @param id 平台简介id
	 * @return 0：失败；1成功
	 */
	public int deletePlatformIntroduce(InsertAdminLogEntity 
			logentity,String[] sIpInfo);  
	/**
	 * 查询平台简介 
	 * @return PlatformIntroduceEntity 平台简介实体
	 */
	public  PlatformIntroduceEntity selectPlatformIntroduceList();
}
