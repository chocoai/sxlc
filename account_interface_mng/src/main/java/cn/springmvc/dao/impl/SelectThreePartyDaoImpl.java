
package cn.springmvc.dao.impl; 

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.SelectThreePartyDao;
import cn.sxlc.account.manager.model.AccountInterfaceEntity;
import cn.sxlc.account.manager.model.AwardEntity;
import cn.sxlc.account.manager.model.InvestRecordEntity;
import cn.sxlc.account.manager.model.LoanTransactionEntity;
import cn.sxlc.account.manager.model.ProjectEntity;
import cn.sxlc.account.manager.model.RepayDetailEntity;
import cn.sxlc.account.manager.model.SurpriseRedEntity;
import cn.sxlc.account.manager.model.WithdrawalsFeeEntity;
import cn.sxlc.account.manager.model.WithdrawsEntity;

@Component("selectThreePartyDaoImpl")
public class SelectThreePartyDaoImpl extends SqlSessionDaoSupport implements SelectThreePartyDao{
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public AccountInterfaceEntity selectpAccountById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.selectpAccountById",map);
	}

	@Override
	public AccountInterfaceEntity selectcAccountById(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.selectcAccountById",map);
	}

	@Override
	public String findThirdPartyMark(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.findThirdPartyMark",map);
	}

	@Override
	public String findMemberThirdPartyMark(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.findMemberThirdPartyMark",map);
	}
	@Override
	public String payRechargeSet(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.payRechargeSet",map);
	}
	@Override
	public List<LoanTransactionEntity> GetInvestListByProId(
			Map<String, Object> map) {
		map.put("skey", DbKeyUtil.GetDbCodeKey());
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ThreePartyXML.GetInvestListByProId",map);
	}
	@Override
	public WithdrawsEntity finBankCode(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.finBankCode",map);
	}
	@Override
	public WithdrawalsFeeEntity isWithdrawalsCheak(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.isWithdrawalsCheak",map);
	}
	@Override
	public String findWithdrawalRecharge(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.findWithdrawalRecharge",map);
	}
	@Override
	public Map<String, Object> EarlyRepayment(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.EarlyRepayment",map);
	}

	@Override
	public long selectAllmoneyForEarlyRepayment(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.selectAllmoneyForEarlyRepayment",map);
	}

	@Override
	public List<RepayDetailEntity> selectAllInvestForEarlyRepayment(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.selectAllInvestForEarlyRepayment",map);
	}

	@Override
	public long selectRevenuePlan(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.selectRevenuePlan",map);
	}

	@Override
	public long findInterestByMember(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.findInterestByMember",map);
	}
	@Override
	public Map<String, Object> findPenaltyRate(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.findPenaltyRate",map);
	}
	@Override
	public long findTimesByMember(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.findTimesByMember",map);
	}
	@Override
	public int projectDurationType(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.projectDurationType",map);
	}

	@Override
	public long findInterestByOne(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.findInterestByOne",map);
	}

	@Override
	public long selectPrincipalByID(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.selectPrincipalByID",map);
	}
	@Override
	public long findDayByOverdue(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.findDayByOverdue",map);
	}
	@Override
	public long findOverdueFees(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.findOverdueFees",map);
	}
	@Override
	public Map<String, Object> InvestIncomeOverdueFee(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.InvestIncomeOverdueFee",map);
	}
	@Override
	public Map<String, Object> allInvestRealIncome(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.allInvestRealIncome",map);
	}
	@Override
	public long findIncomeId(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.findIncomeId",map);
	}
	@Override
	public Timestamp overdueRecvTime(Map<String, Object> map) {
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.overdueRecvTime",map);
	}
	@Override
	public Timestamp overdueRepayMaxTime(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.overdueRepayMaxTime",map);
	}
	@Override
	public long ProjectBaseInfoYearRate(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.ProjectBaseInfoYearRate",map);
	}
	@Override
	public long RepayStatu(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.RepayStatu",map);
	}
	@Override
	public int CompensatoryJudgment(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		map=getSqlSession().selectOne("ThreePartyXML.CompensatoryJudgment",map);
		int i=1;
		if(map.get("result")!=null){
			i=Integer.parseInt(map.get("result").toString());
		}
		return i;
	}
	
	@Override
	public int CompensatoryPaymentJudgment(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		map=getSqlSession().selectOne("ThreePartyXML.CompensatoryPaymentJudgment",map);
		int i=1;
		if(map.get("result")!=null){
			i=Integer.parseInt(map.get("result").toString());
		}
		return i;
	}
	@Override
	public Map<String, Object> sumJudgmentMoney(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.sumJudgmentMoney",map);
	}
	@Override
	public int findDayByOverdueNow(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.findDayByOverdueNow",map);
	}
	@Override
	public List<LoanTransactionEntity> GetCreditorTransId(
			Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ThreePartyXML.GetCreditorTransId",map);
	}
	@Override
	public List<InvestRecordEntity> GetTransInvestList(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ThreePartyXML.GetTransInvestList",map);
	}
	@Override
	public Integer InterestType() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.InterestType");
	}
	@Override
	public Map<String, Integer> getRepaymentByCTAId(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.InterestType",map);
	}
	@Override
	public Map<String, Object> getDateInstallments(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.getDateInstallments",map);
	}
	@Override
	public Map<String, Object> GetProdateTrans(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.GetProdateTrans",map);
	}
	@Override
	public List<Integer> selectLoanId(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ThreePartyXML.selectLoanId",map);
	}
	@Override
	public Map<String, Object> JudgmentRefundDeposit(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ThreePartyXML.JudgmentRefundDeposit",map);
	}
	@Override
	public List<SurpriseRedEntity> findListSurpriseRed(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ThreePartyXML.findListSurpriseRed",map);
	}
	@Override
	public int AccountBalance(Map<String, Object> map) {
		getSqlSession().selectOne("ThreePartyXML.AccountBalance", map);
		int rule=IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return rule;
	}
	@Override
	public List<AwardEntity> FinancialAdvisorAward(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ThreePartyXML.FinancialAdvisorAward",map);
	}
	@Override
	public List<AwardEntity> RecommendedTalentAward(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ThreePartyXML.RecommendedTalentAward",map);
	}
	@Override
	public long findYearMoney() {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ThreePartyXML.findYearMoney");
	}
	@Override
	public int EndTimeComparison(long memberId,String startTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("startTime", startTime);
		// TODO Auto-generated method stub return null;
		getSqlSession().selectOne("ThreePartyXML.EndTimeComparison",map);
		int result = IntegerAndString.StringToInt(map.get("result").toString(),0);
		return result;
	}
	@Override
	public String selectPhone(long memberId) {
		// TODO Auto-generated method stub return null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return getSqlSession().selectOne("ThreePartyXML.selectPhone",map);
	}
	@Override
	public long QueryCashWithdrawal(String thirdBillNo) {
		
		// TODO Auto-generated method stub return null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("thirdBillNo", thirdBillNo);
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return getSqlSession().selectOne("ThreePartyXML.QueryCashWithdrawal",map);
	}
	@Override
	public ProjectEntity findProjectTNByid(int applyId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyId", applyId);
//		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return getSqlSession().selectOne("ThreePartyXML.findProjectTNByid",map);
		
	}
	@Override
	public int BlackMemberJudgmentOne(long memberId, int mType) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("mType", mType);
		// TODO Auto-generated method stub return 0;
		getSqlSession().selectOne("ThreePartyXML.BlackMemberJudgmentOne",map);
		int result = IntegerAndString.StringToInt(map.get("result").toString(), 0);
		return result;
	}
}

