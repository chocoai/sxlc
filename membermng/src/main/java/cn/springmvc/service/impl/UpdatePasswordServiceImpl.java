

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

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import cn.springmvc.dao.impl.RecordsBalanceDaoImpl;
import cn.springmvc.dao.impl.UpdatePasswordDaoImpl;
import cn.springmvc.dao.impl.UpdatePasswordListDaoImpl;
import cn.springmvc.service.UpdatePasswordService;
/** 
 * @author 刘利 
 * @Description: 会员手机号绑定 
 * @since 
 * @date 2016-3-29 上午11:49:19  */
@Service("updatePasswordServiceImpl")
public class UpdatePasswordServiceImpl implements UpdatePasswordService {
	@Resource(name="updatePasswordDaoImpl")
	private UpdatePasswordDaoImpl updatePasswordDaoImpl;
	@Resource(name="updatePasswordListDaoImpl")
	private UpdatePasswordListDaoImpl updatePasswordListDaoImpl;
	
	@Override
	public int updatepersonPassword(Map<String, Object> map) {
		
		return updatePasswordDaoImpl.updatepersonPassword(map);
		
	}
	@Override
	public int checkPassword(Map<String, Object> map) {
		
		return updatePasswordListDaoImpl.checkPassword(map);
		
	}
	
 
}

