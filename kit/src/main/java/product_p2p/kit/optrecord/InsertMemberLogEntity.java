package product_p2p.kit.optrecord;

public class InsertMemberLogEntity {
	private long lServerId;				//服务器id
	private String sIp;					//访问ip
	private String sMac;				//访问mac地址
	private String sUrl;				//访问url
	private String sReferrUrl;			//页面来源
	private String sKeyWord;			//页面关键词
	public String getsKeyWord() {
		return sKeyWord;
	}
	public void setsKeyWord(String sKeyWord) {
		this.sKeyWord = sKeyWord;
	}
	public long getlServerId() {
		return lServerId;
	}
	public void setlServerId(long lServerId) {
		this.lServerId = lServerId;
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
	public String getsReferrUrl() {
		return sReferrUrl;
	}
	public void setsReferrUrl(String sReferrUrl) {
		this.sReferrUrl = sReferrUrl;
	}
}
