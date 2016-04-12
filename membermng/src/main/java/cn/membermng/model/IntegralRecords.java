package cn.membermng.model;



/***
* 积分记录实体
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-3-30 上午10:12:48 
*
 */
public class IntegralRecords {
	
	private long 	integralId;								//序号
	private long 	memberId;								//会员编号
	private int  	integralDirection;						//积分变动方向
	private long 	quantity;								//积分变动数量
	private long	integralResidue;						//剩余可用积分
	private String  recordTime;								//记录时间
	private int		integralType;							//积分类型
	private int 	integralEventId;						//积分事件编号
	
	
	public IntegralRecords() {}


	public IntegralRecords(long integralId, long memberId,
			int integralDirection, long quantity, long integralResidue,
			String recordTime, int integralType, int integralEventId) {
		super();
		this.integralId = integralId;
		this.memberId = memberId;
		this.integralDirection = integralDirection;
		this.quantity = quantity;
		this.integralResidue = integralResidue;
		this.recordTime = recordTime;
		this.integralType = integralType;
		this.integralEventId = integralEventId;
	}


	public long getIntegralId() {
		return integralId;
	}


	public void setIntegralId(long integralId) {
		this.integralId = integralId;
	}


	public long getMemberId() {
		return memberId;
	}


	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}


	public int getIntegralDirection() {
		return integralDirection;
	}


	public void setIntegralDirection(int integralDirection) {
		this.integralDirection = integralDirection;
	}


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	public long getIntegralResidue() {
		return integralResidue;
	}


	public void setIntegralResidue(long integralResidue) {
		this.integralResidue = integralResidue;
	}


	public String getRecordTime() {
		return recordTime;
	}


	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}


	public int getIntegralType() {
		return integralType;
	}


	public void setIntegralType(int integralType) {
		this.integralType = integralType;
	}


	public int getIntegralEventId() {
		return integralEventId;
	}


	public void setIntegralEventId(int integralEventId) {
		this.integralEventId = integralEventId;
	}
	
	
	
	
	
	
}

