package cn.springmvc.service.impl;
 
import java.util.List; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;  

import cn.springmvc.dao.FriendshipLinkDao;
import cn.springmvc.dao.FriendshipLinkListDao; 
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.model.FriendshipUnitEntity;  
import cn.springmvc.service.FriendshipLinkService;
/**
 * 
* @author 刘利 
* @Description: 实现友情链接的增加，删除，修改，查询功能 
* @since 
* @date 2016-3-19 下午8:10:25
 */
@Service("friendshipLinkServiceImpl")
public class FriendshipLinkServiceImpl implements FriendshipLinkService {
	@Resource(name="friendshipLinkDaoImpl")
	private FriendshipLinkDao friendshipLinkDaoImpl;  
	@Resource(name="friendshipLinkListDaoImpl")
	private FriendshipLinkListDao friendshipLinkListDaoImpl;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public int insertFriendshipLink(FriendshipUnitEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的友情链接是否存在,如果已存在则不插入  
		FriendshipUnitEntity friendshipUnitEntity= friendshipLinkListDaoImpl.
				selectFriendshipLinkIsExistByNAme(entity);
		
		if(friendshipUnitEntity != null) {
			return -1;
		} 
		IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
		long id = generatorUtil.GetId();
		entity.setId(id);
		int result = friendshipLinkDaoImpl.insertFriendshipLink(entity);
		if(result == 0) {
			generatorUtil.SetIdUsedFail(id);
		}else{
			generatorUtil.SetIdUsed(id);
			logentity.setsDetail("添加友情链接 :"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result; 
	}

	@Override
	public int deleteFriendshipLinkByID(long id,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		FriendshipUnitEntity friendshipUnitEntity = friendshipLinkListDaoImpl.
				selectFriendshipLinkByID(id);
		
		int result = friendshipLinkDaoImpl.deleteFriendshipLinkByID(id);
		if(result == 1) {
		    logentity.setsDetail("删除友情链接  :"+friendshipUnitEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int updateFriendshipLinkByID(FriendshipUnitEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的友情链接是否存在,如果已存在则不插入  
		FriendshipUnitEntity friendshipUnitEntity = friendshipLinkListDaoImpl.
				selectFriendshipLinkIsExistByNAme(entity);
		
		if(friendshipUnitEntity != null){
			return -1;
		} 
		int result = friendshipLinkDaoImpl.updateFriendshipLinkByID(entity);
		if(result == 1) {
		    logentity.setsDetail("修改友情链接  :"+entity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	} 
	@Override
	public int updateFriendShipLinkStatuByID(FriendshipUnitEntity entity,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		if(entity == null) {
			return 0;
		} 
		FriendshipUnitEntity friendshipUnitEntity = friendshipLinkListDaoImpl.
				selectFriendshipLinkByID(entity.getId());
		
		int result = friendshipLinkDaoImpl.updateFriendShipLinkStatuByID(entity); 
		if(result == 1 && entity.isStatu()) {
			logentity.setsDetail("启用友情链接 :"+friendshipUnitEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}else if(result == 1 && !entity.isStatu()){
			logentity.setsDetail("停用友情链接 :"+friendshipUnitEntity.getName());
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}
	@Override
	public List<FriendshipUnitEntity>  selectFriendshipLinkListpage(PageEntity pageEntity) {
		
		List<FriendshipUnitEntity> friendshipLinkList = null;    
	 	friendshipLinkList = friendshipLinkListDaoImpl.selectFriendshipLinkAllpage(pageEntity);    
		return friendshipLinkList; 
	}

 	
	@Override
	public FriendshipUnitEntity selectFriendshipLinkByID(long id) {
		
		FriendshipUnitEntity friendshipUnitEntity = friendshipLinkListDaoImpl.selectFriendshipLinkByID(id);
		return friendshipUnitEntity; 
		
	}

	@Override
	public List<FriendshipUnitEntity> selectFriendShipLinkfront() {
		
		List<FriendshipUnitEntity> friendshipLinkList = null;    
	 	friendshipLinkList = friendshipLinkListDaoImpl.selectFriendShipLinkfront();    
		return friendshipLinkList; 
		
	}
}
