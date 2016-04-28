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

import cn.springmvc.model.FootNavBarTypeEntity;
import cn.springmvc.service.impl.FootNavBarTypeServiceImpl; 

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testFootNavBarType extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testFootNavBarType.class);
 	@Resource(name="footNavBarTypeServiceImpl")
	private FootNavBarTypeServiceImpl footNavBarTypeServiceImpl; 
	@Test  
	public void testinsert() {  
		FootNavBarTypeEntity footNavBarTypeentity = new FootNavBarTypeEntity();
		footNavBarTypeentity.setId(8); 
		footNavBarTypeentity.setStatu(1);
		footNavBarTypeentity.setName("22");
		footNavBarTypeentity.setUrl("ss");
		footNavBarTypeServiceImpl.insertFootNavBarType(footNavBarTypeentity);  
	} 
	@Test  
	public void testupdate() {  
		FootNavBarTypeEntity footNavBarTypeentity = new FootNavBarTypeEntity();
		footNavBarTypeentity.setId(6); 
		footNavBarTypeentity.setUrl("ss");
		footNavBarTypeServiceImpl.updateFootNavBarTypeByID(footNavBarTypeentity);  
	} 
	@Test  
	public void testdelete() {   
		footNavBarTypeServiceImpl.deleteFootNavBarTypeByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		FootNavBarTypeEntity footNavBarTypeentity = new FootNavBarTypeEntity();
		footNavBarTypeentity.setId(7); 
		footNavBarTypeServiceImpl.updateFootNavBarTypeStatuByID(footNavBarTypeentity);  
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
		List<FootNavBarTypeEntity>  list=footNavBarTypeServiceImpl.selectFootNavBarTypeListpage(pageEntity);   
	} 
}
