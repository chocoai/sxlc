package cn.springmvc.dao.impl.sms; 

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.HttpClient.HttpClientUtil;
import product_p2p.kit.datatrans.IntegerAndString;

/**
 *	
* @author 张友 
* @Description: 发送短信实体 
* @since 
* @date 2016-3-24 下午2:25:15
 */
@Service("sendSmsUtil")
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
		
//		sInfo = transmitStr(sPhone, sContent, smsSet.getsSn(), smsSet.getsPwd(), smsSet.getsInterface());
//		sInfo = mdgxsend(sPhone, sContent, smsSet.getsSn(), smsSet.getsPwd(), smsSet.getsInterface());
		sInfo = sendSMS(sPhone, sContent, smsSet.getsSn(), smsSet.getsPwd(), smsSet.getsInterface());
		
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

	
	
	
	/***
	* 使用凌凯短信平台发送短信
	* <br>
	* 这个方法主要是最基本的封装、用于满足所有要求。
	* @author 李杰	
	* @param cropId						用户名
	* @param pwd						用户密码
	* @param moblie						手机号集合
	* @param content					发送类容
	* @param cell						扩展号(必须是数字或为空)
	* @param sendTime					定时发送时间(可为空)
	* @return
	* 
	* @Description: TODO
	* @date 2016-4-1 上午11:27:43
	 */
	private static String[] lkSendSMS(String url,String cropId,String pwd,Set<String> moblie,String content,String cell,String sendTime){
		try {
			content+="【凌凯】";
			content = content=URLEncoder.encode(content, "gb2312");
		} catch (UnsupportedEncodingException e1) {
			//编码参数异常
			return new String[]{"0","发送失败,参数异常"};
		}
		//1.检查输入参数
		if(content == null || content.trim().length() == 0){//发送类容为空、发送失败
			
		}
		//检查发送号码是否为空
		if(moblie.size() == 0){
			
		}
		StringBuffer phone= new StringBuffer();
		for (String string : moblie) {
			phone.append(string);
			phone.append(",");
		}
		String phones = phone.substring(0, phone.length()-1);
		
		StringBuffer sendParam = new StringBuffer();
		sendParam.append("CorpID=");
		sendParam.append(cropId);
		
		sendParam.append("&Pwd=");
		sendParam.append(pwd);
		
		sendParam.append("&Mobile=");
		sendParam.append(phones);
		
		sendParam.append("&Content=");
		sendParam.append(content);
		
		if(cell != null){
			sendParam.append("&Cell=");
			sendParam.append(cell);
		}
		if(sendTime != null){
			sendParam.append("&SendTime=");
			sendParam.append(sendTime);
		}
		
		
		System.out.println(url+"?"+sendParam.toString()+"-------------------->");
		String ResultStr = HttpClientUtil.sendGet(url, sendParam.toString());
		
		int result = -20;
		try {
			result = Integer.parseInt(ResultStr);
		} catch (Exception e) {
			System.out.println("短信接口调用返回异常:"+e.getLocalizedMessage());
		}
		
		String[] returnInfo = new String[2];
		if(result >= 0){
			returnInfo[1] = "提交成功";
		}else if(result == -1){
			returnInfo[1] = "账号未注册";
		}else if(result == -2){
			returnInfo[1] = "其他错误";
		}else if(result == -3){
			returnInfo[1] = "账户密码错误";
		}else if(result == -5){
			returnInfo[1] = "余额不足";
		}else if(result == -6){
			returnInfo[1] = "定时发送时间不是有效的时间格式";
		}else if(result == -7){
			returnInfo[1] = "提交信息末尾未签名，请添加中文的企业签名【】";
		}else if(result == -8){
			returnInfo[1] = "发送内容需在1到300字之间";
		}else if(result == -9){
			returnInfo[1] = "发送号码为空";
		}else if(result == -10){
			returnInfo[1] = "定时时间不能小于系统当前时间";
		}else if(result == -100){
			returnInfo[1] = "IP黑名单";
		}else if(result == -102){
			returnInfo[1] = "账号黑名单";
		}else if(result == -103){
			returnInfo[1] = "IP未导白";
		}
		returnInfo[0] = ResultStr;
		return returnInfo;
	}
	
	
	
	
	/***
	* 发送短信信息
	* @author 李杰
	* @Title: sendSMS
	* @param phone							目标号码
	* @param content						发送内容
	* @param cropId							账户
	* @param pwd							密码
	* @param sinterface						短信接口地址
	* @return
	* @Description: TODO
	* @date 2016-4-1 下午1:52:58
	 */
	private String[] sendSMS(String phone,String content,String cropId,String pwd,String sinterface){
		Set<String> moblie = new HashSet<String>();
		moblie.add(phone);
		return lkSendSMS(sinterface, cropId, pwd, moblie, content, null, null);
	}
	
	
	
	
	
	
	/**
	* 获取短信信息
	* 
	* @author 李杰
	* @Title: getSMS
	* @param cropId							账号
	* @param pwd							密码
	* @param phoneAndCode			用于返回手机号码等信息[手机号#上行内容#发送时间#扩展号]
	* @return 状态码信息,返回1说明正常，返回0说明没有信息。
	* -1账号未注册，-2其他错误，-3密码错误，-101接口调用太频繁，-100Ip黑名单，-102账号黑名单，-103IP未导白
	* @Description: TODO
	* @date 2016-3-1 下午2:28:03
	 */
	public int getSMS(String cropId,String pwd,String sinterface,String[] phoneAndCode){
		String param = "CorpID="+cropId+",Pwd="+pwd;
		String resultString = HttpClientUtil.sendGet(sinterface, param);
		
		if(resultString == null || resultString.trim().length()==0){
			return 0;
		}
		int result = 1;
		try {
			result = Integer.parseInt(resultString);//如果转换成功，说明没有返回正确数据信息
		} catch (Exception e) {
			phoneAndCode = resultString.split("||");
		}
		return result;
	}
	
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

