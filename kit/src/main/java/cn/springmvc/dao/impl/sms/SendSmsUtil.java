package cn.springmvc.dao.impl.sms; 

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import product_p2p.kit.HttpClient.HttpClientUtil;
import product_p2p.kit.datatrans.IntegerAndString;

/**
 *	
* @author 张友 
* @Description: 发送短信实体 
* @since 
* @date 2016-3-24 下午2:25:15
 */
@Controller("SendSmsUtil")
public class SendSmsUtil {
	
	@Resource(name="smsReadDaoImpl")
	private SmsReadDaoImpl smsReadDaoImpl;
	@Resource(name="smsWriteDaoImpl")
	private SmsWriteDaoImpl smsWriteDaoImpl;
	private static SendSmsUtil sendSmsUtil = null;
	
	public SmsReadDaoImpl getSmsReadDaoImpl() {
		return smsReadDaoImpl;
	}
	public void setSmsReadDaoImpl(SmsReadDaoImpl smsReadDaoImpl) {
		this.smsReadDaoImpl = smsReadDaoImpl;
	}
	public SmsWriteDaoImpl getSmsWriteDaoImpl() {
		return smsWriteDaoImpl;
	}
	public void setSmsWriteDaoImpl(SmsWriteDaoImpl smsWriteDaoImpl) {
		this.smsWriteDaoImpl = smsWriteDaoImpl;
	}
	public SendSmsUtil(){
		if(sendSmsUtil == null){
			sendSmsUtil = this;
		}
	}
	/**
	 * 获取对象方法
	* GetInstance(这里用一句话描述这个方法的作用) 
	* TODO(描述)
	* @author 张友  
	* * @Title: GetInstance 
	* @Description: TODO 
	* @param @return 设定文件 
	* @return SendSmsUtil 返回类型 
	* @date 2016-3-25 下午1:44:55
	* @throws
	 */
	public static SendSmsUtil GetInstance(){
		if(sendSmsUtil==null){
			sendSmsUtil = new SendSmsUtil();
		}
		return sendSmsUtil;
	}

	/**
	 * 
	* SendSms(发送短信方法) 
	* TODO(描述)
	* @author 张友  
	* * @Title: SendSms 		
	* @Description: TODO 
	* @param 	info				短信信息内容
	* @param 	iType				短信类型	 0:验证码	
	* @param	lAdminId			发送短息管理员ID
	* @param	ttLastDate			上次发送时间 再次发送时用
	* 0:验证码			info:	phone:手机号  code:验证码
	* @param @return 设定文件 
	* @return String[] 返回类型 			0：返回码   1：返回消息
	* @date 2016-3-24 下午3:40:22
	* @throws
	 */
	public String[] SendSms(Map<String, Object> info,int iType,long lAdminId,Timestamp ttLastDate){
		/*SmsReadDaoImpl smsReadDaoImpl = (SmsReadDaoImpl)SpringUtil.getBean("smsReadDaoImpl");
		SmsWriteDaoImpl smsWriteDaoImpl = (SmsWriteDaoImpl)SpringUtil.getBean("smsWriteDaoImpl");*/
		SmsSetInfoEntity smsSet = smsReadDaoImpl.GetSmsInfo();
		String[] sInfo = {"-100","发送短信失败"};
		short sType = 0;		// 0:首次发送	1：再次发送
		short sSendType = 0;	// 发送类型 0：系统自动发送 1：管理员手动发送	
		
		if(smsSet==null){
			return sInfo;
		}
		String sPhone = "";
		String sMemberPhone = "";
		String sContent = "";
		switch (iType) {
		case 0:{
			if(info==null){
				return sInfo;
			}
			sPhone = info.get("phone").toString();
			sContent = info.get("code").toString();
			sContent = "尊敬的四象金融用户，您的验证码为："+sContent+"，如非本人操作，请联系客服。";
			sMemberPhone = "-1,0,"+sPhone;
			break;
		}
		default:
			break;
		}
		
		sInfo = transmitStr(sPhone, sContent, smsSet.getsSn(), smsSet.getsPwd(), smsSet.getsInterface());
//		sInfo = mdgxsend(sPhone, sContent, smsSet.getsSn(), smsSet.getsPwd(), smsSet.getsInterface());
		
		short iStatu = 1;
		if(sInfo!=null && sInfo[0]!=null && sInfo[0].equals("0")){
			iStatu = 0;
		}
		smsWriteDaoImpl.InsertSmsRecord(sType, sContent, sMemberPhone, sSendType, lAdminId, iStatu, ttLastDate);
		
		return sInfo;
	}
	
	/*
	 * 方法名称：gxmt 功 能：漫道科技发送短信 参
	 * 数：mobile,content,ext,stime,rrid(手机号，内容，扩展码，定时时间，唯一标识) 返 回
	 *  msgfmt内容编码,0：ASCII串,3：短信写卡操作,4：二进制信息,8：UCS2编码,空或15：含GB汉字.
	 * 值：唯一标识，如果不填写rrid将返回系统生成的
	 */
	public String[] mdgxsend(String mobile, String content,String sn,String pwd,String sUrl) {
		String result[] = {"",""};
		String ext=""; 
		String stime="";
		String rrid="";
		String msgfmt="";
		String soapAction = "http://entinfo.cn/mdgxsend";
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
		xml += "<soap:Body>";
		xml += "<mdgxsend  xmlns=\"http://entinfo.cn/\">";
		xml += "<sn>" + sn + "</sn>";
		xml += "<pwd>" + pwd + "</pwd>";
		xml += "<mobile>" + mobile + "</mobile>";
		xml += "<content>" + content + "</content>";
		xml += "<ext>" + ext + "</ext>";
		xml += "<stime>" + stime + "</stime>";
		xml += "<rrid>" + rrid + "</rrid>";
		xml += "<msgfmt>" + msgfmt + "</msgfmt>";
		xml += "</mdgxsend>";
		xml += "</soap:Body>";
		xml += "</soap:Envelope>";

		URL url;
		try {
			url = new URL(sUrl);

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes());
			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestProperty("SOAPAction", soapAction);
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			OutputStream out = httpconn.getOutputStream();
			out.write(b);
			out.close();

			InputStreamReader isr = new InputStreamReader(httpconn
					.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				Pattern pattern = Pattern
						.compile("<mdgxsendResult>(.*)</mdgxsendResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result[0] = matcher.group(1);
				}
			}
			
			int iResult = IntegerAndString.StringToInt(result[0], -2);
			result[1] = PromptSMS.GetSmsSendStatu(iResult);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
	}
	
	
	/**
	 * 
	* transmitStr(发送短信通用方法) 
	* TODO(亿美软通)
	* @author 张友  
	* * @Title: transmitStr 
	* @Description: TODO 
	* @param @param phone			手机号
	* @param @param content			短信内容
	* @param @param sn				序列号
	* @param @param pwd				密码
	* @param @param sInterface 		url
	* @return void 返回类型 
	* @date 2016-3-24 下午2:27:48
	* @throws
	 */
	public String[] transmitStr(String phone,String content,String sn,String pwd,String sInterface){
		String url=sInterface;//"http://sdk4rptws.eucp.b2m.cn:8080/sdkproxy/sendsms.action";
		String endVlue = "发送失败";
		String[] sResult = {"",""};
		try {
			content=URLEncoder.encode(content, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String param = "sn="+sn+"&pwd="+pwd+"&mobile="+phone+"&content="+content+"&ext=&stime=&rrid=";
	 	String ResultStr = HttpClientUtil.sendGet(url, param);			 
	 	/*int index1 = ResultStr.indexOf("<error>");
		int index2 = ResultStr.indexOf("</error>");*/
		sResult[0] = ResultStr;		//ResultStr.substring(index1+7, index2);

		if(sResult[0].length() >= 18){
			System.out.println("发送短信验证码成功");
			sResult[1] = "短信发送成功";
		}else{
//			sResult[1] = SDKerrorInfo.getSDKResultInfo(endVlue);
			int iResult = IntegerAndString.StringToInt(sResult[0], -1);
			sResult[1] = PromptSMS.GetSmsSendStatu(iResult);
			System.out.println("发送短信验证码失败：返回值"+sResult[0]+";"+sResult[1]);
		}
		return sResult;
	}
	
}

