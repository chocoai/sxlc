package product_p2p.kit.datatrans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampAndString {
	
	/**
	 * Timestamp 转成字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @param value
	 * @return
	 */
  	public static String TimestampToString(Timestamp value){
  		String sResult = "";
  		if(value==null){
  			return sResult;
  		}
  		sResult = value.toString();
  		int iIndex = sResult.indexOf(".");
  		sResult = sResult.substring(0,iIndex);
  		return sResult;
  	}
  	
  	/**
  	 * Timestamp 转成字符串，格式：yyyy-MM-dd
  	 * @param value
  	 * @return
  	 */
  	public static String TimestampToString2(Timestamp value){
  		String sResult = "";
  		if(value==null){
  			return sResult;
  		}
  		sResult = value.toString();
  		int iIndex = sResult.indexOf(" ");
  		sResult = sResult.substring(0,iIndex);
  		return sResult;
  	}
  	
  	/**
  	 * date to string 格式：2016-04-06
  	 * TODO
  	 * 创建日期：2016-4-6上午10:47:53
  	 * 修改日期：
  	 * 作者：pengran
  	 * @param
  	 * return String
  	 */
  	public static String DateToString(Date date){
  		String sResult = "";
  		if(date == null){
  			return sResult;
  		}
  		SimpleDateFormat datafFormat = new SimpleDateFormat("yyyy-MM-dd");
  		sResult = datafFormat.format(date);
  		return sResult;
  	}
	
  	/**
  	 * date to string 格式：2016-04-06 10:48:52
  	 * TODO
  	 * 创建日期：2016-4-6上午10:47:53
  	 * 修改日期：
  	 * 作者：pengran
  	 * @param
  	 * return String
  	 */
  	public static String DateToString2(Date date){
  		String sResult = "";
  		if(date == null){
  			return sResult;
  		}
  		SimpleDateFormat datafFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
  		sResult = datafFormat.format(date);
  		return sResult;
  	}
}
