package product_p2p.aboutus_mng;

import java.util.ArrayList;
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
import cn.membermng.model.InvestIncomeEntity;
import cn.membermng.model.MyinvestEntity;
import cn.springmvc.service.MyinvestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testMyInvest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testMyInvest.class);
 	@Resource(name="myinvestServiceImpl")
	private MyinvestService myinvestService; 
  
 	@Test  
	public void selectMyinvestCollect() { 
 		PageEntity pageEntity =new PageEntity();
 		Map<String,Object> map =new HashMap<String,Object>();
 		pageEntity.setMap(map);
 		List<MyinvestEntity> selectMyinvestCollect=new ArrayList<MyinvestEntity>(); 
 		MyinvestEntity MyinvestEntity =new MyinvestEntity();
 		MyinvestEntity.setInvestAmount(200);
 		selectMyinvestCollect.add(MyinvestEntity);
 		System.out.print(selectMyinvestCollect);
 		selectMyinvestCollect=myinvestService.selectMyinvestCollect(pageEntity);
 		
	} 
 	@Test  
	public void selectMyinvestSettled() { 
 		PageEntity pageEntity =new PageEntity();
 		Map<String,Object> map =new HashMap<String,Object>();
 		pageEntity.setMap(map);
 		List<MyinvestEntity> selectMyinvestCollect=null;
 		selectMyinvestCollect=myinvestService.selectMyinvestSettled(pageEntity);
	} 
 	@Test  
	public void selectMyinvesting() { 
 		PageEntity pageEntity =new PageEntity();
 		Map<String,Object> map =new HashMap<String,Object>();
 		pageEntity.setMap(map);
 		List<MyinvestEntity> selectMyinvestCollect=null;
 		selectMyinvestCollect=myinvestService.selectMyinvesting(pageEntity);
	} 
 	@Test  
	public void selectRealincome() { 
 		PageEntity pageEntity =new PageEntity();
 		Map<String,Object> map =new HashMap<String,Object>();
 		pageEntity.setMap(map);
 		List<InvestIncomeEntity> selectMyinvestCollect=null;
 		selectMyinvestCollect=myinvestService.selectRealincome(pageEntity);
	} 
 	@Test  
	public void selectInvestIncome() { 
 		PageEntity pageEntity =new PageEntity();
 		Map<String,Object> map =new HashMap<String,Object>();
 		pageEntity.setMap(map);
 		List<InvestIncomeEntity> selectMyinvestCollect=null;
 		selectMyinvestCollect=myinvestService.selectInvestIncome(pageEntity);
	} 
  
}
