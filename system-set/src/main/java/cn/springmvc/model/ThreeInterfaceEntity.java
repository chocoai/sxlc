
package cn.springmvc.model; 

/** 
 * 三方接口配置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 下午5:52:18  */
public class ThreeInterfaceEntity {
	private String publicKey;	//加密公钥
	private String privateKey;//加密私钥	
	private int escrowID;//托管平台ID	
	private int interfaceID;//接口类型ID
	private String interfaceUrl;//接口请求URL
	private String escrowName;//托管平台名称
	private String interfaceName;//接口类型名称
	
	private int   statu;//状态   1有效 0 无效
	
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public int getEscrowID() {
		return escrowID;
	}
	public void setEscrowID(int escrowID) {
		this.escrowID = escrowID;
	}
	public int getInterfaceID() {
		return interfaceID;
	}
	public void setInterfaceID(int interfaceID) {
		this.interfaceID = interfaceID;
	}
	public String getInterfaceUrl() {
		return interfaceUrl;
	}
	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}
	public String getEscrowName() {
		return escrowName;
	}
	public void setEscrowName(String escrowName) {
		this.escrowName = escrowName;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}



}

