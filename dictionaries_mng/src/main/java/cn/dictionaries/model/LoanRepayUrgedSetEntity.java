
package cn.dictionaries.model; 

import java.io.Serializable;

/**
 * 账单催收配置实体
* @author 张友 
* @Description: TODO 
* @since 
* @date 2016-5-11 下午3:44:33
 */
public class LoanRepayUrgedSetEntity implements Serializable{
	private static final long serialVersionUID = -8837128442155435195L;
	private short sDays;				//到期前N天视为即将到期账单
	private String sBillContent;		//未逾期账单配置
	private String sBillOverdue;		//逾期账单配置
	public short getsDays() {
		return sDays;
	}
	public void setsDays(short sDays) {
		this.sDays = sDays;
	}
	public String getsBillContent() {
		return sBillContent;
	}
	public void setsBillContent(String sBillContent) {
		this.sBillContent = sBillContent;
	}
	public String getsBillOverdue() {
		return sBillOverdue;
	}
	public void setsBillOverdue(String sBillOverdue) {
		this.sBillOverdue = sBillOverdue;
	}
}

