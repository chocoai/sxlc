package cn.springmvc.service;
 
import java.util.Map;

import cn.integralmall.model.ShippingAddress;

import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
 
/**
 * 
 * @author 刘利 
 * @Description: 订单管理
 * @since 
 * @date 2016-4-11 下午9:08:18
 */
public interface OrderManagerService {
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
	 * @return void 返回类型 
	 * @date 2016-4-22 下午8:01:16
	 */
	public void selectalldOrder(PageEntity pageEntity); 
	/**
	 * 发货
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {OrderID订单ID,adminID管理员ID，logisticsCompany物流公司，logisticsNO物流单号，InformationIN通知信息内容}
	 * @param @return 设定文件 
	 * @return int 返回类型 1成功 0失败 -1 该商品已发货或者已撤销
	 * @date 2016-4-23 下午7:52:59
	 */
	 public int deliverGoods(Map<String,Object> map,InsertAdminLogEntity 
				logentity,String[] sIpInfo);
    /**
	 * 撤销订单
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {OrderID订单ID,adminID管理员ID,revocationReason撤销原因}
	 * @param @return 设定文件 
	 * @return int 返回类型 1成功 0失败 -1该商品已收货或者已撤销
	 * @date 2016-4-23 下午7:52:59
	 */
	 public int CancelOrder(Map<String,Object> map,InsertAdminLogEntity 
				logentity,String[] sIpInfo);
	/**
  	 * 根据订单ID查询收货地址 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param orderID
	 * @param @return 设定文件 
	 * @return ShippingAddress 返回类型 
	 * @date 2016-4-23 下午8:43:26
	 */
	public  ShippingAddress  ShippingAddressByID(long orderID);
}
