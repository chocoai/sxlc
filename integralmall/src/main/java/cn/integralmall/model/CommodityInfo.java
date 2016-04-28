package cn.integralmall.model; 

/***
* 商品
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-8 下午2:35:17 
*
 */
public class CommodityInfo {
	
	private long					commodityId							;//商品编号
	private long					commodityTypeId						;//商品类型编号
	private String					commodityNO							;//商品显示编号
	private String					commodityName						;//商品名称
	private String					brand								;//品牌
	private String					manufacturer						;//生产厂家
	private String					specificationsModels				;//型号
	private String					commodityDescribe					;//描述
	private String					marketPrice							;//市场价格
	private String					needPoint							;//所需积分
	private String					isVIPExclusive						;//是否VIP专享 1是0否
	private String					discount							;//折扣
	private String					vIPDiscount							;//VIP折扣
	private String	 				commodityLargeIcon					;//商品大图标
	private String 					commoditySmallIcon					;//商品小图标
	private String					addTime								;//添加时间
	private String					commodityStatu						;//商品状态
	private String					isActive							;//是否是活动1是0否
	private String					activeType							;//活动商品类型
	private String					vouchersAmount						;//代金券面额
	private String					backAmount							;//返现券面额
	private String					endDate								;//结束日期
	private String					deleteFlag							;//是否删除1有效 0已删除
	
	
	public CommodityInfo() {	}


	public CommodityInfo(long commodityId, long commodityTypeId,
			String commodityNO, String commodityName, String brand,
			String manufacturer, String specificationsModels,
			String commodityDescribe, String marketPrice, String needPoint,
			String isVIPExclusive, String discount, String vIPDiscount,
			String commodityLargeIcon, String commoditySmallIcon,
			String addTime, String commodityStatu, String isActive,
			String activeType, String vouchersAmount, String backAmount,
			String endDate, String deleteFlag) {
		super();
		this.commodityId = commodityId;
		this.commodityTypeId = commodityTypeId;
		this.commodityNO = commodityNO;
		this.commodityName = commodityName;
		this.brand = brand;
		this.manufacturer = manufacturer;
		this.specificationsModels = specificationsModels;
		this.commodityDescribe = commodityDescribe;
		this.marketPrice = marketPrice;
		this.needPoint = needPoint;
		this.isVIPExclusive = isVIPExclusive;
		this.discount = discount;
		this.vIPDiscount = vIPDiscount;
		this.commodityLargeIcon = commodityLargeIcon;
		this.commoditySmallIcon = commoditySmallIcon;
		this.addTime = addTime;
		this.commodityStatu = commodityStatu;
		this.isActive = isActive;
		this.activeType = activeType;
		this.vouchersAmount = vouchersAmount;
		this.backAmount = backAmount;
		this.endDate = endDate;
		this.deleteFlag = deleteFlag;
	}



	public long getCommodityId() {
		return commodityId;
	}


	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}


	public long getCommodityTypeId() {
		return commodityTypeId;
	}


	public void setCommodityTypeId(long commodityTypeId) {
		this.commodityTypeId = commodityTypeId;
	}


	public String getCommodityNO() {
		return commodityNO;
	}


	public void setCommodityNO(String commodityNO) {
		this.commodityNO = commodityNO;
	}


	public String getCommodityName() {
		return commodityName;
	}


	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getSpecificationsModels() {
		return specificationsModels;
	}


	public void setSpecificationsModels(String specificationsModels) {
		this.specificationsModels = specificationsModels;
	}


	public String getCommodityDescribe() {
		return commodityDescribe;
	}


	public void setCommodityDescribe(String commodityDescribe) {
		this.commodityDescribe = commodityDescribe;
	}


	public String getMarketPrice() {
		return marketPrice;
	}


	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}


	public String getNeedPoint() {
		return needPoint;
	}


	public void setNeedPoint(String needPoint) {
		this.needPoint = needPoint;
	}


	public String getIsVIPExclusive() {
		return isVIPExclusive;
	}


	public void setIsVIPExclusive(String isVIPExclusive) {
		this.isVIPExclusive = isVIPExclusive;
	}


	public String getDiscount() {
		return discount;
	}


	public void setDiscount(String discount) {
		this.discount = discount;
	}


	public String getvIPDiscount() {
		return vIPDiscount;
	}


	public void setvIPDiscount(String vIPDiscount) {
		this.vIPDiscount = vIPDiscount;
	}


	public String getCommodityLargeIcon() {
		return commodityLargeIcon;
	}


	public void setCommodityLargeIcon(String commodityLargeIcon) {
		this.commodityLargeIcon = commodityLargeIcon;
	}


	public String getCommoditySmallIcon() {
		return commoditySmallIcon;
	}


	public void setCommoditySmallIcon(String commoditySmallIcon) {
		this.commoditySmallIcon = commoditySmallIcon;
	}


	public String getAddTime() {
		return addTime;
	}


	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}


	public String getCommodityStatu() {
		return commodityStatu;
	}


	public void setCommodityStatu(String commodityStatu) {
		this.commodityStatu = commodityStatu;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getActiveType() {
		return activeType;
	}


	public void setActiveType(String activeType) {
		this.activeType = activeType;
	}


	public String getVouchersAmount() {
		return vouchersAmount;
	}


	public void setVouchersAmount(String vouchersAmount) {
		this.vouchersAmount = vouchersAmount;
	}


	public String getBackAmount() {
		return backAmount;
	}


	public void setBackAmount(String backAmount) {
		this.backAmount = backAmount;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getDeleteFlag() {
		return deleteFlag;
	}


	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

