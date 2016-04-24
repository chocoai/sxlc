package cn.springmvc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IPostInfoDao;
import cn.springmvc.model.PostInfo;
@Repository
public class PostInfoImpl extends SqlSessionDaoSupport implements IPostInfoDao{

	
	@Override
	public int savePost(PostInfo info) {
		
		return getSqlSession().selectOne("PostInfoDaoImpl.savePost",info);
	}

	@Override
	public int editPost(PostInfo info) {
		
		return getSqlSession().selectOne("PostInfoDaoImpl.editPost",info);
	}

	@Override
	public int delPost(PostInfo info) {
		
		return getSqlSession().selectOne("PostInfoDaoImpl.delPostInfo",info);
	}

	@Override
	public int ofPost(PostInfo info) {

		return getSqlSession().selectOne("PostInfoDaoImpl.ofPostInfo",info);
	}
	
	
	
	
	
	
	

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	

}
