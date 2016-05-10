
/**
 * @author pengran
 *  拉黑取消列表
 * @date:2016-5-5 下午8:40:11
 **/

package cn.membermng.model; 

import java.util.Date;

import product_p2p.kit.datatrans.TimestampAndString;


public class BlackRecordEntity {
	
	

	private 	long 	memberId;		//会员id
	private     Date    recordDate;		//拉黑时间
	private     String  sRecordDate;	//拉黑时间
	private     String  adminName;		//拉黑管理员
	private     Date    removeDate;		//取消时间	
	private     String  sRemoveDate;	//取消时间
	private     String  removeAdmin;	//移除操作管理员
	private     String  remark;			//取消原因
	
	
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
		this.sRecordDate = TimestampAndString.DateToString(recordDate);
	}
	public String getsRecordDate() {
		return sRecordDate;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Date getRemoveDate() {
		return removeDate;
	}
	public void setRemoveDate(Date removeDate) {
		this.sRemoveDate =  TimestampAndString.DateToString(removeDate);
	}
	public String getsRemoveDate() {
		return sRemoveDate;
	}
	public String getRemoveAdmin() {
		return removeAdmin;
	}
	public void setRemoveAdmin(String removeAdmin) {
		this.removeAdmin = removeAdmin;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

