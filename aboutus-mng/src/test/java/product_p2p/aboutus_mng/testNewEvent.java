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

import cn.springmvc.model.NewEventEntity; 
import cn.springmvc.service.impl.NewEventServiceImpl;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testNewEvent extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testNewEvent.class);
 	@Resource(name="newEventServiceImpl")
	private NewEventServiceImpl newEventServiceImpl; 
	@Test  
	public void testinsert() {  
		NewEventEntity newEventEntity = new NewEventEntity();
		newEventEntity.setId(9);
		newEventEntity.setContent("dfa"); 
		newEventEntity.setOptId(1);  
		newEventEntity.setTitle("3333"); 
		newEventServiceImpl.insertNewEvent(newEventEntity);  
	} 
	@Test  
	public void testupdate() {  
		NewEventEntity newEventEntity = new NewEventEntity();
		newEventEntity.setId(7);
		newEventEntity.setContent("dfa"); 
		newEventEntity.setOptId(1);   
		newEventServiceImpl.updateNewEventByID(newEventEntity);  
	} 
	@Test  
	public void testdelete() {   
		newEventServiceImpl.deleteNewEventByID(7);  
	} 
	@Test  
	public void testupdatestatu() {
		NewEventEntity newEventEntity = new NewEventEntity();
		newEventEntity.setId(7);
		newEventEntity.setContent("dfa"); 
		newEventEntity.setOptId(1); 
		newEventServiceImpl.updateNewEventStatuByID(newEventEntity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Title", "2015-12-29"); 
		map.put("statu", 1); 
		pageEntity.setMap(map); 
		List<NewEventEntity>  list=newEventServiceImpl.selectNewEventListpage(pageEntity);   
	} 
}
