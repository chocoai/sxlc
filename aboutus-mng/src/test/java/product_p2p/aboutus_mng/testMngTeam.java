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
 
import cn.springmvc.model.MngTeamEntity; 
import cn.springmvc.service.impl.MngTeamServiceImpl;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testMngTeam extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testMngTeam.class);
 	@Resource(name="mngTeamServiceImpl")
	private MngTeamServiceImpl mngTeamServiceImpl; 
	@Test  
	public void testinsert() {  
		MngTeamEntity MngTeamentity = new MngTeamEntity();
		MngTeamentity.setId(8);
		MngTeamentity.setMngName("dfa");
		MngTeamentity.setMngPost("11");
		MngTeamentity.setOptId(1); 
		MngTeamentity.setPortraitUrl("sssdsdssss"); 
		MngTeamentity.setProfile("sss");
		MngTeamentity.setStatu(1);
		mngTeamServiceImpl.insertMngTeam(MngTeamentity);  
	} 
	@Test  
	public void testupdate() {  
		MngTeamEntity MngTeamentity = new MngTeamEntity();
		MngTeamentity.setId(6);
		MngTeamentity.setMngName("dfadf");
		MngTeamentity.setMngPost("sdsds"); 
		MngTeamentity.setPortraitUrl("333");  
		mngTeamServiceImpl.updateMngTeamByID(MngTeamentity);  
	} 
	@Test  
	public void testdelete() {   
		mngTeamServiceImpl.deleteMngTeamByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		MngTeamEntity MngTeamentity = new MngTeamEntity();
		MngTeamentity.setId(7);
		MngTeamentity.setMngName("dfadf");
		MngTeamentity.setMngPost("11");
		MngTeamentity.setOptId(1); 
		MngTeamentity.setPortraitUrl("sssdsdssssssssss"); 
		MngTeamentity.setProfile("sss");
		MngTeamentity.setStatu(0);
		mngTeamServiceImpl.updateMngTeamStatuByID(MngTeamentity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10); 
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("startTime", "2015-12-29");
		map.put("endTime", "2016-12-23"); 
		map.put("mngName", "1111"); 
		pageEntity.setMap(map);
		List<MngTeamEntity>  list=mngTeamServiceImpl.selectMngTeamListpage(pageEntity);   
	} 
}
