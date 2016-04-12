package product_p2p.kit.optrecord;

public class InsertAdminLogEntity {
	private long iAdminId;				//管理员id
	private long lModuleId;				//模块id
	private long lOptId;				//操作id
	private String sDetail;				//操作详情
	private String sIp;					//访问ip
	private String sMac;				//访问mac地址
	private String sUrl;				//访问url
	
	public long getiAdminId() {
		return iAdminId;
	}
	public void setiAdminId(long iAdminId) {
		this.iAdminId = iAdminId;
	}
	public long getlModuleId() {
		return lModuleId;
	}
	public void setlModuleId(long lModuleId) {
		this.lModuleId = lModuleId;
	}
	public long getlOptId() {
		return lOptId;
	}
	public void setlOptId(long lOptId) {
		this.lOptId = lOptId;
	}
	public String getsDetail() {
		return sDetail;
	}
	public void setsDetail(String sDetail) {
		this.sDetail = sDetail;
	}
	public String getsIp() {
		return sIp;
	}
	public void setsIp(String sIp) {
		this.sIp = sIp;
	}
	public String getsMac() {
		return sMac;
	}
	public void setsMac(String sMac) {
		this.sMac = sMac;
	}
	public String getsUrl() {
		return sUrl;
	}
	public void setsUrl(String sUrl) {
		this.sUrl = sUrl;
	}
}
