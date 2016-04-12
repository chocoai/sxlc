package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ProjectTypeReplyEntity;
import  cn.springmvc.service.impl.ProjectTypeReplyServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProjectTypeReply extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProjectTypeReply.class);
 	@Resource(name="projectTypeReplyServiceImpl")
	private ProjectTypeReplyServiceImpl projectTypeReplyServiceImpl; 
	@Test  
	public void testinsert() {  
		ProjectTypeReplyEntity projectTypeReplyentity = new ProjectTypeReplyEntity();
		projectTypeReplyentity.setContent("44444");
		projectTypeReplyentity.setProjectType(7);  
		projectTypeReplyServiceImpl.insertProjectTypeReply(projectTypeReplyentity);  
	} 
	@Test  
	public void testupdate() {  
		ProjectTypeReplyEntity projectTypeReplyentity = new ProjectTypeReplyEntity();
		projectTypeReplyentity.setContent("aaaaaaaaaa");
		projectTypeReplyentity.setProjectType(7); 
		projectTypeReplyentity.setPtIndex(1);   
		projectTypeReplyServiceImpl.updateProjectTypeReplyByID(projectTypeReplyentity);  
	} 
	@Test  
	public void testdelete() {   
		projectTypeReplyServiceImpl.deleteProjectTypeReplyByID(6);  
	}  
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10); 
		List<ProjectTypeReplyEntity>  list=projectTypeReplyServiceImpl.selectProjectTypeReplyListpage(pageEntity);   
	} 
}
