
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
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.service.impl.CreditorServiceImpl;
import cn.springmvc.service.impl.OverdueServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class OverdueTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(OverdueTest.class);
 	@Resource(name="overdueServiceImpl")
	private OverdueServiceImpl overdueServiceImpl;
	@Test  
	public void test() {  
		//测试 逾期费设置查询
		//overdueServiceImpl.findAllOverdue();
		//测试逾期天数程度查询
//		int a=overdueServiceImpl.findOverdueLimit();
//		System.out.println(a);
		//测试查询最大天数
		//overdueServiceImpl.findMaxOverdue();
		//删除逾期天数设置
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("overdueMin",3);
//		overdueServiceImpl.deleteOverdue(map);
		//添加逾期天数设置
//		OverdueEntity overdueEntity = new OverdueEntity();
//		overdueEntity.setId(1);
//		overdueEntity.setOverdueMax(4);
//		overdueEntity.setOverdueMin(1);
//		overdueEntity.setPrice(100);
//		overdueServiceImpl.insertOverdue(overdueEntity);
		//添加逾期程度设置
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("overdueLimit",3);
//		overdueServiceImpl.insertOverdueLimit(map);
		//修改逾期程度设置
//		Map<String,Object>  map = new HashMap<String,Object>();
//		map. put("overdueLimit",4);
//		overdueServiceImpl.updateOverdueLimit(map);
		
	}
	 
}

