
package product_p2p.system_set; 

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import cn.springmvc.model.InterestMngFeeEntity;
import cn.springmvc.service.impl.CreditorServiceImpl;
import cn.springmvc.service.impl.InterestMngFeeServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class InterestMngFeeTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(InterestMngFeeTest.class);
 	@Resource(name="interestMngFeeServiceImpl")
	private InterestMngFeeServiceImpl interestMngFeeServiceImpl;
	@Test  
	public void test() {  
		//查询利息管理费
//		interestMngFeeServiceImpl.selectAllInterestMngFee();
		//添加利息管理费
//		InterestMngFeeEntity interestMngFeeEntity= new InterestMngFeeEntity();
//		interestMngFeeEntity.setPriceDatum(2);
//		interestMngFeeEntity.setProjectType(2);
		//interestMngFeeEntity.setStatu(1);
//		interestMngFeeServiceImpl.insertInterestMngFee(interestMngFeeEntity);
		//修改利息管理费
//		InterestMngFeeEntity interestMngFeeEntity= new InterestMngFeeEntity();
//		interestMngFeeEntity.setPriceDatum(2);
//		interestMngFeeEntity.setProjectType(2);
//		interestMngFeeEntity.setStatu(1);
//		interestMngFeeServiceImpl.updateInterestMngFee(interestMngFeeEntity);
	}
	 
}

