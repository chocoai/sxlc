package cn.springmvc.dao; 

import java.util.Map;


/***
* 红包数据写
* 
* @author 李杰
* @since 
* @date 2016-4-19 下午3:04:53 
*
*/
public interface IRedPackageWriteDao {

	
	/***
	* 领取红包
	* 
	* @author 李杰
	* @Title: grabRedPackage
	* @param affairId				活动编号
	* @param memberId				会员编号
	* @return
	* @date 2016-4-19 下午3:07:20
	*/
	int grabRedPackage(Map<String,Object> param);

	
	/***
	* 抽奖结束保存抽奖信息
	* 
	* @author 李杰
	* @Title: lotteryEnd
	* @param param
	* @return
	* @date 2016-4-13 上午11:56:26
	 */
	int lotteryEnd(Map<String,Object> param);
	
	
	
	
	
	
	
	
	
	
	
	
}

