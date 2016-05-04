

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

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.AwardRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.InvestRepaymentEntity;

/**
 * 
 * @author 刘利 
 * @Description: 推荐达人统计
 * @since 
 * @date 2016-4-5 上午11:12:03
 */

public interface CommissionissuedService {
	/**
	 * 按月统计理财顾问佣金 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * @param @return 设定文件 
	 * @return List<AwardRecordEntity> 返回类型 
	 * @date 2016-4-5 下午3:13:53
	 */
	public List<AwardRecordEntity> getAwardAdvisor(PageEntity page);
	/**
	 * 按月统计推荐达人佣金
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * @param @return 设定文件 
	 * @return List<AwardRecordEntity> 返回类型 
	 * @date 2016-4-5 下午3:14:02
	 */
	public List<AwardRecordEntity> getAwardInvite(PageEntity page);
	/**
	 * 查询理财顾问推荐借款明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * @param @return 设定文件 
	 * @return List<BorrowingDetailedEntity> 返回类型 
	 * @date 2016-4-5 下午3:15:12
	 */
	public List<BorrowingDetailedEntity> getBorrowingAdvisor(PageEntity page);
	/**
	 * 查询推荐达人推荐借款明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * @param @return 设定文件 
	 * @return List<BorrowingDetailedEntity> 返回类型 
	 * @date 2016-4-5 下午3:16:09
	 */
	public List<BorrowingDetailedEntity> getBorrowingInvite(PageEntity page);
	/**
	 * 查询理财顾问推荐投资明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   page
	 * @param @return 设定文件 
	 * @return List<InvestDetailedEntity> 返回类型 
	 * @date 2016-4-5 下午3:17:05
	 */
	public List<InvestDetailedEntity> getInvestAdvisor(PageEntity page);
	/**
	 * 查询推荐达人推荐投资明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  page
	 * @param @return 设定文件 
	 * @return List<InvestDetailedEntity> 返回类型 
	 * @date 2016-4-5 下午3:17:45
	 */
	public List<InvestDetailedEntity> getInvestInvite(PageEntity page);
	/**
	 * 查询理财顾问推荐VIP购买明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  page
	 * @param @return 设定文件 
	 * @return List<BayVIPEntity> 返回类型 
	 * @date 2016-4-5 下午3:18:33
	 */
	public List<BayVIPEntity> getBayVIPAdvisor(PageEntity page);
	/**
	 * 查询推荐达人推荐VIP购买明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param page
	 * @param @return 设定文件 
	 * @return List<BayVIPEntity> 返回类型 
	 * @date 2016-4-5 下午3:19:19
	 */
	public List<BayVIPEntity> getBayVIPInvite(PageEntity page);
    /**
     * 查询理财顾问佣金发放记录
     * @author 刘利   
     * @Description: TODO 
     * @param page
     * @param @return 设定文件 
     * @return List<AwardPaymentRecordEntity> 返回类型 
     * @date 2016-4-5 下午3:21:02
     */
	public List<AwardPaymentRecordEntity> getAwardRecordAdvisor(PageEntity page);
	/**
	 * 查询推荐达人佣金发放记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   page
	 * @param @return 设定文件 
	 * @return List<AwardPaymentRecordEntity> 返回类型 
	 * @date 2016-4-5 下午3:21:22
	 */
	public List<AwardPaymentRecordEntity> getAwardRecordsInvite(PageEntity page);
	
	/**
	 * 理财顾问还本明细
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param page
	 * @param @return 设定文件 
	 * @return List<InvestRepaymentEntity> 返回类型 
	 * @date 2016-4-28 下午7:59:09
	 */
	public List<InvestRepaymentEntity> getRepaymentAdvisor(PageEntity page);
	
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
}

