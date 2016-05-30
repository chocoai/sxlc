

/** 
* @Title: MyAccountHomeServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-7 上午10:10:21 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;

import cn.membermng.model.IncomeReplayPlanEntity;
import cn.membermng.model.MyAccountHomeEntity;
import cn.springmvc.dao.CapitalbudgetdetailsListDao;
import cn.springmvc.dao.MyAccountHomeListDao;
import cn.springmvc.service.MyAccountHomeService;

/** 
 * @author 刘利 
 * @Description: 我的账户-首页
 * @since 
 * @date 2016-4-7 上午10:10:21  */
@Service("myAccountHomeServiceImpl")
public class MyAccountHomeServiceImpl implements MyAccountHomeService{
	@Resource(name="myAccountHomeListDaoImpl")
	private MyAccountHomeListDao myAccountHomeListDao;

	@Override
	public MyAccountHomeEntity selectMyAccountHome(long memberID) {
	    
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("Member_ID_IN", memberID); 
		map.put("Skey", DbKeyUtil.GetDbCodeKey()); 
		myAccountHomeListDao.selectMyAccountHome(map);
		MyAccountHomeEntity myAccountHomeEntity =new MyAccountHomeEntity();
		if( map.get("User_Balance") != null) {
			 myAccountHomeEntity.setUserBalance(IntegerAndString.StringToLong(map.get("User_Balance").toString(),0));
 	    }
		if( map.get("Frozen") != null) {
			 myAccountHomeEntity.setFrozen(IntegerAndString.StringToLong(map.get("Frozen").toString(),0));
	    } 
		if( map.get("Gift_User_Balance") != null) {
			 myAccountHomeEntity.setGiftUserBalance(IntegerAndString.StringToLong(map.get("Gift_User_Balance").toString(),0));
	    } 
		if(map.get("Gift_Amount")!=null){
			myAccountHomeEntity.setGiftAmount(IntegerAndString.StringToLong(map.get("Gift_Amount").toString(),0));
		}
		if( map.get("WillRec_Principal") != null) {
			 myAccountHomeEntity.setWillRecPrincipal(IntegerAndString.StringToLong(map.get("WillRec_Principal").toString(),0));
	    } 
		if( map.get("WillRec_Interest") != null) {
			 myAccountHomeEntity.setWillRecInterest(IntegerAndString.StringToLong(map.get("WillRec_Interest").toString(),0));
	    } 
		if( map.get("Repay_Amount") != null) {
			 myAccountHomeEntity.setRepayAmount(IntegerAndString.StringToLong(map.get("Repay_Amount").toString(),0));
	    } 
		if( map.get("Total_Amount") != null) {
			 myAccountHomeEntity.setTotalAmount(IntegerAndString.StringToLong(map.get("Total_Amount").toString(),0));
	    } 
		if( map.get("Charge_money") != null) {
			 myAccountHomeEntity.setChargemoney(IntegerAndString.StringToLong(map.get("Charge_money").toString(),0));
	    } 
		if( map.get("Withdrawal_Money") != null) {
			 myAccountHomeEntity.setWithdrawalMoney(IntegerAndString.StringToLong(map.get("Withdrawal_Money").toString(),0));
	    } 
		if( map.get("Gift_Amount") != null) {
			 myAccountHomeEntity.setGiftAmount(IntegerAndString.StringToLong(map.get("Gift_Amount").toString(),0));
	    } 
		if( map.get("Friends") != null) {
			 myAccountHomeEntity.setFriends(IntegerAndString.StringToLong(map.get("Friends").toString(),0));
	    } 
		if( map.get("Integral_Residue") != null) {
			 myAccountHomeEntity.setIntegralResidue(IntegerAndString.StringToLong(map.get("Integral_Residue").toString(),0));
	    } 
		if( map.get("Invest_Amount_Valid") != null) {
			 myAccountHomeEntity.setInvestAmountValid(IntegerAndString.StringToLong(map.get("Invest_Amount_Valid").toString(),0));
	    } 
		if( map.get("Real_Amount") != null) {
			 myAccountHomeEntity.setRealAmount(IntegerAndString.StringToLong(map.get("Real_Amount").toString(),0));
	    } 
		if( map.get("Back_Amount") != null) {
			 myAccountHomeEntity.setBackAmount(IntegerAndString.StringToLong(map.get("Back_Amount").toString(),0));
	    } 
		if( map.get("Invest_Vouchers_Amount") != null) {
			 myAccountHomeEntity.setInvestVouchersAmount(IntegerAndString.StringToLong(map.get("Invest_Vouchers_Amount").toString(),0));
	    } 
		if( map.get("Invest_Gift_Amount") != null) {
			 myAccountHomeEntity.setInvestGiftAmount(IntegerAndString.StringToLong(map.get("Invest_Gift_Amount").toString(),0));
	    } 
		if( map.get("Amount") != null) {
			 myAccountHomeEntity.setAmount(IntegerAndString.StringToLong(map.get("Amount").toString(),0));
	    } 
		if( map.get("WillRepay_Principal") != null) {
			 myAccountHomeEntity.setWillRepayPrincipal(IntegerAndString.StringToLong(map.get("WillRepay_Principal").toString(),0));
	    } 
		if( map.get("WillRepay_Interest") != null) {
			 myAccountHomeEntity.setWillRepayInterest(IntegerAndString.StringToLong(map.get("WillRepay_Interest").toString(),0));
	    } 
		if( map.get("Overdue") != null) {
			 myAccountHomeEntity.setOverdue(IntegerAndString.StringToLong(map.get("Overdue").toString(),0));
	    } 
		if( map.get("Last_Date") != null) {
			 myAccountHomeEntity.setLastDate(map.get("Last_Date").toString());
	    } 
		return myAccountHomeEntity;
	}

	@Override
	public List<IncomeReplayPlanEntity> getInvestIncome(long memberID,String monthmin,String monthmax) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("skey", DbKeyUtil.GetDbCodeKey()); 
		map.put("Member_ID", memberID); 
		map.put("Month_Min", monthmin); 
		map.put("Month_Max", monthmax); 
		List<IncomeReplayPlanEntity> IncomeReplayList = myAccountHomeListDao.getInvestIncome(map);

		if(IncomeReplayList.size()==0 ) {
			for (int i = 0; i < 12; i++) {
				IncomeReplayPlanEntity entity = new IncomeReplayPlanEntity();
				entity.setMemberID(memberID);
				entity.setMonth(i+1);
				entity.setSdRecvAmount(0);
				IncomeReplayList.add(entity);
			}
			return IncomeReplayList;
		} 
		List<IncomeReplayPlanEntity> incomeReplayList2 = new ArrayList<IncomeReplayPlanEntity>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < IncomeReplayList.size(); j++) {
				if (IncomeReplayList.get(j).getMonth() == i+1) {
					incomeReplayList2.add( IncomeReplayList.get(j));
					j=IncomeReplayList.size()+1;
				}
			}
			if(incomeReplayList2.size()<i+1){
				IncomeReplayPlanEntity entity = new IncomeReplayPlanEntity();
				entity.setMemberID(memberID);
				entity.setMonth(i+1);
				entity.setSdRecvAmount(0);
				incomeReplayList2.add(entity);
			}
			
		}
		return incomeReplayList2;
		
	}

	@Override
	public List<IncomeReplayPlanEntity> getIncomeRecord(long memberID,String month) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("skey", DbKeyUtil.GetDbCodeKey()); 
		map.put("Member_ID", memberID); 
		map.put("Month", month);  
		return myAccountHomeListDao.getIncomeRecord(map);
	}

	@Override
	public List<IncomeReplayPlanEntity> getLoanRepay(long memberID,String monthmin,String monthmax) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("skey", DbKeyUtil.GetDbCodeKey()); 
		map.put("Member_ID", memberID); 
		map.put("Month_Min", monthmin); 
		map.put("Month_Max", monthmax);   
		
		List<IncomeReplayPlanEntity> IncomeReplayList = myAccountHomeListDao.getLoanRepay(map);

		if(IncomeReplayList.size()==0 ) {
			for (int i = 0; i < 12; i++) {
				IncomeReplayPlanEntity entity = new IncomeReplayPlanEntity();
				entity.setMemberID(memberID);
				entity.setMonth(i+1);
				entity.setSdRecvAmount(0);
				IncomeReplayList.add(entity);
			}
			return IncomeReplayList;
		} 
		List<IncomeReplayPlanEntity> incomeReplayList2 = new ArrayList<IncomeReplayPlanEntity>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < IncomeReplayList.size(); j++) {
				if (IncomeReplayList.get(j).getMonth() == i+1) {
					incomeReplayList2.add( IncomeReplayList.get(j));
					j=IncomeReplayList.size()+1;
				}
			}
			if(incomeReplayList2.size()<i+1){
				IncomeReplayPlanEntity entity = new IncomeReplayPlanEntity();
				entity.setMemberID(memberID);
				entity.setMonth(i+1);
				entity.setSdRecvAmount(0);
				incomeReplayList2.add(entity);
			}
			
		}
		return incomeReplayList2;
		
	}

	@Override
	public List<IncomeReplayPlanEntity> getRepayRecord(long memberID,String month) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("skey", DbKeyUtil.GetDbCodeKey()); 
		map.put("Member_ID", memberID); 
		map.put("Month", month);  
		return myAccountHomeListDao.getRepayRecord(map);
		
	}

	@Override
	public List<IncomeReplayPlanEntity> getDynamicFunds(long memberID) {
		
		  return myAccountHomeListDao.getDynamicFunds(memberID);
	}
}

