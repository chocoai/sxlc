
package cn.springmvc.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.SelectOverdueDao;
import cn.springmvc.dao.SelectCreditorDao;
import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 债权转让设置查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:19:40  */
@Component("selectOverdueDaoImpl")
public class SelectOverdueDaoImpl extends SqlSessionDaoSupport implements SelectOverdueDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	/* * 
	 * 查询所有逾期费率时间设置
	 *  *  * @return * @see cn.springmvc.dao.SelectOverdueDao#findAllOverdue() */
	@Override
	public List<OverdueEntity> findAllOverdue(PageEntity pageEntity) {
		return getSqlSession().selectList("OverdueXML.selectOverdue",pageEntity,new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}
	
	/* * 
	 * 逾期程度界限查询
	 *  *  * @return * @see cn.springmvc.dao.SelectOverdueDao#findOverdueLimit() */
	@Override
	public Integer findOverdueLimit() {
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("OverdueXML.findOverdueLimit");
	}

	@Override
	public int findMaxOverdue() {
		// TODO Auto-generated method stub return 0;
		Long result=getSqlSession().selectOne("OverdueXML.findMaxOverdue");
		int res=0;
		if (result!=null) {
			res=IntegerAndString.StringToInt(result.toString(), 0);
		}
		return res;
	}
	
	
	

}

