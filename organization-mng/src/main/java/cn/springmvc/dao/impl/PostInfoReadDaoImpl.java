package cn.springmvc.dao.impl; 

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IPostInfoReadDao;
import cn.springmvc.model.PostInfo;

@Repository
public class PostInfoReadDaoImpl extends SqlSessionDaoSupport implements IPostInfoReadDao{

	
	@Override
	public List<PostInfo> getListByParam(PageEntity entity) {
		
		return getSqlSession().selectList("PostInfoDaoImpl.getListByParam",entity,new RowBounds(entity.getPageNum(),entity.getPageSize()));
	}
	
	
	@Override
	public PostInfo findById(long id) {
		
		return getSqlSession().selectOne("PostInfoDaoImpl.findById",id);
	}

	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
}

