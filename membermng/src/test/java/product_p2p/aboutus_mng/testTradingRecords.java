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
 
import cn.membermng.model.MemberTradingRecordsEntity;
import cn.membermng.model.MemberWithdrawalRechargeEntity;
import cn.springmvc.service.impl.CapitalbudgetdetailsServiceImpl;

import product_p2p.kit.pageselect.PageEntity;
   

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testTradingRecords extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testTradingRecords.class);
 	@Resource(name="capitalbudgetdetailsServiceImpl")
	private CapitalbudgetdetailsServiceImpl capitalbudgetdetailsServiceImpl;  
	@Test  
	public void selectMemberTradingRecords() { 
		PageEntity pageEntity=new PageEntity();
 		pageEntity.setPageNum(1);
 		pageEntity.setPageSize(2);
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("memberID", 1);
 		map.put("tradeTypeId", 1);
 		map.put("startrecordDate", "2015-12-12");
 		map.put("endrecordDate", "2015-12-12");
 		map.put("recorddays", 8); 
 		map.put("sKey", "222");
 		map.put("order", 2);
 		pageEntity.setMap(map);
 		List<MemberTradingRecordsEntity>  list=capitalbudgetdetailsServiceImpl.selectMemberTradingRecords(pageEntity);
	} 
	@Test  
	public void selectRechargeList() { 
		PageEntity pageEntity=new PageEntity();
 		pageEntity.setPageNum(1);
 		pageEntity.setPageSize(2);
 		Map<String,Object> map=new HashMap<String,Object>(); 
 		map.put("memberID", 1);
 		map.put("thirdMerBillno", "2222");
 		map.put("startTime", "2015-12-12");
 		map.put("endtimeTime", "2015-12-12");
 		map.put("statu", 8); 
 		map.put("sKey", "222"); 
 		map.put("order", 2);
 		pageEntity.setMap(map);
 		List<MemberWithdrawalRechargeEntity>  list=capitalbudgetdetailsServiceImpl.selectRechargeList(pageEntity);
	} 
	@Test  
	public void selectWithdrawalList() { 
		PageEntity pageEntity=new PageEntity();
 		pageEntity.setPageNum(1);
 		pageEntity.setPageSize(2);
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("memberID", 1);
 		map.put("sKey", "222");
 		map.put("startTime", "2015-12-12");
 		map.put("endtimeTime", "2015-12-12");
 		map.put("statu", 8); 
 		map.put("order", 2);
 		pageEntity.setMap(map);
 		List<MemberWithdrawalRechargeEntity>  list=capitalbudgetdetailsServiceImpl.selectWithdrawalList(pageEntity);
	} 
	@Test  
	public void selectTradingRecordsdetail() {  
 		Map<String,Object> map=new HashMap<String,Object>(); 
 		map.put("sKey", "222");
 		map.put("tradeID", -1); 
 		MemberTradingRecordsEntity  list=capitalbudgetdetailsServiceImpl.selectTradingRecordsdetail(map);
	} 
	@Test  
	public void selectTotalRechargeFee() {  
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("memberID", 1);
 		map.put("keys", "222");
 		map.put("memberType", 0); 
 		long result=capitalbudgetdetailsServiceImpl.selectTotalRechargeFee(map);
	} 
	@Test  
	public void selectTotalRechargeReal() {   
 		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("memberID", 1);
 		map.put("keys", "222");
 		map.put("memberType", 0); 
 		long result=capitalbudgetdetailsServiceImpl.selectTotalRechargeFee(map);
	} 
	@Test  
	public void selectTotalWithdrawalFee() {  
 		Map<String,Object> map=new HashMap<String,Object>(); 
 		map.put("memberID", 1);
 		map.put("keys", "222");
 		map.put("memberType", 0); 
 		long result=capitalbudgetdetailsServiceImpl.selectTotalRechargeFee(map);
	} 
	@Test  
	public void selectTotalWithdrawalReal() {  
		Map<String,Object> map=new HashMap<String,Object>();
 		map.put("memberID", 1);
 		map.put("keys", "222");
 		map.put("memberType", 0); 
 		long result=capitalbudgetdetailsServiceImpl.selectTotalRechargeFee(map);
	} 
}
