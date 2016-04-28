package cn.springmvc.service;

import java.util.List; 

import cn.integralmall.model.CommodityInfoEntity;
import cn.integralmall.model.CommodityTypeEntity;
import cn.integralmall.model.InventoryRecordsEntity;
 
import product_p2p.kit.optrecord.InsertAdminLogEntity;
import product_p2p.kit.pageselect.PageEntity; 
/**
 * 
 * @author 刘利 
 * @Description: 商品管理
 * @since 
 * @date 2016-4-11 下午9:08:18
 */
public interface CommodityInfoService {
	
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
	 * @param commodityType(商品类别（实物和电子礼券）),superID(商品上级类型ID)
	 * @param @return 设定文件 
	 * @return List<CommodityTypeEntity> 返回类型 
	 * @date 2016-4-11 下午1:46:50
	 */
	public List<CommodityTypeEntity>  selectCommodityType(int commodityType,long superID); 
	
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
	 * 添加商品信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param commodityInfoEntity
	 * @param @return 设定文件 
	 * @return int 返回类型  1成功 0失败 
	 * @date 2016-4-11 下午2:37:19
	 */
	public int insertCommodityInfo(CommodityInfoEntity commodityInfoEntity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
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
	 * 修改商品基本信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param commodityInfoEntity
	 * @param @return 设定文件 
	 * @return int 返回类型  1成功 0失败
	 * @date 2016-4-11 下午4:29:38
	 */
	public int updateCommodityInfo(CommodityInfoEntity commodityInfoEntity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
	/**
	 * 商品上架下架
	 * @author 刘利   
	 * @Description: TODO 
	 * @param commodityStatu(2下架，1上架),commodityID ,adminID
	 * @param @return 设定文件 
	 * @return int 返回类型    1成功 0失败
	 * @date 2016-4-11 下午4:40:47
	 */
	public int updateCommodityStatu(int commodityStatu,long commodityID,long adminID,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	
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
	
	/**
	 * 商品入库 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param inventoryRecordsEntity
	 * @param @return 设定文件 
	 * @return int 返回类型  -1出库数量大于当期前库存,1成功 0失败
	 * @date 2016-4-11 下午6:17:24
	 */
	public int insertInventoryrecords(InventoryRecordsEntity inventoryRecordsEntity,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	/**
	 * 是否推送到商城首页 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  commodityID,isPush(1推送，0不推送) 
	 * @param @return 设定文件 
	 * @return int  返回类型 0失败，-1每一类最多推荐4个商品 1成功
	 * @date 2016-4-11 下午8:44:20
	 */
	public int updateCommodityISPush(long commodityID,int isPush,InsertAdminLogEntity 
			logentity,String[] sIpInfo );
	
	/**
	 * 设置VIP折扣  
	 * @author 刘利   
	 * @Description: TODO 
	 * @param  {vipDiscount，commodityID}
	 * @param @return 设定文件 
	 * @return int 返回类型 0失败，1成功
	 * @date 2016-4-11 下午8:52:16
	 */
	public int updateCommodityVIPDiscount(long commodityID,String vipDiscount,InsertAdminLogEntity 
			logentity,String[] sIpInfo);
	 
}
