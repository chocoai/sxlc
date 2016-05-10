package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.AdvanceEntity;
import cn.membermng.model.Cleared;
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


/****
* 
* 我的借款
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-31 上午9:44:45 
*
*/
public interface IMyLoanService {

	
	
	/***
	* 我的借款中：融资中
	* <br>
	* 根据会员编号查询,查询条件必须包含memberId
	* @author 李杰
	* @Title: financings
	* @return
	* @Description: TODO
	* @date 2016-3-31 上午10:02:30
	 */
	public List<Financing>	financings(PageEntity entity);
	
	
	
	/**
	* 查看我的投资结束的借款信息
	* <br>查询条件必须包含memberId
	* @author 李杰
	* @Title: endOfFinancing
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-31 下午5:15:39
	 */
	public List<Financing> endOfFinancing(PageEntity entity);
	
	

	/***
	* 获取我的还款中的借款项目	
	* <br>参数必须包含memberId
	* @author 李杰
	* @Title: repaymentIns
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-31 下午5:23:16
	 */
	public List<RepaymentIn> repaymentIns(PageEntity entity);



	/***
	* 查看投资列表
	* <br>参数必须包含applyId				借款项目编号
	* @author 李杰
	* @Title: investRecord
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-31 下午7:23:04
	 */
	public List<InvestmentRecord> investRecord(PageEntity entity);
	
	
	
	/**
	* 
	* 查看还款列表
	* <br>参数必须包含applyId				借款项目编号
	* @author 李杰
	* @Title: loanRepay
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-3-31 下午7:46:35
	 */
	public List<LoanRepay> loanRepay(PageEntity entity);



	
	/***
	* 查看会员当前已流标的借款信息
	* <br>
	* memberId				会员编号
	* memberType			会员类型
	* @author 李杰
	* @Title: FlowLabelS
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 上午11:01:16
	 */
	public List<FlowLabel> flowLabelS(PageEntity entity);


	/***
	* 查看会员当前已结清的借款信息
	* <br>
	* memberId				会员编号
	* @author 李杰
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 下午2:05:53
	 */
	public List<Cleared> cleared(PageEntity entity);



	
	/***
	* 查看当前会员的借款申请记录
	* 
	* @author 李杰
	* @Title: loanApplyRecord
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 下午4:00:08
	 */
	public List<LoanApplyRecord> loanApplyRecord(PageEntity entity);



	/***
	* 查看当前会员的待还计划信息
	* 
	* @author 李杰
	* @Title: stayStillPlans
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-5 下午5:33:32
	 */
	public List<StayStillPlan> stayStillPlans(PageEntity entity);


	
	/***
	* 查询待确认的借款
	* 
	* @author 李杰
	* @param entity
	* memberId					会员编号
	* memberType				会员类型
	* @return
	* @date 2016-4-29 下午8:36:44
	 */
	public List<ConfirmationLoan> confirmationLoans(PageEntity entity);
	
	
	
	
	/***
	* 还款管理+还款中的借款
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-2 下午3:27:50
	 */
	public List<RepaymentOfBorrowings> RepaymentOfBorrowings(PageEntity entity);
	
	
	
	/**
	* 还款管理+还款中的借款+还款计划
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-5-2 下午3:29:18
	 */
	public List<RepaymentOfBorrowingsRM> LoanRements(PageEntity entity);
	
	
	/**
	 *  提前还款数据显示
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return List<AdvanceEntity> 返回类型 
	 * @date 2016-5-3 下午1:05:03
	 */
	public AdvanceEntity getAdvanceReplay(long applyId);
	
	/**
	 * 查看还款详情
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param replyaID
	 * @param @return 设定文件 
	 * @return LoanRepay 返回类型 
	 * @date 2016-5-3 下午2:39:09
	 */
	public ReplayDetailEntity selectReplayDetail(long replyaID,long memberID,int memberType);
	/**
	 * 查询该会员是否开通自动还款，是否授权自动还款
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param memberID
	 * @param @param memberType
	 * @param @return 设定文件 
	 * @return MemberThirdAuthInfoEntity 返回类型 
	 * @date 2016-5-3 下午7:09:34
	 */
	public  MemberThirdAuthInfoEntity selectMemberIsOpenAutoPay(long memberID,int memberType);
	
	/**
	 * 是否开通自动投标 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-5-3 下午8:09:33
	 */
	public int updateIsAutoPay(Map<String,Object> map);
	
	/**
	* 后台还款中的还款计划
	* 
	* @author 刘利 applyId
	* @param entity
	* @return
	* @date 2016-5-2 下午3:29:18
	 */
	public List<RepaymentOfBorrowingsRM> loanRepayback(PageEntity entity);
	
}

