

/** 
* @Title: LuckyDrawService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 上午10:50:06 
* @version V5.0 */
 
package cn.springmvc.service; 
  
import java.util.List;
import java.util.Map;

import cn.invitemastermng.model.LotteryActivityEntity;
import cn.invitemastermng.model.LotteryManage;
import cn.invitemastermng.model.PrizeInformationEntity;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 幸运抽奖
 * @since 
 * @date 2016-4-15 上午10:50:06  */

public interface LuckyDrawService {
	/**
	 * 抽奖等级奖品设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 *   {LotteryID:抽奖活动ID	
	 *	 PrizeID:奖品ID	
	 *	 grade:奖品等级
	 *	 GradeOdds:等级基数
	 *	 WinningOdds:中奖概率基数
	 *	 lID:新生成ID或需要修改的ID} 
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败 ；1成功
	 * @date 2016-4-15 上午10:48:34
	 */
	public int LotteryManageSet(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/** 
	 * 抽奖活动设置 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map
	 * {statu:是否开启关闭本期抽奖：1开启0关闭	
	 *	startDate:抽奖活动开始时间	
	 *	endDate:抽奖活动结束时间
	 *	integra:单次抽奖所需积分
	 *	adminID:操作管理员
	 *	lId:新生成ID或需要修改的ID}
	 * @param @return 设定文件 
	 * @return int 返回类型   0失败 ；1成功
	 * @date 2016-4-15 上午11:20:17
	 */
	public int LotterySet(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
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
	 * @return void 返回类型 
	 * @date 2016-4-15 上午11:48:38
	 */
	public void getLotteryRecord(PageEntity page);
	/**
	 * 奖品删除 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param prizeID 奖品ID
	 * @param @return 设定文件 
	 * @return int 返回类型   0失败 ；1成功
	 * @date 2016-4-15 下午12:44:56
	 */
	public int PrizeDelete(long prizeID,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
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
	 * @return int 返回类型  0失败 ；1成功
	 * @date 2016-4-15 下午1:37:30
	 */
	public int PrizeSet(Map<String,Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 列表查询抽奖活动
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page {statu：1开启0关闭-1全部}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-19 下午4:30:15
	 */
	public void selectLotteryActivity(PageEntity page);
	/**
	 * 列表查询奖品信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page {statu：1有效0无效-1全部}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-19 下午4:49:54
	 */
	public void selectPrizeInformation(PageEntity page);
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
	 * @return void 返回类型 
	 * @date 2016-4-19 下午8:49:46
	 */
	public void selectPrizeByActID(PageEntity page);
	
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
}

