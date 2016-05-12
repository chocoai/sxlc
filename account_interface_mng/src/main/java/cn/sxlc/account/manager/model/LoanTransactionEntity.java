package cn.sxlc.account.manager.model;

/**
 * 借款投资相关交易流水号
 *
 * @author 朱祖轶
 * @Description: TODO
 * @date 2016-3-30 上午9:35:48
 */
public class LoanTransactionEntity {
    private long inversId;//投资记录id
    private String billNo;//第三方投资流水号
    private String giftBillNo;//使用赠送金额流水号
    private long memberId;//会员id
    private long amount;//投资金额
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getGiftBillNo() {
        return giftBillNo;
    }

    public void setGiftBillNo(String giftBillNo) {
        this.giftBillNo = giftBillNo;
    }

    public long getInversId() {
        return inversId;
    }

    public void setInversId(long inversId) {
        this.inversId = inversId;
    }

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}

