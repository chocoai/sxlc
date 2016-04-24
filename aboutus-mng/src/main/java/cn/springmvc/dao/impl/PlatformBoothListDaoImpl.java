

/** 
* @Title: PlatformBoothDao.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-12 下午7:16:27 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.PlatformBoothListDao;
import cn.springmvc.model.PlatformBoothEntity;

/** 
 * @author 刘利 
 * @Description: 平台宣传点
 * @since 
 * @date 2016-4-12 下午7:16:27  */
@Repository("platformBoothListDaoImpl")
public class PlatformBoothListDaoImpl extends SqlSessionDaoSupport implements PlatformBoothListDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<PlatformBoothEntity> selectPlatformBooth() {
		
		return getSqlSession().selectList("PlatformBooth.selectPlatformBoothList");
		
	}

	@Override
	public List<PlatformBoothEntity> selectPlatformBoothList(
			PageEntity pageEntity) {
		
		return getSqlSession().selectList("PlatformBooth.selectPlatformBoothList",
				pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
		
	}

	@Override
	public PlatformBoothEntity selectPlatformBoothByID(long sgID) {
		
		return getSqlSession().selectOne("PlatformBooth.selectPlatformBoothByID",sgID);
		
	}

	@Override
	public int selectPlatformBoothIsExistByTitle(
			PlatformBoothEntity platformBoothEntity) {
		
		return getSqlSession().selectOne("PlatformBooth.selectPlatformBoothIsExistByTitle",
				platformBoothEntity);
		
	}
}

