package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.LotteryManage;
import cn.invitemastermng.model.LotteryRecords;
import cn.invitemastermng.model.PrizeInformation;
import cn.invitemastermng.model.RedRecord;
import cn.invitemastermng.model.RedpacketsDetailRecord;


public interface IRedPackageReadDao {

	
	
	/***
	* 红包领取记录
	* 
	* @author 李杰
	* @param entity
	* @return
	* @date 2016-4-19 下午2:10:16
	 */
	List<RedRecord> redRecord(PageEntity entity);

	
	/***
	* 抽奖奖励列表
	* 
	* @author 李杰
	* @Title: prizeInformations
	* @return
	* @Description: TODO
	* @date 2016-4-19 下午7:17:12
	*/
	List<PrizeInformation> prizeInformations();


	/***
	* 获取获奖名单
	* 
	* @author 李杰
	* @Title: winners
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-19 下午7:50:37
	 */
	List<LotteryRecords> winners(PageEntity entity);


	/***
	* 获取抽奖设置
	* 
	* @author 李杰
	* @Title: lottery
	* @param lid							抽奖活动编号
	* @return
	* @date 2016-4-13 上午11:22:13
	*/
	List<LotteryManage> lotteryConfig(long lid);

	
	/***
	* 红包类型设置
	* 
	* @author 李杰
	* @Title: redPackageConf
	* @param aid
	* @return
	* @date 2016-4-13 下午7:41:33
	 */
	List<RedpacketsDetailRecord> redPackageConf(long aid);
	
	/** 
	* BlackMemberJudgmentOne 黑名单 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: BlackMemberJudgmentOne 
	* @Description: TODO 
	* @param memberId
	* @param mType
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-11 下午3:52:28
	* @throws 
	*/
	public int BlackMemberJudgmentTow(long memberId, int mType);
	
}

