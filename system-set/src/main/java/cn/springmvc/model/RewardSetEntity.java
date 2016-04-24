
package cn.springmvc.model; 

/** 
* 推荐提奖设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 上午9:56:14  */
public class RewardSetEntity {
	private int type;//
	private long id;//	
	private String gradeName;//		等级名称	
	private long totalInvest;//		投资总金额
	private String gradeRemark;//	等级描述
	private int vIPReward;//		VIP提成设置 推荐一个VIP提成金额 单位：元  保留4位小数
	private int borrowReward;//		借款提奖点数 保留4位小数
	private int repayReward;//		借款还本金提奖点数 保留4位小数
	private int investReward;//		投资收益提奖点数 单位 百万分之
	private int statu;//			状态 0：无效 1：有效
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public long getTotalInvest() {
		return totalInvest;
	}
	public void setTotalInvest(long totalInvest) {
		this.totalInvest = totalInvest;
	}
	public String getGradeRemark() {
		return gradeRemark;
	}
	public void setGradeRemark(String gradeRemark) {
		this.gradeRemark = gradeRemark;
	}
	public int getvIPReward() {
		return vIPReward;
	}
	public void setvIPReward(int vIPReward) {
		this.vIPReward = vIPReward;
	}
	public int getBorrowReward() {
		return borrowReward;
	}
	public void setBorrowReward(int borrowReward) {
		this.borrowReward = borrowReward;
	}
	public int getRepayReward() {
		return repayReward;
	}
	public void setRepayReward(int repayReward) {
		this.repayReward = repayReward;
	}
	public int getInvestReward() {
		return investReward;
	}
	public void setInvestReward(int investReward) {
		this.investReward = investReward;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	@Override
	public String toString() {
		return "RewardSetEntity [type=" + type + ", id=" + id + ", gradeName(等级名称)="
				+ gradeName + ", totalInvest(投资总金额)=" + totalInvest + ", gradeRemark(等级描述)="
				+ gradeRemark + ", vIPReward(VIP提成设置)=" + vIPReward + ", borrowReward(借款提奖点数 保留4位小数)="
				+ borrowReward + ", repayReward(借款还本金提奖点数)=" + repayReward
				+ ", investReward(投资收益提奖点数 )=" + investReward + ", statu(状态 0：无效 1：有效)=" + statu + "]";
	}

}

