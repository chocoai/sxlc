

/** 
* @Title: CreditorTransferCheckServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-25 下午12:44:09 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;
import cn.springmvc.dao.CreditorTransferCheckDao;
import cn.springmvc.dao.CreditorTransferCheckListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.CreditorTransferCheckEntity;
import cn.springmvc.service.CreditorTransferCheckService;

/** 
 * @author 刘利 
 * @Description:债权转让管理
 * @since 
 * @date 2016-4-25 下午12:44:09  */
@Service("creditorTransferCheckServiceImpl")
public class CreditorTransferCheckServiceImpl implements
		CreditorTransferCheckService {
	@Resource(name="creditorTransferCheckListDaoImpl")
    private CreditorTransferCheckListDao creditorTransferCheckListDao;
	@Resource(name="creditorTransferCheckDaoImpl")
	private CreditorTransferCheckDao creditorTransferCheckDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public void selectCreditorTransferManager(PageEntity pageEntity) {

		List<CreditorTransferCheckEntity> list = creditorTransferCheckListDao.
				selectCreditorTransferManager(pageEntity);
		PageUtil.ObjectToPage(pageEntity, list);

	}
	@Override
	public CreditorTransferCheckEntity selectCreditorTransferDetailCheck(
			long ctaId) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ctaId", ctaId);
		map.put("sKey",  DbKeyUtil.GetDbCodeKey());
		return creditorTransferCheckListDao.selectCreditorTransferDetailCheck(map);
		
	}
	@Override
	public int creditorTransAppCheck(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		map.put("lID", id);
		int result = creditorTransferCheckDao.creditorTransAppCheck(map);
		if(result == 1) {
			generatorUtil.SetIdUsed(id);
			Map<String, Object> map2 = new HashMap<String,Object>();
			map2.put("ctaId", IntegerAndString.StringToInt(map.get("ctaId").toString(),0));
			map2.put("sKey",  DbKeyUtil.GetDbCodeKey());
			CreditorTransferCheckEntity entity = creditorTransferCheckListDao.
					selectCreditorTransferDetailCheck(map2);
			StringBuffer detail =new StringBuffer("债权转让审核:");
			detail.append("项目名称"+entity.getProjectTitle());
			detail.append("转让人"+entity.getTranMemberName());
			logentity.setsDetail(detail.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else{
			generatorUtil.SetIdUsedFail(id);
		} 
		return result;
	}
	@Override
	public int updateTransMaxTime(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(map == null || map.get("transMaxTime") == null) {
			return 0;
		}
		int result = creditorTransferCheckDao.updateTransMaxTime(map);
		if(result == 1) {
			Map<String, Object> map2 = new HashMap<String,Object>();
			map2.put("ctaId", IntegerAndString.StringToInt(map.get("ctaId").toString(),0));
			map2.put("sKey",  DbKeyUtil.GetDbCodeKey());
			CreditorTransferCheckEntity entity = creditorTransferCheckListDao.
					selectCreditorTransferDetailCheck(map2);
			StringBuffer detail =new StringBuffer("修改:");
			detail.append("项目名称"+entity.getProjectTitle());
			detail.append("转让人"+entity.getTranMemberName());
			detail.append("的投标结束时间为"+map.get("transMaxTime").toString());
			logentity.setsDetail(detail.toString());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
	@Override
	public String selectTransMaxTime(long ctaId) {
		
		return creditorTransferCheckListDao.selectTransMaxTime(ctaId);
		
	}

}

