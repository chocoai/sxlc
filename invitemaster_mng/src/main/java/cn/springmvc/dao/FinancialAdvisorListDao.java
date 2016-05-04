

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
 * @Description: 理财顾问
 * @since 
 * @date 2016-4-5 上午11:33:04
 */

public interface FinancialAdvisorListDao {
	 
	/**
	 * 理财顾问提奖记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<InviteMasterAwardRecordEntity> 返回类型 
	 * @date 2016-4-28 下午8:35:22
	 */
	public List<InviteMasterAwardRecordEntity> getFinancialAdvisorAward(PageEntity page);
	/**
	 *  理财顾问历史返现
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<AwardPaymentRecordEntity> 返回类型 
	 * @date 2016-4-28 下午8:37:00
	 */
	public List<AwardPaymentRecordEntity> getFinancialMasterHistoryBack(PageEntity page);
	/**
	 * 理财顾问邀请记录 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<InvitationRecordEntity> 返回类型 
	 * @date 2016-4-28 下午8:37:50
	 */
	public List<InvitationRecordEntity> getFinancialInvitationRecord(PageEntity page);
	/**
	 * 理财顾问理财借款明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<selectInviteBorrowing> 返回类型 
	 * @date 2016-4-28 下午8:38:34
	 */
	public List<BorrowingDetailedEntity> selectFinancialBorrowing(PageEntity page);
	/**
	 * 理财顾问投资明细 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<InvestDetailedEntity> 返回类型 
	 * @date 2016-4-28 下午8:39:34
	 */
	public List<InvestDetailedEntity> getFinancialInvest(PageEntity page);
	
	/**
	 *  理财顾问VIP购买明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<BayVIPEntity> 返回类型 
	 * @date 2016-4-28 下午8:40:13
	 */
	public List<BayVIPEntity> getFinancialVipPay(PageEntity page);
	
	/**
	 * 理财顾问推荐还本明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<InvestRepaymentEntity> 返回类型 
	 * @date 2016-5-1 下午3:08:38
	 */
	public List<InvestRepaymentEntity> getRepaymentAdvisor(PageEntity page);
	/**
	 * 理财顾问数据统计
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return InviteMasterAwardRecordEntity 返回类型 
	 * @date 2016-5-1 下午3:26:05
	 */
	public InviteMasterAwardRecordEntity selectFinancialMasterStatistic(Map<String,Object> map);
}

