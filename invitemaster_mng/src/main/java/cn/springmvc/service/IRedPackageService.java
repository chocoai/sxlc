package cn.springmvc.service; 

import java.util.List;

import cn.invitemastermng.model.LotteryRecords;
import cn.invitemastermng.model.PrizeInformation;
import cn.invitemastermng.model.RedRecord;

import product_p2p.kit.pageselect.PageEntity;


/***
* 活动红包服务
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-19 下午1:54:02 
*
*/
public interface IRedPackageService {

	
	/***
	* 获取最新红包领取记录
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-4-19 下午2:05:59
	*/
	public List<RedRecord> redRecord(PageEntity entity);

	
	
	/***
	* 领取红包
	* 
	* @author 李杰
	* @param affairId				活动编号
	* @param memberId				会员边海
	* @return
	* 1领取成功、0领取失败、-1当前活动不存在、-2活动未开始、-3活动已结束、-4你已经领过了、-5红包被领完了  -6;//黑名单会员禁止抢红包
	* @date 2016-4-19 下午3:01:38
	 */
	public int grabRedPackage(long affairId, long memberId);



	/***
	* 奖品信息列表
	* 
	* @author 李杰
	* @Title: prizeInformations
	* @return
	* @date 2016-4-19 下午7:14:39
	*/
	public List<PrizeInformation> prizeInformations();


	/***
	* 获奖名单
	* 
	* @author 李杰
	* @Title: winners
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-19 下午7:49:48
	 */
	public List<LotteryRecords> winners(PageEntity entity);



	/***
	* 抽奖
	* 
	* @author 李杰
	* @Title: lottery
	* @param lid
	* @return
	* @date 2016-4-13 上午11:03:38
	*/
	public int lottery(long lid);
	
	
	
	
	
}

