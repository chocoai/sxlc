
package cn.springmvc.model; 

/**
 * @author pengran
 * 托管平台接口类型表
 * @date:2016-5-13 上午10:38:20
 **/

public class AccountEscrowInterfaceEntity {
	private  int 	 interfaceID  ;		//接口id
	private  String  interfaceName; 	//接口名称
	private  int     typeStatu;			//接口状态
	public int getInterfaceID() {
		return interfaceID;
	}
	public void setInterfaceID(int interfaceID) {
		this.interfaceID = interfaceID;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public int getTypeStatu() {
		return typeStatu;
	}
	public void setTypeStatu(int typeStatu) {
		this.typeStatu = typeStatu;
	}
}

