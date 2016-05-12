

/** 
* @Title: LuckyDrawServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 上午10:54:44 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import cn.invitemastermng.model.LotteryActivityEntity;
import cn.invitemastermng.model.LotteryManage;
import cn.invitemastermng.model.LotteryRecordsEntity;
import cn.invitemastermng.model.PrizeInformationEntity;
import cn.springmvc.dao.LuckyDrawDao;
import cn.springmvc.dao.LuckyDrawListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.service.LuckyDrawService;

/** 
 * @author 刘利 
 * @Description: 幸运抽奖
 * @since 
 * @date 2016-4-15 上午10:54:44  */
@Service("luckyDrawServiceImpl")
public class LuckyDrawServiceImpl implements LuckyDrawService { 
	@Resource(name="luckyDrawDaoImpl")
	private LuckyDrawDao luckyDrawDao;
	@Resource(name="luckyDrawListDaoImpl")
	private LuckyDrawListDao luckyDrawListDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int LotteryManageSet(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
     
		int result = 0;
		if(map == null) { 
			  return 0;	
		}
		if(map.get("lID") == null) {
			return 0;
		}
		int type = IntegerAndString.StringToInt(map.get("lID").toString(),0);
		//添加
		if(type == 0) {
			
		  IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		  long id = generatorUtil.GetId();
		  map.put("lID", id);
		  result = luckyDrawDao.LotteryManageSet(map);
		  if(result == 1) {
				generatorUtil.SetIdUsed(id);
				logentity.setsDetail("添加抽奖管理设置");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		  }else{
				generatorUtil.SetIdUsedFail(id);
		  } 
		  
        }else{
          result = luckyDrawDao.LotteryManageSet(map);
          if(result == 1) { 
			   logentity.setsDetail("修改抽奖管理设置");
			   optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		  }
        }
		 
        return result;
	}
	
	@Override
	public int LotterySet(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = 0;
		if(map == null) { 
		  return 0;	
		}
		if(map.get("lId") == null) {
			return 0;
		}
		int type = IntegerAndString.StringToInt(map.get("lId").toString(),0);
		//添加
		if(type == 0) {
			
		  IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		  long id = generatorUtil.GetId();
		  map.put("lId", id);
		   
		  result = luckyDrawDao.LotterySet(map);
		  if(result == 1) {
				generatorUtil.SetIdUsed(id); 
				logentity.setsDetail("添加抽奖活动 ");
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		  }else{
				generatorUtil.SetIdUsedFail(id);
		  } 
		  
        }else{
        	//修改
          result = luckyDrawDao.LotterySet(map);
          if(result == 1) { 
			   logentity.setsDetail("修改抽奖活动");
			   optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		  }
        }
		 
        return result;
		
	}
	@Override
	public void getLotteryRecord(PageEntity page) {
		
		List<LotteryRecordsEntity> list = luckyDrawListDao.getLotteryRecord(page);
		PageUtil.ObjectToPage(page, list);
		
	}
	@Override
	public int PrizeDelete(long prizeID,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("lId", prizeID);
		int result = luckyDrawDao.PrizeDelete(map);
		if(result == 1) { 
		   PrizeInformationEntity entity = luckyDrawListDao.selectPrizeInformationByID(prizeID);
		   logentity.setsDetail("删除奖品"+entity.getPrizeName());
		   optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
		
	}
	@Override
	public int PrizeSet(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = 0;
		if(map == null) { 
		  return 0;	
		}
		if(map.get("lId") == null) {
			return 0;
		}
		int type = IntegerAndString.StringToInt(map.get("lId").toString(),0);
		//添加
		if(type == 0) {
			
		  IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		  long id = generatorUtil.GetId();
		  map.put("lId", id);
		  //添加
		  result = luckyDrawDao.PrizeSet(map);
		  if(result == 1) {
				generatorUtil.SetIdUsed(id); 
				logentity.setsDetail("添加奖品"+map.get("prizename").toString());
		   		optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		  }else{
				generatorUtil.SetIdUsedFail(id);
		  } 
		  
       }else{
        	//修改
          result = luckyDrawDao.PrizeSet(map);
          if(result == 1) {  
   		    logentity.setsDetail("修改奖品"+map.get("prizename").toString());
   		    optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
   		  }
       }
	   return result; 
	}

	@Override
	public void selectLotteryActivity(PageEntity page) {
		
		List<LotteryActivityEntity> list = luckyDrawListDao.selectLotteryActivity(page);
		PageUtil.ObjectToPage(page, list); 
		
	}

	@Override
	public void selectPrizeInformation(PageEntity page) {
		
		List<PrizeInformationEntity> list = luckyDrawListDao.selectPrizeInformation(page);
		PageUtil.ObjectToPage(page, list); 
		
	}

	@Override
	public LotteryActivityEntity selectLotteryActivityByID(long lotteryID) {
		
		return luckyDrawListDao.selectLotteryActivityByID(lotteryID);
		
	}

	@Override
	public PrizeInformationEntity selectPrizeInformationByID(long prizeID) {
		
		return luckyDrawListDao.selectPrizeInformationByID(prizeID);
		
	}

	@Override
	public void selectPrizeByActID(PageEntity page) {
		
		List<PrizeInformationEntity> list = luckyDrawListDao.selectPrizeByActID(page);
		PageUtil.ObjectToPage(page, list);
		
	}

	@Override
	public List<LotteryActivityEntity> selectperiod() {
		
		return luckyDrawListDao.selectperiod();
		
	}

	@Override
	public List<LotteryManage> selectgrade() {
		
		return luckyDrawListDao.selectgrade();
		
	}

	@Override
	public List<PrizeInformationEntity> selectPrizeTypes() {
		
		return luckyDrawListDao.selectPrizeTypes();
		
	}

}

