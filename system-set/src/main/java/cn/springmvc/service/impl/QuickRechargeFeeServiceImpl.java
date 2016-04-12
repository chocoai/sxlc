
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.SelectQuickRechargeFeeDaoImpl;
import cn.springmvc.model.QuickRechargeFeeEntity;
import cn.springmvc.service.QuickRechargeFeeService;
@Service("quickRechargeFeeServiceImpl")
public class QuickRechargeFeeServiceImpl implements
		QuickRechargeFeeService {
	@Resource(name="selectQuickRechargeFeeDaoImpl")
	private SelectQuickRechargeFeeDaoImpl  selectQuickRechargeFeeDaoImpl;
	@Resource(name="handleQuickRechargeFeeDaoImpl")
	private HandleQuickRechargeFeeDaoImpl  handleQuickRechargeFeeDaoImpl;
	@Override
	public List<QuickRechargeFeeEntity> findAllQuickRechargeFee() {

		// TODO Auto-generated method stub return null;
		return selectQuickRechargeFeeDaoImpl.findAllQuickRechargeFee();
	}

	@Override
	public List<Object> updateQuickRechargeFee(Map<String, Object> map) {
		
		// TODO Auto-generated method stub return 0;
		return handleQuickRechargeFeeDaoImpl.updateQuickRechargeFee(map);
		
	}

}

