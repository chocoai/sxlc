package cn.springmvc.model;
/**
 * 借款意向配置实体
 * @author 刘利
 *
 */
public class ProjectPurposeSetEntity {
	/**
	 * 所需选项内容 
	 * 0：借款用途 1：还款保障 2：借款金额 3：项目描述 4：借款期限 5：还款方式
	 *  6：预计年化收益率 7：借款项目类型 8：还款来源
	 */
	private int optionType;	
	/**
	 * 所需选项状态 0：无效 1：有效
	 */
	private int optionStatu;
	public int getOptionStatu() {
		return optionStatu;
	}
	public void setOptionStatu(int optionStatu) {
		this.optionStatu = optionStatu;
	}
	public int getOptionType() {
		return optionType;
	}
	public void setOptionType(int optionType) {
		this.optionType = optionType;
	}	

}
