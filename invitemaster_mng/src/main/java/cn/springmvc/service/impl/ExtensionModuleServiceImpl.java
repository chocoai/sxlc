

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

import cn.invitemastermng.model.CpsInviteSetEntity; 
import cn.invitemastermng.model.MemberInfoEntity; 
import cn.invitemastermng.model.SeoSetEntity;
import cn.invitemastermng.model.SeoSetTypeEntity; 
import cn.springmvc.dao.ExtensionModuleDao;
import cn.springmvc.dao.ExtensionModuleListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.service.ExtensionModuleService;

/** 
 * @author 刘利 
 * @Description: 推广模块
 * @since 
 * @date 2016-4-15 下午8:11:21  */
@Service("extensionModuleServiceImpl")
public class ExtensionModuleServiceImpl implements ExtensionModuleService {
	@Resource(name="extensionModuleListDaoImpl")
	private  ExtensionModuleListDao extensionModuleListDao;
	@Resource(name="extensionModuleDaoImpl")
	private  ExtensionModuleDao extensionModuleDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int seoSet(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		if(map == null) {
			return 0;
		}
		int result = 0;
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		map.put("lId", id); 
		result = extensionModuleDao.seoSet(map);
	    if(result == 1) {
			generatorUtil.SetIdUsed(id); 
			StringBuffer detail = new  StringBuffer("SEO信息配置表设置 :");
			detail.append("title内容"       +map.get("title"));
			detail.append("描述"      +map.get("description"));
			detail.append("关键词"         +map.get("keyword")); 
			logentity.setsDetail(detail.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
	    }else{
			generatorUtil.SetIdUsedFail(id);
	    } 
	    return result; 
    }
	@Override
	public int seoDelete(int lId,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		Map<String, Object> map = new  HashMap<String,Object>();
		map.put("lId", lId);
		SeoSetEntity seoSetEntity = extensionModuleListDao.getSEOSetByID(lId);
		int result = extensionModuleDao.seoDelete(map);
		if(result == 1) { 
			 StringBuffer detail = new  StringBuffer("删除SEO信息配置表设置 :");
			 detail.append("title内容"      +seoSetEntity.getSeoTitle());
			 detail.append("描述"      +seoSetEntity.getSeoDescription());
			 detail.append("关键词"         +seoSetEntity.getSeoKeyword()); 
			 logentity.setsDetail(detail.toString()); 
			 optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
	    }
		return result;
	}
	@Override
	public int CPSPromote(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		 
		int result = extensionModuleDao.CPSPromote(map);
		if(result == 1) {
			StringBuffer detail = new  StringBuffer("CPS推荐配置设置:");
			if(Integer.valueOf(map.get("first_Invest").toString()) != -1) {
			detail.append("cps推荐首次投资返现金额"  + IntegerAndString.IntToString
					(Integer.valueOf(map.get("first_Invest").toString())));
			}
			
			if(Integer.valueOf(map.get("invite").toString()) != -1) {
			detail.append("开通第三方账户成功返现金额" +IntegerAndString.IntToString
					(Integer.valueOf(map.get("invite").toString())));
			}
			
			if(Integer.valueOf(map.get("first_Borrow").toString()) != -1) {
			detail.append("首次借款成功返现金额" +IntegerAndString.IntToString
					(Integer.valueOf(map.get("first_Borrow").toString())));
			}
			
			if(Integer.valueOf(map.get("first_Recharge").toString()) != -1) {
			detail.append("首次充值成功返现金额 " +IntegerAndString.IntToString
					(Integer.valueOf(map.get("first_Recharge").toString()))); 
			}
			logentity.setsDetail(detail.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
	@Override
	public int inviteMasterSet(int validityPeriod,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		Map<String, Object> map = new  HashMap<String,Object>();
		map.put("validity_Period", validityPeriod); 
		int result = extensionModuleDao.inviteMasterSet(map);
		if(result == 1) { 
			logentity.setsDetail("推荐关系年限:"+validityPeriod);
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
	    }
		return result;
	}
	@Override
	public int inviteMasterApplyCheck(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		if(map == null) {
			return 0;
		}
		int result = 0;
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		map.put("lId", id); 
		result = extensionModuleDao.inviteMasterApplyCheck(map);
		if(result == 1) {
			
			generatorUtil.SetIdUsed(id);
			if(map.get("checkStatu").toString().equals("1")) {
				logentity.setsDetail("推荐达人申请审核，审核通过");
			}else if(map.get("checkStatu").toString().equals("-1")) {
				logentity.setsDetail("推荐达人申请审核，审核打回");
			}
			
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
	    }else{
			generatorUtil.SetIdUsedFail(id);
	    } 
	    return result; 
    }
	@Override
	public void getIMapply(PageEntity page) {
		
		List<MemberInfoEntity> list = extensionModuleListDao.getIMapply(page); 
		PageUtil.ObjectToPage(page, list);
	}
	@Override
	public void getIMInvite(PageEntity page) {
		
		List<MemberInfoEntity> list = extensionModuleListDao.getIMInvite(page); 
		PageUtil.ObjectToPage(page, list);
		
	}
	@Override
	public void getSEODisplay(PageEntity page) {
		
		List<SeoSetEntity> list = extensionModuleListDao.getSEODisplay(page); 
		PageUtil.ObjectToPage(page, list);
		
	}
	@Override
	public CpsInviteSetEntity selectCpsInviteSet() {
		
		return extensionModuleListDao.selectCpsInviteSet();
		
	}
	@Override
	public SeoSetEntity getSEOSetByID(long seoSetID) {
		
		return extensionModuleListDao.getSEOSetByID(seoSetID);
		
	}
	@Override
	public List<SeoSetTypeEntity> getSeoSetType() {
		
		return extensionModuleListDao.getSeoSetType();
		
	}
	@Override
	public int getInviteMasterSet() {
		
		return extensionModuleListDao.getInviteMasterSet();
		
	} 
}

