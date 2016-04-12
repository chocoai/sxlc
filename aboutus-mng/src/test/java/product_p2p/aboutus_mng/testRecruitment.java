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

import cn.springmvc.model.RecruitmentEntity; 
import cn.springmvc.service.impl.RecruitmentServiceImpl;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testRecruitment extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testRecruitment.class);
 	@Resource(name="recruitmentServiceImpl")
	private RecruitmentServiceImpl recruitmentServiceImpl; 
	@Test  
	public void testinsert() {  
		RecruitmentEntity recruitmentEntity = new RecruitmentEntity();
		recruitmentEntity.setId(11); 
		recruitmentEntity.setOptId(1);
		recruitmentEntity.setStatu(1);  
		recruitmentEntity.setName("osss");
		recruitmentEntity.setArea("dd");
		recruitmentEntity.setJobRequirements("dfd");
		recruitmentEntity.setJobResponsibilities("dd");
		recruitmentEntity.setOptId(1);
		recruitmentServiceImpl.insertRecruitments(recruitmentEntity);  
	} 
	@Test  
	public void testupdate() {  
		RecruitmentEntity recruitmentEntity = new RecruitmentEntity();
		recruitmentEntity.setId(8); 
		recruitmentServiceImpl.updateRecruitments(recruitmentEntity);  
	} 
	@Test  
	public void testdelete() {   
		recruitmentServiceImpl.deleteRecruitments(8);  
	} 
	@Test  
	public void testupdatestatu() {
		RecruitmentEntity recruitmentEntity = new RecruitmentEntity();
		recruitmentEntity.setId(8); 
		recruitmentEntity.setStatu(0);  
		recruitmentServiceImpl.updateRecruitmentStatuByID(recruitmentEntity);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Name", "2015-12-29"); 
		map.put("statu", 1); 
		pageEntity.setMap(map);
		List<RecruitmentEntity>  list=recruitmentServiceImpl.selectRecruitmentsList(pageEntity);   
	} 
}