package product_p2p.projectmng;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import junit.framework.TestCase; 

import  cn.springmvc.model.LoanRepayUrgedSetEntity;
import  cn.springmvc.service.impl.LoanRepayUrgedSetServiceImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import product_p2p.kit.pageselect.PageEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testLoanRepayUrgedSet extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testLoanRepayUrgedSet.class);
 	@Resource(name="loanRepayUrgedSetServiceImpl")
	private LoanRepayUrgedSetServiceImpl loanRepayUrgedSetServiceImpl; 
	@Test  
	public void testinsert() {  
		LoanRepayUrgedSetEntity loanRepayUrgedSetentity = new LoanRepayUrgedSetEntity(); 
		loanRepayUrgedSetentity.setBillContent("68768");
		loanRepayUrgedSetentity.setBillDays(5);
		loanRepayUrgedSetServiceImpl.insertLoanRepayUrgedSet(loanRepayUrgedSetentity);  
	}  
	@Test  
	public void testdelete() {   
		loanRepayUrgedSetServiceImpl.deleteLoanRepayUrgedSet(0);  
	} 
 
	@Test  
	public void testselecAll() {
		LoanRepayUrgedSetEntity loanRepayUrgedSetentity = new LoanRepayUrgedSetEntity(); 
		loanRepayUrgedSetentity=loanRepayUrgedSetServiceImpl.selectLoanRepayUrgedSetList();   
	} 
}