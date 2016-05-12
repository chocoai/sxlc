

/** 
* @Title: ExtensionModuleServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午8:11:21 
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

import cn.invitemastermng.model.FirstInvestRedpacketsSetEntity; 
import cn.invitemastermng.model.MemberRedpacketsEntity;
import cn.invitemastermng.model.MemberRedpacketsSetEntity;
import cn.invitemastermng.model.RedpacketsAffairEntity; 
import cn.invitemastermng.model.RedpacketsDetailRecordEntity;
import cn.springmvc.dao.ExtensionModuleGiftDao;
import cn.springmvc.dao.ExtensionModuleGiftListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.service.ExtensionModuleGiftService; 

/** 
 * @author 刘利 
 * @Description: 推广模块-赠送管理
 * @since 
 * @date 2016-4-15 下午8:11:21  */
@Service("extensionModuleGiftServiceImpl")
public class ExtensionModuleGiftServiceImpl implements ExtensionModuleGiftService {
	@Resource(name="extensionModuleGiftListDaoImpl")
	private  ExtensionModuleGiftListDao extensionModuleGiftListDao;
	@Resource(name="extensionModuleGiftDaoImpl")
	private  ExtensionModuleGiftDao extensionModuleGiftDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	
	@Override
	public void getRedpacketsAffair(PageEntity page) {
		
		List<RedpacketsAffairEntity> list = extensionModuleGiftListDao.getRedpacketsAffair(page); 
		PageUtil.ObjectToPage(page, list); 
		
	}
	@Override
	public void getRedpacketsreceive(PageEntity page) {
		
		List<MemberRedpacketsEntity> list = extensionModuleGiftListDao.getRedpacketsreceive(page); 
		PageUtil.ObjectToPage(page, list);  
		
	}
	@Override
	public int FirstInvestRedpacketsSet(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = 0;
		if(map == null) { 
			return 0;	
		}
		if(map.get("lId") == null)
		{
			return 0;
		}
		int type = IntegerAndString.StringToInt(map.get("lId").toString(),0);
		//添加
		if(type == 0) {
			
		   IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		   long id = generatorUtil.GetId();
		   map.put("lId", id);
		   result = extensionModuleGiftDao.FirstInvestRedpacketsSet(map);
		   if(result == 1) {
				generatorUtil.SetIdUsed(id);
				StringBuffer detail = new StringBuffer("新增首次投资红包赠送配置:");
				detail.append("投资金额:"+IntegerAndString.LongToString(Long.valueOf(map.get("invest_Amount").toString())));
				detail.append("赠送比例:"+IntegerAndString.IntToString(Integer.valueOf(map.get("rp_Rate").toString()))+"%");
				logentity.setsDetail(detail.toString());
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		   }else{
				generatorUtil.SetIdUsedFail(id);
		   } 
		  
        }else{
        //修改
           result = extensionModuleGiftDao.FirstInvestRedpacketsSet(map);
           if(result == 1) { 
        	    StringBuffer detail = new StringBuffer("修改首次投资红包赠送配置:");
				detail.append("投资金额:"+IntegerAndString.LongToString(Long.valueOf(map.get("invest_Amount").toString())));
				detail.append("赠送比例:"+IntegerAndString.IntToString(Integer.valueOf(map.get("rp_Rate").toString()))+"%");
				logentity.setsDetail(detail.toString());
				optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo); 
		   }
        }
		 
        return result;
		
	}
	@Override
	public int deleteFirstInvestRedpacketsSet(int FIRPID,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		Map<String, Object> map = new  HashMap<String,Object>();
		map.put("lId", FIRPID);
		int result = extensionModuleGiftDao.deleteFirstInvestRedpacketsSet(map);
		if(result == 1) { 
			
			FirstInvestRedpacketsSetEntity entity = extensionModuleGiftListDao.
					selectFIInvestRedSetByID(FIRPID);
			StringBuffer detail = new StringBuffer("删除首次投资红包赠送配置:");
			detail.append("投资金额:"+entity.getInvestAmounts());
			detail.append("赠送比例:"+entity.getRpRates()+"%"); 
			logentity.setsDetail(detail.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
			
		}
		return result;
		
	}
	@Override
	public int MemberRedpacketsSet(String openAccount, String firstRecharge,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		Map<String, Object> map = new  HashMap<String,Object>();
		map.put("open_Account",   IntegerAndString.StringToInt(openAccount));
		map.put("first_Recharge", IntegerAndString.StringToInt(firstRecharge));
		int result = extensionModuleGiftDao.MemberRedpacketsSet(map);
		if(result == 1) { 
			logentity.setsDetail("红包赠送配置表设置：新注册会员开户赠送金额"+openAccount+"首次充值赠送红包金额"+firstRecharge);
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
	    }
		return result;
		
	}
	@Override
	public int RedpacketsAffairinsert(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(map == null){
			return 0;
		}
		int result = 0;
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		map.put("lId", id); 
		result = extensionModuleGiftDao.RedpacketsAffairinsert(map);
		if(result == 1) {
			generatorUtil.SetIdUsed(id); 
			logentity.setsDetail("新增红包活动 :"+map.get("affairName").toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
	    }else{
			generatorUtil.SetIdUsedFail(id);
	    } 
	    return result; 
		
	}
	@Override
	public int RedpacketsAffairupdate(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(map == null) {
			return 0;
		} 
		int result = extensionModuleGiftDao.RedpacketsAffairupdate(map);
		if(result == 1) {
			logentity.setsDetail("修改红包活动:"+map.get("affairName").toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
	    return result;  
	}
	@Override
	public int RedpacketsAffairrelease(long affairID,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		Map<String, Object> map = new  HashMap<String,Object>();
		map.put("affairID",   affairID); 
		int result = extensionModuleGiftDao.RedpacketsAffairrelease(map); 
		if(result == 1) {
			RedpacketsAffairEntity entity = extensionModuleGiftListDao.selectRedpacketsAffairbyID(affairID);
			logentity.setsDetail("发布红包活动:"+entity.getAffairName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
	    return result;  
		
	}
	@Override
	public MemberRedpacketsSetEntity selectMemberRedpacketsSet() {
		
		return extensionModuleGiftListDao.selectMemberRedpacketsSet(); 
		
	}
	@Override
	public FirstInvestRedpacketsSetEntity selectFIInvestRedSetByID(long firpID) {
		
		return extensionModuleGiftListDao.selectFIInvestRedSetByID(firpID); 
		
	}
	@Override
	public void selectFIInvestRedSetList(PageEntity page) {
		
		List<FirstInvestRedpacketsSetEntity> list = extensionModuleGiftListDao.
				selectFIInvestRedSetList(page); 
		
		PageUtil.ObjectToPage(page, list); 
		
	}
	@Override
	public RedpacketsAffairEntity selectRedpacketsAffairbyID(long affairID) {
		
		RedpacketsAffairEntity entity =  extensionModuleGiftListDao.selectRedpacketsAffairbyID(affairID);
		if (entity != null) {
			List<RedpacketsDetailRecordEntity> RedpacketsDetaillist = extensionModuleGiftListDao.
					selectRedpacketsDetailbyaffairID(affairID);
			entity.setRedpacketsDetail(RedpacketsDetaillist);
		}
	    return entity;
		
	}
	@Override
	public List<RedpacketsDetailRecordEntity> selectRedpacketsDetailbyaffairID(
			long affairID) {
		
		return extensionModuleGiftListDao.selectRedpacketsDetailbyaffairID(affairID);
		
	}  
}

