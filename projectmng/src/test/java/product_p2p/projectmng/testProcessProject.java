package product_p2p.projectmng;

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

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ProcessProjectEntity; 
import cn.springmvc.service.impl.ProcessProjectServiceImpl;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProcessProject extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProcessProject.class);
 	@Resource(name="processProjectServiceImpl")
	private ProcessProjectServiceImpl processProjectServiceImpl; 
	@Test  
	public void testinsert() {  
		ProcessProjectEntity processProjectEntity = new ProcessProjectEntity();
		processProjectEntity.setId(2); 
		processProjectEntity.setBatch(1);
		processProjectEntity.setApID(10);
		InsertAdminLogEntity entityLog =null;
		String[] sIpInfo =null;
		processProjectServiceImpl.insertProcessProject(processProjectEntity,entityLog,sIpInfo);  
	} 
	@Test  
	public void testupdate() {  
		ProcessProjectEntity processProjectEntity = new ProcessProjectEntity();
		processProjectEntity.setId(1); 
		processProjectEntity.setStatu(0);
		processProjectServiceImpl.updateProcessProjectStatuByID(processProjectEntity);  
	} 
	@Test  
	public void testdelete() {   
		processProjectServiceImpl.deleteProcessProjectByID(1);  
	} 
	 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("startTime", "2015-12-29");
		map.put("endTime", "2016-12-23");
		map.put("statu", 1);
		map.put("bannerTitle", "1111");
		pageEntity.setMap(map);
		List<ProcessProjectEntity>  list=processProjectServiceImpl.selectProcessProjectListpage(pageEntity);  
	} 
	@Test  
	public void testMoveAndDown() { 
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("iid", 7);
		map.put("flag", 2); 
		map.put("result", 0);
		int result=processProjectServiceImpl.moveAndDownProcessProjectByID(map);  
	} 
}