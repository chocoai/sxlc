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
  
import cn.membermng.model.MemberRedpacketsEntity;
import cn.membermng.model.OwnTradingRecordsBalanceEntity;
import cn.springmvc.service.impl.MemberInfoServicrImpl; 
import cn.springmvc.service.impl.RecordsBalanceServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testRecordsbalance extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testRecordsbalance.class);
 	@Resource(name="recordsBalanceServiceImpl")
	private RecordsBalanceServiceImpl recordsBalanceServiceImpl;  
	@Test  
	public void testselectMemberBalance() { 
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberID", 1);  
		map.put("memberType", 1);  
		OwnTradingRecordsBalanceEntity  list=recordsBalanceServiceImpl.selectMemberBalance(map);
	} 
	@Test  
	public void testSelectMembergift() { 
		List<MemberRedpacketsEntity>  memberRedpacketsList=recordsBalanceServiceImpl.selectMembergift(1);
		logger.info(memberRedpacketsList.size());
	} 
	@Test  
	public void testselectMembergiftCount() { 
		int result=recordsBalanceServiceImpl.selectMembergiftCount(1);
		
	} 
	@Test  
	public void selectMembergift() { 
		List<MemberRedpacketsEntity>  memberRedpacketsList = null;
		memberRedpacketsList = recordsBalanceServiceImpl.selectMembergift(1); 
	} 
	@Test  
    public void testselectTotalreplay() {
		
		int result= recordsBalanceServiceImpl.selectTotalreplay(1); 
	}
	@Test  
    public void selectAdvanceReplay() {
		
		int result= recordsBalanceServiceImpl.selectAdvanceReplay(1); 
	}
	@Test  
    public void selectTotalReplayOver() {
		
		int result= recordsBalanceServiceImpl.selectTotalReplayOver(1); 
	}
	@Test  
    public void selectTotalInvest() {
		
		int result= recordsBalanceServiceImpl.selectTotalInvest(1); 
	}
	@Test  
    public void selectReplayOverLimit() {
		
		int result= recordsBalanceServiceImpl.selectReplayOverLimit(1); 
	}
	@Test  
    public void selectTotalOverNotReplay() {
		
		int result= recordsBalanceServiceImpl.selectTotalOverNotReplay(1); 
	}
	@Test  
    public void selectMemberInvestTotal() {
		
		long result= recordsBalanceServiceImpl.selectMemberInvestTotal(1); 
		System.out.print(result);
	}
	@Test  
    public void selectRecvPrincipalTotal() {
		
		long result= recordsBalanceServiceImpl.selectRecvPrincipalTotal(1); 
	}
	@Test  
    public void selectMemberReIncomeTotal() {
		
		long result= recordsBalanceServiceImpl.selectMemberReIncomeTotal(1); 
	}
	@Test  
    public void selectSDRecvPrincipalTotal() {
		
		long result= recordsBalanceServiceImpl.selectSDRecvPrincipalTotal(1); 
	}
	@Test  
    public void selectMemberSDIncomeTotal() {
		
		long result= recordsBalanceServiceImpl.selectMemberSDIncomeTotal(1); 
	}
}
