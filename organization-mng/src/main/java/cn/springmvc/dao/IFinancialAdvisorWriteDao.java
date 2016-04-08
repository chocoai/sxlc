package cn.springmvc.dao;


import java.util.List;
import java.util.Map;

import cn.springmvc.model.FinancialAdvisor;

/***
 * 理财顾问数据访问层
 * @author LiJie
 *
 */
public interface IFinancialAdvisorWriteDao {

	
	
	
	
	
	
	/***
	 * 添加理财师
	 * <br>
	 * advisor 必须要有员工编号、前台会员编号
	 * @param advisor				理财顾问实体
	 * @return
	 */
	public int saveFinancialAdvisor(Map<String,Object> param);
	
	
	
	
	
	/***
	 * 移除理财顾问
	 * @param advisor
	 * @return
	 */
	public int removeFinancialAdvisor(Map<String,Object> param);
	
	
	
	
	
	
	
}
