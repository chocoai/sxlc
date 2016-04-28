

/** 
* @Title: CommodityInfoEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-11 上午10:21:58 
* @version V5.0 */
 
package cn.integralmall.model; 

import product_p2p.kit.datatrans.IntegerAndString;

/** 
 * @author 刘利 
 * @Description: 商品信息实体类
 * @since 
 * @date 2016-4-11 上午10:21:58  */

public class CommodityInfoEntity { 
	private long 	commodityID;//	商品ID 
	private long 	commodityTypeID;//	商品类型ID 
	private String  commodityNO;//	格式JFSC0000001向上增加 
	private String  commodityName;//	商品名称	 
	private String  brand;//	品牌	 
	private String  manufacturer;//	生产厂家 
	private String  specificationsmodels;//	规格及型号	 
	private String  commodityDescribe;//	商品描述	 
	private int  	marketPrice;//	市场价 
	private int  	needPoint;//	需要积分 
	private int  	isVIPExclusive;//	是否VIP专享
	private int  	discount;//	折扣 
	private int  	vipDiscount;//	VIP折扣	 
	private String  commoditylargeIcon;//	商品展示图片的路劲	 
	private String  commoditySmallIcon;//	商品展示图片的路劲	 
	private String  addTime;//	商品添加时间	 
	private int  	commodityStatu;//	字典：商品状态DICTSPZT	TINYINT			 
	private int  	isActive;//是否为活动商品	 
	private int  	activeType;//	字典：活动商品类型DICTHDSPLX	 
	private long  	vouchersAmount;//	代金券面额	BIGINT		 
	private long  	backAmount;//	返现券面额	BIGINT	 
	private String  endDate;//	结束日期	datetime 
	private int  	deleteFlag;//	标记为1有效0删除	
	private String  vouchersAmounts;//	代金券面额	BIGINT		 
	private String  backAmounts;//	返现券面额	BIGINT	 
	private String  commodityStatus;//商品状态
	private int     sumQuantity;//已兑换
	private int     backorder;//待发货
	private String  commodityTypename;//商品类别（实物和电子礼券）
	private String  commodityClassify;//商品类型名
	private int     commodityType;//商品类别（实物和电子礼券）
	private long    superID;//商品上级类型ID
	private int     quantity;//剩余数量
	private int     isPush;//是否推送到商城主页：1是0否 
	private String  commodityIntroduction;//商品的简短介绍 
	private int      result;//商品的简短介绍
	public long getSuperID() {
		return superID;
	}
	public void setSuperID(long superID) {
		this.superID = superID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCommodityStatus() {
		return commodityStatus;
	}
	public void setCommodityStatus(String commodityStatus) {
		this.commodityStatus = commodityStatus;
	}
	public int getSumQuantity() {
		return sumQuantity;
	}
	public void setSumQuantity(int sumQuantity) {
		this.sumQuantity = sumQuantity;
	}
	public int getBackorder() {
		return backorder;
	}
	public void setBackorder(int backorder) {
		this.backorder = backorder;
	}
	public String getCommodityTypename() {
		return commodityTypename;
	}
	public void setCommodityTypename(String commodityTypename) {
		this.commodityTypename = commodityTypename;
	}
	public String getCommodityClassify() {
		return commodityClassify;
	}
	public void setCommodityClassify(String commodityClassify) {
		this.commodityClassify = commodityClassify;
	}
	public long getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(long commodityID) {
		this.commodityID = commodityID;
	}
	public long getCommodityTypeID() {
		return commodityTypeID;
	}
	public void setCommodityTypeID(long commodityTypeID) {
		this.commodityTypeID = commodityTypeID;
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
	public String getSpecificationsmodels() {
		return specificationsmodels;
	}
	public void setSpecificationsmodels(String specificationsmodels) {
		this.specificationsmodels = specificationsmodels;
	}
	public String getCommodityDescribe() {
		return commodityDescribe;
	}
	public void setCommodityDescribe(String commodityDescribe) {
		this.commodityDescribe = commodityDescribe;
	}
	public int getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}
	public int getNeedPoint() {
		return needPoint;
	}
	public void setNeedPoint(int needPoint) {
		this.needPoint = needPoint;
	}
	public int getIsVIPExclusive() {
		return isVIPExclusive;
	}
	public void setIsVIPExclusive(int isVIPExclusive) {
		this.isVIPExclusive = isVIPExclusive;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getVipDiscount() {
		return vipDiscount;
	}
	public void setVipDiscount(int vipDiscount) {
		this.vipDiscount = vipDiscount;
	}
	public String getCommoditylargeIcon() {
		return commoditylargeIcon;
	}
	public void setCommoditylargeIcon(String commoditylargeIcon) {
		this.commoditylargeIcon = commoditylargeIcon;
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
	public int getCommodityStatu() {
		return commodityStatu;
	}
	public void setCommodityStatu(int commodityStatu) {
		this.commodityStatu = commodityStatu;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getActiveType() {
		return activeType;
	}
	public void setActiveType(int activeType) {
		this.activeType = activeType;
	}
	public long getVouchersAmount() {
		return vouchersAmount;
	}
	public void setVouchersAmount(long vouchersAmount) {
		this.vouchersAmount = vouchersAmount;
		this.vouchersAmounts = IntegerAndString.LongToString(vouchersAmount);
	}
	public long getBackAmount() {
		return backAmount;
	}
	public void setBackAmount(long backAmount) {
		this.backAmount = backAmount;
		this.backAmounts = IntegerAndString.LongToString(backAmount);
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getVouchersAmounts() {
		return vouchersAmounts;
	}
	public void setVouchersAmounts(String vouchersAmounts) {
		this.vouchersAmounts = vouchersAmounts;
	}
	public String getBackAmounts() {
		return backAmounts;
	}
	public void setBackAmounts(String backAmounts) {
		this.backAmounts = backAmounts;
	} 
	public int getCommodityType() {
		return commodityType;
	}
	public void setCommodityType(int commodityType) {
		this.commodityType = commodityType;
	}
	public int getIsPush() {
		return isPush;
	}
	public void setIsPush(int isPush) {
		this.isPush = isPush;
	}
	public String getCommodityIntroduction() {
		return commodityIntroduction;
	}
	public void setCommodityIntroduction(String commodityIntroduction) {
		this.commodityIntroduction = commodityIntroduction;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "CommodityInfoEntity [commodityID=" + commodityID
				+ ", commodityTypeID=" + commodityTypeID + ", commodityNO="
				+ commodityNO + ", commodityName=" + commodityName + ", brand="
				+ brand + ", manufacturer=" + manufacturer
				+ ", specificationsmodels=" + specificationsmodels
				+ ", commodityDescribe=" + commodityDescribe + ", marketPrice="
				+ marketPrice + ", needPoint=" + needPoint
				+ ", isVIPExclusive=" + isVIPExclusive + ", discount="
				+ discount + ", vipDiscount=" + vipDiscount
				+ ", commoditylargeIcon=" + commoditylargeIcon
				+ ", commoditySmallIcon=" + commoditySmallIcon + ", addTime="
				+ addTime + ", commodityStatu=" + commodityStatu
				+ ", isActive=" + isActive + ", activeType=" + activeType
				+ ", vouchersAmount=" + vouchersAmount + ", backAmount="
				+ backAmount + ", endDate=" + endDate + ", deleteFlag="
				+ deleteFlag + ", vouchersAmounts=" + vouchersAmounts
				+ ", backAmounts=" + backAmounts + ", commodityStatus="
				+ commodityStatus + ", sumQuantity=" + sumQuantity
				+ ", backorder=" + backorder + ", commodityTypename="
				+ commodityTypename + ", commodityClassify="
				+ commodityClassify + ", commodityType=" + commodityType
				+ ", superID=" + superID + ", quantity=" + quantity
				+ ", isPush=" + isPush + ", commodityIntroduction="
				+ commodityIntroduction + ", result=" + result + "]";
	}
 
	
}

