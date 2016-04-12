
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import cn.springmvc.dao.SelectIntegralRuleDao;
import cn.springmvc.dao.SelectInterestMngFeeDao;
import cn.springmvc.dao.SelectOverdueDao;
import cn.springmvc.dao.SelectCreditorDao;
import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.IntegralRuleEntity;
import cn.springmvc.model.InterestMngFeeEntity;
import cn.springmvc.model.OverdueEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 利息管理费设置
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:19:40  */
@Component("selectInterestMngFeeDaoImpl")
public class SelectInterestMngFeeDaoImpl extends SqlSessionDaoSupport implements SelectInterestMngFeeDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<InterestMngFeeEntity> selectAllInterestMngFee() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("InterestMngFeeXML.selectAllInterestMngFee");
	}

	

}

