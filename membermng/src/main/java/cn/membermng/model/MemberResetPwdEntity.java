
/**
 * @author pengran
 * 会员重置密码记录
 * @date:2016-5-5 下午3:43:09
 **/
 
package cn.membermng.model; 

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;


public class MemberResetPwdEntity {
	
	
	private 	long	 memberId;		//会员id
	private 	Date     recordDate;
	private     String   sRecordDate;	//操作时间
	private     long     adminId;		//操作管理员ID
	private     String   adminName;		////操作管理员
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
		this.sRecordDate = TimestampAndString.DateToString2(recordDate);
	}
	public String getsRecordDate() {
		return sRecordDate;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}

