package cn.springmvc.service; 

import java.util.List;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity;

import cn.integralmall.model.CommodityInfo;
import cn.integralmall.model.CommodityType;
import cn.integralmall.model.ShippingAddress;


/***
* 积分商城首页服务
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-8 上午11:18:08 
*
 */
@Service
public interface IIntegrallService {

	
	
	
	/***
	* 获取首页所需要的商品数据<br>
	* 获取所有种类的楼层和下面的4中最新商品<br>
	* 
	* @author 李杰
	* @Title: indexList
	* @return
	* @Description: TODO
	* @date 2016-4-8 上午11:17:57
	 */
	public List<CommodityType> indexList();

	
	/***
	* 积分商城列表
	* 
	* @author 李杰
	* @Title: goods
	* @param entity
	* minPoint 				最小积分
	* maxPoint				最大积分
	* commodityTypeId		类型编号
	* @return
	* @Description: TODO
	* @date 2016-4-8 下午4:03:23
	 */
	public List<CommodityInfo> goods(PageEntity entity);


	/***
	* 查看商品详细信息
	* 
	* @author 李杰
	* @Title: commodityInfo
	* @param  commodityId				商品编号
	* @return
	* @Description: TODO
	* @date 2016-4-8 下午4:21:59
	 */
	public CommodityInfo commodityInfo(long commodityId);


	
	/***
	* 添加收件地址信息
	* 
	* @author 李杰
	* @Title: saveShippingAddress
	* @param address
	* memberId				<br>
	* contentName			<br>
	* provinceId			<br>
	* cityId				<br>
	* countyId				<br>
	* detailedAddress		<br>
	* contactPhone			<br>
	* deliveryChoice		<br>
	* isDefaultAddress		<br>
	* @return 1保存成功、0保存失败、-1收件地址数量达到上限
	* @date 2016-4-11 上午11:22:15
	*/
	public int saveShippingAddress(ShippingAddress address);

	
	/***
	* 兑换商品
	* 
	* @author 李杰
	* @param memberId						会员编号
	* @param commodityId					商品编号
	* @param quantity						兑换数量
	* @param addressId						收件地址
	* @return 1兑换成功、0兑换失败、-1商品不存在、-2该商品已兑换完、-3积分不足、-4商品数量不足、-5
	* @Description: TODO
	* @date 2016-4-11 下午3:57:40
	 */
	public int pointxchange(long memberId,long commodityId,int quantity,long addressId);


	/***
	* 获取会员的收件地址列表
	* 
	* @author 李杰
	* @Title: ShippingAddressList
	* @param l
	* @return
	* @Description: TODO
	* @date 2016-4-11 下午7:22:55
	 */
	public List<ShippingAddress> ShippingAddressList(long l);


	
	/***
	* 
	* ShippingAddressInfoById(这里用一句话描述这个方法的作用)
	* TODO(描述)
	* @author 李杰
	* @Title: ShippingAddressInfoById
	* @param l
	* @return
	* @Description: TODO
	* @date 2016-4-11 下午7:23:14
	 */
	public ShippingAddress ShippingAddressInfoById(long l);


	/***
	* 修改个人收件地址信息
	* 
	* @author 李杰
	* @Title: editShippingAddress
	* @param  address
	* addressId				<br>
	* memberId				<br>
	* contentName			<br>
	* provinceId			<br>
	* cityId				<br>
	* countyId				<br>
	* detailedAddress		<br>
	* contactPhone			<br>
	* deliveryChoice		<br>
	* isDefaultAddress		<br>
	* @return 1：修改成功、0修改失败
	* @date 2015-9-1 上午9:37:04
	 */
	public int editShippingAddress(ShippingAddress address);
	
	
	
}

