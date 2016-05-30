package product_p2p.kit.datatrans;

import java.util.Random;

public class IntegerAndString {
	
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
     * 长整形转化为 string 已经除了10000  4位小数
     * @author zhy
     * @param l
     * @return
     */
    public static String LongToString2(long l){
//    	l = l /100;
    	String sResult = "0.00";
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
    	sResult = sResult.substring(0, sResult.length()-2);
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
				}else if(sInfos[1].length()<4){
					while(sInfos[1].length()<4){
						sInfos[1] = sInfos[1] + "0";
					}
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
//    	while(sDiv.length()<2){
//    		sDiv = "0" + sDiv;
//    	}
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
	  * 随机码
	  * @param length  位数（6位）
	  * @return
	  * @author panchangqin
	  */
	public static String getRandomNum(int length){
		try{
			if (length <= 0){
				return "";
			}
			Random r = new Random();
			StringBuffer result = new StringBuffer();
			for (int i = 0; i < length; i++){
				result.append(Integer.toString(r.nextInt(10)));
			}
			return result.toString();
		}
		catch (Exception ex){
			ex.printStackTrace();
			return null;
		}
	}	
	   
    
}
