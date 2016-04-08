package cn.springmvc.dao.impl; 
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.FriendshipLinkDao;
import cn.springmvc.model.FriendshipUnitEntity; 
@Repository("friendshipLinkDaoImpl")
public class FriendshipLinkDaoImpl extends SqlSessionDaoSupport implements FriendshipLinkDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public int insertFriendshipLink(FriendshipUnitEntity entity) {
		
		int iResult = 0;
		if(entity == null) {
			return iResult;
		}
		iResult = getSqlSession().insert("friendshipUnit.insertFriendShipLink", entity);
		return iResult;
	} 
	@Override
	public int updateFriendshipLinkByID(FriendshipUnitEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("friendshipUnit.updateFriendShipLinkByID", entity);
		return result;
	}

	@Override
	public int deleteFriendshipLinkByID(int id) {
		
		int result = 0;
		result = getSqlSession().delete("friendshipUnit.deleteFriendShipLinkByID", id);
		return result;
	} 
	@Override
	public int updateFriendShipLinkStatuByID(FriendshipUnitEntity entity) {
		
		int result = 0;
		result = getSqlSession().update("friendshipUnit.updateFriendShipLinkStatuByID", entity);
		return result;
	}
 
}
