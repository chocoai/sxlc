
package cn.springmvc.service.impl; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;
import cn.invitemastermng.model.LotteryManage;
import cn.invitemastermng.model.LotteryRecords;
import cn.invitemastermng.model.PrizeInformation;
import cn.invitemastermng.model.RedRecord;
import cn.invitemastermng.model.RedpacketsDetailRecord;
import cn.springmvc.dao.IRedPackageReadDao;
import cn.springmvc.dao.IRedPackageWriteDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.service.IRedPackageService;

@Service
public class RedPackageServiceImpl implements IRedPackageService {

	@Resource(name="redPackageReadDaoImpl")
	private IRedPackageReadDao redPackageDaoImpl;
	
	@Resource(name="redPackageWriteDaoImpl")
	private IRedPackageWriteDao redPackageWriteDaoImpl;
	
	@Override
	public List<RedRecord> redRecord(PageEntity entity) {
		
		return redPackageDaoImpl.redRecord(entity);
	}

	
	@Override
	public int grabRedPackage(long affairId, long memberId) {
		List<RedpacketsDetailRecord> redPackage = redPackageDaoImpl.redPackageConf(affairId);
		List<RedpacketsDetailRecord> newRecords = new ArrayList<RedpacketsDetailRecord>();
		for (int i = 0; i < redPackage.size(); i++) {
			if(redPackage.get(i).getRemainQuantity() > 0){
				newRecords.add(redPackage.get(i));
			}
		}
		if(newRecords.size() == 0){
			return -5; //红包已被领完
		}
		int sta = redPackageDaoImpl.BlackMemberJudgmentTow(memberId, 5);
		if (sta==-1) {
			return -6;//黑名单会员禁止抢红包
		}
		int random = (int) (1+Math.random()*newRecords.size());
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("mrId", id);
		param.put("memberId", memberId);
		param.put("affairId", affairId);
		param.put("rdId", newRecords.get(random).getrPDetailId());
		int result = redPackageWriteDaoImpl.grabRedPackage(param);
		if(result == 1){
			generatorUtil.SetIdUsed(id);
		}else{
			generatorUtil.SetIdUsedFail(id);
		}
		return result;
	}

	
	@Override
	public List<PrizeInformation> prizeInformations() {
		
		return redPackageDaoImpl.prizeInformations();
	}
	
	
	@Override
	public List<LotteryRecords> winners(PageEntity entity) {
		
		return redPackageDaoImpl.winners(entity);
	}


	@Override
	public int lottery(long lid) {
		//首先查询出商品配置信息、可以缓存一下！
		List<LotteryManage> config = redPackageDaoImpl.lotteryConfig(lid);
		int[] array = new int[config.size()];
		//计算各奖项的范围
		int sumGradeOdds = 0;
		for (int i = 0; i < config.size(); i++) {
			sumGradeOdds += config.get(i).getGradeOdds();
			array[i] = (int) config.get(i).getGradeOdds();
		}
		
		selectSort(array);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < config.size(); j++) {
				if(config.get(j).getGradeOdds() == array[i]){
					
				}
			}
		}
		
		
		
		//产生随机数来随机产品信息
		int number = sumGradeOdds%(1+(int)(Math.random()*sumGradeOdds));
		LotteryManage lotteryManage = null;
		for (int i = 0; i < config.size(); i++) {
			if(number == sumGradeOdds%config.get(i).getZjjs()){
				lotteryManage = config.get(i);
			}
		}
		if(lotteryManage !=null){//抽奖成功
			
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		/*List<LotteryManage> config = new ArrayList<LotteryManage>();
		config.add(new LotteryManage(1, 1, 1, 10, 10));
		config.add(new LotteryManage(1, 2, 1, 10, 10));
		config.add(new LotteryManage(1, 3, 1, 10, 10));
		config.add(new LotteryManage(1, 4, 1, 10, 10));
		
		//计算各奖项的中奖范围
		int sumGradeOdds = 0;
		for (int i = 0; i < config.size(); i++) {
			sumGradeOdds += config.get(i).getGradeOdds();
		}
		//产生随机数来随机产品信息
		int cnumber = 1+(int)(Math.random()*sumGradeOdds);
		int number = sumGradeOdds/cnumber;
		System.out.println("总基数为:"+sumGradeOdds+",当前概率："+number+",");
		LotteryManage lotteryManage = null;
		for (int i = 0; i < config.size(); i++) {
			System.out.println(number +" : "+sumGradeOdds+" : "+config.get(i).getGradeOdds()+" : "+sumGradeOdds/config.get(i).getGradeOdds());
			if(number == sumGradeOdds/config.get(i).getGradeOdds()){
				lotteryManage = config.get(i);
			}
		}
		System.out.println(JSONObject.toJSONString(lotteryManage));*/
	}
	
	public static void selectSort(int[] numbers) {   
	    int size = numbers.length, temp;   
	    for (int i = 0; i < size; i++) {   
	        int k = i;   
	        for (int j = size - 1; j >i; j--)  {   
	            if (numbers[j] < numbers[k])  k = j;   
	        }   
	        temp = numbers[i];   
	        numbers[i] = numbers[k];   
	        numbers[k] = temp;   
	    }   
	}
}


