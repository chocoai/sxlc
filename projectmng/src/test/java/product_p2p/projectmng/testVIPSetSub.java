package product_p2p.projectmng;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.model.VIPSetSubEntity;
import cn.springmvc.service.impl.VIPSetSubServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testVIPSetSub extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testVIPSetSub.class);
 	@Resource(name="vipSetSubServiceImpl")
	private VIPSetSubServiceImpl vipSetSubServiceImpl; 
	@Test  
	public void testinsert() {  
		VIPSetSubEntity vipSetSubentity = new VIPSetSubEntity(); 
		vipSetSubentity.setBorrowMngRate(77);
		vipSetSubentity.setInvestMngRate(3);
		vipSetSubentity.setVipTerm(2);
		vipSetSubentity.setVipAttest(12); 
		vipSetSubentity.setVipInvest(1000);
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		vipSetSubServiceImpl.insertVIPSetSub(vipSetSubentity,entityLog,sIpInfo);  
	}  
	@Test  
	public void testdelete() {   
		vipSetSubServiceImpl.deleteVIPSetSub(0);  
	} 
 
	@Test  
	public void testselecAll() { 
		VIPSetSubEntity	vipSetSubentity=vipSetSubServiceImpl.selectVIPSetSubList(); 
		System.out.print(vipSetSubentity);
	} 
}