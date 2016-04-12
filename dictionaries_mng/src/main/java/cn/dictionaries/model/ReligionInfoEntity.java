
package cn.dictionaries.model; 
/**
 * 字典 ： 宗教信仰实例
* @author 杨翰林
* @Description: TODO 
* @since 
* @date 2016-4-1 下午2:55:04
 */
public class ReligionInfoEntity {

	//宗教类型Id
	private int rId;
	
	//类型名称
	private String 	rName;

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}
	
	
}

