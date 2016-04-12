
package cn.springmvc.model; 

/** 
 * 平台消息类型设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-16 上午11:57:56  */
public class MessageTypeEntity {
	private long typeID;//	消息类型id
	private String typeName;//	消息类型名称 注册成功、开户成功、充值成功、提现成功、投资成功、投资失败、借款申请审核失败、借款失败、借款成功、还款提醒、当期还款成功、项目回款、修改登录密码通知
	private String msgDetail;//消息内容
	private int statu;//	状态 0：无效 1：有效
	private int iSSmsSend;//是否发送短信 0：不发送 1：发送
	private int iSLetterSend;//是否发送站内信0：不发送 1：发送
	private int iSEmailSend;//是否发送系统邮件0：不发送 1：发送
	public long getTypeID() {
		return typeID;
	}
	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getMsgDetail() {
		return msgDetail;
	}
	public void setMsgDetail(String msgDetail) {
		this.msgDetail = msgDetail;
	}
	public int getiSSmsSend() {
		return iSSmsSend;
	}
	public void setiSSmsSend(int iSSmsSend) {
		this.iSSmsSend = iSSmsSend;
	}
	public int getiSLetterSend() {
		return iSLetterSend;
	}
	public void setiSLetterSend(int iSLetterSend) {
		this.iSLetterSend = iSLetterSend;
	}
	public int getiSEmailSend() {
		return iSEmailSend;
	}
	public void setiSEmailSend(int iSEmailSend) {
		this.iSEmailSend = iSEmailSend;
	}
	
}

