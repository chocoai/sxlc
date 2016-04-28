package cn.springmvc.service.impl;
  
import cn.integralmall.model.OrderRecordsEntity;  
import cn.springmvc.dao.HistoricalOrderListDao; 
import cn.springmvc.service.HistoricalOrderService;

import org.springframework.stereotype.Service;
import product_p2p.kit.pageselect.PageEntity;
import product_p2p.kit.pageselect.PageUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author 刘利 
 * @Description: 历史订单
 * @since 
 * @date 2016-4-22 下午8:14:44
 */
@Service("historicalOrderServiceImpl")
public class HistoricalOrderServiceImpl implements HistoricalOrderService {
    @Resource(name = "historicalOrderListDaoImpl")
    private HistoricalOrderListDao historicalOrderListDao;

	@Override
	public void selectCompletedOrder(PageEntity pageEntity) {
		
		List<OrderRecordsEntity> list = historicalOrderListDao.selectCompletedOrder(pageEntity); 
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}

	@Override
	public void selectFailedOrder(PageEntity pageEntity) {
		
		List<OrderRecordsEntity> list = historicalOrderListDao.selectFailedOrder(pageEntity); 
		PageUtil.ObjectToPage(pageEntity, list); 
		
	}

    
}
