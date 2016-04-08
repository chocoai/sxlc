package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.Financing;
import cn.membermng.model.FlowLabel;
import cn.membermng.model.InvestmentRecord;
import cn.membermng.model.LoanRepay;
import cn.membermng.model.RepaymentIn;


/***
* 我的借查询数据访问层
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-31 上午10:18:28 
*
 */
public interface IMyLoanReadDao {

	
	
	
	
	
	
	/***
	* 根据会员编号分页查询当前会员的借款融资中的记录
	* @author 李杰
	* @Title: financings
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-3-31 上午10:20:02
	 */
	List<Financing> financings(PageEntity entity);

	/**
	* 根据会员编号查询会员当前借款投资结束的借款
	* 
	* @author 李杰
	* @Title: endOfFinancing
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-31 下午5:16:51
	 */
	List<Financing> endOfFinancing(PageEntity entity);

	
	/**
	* 查看会员还款中的项目
	* 
	* @author 李杰
	* @Title: repaymentIns
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-31 下午5:26:22
	 */
	List<RepaymentIn> repaymentIns(PageEntity entity);

	
	
	/**
	* 查看投资记录
	* 
	* @Title: investRecord
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-31 下午7:24:01
	 */
	List<InvestmentRecord> investRecord(PageEntity entity);

	
	
	/***
	* 查看项目的还款计划
	* 
	* @author 李杰
	* @Title: loanRepay
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 上午11:04:33
	 */
	public List<LoanRepay> loanRepay(PageEntity entity);

	
	
	/***
	* 查看会员已流标的借款信息
	* 
	* @author 李杰
	* @Title: flowLabelS
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 上午11:05:13
	 */
	List<FlowLabel> flowLabelS(PageEntity entity);
	
	
	
	
	
	
	
}

