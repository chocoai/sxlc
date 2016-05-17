package cn.sxlc.account.manager.model;

import java.sql.Timestamp;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.datatrans.TimestampAndString;

/**
 * 未使用红包实体
 *
 * @author 张友
 * @Description: TODO
 * @date 2016-3-29 下午1:33:01
 */
public class UnUsedRedpacketsEntity {
    private long lId;                //红包ID
    private long lAmount;            //总额
    private long lUsedAmount;        //已用金额
    private long lFrozenAmount;            //冻结金额
    private long lUnUsedAmount;            //剩余可用金额
    private String sUnUsedAmount;        //剩余可用金额
    private Timestamp ttEndDate;        //有效期
    private String sEndDate;            //有效期

    public long getlId() {
        return lId;
    }

    public void setlId(long lId) {
        this.lId = lId;
    }

    public long getlAmount() {
        return lAmount;
    }

    public void setlAmount(long lAmount) {
        this.lAmount = lAmount;
        this.lUnUsedAmount = lAmount - this.lUsedAmount - this.lFrozenAmount;
        this.sUnUsedAmount = IntegerAndString.LongToString(this.lUnUsedAmount);
    }

    public long getlFrozenAmount() {
        return lFrozenAmount;
    }

    public void setlFrozenAmount(long lFrozenAmount) {
        this.lFrozenAmount = lFrozenAmount;
    }

    public long getlUsedAmount() {
        return lUsedAmount;
    }

    public void setlUsedAmount(long lUsedAmount) {
        this.lUsedAmount = lUsedAmount;
        this.lUnUsedAmount = lAmount - this.lUsedAmount - this.lFrozenAmount;
        this.sUnUsedAmount = IntegerAndString.LongToString(this.lUnUsedAmount);
    }

    public long getlUnUsedAmount() {
        return lUnUsedAmount;
    }

    public void setlUnUsedAmount(long lUnUsedAmount) {
        this.lUnUsedAmount = lUnUsedAmount;
    }

    public String getsUnUsedAmount() {
        return sUnUsedAmount;
    }

    public void setsUnUsedAmount(String sUnUsedAmount) {
        this.sUnUsedAmount = sUnUsedAmount;
    }

    public Timestamp getTtEndDate() {
        return ttEndDate;
    }

    public void setTtEndDate(Timestamp ttEndDate) {
        this.ttEndDate = ttEndDate;
        this.sEndDate = TimestampAndString.TimestampToString2(this.ttEndDate);
    }

    public String getsEndDate() {
        return sEndDate;
    }

    public void setsEndDate(String sEndDate) {
        this.sEndDate = sEndDate;
    }
}

