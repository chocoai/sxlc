

/** 
* @Title: testInvestJudge.java 
* @Package product_p2p.projectmng 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-25 下午2:35:20 
* @version V5.0 */
 
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

import product_p2p.kit.pageselect.PageEntity;
import cn.membermng.model.MemberThirdAuthInfoEntity;
import cn.springmvc.model.ActivitiesProjectEntity;
import cn.springmvc.model.ProjectAppProcessEntity;
import cn.springmvc.service.impl.ActivitiesProjectServiceImpl;
import cn.springmvc.service.impl.InvestJudgeServiceImpl;
import cn.springmvc.service.impl.ProjectDetailServiceImpl;
import cn.springmvc.service.impl.RecordsBalanceServiceImpl;

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-3-25 下午2:35:20  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class testInvestJudge extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(testInvestJudge.class);
 	@Resource(name="investJudgeServiceImpl")
	private InvestJudgeServiceImpl investJudgeServiceImpl; 
 	@Resource(name="recordsBalanceServiceImpl")
	private RecordsBalanceServiceImpl recordsBalanceServiceImpl; 
	@Resource(name="projectDetailServiceImpl")
	private ProjectDetailServiceImpl projectDetailServiceImpl; 
	@Test  
	public void testinsert() { 
		long memberID = 1;
		long investamount = 100;
		int memberType = 0;
		int applyId = 1;
		String redIDandreal = ""; 
		long vouchers =22;
		//-1未登录，-2未输入投资金额，-3 该会员未开户 ，-4未授权二次分配， -5该项目不存在
		//-6不能投资自己的借款,-7账户可用余额不足,-8超过最大投资笔数,-9超过最大投资总额 ,-10红包无效 ,
		//-11 使用代金券不能大于投资金额 ,-12使用代金券大于用户账户可用代金券，-13红包与代金卷不能同时使用,-14投金额不得小于起投金额 ,
		//-15不满足投资幅度-16可投金额低于加价幅度与投资金额必须全部投资,-17红包使用金额大于红包有效金额,-18 红包使用金额大于最大使用红包金额,
		//-19项目不在投资中
		int result=0;  
		//是否登录
		if(memberID > 0) {
		    if(investamount == 0){
		    	result =-2;//未输入投资金额
		    	return;
		    }
		    if(vouchers>0&&redIDandreal.length()>0){
		    	result = -13;//红包与代金卷不能同时使用
		    	return;
		    }
		    Map<String,Object> map = new HashMap<String,Object>();
		    map.put("memberID", memberID);
		    map.put("memberType", memberType);
		    MemberThirdAuthInfoEntity memberThirdAuthInfoEntity = 
		    		recordsBalanceServiceImpl.selectMemberThirdAuthInfo(map);
		    if(memberThirdAuthInfoEntity == null){
		    	result = -3;//该会员未开户
		    	return;
		    }
		    if(memberThirdAuthInfoEntity.getOpenSecondDistribute() == 0) {
		    	result = -4;//未授权二次分配
		    	return; 
		    }
		    Map<String,Object> map2 =new HashMap<String,Object>();
		    map2.put("sKey", "11");
		    map2.put("id", 1);
		    ProjectAppProcessEntity projectAppProcessEntity =
		    		projectDetailServiceImpl.selectProjectDetailByID(map2);
		    if(projectAppProcessEntity == null ) {
		    	result = -5;//该项目不存在
		    	return ;
		    }
		    int statu = projectAppProcessEntity.getProjectAppRecordEntity().getInvestStatu();
		    if(statu != 0){
		    	result = -19;//项目不在投资中
		    	return ;
		    }
		    if(projectAppProcessEntity.getProjectAppRecordEntity().getMemberID() == memberID) {
		    	
		    	result = -6;//不能投资自己的借款
		    	return ;
		    }
		    
		    //项目剩余投资金额
		    long availableaAmount = projectAppProcessEntity.getProjectAppRecordEntity().getAvailableaAmount();
		    
		    //账户可用余额
		    long userBanlance = memberThirdAuthInfoEntity.getMemberThirdInfoEntity().getGiftUserBalance();
		     
		    if(userBanlance < availableaAmount){
		    	result =-7;//账户可用余额不足
		    	return; 
		    }
		    //已投资总笔数
		    long countInvest = investJudgeServiceImpl.selectInvestCountByApplyID(applyId);
		    //该项目的最大投资笔数
		    long canInvestCount = projectAppProcessEntity.getProjectAppRecordEntity()
		    		.getInvestCountMax();
		    if(canInvestCount !=0 && countInvest == canInvestCount){
		    	result = -8;//超过最大投资笔数
		    	return;
		    }
		    //最大投资比例
		    int  InvestMax = projectAppProcessEntity.getProjectAppRecordEntity().getInvestMax();
		    if( InvestMax!=0 && InvestMax != 1000000) {
		    	
	    	   Map<String,Object> mapinvestsum = new HashMap<String,Object>();
			   map.put("applyId", applyId);
			   map.put("memberID", memberID);
			   //该会员已投资该项目的总金额
			   long investSum = investJudgeServiceImpl.selectInvestAmountByMemID(mapinvestsum);
				 
			    //借款总额
			    long amount = projectAppProcessEntity.getProjectAppRecordEntity()
			    		.getProjectBaseInfoentity().getAmount();
			    //最大投资金额
			    long maxInvestAmount = amount * InvestMax;
			    
			    if(maxInvestAmount < (investSum + investamount)*1000000 ) {
			    	result = -9;//超过最大投资总额
			    	return;
			    }
		    } 
		    int giftAmount = 0;
		    //使用红包
		    if(redIDandreal.length()>0) {
		    	String[] redIDS = redIDandreal.split("A");
				//String[] redID = redIDS[0].split(",");
				System.out.print(redIDS.length);
		    	for(int i=0 ; i< redIDS.length ;i++) {
		    	
		    	    String[] redID = redIDS[0].split(",");	 
				    Map<String,Object> giftMap = new HashMap<String,Object>();
				    map.put("redID", Integer.parseInt(redID[0]));
					map.put("memberID", memberID);
				    Map<String,Object>  resultgiftMap =  investJudgeServiceImpl.selectGiftInfobyID(giftMap);
					   if(resultgiftMap.isEmpty()){
						    result = -10;//红包无效
					    	return;
					   } 
				       
					   int avalibleGift = (int) resultgiftMap.get("avalibleGiftAmount");
					   
					   if(Integer.parseInt(redID[1]) > avalibleGift){
						   result = -17;//红包使用金额大于红包有效金额
					       return;
					   }
					giftAmount += Integer.parseInt(redID[1]);  
					   
		    	} 
		    	//最大红包使用百分比 0无上限
				int redpacketsRateMax  =investJudgeServiceImpl.selectRedpacketsRateMax();
				
				if(redpacketsRateMax > 0) {
				 //最大使用红包金额
				 long maxUseGift = investamount*redpacketsRateMax/100;
				 
				 if(giftAmount*100 > maxUseGift) {
					 result = -18;//红包使用金额大于最大使用红包金额
				     return;
				 }
				 
				}
		    }
		    //使用代金券
		    if(vouchers > 0){
		    	//账户可用代金券
		    	long giftUserBalance =  memberThirdAuthInfoEntity.getMemberThirdInfoEntity()
		    			.getGiftUserBalance();
		    	if( vouchers > investamount) {
		    		
		    	    result = -11;//使用代金券不能大于投资金额
			    	return;
		    	}
		    	if(vouchers > giftUserBalance) {
		    		
		    		    result = -12;//使用代金券大于用户账户可用代金券
				    	return;
		    	}
		    }
             
		    //可投金额不等于投资金额需判断加价幅度与起投金额
		    if(availableaAmount != investamount) { 
		    	 //起投金额
			     long MinStart = projectAppProcessEntity.getProjectAppRecordEntity()
			    		.getMinStart();
			     //加价幅度
			     long IncreaseRange = projectAppProcessEntity.getProjectAppRecordEntity()
			    		.getIncreaseRange();
		    	
		    	   //可投金额大于起投金额且大于加价幅度，判断投资金额是否满足加价幅度与起投金额
				  if(availableaAmount > MinStart && availableaAmount > IncreaseRange) {
						
					    if(investamount<MinStart) {
							result = -14; //投金额不得小于起投金额;
							return;
						}
					    if( IncreaseRange !=0 ) {
					    	
						    long investm = investamount - MinStart; 
						    if(investm%IncreaseRange != 0) {
						    	 result = -15;//不满足投资幅度
						    	 return;
						    }
					      
					    } 
				  }else{
					 
					 //可投金额低于加价幅度与投资金额必须全部投资，如起投：100，加价幅度150；可投金额110，不能满足起投与加价幅度
					 result = -16;
			    	 return;
				 }
		     }
		    
		}else{
		  result = -1;//未登录
		} 
	} 
 
}

