

/** 
* @Title: MobileEmailBindingServiceImpl.java 
* @Package cn.securitycenter.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 上午11:49:19 
* @version V5.0 */
 
package cn.springmvc.service.impl; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.dbkey.DbKeyUtil;
 
import cn.springmvc.dao.EmailBindingDao;
import cn.springmvc.dao.EmailBindingListDao;
import cn.springmvc.dao.impl.EmailBindingDaoImpl;
import cn.springmvc.dao.impl.EmailBindingListDaoImpl;
import cn.springmvc.dao.impl.RecordsBalanceDaoImpl;
import cn.springmvc.service.EmailBindingService;

/** 
 * @author 刘利 
 * @Description: 会员邮箱绑定 
 * @since 
 * @date 2016-3-29 上午11:49:19  */
@Service("emailBindingServiceImpl")
public class EmailBindingServiceImpl implements EmailBindingService {
	@Resource(name="emailBindingListDaoImpl")
	private EmailBindingListDao emailBindingListDaoImpl;
	@Resource(name="emailBindingDaoImpl")
	private EmailBindingDao emailBindingDaoImpl;
	
	@Override
	public int selectEmailIsExist(Map<String, Object> map) {
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		return emailBindingListDaoImpl.selectEmailIsExist(map);
		
	}

	@Override
	public int updatepersonEmail(Map<String, Object> map) {
	   
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		int result = emailBindingListDaoImpl.selectEmailIsExist(map);
		if (result >0 ) {
			return -1;
		}
		return emailBindingDaoImpl.updatepersonEmail(map);
		
	}

//	@Override
//	public int updatecompanyEmail(Map<String, Object> map) {
//		
//		map.put("sKey", DbKeyUtil.GetDbCodeKey());
//		return emailBindingDaoImpl.updatecompanyEmail(map);
//		
//	}

	@Override
	public String selectOldEmail(long memberId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sKey", DbKeyUtil.GetDbCodeKey());
		map.put("memberId",              memberId);
		return emailBindingListDaoImpl.selectOldEmail(map);
		
	}

	@Override
	public int checkEmail(Map<String, Object> map) {
		 
		map.put("sKey", DbKeyUtil.GetDbCodeKey()); 
		return emailBindingListDaoImpl.checkEmail(map);
		
	}

}

