package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.FinancialAdvisor;

public interface IFinancialAdvisorServer {

	
	

	/***
	 * 根据条件获取理顾问财列表
	 * @param param					条件
	 * personalName					员工名称<br>
	 * memberId						前台会员编号<br>
	 * memberName					前台会员名称<br>
	 * memberUserName				前台会员用户名<br>
	 * @return
	 */
	public void getListByParam(PageEntity entity);
	
	
	
	
	/***
	 * 添加理财师
	 * <br>
	 * advisor 必须要有员工编号、前台会员编号
	 * @param advisor				理财顾问实体
	 * @return
	 */
	public int saveFinancialAdvisor(FinancialAdvisor advisor);
	
	
	
	
	
	/***
	 * 移除理财顾问
	 * memberId						会员编号
	 * staffId						员工编号
	 * serviceNo					理财顾问编号
	 * 
	 * @param advisor
	 * @return
	 */
	public int removeFinancialAdvisor(FinancialAdvisor advisor);
	
	
	
}

