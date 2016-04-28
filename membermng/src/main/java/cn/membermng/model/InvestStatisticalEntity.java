

/** 
* @Title: InvestStatisticalEntity.java 
* @Package cn.membermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午9:16:05 
* @version V5.0 */
 
package cn.membermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 统计中心-投资统计实体
 * @since 
 * @date 2016-4-13 下午9:16:05  */

public class InvestStatisticalEntity {
	private long    applyId;	//投资记录ID			  
    private String  projectNo; 	//项目编号		    
    private String  projectName; 	//项目类型
    private String  projectTitle;//项目名称
    private String  logname; 	//	 会员用户名       
    private String  memberName; //	会员姓名	  
    private long    investAmountValid;// 投资金额
    private String  investAmountValids; //投资金额
    private long    realAmount;    //收益金额
    private String  realAmounts;  //  收益金额
    private int     investMng; //平台投资管理费
    private String  investMngs; //平台投资管理费
    private String  mngTime;    // 最后一次管理费到账时间
    private int     ifGift; 	// 是否使用红包:1是0否        
    private int     investGiftAmount;//使用投资红包金额
    private String  investGiftAmounts;//使用投资红包金额
    private int     investStatu; 	//	项目状态   
    private String  recvTime;//最后一次收益到账时间
	public long getApplyId() {
		return applyId;
	}
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public long getInvestAmountValid() {
		return investAmountValid;
	}
	public void setInvestAmountValid(long investAmountValid) {
		this.investAmountValid = investAmountValid;
		this.investAmountValids=IntegerAndString.LongToString(investAmountValid);
	}
	public String getInvestAmountValids() {
		return investAmountValids;
	}
	public void setInvestAmountValids(String investAmountValids) {
		this.investAmountValids = investAmountValids;
	}
	public long getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(long realAmount) {
		this.realAmount = realAmount;
		this.realAmounts=IntegerAndString.LongToString(realAmount);
	}
	public String getRealAmounts() {
		return realAmounts;
	}
	public void setRealAmounts(String realAmounts) {
		this.realAmounts = realAmounts;
	}
	public int getInvestMng() {
		return investMng;
	}
	public void setInvestMng(int investMng) {
		this.investMng = investMng;
		this.investMngs=IntegerAndString.IntToString(investMng);
	}
	public String getInvestMngs() {
		return investMngs;
	}
	public void setInvestMngs(String investMngs) {
		this.investMngs = investMngs;
	}
	public String getMngTime() {
		return mngTime;
	}
	public void setMngTime(String mngTime) {
		this.mngTime = mngTime;
	}
	public int getIfGift() {
		return ifGift;
	}
	public void setIfGift(int ifGift) {
		this.ifGift = ifGift;
	}
	public int getInvestGiftAmount() {
		return investGiftAmount;
	}
	public void setInvestGiftAmount(int investGiftAmount) {
		this.investGiftAmount = investGiftAmount;
		this.investGiftAmounts=IntegerAndString.IntToString(investGiftAmount);
	}
	public String getInvestGiftAmounts() {
		return investGiftAmounts;
	}
	public void setInvestGiftAmounts(String investGiftAmounts) {
		this.investGiftAmounts = investGiftAmounts;
	}
	public int getInvestStatu() {
		return investStatu;
	}
	public void setInvestStatu(int investStatu) {
		this.investStatu = investStatu;
	}
	public String getRecvTime() {
		return recvTime;
	}
	public void setRecvTime(String recvTime) {
		this.recvTime = recvTime;
	}
}

