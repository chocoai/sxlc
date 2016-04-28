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

import cn.springmvc.model.PartnersEntity;
import cn.springmvc.model.PlatformAnnouncementEntity;
import cn.springmvc.service.impl.PartnersServiceImpl;
import cn.springmvc.service.impl.PlatformAnnouncementServiceImpl;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testPlatformAnnouncement extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testPartner.class);
 	@Resource(name="platformAnnouncementServiceImpl")
	private PlatformAnnouncementServiceImpl platformAnnouncementServiceImpl; 
	@Test  
	public void testinsert() {  
		PlatformAnnouncementEntity platformAnnouncementEntity = new PlatformAnnouncementEntity();
		platformAnnouncementEntity.setId(9);
		platformAnnouncementEntity.setContent("dfadf");
		platformAnnouncementEntity.setOptId(1);
		platformAnnouncementEntity.setStatu(1);  
		platformAnnouncementEntity.setTitle("qq");
		platformAnnouncementServiceImpl.insertPlatform(platformAnnouncementEntity);  
	} 
	@Test  
	public void testupdate() {  
		PlatformAnnouncementEntity platformAnnouncementEntity = new PlatformAnnouncementEntity();
		platformAnnouncementEntity.setId(7);
		platformAnnouncementEntity.setContent("dfadf"); 
		platformAnnouncementServiceImpl.updatePlatform(platformAnnouncementEntity);  
	} 
	@Test  
	public void testdelete() {   
		platformAnnouncementServiceImpl.deletePlatform(7);  
	} 
	@Test  
	public void testupdatestatu() {
		PlatformAnnouncementEntity platformAnnouncementEntity = new PlatformAnnouncementEntity();
		platformAnnouncementEntity.setId(7); 
		platformAnnouncementEntity.setStatu(0);  
		platformAnnouncementServiceImpl.updatePlatformStatuByID(platformAnnouncementEntity);  
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
		List<PlatformAnnouncementEntity>  list=platformAnnouncementServiceImpl.selectPlatformList(pageEntity);   
	} 
}