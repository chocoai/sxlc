

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
 

/** 
 * @author 刘利 
 * @Description: 实时播报
 * @since 
 * @date 2016-4-12 下午7:49:02  */

public interface LiveBroadcastDao {
    /** 
     * 添加实时播报
     * @author 刘利   
     * @Description: TODO 
     * @param @param content
     * @param @return 设定文件 
     * @return int 返回类型 
     * @date 2016-4-21 下午12:41:02
     */
	public int insertLiveBroadcast(String content);
}

