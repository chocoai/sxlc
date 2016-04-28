
package cn.springmvc.service; 

import cn.sxlc.account.manager.model.LoanTransferReturnEntity;
import cn.sxlc.account.manager.model.TransferSubmitEntity;

/**
 * 投资service接口
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-4-27 下午7:55:26
 */
public interface ProjectInvestService {
	/**
	 * 获取某个会员对某个项目的当前最大可投金额
	* GetMaxInvestAmount 获取某个会员对某个项目的当前最大可投金额
	* TODO(描述)
	* @author 张友  
	* * @Title: GetMaxInvestAmount 	获取某个会员对某个项目的当前最大可投金额
	* @Description: TODO 
	* @param @param lProjectId				项目ID
	* @param @param lMemberId				会员ID
	* @param @param sKey					加密，解密key值
	* @param @param sIsAuto					是否自动投标		0：否	1：是
	* @param @return 可投资金额
	* @return long 返回类型 					可投资金额
	* @date 2016-4-27 下午7:57:22
	* @throws	null
	 */
	long GetMaxInvestAmount(long lProjectId, long lMemberId, String sKey, short sIsAuto);
	
	
	
	/**
	 * 会员项目投资，投资前信息处理   同时添加临时投资记录
	* MemberInvestCheck 会员项目投资，投资前信息处理
	* TODO				会员项目投资，投资前信息处理
	* @author 张友  
	* * @Title: MemberInvestCheck 
	* @Description: TODO 
	* @param  lMemberId					投资会员id
	* @param  lProjectId					投资项目id
	* @param  sIsAuto						是否为自动投标
	* @param  lAmount						投资总金额		(单位元，保留4位小数)
	* @param  sRedpacketsInfo				红包使用金额		红包1ID,使用金额(单位元，保留4位小数);红包ID2,使用金额;
	* @param  lVouchers					代金券金额		(单位元，保留4位小数)
	* @param  sKey						加密解密key
	* @param  lRedpackets					返回使用红包金额
	* @param  sDirectPwd					定向标密码
	* @param @return 							返回结果 success： 验证成功 	fail： 验证失败    其他：验证失败，返回原因
	* @return String 返回类型 						
	* @date 2016-4-27 下午8:06:16
	* @throws null
	 */
	String MemberInvestCheck(long lMemberId, long lProjectId,
            short sIsAuto, long lAmount, String sRedpacketsInfo,
            long lVouchers, String sKey, long[] lRedpackets, String sDirectPwd);
	
	/**
	 * 调用投资接口前 获取投资详情  添加临时投资记录
	* GetInvestInfo 		调用投资接口前 获取投资详情   
	* TODO					调用投资接口前 获取投资详情   
	* @author 张友  
	* * @Title: GetInvestInfo 		调用投资接口前 获取投资详情   
	* @Description: TODO 
	* @param  sIsAuto			自动投标	0：否 1：是
	* @param  lMemberId			投资会员id
	* @param  lProjectId		投资项目id
	* @param  lAmount			投资总金额
	* @param  lRedpackets		选择红包信息
	* @param  lVouchers			使用代金券
	* @param  sClient			投资客户端	
	* @param @return 
	* @return TransferSubmitEntity 返回类型 
	* @date 2016-4-27 下午8:11:14
	* @throws null
	 */
	TransferSubmitEntity GetInvestInfo(short sIsAuto, long lMemberId, long lProjectId,
            long lAmount, long lRedpackets, long lVouchers, short sClient,String sKey);
	
	/**
	 * 项目投资返回
	* ProjectInvestBackDeal			项目投资返回 
	* TODO							项目投资返回
	* @author 张友  
	* * @Title: ProjectInvestBackDeal 项目投资返回
	* @Description: TODO 
	* @param  returnEntity		投资返回对象
	* @param @return 					0:失败 	1：成功
	* @return int 返回类型 
	* @date 2016-4-27 下午8:29:44
	* @throws	null
	 */
	int ProjectInvestBackDeal(LoanTransferReturnEntity returnEntity);
	
	/**
	 * 投资返回页面判断是否获取惊喜红包
	* CheckInvestRedPackage					投资返回页面判断是否获取惊喜红包
	* TODO									投资返回页面判断是否获取惊喜红包
	* @author 张友  
	* * @Title: CheckInvestRedPackage 		投资返回页面判断是否获取惊喜红包
	* @Description: TODO 
	* @param  sStatu						投资结果	0：成功 1：失败 
	* @param sType							投资类型 （0：会员账户投资 1：红包账户投资 ）
	* @param sOrderNo						请求订单号
	* @param sClient						投资类型 0：pc 1：app 2：微信端
	* @param sKey							加密解密key
	* @return long 返回类型 					-1：未获取奖励金额 0：获取奖励金额为0 >0:获取惊喜红包金额				
	* @date 2016-4-27 下午8:32:50
	* @throws null
	 */
	long CheckInvestRedPackage(short sStatu, short sType,
			String sOrderNo, short sClient, String sKey);
}

