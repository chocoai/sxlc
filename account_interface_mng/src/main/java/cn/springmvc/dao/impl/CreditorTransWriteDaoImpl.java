package cn.springmvc.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import cn.springmvc.dao.CreditorTransWriteDao;
import cn.sxlc.account.manager.model.LoanReturnInfoBean;
import cn.sxlc.account.manager.model.LoanTransferReturnEntity;

@Repository("creditorTransWriteDaoImpl")
public class CreditorTransWriteDaoImpl extends SqlSessionDaoSupport implements CreditorTransWriteDao {

    @Override
    public int processCreditorTransResult(LoanTransferReturnEntity returnEntity) {
        int iResult = 0;
        if (returnEntity == null || returnEntity.getLoaninfolist() == null || returnEntity.getLoaninfolist().size() <= 0) {
            return iResult;
        }
        LoanReturnInfoBean infoBean = returnEntity.getLoaninfolist().get(0);
        String sRemark = infoBean.getRemark();
        String sRemark1 = returnEntity.getRemark1();
        String sRemark2 = returnEntity.getRemark2();
        if (StringUtils.isEmpty(sRemark) || StringUtils.isEmpty(sRemark1) || StringUtils.isEmpty(sRemark2)) {
            return iResult;
        }

        String[] sR = StringUtils.split(sRemark, "CTCT");
        String[] sR1 = StringUtils.split(sRemark1, "A");
        String[] sR2 = StringUtils.split(sRemark2, "A");

        if (ArrayUtils.isEmpty(sR) || sR.length < 2) {
            return iResult;
        }
        if (ArrayUtils.isEmpty(sR1) || sR1.length < 7) {
            return iResult;
        }
        if (ArrayUtils.isEmpty(sR2) || sR2.length < 3) {
            return iResult;
        }

        short iType = 0;
        if (sR[0] != null && sR[0].equals("A")) {
            iType = 1;
        }

        long lId = IdGeneratorUtil.GetIdGeneratorInstance().GetId();
        String sKey = DbKeyUtil.GetDbCodeKey();
        Map<String, Object> param = new HashMap<String, Object>();
        //投资状态 0成功 1失败
        param.put(DaoConstant.PARAM_STATUS, returnEntity.getStatu());
        //投资类型 （0：会员账户投资 1：红包账户投资)
        param.put(DaoConstant.PARAM_INVEST_TYPE, iType);
        //平台订单号
        param.put(DaoConstant.PARAM_ORDER_NO, infoBean.getOrderNo());
        //第三方交易订单号
        param.put(DaoConstant.PARAM_BILL_NO, infoBean.getLoanNo());
        //投资记录id

        param.put(DaoConstant.PARAM_INVEST_ID, lId);


        param.put(DaoConstant.PARAM_MEMBER_ID, IntegerAndString.StringToLong(sR1[0], 0));        //投资会员id
        param.put(DaoConstant.PARAM_CREDITOR_TRANS_APPLY_ID, IntegerAndString.StringToLong(sR1[1], 0));        //债权转让申请ID
        param.put(DaoConstant.PARAM_MONEY, IntegerAndString.StringToLong(sR1[2], 0));                //实际投资金额 投资总金额-使用红包-使用代金券
        param.put(DaoConstant.PARAM_AUTO_TENDER, IntegerAndString.StringToLong(sR1[5], 0));            // 是否为自动投标
        param.put(DaoConstant.PARAM_CLIENT, IntegerAndString.StringToLong(sR1[6], 0));            // 投资客户端
        param.put(DaoConstant.PARAM_ENCRYPT_KEY, sKey);            // 加密解密key
        param.put(DaoConstant.PARAM_RED_PACKETS, IntegerAndString.StringToLong(sR1[3], 0));            // 使用红包
        param.put(DaoConstant.PARAM_VOUCHERS, IntegerAndString.StringToLong(sR1[4], 0));            // 使用代金券
        param.put(DaoConstant.PARAM_MANAGE_FEE, IntegerAndString.StringToLong(sR2[0], 0));            // 本次分润管理费

        getSqlSession().selectOne(DaoConstant.CREDITOR_TRANS_DAO_PROCESS_CREDITOR_TRANS_RESULT, param);
        iResult = IntegerAndString.StringToInt(param.get(DaoConstant.PARAM_RESULT).toString(), 0);

        return iResult;
    }
    
    
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    	super.setSqlSessionFactory(sqlSessionFactory);
    }
}

