package cn.springmvc.dao;


import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.FinancialAdvisor;

/***
 * 理财顾问数据访问层
 * @author LiJie
 *
 */
public interface IFinancialAdvisorReadDao {

	
	/***
	 * 根据条件获取理顾问财列表
	 * @param param					条件
	 * personalName					员工名称<br>
	 * memberId						前台会员编号<br>
	 * memberName					前台会员名称<br>
	 * memberUserName				前台会员用户名<br>
	 * @return
	 */
	public List<FinancialAdvisor> getListByParam(PageEntity entity);
	
	

	
	
	
	
	
	
}
