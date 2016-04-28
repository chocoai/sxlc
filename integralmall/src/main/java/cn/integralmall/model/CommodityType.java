package cn.integralmall.model; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
* 商品分类
* @author 李杰
* @Description: TODO 
* @since 
* @date 2016-4-8 下午2:20:18 
*
*/
public class CommodityType {
	
	private long				commodityTypeId						;//类型编号
	private long				adminId								;//管理员编号
	private int					commodityType						;//商品分类
	private String				superId								;//上级类型编号
	private String				commodityClassify					;//商品类型名称
	private String				commodityClassifyDes				;//商品描述			
	private String				commodityClassifyPic				;//商品类型图片
	private int					status								;//状态 0无效 1有效
	private Date				addTime								;//添加时间	
	private int					deleteFlag							;//是否删除 1有效 0已删除
	
	List<CommodityInfo> goods ;
	
	public CommodityType() {}


	public CommodityType(long commodityTypeId, long adminId, int commodityType,
			String superId, String commodityClassify,
			String commodityClassifyDes, String commodityClassifyPic,
			int status, Date addTime, int deleteFlag) {
		super();
		this.commodityTypeId = commodityTypeId;
		this.adminId = adminId;
		this.commodityType = commodityType;
		this.superId = superId;
		this.commodityClassify = commodityClassify;
		this.commodityClassifyDes = commodityClassifyDes;
		this.commodityClassifyPic = commodityClassifyPic;
		this.status = status;
		this.addTime = addTime;
		this.deleteFlag = deleteFlag;
	}



	public long getCommodityTypeId() {
		return commodityTypeId;
	}



	public void setCommodityTypeId(long commodityTypeId) {
		this.commodityTypeId = commodityTypeId;
	}



	public long getAdminId() {
		return adminId;
	}



	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}



	public int getCommodityType() {
		return commodityType;
	}



	public void setCommodityType(int commodityType) {
		this.commodityType = commodityType;
	}



	public String getSuperId() {
		return superId;
	}



	public void setSuperId(String superId) {
		this.superId = superId;
	}



	public String getCommodityClassify() {
		return commodityClassify;
	}



	public void setCommodityClassify(String commodityClassify) {
		this.commodityClassify = commodityClassify;
	}



	public String getCommodityClassifyDes() {
		return commodityClassifyDes;
	}



	public void setCommodityClassifyDes(String commodityClassifyDes) {
		this.commodityClassifyDes = commodityClassifyDes;
	}



	public String getCommodityClassifyPic() {
		return commodityClassifyPic;
	}



	public void setCommodityClassifyPic(String commodityClassifyPic) {
		this.commodityClassifyPic = commodityClassifyPic;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public Date getAddTime() {
		return addTime;
	}



	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}



	public int getDeleteFlag() {
		return deleteFlag;
	}



	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public List<CommodityInfo> getGoods() {
		return goods;
	}


	public void setGoods(List<CommodityInfo> goods) {
		this.goods = goods;
	}
	
	
	
	
	
	

}

