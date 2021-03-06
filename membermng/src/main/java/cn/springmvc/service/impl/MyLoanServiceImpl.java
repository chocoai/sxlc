
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
import cn.membermng.model.ComfirLoanInfo;
import cn.membermng.model.ConfirmationLoan;
import cn.membermng.model.Financing;
import cn.membermng.model.FlowLabel;
import cn.membermng.model.InvestmentRecord;
import cn.membermng.model.LoanApplyRecord;
import cn.membermng.model.LoanRepay;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.membermng.model.RepaymentIn;
import cn.membermng.model.RepaymentOfBorrowings;
import cn.membermng.model.RepaymentOfBorrowingsRM;
import cn.membermng.model.ReplayDetailEntity;
import cn.membermng.model.StayStillPlan;
import cn.membermng.model.SuccessRepayDetail;
import cn.springmvc.dao.IMyLoanWriteDao;
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
	@Resource(name="myLoanWriteDaoImpl")
	private IMyLoanWriteDao iMyLoanWriteDao;
	
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
	public ComfirLoanInfo confirmationLoanInfo(long memberId, long applyId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("memberId", memberId);
		param.put("applyId", applyId);
		
		return myLoanReadDao.confirmationLoanInfo(param);
	}
	
	
	
	@Override
	public int confirmationLoan(long memberId, long applyId,int optionvalue,int sysId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		param.put("memberId", memberId);
		param.put("applyId", applyId);
		param.put("optionvalue", optionvalue);
		param.put("sysId", sysId);
		
		return iMyLoanWriteDao.confirmationLoan(param);
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
		AdvanceEntity advanceEntity =  myLoanReadDao.getAdvanceReplay(map);
		long linver = advanceEntity.getRepayInterest();//应付利息
		if (advanceEntity.getDeadlineType()==1) {//月标
			linver=linver-(linver/30*advanceEntity.getRemaintimes());
		}
		if (advanceEntity.getDeadlineType()==2) {//年标
			linver=linver-(linver/365*advanceEntity.getRemaintimes());
		}
		if (linver<100) {
			linver=0;
		}
		advanceEntity.setRepayInterest(linver);
		//平台收取违约金
		advanceEntity.setPenaltyPingTai(advanceEntity.getRepayPrincipal()*advanceEntity.getPenaltyPingTaiRate()/1000000); 
		//投资人收取违约金
		advanceEntity.setPenaltyInvest(advanceEntity.getRepayPrincipal()*advanceEntity.getPenaltyInvestRate()/1000000);
		//总的违约金
		advanceEntity.setPenaltyTotal(advanceEntity.getPenaltyPingTai()+advanceEntity.getPenaltyInvest());
		//总的还款金额
		advanceEntity.setReplayTotal(advanceEntity.getRepayInterest()+advanceEntity.getRepayPrincipal()
				+advanceEntity.getPenaltyTotal()); 
		return advanceEntity;
	}



	@Override
	public ReplayDetailEntity selectReplayDetail(long replyaID,long memberID,int memberType) {
		
		
		ReplayDetailEntity entity = myLoanReadDao.selectReplayDetail(replyaID, memberID, memberType);
		if(entity == null) {
			return null;
		}
		Long userBalance = entity.getUserBalance();//账户可用余额 
		entity.setPaidAmount(0);
		entity.setPaidInterest(0);
		entity.setPaidOberdueFine(0);
		entity.setPaisdReplayTotal(0);
		//是否满足先还本金
		if(entity.getLoanAmount() <=  entity.getUserBalance()) {
			entity.setPaidAmount(entity.getLoanAmount());
			userBalance = userBalance - entity.getLoanAmount(); 
		}else {
			entity.setPaidAmount(userBalance);
			userBalance = 0L;
		}
		//是否满足还利息
		if(entity.getLoanInterest() <= userBalance) {
			entity.setPaidInterest(entity.getLoanInterest());
			userBalance = userBalance - entity.getLoanInterest();
		} else {
			entity.setPaidInterest(userBalance);
			userBalance = 0L;
		}
		//是否满足还罚金
		if(entity.getOberdueFine() <= userBalance) {
			
			entity.setPaidOberdueFine(entity.getOberdueFine());
			userBalance = userBalance - entity.getOberdueFine();
		} else {
			
			entity.setPaidOberdueFine(userBalance);
			userBalance = 0L;
		}
		//是否满足还罚息
		if(entity.getOverdueInterest() <= userBalance) {
			
			entity.setPaidOverdueInterest(entity.getOverdueInterest());
			userBalance = userBalance - entity.getOverdueInterest();
		} else {
			entity.setPaidOverdueInterest(userBalance);
			userBalance = 0L;
		} 
	   if(entity.getUserBalance() <= entity.getSdReplayTotal()) { 
		   entity.setPaisdReplayTotal(entity.getUserBalance());
		}else {
			entity.setPaisdReplayTotal(entity.getSdReplayTotal());
		}
		return entity;
	}



	@Override
	public MemberThirdAuthInfoEntity selectMemberIsOpenAutoPay(long memberID,
			int memberType) {
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("memberID",     memberID);
		map.put("memberType", memberType);
		return myLoanReadDao.selectMemberIsOpenAutoPay(map);
	}



	@Override
	public int updateIsAutoPay(Map<String, Object> map) {
		
		return iMyLoanWriteDao.updateAutoPay(map);
		
	}



	@Override
	public List<RepaymentOfBorrowingsRM> loanRepayback(PageEntity entity) {
		
		entity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		return myLoanReadDao.loanRepayback(entity);
	}



	@Override
	public List<SuccessRepayDetail> loanRepayDetail(PageEntity entity) {
		
		entity.getMap().put("skey", DbKeyUtil.GetDbCodeKey());
		return myLoanReadDao.loanRepayDetail(entity);
		
	}


}

