

/** 
* @Title: InviteMasterApplyEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-5 上午10:52:22 
* @version V5.0 */
 
package cn.invitemastermng.model; 

/** 
 * @author 刘利 
 * @Description: 推荐达人申请实体
 * @since 
 * @date 2016-4-5 上午10:52:22  */

public class InviteMasterApplyEntity {
	private long imApplyID;//ID																					
	private long memberID;//会员ID	
	private String applyDate;//理财师申请时间	
	private int checkStatu	; //审核状态 0：审核中 1：通过 -1：打回	
	private String checkDate;	 //审核时间	
	public long getImApplyID() {
		return imApplyID;
	}
	public void setImApplyID(long imApplyID) {
		this.imApplyID = imApplyID;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public int getCheckStatu() {
		return checkStatu;
	}
	public void setCheckStatu(int checkStatu) {
		this.checkStatu = checkStatu;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

}

