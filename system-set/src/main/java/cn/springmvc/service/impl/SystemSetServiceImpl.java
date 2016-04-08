
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.HandleCreditorDaoImpl;
import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.HandleSystemSetDaoImpl;
import cn.springmvc.dao.impl.SelectCreditorDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.SelectSystemSetDaoImpl;
import cn.springmvc.model.CreditorEntity;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.model.SystemInfoSetEntity;
import cn.springmvc.model.SystemSetEntity;
import cn.springmvc.service.CreditorService;
import cn.springmvc.service.QuickRechargeFeeService;
import cn.springmvc.service.SystemSetService;

/** 
 * 债权转让设置 接口实现
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-15 上午9:38:07  */
@Service("systemSetServiceImpl")
public class SystemSetServiceImpl implements
 SystemSetService {
	@Resource(name="selectSystemSetDaoImpl")
	private SelectSystemSetDaoImpl  selectSystemSetDaoImpl;
	
	@Resource(name="handleSystemSetDaoImpl")
	private HandleSystemSetDaoImpl  handleSystemSetDaoImpl;

	@Override
	public SystemSetEntity findSystemSet() {
		
		// TODO Auto-generated method stub return null;
		return selectSystemSetDaoImpl.findSystemSet();
	}

	@Override
	public int updateSystemSet(SystemSetEntity systemSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.updateSystemSet(systemSetEntity);
	}

	@Override
	public int insertSystemSet(SystemSetEntity systemSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.insertSystemSet(systemSetEntity);
	}

	@Override
	public SystemInfoSetEntity findSystemInfoSet() {
		
		// TODO Auto-generated method stub return null;
		return selectSystemSetDaoImpl.findSystemInfoSet();
	}

	@Override
	public int updateSystemInfoSet(SystemInfoSetEntity systemSetInfoEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.updateSystemInfoSet(systemSetInfoEntity);
	}

	@Override
	public int insertSystemInfoSet(SystemInfoSetEntity systemInfoSetEntity) {
		
		// TODO Auto-generated method stub return 0;
		return handleSystemSetDaoImpl.insertSystemInfoSet(systemInfoSetEntity);
	}
	

}

