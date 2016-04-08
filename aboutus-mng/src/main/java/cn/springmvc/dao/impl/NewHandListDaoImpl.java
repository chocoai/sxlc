package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.NewHandListDao; 
import cn.springmvc.model.NewHandEntity;
@Repository("newHandListDaoImpl")
public class NewHandListDaoImpl  extends SqlSessionDaoSupport  implements NewHandListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public NewHandEntity selectNewHand() {
		
		NewHandEntity platroductIntroduceentity = new  NewHandEntity();
		platroductIntroduceentity = getSqlSession().selectOne("newHand.selectNewHand");
		return platroductIntroduceentity;
	}
	@Override
	public int selectNewHandIsExist() {
		
		int result = 0;
		result = getSqlSession().selectOne("newHand.selectNewHandIsExist");
		return result;
	}
 
}
