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

import cn.membermng.model.BankCardInfoEntity;
import cn.membermng.model.BankCodeEntity;
import cn.membermng.model.CityDictionaryEntity;
import cn.membermng.model.MemberBankCardEntity;
import cn.membermng.model.ProvinceDictionaryEntity;
import cn.springmvc.service.impl.MemberBankCardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testBankCard extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testBankCard.class);
 	@Resource(name="memberBankCardServiceImpl")
	private MemberBankCardServiceImpl memberBankCardServiceImpl; 
 	@Test  
	public void testselectBankInfo() {
		 
		List<BankCodeEntity>  list=memberBankCardServiceImpl.selectBankInfo(); 
		System.out.print(list);
	} 
 	@Test  
	public void testselectProvinceDictionary() {
		 
		List<ProvinceDictionaryEntity>  list=memberBankCardServiceImpl.selectProvinceDictionary();   
	} 
 	@Test  
	public void selectCityDictionary() {
		 
		List<CityDictionaryEntity>  list2=memberBankCardServiceImpl.selectCityDictionary(1);   
		System.out.print(list2);
	} 
 	@Test  
	public void insertMemberBackCard() {
 		BankCardInfoEntity bankCardInfoEntity =new BankCardInfoEntity();
 		bankCardInfoEntity.setBankCardId(205);
 		bankCardInfoEntity.setBankId(97);
 		bankCardInfoEntity.setBankNo("6228545845784");
 		bankCardInfoEntity.setBankPhone("13550095458");
 		bankCardInfoEntity.setBranchAddress("sdfsdf");
 		bankCardInfoEntity.setCardProvince(123);
 		bankCardInfoEntity.setCardCity(2);
 		bankCardInfoEntity.setBranch("sdfsdf");
 		MemberBankCardEntity memberBankCardEntity =new MemberBankCardEntity();
 		memberBankCardEntity.setBankCardId(201);
 		memberBankCardEntity.setMemberID(1);
 		memberBankCardEntity.setMemberType(1);
 		memberBankCardEntity.setReceiveCard(4); 
		int result=memberBankCardServiceImpl.
				insertMemberBackCard(bankCardInfoEntity,memberBankCardEntity); 
		System.out.print(result);
	} 
 	@Test  
	public void selectMemberBankCardList() {
 		 Map<String,Object> map =new HashMap<String,Object>();
		 map.put("memberID", 1);
		 map.put("memberType", 1);
 		List<MemberBankCardEntity>  list=memberBankCardServiceImpl.selectMemberBankCardList(map); 
 		System.out.print(list);
	} 
 	@Test  
	public void selectMemberBankCardByID() {
 		BankCardInfoEntity bankCardInfoEntity=memberBankCardServiceImpl.selectMemberBankCardByID(1);  
 		System.out.print(bankCardInfoEntity);
	} 
 	@Test  
	public void updateBankCardInfo() {
 		BankCardInfoEntity bankCardInfoEntity =new BankCardInfoEntity();
 		bankCardInfoEntity.setBankCardId(2);
 		bankCardInfoEntity.setBankId(1);
 		bankCardInfoEntity.setBankNo("6228545845784");
 		bankCardInfoEntity.setBankPhone("13550095458");
 		bankCardInfoEntity.setBranchAddress("sdfsdf");
 		bankCardInfoEntity.setCardProvince(1);
 		bankCardInfoEntity.setCardProvince(1);
 		Map<String,Object> map = new HashMap<String,Object>();
 		map.put("bankNo", bankCardInfoEntity.getBankNo());
 		map.put("receiveCard", 1); 
 		int result=memberBankCardServiceImpl.updateBankCardInfo(bankCardInfoEntity,map); 
 		System.out.print(result);
	} 
 	@Test  
	public void deleteMemberBankCard() { 
 		int result=memberBankCardServiceImpl.deleteMemberBankCard(1);   
	} 
	 
}
