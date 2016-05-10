package cn.membermng.model; 

/***
* 企业法人实名认证实体
* 
* @author 李杰
* @since 
* @date 2016-5-4 下午3:35:50 
*
 */
public class LegalPersonReanName {

	
	private long 				rid;			//认证记录编号
	private String				peronalName;	//法人真实姓名
	private String				idCard;			//法人身份证
	private String				phone;			//法人手机号
	private String				enclosure;		//附件,用逗号隔开
	private String				enclosureName;	//附件名称
	private String				endTime;		//有效期
	
	
	
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getPeronalName() {
		return peronalName;
	}
	public void setPeronalName(String peronalName) {
		this.peronalName = peronalName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEnclosure() {
		return enclosure;
	}
	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}
	public String getEnclosureName() {
		return enclosureName;
	}
	public void setEnclosureName(String enclosureName) {
		this.enclosureName = enclosureName;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}

