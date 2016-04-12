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
  
import cn.membermng.model.MemberInfoEntity;
import cn.springmvc.service.impl.MemberInfoServicrImpl; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testMemberInfo extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testMemberInfo.class);
 	@Resource(name="memberInfoServicrImpl")
	private MemberInfoServicrImpl memberInfoServicrImpl;  
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("key", "ss");
		pageEntity.setMap(map);
		List<MemberInfoEntity>  list=memberInfoServicrImpl.selectMemberInfoList(pageEntity);   
	} 
}
