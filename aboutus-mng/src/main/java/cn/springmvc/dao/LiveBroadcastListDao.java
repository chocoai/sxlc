

/** 
* @Title: LiveBroadcastListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:49:02 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import cn.springmvc.model.LiveBroadcastEntity;

/** 
 * @author 刘利 
 * @Description: 实时播报
 * @since 
 * @date 2016-4-12 下午7:49:02  */

public interface LiveBroadcastListDao {
	/**
	 * 首页显示实时播报
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<LiveBroadcastEntity> 返回类型 
	 * @date 2016-4-12 下午7:50:39
	 */
	public List<LiveBroadcastEntity> selectLiveBroadcast();
}

