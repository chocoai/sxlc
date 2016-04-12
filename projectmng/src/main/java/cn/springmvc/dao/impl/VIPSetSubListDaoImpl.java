package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.VIPSetSubListDao; 
import cn.springmvc.model.VIPSetSubEntity;
@Repository("vipSetSubListDaoImpl")
public class VIPSetSubListDaoImpl  extends SqlSessionDaoSupport  implements VIPSetSubListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public VIPSetSubEntity selectVIPSetSub() {
		VIPSetSubEntity platroductIntroduceentity=new  VIPSetSubEntity();
		platroductIntroduceentity=getSqlSession().selectOne("vipSetSub.selectVIPSetSub");
		return platroductIntroduceentity;
	}
	@Override
	public int selectVIPSetSubIsExist() {
		int result=0;
		result=getSqlSession().selectOne("vipSetSub.selectVIPSetSubsIsExist");
		return result;
	} 
 
}
