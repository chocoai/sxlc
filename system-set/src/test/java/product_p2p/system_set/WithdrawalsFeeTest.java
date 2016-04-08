
package product_p2p.system_set; 
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import cn.springmvc.model.WithdrawalsFeeEntity;
import cn.springmvc.service.impl.FinancialSettingServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class WithdrawalsFeeTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(WithdrawalsFeeTest.class);
 	@Resource(name="financialSettingServiceImpl")
	private FinancialSettingServiceImpl financialSettingServiceImpl;
	@Test  
	public void test() {  
		WithdrawalsFeeEntity wEntity = new WithdrawalsFeeEntity();
		wEntity.setCheck_Type(3);
		wEntity.setWithdrawal_Fee_Pingtai(3);
		wEntity.setWithdrawal_Fee_Third(3);
		wEntity.setWithdrawal_Type_Third(3);
		//测试修改 提现手续费
//		financialSettingServiceImpl.updateWithdrawalsFee(wEntity); 
		//测试提现手续费查询
		//financialSettingServiceImpl.selectWithdrawalsFee();
		//测试查询提现手续费是否已存在
		//financialSettingServiceImpl.findWithdrawalsFee();
		//测试添加提现手续费
		//financialSettingServiceImpl.insertWithdrawalsFee(wEntity);
	}
	 
}

