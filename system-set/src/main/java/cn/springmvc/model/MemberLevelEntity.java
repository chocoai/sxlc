
package cn.springmvc.model; 

/** 
 * 会员等级
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午7:35:47  */
public class MemberLevelEntity {
	private long id;	
	private int scoreMin;//	等级最小值
	private int scoreMax;//	等级最大值 0：表示无上限
	private String levelMark;//	等级名称
	private String levelDetail;//	等级描述
	private int statu;//	状态 0：无效 1：有效
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getScoreMin() {
		return scoreMin;
	}
	public void setScoreMin(int scoreMin) {
		this.scoreMin = scoreMin;
	}
	public int getScoreMax() {
		return scoreMax;
	}
	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}
	public String getLevelMark() {
		return levelMark;
	}
	public void setLevelMark(String levelMark) {
		this.levelMark = levelMark;
	}
	public String getLevelDetail() {
		return levelDetail;
	}
	public void setLevelDetail(String levelDetail) {
		this.levelDetail = levelDetail;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	@Override
	public String toString() {
		return "MemberLevelEntity [id=" + id + ", scoreMin=" + scoreMin
				+ ", scoreMax=" + scoreMax + ", levelMark=" + levelMark
				+ ", levelDetail=" + levelDetail + ", statu=" + statu + "]";
	}
}

