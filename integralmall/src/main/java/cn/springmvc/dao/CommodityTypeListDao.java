package cn.springmvc.dao;

import product_p2p.kit.pageselect.PageEntity;

import java.util.List;

import cn.integralmall.model.BaseCommodityTypeEntity;

/**
 * @author 黄勇
 * @Description: 商品分类类型查询接口
 * @date 2016-3-19 下午7:24:01
 */
public interface CommodityTypeListDao<K extends BaseCommodityTypeEntity> extends CommodityTypeDao<K>{
    /**
     * 查询该名称的商品分类类型是否存在
     *
     * @param entity 商品分类类型实体
     * @return CommodityTypeEntity  商品分类类型实体
     */
    K selectCommodityTypeIsExistByName(K entity);

    /**
     * 分页查询商品分类类型
     *
     * @param pageEntity 分页实体类
     * @return 商品分类类型实体 列表
     */
    List<K> selectCommodityTypeAllPage(
            PageEntity pageEntity);

    /**
     * 根据ID查询的商品分类类型
     *
     * @param id 商品分类类型id
     * @return CommodityTypeEntity  商品分类类型实体
     */
    K selectCommodityTypeByID(int id);

    /**
     * 前台显示商品分类类型
     *
     * @return 商品分类类型列表
     */
    List<K> selectCommodityTypeFront();
}
