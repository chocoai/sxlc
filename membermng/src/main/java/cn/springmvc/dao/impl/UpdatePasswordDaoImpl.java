

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

import cn.springmvc.dao.UpdatePasswordDao;

/** 
 * @author 刘利 
 * @Description: 会员邮箱验证
 * @since 
 * @date 2016-3-29 上午11:33:21  */
@Repository("updatePasswordDaoImpl")
public class UpdatePasswordDaoImpl extends SqlSessionDaoSupport implements UpdatePasswordDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public int updatepersonPassword(Map<String, Object> map) {
		int result = getSqlSession().update("password.updatepersonPassword",map);
		return result;
		
	}

}

