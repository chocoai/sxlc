package cn.springmvc.service;
 
import cn.integralmall.model.CommodityTypeEntity;

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

/**
 * @author 黄勇
 * @Description: 实现商品分类类型的增删改查功能
 * @date 2016-3-19 下午7:28:53
 */
public interface CommodityTypeService {
    /**
     * 新增商品分类类型
     *
     * @param entity 商品分类类型实体
     * @return 0：数据为空;-1：该名称的商品分类类型已存在;1:添加成功
     */
    int insertCommodityType(CommodityTypeEntity entity);

    /**
     * 删除商品分类类型
     *
     * @param id 商品分类类型id
     * @return 0：失败；1成功
     */
    int deleteCommodityTypeByID(int id);

    /**
     * 修改商品分类类型
     *
     * @param entity 商品分类类型实体
     * @return 0：失败；1成功;-1：该名称的商品分类类型已存在;
     */
    int updateCommodityTypeByID(CommodityTypeEntity entity);

    /**
     * 停用或启用商品分类类型信息
     *
     * @param entity 商品分类类型实体,传statu (0无效，1有效) ,与id
     * @return 0:失败 1：成功
     */
    int updateCommodityTypeStatusByID(CommodityTypeEntity entity);

    /**
     * 分页查询商品分类类型
     *
     * @param pageEntity 分页实体 map 包含(mngName,statu:(0无效，1有效,-1全部))
     * @return 商品分类类型列表
     */
    List<CommodityTypeEntity> selectCommodityTypeListPage(PageEntity pageEntity);

    /**
     * 根据ID查询的商品分类类型
     *
     * @param id 商品分类类型id
     * @return CommodityTypeEntity 商品分类类型实体
     */
    CommodityTypeEntity selectCommodityTypeByID(int id);

    /**
     * 前台显示商品分类类型
     *
     * @return 商品分类类型列表
     */
    List<CommodityTypeEntity> selectCommodityTypeFront();
}
