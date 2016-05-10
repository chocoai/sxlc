package cn.springmvc.dao.impl.sms;   
  
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮箱权限
 * @author tanke_oyp
 *
 */
public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }   
        
}   