package cn.springmvc.dao;

import java.util.List;  
import cn.integralmall.model.OrderRecordsEntity;
import cn.integralmall.model.ShippingAddress;

import product_p2p.kit.pageselect.PageEntity;
 
/**
 * 
 * @author 刘利 
 * @Description: 订单管理
 * @since 
 * @date 2016-4-11 上午11:58:35
 */
public interface OrderManagementListDao {
	/**
	 * 已完成定单 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  pageEntity
	 * {commodityName商品名称,commodityNO商品编号,ExchangestartTime,ExchangeendTime兑换时间 
	 * DeliverystartTime,DeliveryendTime发货时间,logname会员用户名,memberName会员姓名
	 * personalPhone联系电话,orderType状态
	 * backorder(1兑换时间 降序，-1兑换时间 升序，2发货时间 降序，-2发货时间 升序 ，3兑换数量降序，-3兑换数量升序
	 * ，4发货时间降序，-4发货时间升序，5应付积分降序，-5应付积分升序)}
	 * @param @return 设定文件 
	 * @return List<OrderRecordsEntity> 返回类型 
	 * @date 2016-4-22 下午8:01:16
	 */
	public List<OrderRecordsEntity>  selectalldOrder(PageEntity pageEntity); 
	/**
	 * 根据ID查询收货地址 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param addressID
	 * @param @return 设定文件 
	 * @return ShippingAddress 返回类型 
	 * @date 2016-4-23 下午8:43:26
	 */
	public  ShippingAddress  ShippingAddressByID(long addressID);
	
}
