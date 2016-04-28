
package cn.springmvc.service.impl; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.AccountDaoSupport;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.ProjectInvestReadDaoImpl;
import cn.springmvc.dao.impl.ProjectInvestWriteDaoImpl;
import cn.springmvc.service.ProjectInvestService;
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
			short sClient,String sKey) {
		
//		long lId = IdGeneratorUtil.GetIdGeneratorInstance().GetId();
		TransferSubmitEntity entity = projectInvestReadDaoImpl.GetInvestInfo(sIsAuto, lMemberId, lProjectId, lAmount, lRedpackets, lVouchers, sClient);
//		projectInvestWriteDaoImpl.InsertProjectInvestTmp(lId, lProjectId, lMemberId, entity.get, lAmountTotal, lRedpackets, sRedpacketsInfo, lVouchers, isAuto, sKey)
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

}

