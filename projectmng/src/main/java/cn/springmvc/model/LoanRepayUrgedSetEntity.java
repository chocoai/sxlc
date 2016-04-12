package cn.springmvc.model;
/**
 * 催收账单配置
 * @author 刘利
 *
 */
public class LoanRepayUrgedSetEntity {
	/**
	 *  到期前N天视为即将到期账单
	 */
    private int	billDays;	
    /**
     * 账单内容配置
     */
	private String billContent;
	public int getBillDays() {
		return billDays;
	}
	public void setBillDays(int billDays) {
		this.billDays = billDays;
	}
	public String getBillContent() {
		return billContent;
	}
	public void setBillContent(String billContent) {
		this.billContent = billContent;
	} 

}
