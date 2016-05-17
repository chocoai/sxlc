
package cn.springmvc.dao; 

import java.util.List;

import cn.membermng.model.MemberTradingIdEntity;

public interface BalanceDealDao {
	
	/**
	 * 获取待处理的会员交易记录
	* GetUnDealRecordList	获取待处理的会员交易记录
	* TODO					获取待处理的会员交易记录
	* @author 张友  
	* * @Title: GetUnDealRecordList 
	* @Description: TODO 
	* @param @return  			待处理的会员交易记录
	* @return List<Long> 返回类型 
	* @date 2016-5-5 下午5:12:19
	* @throws null
	 */
	List<MemberTradingIdEntity> GetUnDealRecordList();
	
	/**
	 * 交易记录余额处理
	* MemberBalanceDeal		交易记录余额处理 
	* TODO					交易记录余额处理
	* @author 张友  
	* * @Title: MemberBalanceDeal 
	* @Description: TODO 
	* @param lRecordId 		交易记录ID 
	* @return void 返回类型 
	* @date 2016-5-5 下午5:13:43
	* @throws null
	 */
	void MemberBalanceDeal(long lRecordId);
	
	/**
	 * 获取待处理信息账户的会员交易记录
	* GetUnDealAccountRecordList			获取待处理信息账户的会员交易记录
	* TODO									获取待处理信息账户的会员交易记录
	* @author 张友  
	* * @Title: GetUnDealAccountRecordList 
	* @Description: TODO 
	* @param @return 
	* @return List<MemberTradingIdEntity> 返回类型 
	* @date 2016-5-5 下午9:38:35
	* @throws null
	 */
	List<MemberTradingIdEntity> GetUnDealAccountRecordList();
	
	/**
	 * 处理信息账户的会员交易记录
	* MemberAccountDeal						处理信息账户的会员交易记录 
	* TODO(描述)
	* @author 张友  
	* * @Title: MemberAccountDeal 
	* @Description: TODO 
	* @param lRecordId 						交易记录ID
	* @return void 返回类型 
	* @date 2016-5-5 下午9:40:55
	* @throws  null
	 */
	void MemberAccountDeal(long lRecordId);
}

