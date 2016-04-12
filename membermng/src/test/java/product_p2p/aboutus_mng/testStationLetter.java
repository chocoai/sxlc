package product_p2p.aboutus_mng;

import java.util.ArrayList;
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
import cn.membermng.model.MemberStationLetterEntity;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.service.impl.MemberStationServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testStationLetter extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testStationLetter.class);
 	@Resource(name="memberStationServiceImpl")
	private MemberStationServiceImpl memberStationServiceImpl; 
 	@Test  
	public void testdeleteSendStationLetter() {
		List<Integer> list =new ArrayList<Integer>();
		for(int i=1;i<3;i++){
			list.add(i);
		} 
		int result =memberStationServiceImpl.deleteSendStationLetter(list); 
		System.out.print(result);
	} 
 	@Test  
	public void testdeleteRecStationLetter() {
		 
 		List<Integer> list =new ArrayList<Integer>();
		for(int i=1;i<3;i++){
			list.add(i);
		} 
		int result =memberStationServiceImpl.deleteRecStationLetter(list); 
		System.out.print(result);  
	} 
 	@Test  
	public void updateRecStationReadlist() {
		 
 		List<Integer> list =new ArrayList<Integer>();
		for(int i=1;i<3;i++){
			list.add(i);
		} 
		int result =memberStationServiceImpl.updateRecStationReadlist(list); 
		System.out.print(result);  
	} 
 	@Test  
	public void updateRecStationNotReadlist() {
 		List<Integer> list =new ArrayList<Integer>();
		for(int i=1;i<3;i++){
			list.add(i);
		} 
		int result =memberStationServiceImpl.updateRecStationNotReadlist(list); 
		System.out.print(result);  
	} 
 	@Test  
	public void addStationLetter() {
 		 MemberStationLetterEntity memberStationLetterEntity = new MemberStationLetterEntity(); 
 		 memberStationLetterEntity.setTitle("dfsd");
 		 memberStationLetterEntity.setDetail("dfd");
 		 memberStationLetterEntity.setMemberID(2);
 		 memberStationLetterEntity.setLetterID(2);
 		 int result = memberStationServiceImpl.addStationLetter(memberStationLetterEntity); 
 		 System.out.print(result);
	} 
 	@Test  
	public void selectSendLetter() { 
 		PageEntity pageEntity=new PageEntity();
 		pageEntity.setPageNum(1);
 		pageEntity.setPageSize(2);
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("memberID", 2);
 		map.put("keys", "222");
 		pageEntity.setMap(map);
 		List<MemberStationLetterEntity> list=memberStationServiceImpl.selectSendLetter(pageEntity);  
 		System.out.print(list);
	} 
 	@Test  
	public void selectRecLetter() {
 		PageEntity pageEntity=new PageEntity();
 		pageEntity.setPageNum(1);
 		pageEntity.setPageSize(2);
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("memberID", 1);
 		map.put("keys", "222");
 		map.put("isRead", -1);
 		pageEntity.setMap(map);
 		List<MemberStationLetterEntity> list=memberStationServiceImpl.selectRecLetter(pageEntity);  
 		System.out.print(list);
	} 
 	@Test  
	public void selectSendLetterDetail() { 
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("letterID", 1);
 		map.put("keys", "222"); 
 		MemberStationLetterEntity memberStationLetterEntity=memberStationServiceImpl.selectSendLetterDetail(map);  
 		System.out.print(memberStationLetterEntity);
	} 
 	@Test  
	public void selectRecLetterDetail() { 
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("letterID", 2);
 		map.put("keys", "222"); 
 		MemberStationLetterEntity memberStationLetterEntity=memberStationServiceImpl.selectRecLetterDetail(map);  
 		System.out.print(memberStationLetterEntity);
	} 
 	@Test  
	public void selectMemberID() {  
 		long memberID=memberStationServiceImpl.selectMemberID("1111");  
 		System.out.print(memberID);
	} 
 	@Test  
	public void updateRecStationRead() {  
 		long memberID=memberStationServiceImpl.updateRecStationRead(1);  
 		System.out.print(memberID);
	} 
}
