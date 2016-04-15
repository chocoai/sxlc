

/** 
* @Title: LoanService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-14 上午9:15:56 
* @version V5.0 */
 
package cn.springmvc.service; 

/** 
 * @author 刘利 
 * @Description: 项目放款
 * @since 
 * @date 2016-4-14 上午9:15:56  */

public interface LoanService { 
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
	public int Loan(long lApplyId,String sMerBillNo,String sOrderNos,int iStatu,
			String backInfoenc,String backinfo);
}

