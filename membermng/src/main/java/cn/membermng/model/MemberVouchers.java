package cn.membermng.model;

import product_p2p.kit.datatrans.IntegerAndString;



/***
* 我的代金券 
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-30 下午4:54:57 
*
*/
public class MemberVouchers {

	
	
	private Long			memberRpId;				//编号
	private Long			memberId;				//会员编号
	private String			receiveDate;			//领取时间
	private String			endDate;				//过期时间
	private String			giftType;				//获取方式
	private Long			giftAmount;				//代金券金额
	private String			sGiftAmount;			//
	private Long			projectId;				//获取事件编号
	
	private String			pStatus;				//投资项目状态
	private String			ctaStatus;				//债权转让投资状态
	private String 			statuName;				//状态名称
	private String			loanTypeName;			//投资名称  债权投资 | 实际投资
	
	
	
	
	
	
	private int				statu;					//状态DICT_TZSYZT   -1失败  0处理中  1成功
	
	private String 			useDate;				//使用时间
	
	private int				Invest_Type;			//使用类型  0	实际投资记录 1	临时投资记录  
	
	
	
	public MemberVouchers() {}




	public MemberVouchers(Long memberRpId, Long memberId, String receiveDate,
			String endDate, String giftType, Long giftAmount,
			String sGiftAmount, Long projectId) {
		super();
		this.memberRpId = memberRpId;
		this.memberId = memberId;
		this.receiveDate = receiveDate;
		this.endDate = endDate;
		this.giftType = giftType;
		this.giftAmount = giftAmount;
		this.sGiftAmount = sGiftAmount;
		this.projectId = projectId;
	}

	public String getLoanTypeName() {
		return loanTypeName;
	}




	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}




	public String getStatuName() {
		return statuName;
	}




	public void setStatuName(String statuName) {
		this.statuName = statuName;
	}




	public Long getMemberRpId() {
		return memberRpId;
	}

	public void setMemberRpId(Long memberRpId) {
		this.memberRpId = memberRpId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getGiftType() {
		return giftType;
	}

	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}

	public Long getGiftAmount() {
		return giftAmount;
	}

	public void setGiftAmount(Long giftAmount) {
		this.giftAmount = giftAmount;
	}

	public String getsGiftAmount() {
		return sGiftAmount;
	}

	public void setsGiftAmount(String sGiftAmount) {
		this.sGiftAmount = sGiftAmount;
		this.giftAmount	 = IntegerAndString.StringToLong(sGiftAmount);
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}




	public String getUseDate() {
		return useDate;
	}




	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}




	public int getInvest_Type() {
		return Invest_Type;
	}




	public void setInvest_Type(int invest_Type) {
		Invest_Type = invest_Type;
	}




	public String getpStatus() {
		return pStatus;
	}




	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}




	public String getCtaStatus() {
		return ctaStatus;
	}




	public void setCtaStatus(String ctaStatus) {
		this.ctaStatus = ctaStatus;
	}


		
	
}

