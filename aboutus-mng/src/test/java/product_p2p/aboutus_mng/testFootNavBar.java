package product_p2p.aboutus_mng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.FootNavBarEntity;
import cn.springmvc.service.impl.FootNavBarServiceImpl; 

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testFootNavBar extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testFootNavBar.class);
 	@Resource(name="footNavBarServiceImpl")
	private FootNavBarServiceImpl footNavBarServiceImpl; 
	@Test  
	public void testinsert() {  
		FootNavBarEntity footNavBarentity = new FootNavBarEntity();
		footNavBarentity.setId(17); 
		footNavBarentity.setStatu(1);
		footNavBarentity.setName("22");
		footNavBarentity.setUrl("ss");
		footNavBarentity.setTitle("ss444");
		footNavBarentity.setOptId(1);
		footNavBarentity.setTypeId(7);
		footNavBarServiceImpl.insertFootNavBar(footNavBarentity);  
	} 
	@Test  
	public void testupdate() {  
		FootNavBarEntity footNavBarentity = new FootNavBarEntity();
		footNavBarentity.setId(6); 
		footNavBarentity.setUrl("ss");
		footNavBarServiceImpl.updateFootNavBarByID(footNavBarentity);  
	} 
	@Test  
	public void testdelete() {   
		footNavBarServiceImpl.deleteFootNavBarByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		FootNavBarEntity footNavBarentity = new FootNavBarEntity();
		footNavBarentity.setId(7); 
		footNavBarServiceImpl.updateFootNavBarStatuByID(footNavBarentity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "11");
		map.put("statu", 1);
		pageEntity.setMap(map);
		List<FootNavBarEntity>  list=footNavBarServiceImpl.selectFootNavBarListpage(pageEntity);   
	} 
}
