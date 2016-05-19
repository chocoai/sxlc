

/** 
* @Title: InvestIncomeService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午2:20:48 
* @version V5.0 */
 
package cn.springmvc.service; 

/** 
 * @author 刘利 
 * @Description: 放款后生成收益计划
 * @since 
 * @date 2016-4-12 下午2:20:48  */

public interface InvestIncomeService {
	/**
	 * 放款后生成收益计划 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param applyID 项目申请ID
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-12 下午2:24:28
	 */
	public int GenerateInvestIncomeList(long applyID);
//	/**
//	 * 生成收益计划
//	 * @author 刘利   
//	 * @Description: TODO 
//	 * @param   investID 投资记录ID
//	 * @param   planStr  
//	 * @param @return 设定文件 
//	 * @return int 返回类型 
//	 * @date 2016-4-12 下午3:01:58
//	 */
//	public int GenerateInvestIncome(long investID,String planStr);
}

