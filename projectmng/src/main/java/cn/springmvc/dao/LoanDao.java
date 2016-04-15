

/** 
* @Title: LoanDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-14 上午9:10:59 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;

/** 
 * @author 刘利 
 * @Description: 项目放款 
 * @since 
 * @date 2016-4-14 上午9:10:59  */

public interface LoanDao {
	/**
	 * 项目放款
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-14 上午9:12:18
	 */
	public int Loan(Map<String,Object> map);
}

