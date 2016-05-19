package cn.springmvc.service;


import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.springmvc.model.InvestRecordInfoEntity;
import cn.sxlc.account.manager.model.AccountInterfaceEntity;
import cn.sxlc.account.manager.model.AuditEntity;
import cn.sxlc.account.manager.model.AuthorizeInterfaceEntity;
import cn.sxlc.account.manager.model.LoanTransferEntity;
import cn.sxlc.account.manager.model.RechargeEntity;
import cn.sxlc.account.manager.model.RepayInterfaceEntity;
import cn.sxlc.account.manager.model.WithdrawsInterdaceEntity;

/** 
* 关于第三方  还款接口
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-7 下午2:17:23  */
@WebService
public interface RepaymentInterfaceServer {
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
	* @param @param iStatu 0：提前还款  1：正常还款	
	* @param @return 设定文件 
	* @return RepayInterfaceEntity 返回类型 
	* @date 2016-4-7 下午3:01:39
	* @throws 
	*/
	public LoanTransferEntity GetRepayInfoById(long lId,long applayid,long lmoney,
			int isUpdate,int[] iStatu,long lonmemberId, int lonmembertype,HttpServletRequest request,String returnURL,String notifyURL); 

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
	public RepayInterfaceEntity RepaymentProcessing(long lonmemberId,
			int lonmembertype,long appplyId,long repalyId,int[] results);
	
	/** 
	* earlyRepaymentSubm 还款提交第三方 数据处理 
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
	public LoanTransferEntity earlyRepaymentSubm(RepayInterfaceEntity repayInterfaceEntity,
			HttpServletRequest request,String returnURL,String notifyURL);
	
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
	public String testRepaymentReturn(HttpServletRequest request,HttpServletResponse response);
	
	
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
	public void testRepaymentNotify(HttpServletRequest request,HttpServletResponse response);
	
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
	
	
}
