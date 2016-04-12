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

import cn.membermng.model.MemberMsgRecordEntity;
import cn.springmvc.service.impl.MemberMsgRecordServiceImpl;

import product_p2p.kit.pageselect.PageEntity; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testMsg extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testMsg.class);
 	@Resource(name="memberMsgRecordServiceImpl")
	private MemberMsgRecordServiceImpl memberMsgRecordServiceImpl; 
  
 	@Test  
	public void selectMemberMsgList() {
 		PageEntity pageEntity=new PageEntity();
 		pageEntity.setPageNum(1);
 		pageEntity.setPageSize(2);
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("memberID", 1);
 		map.put("readStatu", -1);
 		pageEntity.setMap(map);
 		List<MemberMsgRecordEntity> list=memberMsgRecordServiceImpl.selectMemberMsgList(pageEntity);  
 		System.out.print(list);
	} 
  
 	@Test  
	public void updateMemberMsgIsRead() {  
 		Map<String,Object> map =new HashMap<String,Object>();
 		map.put("memberID", 1);
 		map.put("recordDate", "2016-03-29 20:51:29");
 		map.put("msgType", 2);
 		int result=memberMsgRecordServiceImpl.updateMemberMsgIsRead(map);  
 		System.out.print(result);
	} 
}
