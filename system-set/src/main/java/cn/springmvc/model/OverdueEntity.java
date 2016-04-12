
package cn.springmvc.model; 

/** 
 * 逾期设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午11:19:30  */
public class OverdueEntity {
	private int id;	//
	private int overdueMin;	//逾期天数（最小）
	private int overdueMax;	//逾期天数（最大）0表示无上限
	private int price;	//逾期罚息日利率(百万分之)
	private int statu;	//状态 0：无效 1：有效
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOverdueMin() {
		return overdueMin;
	}
	public void setOverdueMin(int overdueMin) {
		this.overdueMin = overdueMin;
	}
	public int getOverdueMax() {
		return overdueMax;
	}
	public void setOverdueMax(int overdueMax) {
		this.overdueMax = overdueMax;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	

}

