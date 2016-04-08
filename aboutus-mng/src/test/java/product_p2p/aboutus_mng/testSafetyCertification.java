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

import cn.springmvc.model.SafetyCertificationEntity;
import cn.springmvc.service.impl.SafetyCertificationServiceImpl; 

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testSafetyCertification extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testSafetyCertification.class);
 	@Resource(name="safetyCertificationServiceImpl")
	private SafetyCertificationServiceImpl safetyCertificationServiceImpl; 
	@Test  
	public void testinsert() {  
		SafetyCertificationEntity safetyCertificationentity = new SafetyCertificationEntity();
		safetyCertificationentity.setId(17); 
		safetyCertificationentity.setStatu(1); 
		safetyCertificationentity.setUrl("ss");
		safetyCertificationentity.setTitle("ss");
		safetyCertificationentity.setOptId(1); 
		safetyCertificationentity.setLogo("dd");
		safetyCertificationServiceImpl.insertSafetyCertification(safetyCertificationentity);  
	} 
	@Test  
	public void testupdate() {  
		SafetyCertificationEntity safetyCertificationentity = new SafetyCertificationEntity();
		safetyCertificationentity.setId(6); 
		safetyCertificationentity.setUrl("ss");
		safetyCertificationServiceImpl.updateSafetyCertificationByID(safetyCertificationentity);  
	} 
	@Test  
	public void testdelete() {   
		safetyCertificationServiceImpl.deleteSafetyCertificationByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		SafetyCertificationEntity safetyCertificationentity = new SafetyCertificationEntity();
		safetyCertificationentity.setId(7); 
		safetyCertificationServiceImpl.updateSafetyCertificationStatuByID(safetyCertificationentity);  
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
		List<SafetyCertificationEntity>  list=safetyCertificationServiceImpl.selectSafetyCertificationList(pageEntity);   
	} 
}
