package cn.sxlc.account.manager.model;


/** 
 * 提现银行卡信息
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-3-31 上午11:46:22  */
public class WithdrawsEntity {
	private int iMemberType;		//会员类型		0：企业会员 1：个人会员 2：企业担保机构 3：个人担保
	private int iMemberId;			//会员id
	private String sMarkNo;			//钱多多标识号
	private String sMerBillNo;		//平台订单号
	private String sAmount;			//提现金额
	private String sPtRate;			//平台支付第三方手续费比例
	private String sUserFee;		//用户承担的最高手续费
	private String sFeeRate;		//上浮费率
	private String sCardNo;			//银行卡编号
	private int iCardType;			//银行卡类型
	private String sBankCode;		//银行卡代码
	private String sBankName;		//开户行支行名称
	private int iProvince;			//省份
	private String sProvince;		//开户省份
	private int iCity;				//开户城市
	private String sCity;			//开户城市
	private String sDate;			//时间戳
	public int getiProvince() {
		return iProvince;
	}
	public void setiProvince(int iProvince) {
		this.iProvince = iProvince;
	}
	public int getiCity() {
		return iCity;
	}
	public void setiCity(int iCity) {
		this.iCity = iCity;
	}
	public int getiMemberType() {
		return iMemberType;
	}
	public void setiMemberType(int iMemberType) {
		this.iMemberType = iMemberType;
	}
	public int getiMemberId() {
		return iMemberId;
	}
	public void setiMemberId(int iMemberId) {
		this.iMemberId = iMemberId;
	}
	public String getsMarkNo() {
		return sMarkNo;
	}
	public void setsMarkNo(String sMarkNo) {
		this.sMarkNo = sMarkNo;
	}
	public String getsMerBillNo() {
		return sMerBillNo;
	}
	public void setsMerBillNo(String sMerBillNo) {
		this.sMerBillNo = sMerBillNo;
	}
	public String getsAmount() {
		return sAmount;
	}
	public void setsAmount(String sAmount) {
		this.sAmount = sAmount;
	}
	public String getsPtRate() {
		return sPtRate;
	}
	public void setsPtRate(String sPtRate) {
		this.sPtRate = sPtRate;
	}
	public String getsUserFee() {
		return sUserFee;
	}
	public void setsUserFee(String sUserFee) {
		this.sUserFee = sUserFee;
	}
	public String getsFeeRate() {
		return sFeeRate;
	}
	public void setsFeeRate(String sFeeRate) {
		this.sFeeRate = sFeeRate;
	}
	public String getsCardNo() {
		return sCardNo;
	}
	public void setsCardNo(String sCardNo) {
		this.sCardNo = sCardNo;
	}
	public int getiCardType() {
		return iCardType;
	}
	public void setiCardType(int iCardType) {
		this.iCardType = iCardType;
	}
	public String getsBankCode() {
		return sBankCode;
	}
	public void setsBankCode(String sBankCode) {
		this.sBankCode = sBankCode;
	}
	public String getsBankName() {
		return sBankName;
	}
	public void setsBankName(String sBankName) {
		this.sBankName = sBankName;
	}
	public String getsProvince() {
		return sProvince;
	}
	public void setsProvince(String sProvince) {
		this.sProvince = sProvince;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
}
