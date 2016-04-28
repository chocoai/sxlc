package cn.integralmall.model;

/**
 * 商品分类类型实体类
 *
 * @author 黄勇
 */
public class BaseCommodityTypeEntity {

    private Long commodityTypeID;
    private Long adminID;
    private Long commodityType;
    private Long superID;
    private String commodityClassify;
    private String commodityClassifyDes;
    private String commodityClassifyPic;
    private Integer status;
    private Long addTime;
    private Integer deleteFlag = 0;

    public Long getCommodityTypeID() {
        return commodityTypeID;
    }

    public void setCommodityTypeID(Long commodityTypeID) {
        this.commodityTypeID = commodityTypeID;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public Long getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(Long commodityType) {
        this.commodityType = commodityType;
    }

    public Long getSuperID() {
        return superID;
    }

    public void setSuperID(Long superID) {
        this.superID = superID;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
