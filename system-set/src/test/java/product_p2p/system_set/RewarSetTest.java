
package product_p2p.system_set; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.RewardSetEntity;
import cn.springmvc.service.impl.CreditorServiceImpl;
import cn.springmvc.service.impl.RewarSetServiceImpl;

 

import junit.framework.TestCase;  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring.xml"})
public class RewarSetTest extends TestCase { 
	private static final Logger logger = Logger
			.getLogger(RewarSetTest.class);
 	@Resource(name="rewarSetServiceImpl")
	private RewarSetServiceImpl rewarSetServiceImpl;
	@Test  
	public void test() {  
		//查询提奖设置
//		PageEntity page = new PageEntity();
//		page.setPageNum(1);
//		page.setPageSize(1);
//		Map<String, Object> map =new HashMap<>();
//		map.put("type", 1);//0：推荐达人 1：理财顾问
//		page.setMap(map);
//		rewarSetServiceImpl.selectRewarSetByType(page);
		//添加提奖设置
//		RewardSetEntity rewardSetEntity = new RewardSetEntity();
//		rewardSetEntity.setId(1);
//		rewardSetEntity.setBorrowReward(1);
//		rewardSetEntity.setGradeName("");
//		rewardSetEntity.setGradeRemark("");
//		rewardSetEntity.setInvestReward(1);
//		rewardSetEntity.setRepayReward(1);
//		rewardSetEntity.setTotalInvest(111);
//		rewardSetEntity.setType(0);
//		rewardSetEntity.setvIPReward(1);
//		rewarSetServiceImpl.insertRewarSet(rewardSetEntity);
		//修改提奖设置
//		RewardSetEntity rewardSetEntity = new RewardSetEntity();
//		rewardSetEntity.setBorrowReward(1);
//		rewardSetEntity.setGradeName("");
//		rewardSetEntity.setGradeRemark("");
//		rewardSetEntity.setInvestReward(1);
//		rewardSetEntity.setRepayReward(1);
//		rewardSetEntity.setTotalInvest(1101);
//		rewardSetEntity.setType(0);
//		rewardSetEntity.setvIPReward(3);
//		rewarSetServiceImpl.updateRewarSet(rewardSetEntity);
		//删除提奖设置
//		RewardSetEntity rewardSetEntity = new RewardSetEntity();
//		rewardSetEntity.setType(0);
//		rewardSetEntity.setId(1);
//		rewarSetServiceImpl.deleteRewarSet(rewardSetEntity);
	}
	 
}

