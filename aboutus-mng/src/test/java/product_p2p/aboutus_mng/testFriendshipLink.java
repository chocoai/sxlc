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

import cn.springmvc.model.FriendshipUnitEntity; 
import cn.springmvc.service.impl.FriendshipLinkServiceImpl; 
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testFriendshipLink extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testFriendshipLink.class);
 	@Resource(name="friendshipLinkServiceImpl")
	private FriendshipLinkServiceImpl friendshipLinkServiceImpl; 
	@Test  
	public void testinsert() {  
		FriendshipUnitEntity frindship = new FriendshipUnitEntity();
		frindship.setId(11);
		frindship.setUrl("dfadf");
		frindship.setIndexs(1);
		frindship.setIntroduction("aa77");
		frindship.setLogo("22");
		frindship.setName("asa66");
		frindship.setOptId(1);
		frindship.setStatu(true);
		friendshipLinkServiceImpl.insertFriendshipLink(frindship);  
	} 
	@Test  
	public void testupdate() {  
		FriendshipUnitEntity frindship = new FriendshipUnitEntity();
		frindship.setId(6);
		frindship.setUrl("dfadf");
		frindship.setIndexs(1); 
		friendshipLinkServiceImpl.updateFriendshipLinkByID(frindship);  
	} 
	@Test  
	public void testdelete() {   
		friendshipLinkServiceImpl.deleteFriendshipLinkByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		FriendshipUnitEntity frindship = new FriendshipUnitEntity();
		frindship.setId(6); 
		frindship.setStatu(false);
		friendshipLinkServiceImpl.updateFriendShipLinkStatuByID(frindship);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "11");
		map.put("statu", -1);
		pageEntity.setMap(map);
		List<FriendshipUnitEntity>  list=friendshipLinkServiceImpl.selectFriendshipLinkListpage(pageEntity);   
	} 
}