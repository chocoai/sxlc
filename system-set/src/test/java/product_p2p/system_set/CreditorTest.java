
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
import cn.springmvc.service.impl.CreditorServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class CreditorTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(CreditorTest.class);
 	@Resource(name="creditorServiceImpl")
	private CreditorServiceImpl creditorServiceImpl;
	@Test  
	public void test() {  
		//查询债权转让设置 为null证明未设置
		//System.out.println(creditorServiceImpl.findAllCreditor());
		//添加债权转让设置
//		CreditorEntity creditorEntity =new CreditorEntity();
//		creditorEntity.setCheckType(1);
//		creditorEntity.setHoldDay(1);
//		creditorEntity.setInterestDay(1);
//		creditorEntity.setInterestType(1);
//		creditorEntity.setLoanType(1);
//		creditorEntity.setMngFee(1);
//		creditorEntity.setMngType(1);
//		creditorEntity.setRangeDay(1);
		//creditorServiceImpl.inserCreditor(creditorEntity);
		//修改债权转让设置
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("interestType",3);
//		map. put("type",3);
//		creditorServiceImpl.updateCreditor(map);
	}
	 
}

