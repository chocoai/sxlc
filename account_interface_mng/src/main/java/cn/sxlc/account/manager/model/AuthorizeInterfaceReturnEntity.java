
package cn.sxlc.account.manager.model; 

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/** 
 * 第三方自动投标、自动还款、二次分配授权返回信息处理
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-10 上午11:32:23  */
public class AuthorizeInterfaceReturnEntity {
	private String moneymoremoreId;//用户乾多多标识
	private String platformMoneymoremore;//平台乾多多标识
	private int authorizeStatu;//此次 开启还是关闭授权；1：开启  2：关闭
	private String authorizeTypeOpen;//开启授权类型
	private String authorizeTypeClose;//关闭授权类型
	private String authorizeType;//当前授权类型
	private String randomTimeStamp;//
	private String remark1;//
	private String remark2;//
	private String remark3;//
	private String returnURL;//页面返回网址
	private String notifyURL;//后台通知网址
	private String resultCode;//返回码
	private String message;//返回信息
	private String signInfo;//签名信息
	private int statu;//授权状态 ：0成功 1失败
//	public AuthorizeInterfaceReturnEntity authorizationInformation() throws UnsupportedEncodingException{
//		AuthorizeInterfaceReturnEntity 
//			authorizeInterfaceReturnEntity=new AuthorizeInterfaceReturnEntity();
//		ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		request.setCharacterEncoding("UTF-8");
//		authorizeInterfaceReturnEntity.
//			setResultCode(request.getParameter("ResultCode"));
//		authorizeInterfaceReturnEntity
//			.setMessage(request.getParameter("Message"));//返回状态信息
//		if(authorizeInterfaceReturnEntity.getResultCode()!=null){
//			if(authorizeInterfaceReturnEntity.getResultCode().equals("88")){
//				if(!request.getParameter("AuthorizeTypeOpen").equals("")){
//					authorizeInterfaceReturnEntity.setAuthorizeStatu(1);//开启
//				}else {
//					authorizeInterfaceReturnEntity.setAuthorizeStatu(2);//关闭
//				}
//				authorizeInterfaceReturnEntity.setRemark1(request.getParameter("Remark1"));
//				authorizeInterfaceReturnEntity.setRemark2(request.getParameter("Remark2"));
//				authorizeInterfaceReturnEntity.setRemark3(request.getParameter("Remark3"));
//				authorizeInterfaceReturnEntity
//					.setAuthorizeType(request.getParameter("AuthorizeType"));//当前操作的授权类型
//				authorizeInterfaceReturnEntity.setStatu(0);
//			}else{
//				authorizeInterfaceReturnEntity.setStatu(1);
//			}
//		}
//		return authorizeInterfaceReturnEntity;
//	} 
	
	
	public String getMoneymoremoreId() {
		return moneymoremoreId;
	}
	public void setMoneymoremoreId(String moneymoremoreId) {
		this.moneymoremoreId = moneymoremoreId;
	}
	public String getPlatformMoneymoremore() {
		return platformMoneymoremore;
	}
	public void setPlatformMoneymoremore(String platformMoneymoremore) {
		this.platformMoneymoremore = platformMoneymoremore;
	}
	public String getAuthorizeTypeOpen() {
		return authorizeTypeOpen;
	}
	public void setAuthorizeTypeOpen(String authorizeTypeOpen) {
		this.authorizeTypeOpen = authorizeTypeOpen;
	}
	public String getAuthorizeTypeClose() {
		return authorizeTypeClose;
	}
	public void setAuthorizeTypeClose(String authorizeTypeClose) {
		this.authorizeTypeClose = authorizeTypeClose;
	}
	public String getRandomTimeStamp() {
		return randomTimeStamp;
	}
	public void setRandomTimeStamp(String randomTimeStamp) {
		this.randomTimeStamp = randomTimeStamp;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getReturnURL() {
		return returnURL;
	}
	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}
	public String getNotifyURL() {
		return notifyURL;
	}
	public void setNotifyURL(String notifyURL) {
		this.notifyURL = notifyURL;
	}
	public String getSignInfo() {
		return signInfo;
	}
	public void setSignInfo(String signInfo) {
		this.signInfo = signInfo;
	}
	public String getAuthorizeType() {
		return authorizeType;
	}
	public void setAuthorizeType(String authorizeType) {
		this.authorizeType = authorizeType;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	public int getAuthorizeStatu() {
		return authorizeStatu;
	}


	public void setAuthorizeStatu(int authorizeStatu) {
		this.authorizeStatu = authorizeStatu;
	}


	public int getStatu() {
		return statu;
	}


	public void setStatu(int statu) {
		this.statu = statu;
	}
	@Override
	public String toString() {
		return "AuthorizeInterfaceReturnEntity [moneymoremoreId="
				+ moneymoremoreId + ", platformMoneymoremore="
				+ platformMoneymoremore + ", authorizeStatu=" + authorizeStatu
				+ ", authorizeTypeOpen=" + authorizeTypeOpen
				+ ", authorizeTypeClose=" + authorizeTypeClose
				+ ", authorizeType=" + authorizeType + ", randomTimeStamp="
				+ randomTimeStamp + ", remark1=" + remark1 + ", remark2="
				+ remark2 + ", remark3=" + remark3 + ", returnURL=" + returnURL
				+ ", notifyURL=" + notifyURL + ", resultCode=" + resultCode
				+ ", message=" + message + ", signInfo=" + signInfo
				+ ", statu=" + statu + "]";
	}
	
	
}

