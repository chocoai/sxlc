
package cn.springmvc.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import cn.springmvc.model.InvestRecordInfoEntity;
import cn.springmvc.model.LoanRepayEntitys;
import cn.springmvc.model.ProjectDetailEntity;
import cn.sxlc.account.manager.model.AccountInterfaceEntity;
import cn.sxlc.account.manager.model.AwardEntity;
import cn.sxlc.account.manager.model.InvestRecordEntity;
import cn.sxlc.account.manager.model.LoanRepayEntity;
import cn.sxlc.account.manager.model.LoanTransactionEntity;
import cn.sxlc.account.manager.model.ProjectEntity;
import cn.sxlc.account.manager.model.RepayDetailEntity;
import cn.sxlc.account.manager.model.SurpriseRedEntity;
import cn.sxlc.account.manager.model.WithdrawalsFeeEntity;
import cn.sxlc.account.manager.model.WithdrawsEntity;

/** 
 * 第三方交互相关查询
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-28 上午11:30:25  */
public interface SelectThreePartyDao {
	
	/** 
	* selectpAccountById 查询个人会员开户所需基本信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectpAccountById 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return AccountInterfaceEntity 返回类型 
	* @date 2016-3-28 下午1:35:27
	* @throws 
	*/
	public AccountInterfaceEntity selectpAccountById(Map<String, Object> map);
	
	
	/** 
	* selectcAccountById 查询企业会员开户所需基本信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectcAccountById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return AccountInterfaceEntity 返回类型 
	* @date 2016-3-28 下午1:38:25
	* @throws 
	*/
	public AccountInterfaceEntity selectcAccountById(Map<String, Object> map);
	
	
	/** 
	* findThirdPartyMark 查询平台账号信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findThirdPartyMark 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-3-28 下午1:41:33
	* @throws 
	*/
	public String findThirdPartyMark(Map<String, Object> map);
	
	
	/** 
	* findMemberThirdPartyMark 根据会员类型和id查询会员乾多多标识 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findMemberThirdPartyMark 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-3-29 上午10:20:16
	* @throws 
	*/
	public String findMemberThirdPartyMark(Map<String, Object> map);
	
	/** 
	* payRechargeSet 根据会员类型查询手续费支付方式 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: payRechargeSet 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-3-29 上午10:58:35
	* @throws 
	*/
	public String payRechargeSet(Map<String, Object> map);
	
	
	/** 
	* GetInvestListByProId 根据项目id查询所有放款或流标操作流水号 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: GetInvestListByProId 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<LoanTransactionEntity> 返回类型 
	* @date 2016-3-30 上午9:40:34
	* @throws 
	*/
	public List<LoanTransactionEntity> GetInvestListByProId(Map<String, Object> map);
	
	
	/** 
	* isWithdrawalsCheak 根据 会员类型查询提现规则设置
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: isWithdrawalsCheak 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return WithdrawalsFeeEntity 返回类型 
	* @date 2016-3-31 下午1:44:44
	* @throws 
	*/
	public WithdrawalsFeeEntity isWithdrawalsCheak(Map<String, Object> map);
	
	
	/** 
	* finBankCode 根据银行卡id查询银行信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: finBankCode 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return WithdrawsEntity 返回类型 
	* @date 2016-3-31 下午1:45:29
	* @throws 
	*/
	public WithdrawsEntity finBankCode(Map<String, Object> map);
	
	
	/** 
	* findWithdrawalRecharge 根据提现申请记录id 查询提现申请交易流水号 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findWithdrawalRecharge 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-1 上午10:23:23
	* @throws 
	*/
	public String findWithdrawalRecharge(Map<String, Object> map);
	
	
	/** 
	* EarlyRepayment 判断是否满足提前还款条件
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: EarlyRepayment 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-2 上午9:51:42
	* @throws 
	*/
	public Map<String, Object> EarlyRepayment(Map<String, Object> map);
	
	
	/** 
	* selectAllmoneyForEarlyRepayment 根据项目申请id查询出提前还款应还的所有本金
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectAllmoneyForEarlyRepayment 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-2 上午10:34:05
	* @throws 
	*/
	public long selectAllmoneyForEarlyRepayment(Map<String, Object> map);
	
	
	/** 
	* selectAllmoneyForEarlyRepayment  根据项目申请id查询所有投资记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectAllmoneyForEarlyRepayment 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<RepayDetailEntity> 返回类型 
	* @date 2016-4-2 上午10:35:09
	* @throws 
	*/
	public List<RepayDetailEntity> selectAllInvestForEarlyRepayment(Map<String, Object> map);
	
	
	/** 
	* selectRevenuePlan 根据投资id查询会员未收总本金
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectRevenuePlan 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-2 上午10:37:03
	* @throws 
	*/
	public long selectRevenuePlan(Map<String, Object> map);
	
	
	/** 
	* findInterestByMember 查询出提前还款 单个投资会员最近一期未收收益 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findInterestByMember 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-2 上午10:37:56
	* @throws 
	*/
	public long findInterestByMember(Map<String, Object> map);
	
	
	/** 
	* findPenaltyRate 查询提前还款违约金设置
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findPenaltyRate 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-2 上午11:47:51
	* @throws 
	*/
	public Map<String, Object> findPenaltyRate(Map<String, Object> map);
	
	
	/** 
	* findTimesByMember 查询出提前还款 单个投资会员最近一期应收收益时间，月标 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findTimesByMember 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-5 上午10:50:47
	* @throws 
	*/
	public long findTimesByMember(Map<String, Object> map);
	
	
	/** 
	* projectDurationType 查询出该项目的期限类型
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: projectDurationType 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-5 上午11:05:38
	* @throws 
	*/
	public int projectDurationType(Map<String, Object> map);
	
	
	/** 
	* findInterestByOne 查询还款 单个投资会员未收总利息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findInterestByOne 
	* @Description: TODO 
	* @param @param map investId  投资id;repayId 还款计划id
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-6 上午11:04:29
	* @throws 
	*/
	public long findInterestByOne(Map<String, Object> map);
	
	
	/** 
	* selectPrincipalByID 根据投资id、还款计划id查询会员当期未收总本金
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectPrincipalByID 
	* @Description: TODO 
	* @param @param map investId  投资id;repayId 还款计划id
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-6 上午11:05:06
	* @throws 
	*/
	public long selectPrincipalByID(Map<String, Object> map);
	
	/** 
	* findDayByOverdue 查询还款逾期天数 大于0视为逾期
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findDayByOverdue 
	* @Description: TODO 
	* @param @param map investId  投资id;repayId 还款计划id
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-6 下午2:44:19
	* @throws 
	*/
	public long findDayByOverdue(Map<String, Object> map);
	
	
	/** 
	* findOverdueFees 根据逾期天数查询逾期费率 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findOverdueFees 
	* @Description: TODO 
	* @param @param map iDays 逾期天数
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-6 下午5:24:13
	* @throws 
	*/
	public long findOverdueFees(Map<String, Object> map);
	
	
	/** 
	* InvestIncomeOverdueFee 根据收益计划id查询投资人预计还款逾期罚息和罚金 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: InvestIncomeOverdueFee 
	* @Description: TODO 
	* @param @param map incomeId 收益记录id skey 秘钥
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-6 下午7:14:56
	* @throws 
	*/
	public Map<String, Object> InvestIncomeOverdueFee(Map<String, Object> map);
	
	
	/** 
	* allInvestRealIncome 根据收益计划id查询出实际已收的所有罚息和罚金 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: allInvestRealIncome 
	* @Description: TODO 
	* @param @param map incomeId 收益记录id skey 秘钥
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-6 下午8:25:57
	* @throws 
	*/
	public Map<String, Object> allInvestRealIncome(Map<String, Object> map);
	
	
	/** 
	* findIncomeId 根据投资记录id和还款计划id查询单个会员收益计划id
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findIncomeId 
	* @Description: TODO 
	* @param @param map investId 投资记录id ;repayId 
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-6 下午8:54:04
	* @throws 
	*/
	public long findIncomeId(Map<String, Object> map);
	
	
	/** 
	* overdueRecvTime 根据还款计划id查询最近一次逾期还款时间
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: overdueRecvTime 
	* @Description: TODO 
	* @param @param map repayId 还款计划id
	* @param @return 设定文件 
	* @return Timestamp 返回类型 
	* @date 2016-4-7 上午10:06:20
	* @throws 
	*/
	public Timestamp overdueRecvTime(Map<String, Object> map);
	
	
	/** 
	* overdueRepayMaxTime 根据还款计划id查询当期预计还款时间 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: overdueRepayMaxTime 
	* @Description: TODO 
	* @param @param map repayId 还款计划id
	* @param @return 设定文件 
	* @return Timestamp 返回类型 
	* @date 2016-4-7 上午10:21:29
	* @throws 
	*/
	public Timestamp overdueRepayMaxTime(Map<String, Object> map);
	
	
	/** 
	* ProjectBaseInfoYearRate 根据项目申请id查询 项目年化
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ProjectBaseInfoYearRate 
	* @Description: TODO 
	* @param @param map applyId 项目申请id
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-7 上午10:53:23
	* @throws 
	*/
	public long ProjectBaseInfoYearRate(Map<String, Object> map);
	
	
	/** 
	* RepayStatu 查询当前还款计划还款状态
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: RepayStatu 
	* @Description: TODO 
	* @param @param map repayId 还款计划id
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-4-7 下午5:14:57
	* @throws 
	*/
	public long RepayStatu(Map<String, Object> map);
	
	
	/** 
	* CompensatoryJudgment 代偿前判断
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CompensatoryJudgment 
	* @Description: TODO 
	* @param @param map  replayId 还款计划id ；result -1:已还款 -2 该还款计划已代偿 -3 该还款计划为无效 -4 该还款计划为还款中
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-8 下午2:42:26
	* @throws 
	*/
	public int CompensatoryJudgment(Map<String, Object> map);
	
	
	/** 
	* CompensatoryPaymentJudgment 代偿回款前判断
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CompensatoryPaymentJudgment 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-12 上午9:48:37
	* @throws 
	*/
	public int CompensatoryPaymentJudgment(Map<String, Object> map);
	
	
	
	/** 
	* sumJudgmentMoney 查询出代偿回款代偿方代偿的金额信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: sumJudgmentMoney 
	* @Description: TODO 
	* @param @param map repayId skey
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-12 下午1:49:51
	* @throws 
	*/
	public Map<String, Object> sumJudgmentMoney(Map<String, Object> map);
	
	
	/** 
	* findDayByOverdueNow 查询逾期时间
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findDayByOverdueNow 
	* @Description: TODO 
	* @param @param map repayId 还款计划id
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-12 下午3:09:28
	* @throws 
	*/
	public int findDayByOverdueNow(Map<String, Object> map);
	
	
	/** 
	* GetCreditorTransId 查询债权转让未处理的所有流水号
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: GetCreditorTransId 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<LoanTransactionEntity> 返回类型 
	* @date 2016-4-13 下午5:00:24
	* @throws 
	*/
	public List<LoanTransactionEntity> GetCreditorTransId(Map<String, Object> map);
	
	
	/** 
	* GetTransInvestList 查询债权转让投资记录
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: GetTransInvestList 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<InvestRecordEntity> 返回类型 
	* @date 2016-4-14 上午10:10:25
	* @throws 
	*/
	public List<InvestRecordEntity> GetTransInvestList(Map<String, Object> map);
	
	
	/** 
	* InterestType  查询债权转让 利息生成方式
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: InterestType 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return Integer 返回类型 
	* @date 2016-4-14 上午10:42:57
	* @throws 
	*/
	public Integer InterestType();
	
	
	
	/** 
	* getRepaymentByCTAId 查询债权转让原项目的还款方式 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: getRepaymentByCTAId 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Integer 返回类型 
	* @date 2016-4-14 上午11:12:45
	* @throws 
	*/
	public Map<String, Object> getRepaymentByCTAId(Map<String, Object> map);
	
	
	/** 
	* getDateInstallments 查询债权转让原投资的剩余期限以及期限类型 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: getDateInstallments 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-14 下午2:01:17
	* @throws 
	*/
	public Map<String, Object> getDateInstallments(Map<String, Object> map);
	
	
	/** 
	* GetProdateTrans 查询出最近一次回款时间（作为生成收益计划的投标结束时间） 如果一次都未还则为原项目放款时间 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: GetProdateTrans 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-14 下午3:06:10
	* @throws 
	*/
	public Map<String, Object> GetProdateTrans(Map<String, Object> map);
	
	
	/** 
	* selectLoanId(根据项目申请id查询所有未还还款计划id) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectLoanId 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<Integer> 返回类型 
	* @date 2016-4-14 下午3:59:07
	* @throws 
	*/
	public List<LoanRepayEntity> selectLoanId(Map<String, Object> map);
	
	
	/** 
	* JudgmentRefundDeposit 退还保证金判断 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: JudgmentRefundDeposit 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-15 上午10:21:58
	* @throws 
	*/
	public Map<String, Object> JudgmentRefundDeposit(Map<String, Object> map);
	
	
	/** 
	* findListSurpriseRed 查询出项目使用惊喜红包的使用记录 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findListSurpriseRed 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<SurpriseRedEntity> 返回类型 
	* @date 2016-4-18 下午2:47:02
	* @throws 
	*/
	public List<SurpriseRedEntity> findListSurpriseRed(Map<String, Object> map);
	
	
	/** 
	* AccountBalance 判断转账人余额是否充足
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: AccountBalance 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-19 上午11:16:38
	* @throws 
	*/
	public int AccountBalance (Map<String, Object> map);
	
	
	/** 
	* RecommendedTalentAward 推荐达人 提奖会员应提奖金额查询 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: RecommendedTalentAward 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<AwardEntity> 返回类型 
	* @date 2016-4-19 下午5:23:19
	* @throws 
	*/
	public List<AwardEntity> RecommendedTalentAward(Map<String, Object> map);
	
	
	/** 
	* FinancialAdvisorAward 理财顾问 提奖会员应提奖金额查询 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: FinancialAdvisorAward 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return List<AwardEntity> 返回类型 
	* @date 2016-4-19 下午5:25:04
	* @throws 
	*/
	public List<AwardEntity> FinancialAdvisorAward(Map<String, Object> map);
	
	
	/** 
	* findYearMoney 查询出vip购买年费金额 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findYearMoney 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-5-9 上午10:09:00
	* @throws 
	*/
	public long findYearMoney();
	
	
	/** 
	* EndTimeComparison 比较购买vip时选择的vip购买开始时间
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: EndTimeComparison 
	* @Description: TODO 
	* @param @param map 
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-5-9 上午10:57:45
	* @throws 
	*/
	public int EndTimeComparison(long memberId,String startTime);
	
	
	/** 
	* selectPhone 根据会员id查询手机号
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectPhone 
	* @Description: TODO 
	* @param memberId 会员id
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-5-10 下午12:03:20
	* @throws 
	*/
	public String selectPhone(long memberId);
	
	
	/** 
	* QueryCashWithdrawal 根据第三方交易号查询提现申请金额 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: QueryCashWithdrawal 
	* @Description: TODO 
	* @param  thirdBillNo
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-5-10 下午2:00:49
	* @throws 
	*/
	public long QueryCashWithdrawal(String thirdBillNo);
	
	
	/** 
	* findProjectTNByid 根据项目申请id查询项目名称和类型名称
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findProjectTNByid 
	* @Description: TODO 
	* @param applyId
	* @return 设定文件 
	* @return ProjectEntity 返回类型 
	* @date 2016-5-10 下午2:50:31
	* @throws 
	*/
	public ProjectEntity findProjectTNByid(int applyId);
	
	
	/** 
	* BlackMemberJudgmentOne   
	* TODO 判断是否是黑名单并能否执行下一步 
	* @author ZZY  
	* @Title: BlackMemberJudgmentOne
	* @Description: TODO 
	* @param memberId 会员id
	* @param mType 黑名单禁止项类型
	* @return int 返回类型  -1：该会员已存在于黑名单限制禁止操作 ；非-1：允许继续操作
	* @date 2016-5-11 下午3:26:56
	* @throws 
	*/
	int BlackMemberJudgmentOne(long memberId, int mType);
	
	/**
	 * 根据项目ID查询该项目的投资记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param Map{}
	 * @param @return 设定文件 
	 * @return List<InvestRecordEntity> 返回类型 
	 * @date 2016-4-12 下午2:16:44
	 */
	public List<InvestRecordInfoEntity>  selectInvestListByProjectID(Map<String,Object> map);
	
	/** 
	 * 根据项目申请记录id查询项目详情   ProjectBaseInfoEntitys
	 * @author 刘利   
	 * @Description: 根据项目申请记录id查询项目详情  
	 * @param id  项目申请记录id 
	 * @return ProjectAppProcessEntity 返回类型 
	 * @date 2016-3-21 下午1:55:21 
	 */
	ProjectDetailEntity  selectProjectDetailByID(long id);
	
	/**
	 * 根据投资ID查询投资信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param investID 投资ID
	 * @param @return 设定文件 
	 * @return InvestRecordEntity 返回类型 
	 * @date 2016-4-12 下午2:56:27
	 */
	public InvestRecordInfoEntity selectInvestInfoByInvestID(long investID);
	/**
	 * 根据项目申请ID查询该项目的还款计划
	 * @author 刘利   
	 * @Description: TODO 
	 * @param applyID 项目申请ID
	 * @param @return 设定文件 
	 * @return List<LoanRepayEntity> 返回类型 
	 * @date 2016-4-12 下午3:16:00
	 */
	public List<LoanRepayEntitys> selectLoanRepayIDByapplyID(long applyID);
 
	
	/** 
	* findUserMoney 查询账户可用余额
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findUserMoney 
	* @Description: TODO 
	* @param @param memberID
	* @param @param memberType
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-5-19 下午3:05:01
	* @throws 
	*/
	public long findUserMoney(long memberID,int memberType);
	
	
	/** 
	* findInterestMngFee 利息管理费
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: findInterestMngFee 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-5-19 下午3:11:14
	* @throws 
	*/
	public long findInterestMngFee();
	
	/** 
	* selectcAccountById 查询担保机构开户所需基本信息 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: selectcAccountById 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return AccountInterfaceEntity 返回类型 
	* @date 2016-3-28 下午1:38:25
	* @throws 
	*/
	public AccountInterfaceEntity selectbAccountById(Map<String, Object> map);
	
	
	/** 
	* GetEndMoneyByInv 根据债权转让人投资记录ID查询现有有效投资
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: GetEndMoneyByInv 
	* @Description: TODO 
	* @param @param investId
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-5-25 下午6:51:55
	* @throws 
	*/
	public long GetEndMoneyByInv(long investId);
	
	
	/** 
	* loanMemberId 查询借款会员id
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: loanMemberId 
	* @Description: TODO 
	* @param @param lApplyId
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-5-27 下午5:48:48
	* @throws 
	*/
	public long loanMemberId(long lApplyId);
}

