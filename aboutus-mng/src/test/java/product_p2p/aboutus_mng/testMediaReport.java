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

import cn.springmvc.model.MediaReportsEntity;
import cn.springmvc.model.PartnersEntity;
import cn.springmvc.service.impl.MediaReportsServiceImpl;
import cn.springmvc.service.impl.PartnersServiceImpl;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testMediaReport extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testMediaReport.class);
 	@Resource(name="mediaReportsServiceImpl")
	private MediaReportsServiceImpl mediaReportsServiceImpl; 
	@Test  
	public void testinsert() {  
		MediaReportsEntity mediaReports = new MediaReportsEntity();
		mediaReports.setId(7);
		mediaReports.setContent("dfadf");
		mediaReports.setLogo("11");
		mediaReports.setOptId(1); 
		mediaReports.setSource("sssdsdssssssssss");
		mediaReports.setStatu(1);
		mediaReports.setTitle("sss");
		mediaReportsServiceImpl.insertMediaReports(mediaReports);  
	} 
	@Test  
	public void testupdate() {  
		MediaReportsEntity mediaReports = new MediaReportsEntity();
		mediaReports.setId(6);
		mediaReports.setContent("dfadf"); 
		mediaReportsServiceImpl.updateMediaReportsByID(mediaReports);  
	} 
	@Test  
	public void testdelete() {   
		mediaReportsServiceImpl.deleteMediaReportsByID(3);  
	} 
	@Test  
	public void testupdatestatu() {
		MediaReportsEntity mediaReports = new MediaReportsEntity();
		mediaReports.setId(6);
		mediaReports.setContent("dfadf");
		mediaReports.setLogo("11");
		mediaReports.setOptId(1);  
		mediaReportsServiceImpl.updateMediaReportsStatuByID(mediaReports);  
	} 
	@Test  
	public void testselecAll() {
		PageEntity pageEntity = new PageEntity();
		pageEntity.setPageNum(1);
		pageEntity.setPageSize(10);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Title", "ss"); 
		map.put("statu", 1); 
		pageEntity.setMap(map);
		List<MediaReportsEntity>  list=mediaReportsServiceImpl.selectMediaReportsListpage(pageEntity);   
	} 
}
