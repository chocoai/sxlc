package product_p2p.projectmng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ProjectTypeDatumEntity;
import  cn.springmvc.service.impl.ProjectTypeDatumServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProjectTypeDatum extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProjectTypeDatum.class);
 	@Resource(name="projectTypeDatumServiceImpl")
	private ProjectTypeDatumServiceImpl projectTypeDatumServiceImpl; 
	@Test  
	public void testinsert() {  
		List<ProjectTypeDatumEntity> projectTypeList = new ArrayList<ProjectTypeDatumEntity>();
		ProjectTypeDatumEntity projectTypeDatumEntity=new ProjectTypeDatumEntity();
		projectTypeDatumEntity.setAttestType(1);
		projectTypeDatumEntity.setAttestTypeID(6);
		projectTypeDatumEntity.setProjectType(7);
		projectTypeList.add(projectTypeDatumEntity);
		projectTypeDatumServiceImpl.insertProjectTypeDatum(projectTypeList,9);  
	} 
	 
	@Test  
	public void testselecAll() { 
		int optTypeID=9;
		ProjectTypeDatumEntity projectTypeDatumEntity=new ProjectTypeDatumEntity();
		projectTypeDatumEntity.setAttestType(1);
		projectTypeDatumEntity.setAttestTypeID(1);
		projectTypeDatumEntity.setProjectType(7);
		List<ProjectTypeDatumEntity>  list=projectTypeDatumServiceImpl.selectMemberAttestTypeList(projectTypeDatumEntity);   
	} 
}
