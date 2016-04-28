package cn.membermng.model; 


/***
* 认证类型
* 
* @author 李杰
* @since 
* @date 2016-4-26 下午1:50:58 
*
*/
public class BorrowingType {
	
	private long 			typeId;				//类型编号
	private String			typeName;			//类型名称
	private int 			status;				//状态
	
	
	
	public BorrowingType() {}

	public long getTypeId() {
		return typeId;
	}
	
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	

}

