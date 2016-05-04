
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.AdvanceEntity;
import cn.membermng.model.Cleared;
import cn.membermng.model.ConfirmationLoan;
import cn.membermng.model.Financing;
import cn.membermng.model.FlowLabel;
import cn.membermng.model.InvestmentRecord;
import cn.membermng.model.LoanApplyRecord;
import cn.membermng.model.LoanRepay;
import cn.membermng.model.RepaymentIn;
import cn.membermng.model.RepaymentOfBorrowings;
import cn.membermng.model.RepaymentOfBorrowingsRM;
import cn.membermng.model.StayStillPlan;
import cn.springmvc.dao.impl.IMyLoanReadDao;
import cn.springmvc.service.IMyLoanService;



/***
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-31 上午10:14:52 
*
*/
@Service
public class MyLoanServiceImpl implements IMyLoanService {

	
	@Resource(name="myLoanReadDaoImpl")
	private IMyLoanReadDao myLoanReadDao;
	
	@Override
	public List<Financing> financings(PageEntity entity) {
		
		return myLoanReadDao.financings(entity);
	}
	
	
	
	@Override
	public List<Financing> endOfFinancing(PageEntity entity) {
		
		return myLoanReadDao.endOfFinancing(entity);
	}
	
	
	
	@Override
	public List<RepaymentIn> repaymentIns(PageEntity entity) {
		
		return myLoanReadDao.repaymentIns(entity);
	}
	
	
	@Override
	public List<InvestmentRecord> investRecord(PageEntity entity) {
		
		return myLoanReadDao.investRecord(entity);
	}
	
	
	@Override
	public List<LoanRepay> loanRepay(PageEntity entity) {
		
		return myLoanReadDao.loanRepay(entity);
	}

	
	@Override
	public List<FlowLabel> flowLabelS(PageEntity entity) {
		
		return myLoanReadDao.flowLabelS(entity);
	}


	@Override
	public List<Cleared> cleared(PageEntity entity) {
		entity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		return myLoanReadDao.cleared(entity);
	}

	
	@Override
	public List<LoanApplyRecord> loanApplyRecord(PageEntity entity) {

		return myLoanReadDao.loanApplyRecord(entity);
	}
	
	@Override
	public List<StayStillPlan> stayStillPlans(PageEntity entity) {
	
		entity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		return myLoanReadDao.stayStillPlans(entity);
	}


	@Override
	public List<ConfirmationLoan> confirmationLoans(PageEntity entity) {
		entity.getMap().put("sKey", DbKeyUtil.GetDbCodeKey());
		return myLoanReadDao.confirmationLoans(entity);
	}


	@Override
	public List<RepaymentOfBorrowings> RepaymentOfBorrowings(PageEntity entity) {
		entity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		return myLoanReadDao.RepaymentOfBorrowings(entity);
	}


	@Override
	public List<RepaymentOfBorrowingsRM> LoanRements(PageEntity entity) {
		entity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		return myLoanReadDao.LoanRements(entity);
	}



	@Override
	public AdvanceEntity getAdvanceReplay(long applyId) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("applyId",               applyId);
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		return myLoanReadDao.getAdvanceReplay(map);
		
	}



	@Override
	public LoanRepay selectReplayDetail(long replyaID) {
		
		return myLoanReadDao.selectReplayDetail(replyaID);
		
	}


}

