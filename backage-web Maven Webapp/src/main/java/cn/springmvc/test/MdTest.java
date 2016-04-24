package cn.springmvc.test;

import java.security.MessageDigest;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class MdTest {
	
	@Test
	public void testt(){
		System.out.println(checkParam());
	}

	public boolean checkParam(){
		//获取请求中的参数
		Map<String, String> newMap = new HashMap<>();
		newMap.put("mngName", "测试");
		newMap.put("startTime", null);
		newMap.put("atartTima", "a");
		newMap.put("sign", "8AE8DC5BF720963585787F0728772130");//B6F988DECBB785577F579E3C9223C473
		String sign = newMap.get("sign");
		newMap.remove("sign");
		if(sign == null){//没有sign或者sign多个  验证失败
			return true;
		}else{
			String paramCheckCode = "";
			Map<String, String> sortMap = new TreeMap<String, String>(
			new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			sortMap.putAll(newMap);
			for(String key : sortMap.keySet()){
				paramCheckCode += key+sortMap.get(key);
			}
			String result = MD5(paramCheckCode);
			if(result != null && result.equals(sign)){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
