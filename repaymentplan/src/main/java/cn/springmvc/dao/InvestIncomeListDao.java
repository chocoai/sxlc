

/** 
* @Title: InvestIncomeDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午2:13:32 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import cn.springmvc.model.InvestIncomeEntity;
import cn.springmvc.model.InvestRecordEntity;
import cn.springmvc.model.LoanRepayEntity;

/** 
 * @author 刘利 
 * @Description: 放款后生成还款计划
 * @since 
 * @date 2016-4-12 下午2:13:32  */

public interface InvestIncomeListDao {
	/**
	 * 根据项目ID查询该项目的投资记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param Map{}
	 * @param @return 设定文件 
	 * @return List<InvestRecordEntity> 返回类型 
	 * @date 2016-4-12 下午2:16:44
	 */
	public List<InvestRecordEntity>  selectInvestListByProjectID(Map<String,Object> map);
	/**
	 * 根据投资ID查询投资信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param investID 投资ID
	 * @param @return 设定文件 
	 * @return InvestRecordEntity 返回类型 
	 * @date 2016-4-12 下午2:56:27
	 */
	public InvestRecordEntity selectInvestInfoByInvestID(long investID);
	/**
	 * 根据项目申请ID查询该项目的还款计划
	 * @author 刘利   
	 * @Description: TODO 
	 * @param applyID 项目申请ID
	 * @param @return 设定文件 
	 * @return List<LoanRepayEntity> 返回类型 
	 * @date 2016-4-12 下午3:16:00
	 */
	public List<LoanRepayEntity> selectLoanRepayIDByapplyID(long applyID);

	/**
	 * 根据还款计划ID查询收益计划的总的应收本金与应收利息  
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map{sKey,replayID}
	 * @param @return 设定文件 
	 * @return InvestIncomeEntity 返回类型 
	 * @date 2016-4-12 下午4:08:07
	 */
	public InvestIncomeEntity selectSumAmount(Map<String,Object> map);
	/**
	 * 根据还款计划ID查询应还款日期
	 * @author 刘利   
	 * @Description: TODO 
	 * @param replayID 还款计划ID
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @date 2016-4-12 下午4:18:20
	 */
	public String selectSDRecvMaxTime(long replayID);
	
}

