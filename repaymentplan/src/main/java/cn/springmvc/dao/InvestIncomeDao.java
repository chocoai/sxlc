

/** 
* @Title: InvestIncomeDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午4:46:47 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-4-12 下午4:46:47  */

public interface InvestIncomeDao {
	/**
	 * 新增收益计划 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * @param @return 设定文件 
	 * @return int 返回类型  0失败1成功
	 * @date 2016-4-12 下午3:47:23
	 */
	public int  insertInvestIncome(Map<String,Object> map);
	/**
	 * 修改还款计划收益平账 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-12 下午4:40:54
	 */
	public int updateReplay(Map<String,Object> map);
}

