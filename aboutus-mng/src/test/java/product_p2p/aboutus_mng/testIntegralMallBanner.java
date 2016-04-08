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

import cn.springmvc.model.IntegralMallBannerEntity;  
import cn.springmvc.service.impl.IntegralMallBannerServiceImpl;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testIntegralMallBanner extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testIntegralMallBanner.class);
 	@Resource(name="integralMallBannerServiceImpl")
	private IntegralMallBannerServiceImpl integralMallBannerServiceImpl; 
	@Test  
	public void testinsert() {  
		IntegralMallBannerEntity homeBannerEntity = new IntegralMallBannerEntity();
		homeBannerEntity.setId(8);
		homeBannerEntity.setBannerTitle("1111");
		homeBannerEntity.setIndexs(1);
		homeBannerEntity.setOptId(1); 
		homeBannerEntity.setUrl("ssss");  
		homeBannerEntity.setStatu(1);
		integralMallBannerServiceImpl.insertIntegralMallBanner(homeBannerEntity);  
	} 
	@Test  
	public void testupdate() {  
		IntegralMallBannerEntity homeBannerEntity = new IntegralMallBannerEntity();
		homeBannerEntity.setId(7);
		homeBannerEntity.setBannerTitle("1111");
		homeBannerEntity.setIndexs(1);
		homeBannerEntity.setOptId(1);  
		integralMallBannerServiceImpl.updateIntegralMallBannerByID(homeBannerEntity);  
	} 
	@Test  
	public void testdelete() {   
		integralMallBannerServiceImpl.deleteIntegralMallBannerByID(6);  
	} 
	@Test  
	public void testupdatestatu() {
		IntegralMallBannerEntity homeBannerEntity = new IntegralMallBannerEntity();
		homeBannerEntity.setId(7);
		homeBannerEntity.setBannerTitle("1111");
		homeBannerEntity.setIndexs(1);
		homeBannerEntity.setOptId(1);  
		integralMallBannerServiceImpl.updateIntegralMallBannerStatuByID(homeBannerEntity);  
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
		List<IntegralMallBannerEntity>  list=integralMallBannerServiceImpl.selectIntegralMallBannerListpage(pageEntity); 
	} 
	@Test  
	public void testMoveAndDown() { 
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("iid", 7);
		map.put("flag", 2); 
		map.put("result", 0);
		int result=integralMallBannerServiceImpl.moveAndDownIntegralMallBannerByID(map);  
	} 
}