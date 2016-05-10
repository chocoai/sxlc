

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
import cn.springmvc.dao.InviteMasterApplyDao;  
import cn.springmvc.dao.InviteMasterApplyListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.service.InviteMasterApplyService;

/** 
 * @author 刘利 
 * @Description: 推荐达人申请
 * @since 
 * @date 2016-4-1 下午1:59:16  */
@Service("inviteMasterApplyServiceImpl")
public class InviteMasterApplyServiceImpl implements InviteMasterApplyService {
	@Resource(name="inviteMasterApplyDaoImpl")
	private  InviteMasterApplyDao inviteMasterApplyDao;
	@Resource(name="inviteMasterApplyListDaoImpl")
	private  InviteMasterApplyListDao inviteMasterApplyListDaoImpl; 
	@Override
	public int insertInviteMasterApply(long memberID) {
		
		int result = 0; 
		result = inviteMasterApplyListDaoImpl.selectInviteMasterApplyIsExist(memberID);
		//判断该会员是否是推荐达人，或者存在未审核的申请
		if(result >0 ) {
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("memberID", memberID);
		map.put("imApplyID", id);
		result = inviteMasterApplyDao.insertInviteMasterApply(map); 
		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
	    }else{
			generatorUtil.SetIdUsedFail(id);
	    } 
		return result;
	}
	@Override
	public List<InviteMasterAwardRecordEntity> getInviteMasterAwardRecord(
			PageEntity page) {
		
		return inviteMasterApplyListDaoImpl.getInviteMasterAwardRecord(page);
		
	}
	@Override
	public List<AwardPaymentRecordEntity> getInviteMasterHistoryBack(
			PageEntity page) {
		
		return inviteMasterApplyListDaoImpl.getInviteMasterHistoryBack(page);
		
	}
	@Override
	public List<InvitationRecordEntity> getInviteInvitationRecord(
			PageEntity page) {
		
		return inviteMasterApplyListDaoImpl.getInviteInvitationRecord(page);
		
	}
	@Override
	public List<BorrowingDetailedEntity> selectInviteBorrowing(PageEntity page) {
		
		return inviteMasterApplyListDaoImpl.selectInviteBorrowing(page);
		
	}
	@Override
	public List<InvestDetailedEntity> getInviteInvest(PageEntity page) {
		
		return inviteMasterApplyListDaoImpl.getInviteInvest(page);
		
	}
	@Override
	public List<BayVIPEntity> getInviteVipPay(PageEntity page) {
		
		return inviteMasterApplyListDaoImpl.getInviteVipPay(page);
		
	}
	@Override
	public List<InvestRepaymentEntity> getRepaymentInvite(PageEntity page) {
		
		return inviteMasterApplyListDaoImpl.getRepaymentInvite(page);
		
	}
	@Override
	public InviteMasterAwardRecordEntity selectInviteMasterStatistic(
			long memberID) {
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("memberID",                memberID);
		map.put("skey",    DbKeyUtil.GetDbCodeKey());
		return inviteMasterApplyListDaoImpl.selectInviteMasterStatistic(map);
		
	}
 
	@Override
	public List<InviteMasterAwardRecordEntity> getInviteMasterAwardRecordExcel(
			Map<String, Object> map) {
		
		return inviteMasterApplyListDaoImpl.getInviteMasterAwardRecordExcel(map);
		
	}
	@Override
	public List<AwardPaymentRecordEntity> getInviteMasterHistoryBackExcel(
			Map<String, Object> map) {
		
		return inviteMasterApplyListDaoImpl.getInviteMasterHistoryBackExcel(map);
		
	}  
	 

}

