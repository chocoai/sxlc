package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.SystemAgreementSetEntity;
import  cn.springmvc.service.impl.SystemAgreementSetServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testSystemAgreementSet extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testSystemAgreementSet.class);
 	@Resource(name="systemAgreementSetServiceImpl")
	private SystemAgreementSetServiceImpl systemAgreementSetServiceImpl; 
	@Test  
	public void testinsert() {  
		SystemAgreementSetEntity systemAgreementSeteentity = new SystemAgreementSetEntity();
		systemAgreementSeteentity.setAgreementDetail("aa");
		systemAgreementSeteentity.setAgreementStatu(1);
		systemAgreementSeteentity.setAgreementType(11); 
		systemAgreementSetServiceImpl.insertSystemAgreementSet(systemAgreementSeteentity);  
	} 
	@Test  
	public void testupdate() {  
		SystemAgreementSetEntity systemAgreementSeteentity = new SystemAgreementSetEntity();
		systemAgreementSeteentity.setAgreementDetail("asass");
		systemAgreementSeteentity.setAgreementStatu(1);
		systemAgreementSeteentity.setAgreementType(11); 
		systemAgreementSetServiceImpl.updateSystemAgreementSetByType(systemAgreementSeteentity);  
	} 
	@Test  
	public void testdelete() {   
		systemAgreementSetServiceImpl.deleteSystemAgreementSetByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		SystemAgreementSetEntity systemAgreementSeteentity = new SystemAgreementSetEntity();
		systemAgreementSeteentity.setAgreementDetail("aa");
		systemAgreementSeteentity.setAgreementStatu(0);
		systemAgreementSeteentity.setAgreementType(11); 
		systemAgreementSetServiceImpl.updateSystemAgreementSetStatuByType(systemAgreementSeteentity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("agreementType", 1);
		pageEntity.setMap(map);
		List<SystemAgreementSetEntity>  list=systemAgreementSetServiceImpl.selectSystemAgreementSetListpage(pageEntity);   
	} 
	@Test  
	public void selectSystemAgreementSetBytype() {
		SystemAgreementSetEntity systemAgreementSeteentity = null; 
		systemAgreementSetServiceImpl.selectSystemAgreementSetBytype(11);  
	} 
}
