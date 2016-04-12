

/** 
* @Title: CommissionissuedServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-5 下午3:45:59 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.AwardRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.springmvc.dao.CommissionissuedListDao; 
import cn.springmvc.service.CommissionissuedService;

/** 
 * @author 刘利 
 * @Description: 推荐达人统计 
 * @since 
 * @date 2016-4-5 下午3:45:59  */
@Service("commissionissuedServiceImpl")
public class CommissionissuedServiceImpl implements CommissionissuedService{
	@Resource(name="commissionissuedListDaoImpl")
	private  CommissionissuedListDao commissionissuedListDao;
	@Override
	public List<AwardRecordEntity> getAwardAdvisor(PageEntity page) {
		
		return commissionissuedListDao.getAwardAdvisor(page);
		
	}

	@Override
	public List<AwardRecordEntity> getAwardInvite(PageEntity page) {
		
		return commissionissuedListDao.getAwardInvite(page);
		
	}

	@Override
	public List<BorrowingDetailedEntity> getBorrowingAdvisor(PageEntity page) {
		
		return commissionissuedListDao.getBorrowingAdvisor(page);
		
	}

	@Override
	public List<BorrowingDetailedEntity> getBorrowingInvite(PageEntity page) {
		
		return commissionissuedListDao.getBorrowingInvite(page);
		
	}

	@Override
	public List<InvestDetailedEntity> getInvestAdvisor(PageEntity page) {
		
		return commissionissuedListDao.getInvestAdvisor(page);
		
	}

	@Override
	public List<InvestDetailedEntity> getInvestInvite(PageEntity page) {
		
		return commissionissuedListDao.getInvestInvite(page);
		
	}

	@Override
	public List<BayVIPEntity> getBayVIPAdvisor(PageEntity page) {
		
		return commissionissuedListDao.getBayVIPAdvisor(page);
		
	}

	@Override
	public List<BayVIPEntity> getBayVIPInvite(PageEntity page) {
		
		return commissionissuedListDao.getBayVIPInvite(page);
		
	}

	@Override
	public List<AwardPaymentRecordEntity> getAwardRecordAdvisor(PageEntity page) {
		
		return commissionissuedListDao.getAwardRecordAdvisor(page);
		
	}

	@Override
	public List<AwardPaymentRecordEntity> getAwardRecordsInvite(PageEntity page) {
		
		return commissionissuedListDao.getAwardRecordsInvite(page);
		
	}

}

