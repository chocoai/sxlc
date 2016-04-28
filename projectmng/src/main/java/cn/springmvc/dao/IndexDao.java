

/** 
* @Title: IndexDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-8 上午10:23:02 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 网站首页
 * @since 
 * @date 2016-4-8 上午10:23:02  */

public interface IndexDao {
	/**
	 * 查询首页顶部统计
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  sKey
	 * @param @return 设定文件 
	 * @return Map<String,Object> 返回类型  {IncomeTotal（总收益），countmember（总会员），
	 *                                    totalLoanAmount（总的借款）,RiskReserveFund(前台显示风险备付金)}
	 * @date 2016-4-8 上午11:38:50
	 */
	public Map<String, Object> selectIndexStatistic(String sKey);
	/**
	 * 首页投资列表 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-8 下午1:34:50
	 */
	public List<ProjectAppRecordEntity>  selectInvestListIndex();
	/**
	 * 首页债权转让列表 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<CreditorTransferListEntity> 返回类型 
	 * @date 2016-4-8 下午2:00:25
	 */
	public List<CreditorTransferListEntity> selectCreditorTransferListIndex(Map<String, Object> map);
	/**
	 * 查询当前，当月，本周投资排名
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {sKey，nowMonthOrweek(1本月，2本周，其他查询全部)
	 * @param @return 设定文件 
	 * @return List<InvestEntity> 返回类型 
	 * @date 2016-4-8 下午2:44:09
	 */
	public List<InvestEntity> selectInvestRecordIndex(Map<String,Object> map);
}

