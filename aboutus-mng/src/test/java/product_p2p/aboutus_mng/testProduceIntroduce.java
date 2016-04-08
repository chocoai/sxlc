package product_p2p.aboutus_mng;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.springmvc.model.ProductIntroduceEntity; 
import cn.springmvc.service.impl.ProductIntroduceServiceImpl;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProduceIntroduce extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProduceIntroduce.class);
 	@Resource(name="productIntroduceServiceImpl")
	private ProductIntroduceServiceImpl productIntroduceServiceImpl; 
	@Test  
	public void testinsert() {  
		ProductIntroduceEntity productIntroduceEntity = new ProductIntroduceEntity();
		productIntroduceEntity.setId(7); 
		productIntroduceEntity.setOptId(1); 
		productIntroduceEntity.setContent("ds");
		productIntroduceServiceImpl.insertProductIntroduce(productIntroduceEntity);  
	}  
	@Test  
	public void testdelete() {   
		productIntroduceServiceImpl.deleteProductIntroduce(7);  
	} 
	@Test  
	public void testupdatestatu() {
		ProductIntroduceEntity productIntroduceEntity = new ProductIntroduceEntity();
		productIntroduceEntity.setId(7); 
		productIntroduceEntity.setStatu(0);  
		productIntroduceServiceImpl.updateProductIntroduceStatuByID(productIntroduceEntity);  
	} 
	@Test  
	public void testselecAll() {
		ProductIntroduceEntity productIntroduceEntity = new ProductIntroduceEntity();
		productIntroduceEntity=productIntroduceServiceImpl.selectProductIntroduceList(1);   
	} 
}
