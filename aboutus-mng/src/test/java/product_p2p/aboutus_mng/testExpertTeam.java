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

import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.service.impl.ExpertTeamServiceImpl; 

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testExpertTeam extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testExpertTeam.class);
 	@Resource(name="expertTeamServiceImpl")
	private ExpertTeamServiceImpl expertTeamServiceImpl; 
	@Test  
	public void testinsert() {  
		ExpertTeamEntity expertTeamentity = new ExpertTeamEntity();
		expertTeamentity.setId(9);
		expertTeamentity.setMngName("HFGHFGH");
		expertTeamentity.setMngPost("11");
		expertTeamentity.setOptId(1); 
		expertTeamentity.setPortraitUrl("sssdsdssss"); 
		expertTeamentity.setProfile("sss");
		expertTeamentity.setStatu(1);
		expertTeamServiceImpl.insertExpertTeam(expertTeamentity);  
	} 
	@Test  
	public void testupdate() {  
		ExpertTeamEntity expertTeamentity = new ExpertTeamEntity();
		expertTeamentity.setId(6);
		expertTeamentity.setMngName("dfadf");
		expertTeamentity.setMngPost("sdsds"); 
		expertTeamentity.setPortraitUrl("333");  
		expertTeamServiceImpl.updateExpertTeamByID(expertTeamentity);  
	} 
	@Test  
	public void testdelete() {   
		expertTeamServiceImpl.deleteExpertTeamByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		ExpertTeamEntity expertTeamentity = new ExpertTeamEntity();
		expertTeamentity.setId(7);
		expertTeamentity.setMngName("dfadf");
		expertTeamentity.setMngPost("11");
		expertTeamentity.setOptId(1); 
		expertTeamentity.setPortraitUrl("sssdsdssssssssss"); 
		expertTeamentity.setProfile("sss");
		expertTeamentity.setStatu(0);
		expertTeamServiceImpl.updateExpertTeamStatuByID(expertTeamentity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("mngName", "11");
		map.put("statu", -1);
		pageEntity.setMap(map);
		List<ExpertTeamEntity>  list=expertTeamServiceImpl.selectExpertTeamListpage(pageEntity);   
	} 
}
