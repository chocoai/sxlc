package cn.springmvc.dao; 

import java.util.Map;



/****
* 积分商城数据写
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-11 上午11:32:00 
*
*/
public interface IIntegrallServiceWriteDao {

	
	
	
	/***
	* 添加收件人地址
	* @author 李杰
	* @Title: saveShippingAddress
	* @param address
	* @return
	* @Description: TODO
	* @date 2016-4-11 上午11:41:45
	 */
	int saveShippingAddress(Map<String,Object> param);

	
	/***
	* 积分兑换
	* 
	* @author 李杰
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-4-11 下午4:03:03
	 */
	int pointxchange(Map<String, Object> param);


	/***
	* 修改个人收件地址
	* 
	* @author 李杰
	* @Title: editShippingAddress
	* @param param
	* @return
	* @Description: TODO
	* @date 2016-4-19 上午9:46:06
	 */
	int editShippingAddress(Map<String, Object> param);

	
	
	
	
	
	
	
	
}

