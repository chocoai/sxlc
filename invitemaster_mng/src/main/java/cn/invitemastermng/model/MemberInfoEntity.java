

/** 
* @Title: MemberInfoEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-16 下午1:51:56 
* @version V5.0 */
 
package cn.invitemastermng.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 会员基本信息
 * @since 
 * @date 2016-4-16 下午1:51:56  */

public class MemberInfoEntity {
	private long   memberID;//ID;//会员ID
	private String memberNo;//No;//会员编号
	private String logname;//会员用户名
	private int    memberType;//Type;//会员类型
	private String personalName;//Name;//姓名
	private String regDate;//Date;//注册时间 
	private String personalPhone;//Phone;//手机号
	private int    totalInvite;//Invite;//累计邀请人数
	private int    checkStatu;//Statu;//状态
	private String houseAddress;//所在地 
	private int    iSThird;//是否开通第三方:1是0否 
	private long   investAmount;//累计成功投资
	private long   repayAmount;//累计成功借款
	private String investAmounts;//累计成功投资
	private String repayAmounts;//累计成功借款
	private String imNo;//推荐达人编号
	private String inviteLogname;//推荐达人
	private long   imApplyID;//推荐达人申请ID
	
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	 
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
 
	public int getCheckStatu() {
		return checkStatu;
	}
	public void setCheckStatu(int checkStatu) {
		this.checkStatu = checkStatu;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public int getiSThird() {
		return iSThird;
	}
	public void setiSThird(int iSThird) {
		this.iSThird = iSThird;
	}
	public long getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(long investAmount) {
		this.investAmount = investAmount;
		this.investAmounts = IntegerAndString.LongToString(investAmount);
	}
	public long getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(long repayAmount) {
		this.repayAmount = repayAmount;
		this.repayAmounts = IntegerAndString.LongToString(repayAmount);
	}
	public String getInvestAmounts() {
		return investAmounts;
	}
	public void setInvestAmounts(String investAmounts) {
		this.investAmounts = investAmounts;
	}
	public String getRepayAmounts() {
		return repayAmounts;
	}
	public void setRepayAmounts(String repayAmounts) {
		this.repayAmounts = repayAmounts;
	}
	public String getImNo() {
		return imNo;
	}
	public void setImNo(String imNo) {
		this.imNo = imNo;
	}
	public String getInviteLogname() {
		return inviteLogname;
	}
	public void setInviteLogname(String inviteLogname) {
		this.inviteLogname = inviteLogname;
	}
	public int getTotalInvite() {
		return totalInvite;
	}
	public void setTotalInvite(int totalInvite) {
		this.totalInvite = totalInvite;
	}
	public long getImApplyID() {
		return imApplyID;
	}
	public void setImApplyID(long imApplyID) {
		this.imApplyID = imApplyID;
	}
}

