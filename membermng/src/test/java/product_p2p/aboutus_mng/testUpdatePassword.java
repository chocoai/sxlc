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

import cn.springmvc.service.impl.UpdatePasswordServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testUpdatePassword extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testUpdatePassword.class);
 	@Resource(name="updatePasswordServiceImpl")
	private UpdatePasswordServiceImpl updatePasswordServiceImpl; 
  
 	@Test  
	public void testPhoneBing() {
 	 //原有密码
     String passwordold = "Asss";  
 	 //要新绑定的密码
 	 String Newpassword = "1355";
     //session中的图形验证码
     String codesesion="2125";
     //获取的图形验证码
     String code="2015";
     
     int result = -1;
      
     if(!code.equals(codesesion)){
    	 result = -2;//图形验证码输入错误
     }
   
     Map<String,Object> map =new HashMap<String,Object>();
     map.put("keys", "22");
     map.put("memberPwd", passwordold);
     map.put("memberID", 2);
     result = updatePasswordServiceImpl.checkPassword(map);
     //原始密码输入正确
     if( result == 1 ) {
    	 Map<String,Object> map2 =new HashMap<String,Object>();
    	 map2.put("keys", "22");
    	 map2.put("memberPwd", Newpassword);
    	 map2.put("memberID", 2);
    	 //个人会员
    	 result = updatePasswordServiceImpl.updatepersonPassword(map2);
    	 
      }
     System.out.print(result);
	}  
}
