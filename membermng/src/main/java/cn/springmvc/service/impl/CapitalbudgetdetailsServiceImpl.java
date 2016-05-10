

/** 
* @Title: CapitalbudgetdetailsServiceImpl.java 
* @Package cn.capitalbudgetdetails.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-30 下午5:04:46 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MemberWithdrawalRechargeEntity;
import cn.springmvc.dao.CapitalbudgetdetailsListDao;
import cn.springmvc.service.CapitalbudgetdetailsService;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
 

/** 
 * @author 刘利 
 * @Description: 资金收支明细 
 * @since 
 * @date 2016-3-30 下午5:04:46  */
@Service("capitalbudgetdetailsServiceImpl")
public class CapitalbudgetdetailsServiceImpl implements CapitalbudgetdetailsService{
	@Resource(name="capitalbudgetdetailsListDaoImpl")
	private CapitalbudgetdetailsListDao capitalbudgetdetailsListDao;
	@Override
	public List<MemberTradingRecordsEntity> selectMemberTradingRecords(
			PageEntity pageEntity) {
		List<MemberTradingRecordsEntity> list = capitalbudgetdetailsListDao.selectMemberTradingRecords(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list;
	}

	@Override
	public MemberTradingRecordsEntity selectTradingRecordsdetail(
			Map<String, Object> map) {
		    map.put("sKey", DbKeyUtil.GetDbCodeKey());
		  return capitalbudgetdetailsListDao.selectTradingRecordsdetail(map);
		
	}

	@Override
	public List<MemberWithdrawalRechargeEntity> selectRechargeList(
			PageEntity pageEntity) {
		List<MemberWithdrawalRechargeEntity> list =  capitalbudgetdetailsListDao.selectRechargeList(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list ;
	}

	@Override
	public List<MemberWithdrawalRechargeEntity>  selectWithdrawalList(PageEntity pageEntity) {
		List<MemberWithdrawalRechargeEntity> list =  capitalbudgetdetailsListDao.selectWithdrawalList(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);
		return list ;
		
	}

	@Override
	public long selectTotalRechargeFee(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return capitalbudgetdetailsListDao.selectTotalRechargeFee(map);
		
	}

	@Override
	public long selectTotalRechargeReal(Map<String, Object> map) {
	   
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return capitalbudgetdetailsListDao.selectTotalRechargeReal(map);
		
	}

	@Override
	public long selectTotalWithdrawalFee(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return capitalbudgetdetailsListDao.selectTotalWithdrawalFee(map);
		
	}

	@Override
	public long selectTotalWithdrawalReal(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return capitalbudgetdetailsListDao.selectTotalWithdrawalReal(map);
		
	}

	@Override
	public Map<String,Object> selectTotalRechargeInfo(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return capitalbudgetdetailsListDao.selectTotalRechargeInfo(map); 
		
	}

	@Override
	public Map<String, Object> selectTotalWithdrawalInfo(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return capitalbudgetdetailsListDao.selectTotalWithdrawalInfo(map); 
		
	}

}

