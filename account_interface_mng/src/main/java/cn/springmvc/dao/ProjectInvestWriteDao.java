
package cn.springmvc.dao; 

import cn.account_interface_mng.model.LoanTransferReturnEntity;

public interface ProjectInvestWriteDao {
	
	/**
	 * 项目投资返回
	* ProjectInvestBackDeal 项目投资返回 
	* TODO(描述)
	* @author 张友  
	* * @Title: ProjectInvestBackDeal 
	* @Description: TODO 
	* @param @param returnEntity		
	* @param @return 设定文件 
	* @return int  0:失败 	1：成功
	* @date 2016-4-1 下午3:04:36
	* @throws 无
	 */
	public int ProjectInvestBackDeal(LoanTransferReturnEntity returnEntity);
	
	/**
	 * 添加临时投资记录
	* InsertProjectInvestTmp 添加临时投资记录 
	* TODO(描述)
	* @author 张友  
	* * @Title: InsertProjectInvestTmp 
	* @Description: TODO 
	* @param  lId					记录ID
	* @param  lProjectId			项目ID
	* @param  lMemberId			会员ID
	* @param  sOrderNo			投资订单号
	* @param  lAmountTotal		投资总金额		(单位元，保留4位小数)
	* @param  lRedpackets			投资红包总金额	(单位元，保留4位小数)
	* @param  sRedpacketsInfo		投资红包详情		红包1ID,使用金额(单位元  格式：0.20元，保留2位小数);红包ID2,使用金额;
	* @param  lVouchers			投资代金券金额	(单位元，保留4位小数)
	* @param  isAuto				是否为自动投标	0：否 	1：是
	* @param  sKey					加密解密key
	* @param @return 设定文件 				
	* @return int 0:失败 	1：成功
	* @date 2016-4-1 下午3:27:01
	* @throws wu
	 */
	public int InsertProjectInvestTmp(long lId,long lProjectId,long lMemberId,String sOrderNo,long lAmountTotal,
			long lRedpackets,String sRedpacketsInfo,long lVouchers,short isAuto,String sKey);
}

