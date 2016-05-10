package cn.membermng.model; 


/****
* 消息提示设置对象
* 
* @author 李杰
* @since 
* @date 2016-5-9 下午4:38:08 
*
*/
public class MemberMessageConfig {

	private long			typeId;				//设计类型编号
	private String			typeName;			//类型名称
	private int				sysSms;				//用户定义短信状态 	0未选中 1选中
	private int				sysLett;			//用户定义站内信状态	0为选择 1选中
	private int				sysemil;			//用户定义邮箱状态	0未选中 1选中
	
	private int				useSms;				//用户定义短信状态 	0未选中 1选中
	private int				useLett;			//用户定义站内信状态	0为选择 1选中
	private int				useemil;			//用户定义邮箱状态	0未选中 1选中
	
	
	
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
	public int getUseSms() {
		return useSms;
	}
	public void setUseSms(int useSms) {
		this.useSms = useSms;
	}
	public int getUseLett() {
		return useLett;
	}
	public void setUseLett(int useLett) {
		this.useLett = useLett;
	}
	public int getUseemil() {
		return useemil;
	}
	public void setUseemil(int useemil) {
		this.useemil = useemil;
	}
	public int getSysSms() {
		return sysSms;
	}
	public void setSysSms(int sysSms) {
		this.sysSms = sysSms;
	}
	public int getSysLett() {
		return sysLett;
	}
	public void setSysLett(int sysLett) {
		this.sysLett = sysLett;
	}
	public int getSysemil() {
		return sysemil;
	}
	public void setSysemil(int sysemil) {
		this.sysemil = sysemil;
	}
	
	
}

