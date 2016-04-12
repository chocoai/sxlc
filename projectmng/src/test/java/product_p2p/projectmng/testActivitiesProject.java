package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ActivitiesProjectEntity;
import  cn.springmvc.service.impl.ActivitiesProjectServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testActivitiesProject extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testActivitiesProject.class);
 	@Resource(name="activitiesProjectServiceImpl")
	private ActivitiesProjectServiceImpl activitiesProjectServiceImpl; 
	@Test  
	public void testinsert() {  
		ActivitiesProjectEntity activitiesProjectentity = new ActivitiesProjectEntity();
		activitiesProjectentity.setApName("3434");
		activitiesProjectentity.setRoleID(7);
		activitiesProjectentity.setId(10);
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		activitiesProjectServiceImpl.insertActivitiesProject(activitiesProjectentity,entityLog,sIpInfo);   
	} 
	@Test  
	public void testupdate() {  
		ActivitiesProjectEntity activitiesProjectentity = new ActivitiesProjectEntity();
		activitiesProjectentity.setApName("sd23we22222");
		activitiesProjectentity.setRoleID(3); 
		activitiesProjectentity.setStatu(0);
		activitiesProjectentity.setId(9);
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		activitiesProjectServiceImpl.updateActivitiesProjectByID(activitiesProjectentity,entityLog,sIpInfo);  
	} 
	@Test  
	public void testdelete() { 
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		activitiesProjectServiceImpl.deleteActivitiesProjectByID(7,"sd23we22222",entityLog,sIpInfo);  
	} 
	@Test  
	public void testupdatestatu() {
		ActivitiesProjectEntity activitiesProjectentity = new ActivitiesProjectEntity(); 
		activitiesProjectentity.setRoleID(1); 
		activitiesProjectentity.setId(8);
		activitiesProjectentity.setStatu(0);
		activitiesProjectServiceImpl.updateActivitiesProjectStatuByID(activitiesProjectentity);  
	} 
	@Test  
	public void testselecAll() { 
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("apName", "11");
		map.put("statu", -1);
		pageEntity.setMap(map);
		List<ActivitiesProjectEntity>  list=activitiesProjectServiceImpl.selectActivitiesProjectListpage(pageEntity);   
	} 
	@Test  
	public void testselectActivitiesProjectByID() {  
		ActivitiesProjectEntity   list=activitiesProjectServiceImpl.selectActivitiesProjectByID(8); 
		System.out.print(list);
	} 
}
