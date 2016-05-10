package cn.membermng.model; 


/***
* 兑换记录
* @author 李杰
* @since 
* @date 2016-5-6 下午5:30:54 
*
 */
public class ExchangeRecords {

	
	private long			eId	;			//兑换记录编号
	private long			points;			//消费积分
	private String			sPoints;		//消费积分
	private long			eType;			//兑换类型
	private String			eTypeName;		//兑换类型
	private String			goodName;		//商品名称
	private int				numbers;		//数量
	private String			eTime;			//兑换时间
	private String			confirm;		//确认时间
	private int				status;			//状态
	private String			statusName;		//状态名称
	
	
	
	public long geteId() {
		return eId;
	}
	public void seteId(long eId) {
		this.eId = eId;
	}
	public long getPoints() {
		return points;
	}
	public void setPoints(long points) {
		this.points = points;
	}
	public String getsPoints() {
		return sPoints;
	}
	public void setsPoints(String sPoints) {
		this.sPoints = sPoints;
	}
	public long geteType() {
		return eType;
	}
	public void seteType(long eType) {
		this.eType = eType;
	}
	public String geteTypeName() {
		return eTypeName;
	}
	public void seteTypeName(String eTypeName) {
		this.eTypeName = eTypeName;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}

