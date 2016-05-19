package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import cn.springmvc.dao.ProjectInvestReadDao;
import cn.sxlc.account.manager.model.InvestAccountFeeEntity;
import cn.sxlc.account.manager.model.LoanInfoBeanSubmit;
import cn.sxlc.account.manager.model.LoanInfoSecondaryBean;
import cn.sxlc.account.manager.model.TransferSubmitEntity;
import cn.sxlc.account.manager.utils.InterfaceConstant;
@Repository("projectInvestReadDaoImpl")
public class ProjectInvestReadDaoImpl extends AccountDaoSupport implements ProjectInvestReadDao {

    /*public static final String RESOURCE_BUNDLE_ACCOUNT_MANAGER = "account.manager";
    private ResourceBundle mResourceBundle;

    public ProjectInvestReadDaoImpl() {
        super();
        this.mResourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_ACCOUNT_MANAGER);
    }*/
    
    @Override
    @Resource(name = "sqlSessionFactoryR")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 获取最大可投金额
     * GetMaxInvestAmount	获取某个会员对某个项目的当前最大可投金额
     * TODO(描述)
     *
     * @param @param  lProjectId			项目id
     * @param @param  lMemberId				会员id
     * @param @param  sKey					加密，解密key值
     * @param @param  sIsAuto				是否自动投标		0：否	1：是
     * @param @return 设定文件
     * @return long 返回类型
     * @throws
     * @author 张友
     * * @Title: GetMaxInvestAmount
     * @Description: TODO
     * @date 2016-3-28 下午8:27:59
     */
    @Override
    public long GetMaxInvestAmount(long lProjectId, long lMemberId, String sKey, short sIsAuto) {
        long lResult = 0;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put(DaoConstant.PARAM_PROJECT_ID, lProjectId);
        param.put(DaoConstant.PARAM_MEMBER_ID, lMemberId);
        param.put(DaoConstant.PARAM_AUTO_TENDER, sIsAuto);
        param.put(DaoConstant.PARAM_ENCRYPT_KEY, sKey);
        param.put(DaoConstant.PARAM_RESULT, 0);

        getSqlSession().selectOne(DaoConstant.PROJECT_INVEST_DAO_GET_PROJECT_MAX_INVEST_AMOUNT, param);
        
        lResult = 0;
        if(param.get(DaoConstant.PARAM_RESULT)!=null){
        	lResult = IntegerAndString.StringToLong(param.get(DaoConstant.PARAM_RESULT).toString(), -1);
        }

        return lResult;
    }

    /**
     * MemberInvestCheck		会员项目投资，投资前信息处理
     * TODO(描述)
     *
     * @param lMemberId       会员ID
     * @param lProjectId      项目ID
     * @param sIsAuto         是否为自动投标	0:否	1：是
     * @param lAmount         投资总金额		(单位元，保留4位小数)
     * @param sRedpacketsInfo 红包使用金额		红包1ID,使用金额(单位元，保留4位小数);红包ID2,使用金额;
     * @param lVouchers       代金券金额		(单位元，保留4位小数)
     * @param sKey            加密解密key
     * @param @return         设定文件
     * @return String 返回类型 				验证成功返回:success  其他为失败原因
     * 1：验证成功 0：验证失败 -1：投资金额超过最大投资金额 -2：使用红包金额比例大于项目最高红包比例 -3：红包已经过期
     * -4：红包使用金额大于红包总额 -5：代金券使用金额大于代金券可用余额	-6：红包、代金券总和不能超过或等于投资总额 -7：您投资的笔数已达上限不能再投资
     * -8:不能超过自动投标比例上限 -9：自动投资未开始 -10:项目未开标 -11：投资金额超过剩余投资金额 -12：项目已满标（投标时间结束，投标满标）
     * -13:自己不能投资自己的借款	-14：余额不足
     * @throws
     * @author 张友
     * * @Title: MemberInvestCheck
     * @Description: TODO
     * @date 2016-3-29 下午3:49:00
     */
    @Override
    public String MemberInvestCheck(long lMemberId, long lProjectId,
                                    short sIsAuto, long lAmount, String sRedpacketsInfo,
                                    long lVouchers, String sKey, long[] lRedpackets, String sDirectPwd) {
        String sResult = "fail";
        if (lRedpackets == null || lRedpackets.length < 1) {
            return sResult;
        }

        Map<String, Object> param = new HashMap<String, Object>();
        param.put(DaoConstant.PARAM_MEMBER_ID, lMemberId);
        param.put(DaoConstant.PARAM_PROJECT_ID, lProjectId);
        param.put(DaoConstant.PARAM_AUTO_TENDER, sIsAuto);
        param.put(DaoConstant.PARAM_TOTAL_AMOUNT, lAmount);
        param.put(DaoConstant.PARAM_RED_PACKETS_INFO, sRedpacketsInfo);
        param.put(DaoConstant.PARAM_VOUCHERS, lVouchers);
        param.put(DaoConstant.PARAM_ENCRYPT_KEY, sKey);
        param.put("sDirectPwd", sDirectPwd);
        param.put("vResult", "");
        param.put(DaoConstant.PARAM_RED_PACKETS, 0);
        param.put(DaoConstant.PARAM_RESULT, 0);

        getSqlSession().selectOne("ProjectInvestDao.MemberInvestCheckRecord", param);

        
//=========================================================================================
        if(param.get(DaoConstant.PARAM_RESULT) == null){
        	param.put(DaoConstant.PARAM_RESULT, "0");
        }
        if(param.get(DaoConstant.PARAM_RED_PACKETS) == null){
        	param.put(DaoConstant.PARAM_RED_PACKETS, "0");
        }
//=========================================================================================
        
        
        int iResult = IntegerAndString.StringToInt(param.get(DaoConstant.PARAM_RESULT).toString(), 0);
        lRedpackets[0] = 0;
        if(param.get(DaoConstant.PARAM_RED_PACKETS) != null){
        	lRedpackets[0] = IntegerAndString.StringToLong(param.get(DaoConstant.PARAM_RED_PACKETS).toString(), 0);
        }
        if (iResult == 1) {
            sResult = "success";
        } else if (iResult == 0) {
            sResult = "fail";
        } else {
            sResult = param.get("vResult").toString();
        }
        return sResult;
    }

    /**
     * 获取投资详情
     * GetInvestInfo 获取投资详情
     * TODO(描述)
     *
     * @param sIsAuto     自动投标	0：否 1：是
     * @param lMemberId   会员ID
     * @param lProjectId  项目ID
     * @param lAmount     投资总金额
     * @param lRedpackets 使用红包金额
     * @param lVouchers   使用代金券
     * @param 设定文件
     * @return TransferSubmitEntity 返回类型 	返回调用投资接口对象
     * @throws
     * @author 张友
     * * @Title: GetInvestInfo
     * @Description: TODO
     * @date 2016-3-30 下午5:11:26
     */
    @Override
    public TransferSubmitEntity GetInvestInfo(short sIsAuto, long lMemberId, long lProjectId,
                                              long lAmount, long lRedpackets, long lVouchers, short sClient) {
        //担保费分配
        long lRedpacketsGFee = 0;
        long lVouchersGFee = 0;
        long lAmountGFee = 0;
        long lGuaranteeFee = 0;        //本次支付担保费

        //风险保证金
        long lRedpacketsRFee = 0;
        long lVouchersRFee = 0;
        long lAmountRFee = 0;
        long lRiskMarginFee = 0;        //本次风险保证金

        //管理费
        long lRedpacketsMFee = 0;
        long lVouchersMFee = 0;
        long lAmountMFee = 0;
        long lMngFee = 0;        //本次管理费
        long lBackAmount = 0;        //返现金额
        long lRewardRate = 0;        //返现比例

        SqlSession session = getSqlSession();
        String sOrderNo = "";            //订单号
        int i = 1;

        TransferSubmitEntity entity = new TransferSubmitEntity();
        entity.setTransferAction(TransferSubmitEntity.TRANSFER_ACTION_TYPE_TENDER);
        if (sIsAuto == 0) {
            entity.setAction(TransferSubmitEntity.ACTION_TYPE_MANUAL);
        } else {
            entity.setAction(TransferSubmitEntity.ACTION_TYPE_AUTO);
        }
        //计算实际投资金额
        long lRealAmount = lAmount - lRedpackets - lVouchers;

        //配置转帐帐号信息

        InterfaceUtil interfaceUtil = InterfaceUtil.GetInterfaceUtilInstance();
        String sRiskMarginAccount = interfaceUtil.GetRiskMarginAccountMark();        //风险保证金账户
        //获取投资人帐户信息
        String sInvestMark = getInvestMemberMark(lMemberId);
        //获取平台账户信息
        entity.setPlatformMoneyMoreMore(interfaceUtil.GetOwnAccountMark());
        //配置转帐URL
        entity.setSubmitURL(interfaceUtil.GetInterfaceUrl(InterfaceConstant.IXIANGMUTOUBIAO));

        //获取担保费 担保账户标识

        InvestAccountFeeEntity feeEntity = getGuaranteeInfo(lProjectId);
        //返现费率
        lRewardRate = feeEntity.getiRewardRate();
        //计算返现金额
        lBackAmount = lAmount * lRewardRate / 1000000;

        //担保费二次分润

        //计算担保费
        if (feeEntity.getlGuaranteeFee() > 0) {
            lGuaranteeFee = lAmount * feeEntity.getlGuaranteeFee() / feeEntity.getlAmountTotal();
            if (lRedpackets > 0) {
                lRedpacketsGFee = lRedpackets * lGuaranteeFee / lAmount;
            }
            if (lVouchers > 0) {
                lVouchersGFee = lVouchers * lGuaranteeFee / lAmount;
            }
            lAmountGFee = lGuaranteeFee - lRedpacketsGFee - lVouchersGFee;
        }
        //计算风险保证金
        if (feeEntity.getlRiskMarginFee() > 0) {
            lRiskMarginFee = lAmount * feeEntity.getlRiskMarginFee() / feeEntity.getlAmountTotal();
            if (lRedpackets > 0) {
                lRedpacketsRFee = lRedpackets * lRiskMarginFee / lAmount;
            }
            if (lVouchers > 0) {
                lVouchersRFee = lVouchers * lRiskMarginFee / lAmount;
            }
            lAmountRFee = lRiskMarginFee - lRedpacketsRFee - lVouchersRFee;
        }
        //计算管理费
        if (feeEntity.getlMngFee() > 0) {
            lMngFee = lAmount * feeEntity.getlMngFee() / feeEntity.getlAmountTotal();
            if (lRedpackets > 0) {
                lRedpacketsMFee = lRedpackets * lMngFee / lAmount;
            }
            if (lVouchers > 0) {
                lVouchersMFee = lVouchers * lMngFee / lAmount;
            }
            lAmountMFee = lMngFee - lRedpacketsMFee - lVouchersMFee;
        }

        //生成返回值

        List<LoanInfoBeanSubmit> list = new ArrayList<LoanInfoBeanSubmit>();
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

        //计算平台支付给借款人的转帐信息

        long l = lRedpackets + lVouchers - lRedpacketsMFee - lVouchersMFee;
        if (l > 0) {
            l = lRedpackets + lVouchers - lRedpacketsMFee - lVouchersMFee;
            beanEntity.setLoanOutMoneymoremore(entity.getPlatformMoneyMoreMore());
            beanEntity.setLoanInMoneymoremore(sInvestMark);
            beanEntity.setOrderNo(sOrderNo + i + "");
            i++;
            beanEntity.setBatchNo(feeEntity.getsProjectNo());
            beanEntity.setAmount(IntegerAndString.LongToString2(l));
            beanEntity.setFullAmount(IntegerAndString.LongToString2(feeEntity.getlAmountTotal()));
            beanEntity.setTransferName("平台支付给借款人");
            beanEntity.setRemark("ACTCT平台支付给借款人，金额:" + IntegerAndString.LongToString2(l));
            secondList = new ArrayList<LoanInfoSecondaryBean>();

            // 平台支付给风险保证金：红包R(风险保证金) + 代金券R(风险保证金)
            l = lRedpacketsRFee + lVouchersRFee;
            if (l > 0) {
                secondaryEntity = new LoanInfoSecondaryBean();
                secondaryEntity.setAmount(IntegerAndString.LongToString2(l));
                secondaryEntity.setLoanInMoneymoremore(sRiskMarginAccount);
                secondaryEntity.setRemark("平台支付红包及代金券部分风险保证金");
                secondList.add(secondaryEntity);
            }

            // 平台给担保机构：红包G(担保费)+代金券G(担保费)
            l = lRedpacketsGFee + lVouchersGFee;
            if (l > 0) {
                secondaryEntity = new LoanInfoSecondaryBean();
                secondaryEntity.setAmount(IntegerAndString.LongToString2(l));
                secondaryEntity.setLoanInMoneymoremore(feeEntity.getsGuaranteeMark());
                secondaryEntity.setRemark("平台支付红包及代金券部分担保费");
                secondList.add(secondaryEntity);
            }

            beanEntity.setLoanInfoSecondaryBeanList(secondList);
            list.add(beanEntity);
        }

        // 投资人给借款人:实际投资金额 - 实际M(管理费) - 实际G(担保费) - 实际R(风险保证金)

        l = lRealAmount;
        if (l > 0) {
            if (lBackAmount > 0) {
                l = l - lBackAmount;
                if (l < 100) {
                    l = 100;
                    lBackAmount = lRealAmount - l;
                }
            }
            beanEntity.setLoanOutMoneymoremore(sInvestMark);
            beanEntity.setLoanInMoneymoremore(feeEntity.getsMemberMark());
            beanEntity.setOrderNo(sOrderNo + i + "");
            i++;
            beanEntity.setBatchNo(feeEntity.getsProjectNo());
            beanEntity.setAmount(IntegerAndString.LongToString2(l));
            beanEntity.setFullAmount(IntegerAndString.LongToString2(feeEntity.getlAmountTotal()));
            beanEntity.setTransferName("投资人支付给借款人");
            beanEntity.setRemark("BCTCT投资人支付给借款人，金额:" + IntegerAndString.LongToString2(l));

            secondList = new ArrayList<LoanInfoSecondaryBean>();

            // 投资人给担保机构:实际G(担保费)
            l = lRedpacketsRFee + lVouchersRFee;
            if (l > 0) {
                secondaryEntity = new LoanInfoSecondaryBean();
                secondaryEntity.setAmount(IntegerAndString.LongToString2(l));
                secondaryEntity.setLoanInMoneymoremore(feeEntity.getsGuaranteeMark());
                secondaryEntity.setRemark("投资人支付担保费用");
                secondList.add(secondaryEntity);
            }

            // 投资人给风险保证金：实际R(风险保证金)
            l = lAmountRFee;
            if (l > 0) {
                secondaryEntity = new LoanInfoSecondaryBean();
                secondaryEntity.setAmount(IntegerAndString.LongToString2(l));
                secondaryEntity.setLoanInMoneymoremore(sRiskMarginAccount);
                secondaryEntity.setRemark("投资人支付风险保证金");
                secondList.add(secondaryEntity);
            }

            // 投资人给平台：实际M(管理费)
            l = lAmountMFee;
            if (l > 0) {
                secondaryEntity = new LoanInfoSecondaryBean();
                secondaryEntity.setAmount(IntegerAndString.LongToString2(l));
                secondaryEntity.setLoanInMoneymoremore(entity.getPlatformMoneyMoreMore());
                secondaryEntity.setRemark("投资人支付管理费");
                secondList.add(secondaryEntity);
            }

            beanEntity.setLoanInfoSecondaryBeanList(secondList);
            list.add(beanEntity);
        }

        //使用红包，使用代金券
        //String.format("%s,%s,%s,%s,%s,%s",);
        String sRemark = lProjectId + "A" + lMemberId + "A" + lRealAmount + "A" + lRedpackets + "A" + lVouchers
                + "A" + sIsAuto + "A" + sClient + "A" + lRewardRate + "A" + lBackAmount + "";
        entity.setRemark1(sRemark);
        //支付管理费，支付担保费，支付风险保证金
        sRemark = lMngFee + "A" + lGuaranteeFee + "A" + lRiskMarginFee + "";
        entity.setRemark2(sRemark);
        entity.setLoanInfoBeanSubmits(list);
        
        // 平台给平台：红包M(管理费) + 代金券M(管理费)
        return entity;
    }
    
    @Override
    public int GetRedpacketsInvestRate(){
    	int iResult = 0;
    	
    	String sInfo = getSqlSession().selectOne("ProjectInvestDao.GetRedpacketsInvestRate");
    	iResult=IntegerAndString.StringToInt(sInfo, 0);
    	
    	return iResult;
    }
    
}

