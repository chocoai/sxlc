package product_p2p.projectmng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.ProjectBaseInfoEntity;
import  cn.springmvc.service.impl.ProjectBaseInfoServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testProjectBaseInfo extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testProjectBaseInfo.class);
 	@Resource(name="projectBaseInfoServiceImpl")
	private ProjectBaseInfoServiceImpl projectBaseInfoServiceImpl; 
	@Test  
	public void testinsert() {  
		ProjectBaseInfoEntity projectBaseInfoentity = new ProjectBaseInfoEntity();
		projectBaseInfoentity.setId(18); 
		projectBaseInfoentity.setStatu(1);
		projectBaseInfoentity.setBriefIntroduction("ssss");
		projectBaseInfoentity.setIsMortgage(0);
		projectBaseInfoentity.setPicIcon("sss");
		projectBaseInfoentity.setProjectName("dsfds");
		projectBaseInfoentity.setPicUrl("sdf");
		projectBaseInfoentity.setPicIcon("fsd");
		String[] info={"1"};
		projectBaseInfoServiceImpl.insertProjectBaseInfo(projectBaseInfoentity,projectBaseInfoentity,info);   
	} 
	@Test  
	public void testupdate() {  
		ProjectBaseInfoEntity projectBaseInfoentity = new ProjectBaseInfoEntity();
		projectBaseInfoentity.setId(7); 
		projectBaseInfoentity.setStatu(1);
		projectBaseInfoentity.setBriefIntroduction("11");
		projectBaseInfoentity.setPicIcon("qqqqqqqqqqsss");
		projectBaseInfoentity.setProjectName("qqqqqdsfds");
		projectBaseInfoentity.setPicUrl("qqqqqqqqsdf");
		projectBaseInfoentity.setPicIcon("qqqqqqqqqqfsd");
		projectBaseInfoServiceImpl.updateProjectBaseInfoByID(projectBaseInfoentity);  
	} 
	@Test  
	public void testdelete() {   
		projectBaseInfoServiceImpl.deleteProjectBaseInfoByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		ProjectBaseInfoEntity projectBaseInfoentity = new ProjectBaseInfoEntity();
		projectBaseInfoentity.setId(7);   
		projectBaseInfoentity.setStatu(1);
		projectBaseInfoServiceImpl.updateProjectBaseInfoStatuByID(projectBaseInfoentity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("projectName", "11");
		map.put("statu", -1);
		pageEntity.setMap(map);
		List<ProjectBaseInfoEntity>  list=projectBaseInfoServiceImpl.selectProjectBaseInfoListpage(pageEntity);   
	} 
	@Test  
	public void testselecone() { 
		 ProjectBaseInfoEntity  list=projectBaseInfoServiceImpl.selectProjectBaseInfoById(7);   
	} 
}
