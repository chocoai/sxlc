package cn.invitemastermng.model; 

import java.util.Date;

/***
* 中奖纪录列表  
* 
* @author 李杰
* @since 
* @date 2016-4-19 下午7:32:34 
*
*/
public class LotteryRecords {

	private long 				memberId				;//会员编号
	private String				memberName				;//会员登录名
	private long				lotteryId				;//抽奖活动编号
	private long				prizeId					;//奖品编号
	private String				prizeName				;//奖品名称
	private Date				lotteryTime				;//中奖时间
	private int					statues					;//状态(1已发放、0未发放)
	
	
	public LotteryRecords() {}


	public LotteryRecords(long memberId, String memberName, long lotteryId,
			long prizeId, String prizeName, Date lotteryTime, int statues) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.lotteryId = lotteryId;
		this.prizeId = prizeId;
		this.prizeName = prizeName;
		this.lotteryTime = lotteryTime;
		this.statues = statues;
	}


	public long getMemberId() {
		return memberId;
	}


	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public long getLotteryId() {
		return lotteryId;
	}


	public void setLotteryId(long lotteryId) {
		this.lotteryId = lotteryId;
	}


	public long getPrizeId() {
		return prizeId;
	}


	public void setPrizeId(long prizeId) {
		this.prizeId = prizeId;
	}


	public String getPrizeName() {
		return prizeName;
	}


	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}


	public Date getLotteryTime() {
		return lotteryTime;
	}


	public void setLotteryTime(Date lotteryTime) {
		this.lotteryTime = lotteryTime;
	}


	public int getStatues() {
		return statues;
	}


	public void setStatues(int statues) {
		this.statues = statues;
	}
	
	
	
	
	
}

