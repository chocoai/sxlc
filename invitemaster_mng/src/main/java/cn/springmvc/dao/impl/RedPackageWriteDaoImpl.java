
package cn.springmvc.dao.impl; 

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.IRedPackageWriteDao;

@Repository
public class RedPackageWriteDaoImpl extends SqlSessionDaoSupport implements IRedPackageWriteDao {

	@Override
	public int grabRedPackage(Map<String,Object> param) {
		getSqlSession().selectOne("redPackageDao.grabRedPackage",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), 0);
	}

	@Override
	public int lotteryEnd(Map<String, Object> param) {
		getSqlSession().selectOne("redPackageDao.lotteryEnd",param);
		return IntegerAndString.StringToInt(param.get("result").toString(), 0);
	}
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}

