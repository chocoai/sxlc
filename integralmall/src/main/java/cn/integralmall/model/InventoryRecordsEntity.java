

/** 
* @Title: InventoryRecordsEntity.java 
* @Package cn.springmvc.model 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-11 下午5:07:16 
* @version V5.0 */
 
package cn.integralmall.model; 

/** 
 * @author 刘利 
 * @Description: TODO 
 * @since 
 * @date 2016-4-11 下午5:07:16  */

public class InventoryRecordsEntity { 
	private long    commodityID;//	商品ID 
	private String 	operationTime;//	操作时间 
	private int	    operationDirection;//	标志位：1入库-1出库	 
	private int	    quantitys;//	入库/出库数量 
	private int	    deleteFlag;//	标记为1有效0删除 
	private long	adminID;//	管理员ID	 
	private String	adminName;//	管理员ID	 
	private int     totalQuantity;//记录库存总量 
	private int     result;//记录库存总量 
	public long getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(long commodityID) {
		this.commodityID = commodityID;
	}
	public String getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	public int getOperationDirection() {
		return operationDirection;
	}
	public void setOperationDirection(int operationDirection) {
		this.operationDirection = operationDirection;
	}
 
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public long getAdminID() {
		return adminID;
	}
	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getQuantitys() {
		return quantitys;
	}
	public void setQuantitys(int quantitys) {
		this.quantitys = quantitys;
	}
	 
}

