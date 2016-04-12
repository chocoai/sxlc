package product_p2p.projectmng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ProjectPurposeSetEntity;
import  cn.springmvc.service.impl.ProjectPurposeSetServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import product_p2p.kit.optrecord.InsertAdminLogEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProjectPurposeSet extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProjectPurposeSet.class);
 	@Resource(name="projectPurposeSetServiceImpl")
	private ProjectPurposeSetServiceImpl projectPurposeSetServiceImpl; 
	@Test  
	public void testinsert() {  
		ProjectPurposeSetEntity projectPurposeSetentity = new ProjectPurposeSetEntity();
		projectPurposeSetentity.setOptionStatu(1);
		projectPurposeSetentity.setOptionType(2);
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		projectPurposeSetServiceImpl.insertProjectPurposeSet(projectPurposeSetentity,entityLog,sIpInfo);  
	} 
	@Test  
	public void testupdate() {  
		List<Integer> ls = new ArrayList<Integer>();
	    for(int i = 1;i < 2;i++){
	        ls.add(i);
	    }
	    InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		projectPurposeSetServiceImpl.updateProjectPurposeSetByType(ls,entityLog,sIpInfo);  
	} 
	@Test  
	public void testdelete() {   
		projectPurposeSetServiceImpl.deleteProjectPurposeSetByType(1);  
	}  
	@Test  
	public void testselecAll() { 
		List<ProjectPurposeSetEntity>  list=projectPurposeSetServiceImpl.selectProjectPurposeSetListpage(); 
		System.out.print(list);
	} 
}
