

/** 
* @Title: MobilePhoneBindingServiceImpl.java 
* @Package cn.securitycenter.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 上午11:49:19 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;

import cn.springmvc.dao.impl.MobilePhoneBindingDaoImpl;
import cn.springmvc.dao.impl.MobilePhoneBindingListDaoImpl;
import cn.springmvc.dao.impl.RecordsBalanceDaoImpl;
import cn.springmvc.service.MobilePhoneBindingService;

/** 
 * @author 刘利 
 * @Description: 会员手机号绑定 
 * @since 
 * @date 2016-3-29 上午11:49:19  */
@Service("mobilePhoneBindingServiceImpl")
public class MobilePhoneBindingServiceImpl implements MobilePhoneBindingService {
	@Resource(name="mobilePhoneBindingListDaoImpl")
	private MobilePhoneBindingListDaoImpl mobilePhoneBindingListDaoImpl;
	@Resource(name="mobilePhoneBindingDaoImpl")
	private MobilePhoneBindingDaoImpl mobilePhoneBindingDaoImpl;
	
	@Override
	public int selectPhoneIsExist(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return mobilePhoneBindingListDaoImpl.selectPhoneIsExist(map);
		
	}

	@Override
	public int updatepersonPhone(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return mobilePhoneBindingDaoImpl.updatepersonPhone(map);
		
	}

	@Override
	public int updatecompanyPhone(Map<String, Object> map) {
		
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return mobilePhoneBindingDaoImpl.updatecompanyPhone(map);
		
	}

}

