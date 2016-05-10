
package cn.springmvc.model; 


/** 
 * 会员银行卡
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-4-25 下午5:29:55  */
public class GuaranteeBankCard {
	private long bankCardId;//银行卡信息id
	private int carType=1;//银行卡类型（借记卡）
	private String bankName;//，开户银行
	private String bankCity;//，开户行城市，
	private String bankBranch;//开户行支行
	private String bankNo;//，银行卡卡号
	public long getBankCardId() {
		return bankCardId;
	}
	public void setBankCardId(long bankCardId) {
		this.bankCardId = bankCardId;
	}
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	
}

