
package cn.springmvc.model; 

/** 
 * 系统设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 下午6:55:59  */
public class SystemInfoSetEntity {
	
	private String systemName;//平台名称	
	private String backgroundLogo;//平台后台logo	
	private String forgroundLogo;//平台前台logo	
	private String systemHotline;//系统客服热线	
	private String systemOfficeHours;//平台工作时间	
	private String weiboName;//	平台微博名
	private String weiboQRCode;//微博二维码地址	
	private String qQGroupCode;//平台qq群号	
	private String qQGroupQRCode;//平台qq群二维码地址	
	private String weChatCode;//平台微信公众号	
	private String weChatQRCode;//平台微信二维码地址	
	private int switchStatu;//	平台开启状态 0：关闭 1：开启
	private String riskReserveFund;//前台显示平台风险准备金金额	
	private String expectYearRate;//平台前台显示逾期年化设置	
	private String integralAlias;//积分别名	
	private String welcomeTitle;//平台欢迎语设置
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getBackgroundLogo() {
		return backgroundLogo;
	}
	public void setBackgroundLogo(String backgroundLogo) {
		this.backgroundLogo = backgroundLogo;
	}
	public String getForgroundLogo() {
		return forgroundLogo;
	}
	public void setForgroundLogo(String forgroundLogo) {
		this.forgroundLogo = forgroundLogo;
	}
	public String getSystemHotline() {
		return systemHotline;
	}
	public void setSystemHotline(String systemHotline) {
		this.systemHotline = systemHotline;
	}
	public String getSystemOfficeHours() {
		return systemOfficeHours;
	}
	public void setSystemOfficeHours(String systemOfficeHours) {
		this.systemOfficeHours = systemOfficeHours;
	}
	public String getWeiboName() {
		return weiboName;
	}
	public void setWeiboName(String weiboName) {
		this.weiboName = weiboName;
	}
	public String getWeiboQRCode() {
		return weiboQRCode;
	}
	public void setWeiboQRCode(String weiboQRCode) {
		this.weiboQRCode = weiboQRCode;
	}
	public String getqQGroupCode() {
		return qQGroupCode;
	}
	public void setqQGroupCode(String qQGroupCode) {
		this.qQGroupCode = qQGroupCode;
	}
	public String getqQGroupQRCode() {
		return qQGroupQRCode;
	}
	public void setqQGroupQRCode(String qQGroupQRCode) {
		this.qQGroupQRCode = qQGroupQRCode;
	}
	public String getWeChatCode() {
		return weChatCode;
	}
	public void setWeChatCode(String weChatCode) {
		this.weChatCode = weChatCode;
	}
	public String getWeChatQRCode() {
		return weChatQRCode;
	}
	public void setWeChatQRCode(String weChatQRCode) {
		this.weChatQRCode = weChatQRCode;
	}
	public int getSwitchStatu() {
		return switchStatu;
	}
	public void setSwitchStatu(int switchStatu) {
		this.switchStatu = switchStatu;
	}
	public String getRiskReserveFund() {
		return riskReserveFund;
	}
	public void setRiskReserveFund(String riskReserveFund) {
		this.riskReserveFund = riskReserveFund;
	}
	public String getExpectYearRate() {
		return expectYearRate;
	}
	public void setExpectYearRate(String expectYearRate) {
		this.expectYearRate = expectYearRate;
	}
	public String getIntegralAlias() {
		return integralAlias;
	}
	public void setIntegralAlias(String integralAlias) {
		this.integralAlias = integralAlias;
	}
	public String getWelcomeTitle() {
		return welcomeTitle;
	}
	public void setWelcomeTitle(String welcomeTitle) {
		this.welcomeTitle = welcomeTitle;
	}
	@Override
	public String toString() {
		return "SystemInfoSetEntity [systemName平台名称=" + systemName
				+ ", backgroundLogo=" + backgroundLogo + ", forgroundLogo="
				+ forgroundLogo + ", systemHotline=" + systemHotline
				+ ", systemOfficeHours=" + systemOfficeHours + ", weiboName="
				+ weiboName + ", weiboQRCode=" + weiboQRCode + ", qQGroupCode="
				+ qQGroupCode + ", qQGroupQRCode=" + qQGroupQRCode
				+ ", weChatCode=" + weChatCode + ", weChatQRCode="
				+ weChatQRCode + ", switchStatu=" + switchStatu
				+ ", riskReserveFund=" + riskReserveFund + ", expectYearRate="
				+ expectYearRate + ", integralAlias=" + integralAlias
				+ ", welcomeTitle=" + welcomeTitle + "]";
	}	
	
	
	
}

