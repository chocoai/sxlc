package cn.invitemastermng.model; 

/***
* 抽奖设置
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-13 上午11:11:33 
*
*/
public class LotteryManage {

	
	private long				lotteryId					;//抽奖活动编号
	private long				prizeId						;//奖品编号
	private int					grade						;//获奖等级
	private long				gradeOdds					;//等级基数
	private long				winningOdds					;//中奖概率基数
	private long				zjjs						;//中奖概率
	
	
	public LotteryManage() {}


	public LotteryManage(long lotteryId, long prizeId, int grade,
			long gradeOdds, long winningOdds) {
		super();
		this.lotteryId = lotteryId;
		this.prizeId = prizeId;
		this.grade = grade;
		this.gradeOdds = gradeOdds;
		this.winningOdds = winningOdds;
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


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public long getGradeOdds() {
		return gradeOdds;
	}


	public void setGradeOdds(long gradeOdds) {
		this.gradeOdds = gradeOdds;
	}


	public long getWinningOdds() {
		return winningOdds;
	}


	public void setWinningOdds(long winningOdds) {
		this.winningOdds = winningOdds;
	}


	public long getZjjs() {
		return zjjs;
	}


	public void setZjjs(long zjjs) {
		this.zjjs = zjjs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

