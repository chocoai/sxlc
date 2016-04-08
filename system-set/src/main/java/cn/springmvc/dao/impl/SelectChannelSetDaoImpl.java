
package cn.springmvc.dao.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.dao.SelectChannelSetDao;
import cn.springmvc.dao.SelectCreditorDao;
import cn.springmvc.dao.SelectQuickRechargeFeeDao;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.MailSettingsEntity;
import cn.springmvc.model.MessageTypeEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.SmsSettingsEntity;
import cn.springmvc.model.ThreeInterfaceEntity;

/** 
 * 债权转让设置查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:19:40  */
@Component("selectChannelSetDaoImpl")
public class SelectChannelSetDaoImpl extends SqlSessionDaoSupport implements SelectChannelSetDao {
	@Override
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<MessageTypeEntity> selectChannelSet() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ChannelSetXML.selectChannelSet");
	}

	@Override
	public List<SmsSettingsEntity> selectSmsSettings(PageEntity pageEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ChannelSetXML.selectSmsSettings", pageEntity, new RowBounds(pageEntity.getPageNum(),pageEntity.getPageSize()));
	}

	@Override
	public SmsSettingsEntity findSmsSettingsById(
			SmsSettingsEntity settingsEntity) {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ChannelSetXML.findSmsSettingsById",settingsEntity);
	}

	@Override
	public int countSmsSettings(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return getSqlSession().selectOne("ChannelSetXML.countSmsSettings",map);
	}

	@Override
	public MailSettingsEntity selectMailSettings() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectOne("ChannelSetXML.selectMailSettings");
	}
	
	@Override
	public List<ThreeInterfaceEntity> selectThreeInterface() {
		
		// TODO Auto-generated method stub return null;
		return getSqlSession().selectList("ChannelSetXML.selectThreeInterface");
	}
}

