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
* 关于第三方托管接口  代偿处理
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-7 下午2:17:23  */
@WebService
public interface CompensatoryInterfaceServer {
	/** 
	* Compensatory 代偿数据查询
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: Compensatory 
	* @Description: TODO 
	* @param @param daicangId 代偿方 id  
	* @param @param daicangtype 代偿方类型  1：担保机构 2平台
	* @param @param appplyId 借款申请id
	* @param @param repalyId 还款计划id
	* @param @param results 
	* @param @return 设定文件 
	* @return LoanTransferEntity 返回类型 
	* @date 2016-4-8 下午3:58:08
	* @throws 
	*/
	public LoanTransferEntity Compensatory( long appplyId,long repalyId, int[] results,long daicangId,int daicangtype,HttpServletRequest request,String returnURL,String notifyURL);

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
	public LoanTransferEntity earlyRepaymentSubm(RepayInterfaceEntity repayInterfaceEntity,HttpServletRequest request,String returnURL,String notifyURL);

	/** 
	* testRepaymentReturn 代偿双乾第三方页面返回信息处理 
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
	public String CompensatoryReturn(HttpServletRequest request,HttpServletResponse response);
	
	
	/** 
	* testRepaymentNotify 代偿双乾第三方服务器返回信息处理
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
	public void CompensatoryNotify(HttpServletRequest request,HttpServletResponse response);
}
