package cn.membermng.model; 

/***
* 后台查看会员银行卡信息
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-7 下午4:57:59 
*
*/
public class MemberBankICardInfos {

	
	private String					bankName			;//银行名
	private String					branch				;//支行名称
	private String					cityName			;//城市名称
	private String					bankNo				;//银行卡编号
	
	public MemberBankICardInfos() {}

	public MemberBankICardInfos(String bankName, String branch,
			String cityName, String bankNo) {
		super();
		this.bankName = bankName;
		this.branch = branch;
		this.cityName = cityName;
		this.bankNo = bankNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	
	
	
	
}



