package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ProjectPurposeEntity;
import  cn.springmvc.service.impl.ProjectPurposeServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProjectPurpose extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProjectPurpose.class);
 	@Resource(name="projectPurposeServiceImpl")
	private ProjectPurposeServiceImpl projectPurposeServiceImpl; 
	@Test  
	public void testinsert() {  
		ProjectPurposeEntity projectPurposeentity = new ProjectPurposeEntity();
		projectPurposeentity.setAmount("100"); 
		projectPurposeentity.setId(2);
		projectPurposeServiceImpl.insertProjectPurpose(projectPurposeentity);  
	} 
}
	 
