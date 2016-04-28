
package cn.springmvc.dao; 

import cn.sxlc.account.manager.model.LoanTransferReturnEntity;

public interface ProjectInvestWriteDao {
	
	/**
	 * 项目投资返回
	* ProjectInvestBackDeal 项目投资返回 
	* TODO(描述)
	* @author 张友  
	* @Title: ProjectInvestBackDeal 
	* @Description: TODO 
	* @param returnEntity {@link LoanTransferReturnEntity}
	* @param @return 设定文件 
	* @return int  0:失败 	1：成功
	* @date 2016-4-1 下午3:04:36
	* @throws null
	 */
	int ProjectInvestBackDeal(LoanTransferReturnEntity returnEntity);
	
	/**
	 * 添加临时投资记录
	* InsertProjectInvestTmp 添加临时投资记录 
	* TODO(描述)
	* @author 张友  
	* @Title: InsertProjectInvestTmp 
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
	* @throws null
	 */
	int InsertProjectInvestTmp(long lId,long lProjectId,long lMemberId, String sOrderNo, String sSubOrderNo,long lAmountTotal,
			long lRedpackets,String sRedpacketsInfo,long lVouchers,short isAuto,String sKey);

	/**
	 * 
	* CheckInvestRedPackage(投资页面返回时判断是否获取惊喜红包，及惊喜红包金额) 
	* TODO(描述)
	* @author 张友  
	* * @Title: CheckInvestRedPackage 
	* @Description: TODO 
	* @param sStatu					投资状态 0成功 1失败
	* @param sType					投资类型 （0：会员账户投资 1：红包账户投资 ）
	* @param sOrderNo				请求订单号
	* @param sClient				投资类型 0：pc 1：app 2：微信端
	* @param sKey					加密解密key
	* @param 设定文件 
	* @return long 返回类型 			-1：未获取奖励金额 0：获取奖励金额为0 >0:获取惊喜红包金额
	* @date 2016-4-21 下午3:49:55
	* @throws null
	 */
	long CheckInvestRedPackage(short sStatu,short sType,String sOrderNo,short sClient,String sKey);
}

