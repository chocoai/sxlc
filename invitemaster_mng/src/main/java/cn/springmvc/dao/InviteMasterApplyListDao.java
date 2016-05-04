

/** 
* @Title: GenerateRepayListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:46:58 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;
import java.util.Map;

import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.InvestRepaymentEntity;
import cn.invitemastermng.model.InvitationRecordEntity;
import cn.invitemastermng.model.InviteMasterAwardRecordEntity;

import product_p2p.kit.pageselect.PageEntity;
 
/**
 * 
 * @author 刘利 
 * @Description: 推荐达人申请
 * @since 
 * @date 2016-4-5 上午11:33:04
 */

public interface InviteMasterApplyListDao {
	/**
	 * 查询该会员是否已成为推荐达人，或者存在审核中的推荐达人申请
	 * @author 刘利   
	 * @Description: TODO 
	 * @param memberID 会员ID
	 * @param @return 设定文件 
	 * @return int 返回类型  0不存在，大于0存在
	 * @date 2016-4-5 上午11:38:32
	 */
	public int selectInviteMasterApplyIsExist(long memberID);
	/**
	 * 推荐达人提奖记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
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
	 * @param @return 设定文件 
	 * @return List<InvestDetailedEntity> 返回类型 
	 * @date 2016-4-28 下午8:39:34
	 */
	public List<InvestDetailedEntity> getInviteInvest(PageEntity page);
	/**
	 *  推荐达人VIP购买明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
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
	 * @param @return 设定文件 
	 * @return List<InvestRepaymentEntity> 返回类型 
	 * @date 2016-4-28 下午8:00:06
	 */
	public List<InvestRepaymentEntity> getRepaymentInvite(PageEntity page);
	/**
	 * 推荐达人数据统计
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return InviteMasterAwardRecordEntity 返回类型 
	 * @date 2016-5-1 下午3:26:05
	 */
	public InviteMasterAwardRecordEntity selectInviteMasterStatistic(Map<String,Object> map);
	
}

