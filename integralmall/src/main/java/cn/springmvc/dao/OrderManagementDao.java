package cn.springmvc.dao; 

import java.util.Map;
 
/**
 * 
 * @author 刘利 
 * @Description: 订单管理管理
 * @since 
 * @date 2016-4-11 下午9:07:54
 */
public interface OrderManagementDao {
	/**
	 * 发货
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {OrderID订单ID,adminID管理员ID}
	 * @param @return 设定文件 
	 * @return int 返回类型 1成功 0失败-1该商品已发货或者已撤销
	 * @date 2016-4-23 下午7:52:59
	 */
	 public int deliverGoods(Map<String,Object> map);
    /**
	 * 发货
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map {OrderID订单ID,adminID管理员ID}
	 * @param @return 设定文件 
	 * @return int 返回类型 1成功 0失败
	 * @date 2016-4-23 下午7:52:59
	 */
	 public int CancelOrder(Map<String,Object> map);
}
