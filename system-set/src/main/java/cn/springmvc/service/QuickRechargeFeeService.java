
package cn.springmvc.service; 

import java.util.List;
import java.util.Map;

import product_p2p.kit.optrecord.InsertAdminLogEntity;

import cn.springmvc.model.QuickRechargeFeeEntity;

/** 
 * 充值手续费设置查询
* @author ZZY 
* @Description: TODO 
* @since 
* @date 2016-3-14 下午5:25:37  */
public interface QuickRechargeFeeService {
	public List<QuickRechargeFeeEntity> findAllQuickRechargeFee();
	public int  updateQuickRechargeFee(Map<String, Object> map,InsertAdminLogEntity entity,String[] sIpInfo);
}

