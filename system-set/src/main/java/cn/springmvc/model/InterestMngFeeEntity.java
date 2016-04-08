
package cn.springmvc.model; 

/** 
 * 利息管理费设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 下午9:24:04  */
public class InterestMngFeeEntity {
	private int priceDatum;//利息管理费 单位万分之
	private int projectType;//	项目类型ID
	private int statu;//认证项状态 0：无效 1：有效	
	public int getPriceDatum() {
		return priceDatum;
	}
	public void setPriceDatum(int priceDatum) {
		this.priceDatum = priceDatum;
	}
	public int getProjectType() {
		return projectType;
	}
	public void setProjectType(int projectType) {
		this.projectType = projectType;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	
}

