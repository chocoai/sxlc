package product_p2p.kit.datatrans;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
  		if(date == null && !"".equals(date)){
  			return sResult;
  		}
  		SimpleDateFormat datafFormat = new SimpleDateFormat("yyyy-MM-dd");
  		sResult = datafFormat.format(date);
  		return sResult;
  	}
	
  	/**
  	 * date to string 格式：2016-04-06 10-48-52
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
  	public static String DateToString3(Date date){
  		String sResult = "";
  		if(date == null){
  			return sResult;
  		}
  		SimpleDateFormat datafFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  		sResult = datafFormat.format(date);
  		return sResult;
  	}
  	/**
  	 * 将字符串转换为日期
  	 * TODO
  	 * 创建日期：2016-5-23上午10:34:51
  	 * 修改日期：
  	 * 作者：pengran
  	 * @param
  	 * return Date
  	 */
	public static Date  StringToDate(String str){
  		Date sDate = new Date();
  		if(str == null && !"".equals(str)){
  			return sDate;
  		}
  		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  		try {
			sDate = dateFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return sDate;
  	} 
  	/**
  	 * 计算两个时间相差几个月又几天
  	* getDateSubMonthDay	计算两个时间相差几个月又几天 
  	* TODO(描述)
  	* @author 张友  
  	* * @Title: getDateSubMonthDay 
  	* @Description: TODO 
  	* @param  ttStart				开始时间
  	* @param  ttEnd					结束时间
  	* @param  iResult				返回值	 	iType：0 iResult[0]	几天	 
  	* 										iType：1 iResult[0]	相差几个月	iResult[1] 相差几天
  	* 										iType：2 iResult[0]	相差几年	iResult[1] 相差几月
  	* @param  iType 				计算类型	0：天	 1：月天	 2：年月
  	* @return void 返回类型 
  	* @date 2016-5-10 下午2:42:42
  	* @throws
  	 */
	public static void getDateSubMonthDay(Date ttStart,Date ttEnd,long[] iResult,int iType){
		if(ttStart == null || ttEnd == null || ttStart.after(ttEnd) || iResult == null || iResult.length<2){
			return;
		}
		
		Date date = null;
		long long1 = ttStart.getTime();
		long long2 = ttEnd.getTime();
		
		if(iType == 0){
			// 天
			// 计算相差天数
			iResult[0] = (long2-long1)/(1000*60*60*24);
		}else if(iType == 1){
			// 月天
			
			// 计算相差月数
			iResult[0] = (long2-long1)/(1000*60*60*24*30);
			date = ttStart;
			// 开始时间 加上月份差
			date.setMonth(date.getMonth()+(int)iResult[0]);
			if(date.before(ttEnd)){
				// 存在剩余天数
				long1 = date.getTime();
				iResult[1] = (long2-long1)/(1000*60*60*24);
			}else if(date.after(ttEnd)){
				// 大于结束时间
				iResult[0] = iResult[0] - 1;
				date = ttStart;
				date.setMonth(date.getMonth()+(int)iResult[0]);
				long1 = date.getTime();
				iResult[1] = (long2-long1)/(1000*60*60*24);
			}else{
				
			}
		}else{
			// 年月
			
			// 计算相差年数
			iResult[0] = (long2-long1)/(1000*60*60*24*360);
			date = ttStart;
			// 开始时间加上时间差
			date.setYear(date.getYear() + (int)iResult[0]);
			if(date.before(ttEnd)){
				// 存在剩余月份
				long1 = date.getTime();
				iResult[1] = (long2-long1)/(1000*60*60*24*30);
				date.setMonth(date.getMonth() + (int)iResult[1]);
				if(date.after(ttEnd)){
					iResult[1] = iResult[1]-1;
				}
			}else if(date.after(ttEnd)){
				// 大于结束时间
				iResult[0] = iResult[0] - 1;
				date = ttStart;
				date.setYear(date.getYear() + (int)iResult[0]);
				long1 = date.getTime();
				iResult[1] = (long2-long1)/(1000*60*60*24*30);
				date.setMonth(date.getMonth() + (int)iResult[1]);
				if(date.after(ttEnd)){
					iResult[1] = iResult[1]-1;
				}
			}else{
				
			}
		}
	}
	
  	
  	 /**
	  * 根据时间倒推出时间   年月日时分秒
	  * @param timg 开始时间
	  * @param year 年
	  * @param month 月
	  * @param day 日
	  * 用法：timeBackTotime2("2014-10-12 11:12:10",1,2,2); 为‘正数’为计算此时间后的时间，‘负数’为此时间前的时间
	  */
	 public static String timeBackTotime(String timg,int year,int month,int day){
		 
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String str=timg;
	        Date dt;
	        String reStr="";
			try {
				dt = sdf.parse(str);
		        Calendar rightNow = Calendar.getInstance();
		        rightNow.setTime(dt);
		        rightNow.add(Calendar.YEAR,year);//日期减1年
		        rightNow.add(Calendar.MONTH,month);//日期加3个月
		        rightNow.add(Calendar.DAY_OF_YEAR,day);//日期加10天
		        Date dt1=rightNow.getTime();
		        reStr = sdf.format(dt1);				
			} catch (ParseException e) {
				e.printStackTrace();
			}
    
			return reStr;
	 }
}
