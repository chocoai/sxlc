
package cn.springmvc.service; 

import java.util.List;

import cn.sxlc.account.manager.model.UnUsedRedpacketsEntity;

/**
 * 投资账户信息 包括：可用红包，可用代金券余额
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-4-27 下午8:03:43
 */
public interface AccountSupportService {
	/**
	 * 获取会员剩余代金券
	* getRemainderVouchers						获取会员剩余代金券
	* TODO										获取会员剩余代金券
	* @author 张友  
	* * @Title: getRemainderVouchers 
	* @Description: TODO 
	* @param  lMemberId					会员ID
	* @param @return 设定文件 
	* @return long 						剩余代金券	保留4位小数
	* @date 2016-4-27 下午9:01:58
	* @throws	null
	 */
	long getRemainderVouchers(long lMemberId);
	
	/**
	 *  获取会员可用红包列表
	* getMemberUnUsedRedPackets							 获取会员可用红包列表 
	* TODO												 获取会员可用红包列表
	* @author 张友  
	* * @Title: getMemberUnUsedRedPackets 
	* @Description: TODO 
	* @param  lMemberId									会员ID
	* @param @return 									可用红包列表
	* @return List<UnUsedRedpacketsEntity> 返回类型 
	* @date 2016-4-27 下午9:03:30
	* @throws null
	 */
	List<UnUsedRedpacketsEntity> getMemberUnUsedRedPackets(long lMemberId);
}

