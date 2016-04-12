package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ProjectTypeGuideEntity;
import  cn.springmvc.service.impl.ProjectTypeGuideServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProjectTypeGuide extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProjectTypeGuide.class);
 	@Resource(name="projectTypeGuideServiceImpl")
	private ProjectTypeGuideServiceImpl projectTypeGuideServiceImpl; 
	@Test  
	public void testinsert() {  
		ProjectTypeGuideEntity projectTypeGuideentity = new ProjectTypeGuideEntity();
		projectTypeGuideentity.setContent("1111111sfdfsf");
		projectTypeGuideentity.setProjectType(7);  
		projectTypeGuideServiceImpl.insertProjectTypeGuide(projectTypeGuideentity);  
	} 
	@Test  
	public void testupdate() {  
		ProjectTypeGuideEntity projectTypeGuideentity = new ProjectTypeGuideEntity();
		projectTypeGuideentity.setContent("aaaaaaaaaa");
		projectTypeGuideentity.setProjectType(7); 
		projectTypeGuideentity.setPtIndex(1);   
		projectTypeGuideServiceImpl.updateProjectTypeGuideByID(projectTypeGuideentity);  
	} 
	@Test  
	public void testdelete() {   
		projectTypeGuideServiceImpl.deleteProjectTypeGuideByID(6);  
	}  
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10); 
		List<ProjectTypeGuideEntity>  list=projectTypeGuideServiceImpl.selectProjectTypeGuideListpage(pageEntity);   
	} 
}
