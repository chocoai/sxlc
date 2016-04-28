package cn.springmvc.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.IMemberManagerWriteDao;


/***
 * 
* @author 李杰
* @Description: TODO 
* @since 5.0
* @date 2016-3-18 下午6:50:58
 */
@Repository
public class MemberManagerWriteDaoImpl extends SqlSessionDaoSupport implements IMemberManagerWriteDao {
	
	
	
	@Override
	public int pullBlack(Map<String,Object> param) {
		getSqlSession().selectOne("memberManagerDao.pullBlack",param);
		return Integer.parseInt(param.get("result").toString());
	}
	
	
	
	
	
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
}
