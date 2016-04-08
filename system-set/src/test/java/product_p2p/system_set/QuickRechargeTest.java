
package product_p2p.system_set; 
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.WithdrawalsFeeEntity;
import cn.springmvc.service.impl.FinancialSettingServiceImpl;
import cn.springmvc.service.impl.QuickRechargeFeeServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class QuickRechargeTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(QuickRechargeTest.class);
 	@Resource(name="quickRechargeFeeServiceImpl")
	private QuickRechargeFeeServiceImpl quickRechargeFeeServiceImpl;
	@Test  
	public void test() {  
		QuickRechargeFeeEntity wEntity = new QuickRechargeFeeEntity();
		//快捷充值手续费查询测试
		//quickRechargeFeeServiceImpl.findAllQuickRechargeFee();
		//修改
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("paymentMemberType",(int)1);
//		map. put("feePaymentMethod",(int)1);
//		map. put("rev",(int)-1);
//		System.out.println(quickRechargeFeeServiceImpl.updateQuickRechargeFee(map));
	}
	 
}

