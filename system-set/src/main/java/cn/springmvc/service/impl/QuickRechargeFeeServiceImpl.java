
package cn.springmvc.service.impl; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.datatrans.IntegerAndString;
import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.dao.impl.HandleQuickRechargeFeeDaoImpl;
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
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
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
	@Override
	public List<QuickRechargeFeeEntity> findAllQuickRechargeFee() {

		// TODO Auto-generated method stub return null;
		return selectQuickRechargeFeeDaoImpl.findAllQuickRechargeFee();
	}

	@Override
	public int updateQuickRechargeFee(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo) {
		entity.setsDetail("充值手续费设置 :"+map.toString());
		optRecordWriteDaoImpl.InsertAdminOptRecord(entity, sIpInfo);
		// TODO Auto-generated method stub return 0;
		map = handleQuickRechargeFeeDaoImpl.updateQuickRechargeFee(map);
		int re=IntegerAndString.StringToInt(map.get("rev").toString(), 0);
		return re;
		
	}

}

