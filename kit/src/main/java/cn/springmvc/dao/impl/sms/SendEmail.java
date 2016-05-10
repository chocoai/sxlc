package cn.springmvc.dao.impl.sms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;




/** 
 * 发送邮件
* @author 朱祖轶 
* @Description: TODO 
* @since 
* @date 2016-5-6 下午1:55:10  */
@Service("sendEmail")
public class SendEmail {
	@Resource(name="smsReadDaoImpl")
	private SmsReadDaoImpl smsReadDaoImpl;
	@Resource(name="smsWriteDaoImpl")
	private SmsWriteDaoImpl smsWriteDaoImpl;
	private static SendEmail sendEmail;
	public SmsWriteDaoImpl getSmsWriteDaoImpl() {
		return smsWriteDaoImpl;
	}

	public void setSmsWriteDaoImpl(SmsWriteDaoImpl smsWriteDaoImpl) {
		this.smsWriteDaoImpl = smsWriteDaoImpl;
	}
	public SmsReadDaoImpl getSmsReadDaoImpl() {
		return smsReadDaoImpl;
	}

	public void setSmsReadDaoImpl(SmsReadDaoImpl smsReadDaoImpl) {
		this.smsReadDaoImpl = smsReadDaoImpl;
	}

	public static SendEmail getSendEmail() {
		return sendEmail;
	}

	public static void setSendEmail(SendEmail sendEmail) {
		SendEmail.sendEmail = sendEmail;
	}
	public SendEmail(){
		if(sendEmail == null){
			sendEmail = this;
		}
	}
	
	
	/** 
	* checkEmail 发送邮件 
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: checkEmail 
	* @Description: TODO 
	* @param @param email 邮件地址
	* @param @param content 发送内容
	* @param @param request
	* @param @param memberID 接收会员id
	* @param @param memberType 接收会员类型  邮件发送对象类型 0：会员 1：担保机构
	* @param @param sSendType 发送类型 0：系统自动发送 1：管理员手动发送
	* @param @param lAdminId 手动发送管理员id
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-6 下午2:31:43
	* @throws 
	*/
	public int checkEmail(String email,String content,HttpServletRequest request,long memberID,int memberType,short sSendType,long lAdminId){
		HttpSession session = request.getSession();
		short sStatu = 0;
		int rulest = 0;
		if (email != "" && email != null) {
			EMessageEntity eMessageEntity = smsReadDaoImpl.getEmail();
			
			String smtpservice = eMessageEntity.getSmtpservice();
			String portNumber = eMessageEntity.getPort_Number();
			
			String emailAddress = eMessageEntity.getEmail_Address();
			String emailPwd = eMessageEntity.getEmail_Password();
			
			//这个类主要是设置邮件   
		     MailSenderInfo mailInfo = new MailSenderInfo(); 
		     
		     mailInfo.setMailServerHost(smtpservice);    
		     
		     
		     mailInfo.setMailServerPort(portNumber);    
		     mailInfo.setValidate(true);    
		     
		     mailInfo.setUserName(emailAddress);    
		     
		     mailInfo.setPassword(emailPwd);//您的邮箱密码
		     
		     // 发件人邮箱地址
		     mailInfo.setFromAddress(emailAddress);    
		     
		     mailInfo.setToAddress(email);    
		     
		     mailInfo.setSubject("四象联创");
		     
		     int randNum=(int)(Math.random()*1000000);
		     String ssString=Integer.toString(randNum);
		     if (ssString.length()<6) {
				for (int i = ssString.length(); i < 6; i++) {
					ssString +="0";
				}
				randNum=IntegerAndString.StringToInt(ssString, 0);
			}
		    System.out.println("来着邮箱消息："+randNum);
			session.setAttribute("randNum", randNum);
			//content = SMScontent.contentEmail2(randNum+"");
		    mailInfo.setContent(content);
		    //这个类主要来发送邮件
		    SimpleMailSender sms = new SimpleMailSender();   
		    
		    try{
		    	Thread.sleep(1000);//延迟1秒
		    	boolean send=sms.sendTextMail(mailInfo);
		    	if (send) {
		    		sStatu=1;
		    		rulest=1;
		    		smsWriteDaoImpl.InsertEmailSmsRecord(memberID, memberType, content, emailPwd, sSendType, lAdminId, sStatu);
				}else {
					sStatu=0;
					rulest = 0;
		    		smsWriteDaoImpl.InsertEmailSmsRecord(memberID, memberType, content, emailPwd, sSendType, lAdminId, sStatu);
				}
			} catch (Exception e) {
				rulest = 0;
				System.out.println("发送邮件时："+e.getLocalizedMessage());
			}
		}
		return rulest;
	}
	
	
	/** 
	* sendLetter 后台发送站内消息
	* TODO(描述)
	* @author 朱祖轶  
	* * @Title: sendLetter 
	* @Description: TODO 
	* @param @param vTmp 发送会员拼接（会员类型，会员id;会员类型，会员id） 如:0,111;1,121
	* @param @param adminId 操作管理员id
	* @param @param sendType 发送类型 0：系统自动发送 1：管理员手动发送
	* @param @param details 发送内容
	* @param @return 设定文件 
	* @return int 返回类型 
	* @date 2016-5-6 下午3:22:34
	* @throws 
	*/
	public int sendLetter(String vTmp,long adminId,int sendType,String details){
		return smsWriteDaoImpl.LetterSendRecord(vTmp, adminId, sendType, details);
	};
}
