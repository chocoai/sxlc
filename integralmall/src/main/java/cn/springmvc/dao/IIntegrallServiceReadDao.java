package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.integralmall.model.CommodityInfo;
import cn.integralmall.model.CommodityType;
import cn.integralmall.model.ShippingAddress;


/***
* 积分商城数据访问层
* 
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-8 上午11:26:15 
*
 */
public interface IIntegrallServiceReadDao {

	
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
	List<CommodityType> indexList();

	
	/***
	* 根据类型获取最新的4条商品信息
	* 
	* @author 李杰
	* @Title: goodsTop4
	* @return
	* @Description: TODO
	* @date 2016-4-8 下午3:32:59
	 */
	List<CommodityInfo> goodsTop4(long commodityTypeId);


	/**
	* 获取商品列表
	* 
	* @author 李杰
	* @Title: goods
	* @param entity
	* @return
	* @Description: TODO
	* @date 2016-4-8 下午4:29:29
	 */
	List<CommodityInfo> goods(PageEntity entity);


	
	/***
	* 获取商品详细信息
	* 
	* @author 李杰
	* @Title: commodityInfo
	* @param commodityId
	* @return
	* @Description: TODO
	* @date 2016-4-8 下午4:32:16
	 */
	CommodityInfo commodityInfo(long commodityId);

	
	
	/**
	* 获取会员列表
	* 
	* @author 李杰
	* @Title: ShippingAddressList
	* @param memberId
	* @return
	* @Description: TODO
	* @date 2016-4-11 下午7:24:46
	 */
	List<ShippingAddress> ShippingAddressList(long memberId);
	
	
	
	
}

