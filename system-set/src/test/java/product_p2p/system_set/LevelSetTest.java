
package product_p2p.system_set; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.CreditLevelEntity;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.service.impl.CreditorServiceImpl;
import cn.springmvc.service.impl.LevelSetServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class LevelSetTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(LevelSetTest.class);
 	@Resource(name="levelSetServiceImpl")
	private LevelSetServiceImpl levelSetServiceImpl;
	@Test  
	public void test() {  
		//查询会员等级
		PageEntity page = new PageEntity();
		page.setPageNum(1);
		page.setPageSize(1);
//		levelSetServiceImpl.selectAllCreditLevel(page);
//		levelSetServiceImpl.selectAllMemberLevel(page);
		//添加会员等级
		CreditLevelEntity creditLevelEntity= new CreditLevelEntity();
		creditLevelEntity.setCreditScoreMax(3);
		creditLevelEntity.setCreditScoreMin(1);
		creditLevelEntity.setId(1);
		creditLevelEntity.setLevelDetail("1");
		creditLevelEntity.setLevelMark("1");
//		levelSetServiceImpl.insertCreditLevel(creditLevelEntity);
		//修改会员等级
		levelSetServiceImpl.updateCreditLevelById(creditLevelEntity);
	}
	 
}

