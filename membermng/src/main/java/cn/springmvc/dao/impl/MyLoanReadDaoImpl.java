package cn.springmvc.dao.impl; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

/***
* 我的借款查询实现
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-31 上午10:23:05 
*
 */
@Repository
public class MyLoanReadDaoImpl extends SqlSessionDaoSupport implements IMyLoanReadDao{

	
	
	@Override
	public List<Financing> financings(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.financings", entity, new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	
	@Override
	public List<Financing> endOfFinancing(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.endOfFinancing",entity, new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<RepaymentIn> repaymentIns(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.repaymentIns",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<InvestmentRecord> investRecord(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.investRecord",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<LoanRepay> loanRepay(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.loanRepay",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<FlowLabel> flowLabelS(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.flowLabelS",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	} 
	
	
	@Override
	public List<Cleared> cleared(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.cleared", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<LoanApplyRecord> loanApplyRecord(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.loanApplyRecord", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	
	
	@Override
	public List<StayStillPlan> stayStillPlans(PageEntity entity) {
		List<StayStillPlan> list = getSqlSession().selectList("myLoanReadDaoImpl.stayStillPlans", entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
		Map<String,Object> param = new HashMap<String,Object>();
		for (int i = 0; i < list.size(); i++) {
			param.put("lId", list.get(i).getLrId());
			param.put("sKey", DbKeyUtil.GetDbCodeKey());
			getSqlSession().selectOne("myLoanReadDaoImpl.GetLoanRepayOverdueInfo",param);
			list.get(i).setRepayOverdue(Long.parseLong(param.get("lOverdue").toString()));
			list.get(i).setRepayOverdueInterest(Long.parseLong(param.get("lOverdueInterest").toString()));
		}
		return list;
	}
	
	
	@Override
	public List<ConfirmationLoan> confirmationLoans(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.confirmationLoans",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}
	

	@Override
	public List<RepaymentOfBorrowings> RepaymentOfBorrowings(PageEntity entity) {
		
		return getSqlSession().selectList("myLoanReadDaoImpl.repaymentOfBorrowings",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
	}



	@Override
	public List<RepaymentOfBorrowingsRM> LoanRements(PageEntity entity) {
		List<RepaymentOfBorrowingsRM> list = getSqlSession().selectList("myLoanReadDaoImpl.LoanRements",entity,new RowBounds(entity.getPageNum(), entity.getPageSize()));
		Map<String,Object> param = new HashMap<String,Object>();
		for (int i = 0; i < list.size(); i++) {
			param.put("lId", list.get(i).getLid());
			param.put("sKey", DbKeyUtil.GetDbCodeKey());
			if(list.get(i).getIsYuQi() == 0){//未逾期不计算
				continue;
			}
			getSqlSession().selectOne("myLoanReadDaoImpl.GetLoanRepayOverdueInfo",param);
			list.get(i).setYuQiFeiYong(Long.parseLong(param.get("lOverdueInterest").toString())+Long.parseLong(param.get("lOverdue").toString()));
		}
		return list;
	}
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}



	@Override
	public AdvanceEntity getAdvanceReplay(Map<String, Object> map) {
		
		return getSqlSession().selectOne("myLoanReadDaoImpl.getAdvanceReplay",map);
		
	}



	@Override
	public ReplayDetailEntity selectReplayDetail(long replyaID,long memberID,int memberType) {
		
		Map<String,Object>  param = new HashMap<String,Object>();
		param.put("lId",           replyaID);
		param.put("memberID",      memberID);
		param.put("memberType",  memberType);
		param.put("skey", DbKeyUtil.GetDbCodeKey());
		ReplayDetailEntity loanRepay = getSqlSession().selectOne("myLoanReadDaoImpl.selectReplayDetail",param);
		Long  UserBalance   = getSqlSession().selectOne("myLoanReadDaoImpl.selectMemberUserBalance",param);
		if(UserBalance == null) {
			UserBalance = 0L;
		}
		if(loanRepay != null) {
			//应还总额
			loanRepay.setSdReplayTotal(loanRepay.getLoanAmount()+loanRepay.getLoanInterest());
			//逾期利息
			loanRepay.setOverdueInterest(0);
			//逾期罚金
			loanRepay.setOberdueFine(0);
			if(loanRepay.getOverDay() > 0) {
				 getSqlSession().selectOne("myLoanReadDaoImpl.GetLoanRepayOverdueInfo",param); 
				//逾期利息
				loanRepay.setOverdueInterest(Long.parseLong(param.get("lOverdueInterest").toString()));
				//逾期罚金
				loanRepay.setOberdueFine(Long.parseLong(param.get("lOverdue").toString()));
				//应还总额
				loanRepay.setSdReplayTotal(loanRepay.getSdReplayTotal()+
						+loanRepay.getOberdueFine()+loanRepay.getOverdueInterest());
			} 
			loanRepay.setUserBalance(UserBalance);
		}
		
		return loanRepay;
	}



	@Override
	public MemberThirdAuthInfoEntity selectMemberIsOpenAutoPay(Map<String,Object> map) {
		
		return getSqlSession().selectOne("myLoanReadDaoImpl.selectMemberIsOpenAutoPay");
		
	}



	@Override
	public List<RepaymentOfBorrowingsRM> loanRepayback(PageEntity entity) {
		
		List<RepaymentOfBorrowingsRM> list = getSqlSession().selectList("myLoanReadDaoImpl.loanRepayback",entity,
				new RowBounds(entity.getPageNum(), entity.getPageSize()));
		Map<String,Object> param = new HashMap<String,Object>();
		for (int i = 0; i < list.size(); i++) {
			param.put("lId", list.get(i).getLid());
			param.put("sKey", DbKeyUtil.GetDbCodeKey());
			if(list.get(i).getIsYuQi() == 0){//未逾期不计算
				continue;
			}
			getSqlSession().selectOne("myLoanReadDaoImpl.GetLoanRepayOverdueInfo",param);
			list.get(i).setYuQiFeiYong(Long.parseLong(param.get("lOverdueInterest").toString())+Long.parseLong(param.get("lOverdue").toString()));
			list.get(i).setOberdueFine(Long.parseLong(param.get("lOverdue").toString()));
			list.get(i).setOverdueInterest(Long.parseLong(param.get("lOverdueInterest").toString()));
			list.get(i).setSdReplayTotal(list.get(i).getSdReplayTotal()+
					Long.parseLong(param.get("lOverdue").toString())+Long.parseLong(param.get("lOverdueInterest").toString()));
		}
		return list;
		
	}
	
	@Override
	public ComfirLoanInfo confirmationLoanInfo(Map<String, Object> param) {
		
		return getSqlSession().selectOne("myLoanReadDaoImpl.confirmationLoanInfo",param);
	}
	



	@Override
	public List<SuccessRepayDetail> loanRepayDetail(PageEntity entity) {
		
		List<SuccessRepayDetail> loanRepaylist = getSqlSession().selectList("myLoanReadDaoImpl.loanRepayDetail",entity,
				new RowBounds(entity.getPageNum(), entity.getPageSize()));
		
		Map<String,Object> param = new HashMap<String,Object>();
		for (int i = 0; i < loanRepaylist.size(); i++) {
			param.put("lId", loanRepaylist.get(i).getLid());
			param.put("sKey", DbKeyUtil.GetDbCodeKey());
			if(loanRepaylist.get(i).getOverDay() <= 0){//未逾期不计算
				continue;
			}
			getSqlSession().selectOne("myLoanReadDaoImpl.GetLoanRepayOverdueInfo",param);
			loanRepaylist.get(i).setNotpaidOverdueInterest(Long.parseLong(param.get("lOverdueInterest").toString())+
					Long.parseLong(param.get("lOverdue").toString()));
		}
		return loanRepaylist;
		
	}
	
	
	


	
}

