

/** 
* @Title: LuckyDrawListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 上午11:46:47 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import cn.invitemastermng.model.LotteryActivityEntity;
import cn.invitemastermng.model.LotteryManage;
import cn.invitemastermng.model.LotteryRecordsEntity;
import cn.invitemastermng.model.PrizeInformationEntity;

import product_p2p.kit.pageselect.PageEntity;

/** 
 * @author 刘利 
 * @Description: 幸运抽奖 
 * @since 
 * @date 2016-4-15 上午11:46:47  */

public interface LuckyDrawListDao {
	/**
	 * 抽奖记录 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 *  #{skey}              #{Period}         #{Grade}
	 *  #{Prize_Type}        #{Prize_Name}     #{Lottery_Time_Min}
	 *  #{Lottery_Time_Max}  #{Member_No}      #{Logname}
	 *	#{Personal_Phone}    #{Start_Date_Min} #{Start_Date_Max}
	 *  #{ordercolumn}       #{orderDsec(0:降序；1升序)}
	 * @param @return 设定文件 
	 * @return List<LotteryRecordsEntity> 返回类型 
	 * @date 2016-4-15 上午11:47:32
	 */
	public List<LotteryRecordsEntity> getLotteryRecord(PageEntity page);
	/**
	 * 列表查询抽奖活动
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page {statu：1开启0关闭-1全部}
	 * @param @return 设定文件 
	 * @return List<LotteryActivityEntity> 返回类型 
	 * @date 2016-4-19 下午4:30:15
	 */
	public List<LotteryActivityEntity> selectLotteryActivity(PageEntity page);
	/**
	 * 列表查询奖品信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page {statu：1有效0无效-1全部}
	 * @param @return 设定文件 
	 * @return List<PrizeInformationEntity> 返回类型 
	 * @date 2016-4-19 下午4:49:54
	 */
	public List<PrizeInformationEntity> selectPrizeInformation(PageEntity page);
	/**
	 * 根据ID查询抽奖活动 信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param lotteryID
	 * @param @return 设定文件 
	 * @return LotteryActivityEntity 返回类型 
	 * @date 2016-4-19 下午4:58:20
	 */
	public LotteryActivityEntity selectLotteryActivityByID(long lotteryID);
	/**
	 * 根据ID查询奖品信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return PrizeInformationEntity 返回类型 
	 * @date 2016-4-19 下午5:02:28
	 */
	public PrizeInformationEntity selectPrizeInformationByID(long prizeID);
	/**
	 * 根据抽奖活动ID查询该活动的奖品信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  page {prizeID 抽奖活动ID}
	 * @param @return 设定文件 
	 * @return List<PrizeInformationEntity> 返回类型 
	 * @date 2016-4-19 下午8:49:46
	 */
	public List<PrizeInformationEntity> selectPrizeByActID(PageEntity page);
	
	
	/**
	 * 获奖期数下拉
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<Integer> 返回类型 
	 * @date 2016-5-12 上午10:34:27
	 */
	public List<LotteryActivityEntity>  selectperiod();
	
	/**
	 * 获奖等级下拉
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<Integer> 返回类型 
	 * @date 2016-5-12 上午10:34:27
	 */
	public List<LotteryManage>  selectgrade();
	
	/**
	 * 获奖等级下拉
	 * TODO(描述)
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return List<Integer> 返回类型 
	 * @date 2016-5-12 上午10:34:27
	 */
	public List<PrizeInformationEntity>  selectPrizeTypes();
	
	
	/**
	 * 查询最近一期 抽奖活动 
	 * @author 刘利   
	 * @Description: TODO  
	 * @param @return 设定文件 
	 * @return LotteryActivityEntity 返回类型 
	 * @date 2016-4-19 下午4:58:20
	 */
	public LotteryActivityEntity selectLotteryActivitylimit();
}

