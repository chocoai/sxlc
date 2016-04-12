package cn.springmvc.model;




/***
* 银行卡信息实体
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-18 下午7:29:24
*/
public class BankCardInfo {
	
	private Long 			bankCardId;			//银行卡信息序号
	private Integer			bankId;				//银行卡编号
	private Integer			cardProvince;		//银行卡省份编号
	private Integer			cardCity;			//银行卡城市编号
	private String			branch;				//开户行支行
	private String 			branchAddress;		//开户行支行
	private String			bankNo;				//银行卡号
	private String 			bankPhone;			//银行卡关联手机号
	
	public BankCardInfo() {

	}

	public BankCardInfo(Long bankCardId, Integer bankId, Integer cardProvince,
			Integer cardCity, String branch, String branchAddress,
			String bankNo, String bankPhone) {
		super();
		this.bankCardId = bankCardId;
		this.bankId = bankId;
		this.cardProvince = cardProvince;
		this.cardCity = cardCity;
		this.branch = branch;
		this.branchAddress = branchAddress;
		this.bankNo = bankNo;
		this.bankPhone = bankPhone;
	}

	public Long getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Long bankCardId) {
		this.bankCardId = bankCardId;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public Integer getCardProvince() {
		return cardProvince;
	}

	public void setCardProvince(Integer cardProvince) {
		this.cardProvince = cardProvince;
	}

	public Integer getCardCity() {
		return cardCity;
	}

	public void setCardCity(Integer cardCity) {
		this.cardCity = cardCity;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankPhone() {
		return bankPhone;
	}

	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}
	
	
	
	
	
	
	
	
}

