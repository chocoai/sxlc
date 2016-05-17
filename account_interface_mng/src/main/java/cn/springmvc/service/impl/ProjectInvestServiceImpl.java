
package cn.springmvc.service.impl; 


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.HandleThreePartyDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.ProjectInvestReadDaoImpl;
import cn.springmvc.dao.impl.ProjectInvestWriteDaoImpl;
import cn.springmvc.service.ProjectInvestService;
import cn.sxlc.account.manager.model.LoanInfoBeanSubmit;
import cn.sxlc.account.manager.model.LoanTransferReturnEntity;
import cn.sxlc.account.manager.model.TransferSubmitEntity;

/**
 * 项目投资  service 层
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-4-27 下午9:16:13
 */
@Service
public class ProjectInvestServiceImpl implements ProjectInvestService{
	
	@Resource(name="projectInvestWriteDaoImpl")
	private ProjectInvestWriteDaoImpl projectInvestWriteDaoImpl;  
	@Resource(name="projectInvestReadDaoImpl")
	private ProjectInvestReadDaoImpl projectInvestReadDaoImpl; 
	@Resource(name="handleThreePartyDaoImpl")
	private HandleThreePartyDaoImpl  handleThreePartyDaoImpl;
	@Override
	public long GetMaxInvestAmount(long lProjectId, long lMemberId,
			String sKey, short sIsAuto) {
		
		return projectInvestReadDaoImpl.GetMaxInvestAmount(lProjectId, lMemberId, sKey, sIsAuto);
		
	}

	@Override
	public String MemberInvestCheck(long lMemberId, long lProjectId,
			short sIsAuto, long lAmount, String sRedpacketsInfo,
			long lVouchers, String sKey, long[] lRedpackets, String sDirectPwd) {
		
		return projectInvestReadDaoImpl.MemberInvestCheck(lMemberId, lProjectId, sIsAuto, lAmount, sRedpacketsInfo, lVouchers, sKey, lRedpackets, sDirectPwd);
		
	}

	@Override
	public TransferSubmitEntity GetInvestInfo(short sIsAuto, long lMemberId,
			long lProjectId, long lAmount, long lRedpackets, long lVouchers,
			short sClient,String sKey,String sRedpackets) {
		long lId = IdGeneratorUtil.GetIdGeneratorInstance().GetId();
		String sOrderNo = null;
		String sSubOrderNo = null;
		TransferSubmitEntity entity = projectInvestReadDaoImpl.GetInvestInfo(sIsAuto, lMemberId, lProjectId, lAmount, lRedpackets, lVouchers, sClient);
		List<LoanInfoBeanSubmit> list = entity.getLoanInfoBeanSubmits();
		LoanInfoBeanSubmit submitEntity = null;
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
		projectInvestWriteDaoImpl.InsertProjectInvestTmp(lId,(short)0, lProjectId, lMemberId, sOrderNo,sSubOrderNo, lAmount, lRedpackets, sRedpackets, lVouchers, sIsAuto, sKey);
		return entity;
		
	}

	@Override
	public int ProjectInvestBackDeal(LoanTransferReturnEntity returnEntity) {
		
		return projectInvestWriteDaoImpl.ProjectInvestBackDeal(returnEntity);
		
	}

	@Override
	public long CheckInvestRedPackage(short sStatu, short sType,
			String sOrderNo, short sClient, String sKey) {
		
		return projectInvestWriteDaoImpl.CheckInvestRedPackage(sStatu, sType, sOrderNo, sClient, sKey);
		
	}

	@Override
	public int GetRedpacketsInvestRate() {
		
		return projectInvestReadDaoImpl.GetRedpacketsInvestRate();
		
	}

}

