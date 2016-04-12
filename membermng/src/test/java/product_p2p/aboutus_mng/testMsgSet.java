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

import cn.membermng.model.SendSetEntity;
import cn.springmvc.service.impl.MemberMsgSetServiceImpl;

import product_p2p.kit.pageselect.PageEntity; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testMsgSet extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testMsgSet.class);
 	@Resource(name="memberMsgSetServiceImpl")
	private MemberMsgSetServiceImpl memberMsgSetServiceImpl; 
  
 	@Test  
	public void insertMemberSmsSendSet() {
 		SendSetEntity sendSetEntity = new  SendSetEntity();
 		sendSetEntity.setMemberID(1);
 		sendSetEntity.setTypeID(1);
 		memberMsgSetServiceImpl.insertMemberSmsSendSet(sendSetEntity);
	} 
 	@Test  
	public void insertMemberEmailSendSet() {
 		SendSetEntity sendSetEntity = new  SendSetEntity();
 		sendSetEntity.setMemberID(1);
 		sendSetEntity.setTypeID(1);
 		memberMsgSetServiceImpl.insertMemberEmailSendSet(sendSetEntity);
	} 
	@Test  
	public void insertMemberLetterSendSet() {
 		SendSetEntity sendSetEntity = new  SendSetEntity();
 		sendSetEntity.setMemberID(1);
 		sendSetEntity.setTypeID(1);
 		memberMsgSetServiceImpl.insertMemberLetterSendSet(sendSetEntity);
	} 
	@Test  
	public void updateMemberSmsSendSet() {
 		SendSetEntity sendSetEntity = new  SendSetEntity();
 		sendSetEntity.setMemberID(1);
 		sendSetEntity.setTypeID(1);
 		sendSetEntity.setStatu(0);
 		memberMsgSetServiceImpl.updateMemberSmsSendSet(sendSetEntity);
	} 
	@Test  
	public void updateMemberEmailSendSet() {
 		SendSetEntity sendSetEntity = new  SendSetEntity();
 		sendSetEntity.setMemberID(1);
 		sendSetEntity.setTypeID(1);
 		sendSetEntity.setStatu(0);
 		memberMsgSetServiceImpl.updateMemberEmailSendSet(sendSetEntity);
	} 
	@Test  
	public void updateMemberLetterSendSet() {
 		SendSetEntity sendSetEntity = new  SendSetEntity();
 		sendSetEntity.setMemberID(1);
 		sendSetEntity.setTypeID(1);
 		sendSetEntity.setStatu(0);
 		memberMsgSetServiceImpl.updateMemberLetterSendSet(sendSetEntity);
	} 
	@Test  
	public void selectMessageTypeList() { 
 		memberMsgSetServiceImpl.selectMessageTypeList();
	} 
	@Test  
	public void selectMemberSmsSendSet() { 
 		memberMsgSetServiceImpl.selectMemberSmsSendSet(1);
	} 
	@Test  
	public void selectMemberEmailSendSet() { 
 		memberMsgSetServiceImpl.selectMemberEmailSendSet(1);
	} 
	@Test  
	public void selectMemberLetterSendSet() { 
 		memberMsgSetServiceImpl.selectMemberEmailSendSet(1);
	} 
	@Test  
	public void selectMemberSmsSendSetIsExist() { 
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberID", 1);  
		map.put("typeID", 1);  
 		memberMsgSetServiceImpl.selectMemberSmsSendSetIsExist(map);
	} 
	@Test  
	public void selectMemberEmailSendSetIsExist() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberID", 1);  
		map.put("typeID", 1);  
 		memberMsgSetServiceImpl.selectMemberEmailSendSetIsExist(map);
	} 
	@Test  
	public void selectMemberLetterSendSetsExist() { 
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberID", 1);  
		map.put("typeID", 1);  
 		memberMsgSetServiceImpl.selectMemberLetterSendSetsExist(map);
	} 
  
}
