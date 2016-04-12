

/** 
* @Title: IndexService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-8 上午11:06:17 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import cn.springmvc.model.InvestEntity;
import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 网站首页
 * @since 
 * @date 2016-4-8 上午11:06:17  */

public interface IndexService {
	/**
	 * 查询首页顶部统计
	 * @author 刘利   
	 * @Description: TODO  
	 * @param @return 设定文件 
	 * @return Map<String,Object> 返回类型  {IncomeTotal（总收益），countmember（总会员），totalLoanAmount（总的借款）}
	 * @date 2016-4-8 上午11:35:42
	 */
	public Map<String, Object> selectIndexStatistic();
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
	 * 查询当前，当月，本周投资排名
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map {nowMonthOrweek(1本月，2本周，其他查询全部)
	 * @param @return 设定文件 
	 * @return List<InvestEntity> 返回类型 
	 * @date 2016-4-8 下午2:44:09
	 */
	public List<InvestEntity> selectInvestRecordIndex(Map<String,Object> map);
}

