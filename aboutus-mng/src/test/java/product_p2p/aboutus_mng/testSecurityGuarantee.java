package product_p2p.aboutus_mng;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.springmvc.model.SecurityGuaranteeEntity;  
import cn.springmvc.service.impl.SecurityGuaranteeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testSecurityGuarantee extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testSecurityGuarantee.class);
 	@Resource(name="securityGuaranteeServiceImpl")
	private SecurityGuaranteeServiceImpl securityGuaranteeServiceImpl; 
	@Test  
	public void testinsert() {  
		SecurityGuaranteeEntity securityGuaranteeEntity = new SecurityGuaranteeEntity();
		securityGuaranteeEntity.setId(7); 
		securityGuaranteeEntity.setOptId(1); 
		securityGuaranteeEntity.setContent("ds");
		securityGuaranteeServiceImpl.insertSecurityGuarantee(securityGuaranteeEntity);  
	}  
	@Test  
	public void testdelete() {   
		securityGuaranteeServiceImpl.deleteSecurityGuarantee(7);  
	} 
	@Test  
	public void testupdatestatu() {
		SecurityGuaranteeEntity securityGuaranteeEntity = new SecurityGuaranteeEntity();
		securityGuaranteeEntity.setId(7); 
		securityGuaranteeEntity.setStatu(0);  
		securityGuaranteeServiceImpl.updateSecurityGuaranteeStatuByID(securityGuaranteeEntity);  
	} 
	@Test  
	public void testselecAll() {
		SecurityGuaranteeEntity securityGuaranteeEntity = new SecurityGuaranteeEntity();
		securityGuaranteeEntity=securityGuaranteeServiceImpl.selectSecurityGuaranteeList(1);   
	} 
}
