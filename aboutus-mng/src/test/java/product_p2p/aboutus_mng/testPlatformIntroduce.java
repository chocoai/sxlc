package product_p2p.aboutus_mng;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.springmvc.model.PlatformIntroduceEntity; 
import cn.springmvc.service.impl.PlatformIntroduceServiceImpl;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testPlatformIntroduce extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testPlatformIntroduce.class);
 	@Resource(name="platformIntroduceServiceImpl")
	private PlatformIntroduceServiceImpl platformIntroduceServiceImpl; 
	@Test  
	public void testinsert() {  
		PlatformIntroduceEntity platformIntroduceEntity = new PlatformIntroduceEntity();
		platformIntroduceEntity.setContent("dd");
		platformIntroduceServiceImpl.insertPlatformIntroduce(platformIntroduceEntity);  
	}  
	@Test  
	public void testdelete() {   
		platformIntroduceServiceImpl.deletePlatformIntroduce(7);  
	}  
	@Test  
	public void testselecAll() {
		PlatformIntroduceEntity platformIntroduceEntity = new PlatformIntroduceEntity();
		platformIntroduceEntity=platformIntroduceServiceImpl.selectPlatformIntroduceList();   
	} 
}
