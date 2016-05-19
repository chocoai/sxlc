
package cn.springmvc.dao;

import java.util.Map;


/** 
 * 第三方交互相关操作
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-28 下午2:10:45  */
public interface HandleThreePartyDao {
	
	/** 
	* insertThirdInterfaceRecord 添加第三方交互操作信息 
	* TODO(描述) 添加第三方交互操作信息
	* @author 朱祖轶  
	* * @Title: insertThirdInterfaceRecord 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-3-28 下午2:11:02
	* @throws 
	*/
	public int insertThirdInterfaceRecord(Map<String, Object> map);
	
	
	/** 
	* openAccountBack 开户成功处理
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: openAccountBack 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-28 下午3:17:19
	* @throws 
	*/
	public int openAccountBack(Map<String, Object> map);
	
	
	/** 
	* rechargeBack 充值成功返回处理
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: rechargeBack 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-29 下午4:47:24
	* @throws 
	*/
	public Map<String, Object> rechargeBack(Map<String, Object> map);
	
	
	/** 
	* authorizeBack 授权操作成功返回处理
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: authorizeBack 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-29 下午6:36:13
	* @throws 
	*/
	public Map<String, Object> authorizeBack(Map<String, Object> map);
	
	
	/** 
	* ProjectFail 流标返回处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ProjectFail 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-30 下午2:12:48
	* @throws 
	*/
	public int ProjectFail(Map<String, Object> map);
	
	
	/** 
	* MemberWithdrawalBack_Qianduoduo 提现成功返回处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: MemberWithdrawalBack_Qianduoduo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-31 下午7:43:09
	* @throws 
	*/
	public  int MemberWithdrawalBack_Qianduoduo(Map<String, Object> map);
	
	
	/** 
	* WithdraBack  提现平台审核返回 、银行打回
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: WithdraBack 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-3-31 下午7:44:01
	* @throws 
	*/
	public  int WithdraBack(Map<String, Object> map);
	
	
	/** 
	* generateorderNo 生成平台操作订单号
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: generateorderNo 
	* @Description: TODO 
	* @param @param prefix 订单号前缀
	* @param @return 设定文件 
	* @return String 返回类型 
	* @date 2016-4-1 上午9:28:16
	* @throws 
	*/
	public String generateorderNo(String prefix);
	
	
	/** 
	* CreditorTransfer 债权转让放款返回处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CreditorTransfer 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-14 上午10:17:11
	* @throws 
	*/
	public int CreditorTransfer(Map<String, Object> map);
	
	
	
	/** 
	* RepayBackQianduoduo 还款返回处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: RepayBackQianduoduo 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-20 下午2:14:40
	* @throws 
	*/
	public int RepayBackQianduoduo(Map<String, Object> map);
	
	
	/** 
	* addInvestIncome(新增收益计划) 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: addInvestIncome 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-14 下午3:57:45
	* @throws 
	*/
	public Map<String, Object> addInvestIncome(Map<String, Object> map);
	
	
	/** 
	* updateProjrctTransStatu 修改债权转让项目状态为还款中 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: updateProjrctTransStatu 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-14 下午5:06:31
	* @throws 
	*/
	public int updateProjrctTransStatu(Map<String, Object> map);
	
	
	/** 
	* TransFail 债权转让流标返回处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: TransFail 
	* @Description: TODO 
	* @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-14 下午8:35:33
	* @throws 
	*/
	public int TransFail(Map<String, Object> map);
	
	
	/** 
	* ReturnOfDeposit 保证金退回成功处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: ReturnOfDeposit 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return Map<String,Object> 返回类型 
	* @date 2016-4-15 下午2:33:40
	* @throws 
	*/
	public Map<String, Object> ReturnOfDeposit(Map<String, Object> map);
	
	
	/** 
	* SurpriseRedBack 惊喜红包发放返回处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: SurpriseRedBack 
	* @Description: TODO 
	* @param @param map 设定文件 
	* @return int 返回类型 
	* @date 2016-4-18 下午5:07:54
	* @throws 
	*/
	public int SurpriseRedBack(Map<String, Object> map);
	/** 
	* SurpriseRedBack 惊喜红包提交信息标记 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: SurpriseRedBack 
	* @Description: TODO 
	* @param @param map 设定文件 
	* @return int 返回类型 
	* @date 2016-4-18 下午5:07:54
	* @throws 
	*/
	public int DataTagBySurpriseRed(Map<String, Object> map);
	
	
	/** 
	* insertMemberTransferRecord 添加好友转账记录 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: insertMemberTransferRecord 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-19 上午11:44:00
	* @throws 
	*/
	public int insertMemberTransferRecord(Map<String, Object> map);
	
	
	/** 
	* MemberTransferBack 好友转让返回处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: MemberTransferBack 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-19 下午2:56:53
	* @throws 
	*/
	public int MemberTransferBack(Map<String, Object> map);
	
	
	/** 
	* PlatformAwardMoneyBack 平台提奖操作第三方返回处理 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: PlatformAwardMoneyBack 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-20 上午11:59:09
	* @throws 
	*/
	public int PlatformAwardMoneyBack(Map<String, Object> map);
	
	
	/** 
	* AddVipPurchaseRecord vip购买记录添加（提交到第三方前）
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: AddVipPurchaseRecord 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-4-21 下午1:42:12
	* @throws 
	*/
	public int AddVipPurchaseRecord(Map<String, Object> map);
	
	public int PurchaseVipBack(Map<String, Object> map);
	
	/**
	 * 项目放款  
	 * @author 刘利   
	 * @Description: TODO 
	 * @param lApplyId 借款申请ID
	 * @param sMerBillNo 本次商户订单号
	 * @param sOrderNos 放款投资订单号
	 * @param iStatu 放款状态(0 成功；1 失败)
	 * @param backInfoenc
	 * @param backinfo
	 * @param @return 设定文件 
	 * @return int 返回类型  0：失败 1：成功 -1：本次放款已经处理
	 * @date 2016-4-14 上午9:21:05
	 */
	public int FangKuanLoan(long lApplyId,String sMerBillNo,String sOrderNos,int iStatu,
			String backInfoenc,String backinfo);
	
	/**
	 * 新增收益计划 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * @param @return 设定文件 
	 * @return int 返回类型  0失败1成功
	 * @date 2016-4-12 下午3:47:23
	 */
	public int  insertInvestIncome(Map<String,Object> map);
	
	/**
	 * 修改还款计划收益平账 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-12 下午4:40:54
	 */
	public int updateReplay(Map<String,Object> map);
	
	
	/** 
	* CompensatoryRepayBack 代偿返回处理
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: CompensatoryRepayBack 
	* @Description: TODO 
	* @param @param map
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-18 下午5:16:02
	* @throws 
	*/
	public int CompensatoryRepayBack(Map<String,Object> map );
}

