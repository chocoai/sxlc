

/** 
* @Title: LiveBroadcastService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:54:12 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.model.LiveBroadcastEntity;

/** 
 * @author 刘利 
 * @Description: 实时播报
 * @since 
 * @date 2016-4-12 下午7:54:12  */

public interface LiveBroadcastService {
	/**
	 * 首页显示实时播报
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<LiveBroadcastEntity> 返回类型 
	 * @date 2016-4-12 下午7:50:39
	 */
	public List<LiveBroadcastEntity> selectLiveBroadcast();
	 /** 
     * 添加实时播报
     * @author 刘利   
     * @Description: TODO 
     * @param @param content
     * @param @return 设定文件 
     * @return int 返回类型 
     * @date 2016-4-21 下午12:41:02
     */
	public int insertLiveBroadcast(String content,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
}

