

/** 
* @Title: CreditorTransferCheckDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-26 下午9:27:28 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;
 

/** 
 * @author 刘利 
 * @Description: 债权转让管理
 * @since 
 * @date 2016-4-26 下午9:27:28  */

public interface CreditorTransferCheckDao { 
	/**
	 *  债权转让审核
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-26 下午9:29:08
	 */
	public int creditorTransAppCheck(Map<String, Object> map);
   /**
    * 修改最晚投资时间
    * updateTransMaxTime(这里用一句话描述这个方法的作用) 
    * TODO(描述)
    * @author 刘利   
    * @Description: TODO 
    * @param @param map
    * @param @return 设定文件 
    * @return int 返回类型 
    * @date 2016-4-26 下午9:29:41
    */
	public int updateTransMaxTime(Map<String, Object> map); 
}

