package cn.springmvc.dao;

import java.util.List;  
 
import cn.integralmall.model.OrderRecordsEntity;

import product_p2p.kit.pageselect.PageEntity;
 
/**
 * 
 * @author 刘利 
 * @Description: 历史订单
 * @since 
 * @date 2016-4-22 上午11:58:35
 */
public interface HistoricalOrderListDao {
	
	/**
	 * 已完成定单 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  pageEntity
	 * {commodityName商品名称,commodityNO商品编号,ExchangestartTime,ExchangeendTime兑换时间 
	 * DeliverystartTime,DeliveryendTime发货时间,logname会员用户名,memberName会员姓名
	 * personalPhone联系电话,
	 * backorder(1兑换时间 降序，-1兑换时间 升序，2发货时间 降序，-2发货时间 升序 ，3兑换数量降序，-3兑换数量升序
	 * ，4发货时间降序，-4发货时间升序，5应付积分降序，-5应付积分升序，6实际使用积分降序，-6实际使用积分升序，
	 * 7收货时间降序，-7收货时间升序)}
	 * @param @return 设定文件 
	 * @return List<OrderRecordsEntity> 返回类型 
	 * @date 2016-4-22 下午8:01:16
	 */
	public List<OrderRecordsEntity>  selectCompletedOrder(PageEntity pageEntity); 
	
	/**
	 * 失败定单 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  pageEntity
	 * {commodityName商品名称,commodityNO商品编号,ExchangestartTime,ExchangeendTime兑换时间 
	 * DeliverystartTime,DeliveryendTime发货时间,logname会员用户名,memberName会员姓名
	 * personalPhone联系电话,
	 * backorder(1兑换时间 降序，-1兑换时间 升序，2发货时间 降序，-2发货时间 升序 ，3兑换数量降序，-3兑换数量升序
	 * ，4发货时间降序，-4发货时间升序，5应付积分降序，-5应付积分升序，6实际使用积分降序，-6实际使用积分升序，
	 * 7订单撤销降序，-7订单撤销升序)}
	 * @param @return 设定文件 
	 * @return List<OrderRecordsEntity> 返回类型 
	 * @date 2016-4-22 下午8:01:16
	 */
	public List<OrderRecordsEntity>  selectFailedOrder(PageEntity pageEntity); 
 
	
}
