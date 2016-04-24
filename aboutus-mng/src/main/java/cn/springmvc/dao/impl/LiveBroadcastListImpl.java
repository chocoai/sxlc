

/** 
* @Title: LiveBroadcastListImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:51:28 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.springmvc.dao.LiveBroadcastListDao;
import cn.springmvc.model.LiveBroadcastEntity;

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-4-12 下午7:51:28  */
@Repository("liveBroadcastListImpl")
public class LiveBroadcastListImpl extends SqlSessionDaoSupport implements
		LiveBroadcastListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public List<LiveBroadcastEntity> selectLiveBroadcast() {

		return getSqlSession().selectList("LiveBroadcast.selectLiveBroadcast");

	}

}

