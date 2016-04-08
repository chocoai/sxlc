

/** 
* @Title: GenerateRepayListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:46:58 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;
 

/** 
 * @author 刘利 
 * @Description: 发布后生成还款计划
 * @since 
 * @date 2016-4-1 下午1:46:58  */

public interface GenerateRepayListDao {
	/**
	 * 发布后生成还款计划
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 -1项目信息不存在，1成功
	 * @date 2016-4-1 下午1:48:51
	 */
	public int GenerateRepayList(Map<String,Object> map);
	
}

