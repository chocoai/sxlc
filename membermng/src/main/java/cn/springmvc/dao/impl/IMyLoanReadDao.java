package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.AdvanceEntity;
import cn.membermng.model.Cleared;
import cn.membermng.model.ComfirLoanInfo;
import cn.membermng.model.ConfirmationLoan;
import cn.membermng.model.Financing;
import cn.membermng.model.FlowLabel;
import cn.membermng.model.InvestmentRecord;
import cn.membermng.model.LoanApplyRecord;
import cn.membermng.model.LoanRepay;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.membermng.model.RepaymentIn;
import cn.membermng.model.RepaymentOfBorrowings;
import cn.membermng.model.RepaymentOfBorrowingsRM;
import cn.membermng.model.ReplayDetailEntity;
import cn.membermng.model.StayStillPlan;
import cn.membermng.model.SuccessRepayDetail;


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

	
	/***
	* 查看会员当前已结清的借款项目
	* 
	* @author 李杰
	* @Title: cleared
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 下午2:07:47
	 */
	List<Cleared> cleared(PageEntity entity);

	
	/***
	* 查看当前会员借款申请记录
	* 
	* @author 李杰
	* @Title: loanApplyRecord
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 下午4:01:17
	 */
	List<LoanApplyRecord> loanApplyRecord(PageEntity entity);

	
	/***
	* 查询当前会员的待还信息
	* 
	* @author 李杰
	* @Title: stayStillPlans
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 下午5:34:45
	 */
	List<StayStillPlan> stayStillPlans(PageEntity entity);

	
	
	
	/***
	* 查询待确认的借款申请
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-4-29 下午8:48:57
	 */
	List<ConfirmationLoan> confirmationLoans(PageEntity entity);

	
	/***
	* 还款管理+还款中的借款
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-2 下午3:31:21
	 */
	List<RepaymentOfBorrowings> RepaymentOfBorrowings(PageEntity entity);

	
	
	/***
	* 
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-2 下午3:31:34
	 */
	List<RepaymentOfBorrowingsRM> LoanRements(PageEntity entity);
	
	
	/**
	 *  提前还款数据显示
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return AdvanceEntity 返回类型 
	 * @date 2016-5-3 下午1:05:03
	 */
	AdvanceEntity getAdvanceReplay(Map<String,Object> map);
	
	/**
	 * 查看还款详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param replyaID 还款计划ID
	 * @param @return 设定文件 
	 * @return ReplayDetailEntity 返回类型 
	 * @date 2016-5-3 下午2:39:09
	 */
	ReplayDetailEntity selectReplayDetail(long replyaID,long memberID,int memberType);
	 
	 /**
	  * 查询该会员是否开通自动还款，是否授权自动还款
	  * @author 刘利   
	  * @Description: TODO 
	  * @param @return 设定文件 
	  * @return MemberThirdAuthInfoEntity 返回类型 
	  * @date 2016-5-3 下午7:05:11
	  */
	 MemberThirdAuthInfoEntity selectMemberIsOpenAutoPay(Map<String,Object> map);
	
	 /**
	  * 后台显示还款中的还款计划
	  * @author 刘利   
	  * @Description: TODO 
	  * @param @param entity
	  * @param @return 设定文件 
	  * @return List<RepaymentOfBorrowingsRM> 返回类型 
	  * @date 2016-5-10 上午11:47:58
	  */
	 public List<RepaymentOfBorrowingsRM> loanRepayback(PageEntity entity);

	 /***
	 * 获取确认借款信息
	 * 
	 * @author 李杰
	 * @param param
	 * @return
	 * @date 2016-5-12 下午2:32:40
	  */
	 public ComfirLoanInfo confirmationLoanInfo(Map<String, Object> param);

	 
	/**
	 * 成交项目管理-还款详情
	 * @author 刘利   
	 * @Description: TODO   
	 * @return List<LoanRepay> 返回类型 
	 * @date 2016-5-12 下午3:54:00
	 */
	 public List<SuccessRepayDetail> loanRepayDetail(PageEntity entity);
	
	 
	 
	 
}

