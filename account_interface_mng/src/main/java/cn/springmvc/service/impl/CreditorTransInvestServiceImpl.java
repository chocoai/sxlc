
package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;

import cn.springmvc.dao.impl.CreditorTransReadDaoImpl;
import cn.springmvc.dao.impl.CreditorTransWriteDaoImpl;
import cn.springmvc.dao.impl.HandleThreePartyDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.ProjectInvestWriteDaoImpl;
import cn.springmvc.service.CreditorTransInvestService;
import cn.sxlc.account.manager.model.LoanInfoBeanSubmit;
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
	@Resource(name="handleThreePartyDaoImpl")
	private HandleThreePartyDaoImpl  handleThreePartyDaoImpl;
	@Resource(name="projectInvestWriteDaoImpl")
	private ProjectInvestWriteDaoImpl projectInvestWriteDaoImpl;  
	
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
			long lRedPackets, long lVouchers, short sClient,String sRedpackets) {
		
		TransferSubmitEntity entity = creditorTransReadDaoImpl.getCreditorTransInfo(sIsAuto, lMemberId, lCreditorTransAppId, lAmount, 
				lRedPackets, lVouchers, sClient);
		
		List<LoanInfoBeanSubmit> list = entity.getLoanInfoBeanSubmits();
		LoanInfoBeanSubmit submitEntity = null;
		String sOrderNo = "";
		String sSubOrderNo = "";
		int iSize = 0;
		if(list!= null){
			iSize = list.size();
		}
		for(int i=0;i<iSize;i++){
			submitEntity = list.get(i);
			if(i == 0){
				sOrderNo = handleThreePartyDaoImpl.generateorderNo("PI");
				submitEntity.setOrderNo(sOrderNo);
			}else{
				sSubOrderNo = handleThreePartyDaoImpl.generateorderNo("PI");
				submitEntity.setOrderNo(sOrderNo);
			}
		}
		long lId = IdGeneratorUtil.GetIdGeneratorInstance().GetId();
		String sKey = DbKeyUtil.GetDbCodeKey();
		projectInvestWriteDaoImpl.InsertProjectInvestTmp(lId,(short)1, lCreditorTransAppId, lMemberId, sOrderNo,sSubOrderNo, lAmount, lRedPackets, sRedpackets, lVouchers, sIsAuto, sKey);
		
		return entity;
	}

	@Override
	public int processCreditorTransResult(LoanTransferReturnEntity returnEntity) {
		if(returnEntity == null){
			return 0;
		}
		return creditorTransWriteDaoImpl.processCreditorTransResult(returnEntity);
		
	}

}

