

/** 
* @Title: LotteryManageDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 上午10:19:18 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;
 

/** 
 * @author 刘利 
 * @Description: 抽奖管理
 * @since 
 * @date 2016-4-15 上午10:19:18  */

public interface LuckyDrawDao {
	/**
	 * 抽奖等级奖品设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 *  {LotteryID:抽奖活动ID	
	 *	 PrizeID:奖品ID	
	 *	 grade:奖品等级
	 *	 GradeOdds:等级基数
	 *	 WinningOdds:中奖概率基数
	 *	 lID:新生成ID或是需要修改的ID}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-15 上午10:48:34
	 */
	public int LotteryManageSet(Map<String,Object> map);
	/**
	 * 抽奖设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 *  {statu:是否开启关闭本期抽奖：1开启0关闭	
	 *	startDate:抽奖活动开始时间	
	 *	endDate:抽奖活动结束时间
	 *	integra:单次抽奖所需积分
	 *	adminID:操作管理员
	 *	lId:新生成ID}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-15 上午11:17:22
	 */
	public int LotterySet(Map<String,Object> map);
	/**
	 * 奖品删除
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-15 下午12:43:14
	 */
	public int PrizeDelete(Map<String,Object> map);
	/**
	 * 奖品设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * {prizetype:字典：奖品类型DICT_JPLX
	 *	prizename:奖品名称	
	 *	prizeWorth:奖品价值（红包面值、实物市值、代金券面值、返现券面值）
	 *	prizeQuantity:奖品剩余数量
	 *	prizeUrl:奖品图片路径
	 *	lId:新生成ID或需要修改的ID} 
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-15 下午1:37:30
	 */
	public int PrizeSet(Map<String,Object> map);
}

