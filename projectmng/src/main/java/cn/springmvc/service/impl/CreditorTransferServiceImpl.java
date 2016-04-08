

/** 
* @Title: CreditorTransferServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-6 上午11:39:52 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.CreditorTransferListDao;
import cn.springmvc.model.CreditorTransferListEntity;
import cn.springmvc.model.InvestEntity;
import cn.springmvc.service.CreditorTransferService;

/** 
 * @author 刘利 
 * @Description: 债权转让
 * @since 
 * @date 2016-4-6 上午11:39:52  */
@Service("creditorTransferServiceImpl")
public class CreditorTransferServiceImpl implements CreditorTransferService {
	@Resource(name="creditorTransferListDaoImpl")
	private CreditorTransferListDao creditorTransferListDao;  
	@Override
	public List<CreditorTransferListEntity> selectCreditorTransferList(
			PageEntity pageEntity) {

		return creditorTransferListDao.selectCreditorTransferList(pageEntity);

	}
	@Override
	public CreditorTransferListEntity selectCreditorTransferDetail(int ctaId) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		map.put("ctaId",ctaId);
	    return creditorTransferListDao.selectCreditorTransferDetail(map);
		
	}
	@Override
	public CreditorTransferListEntity selectCreditorAvailableaAmount(int ctaId) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		map.put("ctaId",ctaId);
		return creditorTransferListDao.selectCreditorAvailableaAmount(map);
	}
	@Override
	public List<InvestEntity> selectCreditorInvestRecordByctaId(int ctaId) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		map.put("ctaId",ctaId);
		return creditorTransferListDao.selectCreditorInvestRecordByctaId(map);
	}

}

