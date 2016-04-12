package product_p2p.aboutus_mng;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.springmvc.model.FrequentlyAskedQuestionsEntity; 
import cn.springmvc.service.impl.FrequentlyAskedQuestionsServiceImpl;
import cn.springmvc.service.impl.FrequentlyAskedQuestionsServiceImpl;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testFrequentlyAskedQuestions extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testFrequentlyAskedQuestions.class);
 	@Resource(name="frequentlyAskedQuestionsServiceImpl")
	private FrequentlyAskedQuestionsServiceImpl frequentlyAskedQuestionsServiceImpl; 
	@Test  
	public void testinsert() {  
		FrequentlyAskedQuestionsEntity frequentlyAskedQuestionsEntity = new FrequentlyAskedQuestionsEntity();
		frequentlyAskedQuestionsEntity.setId(7); 
		frequentlyAskedQuestionsEntity.setOptId(1); 
		frequentlyAskedQuestionsEntity.setContent("ds");
		frequentlyAskedQuestionsServiceImpl.insertFrequentlyAskedQuestions(frequentlyAskedQuestionsEntity);  
	}  
	@Test  
	public void testdelete() {   
		frequentlyAskedQuestionsServiceImpl.deleteFrequentlyAskedQuestions(7);  
	} 
	@Test  
	public void testupdatestatu() {
		FrequentlyAskedQuestionsEntity frequentlyAskedQuestionsEntity = new FrequentlyAskedQuestionsEntity();
		frequentlyAskedQuestionsEntity.setId(7); 
		frequentlyAskedQuestionsEntity.setStatu(0);  
		frequentlyAskedQuestionsServiceImpl.updateFrequentlyAskedQuestionsStatuByID(frequentlyAskedQuestionsEntity);  
	} 
	@Test  
	public void testselecAll() {
		FrequentlyAskedQuestionsEntity frequentlyAskedQuestionsEntity = new FrequentlyAskedQuestionsEntity();
		frequentlyAskedQuestionsEntity=frequentlyAskedQuestionsServiceImpl.selectFrequentlyAskedQuestionsList(1);   
	} 
}
