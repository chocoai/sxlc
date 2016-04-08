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

import com.github.pagehelper.PageInfo;

import cn.springmvc.model.PartnersEntity; 
import cn.springmvc.service.impl.PartnersServiceImpl; 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testPartner extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testPartner.class);
 	@Resource(name="partnersServiceImpl")
	private PartnersServiceImpl partnersServiceImpl; 
	@Test  
	public void testinsert() {  
	 	PartnersEntity partner = new PartnersEntity();
		partner.setId(7);
		partner.setUrl("dfadf");
		partner.setIndexs(1);
		partner.setIntroduction("aa");
		partner.setLogo("22");
		partner.setName("sssdsdssssssssss");
		partner.setOptId(1);
		partner.setStatu(true);
		partnersServiceImpl.insertPartners(partner);  
	} 
	@Test  
	public void testupdate() {  
	 	PartnersEntity partner = new PartnersEntity();
		partner.setId(6);
		partner.setUrl("dfadf77");
		partner.setIndexs(1); 
		partner.setStatu(true);
		partnersServiceImpl.updatePartners(partner);  
	} 
	@Test  
	public void testdelete() {   
		partnersServiceImpl.deletePartners(3);  
	} 
	@Test  
	public void testupdatestatu() {
		PartnersEntity partner = new PartnersEntity();
		partner.setId(4); 
		partner.setStatu(false);
		partnersServiceImpl.updatePartnerStatuByID(partner);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "2015-12-29"); 
		map.put("statu", 1); 
		pageEntity.setMap(map);
		List<PartnersEntity>  list=partnersServiceImpl.selectPartnersList(pageEntity);   
	} 
}
