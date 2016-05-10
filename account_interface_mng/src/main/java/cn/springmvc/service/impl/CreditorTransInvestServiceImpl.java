
package cn.springmvc.service.impl; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.CreditorTransReadDaoImpl;
import cn.springmvc.dao.impl.CreditorTransWriteDaoImpl;
import cn.springmvc.service.CreditorTransInvestService;
import cn.sxlc.account.manager.model.LoanTransferReturnEntity;
import cn.sxlc.account.manager.model.TransferSubmitEntity;

/**
 * 债权转让投资
* @author 张友 
* @Description: 债权转让投资
* @since 
* @date 2016-5-9 下午1:39:30
 */

@Service
public class CreditorTransInvestServiceImpl implements CreditorTransInvestService{
	@Resource(name="creditorTransReadDaoImpl")
	private CreditorTransReadDaoImpl creditorTransReadDaoImpl;
	@Resource(name="creditorTransWriteDaoImpl")
	private CreditorTransWriteDaoImpl creditorTransWriteDaoImpl;
	
	@Override
	public long getCreditorMaxInvestAmount(long lProjectId, long lMemberId,
			long lCreditorTransAppId, String sKey) {
		
		return creditorTransReadDaoImpl.getCreditorMaxInvestAmount(lProjectId, lMemberId, lCreditorTransAppId, sKey);
		
	}

	@Override
	public String checkCreditorRecordByMember(long lProjectId, long lMemberId,
			long lCreditorTransAppId, short sIsAuto, long lAmount,
			String sRedPacketsInfo, long lVouchers, String sKey,
			long[] lRedPackets) {
		
		return creditorTransReadDaoImpl.checkCreditorRecordByMember(lProjectId, lMemberId, lCreditorTransAppId, sIsAuto, lAmount, 
				sRedPacketsInfo, lVouchers, sKey, lRedPackets);
		
	}

	@Override
	public TransferSubmitEntity getCreditorTransInfo(short sIsAuto,
			long lMemberId, long lCreditorTransAppId, long lAmount,
			long lRedPackets, long lVouchers, short sClient) {
		
		return creditorTransReadDaoImpl.getCreditorTransInfo(sIsAuto, lMemberId, lCreditorTransAppId, lAmount, 
				lRedPackets, lVouchers, sClient);
		
	}

	@Override
	public int processCreditorTransResult(LoanTransferReturnEntity returnEntity) {
		if(returnEntity == null){
			return 0;
		}
		return creditorTransWriteDaoImpl.processCreditorTransResult(returnEntity);
		
	}

}

