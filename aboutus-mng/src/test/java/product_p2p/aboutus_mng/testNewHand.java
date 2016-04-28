package product_p2p.aboutus_mng;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.springmvc.model.NewHandEntity; 
import cn.springmvc.service.impl.NewHandServiceImpl;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testNewHand extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testNewHand.class);
 	@Resource(name="newHandServiceImpl")
	private NewHandServiceImpl newHandServiceImpl; 
	@Test  
	public void testinsert() {  
		NewHandEntity newHandEntity = new NewHandEntity();
		newHandEntity.setContent("dd");
		newHandServiceImpl.insertNewHand(newHandEntity);  
	}  
	@Test  
	public void testdelete() {   
		newHandServiceImpl.deleteNewHand();  
	}  
	@Test  
	public void testselecAll() {
		NewHandEntity newHandEntity = new NewHandEntity();
		newHandEntity=newHandServiceImpl.selectNewHandList();   
	} 
}
