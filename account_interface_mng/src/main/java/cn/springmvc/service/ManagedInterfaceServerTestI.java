package cn.springmvc.service;


import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sxlc.account.manager.model.AccountInterfaceEntity;
import cn.sxlc.account.manager.model.AuditEntity;
import cn.sxlc.account.manager.model.AuthorizeInterfaceEntity;
import cn.sxlc.account.manager.model.LoanTransferEntity;
import cn.sxlc.account.manager.model.RechargeEntity;
import cn.sxlc.account.manager.model.RepayInterfaceEntity;
import cn.sxlc.account.manager.model.WithdrawsInterdaceEntity;

/** 
* 关于第三方托管接口
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-7 下午2:17:23  */
@WebService
public interface ManagedInterfaceServerTestI {
	/** 
	* testAccountInterfaceQDD 乾多多开户提交数据处理
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testAccountInterfaceQDD 
	* @Description: TODO 
	* @param @param account
	* @param @return 设定文件 
	* @return AccountInterfaceEntity 返回类型 
	* @throws 
	*/
	public AccountInterfaceEntity testAccountInterfaceQDD(AccountInterfaceEntity account);
	
	
	/** 
	* testLoanRegisterBindReturn 双乾开户接口页面返回处理 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanRegisterBindReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws 
	*/
	public String testLoanRegisterBindReturn(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* testLoanRegisterBindNotify 双乾开户接口服务器返回处理 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanRegisterBindNotify 
	* @Description: TODO 
	* @param  设定文件 
	* @return void 返回类型 
	* @throws 
	*/
	public void testLoanRegisterBindNotify(HttpServletRequest request,HttpServletResponse response);
	
	
	
	/** 
	* testLoanRecharge 充值提交双乾第三方信息处理 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanRecharge 
	* @Description: TODO 
	* @param @param recharge
	* @param @return 设定文件 
	* @return RechargeEntity 返回类型 
	* @throws 
	*/
	public RechargeEntity testLoanRecharge(RechargeEntity recharge);
	
	
	
	/** 
	* testLoanRechargeReturn 双乾充值第三方页面返回 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanRechargeReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws 
	*/
	public String testLoanRechargeReturn(HttpServletRequest request);
	
	
	/** 
	* testLoanRechargeNotify 双乾充值第三方服务器返回处理 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanRechargeNotify 
	* @Description: TODO 
	* @param  设定文件 
	* @return void 返回类型 
	* @throws 
	*/
	public void testLoanRechargeNotify(HttpServletRequest request,HttpServletResponse response);
	
	
	
	/** 
	* testLoanWithdraws 双乾第三方提现提交信息处理
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanWithdraws 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return WithdrawsEntity 返回类型 
	* @throws 
	*/
	public WithdrawsInterdaceEntity testLoanWithdraws(WithdrawsInterdaceEntity withdrawsEntity);

	
	/** 
	* testLoanWithdrawsReturn双乾第三方提现页面返回 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanWithdrawsReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws 
	*/
	public String testLoanWithdrawsReturn(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* testLoanWithdrawsNotify 双乾第三方提现服务器返回  
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanWithdrawsNotify 
	* @Description: TODO 
	* @param  设定文件 
	* @return void 返回类型 
	* @throws 
	*/
	public void testLoanWithdrawsNotify(HttpServletRequest request,HttpServletResponse response);
	
	
	
	
	/** 
	* testLoanAuthorize  双乾第三方授权接口提交信息
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanAuthorize MemberType MemberId authorizeTypeOpen:开启  1.投标 2.还款3.二次分配审核  多个时将所有数字用英文逗号(,)连成一个字符串
	* authorizeTypeClose:关闭 1.投标 2.还款3.二次分配审核 多个时将所有数字用英文逗号(,)连成一个字符串
	* @Description: TODO 
	* @param @return 设定文件 
	* @return AuthorizeInterfaceEntity 返回类型 
	* @throws 
	*/
	public AuthorizeInterfaceEntity testLoanAuthorize(AuthorizeInterfaceEntity authorizeInterfaceEntity);
	
	
	/** 
	* testLoanAuthorizeReturn 双乾第三方授权 页面返回
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanAuthorizeReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws 
	*/
	public String testLoanAuthorizeReturn(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* testLoanAuthorizeNotify  双乾第三方授权接口 服务器返回地址
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanAuthorizeNotify 
	* @Description: TODO 
	* @param  设定文件 
	* @return void 返回类型 
	* @throws 
	*/
	public void testLoanAuthorizeNotify(HttpServletRequest request,HttpServletResponse response);
	
	
	
	/** 
	* testLoanTransferAudit 双乾第三方审核放款、提现接口信息提交 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanTransferAudit 
	* @Description: TODO 
	* @param @param auditEntity
	* @param @return 设定文件 
	* @return AuditEntity 返回类型 
	* @throws 
	*/
	public AuditEntity testLoanTransferAudit(AuditEntity auditEntity);
	
	
	/** 
	* ProjectSubmitDataProcessing 放款 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ProjectSubmitDataProcessing 
	* @Description: TODO 
	* @param  stype 1:项目 2：债权 3：提现
	* @param  pid 项目id、债权转让id、提现申请id
	* @param  auditType：//审核类型 1：放款 2：流标  5：提现通过 6：提现退回
	* @param  returnURL:第三方回调 页面返回地址
	* @param  notifyURL：第三方回调 服务器返回地址
	* @param @return 设定文件 
	* @return AuditEntity 返回类型 
	* @date 2016-5-12 下午1:57:28
	* @throws 
	*/
	public AuditEntity ProjectSubmitDataProcessing(int stype,long pid,String auditType,String returnURL,String notifyURL);
	
	/** 
	* testLoanTransferAuditReturn 双乾第三方放款、提现审核 页面返回 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanTransferAuditReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws 
	*/
	public String testLoanTransferAuditReturn(HttpServletRequest request,HttpServletResponse response);
	
	/** 
	* testLoanTransferAuditNotify 双乾第三方放款、提现审核 服务器返回  
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanTransferAuditNotify 
	* @Description: TODO 
	* @param  设定文件 
	* @return void 返回类型 
	* @throws 
	*/
	public void testLoanTransferAuditNotify(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* testLoanTransfer 双乾第三方转账信息提交 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testLoanTransfer 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @throws 
	*/
	public LoanTransferEntity testLoanTransfer(LoanTransferEntity loanTransferEntity);
	
	
	
	/** 
	* testInvestmentReturn  前台投资双乾第三方页面返回地址
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testInvestmentReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws 
	*/
	public String testInvestmentReturn(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* testInvestmentNotify 前台投资双乾 第三方服务器返回 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testInvestmentNotify 
	* @Description: TODO 
	* @param  设定文件 
	* @return void 返回类型 
	* @throws 
	*/
	public void testInvestmentNotify(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* testRepaymentReturn 还款双乾第三方页面返回信息处理 
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testRepaymentReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws 
	*/
	public String testRepaymentReturn();
	
	
	/** 
	* testRepaymentNotify 还款双乾第三方服务器返回信息处理
	* TODO(这里描述这个方法适用条件 – 可选) 
	* TODO(这里描述这个方法的执行流程 – 可选) 
	* TODO(这里描述这个方法的使用方法 – 可选) 
	* TODO(这里描述这个方法的注意事项 – 可选) 
	* * @Title: testRepaymentNotify 
	* @Description: TODO 
	* @param  设定文件 
	* @return void 返回类型 
	* @throws 
	*/
	public void testRepaymentNotify();
	
	
	
	
	/** 
	* EarlyRepaymentProcessing 提前还款提交数据查询  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: EarlyRepaymentProcessing 
	* @Description: TODO 
	* @param @param lonmemberId
	* @param @param lonmembertype
	* @param @param appplyId
	* @param @param results -1:已结清 -2存在逾期未还的借款
	* @param @return 设定文件 
	* @return RepayInterfaceEntity 返回类型 
	* @date 2016-4-6 上午10:05:39
	* @throws 
	*/
	public RepayInterfaceEntity EarlyRepaymentProcessing(long lonmemberId,int lonmembertype,long appplyId,int[] results);
	
	
	
	
	/** 
	* RepaymentProcessing 正常还款提交数据查询
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: RepaymentProcessing 
	* @Description: TODO 
	* @param @param lonmemberId 还款会员id
	* @param @param lonmembertype 还款会员类型
	* @param @param appplyId 项目申请id
	* @param @param repalyId 还款计划id
	* @param @param results 查询状态：
	* @param @return 设定文件 
	* @return RepayInterfaceEntity 返回类型 
	* @date 2016-4-6 上午10:03:38
	* @throws 
	*/
	public RepayInterfaceEntity RepaymentProcessing(long lonmemberId,int lonmembertype,long appplyId,long repalyId,int[] results);
	
	

	
	/** 
	* GetRepayInfoById 查询还款详情 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: GetRepayInfoById 
	* @Description: TODO 
	* @param @param lId 还款计划id
	* @param @param applayid 项目申请id
	* @param @param lmoney 还款账户可用余额
	* @param @param isUpdate
	* @param @param iStatu 0：提前还款  1：正常还款	2：部分还款  3：代偿还款 -1:已还
	* @param @return 设定文件 
	* @return RepayInterfaceEntity 返回类型 
	* @date 2016-4-7 下午3:01:39
	* @throws 
	*/
	public RepayInterfaceEntity GetRepayInfoById(long lId,long applayid,long lmoney,int isUpdate,int[] iStatu,long lonmemberId, int lonmembertype); 
	
	
	/** 
	* Compensatory 代偿数据查询
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: Compensatory 
	* @Description: TODO 
	* @param @param lonmemberId
	* @param @param lonmembertype
	* @param @param appplyId
	* @param @param repalyId
	* @param @param results
	* @param @return 设定文件 
	* @return RepayInterfaceEntity 返回类型 
	* @date 2016-4-8 下午3:58:08
	* @throws 
	*/
	public RepayInterfaceEntity Compensatory(long lonmemberId,
			int lonmembertype, long appplyId,long repalyId, int[] results,long daicangId,int daicangtype);
	
	
	/** 
	* CompensatoryPayment 代偿回款查询 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CompensatoryPayment 
	* @Description: TODO 
	* @param @param appplyId 借款项目申请id
	* @param @param repalyId 还款计划id
	* @param @param results 操作状态
	* @param @return 设定文件 
	* @return RepayInterfaceEntity 返回类型 
	* @date 2016-4-12 上午9:10:26
	* @throws 
	*/
	public RepayInterfaceEntity CompensatoryPayment(long lonmemberId,int lonmembertype,long applyId,long repalyId, int[] results);
	
	
	/** 
	* RefundDeposit 保证金退回
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: RefundDeposit 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-4-15 上午9:59:03
	* @throws 
	*/
	public LoanTransferEntity RefundDeposit(long applyId);
	
	
	/** 
	* ReturnOfDepositNotify 保证金退还成功 服务器返回
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ReturnOfDepositNotify 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-15 下午2:16:31
	* @throws 
	*/
	public int ReturnOfDepositNotify();
	
	
	/** 
	* SurpriseRedSubmit  惊喜红包发放提交参数
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: SurpriseRedSubmit 
	* @Description: TODO 
	* @param @param applyId 放款项目id
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-4-18 下午1:37:58
	* @throws 
	*/
	public LoanTransferEntity SurpriseRedSubmit(long applyId);
	
	
	/** 
	* SurpriseRedBack 惊喜红包发放服务器返回处理
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: SurpriseRedBack 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-18 下午3:00:24
	* @throws 
	*/
	public int SurpriseRedBack();
	
	
	/** 
	* SurpriseRedReturn 惊喜红包发放页面返回处理
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: SurpriseRedReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-20 下午2:38:22
	* @throws 
	*/
	public String SurpriseRedReturn();
	
	
	/** 
	* FriendTransfer 好友转账信息提交拼接
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: FriendTransfer 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-4-19 上午9:58:47
	* @throws 
	*/
	public LoanTransferEntity FriendTransfer(long inMemberId,long outMemberId,long amount);
	
	
	
	/** 
	* MemberTransferBack 好友转账返回处理
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: MemberTransferBack 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-19 下午2:58:06
	* @throws 
	*/
	public int MemberTransferBack(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* MemberTransferReturn 好友转账返回处理  页面返回
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: MemberTransferReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-20 下午2:36:33
	* @throws 
	*/
	public String MemberTransferReturn(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* PlatformAwardMoney 平台提奖提交参数处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PlatformAwardMoney 
	* @Description: TODO 
	* @param @param MemberId newAmount实际提奖金额 type:1 理财顾问 2推荐达人
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-4-19 下午3:50:31
	* @throws 
	*/
	public LoanTransferEntity PlatformAwardMoney(long MemberId,String startTime,String endTime,long newAmount,int type);
	
	
	/** 
	* PlatformAwardMoneyBack 平台提奖操作第三方返回处理  
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PlatformAwardMoneyBack 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-20 上午11:47:32
	* @throws 
	*/
	public int PlatformAwardMoneyBack();
	
	/** 
	* PlatformAwardMoneyBack 平台提奖操作第三方返回处理  页面通知
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PlatformAwardMoneyBack 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-20 上午11:47:32
	* @throws 
	*/
	public String PlatformAwardMoneyReturn();
	
	
	
	/** 
	* PurchaseVIP VIP购买提交信息提交 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PurchaseVIP 
	* @Description: TODO 00
	* @param @param memberId 会员id
	* @param @param years 购买年限
	* @param startTime 购买开始时间
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-4-20 下午3:21:55
	*/
	public LoanTransferEntity PurchaseVIP(long memberId,int years,String startTime);
	
	
	/** 
	* PurchaseVipReturn vip购买页面返回
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PurchaseVipReturn 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-21 下午3:13:23
	* @throws 
	*/
	public String PurchaseVipReturn(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* PurchaseVipBack vip购买服务器返回
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PurchaseVipBack 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-21 下午3:14:00
	* @throws 
	*/
	public int PurchaseVipBack(HttpServletRequest request,HttpServletResponse response);
	
	
	
	
	/** 
	* PreInvestmentTreatment 投资提交第三方前信息处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PreInvestmentTreatment 
	* @Description: TODO 
	* @param @param lProjectId 投资项目id
	* @param @param lMemberId	投资会员id
	* @param @param sIsAuto		是否为自动投标
	* @param @param lAmount		投资总金额
	* @param @param sRedpacketsInfo 红包使用金额		红包1ID,使用金额(单位元，保留4位小数);红包ID2,使用金额;
	* @param @param lVouchers 	代金券金额		(单位元，保留4位小数)
	* @param @param sDirectPwd	定向标密码
	* @param @param sClient  0：pc 1：app 2：微信端
	* @param @return 设定文件 
	* @return 0LoanTransferEntity 返回类型 
	* @date 2016-4-28 下午4:23:32
	*/
	public LoanTransferEntity PreInvestmentTreatment(long lProjectId, long lMemberId, short sIsAuto,long lAmount, String sRedpacketsInfo,
            long lVouchers, String sDirectPwd,short sClient);
	
	
	/** 
	* earlyRepaymentSubm 提前还款提交第三方 数据处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: earlyRepaymentSubm 
	* @Description: TODO 
	* @param @param repayInterfaceEntity
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-5-3 下午8:23:27
	* @throws 
	*/
	public LoanTransferEntity earlyRepaymentSubm(RepayInterfaceEntity repayInterfaceEntity);
	
	
	
	
	/** 
	* TransferOfCreditorsRights 债权转让投资信息提交前处理
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: TransferOfCreditorsRights 
	* @Description: TODO 
	* @param @param lProjectId  项目ID
	* @param @param lMemberId 会员ID
	* @param @param lCreditorTransAppId 债权转让的申请id
	* @param @param sIsAuto 是否为自动投标	0:否	1：是
	* @param @param lAmount  投资总金额		(单位元，保留4位小数)
	* @param @param sRedPacketsInfo 红包使用金额		红包1ID,使用金额(单位元 格式：0.20元，保留2位小数);红包ID2,使用金额;
	* @param @param lVouchers 代金券金额		(单位元，保留4位小数)
	* @param @param sClient  0：pc 1：app 2：微信端
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-5-5 下午7:44:36
	* @throws 
	*/
	public LoanTransferEntity TransferOfCreditorsRights(long lProjectId, long lMemberId, long lCreditorTransAppId,short sIsAuto,
            long lAmount, String sRedPacketsInfo, long lVouchers,short sClient);
	
	
	/** 
	* TransferOfCreditorsInvest 债权转让投资 第三方服务器返回
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: TransferOfCreditorsInvest 
	* @Description: TODO 
	* @param @param request
	* @param @param response 设定文件 
	* @return void 返回类型 
	* @date 2016-5-9 上午11:16:39
	* @throws 
	*/
	public void TransferOfCreditorsInvest(HttpServletRequest request,HttpServletResponse response);
}
