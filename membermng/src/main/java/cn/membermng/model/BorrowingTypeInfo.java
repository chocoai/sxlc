package cn.membermng.model; 


/***
* 借款认证信息
* 
* @author 李杰
* @since 
* @date 2016-5-3 上午11:01:16 
*
*/
public class BorrowingTypeInfo {

	
	private long 			attestId;				//类型编号
	private int				attestType;				//0个人会员认证 1企业会员认证
	private int 			status;					//状态
	private String			statusName;				//状态名称
	private String			endTime;				//认证有效期
	private String			attestTypeName;			//认证项目名称
	
	
	public long getAttestId() {
		return attestId;
	}
	public void setAttestId(long attestId) {
		this.attestId = attestId;
	}
	public int getAttestType() {
		return attestType;
	}
	public void setAttestType(int attestType) {
		this.attestType = attestType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAttestTypeName() {
		return attestTypeName;
	}
	public void setAttestTypeName(String attestTypeName) {
		this.attestTypeName = attestTypeName;
	}
	
	
	
}

