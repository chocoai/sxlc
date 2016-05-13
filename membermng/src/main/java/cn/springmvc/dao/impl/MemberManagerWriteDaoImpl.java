package cn.springmvc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.membermng.model.MemberResetPwdEntity;
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
	
	/**
	 * 会员重置密码
	 */
	@Override
	public Map<String, Object> memberResetPwd(Map<String, Object> param) {
		return getSqlSession().selectOne("memberManagerDao.memberResetPwd",param);
	}
		
	@Override
	public Map<String, Object> removeBlack(Map<String, Object> param) {
		return getSqlSession().selectOne("memberManagerDao.removeBlack",param);
	}
	
	//黑名单权限
	@Override
	public int addLimitList(int[] str) {
		return getSqlSession().insert("memberManagerDao.addLimtList",str);
	}

	@Override
	public int deleteLimitList() {
		return getSqlSession().update("memberManagerDao.deleteLimtList");
	}

	@Override
	public int updateAdminPwd(Map<String, Object> param) {
		return getSqlSession().update("memberManagerDao.updateAdminPwd");
	}

	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}


	
}
