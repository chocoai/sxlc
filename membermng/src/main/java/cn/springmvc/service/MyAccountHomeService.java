

/** 
* @Title: MyAccountHomeService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-7 上午10:09:51 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import cn.membermng.model.IncomeReplayPlanEntity;
import cn.membermng.model.MyAccountHomeEntity;

/** 
 * @author 刘利 
 * @Description: 我的账户首页
 * @since 
 * @date 2016-4-7 上午10:09:51  */

public interface MyAccountHomeService {
	/**
	 * 我的账户首页-账户信息查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  memberID 会员ID
	 * @return MyAccountHomeEntity 返回类型 
	 * @date 2016-4-7 上午10:16:46
	 */
	public MyAccountHomeEntity selectMyAccountHome(long memberID);
	/**
	 * 查询回款计划信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  Month_Min,Month_Max格式为'201504'即是'%Y%m'
	 * @param  memberID  会员ID
	 * @return List<IncomeReplayPlanEntity> 返回类型 
	 * @date 2016-4-7 下午3:08:17
	 */
	public List<IncomeReplayPlanEntity> getInvestIncome(long memberID,String monthmin,String monthmax);
	/**
	 * 根据回款计划查询当月回款信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param Month格式为'201504'即是'%Y%m'
	 * @param memberID  会员ID
	 * @return List<IncomeReplayPlanEntity> 返回类型 
	 * @date 2016-4-7 下午3:09:20
	 */
	public List<IncomeReplayPlanEntity> getIncomeRecord(long memberID,String month);
	/**
	 * 查询还款计划信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param Month_Min,Month_Max格式为'201504'即是'%Y%m'
	 * @param memberID  会员ID 
	 * @return List<IncomeReplayPlanEntity> 返回类型 
	 * @date 2016-4-7 下午3:10:09
	 */
	public List<IncomeReplayPlanEntity> getLoanRepay(long memberID,String monthmin,String monthmax);
	/**
	 * 根据还款计划查询当月应还款信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   Month格式为'201504'即是'%Y%m'
	 * @param   memberID  会员ID
	 * @return List<IncomeReplayPlanEntity> 返回类型 
	 * @date 2016-4-7 下午3:11:59
	 */
	public List<IncomeReplayPlanEntity> getRepayRecord(long memberID,String month);
	/**
	 * 查询资金动态信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   memberID 会员ID
	 * @param @return 设定文件 
	 * @return List<IncomeReplayPlanEntity> 返回类型 
	 * @date 2016-4-7 下午3:12:59
	 */
	public List<IncomeReplayPlanEntity> getDynamicFunds(long memberID);
}

