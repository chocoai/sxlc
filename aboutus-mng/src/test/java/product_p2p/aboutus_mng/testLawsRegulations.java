package product_p2p.aboutus_mng;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.springmvc.model.LawsRegulationsEntity; 
import cn.springmvc.service.impl.LawsRegulationsServiceImpl;
import cn.springmvc.service.impl.LawsRegulationsServiceImpl;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testLawsRegulations extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testLawsRegulations.class);
 	@Resource(name="lawsRegulationsServiceImpl")
	private LawsRegulationsServiceImpl lawsRegulationsServiceImpl; 
	@Test  
	public void testinsert() {  
		LawsRegulationsEntity lawsRegulationsEntity = new LawsRegulationsEntity();
		lawsRegulationsEntity.setId(7); 
		lawsRegulationsEntity.setOptId(1); 
		lawsRegulationsEntity.setContent("ds");
		lawsRegulationsServiceImpl.insertLawsRegulations(lawsRegulationsEntity);  
	}  
	@Test  
	public void testdelete() {   
		lawsRegulationsServiceImpl.deleteLawsRegulations(7);  
	} 
	@Test  
	public void testupdatestatu() {
		LawsRegulationsEntity lawsRegulationsEntity = new LawsRegulationsEntity();
		lawsRegulationsEntity.setId(7); 
		lawsRegulationsEntity.setStatu(0);  
		lawsRegulationsServiceImpl.updateLawsRegulationsStatuByID(lawsRegulationsEntity);  
	} 
	@Test  
	public void testselecAll() {
		LawsRegulationsEntity lawsRegulationsEntity = new LawsRegulationsEntity();
		lawsRegulationsEntity=lawsRegulationsServiceImpl.selectLawsRegulationsList(1);   
	} 
}
