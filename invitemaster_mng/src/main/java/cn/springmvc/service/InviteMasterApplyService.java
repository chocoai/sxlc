

/** 
* @Title: GenerateRepayListService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:57:04 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.InvestRepaymentEntity;
import cn.invitemastermng.model.InvitationRecordEntity;
import cn.invitemastermng.model.InviteMasterAwardRecordEntity;

/**
 * 
 * @author 刘利 
 * @Description: 推荐达人申请
 * @since 
 * @date 2016-4-5 上午11:12:03
 */

public interface InviteMasterApplyService {
	/**
	 * 推荐达人申请  
	 * @author 刘利    
	 * @param 会员ID memberID，推荐达人ID:imApplyID
	 * @param @return 设定文件 
	 * @return int 返回类型 1成功，0失败 ，-1该会员已是推荐达人，或存在未审核的申请记录
	 * @date 2016-4-5 上午11:07:37
	 */
	public int insertInviteMasterApply(long memberID);
	/**
	 * 推荐达人提奖记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * map{skey,startTime ,endTime,dateStart(1今天，2近一本周，3近一月，4近6月),memberID}
	 * @param @return 设定文件 
	 * @return List<InviteMasterAwardRecordEntity> 返回类型 
	 * @date 2016-4-28 下午8:35:22
	 */
	public List<InviteMasterAwardRecordEntity> getInviteMasterAwardRecord(PageEntity page);
	/**
	 *  推荐达人历史返现
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * map{month(提奖统计月份一月：01，二月:02),startTime ,endTime,memberID}
	 * @param @return 设定文件 
	 * @return List<AwardPaymentRecordEntity> 返回类型 
	 * @date 2016-4-28 下午8:37:00
	 */
	public List<AwardPaymentRecordEntity> getInviteMasterHistoryBack(PageEntity page);
	/**
	 * 推荐达人邀请记录 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * map{memberID,isopenThird(1开户，2未开户，-1全部),startTime ,endTime,name(会员/用户名)，order（1降序,2升序） }
	 * @param @return 设定文件 
	 * @return List<InvitationRecordEntity> 返回类型 
	 * @date 2016-4-28 下午8:37:50
	 */
	public List<InvitationRecordEntity> getInviteInvitationRecord(PageEntity page);
	/**
	 * 推荐达人推荐借款明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * map{projectTitle借款名称,startTime ,endTime,name(会员/用户名),memberID,order(1根据放款时间降序,2根据放款时间升序 )}
	 * @param @return 设定文件 
	 * @return List<selectInviteBorrowing> 返回类型 
	 * @date 2016-4-28 下午8:38:34
	 */
	public List<BorrowingDetailedEntity> selectInviteBorrowing(PageEntity page);
	/**
	 * 推荐达人投资明细 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * map{projectTitle借款名称,startTime ,endTime,name(会员/用户名),memberID,order(1根据预期收益时间降序,2根据预期收益升序 )}
	 * @param @return 设定文件 
	 * @return List<InvestDetailedEntity> 返回类型 
	 * @date 2016-4-28 下午8:39:34
	 */
	public List<InvestDetailedEntity> getInviteInvest(PageEntity page);
	/**
	 * 推荐达人VIP购买明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * map{startTime ,endTime,name(会员/用户名),memberID,order(1根据支付时间降序,2根据支付时间升序 )}
	 * @param @return 设定文件 
	 * @return List<BayVIPEntity> 返回类型 
	 * @date 2016-4-28 下午8:40:13
	 */
	public List<BayVIPEntity> getInviteVipPay(PageEntity page);
	/**
	 * 推荐达人还本明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 *  map{projectTitle借款名称,startTime ,endTime,name(会员/用户名),
	 *  memberID,order(1根据还款时间降序,2根据还款时间升序 ),over(1逾期，2未逾期，-1全部)}
	 * @param @return 设定文件 
	 * @return List<InvestRepaymentEntity> 返回类型 
	 * @date 2016-4-28 下午8:00:06
	 */
	public List<InvestRepaymentEntity> getRepaymentInvite(PageEntity page);
	/**
	 * 推荐达人数据统计
	 * @author 刘利   
	 * @Description: TODO 
	 * @param memberID 
	 * @param @return 设定文件 
	 * @return InviteMasterAwardRecordEntity 返回类型 
	 * @date 2016-5-1 下午3:26:05
	 */
	public InviteMasterAwardRecordEntity selectInviteMasterStatistic(long memberID);
	
	/**
	 * 推荐达人提奖记录excel导出
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map{skey,startTime ,endTime,dateStart(1今天，2近一本周，3近一月，4近6月),memberID}
	 * @param @return 设定文件 
	 * @return List<InviteMasterAwardRecordEntity> 返回类型 
	 * @date 2016-4-28 下午8:35:22
	 */
	public List<InviteMasterAwardRecordEntity> getInviteMasterAwardRecordExcel(Map<String,Object> map);
	
	
	/**
	 * 推荐达人历史返现EXCEl导出
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map{month(提奖统计月份一月：01，二月:02),startTime ,endTime,memberID}
	 * @param @return 设定文件 
	 * @return List<AwardPaymentRecordEntity> 返回类型 
	 * @date 2016-4-28 下午8:37:00
	 */
	public List<AwardPaymentRecordEntity> getInviteMasterHistoryBackExcel(Map<String,Object> map);
}

