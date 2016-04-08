
package cn.dictionaries.model; 
/**
 * 字典：乡镇实例
* @author 杨翰林
* @Description: TODO 
* @since 
* @date 2016-4-1 上午11:44:31
 */
public class TownInfoEntity {
	
	//乡id
	private int tId;
	
	//县id
	private int xId;
	
	//乡镇名称
	private String tName;
	
	//乡no
	private String tNo;

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getxId() {
		return xId;
	}

	public void setxId(int xId) {
		this.xId = xId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}
	

}

