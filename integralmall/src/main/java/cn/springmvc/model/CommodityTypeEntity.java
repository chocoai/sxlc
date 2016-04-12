package cn.springmvc.model;

/**
 * 商品分类类型实体类
 *
 * @author 黄勇
 */
public class CommodityTypeEntity extends BaseCommodityTypeEntity {

    private String adminName;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
