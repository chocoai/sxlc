package cn.springmvc.dao;
import java.util.Map;

import cn.integralmall.model.CommodityInfoEntity;
import cn.integralmall.model.InventoryRecordsEntity;
 
/**
 * 
 * @author 刘利 
 * @Description: 商品管理
 * @since 
 * @date 2016-4-11 下午9:07:54
 */
public interface CommodityInfoDao {
	/**
	 * 添加商品信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param commodityInfoEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 1成功 0失败
	 * @date 2016-4-11 下午2:37:19
	 */
	public int insertCommodityInfo(CommodityInfoEntity commodityInfoEntity);
	/**
	 * 修改商品基本信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param commodityInfoEntity
	 * @param @return 设定文件 
	 * @return int 返回类型  1成功 0失败
	 * @date 2016-4-11 下午4:29:38
	 */
	public int updateCommodityInfo(CommodityInfoEntity commodityInfoEntity);
	/**
	 * 商品上架下架
	 * @author 刘利   
	 * @Description: TODO 
	 * @param   map{commodityStatu(2下架，1上架),commodityID}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-11 下午4:40:47
	 */
	public int updateCommodityStatu(Map<String,Object> map);
	/**
	 * 商品入库 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param inventoryRecordsEntity
	 * @param @return 设定文件 
	 * @return int 返回类型  -1出库数量大于当期前库存,1成功 0失败
	 * @date 2016-4-11 下午6:17:24
	 */
	public int insertInventoryrecords(InventoryRecordsEntity inventoryRecordsEntity);
	/**
	 * 是否推送到商城首页 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map{commodityID,isPush(1推送，0不推送)}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，-1每一类最多推荐4个商品 1成功
	 * @date 2016-4-11 下午8:44:20
	 */
	public int updateCommodityISPush(Map<String,Object> map);
	/**
	 * 设置VIP折扣  
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  map{vipDiscount，commodityID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-4-11 下午8:52:16
	 */
	public int updateCommodityVIPDiscount(Map<String,Object> map);
	/**
	 * 添加上架下架记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map{commodityStatu(2下架，1上架),commodityID,adminID}
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-11 下午9:05:45
	 */
	public int insertCommodityUpDown(Map<String,Object> map);
}
