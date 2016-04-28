package cn.sxlc.account.manager.model;



/** 
* @Title: RepalyUtitls.java 
* @Package product_p2p.kit.StringUtil 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-1 下午2:03:19 
* @version V5.0 */
 

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;  


/** 
 * @author 刘利 
 * @Description: 生成还款计划
 * @since 
 * @date 2016-4-1 下午2:03:19  */

public class RepalyUtitls {
	 /**
		 * 计算每月还款、收款计划（总的）
		 * @param dateType 期限类型（3:年、2:月、1:日）
		 * @param moneyNum 投资金额
		 * @param yearRate 年化利率
		 * @param dateTime 期限时长
		 * @param typeSta 还款方式(0：等额本息，1：先息后本 2：到期还息本 3：等额本金)
		 * @param prodate 投标结束时间
		 * @author 谢强
		 * 
		 */
		public static List<LoanRepayEntity> getIncomePlan2(int dateType,String moneyNum,String yearRate,short dateTime,short typeSta,String prodate){
			double countMoney = 0;		//总金额（息本）
			double incomeMoney = 0;		//收益（利息）
			double moneyMonth = 0;		//每月收款额
			double monthMoney = 0;		//每月收息额
			
			//到期一次还本付息额=贷款本金×[1+年利率*1] (贷款期为一年) 
			//每月还息额= 贷款本金×年利率÷12
			//每月还款额=[贷款本金×月利率×（1+月利率）^还款月数（总）]÷[（1+月利率）^还款月数（总）－1]  等额本息
			//每月还款金额= （贷款本金/ 还款月数）+（本金 — 已归还本金累计额）×每月利率  等额本金
			//1.月利率 = 年利率/12
			//2.天利率 = 年利率/365
			double rateYear = Double.valueOf(yearRate)/100;				//年利率
			double rateMonth = Double.valueOf(yearRate)/100/12;		//月利率
			double rateDay = Double.valueOf(yearRate)/100/365;		//天利率
			
			ArrayList<LoanRepayEntity> stanArray = new ArrayList<LoanRepayEntity>();
			LoanRepayEntity stanEntity = null;
			
			//计息开始时间
			String date = RepalyUtitls.GetSysDate("yyyy-MM-dd", prodate, 0, 0,-1 );
			/*String date = RepalyUtitls.GetSysDate("yyyy-MM-dd", prodate, 0, 0,0 );*/
			
			if(dateType == 1 && typeSta == 2){//天
				countMoney = Double.valueOf(moneyNum) * (1+(rateDay * dateTime));	//总收益金额（本息）
				incomeMoney = Double.valueOf(moneyNum) * rateDay * dateTime;		//总收益（利息）
				String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, 0, 0,dateTime );
				
				stanEntity = new LoanRepayEntity(); 
				stanEntity.setCorpus(moneyNum);//本金
				stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(incomeMoney)));//利息
				stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(countMoney)));//本息
				stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
				stanArray.add(stanEntity); 
				
			}else if (dateType == 2) {//月
				if(typeSta == 0){//等额本息
					double benjin = 0.0;
					double mTotal = RepalyUtitls.StringToNum(moneyNum);
					double mLast = 0.00;
					for(int i=0;i<dateTime;i++){
						if(i == dateTime-1){
							stanEntity = new LoanRepayEntity();
							moneyMonth = (Double.valueOf(moneyNum) * rateMonth * Math.pow((1 + rateMonth),dateTime))/(Math.pow((1 + rateMonth),dateTime)-1);
							
							String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, 0, (i+1),0 );
							mLast = mTotal - benjin;
							
							stanEntity.setCorpus(RepalyUtitls.StringToString(String.valueOf(mLast)));
							stanEntity.setInterest(RepalyUtitls.StringToString(String.valueOf(moneyMonth-mLast)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth)));
							stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
							stanArray.add(stanEntity);
							
							incomeMoney = incomeMoney+RepalyUtitls.doubleRetain2(moneyMonth-mLast);
						}else{
							monthMoney = (Double.valueOf(moneyNum)-benjin) * rateMonth;		//每月利息
							stanEntity = new LoanRepayEntity();
							moneyMonth = (Double.valueOf(moneyNum) * rateMonth * Math.pow((1 + rateMonth),dateTime))/(Math.pow((1 + rateMonth),dateTime)-1);
							
							String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, 0, (i+1),0 );
							benjin = benjin+(RepalyUtitls.doubleRetain2(moneyMonth-monthMoney));
							
							stanEntity.setCorpus(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth-monthMoney)));
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth)));
							stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
							stanArray.add(stanEntity);
							
							incomeMoney = incomeMoney+RepalyUtitls.doubleRetain2(monthMoney);
						}
					}
					
				}else if (typeSta == 1) {//先息后本
					monthMoney = Double.valueOf(moneyNum) * rateMonth;		//每月利息
					incomeMoney = Double.valueOf(moneyNum) * rateMonth * dateTime;		//总利息
					
					for(int i=0;i<dateTime;i++){
						stanEntity = new LoanRepayEntity();
						if(i != dateTime-1){
							stanEntity.setCorpus("0.0");
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
						}else {
							stanEntity.setCorpus(moneyNum);
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney + Double.valueOf(moneyNum))));
						}
						
						String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, 0, (i+1),0 );
						
						stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
						stanArray.add(stanEntity);
					}
					
				}else if (typeSta == 2) {//到期息本
					countMoney = Double.valueOf(moneyNum) * (1+(rateMonth * dateTime));	//总代收金额（本息）
					incomeMoney = Double.valueOf(moneyNum) * rateMonth * dateTime;		//总收益（利息）
					
					stanEntity = new LoanRepayEntity();
					stanEntity.setCorpus(moneyNum);
					stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(incomeMoney)));
					stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(countMoney)));
					
					String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, 0, dateTime,0 );
					stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
					
					stanArray.add(stanEntity);
				}else if (typeSta == 3) {//等额本金
					double benjin = 0.0;
					double mTotal = RepalyUtitls.StringToNum(moneyNum);
					double mLast = 0.00;
					double monthlyPrincipal = Double.valueOf(moneyNum) / dateTime;;//月还款本金
					double grandTotal = 0;//累计金额
					for(int i=0;i<dateTime;i++){
						if(i == dateTime-1){
							stanEntity = new LoanRepayEntity();
							monthlyPrincipal = Double.valueOf(moneyNum) - grandTotal;
							
							mLast = mTotal - benjin;
							moneyMonth = (Double.valueOf(moneyNum) / dateTime) + ((Double.valueOf(moneyNum) - grandTotal) * rateMonth);
							String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, 0, (i+1),0 );
							
							stanEntity.setCorpus(RepalyUtitls.doubleRetain2(monthlyPrincipal).toString());//本金
							stanEntity.setInterest(RepalyUtitls.doubleRetain2(moneyMonth - monthlyPrincipal).toString());
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth)));
							stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
							stanArray.add(stanEntity);
							
							incomeMoney = incomeMoney+RepalyUtitls.doubleRetain2(moneyMonth-mLast);
						}else{
							//monthMoney = (Double.valueOf(moneyNum)-benjin) * rateMonth;		//每月利息
							//monthlyPrincipal += monthlyPrincipal;
							stanEntity = new LoanRepayEntity();
							moneyMonth = (Double.valueOf(moneyNum) / dateTime) + ((Double.valueOf(moneyNum) - grandTotal) * rateMonth);
							
							grandTotal += monthlyPrincipal;
							String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, 0, (i+1),0 );
							benjin = benjin+(RepalyUtitls.doubleRetain2(moneyMonth-monthMoney));
							
							stanEntity.setCorpus(RepalyUtitls.doubleRetain2(monthlyPrincipal).toString());//本金
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth - monthlyPrincipal)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth)));
							stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
							stanArray.add(stanEntity);
							
							incomeMoney = incomeMoney+RepalyUtitls.doubleRetain2(monthMoney);
						}
					}
				}
			}else if (dateType == 3) {//年
				short count = dateTime ;//* 12;
				if(typeSta == 0){//等额本息
					double benjin = 0.0;
					double mTotal = RepalyUtitls.StringToNum(moneyNum);
					double mLast = 0.00;
					
					for(int i=0;i<count;i++){	
						if(i == count - 1){
							monthMoney = (Double.valueOf(moneyNum)-benjin) * rateYear;		//每月利息
							stanEntity = new LoanRepayEntity();
							moneyMonth = (Double.valueOf(moneyNum) * rateYear * Math.pow((1 + rateYear),count))/(Math.pow((1 + rateYear),count)-1);
							mLast = mTotal - benjin;
							
							stanEntity.setCorpus(RepalyUtitls.StringToString(String.valueOf(mLast)));
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth)));
							
							String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, dateTime, 0,0 );
							stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
							stanArray.add(stanEntity);
							
							incomeMoney = incomeMoney+RepalyUtitls.doubleRetain2(RepalyUtitls.doubleRetain2(monthMoney));
							
						}else{
							monthMoney = (Double.valueOf(moneyNum)-benjin) * rateYear;		//每月利息
							stanEntity = new LoanRepayEntity();
							moneyMonth = (Double.valueOf(moneyNum) * rateYear * Math.pow((1 + rateYear),count))/(Math.pow((1 + rateYear),count)-1);
							benjin = benjin+(RepalyUtitls.doubleRetain2(moneyMonth-monthMoney));
							
							stanEntity.setCorpus(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth-monthMoney)));
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth)));
							
							String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, dateTime, 0,0 );
							stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
							stanArray.add(stanEntity);
							
							incomeMoney = incomeMoney+RepalyUtitls.doubleRetain2(RepalyUtitls.doubleRetain2(monthMoney));
						}
					}
					
				}else if (typeSta == 1) {//先息后本   
					monthMoney = Double.valueOf(moneyNum) * rateYear;		//每月利息
					incomeMoney = Double.valueOf(moneyNum) * Double.valueOf(yearRate)/100 * dateTime;		//总利息
					
					for(int i=0;i<count;i++){
						stanEntity = new LoanRepayEntity();
						if(i != count-1){
							stanEntity.setCorpus("0.0");
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
						}else {
							stanEntity.setCorpus(moneyNum);
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(monthMoney)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(Double.valueOf(moneyNum) + monthMoney)));
						}
						
						String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, (i+1), 0,0 );
						stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
						stanArray.add(stanEntity);
					}
				}else if (typeSta == 2) {//到期息本
					countMoney = Double.valueOf(moneyNum) * (1+(Double.valueOf(yearRate)/100 * dateTime));	//总代收金额（本息）
					incomeMoney = Double.valueOf(moneyNum) * Double.valueOf(yearRate)/100 * dateTime;		//总收益（利息）
					
					stanEntity = new LoanRepayEntity();
					stanEntity.setCorpus(moneyNum);
					stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(incomeMoney)));
					stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(countMoney)));
					
					String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, dateTime, 0,0 );
					stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
					
					stanArray.add(stanEntity);
				}else if (typeSta == 3) {//等额本金
					
					double benjin = 0.0;
					double mTotal = RepalyUtitls.StringToNum(moneyNum);
					double mLast = 0.00;
					double monthlyPrincipal = Double.valueOf(moneyNum) / dateTime;;//月还款本金
					double grandTotal = 0;//累计金额
					for(int i=0;i<dateTime;i++){
						if(i == dateTime-1){
							stanEntity = new LoanRepayEntity();
							monthlyPrincipal = Double.valueOf(moneyNum) - grandTotal;
							
							mLast = mTotal - benjin;
							moneyMonth = (Double.valueOf(moneyNum) / dateTime) + ((Double.valueOf(moneyNum) - grandTotal) * rateYear);
							String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, (i+1), 0,0 );
							
							stanEntity.setCorpus(RepalyUtitls.doubleRetain2(monthlyPrincipal).toString());//本金
							stanEntity.setInterest(RepalyUtitls.doubleRetain2(moneyMonth - monthlyPrincipal).toString());
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth)));
							stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
							stanArray.add(stanEntity);
							
							incomeMoney = incomeMoney+RepalyUtitls.doubleRetain2(moneyMonth-mLast);
						}else{
							//monthMoney = (Double.valueOf(moneyNum)-benjin) * rateMonth;		//每月利息
							//monthlyPrincipal += monthlyPrincipal;
							stanEntity = new LoanRepayEntity();
							moneyMonth = (Double.valueOf(moneyNum) / dateTime) + ((Double.valueOf(moneyNum) - grandTotal) * rateYear);
							grandTotal += monthlyPrincipal;
							String dateEnd = RepalyUtitls.GetSysDate("yyyy-MM-dd", date, (i+1), 0,0 );
							benjin = benjin+(RepalyUtitls.doubleRetain2(moneyMonth-monthMoney));
							
							stanEntity.setCorpus(RepalyUtitls.doubleRetain2(monthlyPrincipal).toString());//本金
							stanEntity.setInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth - monthlyPrincipal)));
							stanEntity.setEndCorpusInterest(Double.toString(RepalyUtitls.doubleRetain2(moneyMonth)));
							stanEntity.setRetrieveDateTime(dateEnd + " 23:59:59");
							stanArray.add(stanEntity);
							
							incomeMoney = incomeMoney+RepalyUtitls.doubleRetain2(monthMoney);
						}
					}
				}
			}
			/*request.setAttribute("incomeMoney", RepalyUtitls.doubleRetain2(incomeMoney));
			request.setAttribute("stanArray", stanArray);*/
			
			if(incomeMoney!=0){
				DecimalFormat df=new DecimalFormat(".####");
				String st=df.format(incomeMoney);
				incomeMoney=RepalyUtitls.StringToNum(st);	
				stanArray.get(0).setAllSy(incomeMoney);			
			}
			
			return stanArray;	
		}
		//得到N月后的日期  
	    public static   String   GetSysDate(String   format,   String   StrDate,   int   year,   int   month,int   day){     
	        Calendar   cal   =   Calendar.getInstance();     
	        SimpleDateFormat   sFmt   =   new   SimpleDateFormat(format);     
	        cal.setTime(sFmt.parse(   (StrDate),   new   ParsePosition(0)));     
	          
	        if   (day   !=   0)   {     
	        cal.add(cal.DATE,   day);     
	        }     
	        if   (month   !=   0)   {     
	        cal.add(cal.MONTH,   month);     
	        }     
	        if   (year   !=   0)   {     
	        cal.add(cal.YEAR,   year);     
	          
	        }     
	        return   sFmt.format(cal.getTime());     
	    }
	    //保留4位小数
	    public static Double doubleRetain2(double num){
	    	java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.0000");
	    	num=Double.parseDouble(myformat.format(num));//保留2为小数
	    	return num;
	    }
	  //将字符串转成可计算的值，并保留两位小数
	    public static Double StringToNum(String str){
	    	double num;
	    	if(str == null || str.equals("")){
	    		str = "0.0000";
	    	}
	    	java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.0000");
	    	num=Double.parseDouble(str);//装换为double类型
	    	num=Double.parseDouble(myformat.format(num));//保留2为小数
	    	/*System.out.println(num);*/
	    	return num;
	    }
	    /**
	     * string 转化为 int
	     * @author panchangqin
	     * @param value 需要转换的字符串
	     * @param iDefault  默认值
	     * @return
	     */
	    public static int StringToInt(String value,int iDefault){
	    	int iResult = iDefault;
	    	if(value == null || value.equals("")){
	    		return iResult;
	    	}
	    	try {
				iResult = Integer.valueOf(value).intValue();
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	return iResult;
	    }
	    
	    /**
	     * string 转化为 long
	     * @param value			需要转换的字符串
	     * @param lDefault		默认值
	     * @return
	     */
	    public static long StringToLong(String value,long lDefault){
	    	long iResult = lDefault;
	    	if(value == null || value.equals("")){
	    		return iResult;
	    	}
	    	try {
				iResult = Long.valueOf(value).longValue();
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	return iResult;
	    }
	    
	    /**
	     * 长整形转化为 string 已经除了10000  4位小数
	     * @author zhy
	     * @param l
	     * @return
	     */
	    public static String LongToString(long l){
	    	String sResult = "0.0000";
	    	String sPre = "";
	    	if(l<0){
	    		l = 0- l;
	    		sPre = "-";
	    	}
	    	long lDiv = 0;
	    	long lMod = 0;
	    	lMod = l % 10000;
	    	lDiv = l / 10000;
	    	String sMod = String.valueOf(lMod);
	    	while(sMod.length()<4){
	    		sMod ="0" + sMod ;
	    	}
	    	String sDiv = String.valueOf(lDiv);
	    	sResult = sPre + sDiv + "." + sMod;
	    	return sResult;
	    }
	    
	    /**
	     *  string 转化为   长整形 已经乘了10000 4位小数
	     * @param s
	     * @return
	     */
	    public static long StringToLong(String s){
	    	long lResult = 0;
	    	if(s== null || s.equals("")){
	    		return lResult;
	    	}
	    	s = s.replace(",", "");
	    	if(s.indexOf(".")<0){
	    		lResult = Long.parseLong(s)*10000;
	    		return lResult;
	    	}
	    	String[] sInfos = s.split("\\.");
	    	try {
				long l1 = Long.parseLong(sInfos[0]);
				lResult = l1*10000;
				if(sInfos.length>1){
					if(sInfos[1] == null || sInfos[1].equals("")){
						sInfos[1] = "00";
					}else if(sInfos[1].length()==1){
						sInfos[1] = sInfos[1] + "0";
					}else if(sInfos[1].length()>4){
						sInfos[1] = sInfos[1].substring(0, 4);
					}
					l1 = Long.parseLong(sInfos[1]);
					lResult = lResult + l1;
				}
			} catch (Exception e) {
				System.out.println("StringToLong:" + e.getLocalizedMessage());
			}
	    	return lResult;
	    }
	    
	    /**
	     * int转化为 string
	     * @param l
	     * @return
	     */
	    public static String IntToString(int i){
	    	String sResult = "0.0000";
	    	String sPre = "";
	    	if(i<0){
	    		i = 0- i;
	    		sPre = "-";
	    	}
	    	int lDiv = 0;
	    	int lMod = 0;
	    	lMod = i % 10000;
	    	lDiv = i / 10000;
	    	String sMod = String.valueOf(lMod);
	    	while(sMod.length()<4){
	    		sMod ="0" + sMod;
	    	}
	    	String sDiv = String.valueOf(lDiv);
//	    	while(sDiv.length()<2){
//	    		sDiv = "0" + sDiv;
//	    	}
	    	sResult = sPre+sDiv + "." + sMod;
	    	
	    	return sResult;
	    }
	    
	    /**
	     *  string 转化为   int
	     * @param s
	     * @return
	     */
	    public static int StringToInt(String s){
	    	int lResult = 0;
	    	if(s== null || s.equals("")){
	    		return lResult;
	    	}
	    	s = StringToString(s);
	    	s = s.replace(",", "");
	    	String[] sInfos = s.split("\\.");
	    	if(s.indexOf(".")<0){
	    		lResult = Integer.parseInt(s)*10000;
	    		return lResult;
	    	}
	    	try {
				int l1 = Integer.parseInt(sInfos[0]);
				lResult = l1*10000;
				if(sInfos.length>1){
					l1 = Integer.parseInt(sInfos[1]);
					lResult = lResult + l1;
				}
			} catch (Exception e) {
				System.out.println("StringToInt:" + e.getLocalizedMessage());
			}
	    	
	    	return lResult;
	    }
	    
	    /*
		 * String 转 String
		 * 将数字转换成货币格式 如：120.000 转成120.0000
		 */
	    public static String StringToString(String str){
	    	double num;
	    	String endStr = "";
	    	java.text.DecimalFormat myformat=new java.text.DecimalFormat("#0.0000");
	    	num=Double.parseDouble(str);//装换为double类型
	    	num=Double.parseDouble(myformat.format(num));//保留4为小数
	    	endStr = myformat.format(num);
	    	int index = endStr.indexOf(".");
	    	if(index>0){
	    		String str2 = endStr.substring(index+1, endStr.length());
	    		if(str2.length()<4){
	    			endStr = endStr+"0";
	    		}
	    	}else{
	    		endStr = endStr+".0000";
	    	}
	    	return endStr;
	    }
	    /**
		 * string 转化为    Timestamp
		 * @param sValue
		 * @return
		 */
		public static Timestamp StringToTimestamp(String sValue){
			Timestamp ttResult = null;
			
			try {
				ttResult = Timestamp.valueOf(sValue);
			} catch (Exception e) {
				ttResult = null;
			}
			
			return ttResult;
		}
}
