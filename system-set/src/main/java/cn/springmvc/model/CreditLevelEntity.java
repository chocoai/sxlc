
package cn.springmvc.model; 

/** 
 * 会员信用等级
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午7:35:31  */
public class CreditLevelEntity {
	private long id;	
	private int creditScoreMin;//	等级最小值
	private int creditScoreMax;//	等级最大值 0：表示无上限
	private String levelMark;//	等级名称
	private String levelDetail;//	等级描述
	private int statu;//	状态 0：无效 1：有效
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCreditScoreMin() {
		return creditScoreMin;
	}
	public void setCreditScoreMin(int creditScoreMin) {
		this.creditScoreMin = creditScoreMin;
	}
	public int getCreditScoreMax() {
		return creditScoreMax;
	}
	public void setCreditScoreMax(int creditScoreMax) {
		this.creditScoreMax = creditScoreMax;
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
	
}

