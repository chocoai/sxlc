package cn.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;
 
import cn.springmvc.dao.FriendshipLinkListDao;
import cn.springmvc.model.FriendshipUnitEntity;
/**
 * 
* @author 刘利 
* @Description: 实现友情链接查询功能类
* @since 
* @date 2016-3-19 下午8:08:27
 */
@Repository("friendshipLinkListDaoImpl")
public class FriendshipLinkListDaoImpl extends SqlSessionDaoSupport implements FriendshipLinkListDao{
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public FriendshipUnitEntity selectFriendshipLinkIsExistByNAme(
			FriendshipUnitEntity entity) {
		
		FriendshipUnitEntity friendshipUnitEntity = null;
		friendshipUnitEntity = (FriendshipUnitEntity) getSqlSession().selectOne("friendshipUnit.selectFriendShipLinkIsExistByNAme",entity);
		return friendshipUnitEntity;
	}
	@Override
	public List<FriendshipUnitEntity> selectFriendshipLinkAllpage(PageEntity pageEntity) {
		
		List<FriendshipUnitEntity> friendshipLinkList=null;
		friendshipLinkList = getSqlSession().selectList("friendshipUnit.selectFriendShipLinkList",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		return friendshipLinkList;
	}
	 
	
	@Override
	public FriendshipUnitEntity selectFriendshipLinkByID(int id) {
		
		FriendshipUnitEntity friendshipUnitEntity=null;
		friendshipUnitEntity = (FriendshipUnitEntity) getSqlSession().selectOne("friendshipUnit.selectFriendShipLinkByID",id);
		return friendshipUnitEntity;
		
	}
	@Override
	public List<FriendshipUnitEntity> selectFriendShipLinkfront() {
		
		List<FriendshipUnitEntity> friendshipLinkList=null;
		friendshipLinkList = getSqlSession().selectList("friendshipUnit.selectFriendShipLinkfront");
		return friendshipLinkList;
		
	}
}
