package cn.membermng.model;

import product_p2p.kit.datatrans.IntegerAndString;



/***
* 红包实体
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-30 下午1:44:24 
*
 */
public class RadPackage {

	private Long		memberRpId;					//会员红包序号
	private Long		memberId;					//会员编号
	private	String		receiveDate;				//领取时间
	private String		endDate;					//过期时间
	private String		useDate;					//红包使用时间
	private Integer		giftType;					//红包类型
	private String		gifTypeName;				//
	private Long		giftAmount;					//红包金额
	private String		sgiftAmount;				
	private Long		projectId;					//赠送事件编号
	private Integer		statu;						//状态
	private String		statuName;					//状态名称
	private String		remark;						//红包描述
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate.substring(0, 19);
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
		this.receiveDate = receiveDate.substring(0, 19);
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate.substring(0, 19);
	}
	public Integer getGiftType() {
		return giftType;
	}
	public void setGiftType(Integer giftType) {
		this.giftType = giftType;
	}
	public Long getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(Long giftAmount) {
		this.giftAmount = giftAmount;
		this.sgiftAmount = IntegerAndString.LongToString(giftAmount);
	}
	public String getSgiftAmount() {
		return sgiftAmount;
	}
	public void setSgiftAmount(String sgiftAmount) {
		this.sgiftAmount = sgiftAmount;
		this.giftAmount = IntegerAndString.StringToLong(sgiftAmount);
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Integer getStatu() {
		return statu;
	}
	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	public String getGifTypeName() {
		return gifTypeName;
	}
	public void setGifTypeName(String gifTypeName) {
		this.gifTypeName = gifTypeName;
	}
	public String getStatuName() {
		return statuName;
	}
	public void setStatuName(String statuName) {
		this.statuName = statuName;
	}
	
	
}

