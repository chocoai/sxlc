

/** 
* @Title: GenerateRepayListService.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午1:59:16 
* @version V5.0 */
 
package cn.springmvc.service.impl; 
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString; 
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.AwardPaymentRecordEntity;
import cn.invitemastermng.model.BayVIPEntity;
import cn.invitemastermng.model.BorrowingDetailedEntity;
import cn.invitemastermng.model.InvestDetailedEntity;
import cn.invitemastermng.model.InvestRepaymentEntity;
import cn.invitemastermng.model.InvitationRecordEntity;
import cn.invitemastermng.model.InviteMasterAwardRecordEntity;
import cn.springmvc.dao.FinancialAdvisorListDao;
import cn.springmvc.dao.InviteMasterApplyDao;  
import cn.springmvc.dao.InviteMasterApplyListDao; 
import cn.springmvc.service.FinancialAdvisorService;
import cn.springmvc.service.InviteMasterApplyService;

/** 
 * @author 刘利 
 * @Description: 推荐达人申请
 * @since 
 * @date 2016-4-1 下午1:59:16  */
@Service("financialAdvisorServiceImpl")
public class FinancialAdvisorServiceImpl implements FinancialAdvisorService { 
	@Resource(name="financialAdvisorListDaoImpl")
	private  FinancialAdvisorListDao financialAdvisorListDao; 
	 
	 
	@Override
	public List<InviteMasterAwardRecordEntity> getFinancialAdvisorAward(
			PageEntity page) {
		
		return financialAdvisorListDao.getFinancialAdvisorAward(page);
		
	}
	@Override
	public List<AwardPaymentRecordEntity> getFinancialMasterHistoryBack(
			PageEntity page) {
		
		return financialAdvisorListDao.getFinancialMasterHistoryBack(page);
		
	}
	@Override
	public List<InvitationRecordEntity> getFinancialInvitationRecord(
			PageEntity page) {
		
		return financialAdvisorListDao.getFinancialInvitationRecord(page);
		
	}
	@Override
	public List<BorrowingDetailedEntity> selectFinancialBorrowing(
			PageEntity page) {
		
		return financialAdvisorListDao.selectFinancialBorrowing(page);
		
	}
	@Override
	public List<InvestDetailedEntity> getFinancialInvest(PageEntity page) {
		
		return financialAdvisorListDao.getFinancialInvest(page);
		
	}
	@Override
	public List<BayVIPEntity> getFinancialVipPay(PageEntity page) {
		
		return financialAdvisorListDao.getFinancialVipPay(page);
		
	}
	@Override
	public List<InvestRepaymentEntity> getRepaymentAdvisor(PageEntity page) {
		
		return financialAdvisorListDao.getRepaymentAdvisor(page);
		
	}
	@Override
	public InviteMasterAwardRecordEntity selectFinancialMasterStatistic(
			long memberID) {
		

		Map<String,Object> map =new HashMap<String,Object>();
		map.put("memberID",                memberID);
		map.put("skey",    DbKeyUtil.GetDbCodeKey());
		return financialAdvisorListDao.selectFinancialMasterStatistic(map);
		
	}  
	 

}

