package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.SafetyCertificationSetEntity;
import  cn.springmvc.service.impl.SafetyCertificationSetServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testSafetyCertificationSet extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testSafetyCertificationSet.class);
 	@Resource(name="safetyCertificationSetServiceImpl")
	private SafetyCertificationSetServiceImpl safetyCertificationSetServiceImpl; 
	@Test  
	public void testinsert() {  
		SafetyCertificationSetEntity safetyCertificationSetentity = new SafetyCertificationSetEntity();
		safetyCertificationSetentity.setId(2);
		safetyCertificationSetentity.setAdminId(1);
		safetyCertificationSetentity.setCertificationAddTime("2015-12-25 00:00:00");
		safetyCertificationSetentity.setCertificationEndTime("2015-12-25 00:00:00");
		safetyCertificationSetentity.setCertificationPicture("aaa");
		safetyCertificationSetentity.setCertificationUrl("sdfsd");
		safetyCertificationSetentity.setCertificationStartTime("2015-12-25 00:00:00"); 
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		safetyCertificationSetServiceImpl.insertSafetyCertificationSet(safetyCertificationSetentity,entityLog,sIpInfo);  
	} 
	@Test  
	public void testupdate() {  
		SafetyCertificationSetEntity safetyCertificationSetentity = new SafetyCertificationSetEntity();
		safetyCertificationSetentity.setId(2);
		safetyCertificationSetentity.setAdminId(1);
		safetyCertificationSetentity.setCertificationAddTime("2015-12-25 00:00:00");
		safetyCertificationSetentity.setCertificationEndTime("2015-12-25 00:00:00");
		safetyCertificationSetentity.setCertificationPicture("aaasdfsfsfsdf");
		safetyCertificationSetentity.setCertificationStartTime("2015-12-25 00:00:00"); 
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		safetyCertificationSetServiceImpl.updateSafetyCertificationSetByID(safetyCertificationSetentity,entityLog,sIpInfo);  
	} 
	@Test  
	public void testdelete() {   
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		safetyCertificationSetServiceImpl.deleteSafetyCertificationSetByID(1,entityLog,sIpInfo);  
	} 
	@Test  
	public void testupdatestatu() {
		SafetyCertificationSetEntity safetyCertificationSetentity = new SafetyCertificationSetEntity();
		safetyCertificationSetentity.setId(2);
		safetyCertificationSetentity.setAdminId(1);
		safetyCertificationSetentity.setCertificationAddTime("2015-12-25 00:00:00");
		safetyCertificationSetentity.setCertificationEndTime("2015-12-25 00:00:00");
		safetyCertificationSetentity.setCertificationPicture("aaa");
		safetyCertificationSetentity.setCertificationStartTime("2015-12-25 00:00:00"); 
		safetyCertificationSetentity.setStatu(0);
		safetyCertificationSetServiceImpl.updateSafetyCertificationSetStatuByID(safetyCertificationSetentity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("endTime", "2017-12-28 00:00:00");
		map.put("startTime", "2015-11-28 00:00:00");
		map.put("statu", -1);
		pageEntity.setMap(map);
		List<SafetyCertificationSetEntity>  list=safetyCertificationSetServiceImpl.selectSafetyCertificationSetListpage(pageEntity);   
	} 
	@Test  
	public void selectSafetyCertificationSetbyID() {
	
		SafetyCertificationSetEntity list=safetyCertificationSetServiceImpl.selectSafetyCertificationSetbyID(2);   
	    System.out.print(list);
	} 
}
