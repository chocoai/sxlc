package cn.springmvc.dao.impl;
 

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.LawsRegulationsListDao; 
import cn.springmvc.model.LawsRegulationsEntity;
@Repository("lawsRegulationsListDaoImpl")
public class LawsRegulationsListDaoImpl  extends SqlSessionDaoSupport  implements LawsRegulationsListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public LawsRegulationsEntity selectLawsRegulations(int statu) {
		LawsRegulationsEntity platroductIntroduceentity = new  LawsRegulationsEntity();
		platroductIntroduceentity = getSqlSession().selectOne("lawsRegulations.selectLawsRegulations",statu);
		return platroductIntroduceentity;
	}
	@Override
	public int selectLawsRegulationsIsExist() {
		int result = 0;
		result = getSqlSession().selectOne("lawsRegulations.selectLawsRegulationsIsExist");
		return result;
	}
}
