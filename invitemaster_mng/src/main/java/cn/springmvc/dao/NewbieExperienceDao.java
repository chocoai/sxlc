

/** 
* @Title: NewbieExperienceDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午2:26:06 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;

/** 
 * @author 刘利 
 * @Description: 新手体验标
 * @since 
 * @date 2016-4-15 下午2:26:06  */

public interface NewbieExperienceDao {
	/**
	 * 新手体验标设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-15 下午2:28:05
	 */
	public int NewbieExperienceSet(Map<String,Object> map); 
}

