package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ActivitiesProjectEntity;
import cn.springmvc.model.ProjectAppRecordEntity;
import  cn.springmvc.service.impl.ActivitiesProjectServiceImpl;
import cn.springmvc.service.impl.InvestListServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testInvestList extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testInvestList.class);
 	@Resource(name="investListServiceImpl")
	private InvestListServiceImpl investListServiceImpl; 
 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("projectinfo", "11");
		map.put("investStatu ", -1);
		map.put("repayWay", "11");
		map.put("reward ", -1);
		map.put("projectType", "11");
		map.put("yearratemin ", -1);
		map.put("yearratemax", "11");
		map.put("deadlineType ", -1);
		map.put("deadlinemin", "11");
		map.put("deadlinemax ", -1); 
		map.put("sKey", "22");
		pageEntity.setMap(map);
		List<ProjectAppRecordEntity>  list=investListServiceImpl.selectInvestList(pageEntity);   
	} 
}
