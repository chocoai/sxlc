
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import cn.account_interface_mng.model.LoanReturnInfoBean;
import cn.account_interface_mng.model.LoanTransferReturnEntity;
import cn.springmvc.dao.ProjectInvestWriteDao;

public class ProjectInvestWriteDaoImpl extends SqlSessionDaoSupport implements ProjectInvestWriteDao{

	@Override
	public int ProjectInvestBackDeal(LoanTransferReturnEntity returnEntity) {
		int iResult = 0;
		if(returnEntity == null || returnEntity.getLoaninfolist() == null || returnEntity.getLoaninfolist().size()<=0){
			return iResult;
		}
		LoanReturnInfoBean infoBean = returnEntity.getLoaninfolist().get(0);
		String sRemark = infoBean.getRemark();
		// String sRemark = lProjectId + "," + lMemberId + "," + lRealAmount + "," + lRedpackets + "," + lVouchers
		// + "," + sIsAuto + "," + sClient + "," + lRewardRate + "," + lBackAmount + "";
		String sRemark1 = returnEntity.getRemark1();
		// sRemark = lMngFee + "," + lGuaranteeFee + "," + lRiskMarginFee + "";
		String sRemark2 = returnEntity.getRemark2();
		if(sRemark==null || sRemark1 == null || sRemark2 == null){
			return iResult;
		}
		String[] sR = sRemark.split(",");
		String[] sR1 = sRemark1.split(",");
		String[] sR2 = sRemark2.split(",");
		
		if(sR== null || sR.length<2){
			return iResult;
		}
		if(sR1== null || sR1.length<9){
			return iResult;
		}
		if(sR2== null || sR2.length<3){
			return iResult;
		}
		
		short iType = 0;
		if(sR[0]!=null && sR[0].equals("A")){
			iType = 1;
		}
		long lId = IdGeneratorUtil.GetIdGeneratorInstance().GetId();
		String sKey = DbKeyUtil.GetDbCodeKey();
		Map<String, Object> param = new HashMap<>();
		param.put("iStatu", returnEntity.getStatu());		//投资状态 0成功 1失败
		param.put("iType", iType);		// 投资类型 （0：会员账户投资 1：红包账户投资 ）
		param.put("orderNo", infoBean.getOrderNo());	// 平台订单号
		param.put("vBillNo", infoBean.getLoanNo());		// 第三方交易订单号
		param.put("iInvestId", lId);					// 投资记录id
		param.put("iProjectId", IntegerAndString.StringToLong(sR1[0], 0));		//借款项目id
		param.put("lMemberId", IntegerAndString.StringToLong(sR1[1], 0));		//投资会员id
		param.put("iMoney", IntegerAndString.StringToLong(sR1[2]));				//实际投资金额 投资总金额-使用红包-使用代金券
		param.put("iIsAuto", IntegerAndString.StringToLong(sR1[5], 0));			// 是否为自动投标
		param.put("iClient", IntegerAndString.StringToLong(sR1[6], 0));			// 投资客户端
		param.put("sKey", sKey);			// 加密解密key
		param.put("lRedpackets", IntegerAndString.StringToLong(sR1[3]));			// 使用红包
		param.put("lVouchers", IntegerAndString.StringToLong(sR1[5]));			// 使用代金券
		param.put("lMngFee", IntegerAndString.StringToLong(sR2[0]));			// 本次投资分润管理费
		param.put("lGuaranteeFee", IntegerAndString.StringToLong(sR2[1]));			// 本次投资分润的担保费
		param.put("lVouchers", IntegerAndString.StringToLong(sR2[2]));			// 本次投资分润的风险保证金
		param.put("lBackRate", IntegerAndString.StringToLong(sR1[7]));			// 返现率
		param.put("lBackAmount", IntegerAndString.StringToLong(sR1[8]));			// 返现金额
		
		getSqlSession().selectOne("ProjectInvestDao.ProjectInvestBack", param);
		iResult = IntegerAndString.StringToInt(param.get("result").toString(),0);
		
		return iResult;
	}

	@Override
	public int InsertProjectInvestTmp(long lId, long lProjectId,
			long lMemberId, String sOrderNo, long lAmountTotal,
			long lRedpackets, String sRedpacketsInfo, long lVouchers,
			short isAuto,String sKey) {
		int iResult = 0;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lId", lId);
		param.put("lProjectId", lProjectId);
		param.put("lMemberId", lMemberId);
		param.put("sOrderNo", sOrderNo);
		param.put("lAmountTotal", lAmountTotal);
		param.put("lRedpackets", lRedpackets);
		param.put("sRedpacketsInfo", sRedpacketsInfo);
		param.put("lVouchers", lVouchers);
		param.put("isAuto", isAuto);
		param.put("sKey", sKey);
		param.put("result", 0);
		
		getSqlSession().selectOne("ProjectInvestDao.InsertInvestTmp", param);
		
		iResult = IntegerAndString.StringToInt(param.get("result").toString(),0);
		return iResult;
	}

}

