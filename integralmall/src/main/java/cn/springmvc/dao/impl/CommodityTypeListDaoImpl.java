package cn.springmvc.dao.impl;

import cn.integralmall.model.BaseCommodityTypeEntity;
import cn.springmvc.dao.CommodityTypeListDao;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import product_p2p.kit.pageselect.PageEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 黄勇
 * @Description: 实现商品分类的查询功能
 * @date 2016-3-19 下午7:26:09
 */
@Repository("commodityTypeListDaoImpl")
public class CommodityTypeListDaoImpl<K extends BaseCommodityTypeEntity>
        extends SqlSessionDaoSupport implements CommodityTypeListDao<K> {
    @Resource(name = "sqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insertCommodityType(K entity) {
        return getSqlSession().insert("CommodityType.insertCommodityType", entity);
    }

    @Override
    public int updateCommodityTypeByID(K entity) {
        return getSqlSession().update("CommodityType.updateCommodityTypeByID", entity);
    }

    @Override
    public int deleteCommodityTypeByID(int id) {
        return getSqlSession().delete("CommodityType.deleteCommodityTypeByID", id);
    }

    @Override
    public int updateCommodityTypeStatusByID(K entity) {
        return getSqlSession().update("CommodityType.updateCommodityTypeStatusByID", entity);
    }

    @Override
    public K selectCommodityTypeIsExistByName(K entity) {
        return  getSqlSession().selectOne("CommodityType.selectCommodityTypeIsExistByName", entity);
    }

    @Override
    public List<K> selectCommodityTypeAllPage(PageEntity pageEntity) {
        return getSqlSession().selectList("CommodityType.selectCommodityTypeList",
                pageEntity, new RowBounds(pageEntity.getPageNum(), pageEntity.getPageSize()));
    }

    @Override
    public List<K> selectCommodityTypeByID(int id) {
        return getSqlSession().selectOne("CommodityType.selectCommodityTypeByID", id);
    }

    @Override
    public List<K> selectCommodityTypeFront() {
        return getSqlSession().selectList("CommodityType.selectCommodityTypeFront");
    }
}
