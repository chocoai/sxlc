package cn.springmvc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IPostInfoDao;
import cn.springmvc.model.PostInfo;
@Repository
public class PostInfoImpl extends SqlSessionDaoSupport implements IPostInfoDao{

	
	@Override
	public int savePost(PostInfo info) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", info.getId());
		map.put("deptId", info.getDeptId());
		map.put("postNo", info.getPostNo());
		map.put("postName", info.getPostName());
		map.put("postRemark", info.getPostRemark());
		
		getSqlSession().selectOne("PostInfoDaoImpl.savePost",map);
		return IntegerAndString.StringToInt(map.get("result").toString(), -1);
	}

	@Override
	public int editPost(PostInfo info) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", info.getId());
		map.put("deptId", info.getDeptId());
		map.put("postName", info.getPostName());
		map.put("postRemark", info.getPostRemark());
		getSqlSession().selectOne("PostInfoDaoImpl.editPost",map);
		return IntegerAndString.StringToInt(map.get("result").toString(), -1);
	}

	@Override
	public int delPost(PostInfo info) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", info.getId());
		getSqlSession().selectOne("PostInfoDaoImpl.delPostInfo",map);
		return IntegerAndString.StringToInt(map.get("result").toString(), -1);
	}

	@Override
	public int ofPost(PostInfo info) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", info.getId());
		map.put("postStatu", info.getPostStatu());
		getSqlSession().selectOne("PostInfoDaoImpl.ofPostInfo",map);
		return IntegerAndString.StringToInt(map.get("result").toString(), -1);
	}

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	

}
