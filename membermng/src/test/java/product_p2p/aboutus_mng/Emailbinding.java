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

import cn.springmvc.service.impl.EmailBindingServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class Emailbinding extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(Emailbinding.class);
 	@Resource(name="emailBindingServiceImpl")
	private EmailBindingServiceImpl emailBindingServiceImpl; 
 	@Test  
	public void testEmailBing() {
 	 
     //sesion中存的发送验证码的邮箱
 	 String VerCodeEmail = "11@143.com";
 	 //要新绑定的邮箱
 	 String NewEmail = "11@143.com";
     //session中的图形验证码
     String codesesion="2125";
     //获取的图形验证码
     String code="2015";
     int memberType=0;
     int result = -1; 
     if(!code.equals(codesesion)){
    	 result = -2;//图形验证码输入错误
     }
     if(!VerCodeEmail.equals(NewEmail)){
    	 result = -3;//邮箱与发送验证码的邮箱不符
     } 
     Map<String,Object> map =new HashMap<String,Object>();
     map.put("keys", "");
     map.put("personalEmail", "");
     result = emailBindingServiceImpl.selectEmailIsExist(map);
     //邮箱不存在
     if( result == 0 ) {
    	 Map<String,Object> map2 =new HashMap<String,Object>();
    	 map2.put("keys", "");
    	 map2.put("personalEmail", "");
    	 map2.put("personalID", "");
    	 //个人会员
    	 if(memberType == 0){
    		 result = emailBindingServiceImpl.updatepersonEmail(map2);
    	 }else{
    		 result = emailBindingServiceImpl.updatecompanyEmail(map2);
    	 }
     }
	} 
 	@Test  
	public void testupdateEmailBing() {
 	 //原有邮箱
     String emailold = "22@132.com";
     //session中的邮箱
     String emailSession="22@132.com";
     //sesion中存的发送验证码的邮箱
 	 String VerCodeEmail = "11@143.com";
 	 //要新绑定的邮箱
 	 String NewEmail = "11@143.com";
     //session中的图形验证码
     String codesesion="2125";
     //获取的图形验证码
     String code="2015";
     int memberType=0;
     int result = -1;
     if(!emailold.equals(emailSession)){
    	 result = -2;//原有邮箱输入错误
     }
     if(!code.equals(codesesion)){
    	 result = -2;//图形验证码输入错误
     }
     if(!VerCodeEmail.equals(NewEmail)){
    	 result = -3;//邮箱与发送验证码的邮箱不符
     } 
     Map<String,Object> map =new HashMap<String,Object>();
     map.put("keys", "");
     map.put("personalEmail", "444");
     result = emailBindingServiceImpl.selectEmailIsExist(map);
     //邮箱不存在
     if( result == 0 ) {
    	 Map<String,Object> map2 =new HashMap<String,Object>();
    	 map2.put("keys", "333");
    	 map2.put("personalEmail", "22222");
    	 map2.put("personalID", 1);
    	 //个人会员
    	 if(memberType == 0){
    		 result = emailBindingServiceImpl.updatepersonEmail(map2);
    	 }else{
    		 result = emailBindingServiceImpl.updatecompanyEmail(map2);
    	 }
     }
     System.out.print(result); 
	}  
}
