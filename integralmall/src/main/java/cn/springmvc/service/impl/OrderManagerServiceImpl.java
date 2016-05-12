package cn.springmvc.service.impl;
  
import cn.integralmall.model.OrderRecordsEntity;  
import cn.integralmall.model.ShippingAddress; 
import cn.springmvc.dao.OrderManagementDao;
import cn.springmvc.dao.OrderManagementListDao; 
import cn.springmvc.dao.impl.OptRecordWriteDaoImpl;
import cn.springmvc.service.OrderManagerService;

import org.springframework.stereotype.Service;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 刘利 
 * @Description: 订单管理
 * @since 
 * @date 2016-4-22 下午8:14:44
 */
@Service("orderManagerServiceImpl")
public class OrderManagerServiceImpl implements OrderManagerService {
    @Resource(name = "orderManagementListDaoImpl")
    private OrderManagementListDao orderManagementListDao;
    @Resource(name = "orderManagementDaoImpl")
    private OrderManagementDao orderManagementDao;
	@Resource(name="optRecordWriteDaoImpl")
	private OptRecordWriteDaoImpl optRecordWriteDaoImpl;
  
	@Override
	public void selectalldOrder(PageEntity pageEntity) {
		
		List<OrderRecordsEntity> list = orderManagementListDao.selectalldOrder(pageEntity); 
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}

	@Override
	public int deliverGoods(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		
		int result = orderManagementDao.deliverGoods(map);
		if(result == 1) {
			logentity.setsDetail("商品发货");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public int CancelOrder(Map<String, Object> map,InsertAdminLogEntity 
			logentity,String[] sIpInfo) {
		 
		int result = orderManagementDao.CancelOrder(map);
		if(result == 1) {
			logentity.setsDetail("撤销订单");
			optRecordWriteDaoImpl.InsertAdminOptRecord(logentity, sIpInfo);
		}
		return result;
	}

	@Override
	public ShippingAddress ShippingAddressByID(long orderID) {
		
		return orderManagementListDao.ShippingAddressByID(orderID);
		
	}

    
}
