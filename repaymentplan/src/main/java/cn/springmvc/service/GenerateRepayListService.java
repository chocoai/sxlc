

/** 
* @Title: GenerateRepayListService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:57:04 
* @version V5.0 */
 
package cn.springmvc.service; 

/** 
 * @author 刘利 
 * @Description: 发布后生成还款计划
 * @since 
 * @date 2016-4-1 下午1:57:04  */

public interface GenerateRepayListService {
	/**
	 * 项目发布时根据项目ID生成该项目的还款计划
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param applyID
	 * @param @return 设定文件 
	 * @return int 返回类型  -1项目信息不存在，1成功
	 * @date 2016-4-1 下午1:58:20
	 */
	int GenerateRepayList(int applyID);
	
	/**
	 * 获取项目投资预期收益
	* GetForecastIncome 获取投资预期收益
	* TODO(描述)
	* @author 张友  
	* * @Title: GetForecastIncome 
	* @Description: TODO 
	* @param  lProId			项目ID
	* @param  lInvestAmount		投资总金额  保留4位小数
	* @param @return 			获取投资某个项目投资收益
	* @return long 返回类型 
	* @date 2016-5-3 下午2:38:39
	* @throws null
	 */
	long GetForecastIncome(long lProId,long lInvestAmount);
}

