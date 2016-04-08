
package product_p2p.system_set; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.service.impl.CreditorServiceImpl;
import cn.springmvc.service.impl.SystemSetServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class SystemSetTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(SystemSetTest.class);
 	@Resource(name="systemSetServiceImpl")
	private SystemSetServiceImpl systemSetServiceImpl;
	@Test  
	public void test() {  
		//查询系统设置
//		systemSetServiceImpl.findSystemSet();
		//修改系统设置
//		SystemSetEntity systemSetEntity =new SystemSetEntity();
//		systemSetEntity.setAutoBackRate(2);
//		systemSetEntity.setEndDateRemind(2);
//		systemSetEntity.setExpirationReminderSet(2);
//		systemSetEntity.setOverdueInsteadDay(2);
//		systemSetEntity.setRedpacketsRateMax(2);
//		systemSetEntity.setRiskMarginRateMax(2);
//		systemSetEntity.setRiskMarginType(2);
//		systemSetServiceImpl.updateSystemSet(systemSetEntity);
//		//添加系统设置
//		SystemSetEntity systemSetEntity =new SystemSetEntity();
//		systemSetEntity.setAutoBackRate(1);
//		systemSetEntity.setEndDateRemind(1);
//		systemSetEntity.setExpirationReminderSet(1);
//		systemSetEntity.setOverdueInsteadDay(1);
//		systemSetEntity.setRedpacketsRateMax(1);
//		systemSetEntity.setRiskMarginRateMax(1);
//		systemSetEntity.setRiskMarginType(1);
//		systemSetServiceImpl.insertSystemSet(systemSetEntity);
		//查询平台设置
		systemSetServiceImpl.findSystemInfoSet();
		//添加平台设置
//		SystemInfoSetEntity systemInfoSetEntity =new SystemInfoSetEntity();
//		systemInfoSetEntity.setBackgroundLogo("1");
//		systemInfoSetEntity.setExpectYearRate("1");
//		systemInfoSetEntity.setForgroundLogo("1");
//		systemInfoSetEntity.setIntegralAlias("1");
//		systemInfoSetEntity.setqQGroupCode("1");
//		systemInfoSetEntity.setqQGroupQRCode("1");
//		systemInfoSetEntity.setRiskReserveFund("1");
//		systemInfoSetEntity.setSwitchStatu(1);
//		systemInfoSetEntity.setSystemHotline("1");
//		systemInfoSetEntity.setSystemName("1");
//		systemInfoSetEntity.setSystemOfficeHours("1");
//		systemInfoSetEntity.setWeChatCode("1");
//		systemInfoSetEntity.setWeChatQRCode("1");
//		systemInfoSetEntity.setWeiboName("1");
//		systemInfoSetEntity.setWeiboQRCode("1");
//		systemInfoSetEntity.setWelcomeTitle("1");
//		systemSetServiceImpl.insertSystemInfoSet(systemInfoSetEntity);
		//修改平台设置
//		SystemInfoSetEntity systemInfoSetEntity =new SystemInfoSetEntity();
//		systemInfoSetEntity.setBackgroundLogo("2");
//		systemInfoSetEntity.setExpectYearRate("2");
//		systemInfoSetEntity.setForgroundLogo("2");
//		systemInfoSetEntity.setIntegralAlias("2");
//		systemInfoSetEntity.setqQGroupCode("1");
//		systemInfoSetEntity.setqQGroupQRCode("1");
//		systemInfoSetEntity.setRiskReserveFund("1");
//		systemInfoSetEntity.setSwitchStatu(1);
//		systemInfoSetEntity.setSystemHotline("1");
//		systemInfoSetEntity.setSystemName("1");
//		systemInfoSetEntity.setSystemOfficeHours("1");
//		systemInfoSetEntity.setWeChatCode("1");
//		systemInfoSetEntity.setWeChatQRCode("2");
//		systemInfoSetEntity.setWeiboName("1");
//		systemInfoSetEntity.setWeiboQRCode("1");
//		systemInfoSetEntity.setWelcomeTitle("1");
//		systemSetServiceImpl.updateSystemInfoSet(systemInfoSetEntity);
		
		
	}
	 
}

