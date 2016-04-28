package cn.springmvc.service.impl;
 
import cn.integralmall.model.CommodityTypeEntity;
import cn.springmvc.dao.CommodityTypeListDao;
import cn.springmvc.dao.impl.IdGeneratorUtil;
import cn.springmvc.service.CommodityTypeService;
import org.springframework.stereotype.Service;
import product_p2p.kit.pageselect.PageEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 黄勇
 * @Description: 实现专家顾问的增删改查功能
 * @date 2016-3-19 下午7:32:30
 */
@Service("commodityTypeServiceImpl")
public class CommodityTypeServiceImpl implements CommodityTypeService {
    @Resource(name = "commodityTypeListDaoImpl")
    private CommodityTypeListDao<CommodityTypeEntity> CommodityTypeListDaoImpl;

    @Override
    public int insertCommodityType(CommodityTypeEntity entity) {

        if (entity == null) {
            return 0;
        }

        CommodityTypeEntity commodityTypeEntity = CommodityTypeListDaoImpl.selectCommodityTypeIsExistByName(entity);
        if (commodityTypeEntity != null) {
            return -1;
        }
        IdGeneratorUtil generatorUtil = IdGeneratorUtil.GetIdGeneratorInstance();
        Long id = generatorUtil.GetId();
        entity.setCommodityTypeID(id);

        int result = CommodityTypeListDaoImpl.insertCommodityType(entity);
        if (result == 0) {
            generatorUtil.SetIdUsedFail(id);
        } else {
            generatorUtil.SetIdUsed(id);
        }
        return result;
    }

    @Override
    public int deleteCommodityTypeByID(int id) {
        return CommodityTypeListDaoImpl.deleteCommodityTypeByID(id);
    }

    @Override
    public int updateCommodityTypeByID(CommodityTypeEntity entity) {

        if (entity == null) {
            return 0;
        }
        CommodityTypeEntity commodityTypeEntity = CommodityTypeListDaoImpl.selectCommodityTypeIsExistByName(entity);
        if (commodityTypeEntity != null) {
            return -1;
        }
        return CommodityTypeListDaoImpl.updateCommodityTypeByID(entity);
    }

    @Override
    public int updateCommodityTypeStatusByID(CommodityTypeEntity entity) {
        return CommodityTypeListDaoImpl.updateCommodityTypeStatusByID(entity);
    }

    @Override
    public List<CommodityTypeEntity> selectCommodityTypeListPage(PageEntity pageEntity) {
        return CommodityTypeListDaoImpl.selectCommodityTypeAllPage(pageEntity);
    }

    @Override
    public CommodityTypeEntity selectCommodityTypeByID(int id) {
        return CommodityTypeListDaoImpl.selectCommodityTypeByID(id);
    }

    @Override
    public List<CommodityTypeEntity> selectCommodityTypeFront() {
        return CommodityTypeListDaoImpl.selectCommodityTypeFront();
    }
}
