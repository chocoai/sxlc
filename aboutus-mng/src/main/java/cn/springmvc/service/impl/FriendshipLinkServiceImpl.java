package cn.springmvc.service.impl;

import java.util.ArrayList; 
import java.util.List; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity; 
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.FriendshipLinkDao;
import cn.springmvc.dao.FriendshipLinkListDao;
import cn.springmvc.dao.impl.FriendshipLinkDaoImpl; 
import cn.springmvc.dao.impl.FriendshipLinkListDaoImpl;
import cn.springmvc.dao.impl.IdGeneratorUtil;
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
	@Override
	public int insertFriendshipLink(FriendshipUnitEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的友情链接是否存在,如果已存在则不插入  
		FriendshipUnitEntity friendshipUnitEntity= friendshipLinkListDaoImpl.selectFriendshipLinkIsExistByNAme(entity);
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
		}
		return result; 
	}

	@Override
	public int deleteFriendshipLinkByID(int id) {
		
		int result = friendshipLinkDaoImpl.deleteFriendshipLinkByID(id); 
		return result;
	}

	@Override
	public int updateFriendshipLinkByID(FriendshipUnitEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		// 查询该名称的友情链接是否存在,如果已存在则不插入  
		FriendshipUnitEntity friendshipUnitEntity = friendshipLinkListDaoImpl.selectFriendshipLinkIsExistByNAme(entity);
		if(friendshipUnitEntity != null){
			return -1;
		} 
		int result = friendshipLinkDaoImpl.updateFriendshipLinkByID(entity); 
		return result;
	} 
	@Override
	public int updateFriendShipLinkStatuByID(FriendshipUnitEntity entity) {
		
		if(entity == null) {
			return 0;
		} 
		int result = friendshipLinkDaoImpl.updateFriendShipLinkStatuByID(entity); 
		return result;
	}
	@Override
	public List<FriendshipUnitEntity>  selectFriendshipLinkListpage(PageEntity pageEntity) {
		
		List<FriendshipUnitEntity> friendshipLinkList = null;    
	 	friendshipLinkList = friendshipLinkListDaoImpl.selectFriendshipLinkAllpage(pageEntity);    
		return friendshipLinkList; 
	}

 	
	@Override
	public FriendshipUnitEntity selectFriendshipLinkByID(int id) {
		
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
