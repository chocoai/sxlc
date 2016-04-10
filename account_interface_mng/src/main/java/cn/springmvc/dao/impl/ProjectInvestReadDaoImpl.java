package cn.springmvc.dao.impl; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.account_interface_mng.model.InvestAccountFeeEntity;
import cn.account_interface_mng.model.LoanInfoBeanSubmit;
import cn.account_interface_mng.model.LoanInfoSecondaryBean;
import cn.account_interface_mng.model.TransferSubmitEntity;
import cn.account_interface_mng.model.UnUsedRedpacketsEntity;
import cn.interfacemng.util.InterfaceConstant;
import cn.interfacemng.util.InterfaceUtil;
import cn.springmvc.dao.ProjectInvestReadDao;

public class ProjectInvestReadDaoImpl extends SqlSessionDaoSupport implements ProjectInvestReadDao{
	
	/**
	 * 获取最大可投金额
	* GetMaxInvestAmount	获取某个会员对某个项目的当前最大可投金额
	* TODO(描述)
	* @author 张友  
	* * @Title: GetMaxInvestAmount 
	* @Description: TODO 
	* @param @param lProjectId				项目id
	* @param @param lMemberId				会员id
	* @param @param sKey					加密，解密key值
	* @param @param sIsAuto					是否自动投标		0：否	1：是
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-3-28 下午8:27:59
	* @throws
	 */
	@Override
	public long GetMaxInvestAmount(long lProjectId, long lMemberId,String sKey,short sIsAuto) {
		long lResult = 0;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lProjectId", lProjectId);
		param.put("lMemberId", lMemberId);
		param.put("isAuto", sIsAuto);
		param.put("sKey", sKey);
		param.put("result", 0);
		
		getSqlSession().selectOne("ProjectInvestDao.GetProjectMaxInvestAmount",param);
		
		lResult = IntegerAndString.StringToLong(param.get("result").toString(),-1);
		
		return lResult;		
	}

	/**
	 * 获取会员剩余代金券
	* GetRemainderVouchers		获取某个会员当前剩余代金券
	* TODO(描述)
	* @author 张友  
	* * @Title: GetRemainderVouchers 
	* @Description: TODO 
	* @param @param lMemberId			会员ID
	* @param @return 设定文件 
	* @return long 返回类型 
	* @date 2016-3-28 下午8:48:39
	* @throws
	 */
	@Override
	public long GetRemainderVouchers(long lMemberId) {
		long lResult = 0;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lMemberId", lMemberId);
		param.put("result", 0);
		
		getSqlSession().selectOne("ProjectInvestDao.GetRemainderVouchers",param);
		
		lResult = IntegerAndString.StringToLong(param.get("result").toString(),-1);
		
		return lResult;
	}

	/**
	 * 获取会员可用红包列表
	* GetMemberUnUsedRedpackets			获取会员可用红包列表 
	* TODO(描述)
	* @author 张友  
	* * @Title: GetMemberUnUsedRedpackets 
	* @Description: TODO 
	* @param @param lMemberId				会员ID
	* @param @return 设定文件 
	* @return List<UnUsedRedpacketsEntity> 返回类型 			红包列表
	* @date 2016-3-29 下午2:27:11
	* @throws
	 */
	@Override
	public List<UnUsedRedpacketsEntity> GetMemberUnUsedRedpackets(long lMemberId) {
		Map<String, Object> param = new HashMap<>();
		param.put("memberId", lMemberId);
		List<UnUsedRedpacketsEntity> list = getSqlSession().selectList("ProjectInvestDao.GetUnUsedRedpackets",param);
		return list;
	}

	/**
	 * 
	* MemberInvestCheck		会员项目投资，投资前信息处理 
	* TODO(描述)
	* @author 张友  
	* * @Title: MemberInvestCheck 
	* @Description: TODO 
	* @param lMemberId				会员ID
	* @param lProjectId				项目ID
	* @param sIsAuto					是否为自动投标	0:否	1：是
	* @param lAmount					投资总金额		(单位元，保留4位小数)
	* @param sRedpacketsInfo			红包使用金额		红包1ID,使用金额(单位元，保留4位小数);红包ID2,使用金额;
	* @param lVouchers					代金券金额		(单位元，保留4位小数)
	* @param sKey						加密解密key
	* @param @return 设定文件 
	* @return String 返回类型 				验证成功返回:success  其他为失败原因
	* 1：验证成功 0：验证失败 -1：投资金额超过最大投资金额 -2：使用红包金额比例大于项目最高红包比例 -3：红包已经过期
	 -4：红包使用金额大于红包总额 -5：代金券使用金额大于代金券可用余额	-6：红包、代金券总和不能超过或等于投资总额 -7：您投资的笔数已达上限不能再投资
	 -8:不能超过自动投标比例上限 -9：自动投资未开始 -10:项目未开标 -11：投资金额超过剩余投资金额 -12：项目已满标（投标时间结束，投标满标）
	 -13:自己不能投资自己的借款	-14：余额不足
	* @date 2016-3-29 下午3:49:00
	* @throws
	 */
	@Override
	public String MemberInvestCheck(long lMemberId, long lProjectId,
			short sIsAuto, long lAmount, String sRedpacketsInfo,
			long lVouchers, String sKey,long[] lRedpackets,String sDirectPwd) {
		String sResult = "fail";
		if(lRedpackets == null || lRedpackets.length<1){
			return sResult;
		}
		
		Map<String, Object> param = new HashMap<>();
		param.put("lMemberId", lMemberId);
		param.put("lProjectId", lProjectId);
		param.put("sIsAuto", sIsAuto);
		param.put("lTotalAmount", lAmount);
		param.put("sRedpacketsInfo", sRedpacketsInfo);
		param.put("lVouchers", lVouchers);
		param.put("sKey", sKey);
		param.put("vResult", "");
		param.put("lRedpackets", 0);
		param.put("result", 0);
		
		getSqlSession().selectOne("ProjectInvestDao.MemberInvestCheckRecord",param);
		
		int iResult = IntegerAndString.StringToInt(param.get("result").toString(),0);
		lRedpackets[0] = IntegerAndString.StringToLong(param.get("lRedpackets").toString(),0);
		if(iResult == 1){
			sResult = "success";
		}else if(iResult == 0){
			sResult = "fail";
		}else{
			sResult = param.get("vResult").toString();
		}
		return sResult;
	}

	/**
	 * 获取投资详情
	* GetInvestInfo 获取投资详情
	* TODO(描述)
	* @author 张友  
	* * @Title: GetInvestInfo 
	* @Description: TODO 
	* @param sIsAuto			自动投标	0：否 1：是
	* @param lMemberId			会员ID
	* @param lProjectId			项目ID
	* @param lAmount			投资总金额
	* @param lRedpackets		使用红包金额
	* @param lVouchers			使用代金券
	* @param 设定文件 
	* @return TransferSubmitEntity 返回类型 	返回调用投资接口对象
	* @date 2016-3-30 下午5:11:26
	* @throws
	 */
	@Override
	public TransferSubmitEntity GetInvestInfo(short sIsAuto,long lMemberId, long lProjectId,
			long lAmount, long lRedpackets, long lVouchers,short sClient) {
		//担保费分配
		long lRedpacketsGFee = 0;
		long lVouchersGFee = 0;
		long lAmountGFee = 0;
		long lGuaranteeFee = 0;		//本次支付担保费
		
		//风险保证金
		long lRedpacketsRFee = 0;
		long lVouchersRFee = 0;
		long lAmountRFee = 0;
		long lRiskMarginFee = 0;		//本次风险保证金
		
		//管理费
		long lRedpacketsMFee = 0;
		long lVouchersMFee = 0;
		long lAmountMFee = 0;
		long lMngFee = 0;		//本次管理费
		long lBackAmount = 0;		//返现金额
		long lRewardRate = 0;		//返现比例
		
		SqlSession session = getSqlSession();
		String sOrderNo = "";			//订单号
		int i = 1;
		
		TransferSubmitEntity entity = new TransferSubmitEntity();
		entity.setTransferAction("1");
		if(sIsAuto == 0){
			entity.setAction("1");
		}else{
			entity.setAction("2");
		}
		long lRealAmount = lAmount - lRedpackets - lVouchers;
		InterfaceUtil interfaceUtil = InterfaceUtil.GetInterfaceUtilInstance();
		String sRiskMarginAccount = interfaceUtil.GetRiskMarginAccountMark();		//风险保证金账户
		String sInvestMark = session.selectOne("ProjectInvestDao.GetInvestMemberMark");													//投资人账户
		entity.setPlatformMoneymoremore(interfaceUtil.GetOwnAccountMark());
		entity.setSubmitURL(interfaceUtil.GetInterfaceUrl(InterfaceConstant.ICHONGZHI));
		Map<String, Object> param = new HashMap<>();
		param.put("applyId", lProjectId);
		// 获取担保费 担保账户标识
		InvestAccountFeeEntity feeEntity = session.selectOne("ProjectInvestDao.GetGuaranteeInfo", param);
		lRewardRate = feeEntity.getiRewardRate();
		lBackAmount = lAmount * lRewardRate / 1000000;
		
		//担保费二次分润
		if(feeEntity.getlGuaranteeFee() >0){
			lGuaranteeFee = lAmount * feeEntity.getlGuaranteeFee()/ feeEntity.getlAmountTotal();
			if(lRedpackets>0){
				lRedpacketsGFee = lRedpackets*lGuaranteeFee/lAmount;
			}
			if(lVouchers>0){
				lVouchersGFee = lVouchers*lGuaranteeFee/lAmount;
			}
			lAmountGFee = lGuaranteeFee - lRedpacketsGFee - lVouchersGFee;
		}
		if(feeEntity.getlRiskMarginFee()>0){
			lRiskMarginFee = lAmount * feeEntity.getlRiskMarginFee()/ feeEntity.getlAmountTotal();
			if(lRedpackets>0){
				lRedpacketsRFee = lRedpackets*lRiskMarginFee/lAmount;
			}
			if(lVouchers>0){
				lVouchersRFee = lVouchers*lRiskMarginFee/lAmount;
			}
			lAmountRFee = lRiskMarginFee - lRedpacketsRFee - lVouchersRFee;
		}
		if(feeEntity.getlMngFee()>0){
			lMngFee = lAmount * feeEntity.getlMngFee()/ feeEntity.getlAmountTotal();
			if(lRedpackets>0){
				lRedpacketsMFee = lRedpackets*lMngFee/lAmount;
			}
			if(lVouchers>0){
				lVouchersMFee = lVouchers*lMngFee/lAmount;
			}
			lAmountMFee = lMngFee - lRedpacketsMFee - lVouchersMFee;
		}
		
		List<LoanInfoBeanSubmit> list = new ArrayList<>();
		LoanInfoBeanSubmit beanEntity = new LoanInfoBeanSubmit();
		List<LoanInfoSecondaryBean> secondList = null;
		LoanInfoSecondaryBean secondaryEntity = null;
		// 平台支付给借款人：红包+代金券 - 红包M(管理费) - 红包G(担保费) - 红包R(风险保证金) - 代金券M(管理费) - 代金券G(担保费) - 代金券R(风险保证金)
//		long l = lRedpackets + lVouchers - lRedpacketsGFee - lRedpacketsRFee - lRedpacketsMFee
//				- lVouchersGFee - lVouchersRFee - lVouchersMFee;
		// 平台支付给风险保证金：红包R(风险保证金) + 代金券R(风险保证金)
//		l = lRedpacketsRFee + lVouchersRFee;
		// 平台给担保机构：红包G(担保费)+代金券G(担保费)
//		l = lRedpacketsGFee + lVouchersGFee;
		
		long l = lRedpackets + lVouchers - lRedpacketsMFee
				- lVouchersMFee;
		if(l >0){
			l = lRedpackets + lVouchers - lRedpacketsMFee
					- lVouchersMFee;
			beanEntity.setLoanOutMoneymoremore(entity.getPlatformMoneymoremore());
			beanEntity.setLoanInMoneymoremore(sInvestMark);
			beanEntity.setOrderNo(sOrderNo+i+"");
			i++;
			beanEntity.setBatchNo(feeEntity.getsProjectNo());
			beanEntity.setAmount(IntegerAndString.LongToString(l));
			beanEntity.setFullAmount(IntegerAndString.LongToString(feeEntity.getlAmountTotal()));
			beanEntity.setTransferName("平台支付给借款人");
			beanEntity.setRemark("A,平台支付给借款人，金额:" + IntegerAndString.LongToString(l));
			secondList = new ArrayList<>();
			
			// 平台支付给风险保证金：红包R(风险保证金) + 代金券R(风险保证金)
			l = lRedpacketsRFee + lVouchersRFee;
			if(l>0){
				secondaryEntity = new LoanInfoSecondaryBean();
				secondaryEntity.setAmount(IntegerAndString.LongToString(l));
				secondaryEntity.setLoanInMoneymoremore(sRiskMarginAccount);
				secondaryEntity.setRemark("平台支付红包及代金券部分风险保证金");
				secondList.add(secondaryEntity);
			}
			
			// 平台给担保机构：红包G(担保费)+代金券G(担保费)
			l = lRedpacketsGFee + lVouchersGFee;
			if(l >0){
				secondaryEntity = new LoanInfoSecondaryBean();
				secondaryEntity.setAmount(IntegerAndString.LongToString(l));
				secondaryEntity.setLoanInMoneymoremore(feeEntity.getsGuaranteeMark());
				secondaryEntity.setRemark("平台支付红包及代金券部分担保费");
				secondList.add(secondaryEntity);
			}
			
			beanEntity.setLoanInfoSecondaryBeanList(secondList);
			list.add(beanEntity);
		}
		
		
		/*if(l > 0){
			beanEntity.setLoanOutMoneymoremore(entity.getPlatformMoneymoremore());
			beanEntity.setLoanInMoneymoremore(sRiskMarginAccount);
			beanEntity.setOrderNo(sOrderNo+i+"");
			i++;
			beanEntity.setBatchNo(feeEntity.getsProjectNo());
			beanEntity.setAmount(IntegerAndString.LongToString2(l));
			beanEntity.setFullAmount(IntegerAndString.LongToString2(feeEntity.getlAmountTotal()));
			beanEntity.setTransferName("平台支付风险保证金");
			beanEntity.setRemark("平台支付风险保证金，金额:" + IntegerAndString.LongToString2(l));
			list.add(beanEntity);
		}*/
		/*if(l > 0){
			beanEntity.setLoanOutMoneymoremore(entity.getPlatformMoneymoremore());
			beanEntity.setLoanInMoneymoremore(feeEntity.getsGuaranteeMark());
			beanEntity.setOrderNo(sOrderNo+i+"");
			i++;
			beanEntity.setBatchNo(feeEntity.getsProjectNo());
			beanEntity.setAmount(IntegerAndString.LongToString2(l));
			beanEntity.setFullAmount(IntegerAndString.LongToString2(feeEntity.getlAmountTotal()));
			beanEntity.setTransferName("投资人支付给平台");
			beanEntity.setRemark("投资人支付给平台，金额:" + IntegerAndString.LongToString2(l));
			list.add(beanEntity);
		}*/
		
		// 投资人给借款人:实际投资金额 - 实际M(管理费) - 实际G(担保费) - 实际R(风险保证金)
		l = lRealAmount;
		if(l>0){
			if(lBackAmount>0){
				l = l - lBackAmount;
				if(l<100){
					l = 100;
					lBackAmount = lRealAmount - l;
				}
			}
			beanEntity.setLoanOutMoneymoremore(sInvestMark);
			beanEntity.setLoanInMoneymoremore(feeEntity.getsMemberMark());
			beanEntity.setOrderNo(sOrderNo+i+"");
			i++;
			beanEntity.setBatchNo(feeEntity.getsProjectNo());
			beanEntity.setAmount(IntegerAndString.LongToString(l));
			beanEntity.setFullAmount(IntegerAndString.LongToString(feeEntity.getlAmountTotal()));
			beanEntity.setTransferName("投资人支付给借款人");
			beanEntity.setRemark("B,投资人支付给借款人，金额:" + IntegerAndString.LongToString(l));
			
			secondList = new ArrayList<>();
			
			// 投资人给担保机构:实际G(担保费)
			l = lRedpacketsRFee + lVouchersRFee;
			if(l>0){
				secondaryEntity = new LoanInfoSecondaryBean();
				secondaryEntity.setAmount(IntegerAndString.LongToString(l));
				secondaryEntity.setLoanInMoneymoremore(feeEntity.getsGuaranteeMark());
				secondaryEntity.setRemark("投资人支付担保费用");
				secondList.add(secondaryEntity);
			}
			
			// 投资人给风险保证金：实际R(风险保证金)
			l = lAmountRFee;
			if(l >0){
				secondaryEntity = new LoanInfoSecondaryBean();
				secondaryEntity.setAmount(IntegerAndString.LongToString(l));
				secondaryEntity.setLoanInMoneymoremore(sRiskMarginAccount);
				secondaryEntity.setRemark("投资人支付风险保证金");
				secondList.add(secondaryEntity);
			}
			
			// 投资人给平台：实际M(管理费)
			l = lAmountMFee;
			if(l >0){
				secondaryEntity = new LoanInfoSecondaryBean();
				secondaryEntity.setAmount(IntegerAndString.LongToString(l));
				secondaryEntity.setLoanInMoneymoremore(entity.getPlatformMoneymoremore());
				secondaryEntity.setRemark("投资人支付管理费");
				secondList.add(secondaryEntity);
			}
			
			beanEntity.setLoanInfoSecondaryBeanList(secondList);
			list.add(beanEntity);
		}
		
		// 投资人给担保机构:实际G(担保费)
		/*l = lAmountGFee;
		if(l>0){
			beanEntity.setLoanOutMoneymoremore(sInvestMark);
			beanEntity.setLoanInMoneymoremore(feeEntity.getsGuaranteeMark());
			beanEntity.setOrderNo(sOrderNo+i+"");
			i++;
			beanEntity.setBatchNo(feeEntity.getsProjectNo());
			beanEntity.setAmount(IntegerAndString.LongToString2(l));
			beanEntity.setFullAmount(IntegerAndString.LongToString2(feeEntity.getlAmountTotal()));
			beanEntity.setTransferName("投资人支付担保费");
			beanEntity.setRemark("投资人支付担保费，金额:" + IntegerAndString.LongToString2(l));
			list.add(beanEntity);
		}*/
		// 投资人给风险保证金：实际R(风险保证金)
		/*l = lAmountRFee;
		if(l>0){
			beanEntity.setLoanOutMoneymoremore(sInvestMark);
			beanEntity.setLoanInMoneymoremore(sRiskMarginAccount);
			beanEntity.setOrderNo(sOrderNo+i+"");
			i++;
			beanEntity.setBatchNo(feeEntity.getsProjectNo());
			beanEntity.setAmount(IntegerAndString.LongToString2(l));
			beanEntity.setFullAmount(IntegerAndString.LongToString2(feeEntity.getlAmountTotal()));
			beanEntity.setTransferName("投资人支付风险保证金");
			beanEntity.setRemark("投资人风险保证金，金额:" + IntegerAndString.LongToString2(l));
			list.add(beanEntity);
		}*/
		
		// 投资人给平台：实际M(管理费)
		/*l = lAmountMFee;
		if(l>0){
			beanEntity.setLoanOutMoneymoremore(sInvestMark);
			beanEntity.setLoanInMoneymoremore(entity.getPlatformMoneymoremore());
			beanEntity.setOrderNo(sOrderNo+i+"");
			i++;
			beanEntity.setBatchNo(feeEntity.getsProjectNo());
			beanEntity.setAmount(IntegerAndString.LongToString2(l));
			beanEntity.setFullAmount(IntegerAndString.LongToString2(feeEntity.getlAmountTotal()));
			beanEntity.setTransferName("投资人支付给平台");
			beanEntity.setRemark("投资人支付给平台，金额:" + IntegerAndString.LongToString2(l));
			list.add(beanEntity);
		}*/
		
		//使用红包，使用代金券
		String sRemark = lProjectId + "," + lMemberId + "," + lRealAmount + "," + lRedpackets + "," + lVouchers
				+ "," + sIsAuto + "," + sClient + "," + lRewardRate + "," + lBackAmount + "";
		entity.setRemark1(sRemark);
		//支付管理费，支付担保费，支付风险保证金
		sRemark = lMngFee + "," + lGuaranteeFee + "," + lRiskMarginFee + "";
		entity.setRemark2(sRemark);
//		private String randomTimeStamp;//
//		private String remark1;//备注;可拼接此次转账需处理信息 如：会员id、红包id
//		private String remark2;//备注;可拼接此次转账需处理信息 如：会员id
//		private String remark3;//备注;可拼接此次转账需处理信息 如：会员id
//		private String returnURL;//页面返回网址
//		private String notifyURL;//后台通知网址
//		private List<LoanInfoBeanSubmit> loanInfoBeanSubmits;//转账列表集合
		
		// 平台给平台：红包M(管理费) + 代金券M(管理费)
		return entity;
	}
	
	
	@Override
	@Resource(name="sqlSessionFactoryR")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}

