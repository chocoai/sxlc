package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IPostInfoDao;
import cn.springmvc.model.PostInfo;
import cn.springmvc.service.IPostInfoServer;


@Service
public class PostInfoServerImpl implements IPostInfoServer{

	
	@Resource(name="postInfoImpl")
	private IPostInfoDao postInfoDao;
	
	@Override
	public int delPost(PostInfo info) {
		return postInfoDao.delPost(info);
	}
	
	@Override
	public int editPost(PostInfo info) {
		return postInfoDao.editPost(info);
	}
	
	@Override
	public List<PostInfo> getListByParam(PageEntity page) {
		return postInfoDao.getListByParam(page);
	}
	
	@Override
	public int ofPost(PostInfo info) {
		return postInfoDao.ofPost(info);
	}
	
	@Override
	public int savePost(PostInfo info) {
		return postInfoDao.savePost(info);
	}
	
	
	
	
}

