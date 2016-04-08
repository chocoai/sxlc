package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.productIntroduceListDao;
import cn.springmvc.model.ExpertTeamEntity;
import cn.springmvc.model.PlatformAnnouncementEntity;
import cn.springmvc.model.ProductIntroduceEntity;
@Repository("productIntroduceListDaoImpl")
public class ProductIntroduceListDaoImpl  extends SqlSessionDaoSupport  implements productIntroduceListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public ProductIntroduceEntity selectProductIntroduce(int statu) {
		
		ProductIntroduceEntity platroductIntroduceentity = new  ProductIntroduceEntity();
		platroductIntroduceentity = getSqlSession().selectOne("Mapper.selectProductIntroduce",statu);
		return platroductIntroduceentity;
	}
	@Override
	public int selectProductIntroduceIsExist() {
		
		int result = 0;
		result = getSqlSession().selectOne("Mapper.selectProductIntroduceIsExist");
		return result;
	}
}
