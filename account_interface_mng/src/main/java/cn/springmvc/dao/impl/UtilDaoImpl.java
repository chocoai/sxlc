
package cn.springmvc.dao.impl; 

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.UtilDao;
@Repository("utilDaoImpl")
public class UtilDaoImpl extends SqlSessionDaoSupport implements UtilDao{

	@Override
	public String GetOwnAccountMark() {
		return getSqlSession().selectOne("UtilDao.GetOwnAccountMark");
	}

	@Override
	public String GetInterfaceUrl(int iType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("typeId", iType);
		return getSqlSession().selectOne("UtilDao.GetInterfaceUrl",param);
	}
	
	@Override
	@Resource(name="sqlSessionFactoryR")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public String GetOwnRiskMarginAccountMark() {
		return getSqlSession().selectOne("UtilDao.GetOwnRiskMarginAccountMark"); 
	}

}

