

/** 
* @Title: MobilePhoneBindingDaoImpl.java 
* @Package cn.securitycenter.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-29 上午11:33:21 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.MobilePhoneBindingDao;
/** 
 * @author 刘利 
 * @Description: 会员手机号绑定
 * @since 
 * @date 2016-3-29 上午11:33:21  */
@Repository("mobilePhoneBindingDaoImpl")
public class MobilePhoneBindingDaoImpl extends SqlSessionDaoSupport implements MobilePhoneBindingDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int updatepersonPhone(Map<String, Object> map) {
		
		return getSqlSession().update("mobileBinding.updatepersonPhone", map);
		
	}

	@Override
	public int updatecompanyPhone(Map<String, Object> map) {
		
		return getSqlSession().update("mobileBinding.updatepersonPhone", map);
		
	}
}

