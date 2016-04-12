package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.PlatformIntroduceListDao; 
import cn.springmvc.model.PlatformIntroduceEntity;
@Repository("platformIntroduceListDaoImpl")
public class PlatformIntroduceListDaoImpl  extends SqlSessionDaoSupport  implements PlatformIntroduceListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public PlatformIntroduceEntity selectPlatformIntroduce() {
		
		PlatformIntroduceEntity platroductIntroduceentity = new  PlatformIntroduceEntity();
		platroductIntroduceentity = getSqlSession().selectOne("platformIntroduce.selectPlatformIntroduce");
		return platroductIntroduceentity;
	}
	@Override
	public int selectPlatformIntroducesIsExist() {
		
		int result = 0;
		result = getSqlSession().selectOne("platformIntroduce.selectplatformIntroducesIsExist");
		return result;
	}
 
}
