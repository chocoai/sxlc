package cn.springmvc.model;


/***
 * 第三方账户表
 * @author LiJie
 *
 */
public class MemberThirdInfo {

	private Long				certificationId;					//序号
	private Integer				memberType;			//会员类型
	private Long				memberId;			//会员编号
	private String				thirdPartyAccount;	//第三方账户编号
	private String				thirdPartyMark;		//用户第三方账户标识
	private Long				userBalance;		//账户余额
	private Long				frozen;				//账户冻结金额
	private Long				giftUserBalance;	//账户红包可用余额
	private Long				giftFrozen;			//账户红包冻结金额
	
	public MemberThirdInfo() {	}
	
	public MemberThirdInfo(Long certificationId, Integer memberType,
			Long memberId, String thirdPartyAccount, String thirdPartyMark,
			Long userBalance, Long frozen, Long giftUserBalance, Long giftFrozen) {
		super();
		this.certificationId = certificationId;
		this.memberType = memberType;
		this.memberId = memberId;
		this.thirdPartyAccount = thirdPartyAccount;
		this.thirdPartyMark = thirdPartyMark;
		this.userBalance = userBalance;
		this.frozen = frozen;
		this.giftUserBalance = giftUserBalance;
		this.giftFrozen = giftFrozen;
	}



	public Long getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(Long certificationId) {
		this.certificationId = certificationId;
	}

	public Integer getMemberType() {
		return memberType;
	}
	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getThirdPartyAccount() {
		return thirdPartyAccount;
	}
	public void setThirdPartyAccount(String thirdPartyAccount) {
		this.thirdPartyAccount = thirdPartyAccount;
	}
	public String getThirdPartyMark() {
		return thirdPartyMark;
	}
	public void setThirdPartyMark(String thirdPartyMark) {
		this.thirdPartyMark = thirdPartyMark;
	}
	public Long getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(Long userBalance) {
		this.userBalance = userBalance;
	}
	public Long getFrozen() {
		return frozen;
	}
	public void setFrozen(Long frozen) {
		this.frozen = frozen;
	}
	public Long getGiftUserBalance() {
		return giftUserBalance;
	}
	public void setGiftUserBalance(Long giftUserBalance) {
		this.giftUserBalance = giftUserBalance;
	}
	public Long getGiftFrozen() {
		return giftFrozen;
	}
	public void setGiftFrozen(Long giftFrozen) {
		this.giftFrozen = giftFrozen;
	}
	
	
	
}
