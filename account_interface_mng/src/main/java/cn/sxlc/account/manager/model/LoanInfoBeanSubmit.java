package cn.sxlc.account.manager.model;

import java.util.List;

/**
 * 转账列表信息
 *
 * @author 朱祖轶
 * @Description: TODO
 * @date 2016-3-29 下午3:19:50
 */
public class LoanInfoBeanSubmit {
    /**
     * 付款人乾多多标识
     */
    private String LoanOutMoneymoremore = "";

    /**
     * 收款人乾多多标识
     */
    private String LoanInMoneymoremore = "";

    /**
     * 订单号
     */
    private String OrderNo = "";

    /**
     * 平台标号
     */
    private String BatchNo = "";

    /**
     * 金额 （实际）
     */
    private String Amount = "";

    /**
     * 项目满标金额
     */
    private String FullAmount = "";

    /**
     * 用途 选填
     */
    private String TransferName = "";

    /**
     * 备注  选填
     */
    private String Remark = "";

    /**
     * 二次分配列表
     */
    private List<LoanInfoSecondaryBean> LoanInfoSecondaryBeanList;
    

    public List<LoanInfoSecondaryBean> getLoanInfoSecondaryBeanList() {
        return LoanInfoSecondaryBeanList;
    }

    public void setLoanInfoSecondaryBeanList(
            List<LoanInfoSecondaryBean> loanInfoSecondaryBeanList) {
        LoanInfoSecondaryBeanList = loanInfoSecondaryBeanList;
    }

    public String getLoanOutMoneymoremore() {
        return LoanOutMoneymoremore;
    }

    public void setLoanOutMoneymoremore(String loanOutMoneymoremore) {
        LoanOutMoneymoremore = loanOutMoneymoremore;
    }

    public String getLoanInMoneymoremore() {
        return LoanInMoneymoremore;
    }

    public void setLoanInMoneymoremore(String loanInMoneymoremore) {
        LoanInMoneymoremore = loanInMoneymoremore;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getTransferName() {
        return TransferName;
    }

    public void setTransferName(String transferName) {
        TransferName = transferName;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String batchNo) {
        BatchNo = batchNo;
    }

    public String getFullAmount() {
        return FullAmount;
    }

    public void setFullAmount(String fullAmount) {
        FullAmount = fullAmount;
    }


}
