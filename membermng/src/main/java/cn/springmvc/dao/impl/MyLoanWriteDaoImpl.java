

/** 
* @Title: MyLoanWriteDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-3 下午7:43:35 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.IMyLoanWriteDao;

/** 自动还款设置
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-5-3 下午7:43:35  */
@Repository
public class MyLoanWriteDaoImpl extends SqlSessionDaoSupport implements IMyLoanWriteDao{
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int updateAutoPay(Map<String, Object> map) {
		
		return getSqlSession().update("myLoanReadDaoImpl.updateIsAutoPay",map);
		
	}
	
}

