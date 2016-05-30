package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import cn.springmvc.dao.CreditorTransReadDao;
import cn.sxlc.account.manager.model.InvestAccountFeeEntity;
import cn.sxlc.account.manager.model.LoanInfoBeanSubmit;
import cn.sxlc.account.manager.model.LoanInfoSecondaryBean;
import cn.sxlc.account.manager.model.TransferSubmitEntity;
import cn.sxlc.account.manager.utils.InterfaceConstant;

/**
 * Created by yonghuang on 16/4/14.
 */
@Repository("creditorTransReadDaoImpl")
public class CreditorTransReadDaoImpl extends AccountDaoSupport implements CreditorTransReadDao {

    public static final String REMARK_FORMAT = "%dA%dA%dA%dA%dA%dA%dA%d";
    public static final String FORMAT = "%dA%dA%d";
    public static final String REMARK2_FORMAT = FORMAT;

    /**
     * getCreditorMaxInvestAmount	获取某个会员对债权最大可投金额
     * TODO(描述)
     *
     * @param lProjectId          项目id
     * @param lMemberId           会员id
     * @param lCreditorTransAppId 债权转让的申请id
     * @param sKey                加密，解密key值
     * @return long 返回类型       小于0:表示错误 -1 表示项目不存在,-2 已经达到最大投资笔数,-3 已经达到最大投资额度
     * @throws null <p>
     */
    public long getCreditorMaxInvestAmount(long lProjectId, long lMemberId, long lCreditorTransAppId, String sKey) {
        Map<String, Object> param = new HashMap<String, Object>();
//        param.put(DaoConstant.PARAM_PROJECT_ID, lProjectId);
        param.put(DaoConstant.PARAM_MEMBER_ID, lMemberId);
        param.put(DaoConstant.PARAM_CREDITOR_TRANS_APPLY_ID, lCreditorTransAppId);
        param.put(DaoConstant.PARAM_ENCRYPT_KEY, sKey);
        param.put(DaoConstant.PARAM_RESULT, 0);

        getSqlSession().selectOne(DaoConstant.CREDITOR_TRANS_DAO_GET_CREDITOR_MAX_INVEST_AMOUNT, param);

        return IntegerAndString.StringToLong(param.get(DaoConstant.PARAM_RESULT).toString(), -1);
    }

    /**
     * @param lMemberId       会员ID
     * @param lProjectId      项目ID
     * @param sIsAuto         是否为自动投标	0:否	1：是
     * @param lAmount         投资总金额		(单位元，保留4位小数)
     * @param sRedPacketsInfo 红包使用金额		红包1ID,使用金额(单位元 格式：0.20元，保留2位小数);红包ID2,使用金额;
     * @param lVouchers       代金券金额		(单位元，保留4位小数)
     * @param sKey            加密解密key
     * @param lRedPackets     返回红包总额
     * @return long 返回类型   验证成功返回:success  其他为失败原因
     * 1：验证成功 0：验证失败
     * -1：投资金额超过最大投资金额
     * -2：使用红包金额比例大于项目最高红包比例
     * -3：红包已经过期
     * -4：红包使用金额大于红包总额
     * -5：代金券使用金额大于代金券可用余额
     * -6：红包、代金券总和不能超过或等于投资总额
     * -7：您投资的笔数已达上限不能再投资
     * -8: 不能超过自动投标比例上限
     * -9：自动投资未开始
     * -10: 项目未开标
     * -11：投资金额超过剩余投资金额
     * -12：项目已满标（投标时间结束，投标满标）
     * -13: 自己不能投资自己的借款
     * -14：余额不足
     * -15:定向标密码错误
     * -16: 借款人不能投资此债权
     * -17: 转让人不能投资此债权
     * @throws null TODO(描述)
     */
    @Override
    public String checkCreditorRecordByMember(long lProjectId, long lMemberId, long lCreditorTransAppId, short sIsAuto,
                                            long lAmount, String sRedPacketsInfo, long lVouchers, String sKey, long[] lRedPackets) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put(DaoConstant.PARAM_MEMBER_ID, lMemberId);
        param.put(DaoConstant.PARAM_CREDITOR_TRANS_APPLY_ID, lCreditorTransAppId);
        param.put(DaoConstant.PARAM_AUTO_TENDER, sIsAuto);
        param.put(DaoConstant.PARAM_TOTAL_AMOUNT, lAmount);
        param.put(DaoConstant.PARAM_RED_PACKETS_INFO, sRedPacketsInfo);
        param.put(DaoConstant.PARAM_VOUCHERS, lVouchers);
        param.put(DaoConstant.PARAM_ENCRYPT_KEY, sKey);
        param.put(DaoConstant.PARAM_RED_PACKETS, 0);
        param.put("vResult", "");
        param.put(DaoConstant.PARAM_RESULT, 0);
        
        getSqlSession().selectOne(DaoConstant.CREDITOR_TRANS_DAO_CHECK_CREDITOR_RECORD_BY_MEMBER, param);
        String sResult = "验证失败";
        if(param.get("result")!=null){
        	if(IntegerAndString.StringToInt(param.get("result").toString(), 0)!=1){
        		sResult =  param.get("vResult").toString();
        	}else{
        		sResult = "success";
        	}
        	
        }
        return sResult;
//        return IntegerAndString.StringToInt(param.get(DaoConstant.PARAM_RESULT).toString(), 0);
    }

    /**
     * 获取债权转让详情
     * GetCreditorTransInfo 获取投资详情
     * TODO(描述)
     *
     * @param sIsAuto     自动投标	0：否 1：是
     * @param lMemberId   会员ID
     * @param lProjectId  项目ID
     * @param lAmount     投资总金额(本金)
     * @param lRedPackets 使用红包金额
     * @param lVouchers   使用代金券
     * @param sClient     使用客户端：0：pc 1：app 2：微信端
     * @return TransferSubmitEntity 返回类型 	返回调用投资接口对象
     * @throws null
     */
    @Override
    public TransferSubmitEntity getCreditorTransInfo(short sIsAuto, long lMemberId, long lCreditorTransAppId,
                                                     long lAmount, long lRedPackets, long lVouchers, short sClient) {
        TransferSubmitEntity entity = new TransferSubmitEntity();
        entity.setTransferAction(TransferSubmitEntity.TRANSFER_ACTION_TYPE_TENDER);
        if (sIsAuto == 0) {
            entity.setAction(TransferSubmitEntity.ACTION_TYPE_MANUAL);
        } else {
            entity.setAction(TransferSubmitEntity.ACTION_TYPE_AUTO);
        }
        
        //债权转让人第三方账户,转让总金额,债权转让编号
        InvestAccountFeeEntity feeEntity = GetCreditorTransAccount(lCreditorTransAppId);
        // 最大投资金额
        long lFullAmount = feeEntity.getlAmountTotal()*feeEntity.getiRewardRate()/1000000;
        
        // 实际使用金额
        long lRateAmount = lAmount * feeEntity.getiRewardRate()/1000000;
        
        //计算实际投资金额
        long lRealAmount = lRateAmount - lRedPackets - lVouchers;

        InterfaceUtil interfaceUtil = InterfaceUtil.GetInterfaceUtilInstance();
        //获取投资人帐户信息
        String sInvestMark = getInvestMemberMark(lMemberId);
        //获取平台账户信息
        String platformMark = interfaceUtil.GetOwnAccountMark();
        entity.setPlatformMoneyMoreMore(platformMark);
        //配置转帐URL
        entity.setSubmitURL(interfaceUtil.GetInterfaceUrl(InterfaceConstant.IZHAIQUANTOUBIAO));

//        InvestAccountFeeEntity feeEntity = getGuaranteeInfo(lProjectId);
        
        //债权转让管理费比例
        long lMngFeeRate = GetTransMngFeeRate();

        long lTotalManageFee = 0;				// 管理费总额
        long lInvestManageFee = 0;				// 自有金额管理费金额
        long lRedPacketsManageFee = 0;			// 使用红包管理费金额
        long lVouchersManageFee = 0;			// 使用代金券管理费金额
        if (lMngFeeRate > 0) {
            lTotalManageFee = lAmount * lMngFeeRate / feeEntity.getlAmountTotal();
            if (lRedPackets > 0) {
                lRedPacketsManageFee = lRedPackets * lTotalManageFee / lRateAmount;
            }
            if (lVouchers > 0) {
                lVouchersManageFee = lVouchers * lTotalManageFee / lRateAmount;
            }
            lInvestManageFee = lTotalManageFee - lRedPacketsManageFee - lVouchersManageFee;
        }

        List<LoanInfoBeanSubmit> loanInfoBeanSubmits = new ArrayList<LoanInfoBeanSubmit>();
        LoanInfoBeanSubmit beanEntity = new LoanInfoBeanSubmit();

        String sOrderNo = "";
        int orderNoIndex = 1;

        long lRedPacketsAndVouchersCost = lRedPackets + lVouchers - lRedPacketsManageFee - lVouchersManageFee;
        if (lRedPacketsAndVouchersCost > 0) {
            beanEntity.setLoanOutMoneymoremore(platformMark);
            beanEntity.setLoanInMoneymoremore(feeEntity.getsMemberMark());
            beanEntity.setOrderNo(sOrderNo + orderNoIndex);
            orderNoIndex++;
            beanEntity.setBatchNo(feeEntity.getsProjectNo());
            beanEntity.setAmount(IntegerAndString.LongToString2(lRedPacketsAndVouchersCost));
            beanEntity.setFullAmount(IntegerAndString.LongToString2(lFullAmount));
            beanEntity.setTransferName("平台支付给转让人");
            beanEntity.setRemark("ACTCT平台支付给借款人，金额:" + IntegerAndString.LongToString2(lRedPacketsAndVouchersCost));
            List<LoanInfoSecondaryBean> secondList = new ArrayList<LoanInfoSecondaryBean>();

            //红包和代金卷所占管理费
            /*long redPacketsAndVouchersManageFee = lRedPacketsManageFee + lVouchersManageFee;
            if (redPacketsAndVouchersManageFee > 0) {
                LoanInfoSecondaryBean secondaryEntity = new LoanInfoSecondaryBean();
                secondaryEntity.setAmount(IntegerAndString.LongToString2(redPacketsAndVouchersManageFee));
                secondaryEntity.setLoanInMoneymoremore(platformMark);
                secondaryEntity.setRemark("平台支付管理费");
                secondList.add(secondaryEntity);
            }*/

            beanEntity.setLoanInfoSecondaryBeanList(secondList);
            loanInfoBeanSubmits.add(beanEntity);
        }


        if (lRealAmount > 0) {
            beanEntity.setLoanOutMoneymoremore(sInvestMark);
            beanEntity.setLoanInMoneymoremore(feeEntity.getsMemberMark());
            beanEntity.setOrderNo(sOrderNo + orderNoIndex + "");
            orderNoIndex++;
            beanEntity.setBatchNo(feeEntity.getsProjectNo());
            beanEntity.setAmount(IntegerAndString.LongToString2(lRealAmount));
            beanEntity.setFullAmount(IntegerAndString.LongToString2(lFullAmount));
            beanEntity.setTransferName("投资人支付给转让人");
            beanEntity.setRemark("BCTCT投资人支付给借款人，金额:" + IntegerAndString.LongToString2(lRealAmount));

            List<LoanInfoSecondaryBean> secondList = new ArrayList<LoanInfoSecondaryBean>();

            // 投资人给平台：实际M(管理费)
            if (lInvestManageFee > 100) {
                LoanInfoSecondaryBean secondaryEntity = new LoanInfoSecondaryBean();
                secondaryEntity.setAmount(IntegerAndString.LongToString2(lInvestManageFee));
                secondaryEntity.setLoanInMoneymoremore(platformMark);
                secondaryEntity.setRemark("投资人支付管理费");
                secondList.add(secondaryEntity);
            }

            beanEntity.setLoanInfoSecondaryBeanList(secondList);
            loanInfoBeanSubmits.add(beanEntity);
        }

        entity.setLoanInfoBeanSubmits(loanInfoBeanSubmits);

        //使用红包，使用代金券
        String remark = String.format(REMARK_FORMAT, lMemberId, lCreditorTransAppId,
                lRealAmount, lRedPackets, lVouchers, sIsAuto, sClient,lAmount);

        entity.setRemark1(remark);
        //支付管理费
        remark = String.format(REMARK2_FORMAT, lInvestManageFee, lRedPacketsManageFee, lVouchersManageFee);
        entity.setRemark2(remark);

        return entity;
    }
    
    /**
     * 获取债权转让人 第三方账户
    * GetCreditorTransAccount 获取债权转让人 第三方账户
    * TODO(描述)
    * @author 张友  
    * * @Title: GetCreditorTransAccount 
    * @Description: TODO 
    * @param  lTransId		债权转让申请id
    * @param @return 设定文件 	债权转让人 第三方账户
    * @return String 返回类型 
    * @date 2016-5-2 下午3:14:32
    * @throws null
     */
    private InvestAccountFeeEntity GetCreditorTransAccount(long lTransId){
    	InvestAccountFeeEntity sResult = null;
    	
    	Map<String, Object> param = new HashMap<String, Object>();
        param.put("transId", lTransId);
        param.put("sKey", DbKeyUtil.GetDbCodeKey());
        sResult = getSqlSession().selectOne("CreditorTrans.GetCreditorTransAccount", param);
    	param = null;
        
    	return sResult;
    }
    
    /**
     * 获取债权转让 管理费
    * GetTransMngFeeRate 获取债权转让 管理费
    * TODO(描述)
    * @author 张友  
    * * @Title: GetTransMngFeeRate 
    * @Description: TODO 
    * @param @return 设定文件 
    * @return long 返回类型 
    * @date 2016-5-2 下午3:18:37
    * @throws null
     */
    private long GetTransMngFeeRate(){
    	long lResult = 0;
    	
    	Map<String, Object> param = new HashMap<String, Object>();
        
        lResult = getSqlSession().selectOne("CreditorTrans.GetTransMngFeeRate", param);
    	param = null;
    	
    	return lResult;
    }

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    	super.setSqlSessionFactory(sqlSessionFactory);
    }
}
