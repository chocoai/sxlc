package cn.springmvc.dao;

import java.util.List; 
import java.util.Map;

import cn.integralmall.model.CommodityInfoEntity;
import cn.integralmall.model.CommodityTypeEntity;
import cn.integralmall.model.InventoryRecordsEntity;

import product_p2p.kit.pageselect.PageEntity;
 
/**
 * 
 * @author 刘利 
 * @Description: 商品管理
 * @since 
 * @date 2016-4-11 上午11:58:35
 */
public interface CommodityInfoListDao {
	/**
	 * 分页查询商品信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity map{commodityName(商品名称),commodityNO(商品编码),commodityType商品种类（实物和电子礼券）
	 *                        commodityStatu(状态（待上架、兑换中、已下架）),order(1:添加时间2:已兑换3:代发货)}
	 * @param @return 设定文件 
	 * @return List<CommodityInfoEntity> 返回类型 
	 * @date 2016-4-11 下午12:02:02
	 */
	public List<CommodityInfoEntity>  selectCommodityInfoList(PageEntity pageEntity); 
	/**
	 * 级联查询商品类型
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map{commodityType(商品类别（实物和电子礼券）),superID(商品上级类型ID)}
	 * @param @return 设定文件 
	 * @return List<CommodityTypeEntity> 返回类型 
	 * @date 2016-4-11 下午1:46:50
	 */
	public List<CommodityTypeEntity>  selectCommodityType(Map<String,Object> map); 
	/**
	 * 查询字典表
	 * @author 刘利   
	 * @Description: TODO 
	 * @param tcode 
	 * @return List<CommodityTypeEntity> 返回类型 
	 * @date 2016-4-11 下午1:50:43
	 */
	public List<CommodityTypeEntity>  selectCommodityTypeDiCT(String tcode);
	/**
	 * 根据商品ID查询商品基本信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param commodityID 商品ID
	 * @param @return 设定文件 
	 * @return CommodityInfoEntity 返回类型 
	 * @date 2016-4-11 下午3:42:02
	 */
	public CommodityInfoEntity selectCommodityInfoByID(long commodityID);
	/**
	 * 查看入库记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param map{commodityID 商品ID}
	 * @param @return 设定文件 
	 * @return List<InventoryRecordsEntity> 返回类型 
	 * @date 2016-4-11 下午5:14:02
	 */
	public List<InventoryRecordsEntity>  selectInventoryrecordsIn(PageEntity pageEntity);
	
}
