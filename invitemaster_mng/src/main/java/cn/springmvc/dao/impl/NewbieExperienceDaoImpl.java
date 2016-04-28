

/** 
* @Title: NewbieExperienceDaoImpl.java 
* @Package cn.springmvc.dao.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午2:28:40 
* @version V5.0 */
 
package cn.springmvc.dao.impl; 

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import product_p2p.kit.datatrans.IntegerAndString;

import cn.springmvc.dao.NewbieExperienceDao;

/** 
 * @author 刘利 
 * @Description: 新手体验标 
 * @since 
 * @date 2016-4-15 下午2:28:40  */
@Repository("newbieExperienceDaoImpl")
public class NewbieExperienceDaoImpl extends SqlSessionDaoSupport implements
		NewbieExperienceDao {
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	} 
	@Override
	public int NewbieExperienceSet(Map<String, Object> map) {

		getSqlSession().selectOne("Newbie_Experience.NewbieExperienceSet",map);
		return IntegerAndString.StringToInt(map.get("result").toString(),0);

	}

}

