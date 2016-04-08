package product_p2p.aboutus_mng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import cn.springmvc.service.impl.MobilePhoneBindingServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testPhonebinding extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testPhonebinding.class);
 	@Resource(name="mobilePhoneBindingServiceImpl")
	private MobilePhoneBindingServiceImpl mobilePhoneBindingServiceImpl; 
  
 	@Test  
	public void testPhoneBing() {
 	 //原有手机号
     String phoneold = "13550095458";
     //session中的手机号
     String phoneSession="13550095458";
     //sesion中存的发送手机验证码的手机号
 	 String VerCodePhone = "13550095451";
 	 //要新绑定的手机号
 	 String NewPhone = "13550095451";
     //session中的图形验证码
     String codesesion="2125";
     //获取的图形验证码
     String code="2015";
     int memberType=0;
     int result = -1;
     if(!phoneold.equals(phoneSession)){
    	 result = -2;//原有手机号输入错误
     }
     if(!code.equals(codesesion)){
    	 result = -2;//图形验证码输入错误
     }
     if(!VerCodePhone.equals(NewPhone)){
    	 result = -3;//手机号与发送手机验证码的手机号不符
     } 
     Map<String,Object> map =new HashMap<String,Object>();
     map.put("keys", "");
     map.put("personalPhone", "333");
     result = mobilePhoneBindingServiceImpl.selectPhoneIsExist(map);
     //手机号码不存在
     if( result == 0 ) {
    	 Map<String,Object> map2 =new HashMap<String,Object>();
    	 map2.put("keys", "333");
    	 map2.put("personalPhone", "444");
    	 map2.put("personalID", 1);
    	 //个人会员
    	 if(memberType == 0){
    		 result = mobilePhoneBindingServiceImpl.updatepersonPhone(map2);
    	 }else{
    		 result = mobilePhoneBindingServiceImpl.updatecompanyPhone(map2);
    	 }
     }

 	 System.out.print(result); 
	} 
	 
}
