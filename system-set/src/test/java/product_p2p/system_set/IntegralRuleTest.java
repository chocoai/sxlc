
package product_p2p.system_set; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import cn.springmvc.model.CreditorEntity;
import cn.springmvc.service.impl.CreditorServiceImpl;
import cn.springmvc.service.impl.IntegralRuleServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class IntegralRuleTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(IntegralRuleTest.class);
 	@Resource(name="integralRuleServiceImpl")
	private IntegralRuleServiceImpl integralRuleServiceImpl;
	@Test  
	public void test() {  
		//查询积分规则
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("membertype",1);
//		map. put("type",2);
//		integralRuleServiceImpl.findAllIntegralRule(map);
		//根据id删除积分规则
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("membertype",1);
//		map. put("type",2);
//		map. put("id",1);
//		integralRuleServiceImpl.deleteIntegralRule(map);
		//修改邀请注册积分规则
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("membertype",1);
//		map. put("regPoints",3);//邀请注册赠送积分个数
//		map. put("signPoints",3);//签名赠送积分
//		integralRuleServiceImpl.insetRegPointsIntegralRule(map);
		//添加  邀请注册积分规则
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("membertype",1);
//		map. put("regPoints",2);//邀请注册赠送积分个数
//		map. put("signPoints",3);//签名赠送积分
//		integralRuleServiceImpl.insetRegPointsIntegralRule(map);
		//添加 项目投资 \债权转让投资\ 充值 \  借款 积分 
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("membertype",1);
//		map. put("type",2);
//		map. put("id",1);
//		map. put("amount",3);//金额
//		map. put("points",3);//对应积分
//		integralRuleServiceImpl.insertIntegralRule(map);
	}
	 
}

