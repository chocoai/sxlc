package cn.membermng.model; 



/***
* 
* @author 李杰
* @since 
* @date 2016-4-26 下午5:22:03 
*
*/
public class SecurityInfo {
	
	private String						realName;						//真实姓名|营业执照认证
	private int 						realNameStatus;					//实名状态
	private String 						thirdPartyAccount;				//第三方账户
	private int							thirdStatus;					//第三方开通状态
	private String						personalPhone;					//手机绑定
	private int							phoneStatus;					//手机绑定状态
	private String						personalEmail;					//邮箱绑定
	private int							emailStatus;					//邮箱绑定状态
	private int							openSecondDistribute;			//二次分配授权状态
	
	public SecurityInfo() {}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setRealNameStatus(int realNameStatus) {
		this.realNameStatus = realNameStatus;
	}
	
	public int getRealNameStatus() {
		return realNameStatus;
	}
	
	
	public String getThirdPartyAccount() {
		return thirdPartyAccount;
	}

	public void setThirdPartyAccount(String thirdPartyAccount) {
		this.thirdPartyAccount = thirdPartyAccount;
	}

	public int getThirdStatus() {
		if(this.thirdPartyAccount == null){
			thirdStatus =  0;			//未开通
		}else{
			thirdStatus =  2;			//已开通
		}
		return thirdStatus;
	}

	public void setThirdStatus(int thirdStatus) {
		this.thirdStatus = thirdStatus;
	}

	public String getPersonalPhone() {
		return personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}

	public int getPhoneStatus() {
		if(this.personalPhone == null){
			phoneStatus = 0;			//未绑定
		}else{
			phoneStatus = 2;			//已绑定
		}
		return phoneStatus;
	}

	public void setPhoneStatus(int phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public int getEmailStatus() {
		if(this.personalEmail == null){
			emailStatus = 0;		//未绑定
		}else{		
			emailStatus = 2;		//已绑定
		}
		return emailStatus;
	}

	public void setEmailStatus(int emailStatus) {
		this.emailStatus = emailStatus;
	}

	public int getOpenSecondDistribute() {
		return openSecondDistribute;
	}

	public void setOpenSecondDistribute(int openSecondDistribute) {
		this.openSecondDistribute = openSecondDistribute;
	}
	
	
}

