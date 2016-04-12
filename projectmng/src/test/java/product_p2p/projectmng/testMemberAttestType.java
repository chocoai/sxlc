package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 
 
import cn.springmvc.model.MemberAttestTypeEntity;
import  cn.springmvc.service.impl.MemberAttestTypeServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testMemberAttestType extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testMemberAttestType.class);
 	@Resource(name="memberAttestTypeServiceImpl")
	private MemberAttestTypeServiceImpl memberAttestTypeServiceImpl; 
	@Test  
	public void testinsert() {  
		MemberAttestTypeEntity memberAttestTypeentity = new MemberAttestTypeEntity();
		memberAttestTypeentity.setAttestTypeID(27);
		memberAttestTypeentity.setAttestTypeName("营业执照认"); 
		memberAttestTypeentity.setOptId(1);  
		memberAttestTypeentity.setStatu(1);
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		int result = memberAttestTypeServiceImpl.insertMemberAttestType(memberAttestTypeentity,entityLog,sIpInfo);
		System.out.print(result);
	} 
	@Test  
	public void testupdate() {  
		MemberAttestTypeEntity memberAttestTypeentity = new MemberAttestTypeEntity();
		memberAttestTypeentity.setAttestTypeID(27);
		memberAttestTypeentity.setAttestTypeName("eeee"); 
		memberAttestTypeentity.setOptId(1);  
		memberAttestTypeentity.setStatu(1);
		memberAttestTypeentity.setPictureUrl("dsds");
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		memberAttestTypeServiceImpl.updateMemberAttestTypeByID(memberAttestTypeentity,entityLog,sIpInfo);  
	} 
	@Test  
	public void testdelete() {
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		memberAttestTypeServiceImpl.deleteMemberAttestTypeByID(27,entityLog,sIpInfo);  
	} 
	@Test  
	public void testupdatestatu() {
		MemberAttestTypeEntity memberAttestTypeentity = new MemberAttestTypeEntity();
		memberAttestTypeentity.setAttestTypeID(27); 
		memberAttestTypeentity.setOptId(1);  
		memberAttestTypeentity.setStatu(0);
		memberAttestTypeServiceImpl.updateMemberAttestTypeStatuByID(memberAttestTypeentity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("attestTypeName", "担保");
		map.put("statu", -1);
		pageEntity.setMap(map);
		List<MemberAttestTypeEntity>  list=memberAttestTypeServiceImpl.selectMemberAttestTypeListpage(pageEntity);   
	    System.out.print(list);
	} 
}
