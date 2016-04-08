package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ProjectTypeTermEntity;
import  cn.springmvc.service.impl.ProjectTypeTermServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProjectTypeTerm extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProjectTypeTerm.class);
 	@Resource(name="projectTypeTermServiceImpl")
	private ProjectTypeTermServiceImpl projectTypeTermServiceImpl; 
	@Test  
	public void testinsert() {  
		ProjectTypeTermEntity projectTypeTermentity = new ProjectTypeTermEntity();
		projectTypeTermentity.setMaxDaytime(10);
		projectTypeTermentity.setMinDaytime(5);
		projectTypeTermentity.setProjectType(7);
		projectTypeTermentity.setUnit(1);
		projectTypeTermServiceImpl.insertProjectTypeTerm(projectTypeTermentity);  
	} 
	@Test  
	public void testselecAll() {
		ProjectTypeTermEntity projectTypeTermentity = new ProjectTypeTermEntity();
		projectTypeTermentity.setMaxDaytime(6);
		projectTypeTermentity.setMinDaytime(5);
		projectTypeTermentity.setProjectType(1);
		projectTypeTermentity.setUnit(1);
		ProjectTypeTermEntity   list=projectTypeTermServiceImpl.selectProjectTypeTermById(projectTypeTermentity);   
	} 
}
