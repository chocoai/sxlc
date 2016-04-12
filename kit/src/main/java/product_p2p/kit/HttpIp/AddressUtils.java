package product_p2p.kit.HttpIp;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
/**
 *  根据IP地址获取详细的地域信息
 */
public class AddressUtils {  
	
	
	/**
	 * 获取访问ip地址
	 * @param request			http请求
	 * @param sIpInfo			返回  ip地址详细信息	[0]：国家	[1]:地区	[2]：省	[3]:市	[4]：县区	[5]：运营商
	 * @return
	 */
	public static String GetRemoteIpAddr(HttpServletRequest request,String[] sIpInfo){
		String sResult = "";
		
		if(request==null){
			return sResult;
		}
		String ip = request.getHeader("X-Real-IP");
		if (ip!=null && !"unknown".equalsIgnoreCase(ip)) {
			sResult = ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (ip!=null && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				sResult = ip.substring(0, index);
			} else {
				sResult = ip;
			}
		} else {
			sResult = request.getRemoteAddr();
		}
		if(sIpInfo == null){
			return sResult;
		}
		
		AddressUtils addressUtils = new AddressUtils();
		try {
			String str = addressUtils.getAddresses("ip="+sResult, "utf-8");
			
			String[] dataStr = str.split("，");
			if(dataStr.length > 0 && dataStr.length>=6){
				String[] country = dataStr[0].split("：");
				String[] region = dataStr[1].split("：");
				String[] province = dataStr[2].split("：");
				String[] city = dataStr[3].split("：");
				String[] area = dataStr[4].split("：");
				String[] ISP = dataStr[5].split("：");
				
				if(country.length > 1 && sIpInfo.length>0){
					sIpInfo[0] = country[1];
				}
				if(region.length > 1 && sIpInfo.length>1){
					sIpInfo[1] = region[1];
				}
				if(province.length > 1 && sIpInfo.length>2){
					sIpInfo[2] = province[1];
				}
				if(city.length > 1 && sIpInfo.length>3){
					sIpInfo[3] = city[1];
				}
				if(area.length > 1 && sIpInfo.length>4){
					sIpInfo[4] = area[1];
				}
				if(ISP.length > 1 && sIpInfo.length>5){
					sIpInfo[5] = ISP[1];
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return sResult;
	}
	
 /**
  * 
  * @param content
  *            请求的参数 格式为：name=xxx&pwd=xxx
  * @param encoding
  *            服务器端请求编码。如GBK,UTF-8等
  * @return
  * @throws UnsupportedEncodingException    
  */
/* public String getAddresses(String content, String encodingString)
   throws UnsupportedEncodingException {
  // 这里调用pconline的接口
  String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
  // 从http://whois.pconline.com.cn取得IP所在的省市区信息
  String returnStr = this.getResult(urlStr, content, encodingString);
  if (returnStr != null) {
   // 处理返回的省市区信息
 //  System.out.println(returnStr);
   String[] temp = returnStr.split(",");
   if(temp.length<3){
    return "0";//无效IP，局域网测试
   }
   // String region = (temp[5].split(":"))[1].replaceAll("\"", "");
   // region = decodeUnicode(region);// 省份
     String country = "";
     String area = ""; 
     String region = ""; 
     String city = ""; 
     String county = ""; 
     String isp = ""; 
     for(int i=0;i<temp.length;i++){
	     switch(i){ 
	     case 1:country = (temp[i].split(":"))[2].replaceAll("\"", ""); 
	     		country = decodeUnicode(country);//国家 
	     		break; 
	     case 3:area = (temp[i].split(":"))[1].replaceAll("\"", ""); 
	     		area = decodeUnicode(area);//地区 
	     		break; 
		 case 5:region = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		 		region = decodeUnicode(region);//省份 
		 		break; 
		 case 7:city = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		        city = decodeUnicode(city);//城市
		        break;
		 case 9:county = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		 		county = decodeUnicode(county);//区
		 		break; 
		 case 11:isp = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		 		isp = decodeUnicode(isp);//ISP(网络运营商)
		 		break; 
	     } 
     }
    String str="国家："+country+"，区域："+area+"，省份："+region+"，城市："+city+"，地区："+county+"，网络运营商："+isp;
    return str;
  }
  return null;
 }
 */
 
	
	/**
	* 通过ip地址获取  ip的所属地区  格式：国家，区域，省份，城市，地区，网络运营商
	* @param content
	*            请求的参数 格式为：name=xxx&pwd=xxx
	* @param encoding
	*            服务器端请求编码。如GBK,UTF-8等
	* @return
	* @throws UnsupportedEncodingException    
	*/
	private String getAddresses(String content, String encodingString)
	throws UnsupportedEncodingException {
	// 这里调用pconline的接口
	String urlStr = "http://apis.baidu.com/apistore/iplookupservice/iplookup";
	String returnStr = null;
	returnStr=request(urlStr, content);
	if (returnStr != null) {
	String[] temp = returnStr.split(",");
	if(temp.length<3){
	 return "0";//无效IP，局域网测试
	}
	  String country = "";
	  String area = ""; 
	  String region = ""; 
	  String city = ""; 
	  String county = ""; 
	  String isp = ""; 
	  for(int i=0;i<temp.length;i++){
		     switch(i){ 
		     case 3:country = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		     		country = decodeUnicode(country);//国家 
		     		break; 
		     case 4:area = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		     		area = decodeUnicode(area);//地区 
		     		break; 
			 case 5:region = (temp[i].split(":"))[1].replaceAll("\"", ""); 
			 		region = decodeUnicode(region);//省份 
			 		break; 
			 case 6:city = (temp[i].split(":"))[1].replaceAll("\"", ""); 
			        city = decodeUnicode(city);//城市
			        break;
	//		 case 7:county = "";// (temp[i].split(":"))[1].replaceAll("\"", "")
	//		 		county = "";//区
	//		 		break; 
			 case 7:isp = (temp[i].split(":"))[1].replaceAll("\"", ""); 
			 		isp = decodeUnicode(isp);//ISP(网络运营商)
			 		break; 
		     } 
	  }
	 String str="国家："+country+"，区域："+area+"，省份："+region+"，城市："+city+"，地区："+county+"，网络运营商："+isp;
	 return str;
	}
	return null;
	}
 
	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	private static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey",  "a1b820dc6da7192823fb17d704f387eb");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
//	        e.printStackTrace();
	        System.out.println("获取ip信息：" + e.getLocalizedMessage());
	    }
	    return result;
	}
	
 /**
  * @param urlStr
  *            请求的地址
  * @param content
  *            请求的参数 格式为：name=xxx&pwd=xxx
  * @param encoding
  *            服务器端请求编码。如GBK,UTF-8等
  * @return
  */
 private String getResult(String urlStr, String content, String encoding) {
  URL url = null;
  HttpURLConnection connection = null;
  try {
   url = new URL(urlStr);
   connection = (HttpURLConnection) url.openConnection();// 新建连接实例
   connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
   connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
   connection.setDoOutput(true);// 是否打开输出流 true|false
   connection.setDoInput(true);// 是否打开输入流true|false
   connection.setRequestMethod("POST");// 提交方法POST|GET
   connection.setUseCaches(false);// 是否缓存true|false
   connection.connect();// 打开连接端口
   DataOutputStream out = new DataOutputStream(connection
     .getOutputStream());// 打开输出流往对端服务器写数据
   out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
   out.flush();// 刷新
   out.close();// 关闭输出流
   BufferedReader reader = new BufferedReader(new InputStreamReader(
     connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
   // ,以BufferedReader流来读取
   StringBuffer buffer = new StringBuffer();
   String line = "";
   while ((line = reader.readLine()) != null) {
    buffer.append(line);
   }
   reader.close();
   return buffer.toString();
  } catch (IOException e) {
//   e.printStackTrace();
	  System.out.println("获取ip所属地区失败：" + e.getLocalizedMessage());
  } finally {
   if (connection != null) {
    connection.disconnect();// 关闭连接
   }
  }
  return null;
 }
 /**
  * unicode 转换成 中文
  */
 private static String decodeUnicode(String theString) {
  char aChar;
  int len = theString.length();
  StringBuffer outBuffer = new StringBuffer(len);
  for (int x = 0; x < len;) {
   aChar = theString.charAt(x++);
   if (aChar == '\\') {
    aChar = theString.charAt(x++);
    if (aChar == 'u') {
     int value = 0;
     for (int i = 0; i < 4; i++) {
      aChar = theString.charAt(x++);
      switch (aChar) {
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
       value = (value << 4) + aChar - '0';
       break;
      case 'a':
      case 'b':
      case 'c':
      case 'd':
      case 'e':
      case 'f':
       value = (value << 4) + 10 + aChar - 'a';
       break;
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
       value = (value << 4) + 10 + aChar - 'A';
       break;
      default:
       throw new IllegalArgumentException(
         "Malformed      encoding.");
      }
     }
     outBuffer.append((char) value);
    } else {
     if (aChar == 't') {
      aChar = '\t';
     } else if (aChar == 'r') {
      aChar = '\r';
     } else if (aChar == 'n') {
      aChar = '\n';
     } else if (aChar == 'f') {
      aChar = '\f';
     }
     outBuffer.append(aChar);
    }
   } else {
    outBuffer.append(aChar);
   }
  }
  return outBuffer.toString();
 }
 
 // 测试
/* private static void main(String[] args) {
  AddressUtils addressUtils = new AddressUtils();
  String ip = "182.150.176.72";
  String address = "";
  try {
   address = addressUtils.getAddresses("ip="+ip, "utf-8");
  } catch (UnsupportedEncodingException e) {
   e.printStackTrace();
  }
  System.out.println(address);
 }*/
}