

/** 
* @Title: InvestJudgeService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-25 上午11:00:09 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.Map;

/** 
 * @author 刘利 
 * @Description: 投资确认判断 
 * @since 
 * @date 2016-3-25 上午11:00:09  */

public interface InvestJudgeService {
	/**
	 *  根据项目ID与会员ID查询该会员投资该项目的总金额 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map{applyId,memberID}
	 * @param @return 设定文件 
	 * @return long 返回类型 
	 * @date 2016-3-25 下午12:46:47
	 */
	public long selectInvestAmountByMemID(Map<String,Object> map);
	/**
	 * 根据项目ID查询改项目已投资总笔数
	 * @author 刘利   
	 * @Description: TODO 
	 * @param applyID项目申请ID 
	 * @return long 返回类型 
	 * @date 2016-3-25 下午12:46:47
	 */
	public int selectInvestCountByApplyID(long applyID);
	/**
	 * 根据红包ID和会员id查询红包信息
	 * @author 刘利   
	 * @Description:根据红包ID和会员id查询红包信息
	 * @param applyID项目申请ID 
	 * @return long 返回类型 
	 * @date 2016-3-25 下午12:46:47
	 */
	public Map<String,Object> selectGiftInfobyID(Map<String,Object> map);
	/**
	 *  查询红包使用百分比
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-3-25 下午4:03:16
	 */
	public int selectRedpacketsRateMax();
}

