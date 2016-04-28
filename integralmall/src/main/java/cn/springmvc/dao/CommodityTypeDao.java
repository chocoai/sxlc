package cn.springmvc.dao;

import cn.integralmall.model.BaseCommodityTypeEntity;


/**
 * @author 黄勇
 * @Description: 商品分类增删改接口
 * @date 2016-3-19 下午7:39:18
 */
public interface CommodityTypeDao<K extends BaseCommodityTypeEntity> {
    /**
     * 添加商品分类类型
     *
     * @param entity 商品分类类型实体类
     * @return 0：失败	1：成功
     */
    int insertCommodityType(K entity);

    /**
     * 通过ID修改商品分类类型
     *
     * @param entity 商品分类类型实体
     * @return 0:失败 1：成功
     */
    int updateCommodityTypeByID(K entity);

    /**
     * 通过ID删除商品分类类型信息
     *
     * @param id 商品分类类型id
     * @return 0:失败 1：成功
     */
    int deleteCommodityTypeByID(int id);

    /**
     * 停用或启用商品分类类型
     *
     * @param entity 商品分类类型实体
     * @return 0:失败 1：成功
     */
    int updateCommodityTypeStatusByID(K entity);
}
