package cn.springmvc.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.IPostInfoDao;
import cn.springmvc.dao.IPostInfoReadDao;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.DeptInfo;
import cn.springmvc.model.PostInfo;
import cn.springmvc.service.IPostInfoServer;


@Service
public class PostInfoServerImpl implements IPostInfoServer{

	
	@Resource(name="postInfoImpl")
	private IPostInfoDao postInfoDao;
		
	@Resource(name="postInfoReadDaoImpl")
	private IPostInfoReadDao postInfoReadDao;
	
	@Resource
	private OptRecordWriteDaoImpl recordWriteDaoImpl;
	
	
	
	
	@Override
	public int delPost(PostInfo info,InsertAdminLogEntity entity,String[] sIpInfo) {
		PostInfo info2 = postInfoReadDao.findById(info.getId());
		entity.setsDetail("删除职务："+info2.getPostName());
		int result =  postInfoDao.delPost(info);
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",成功");
		}else{
			entity.setsDetail(entity.getsDetail()+",失败");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	@Override
	public int editPost(PostInfo info,InsertAdminLogEntity entity,String[] sIpInfo) {
		PostInfo info2 = postInfoReadDao.findById(info.getId());
		
		int result = postInfoDao.editPost(info);
		entity.setsDetail("修改职务：名称["+info2.getPostName()+" as "+info.getPostName()+"]");
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	@Override
	public List<PostInfo> getListByParam(PageEntity page) {
		return postInfoReadDao.getListByParam(page);
	}
	
	@Override
	public int ofPost(PostInfo info,InsertAdminLogEntity entity,String[] sIpInfo) {
		PostInfo info2 = postInfoReadDao.findById(info.getId());
		if(info.getPostStatu() == 0){
			entity.setsDetail("停用职务：名称["+info2.getPostName()+"]");
		}else{
			entity.setsDetail("启用职务：名称["+info2.getPostName()+"]");
		}
		int result = postInfoDao.ofPost(info);
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		recordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		return result;
	}
	
	@Override
	public int savePost(PostInfo info,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("添加职务：职务名称["+info.getPostName()+"]");
		int result = postInfoDao.savePost(info);
		if(result == 0){
			entity.setsDetail(entity.getsDetail()+",操作状态[成功]");
		}else{
			entity.setsDetail(entity.getsDetail()+",操作状态[失败]");
		}
		return result;
	}
	
	
}

