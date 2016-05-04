

/** 
* @Title: InvitationRecordEntity.java 
* @Package cn.invitemastermng.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-28 下午8:29:19 
* @version V5.0 */
 
package cn.invitemastermng.model; 

/** 
 * @author 刘利 
 * @Description: 邀请明细
 * @since 
 * @date 2016-4-28 下午8:29:19  */

public class InvitationRecordEntity {
	
	 private String  logname;//会员用户名
	 private String  memberName;//会员名
	 private String  regDate;//注册时间
	 private String  isopenThird;//是否开通第三方 0 未开通，大于0 开通
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getIsopenThird() {
		return isopenThird;
	}
	public void setIsopenThird(String isopenThird) {
		this.isopenThird = isopenThird;
	}

}

