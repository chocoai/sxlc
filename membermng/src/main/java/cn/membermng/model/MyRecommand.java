/**
 * @author pengran
 *  我的推荐人、邀请人和 会员列表
 * @date:2016-5-5 下午8:28:49
 **/
 
package cn.membermng.model; 


public class MyRecommand {
	
	
	private  long  memberId;		//会员id
	private  String memberNo;		//会员编号
	private  String  realName;		//会员姓名
	private  String  phone;			//会员电话

	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}

