package cn.springmvc.service.impl;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.integralmall.model.CommodityTypeEntity;
import product_p2p.kit.pageselect.PageEntity;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring.xml",
        "classpath:conf/spring-mybatis.xml",
        "classpath:conf/spring-mybatis-read.xml"})
public class testCommodityType extends TestCase {
    private static final Logger logger = Logger
            .getLogger(testCommodityType.class);
    @Resource(name = "commodityTypeServiceImpl")
    private CommodityTypeServiceImpl commodityTypeServiceImpl;

    @Test
    public void testinsert() {
        CommodityTypeEntity commodityTypeEntity = new CommodityTypeEntity();
        commodityTypeEntity.setCommodityTypeID(4l);
        commodityTypeEntity.setCommodityType(1l);
        commodityTypeEntity.setAdminID(1l);
        commodityTypeEntity.setSuperID(0l);
        commodityTypeEntity.setCommodityClassify("fdjsaklfj");
        commodityTypeEntity.setCommodityClassifyDes("fdjsaklfdjak");
        commodityTypeEntity.setCommodityClassifyPic("/fdsalfjd");
        commodityTypeEntity.setStatus(1);
        commodityTypeServiceImpl.insertCommodityType(commodityTypeEntity);
    }

    @Test
    public void testupdate() {
        CommodityTypeEntity commodityTypeEntity = new CommodityTypeEntity();
        commodityTypeEntity.setCommodityTypeID(10l);
        commodityTypeEntity.setCommodityType(1000l);
        commodityTypeEntity.setAdminID(1000l);
        commodityTypeEntity.setSuperID(1000l);
        commodityTypeEntity.setCommodityClassify("fdjsakfdsaflfj");
        commodityTypeEntity.setCommodityClassifyDes("fdjsakfdsafdlfdjak");
        commodityTypeEntity.setCommodityClassifyPic("/fdsalffggdsfdsf//jd");
        commodityTypeEntity.setStatus(1);
        commodityTypeServiceImpl.updateCommodityTypeByID(commodityTypeEntity);
    }

    @Test
    public void testdelete() {
        commodityTypeServiceImpl.deleteCommodityTypeByID(0);
    }

    @Test
    public void testupdatestatus() {
        CommodityTypeEntity commodityTypeEntity = new CommodityTypeEntity();
        commodityTypeEntity.setCommodityTypeID(10l);
        commodityTypeEntity.setCommodityType(1000l);
        commodityTypeEntity.setAdminID(1000l);
        commodityTypeEntity.setSuperID(0l);
        commodityTypeEntity.setCommodityClassify("fdjsakfdsaflfj");
        commodityTypeEntity.setCommodityClassifyDes("fdjsakfdsafdlfdjak");
        commodityTypeEntity.setCommodityClassifyPic("/fdsalffggdsfdsf//jd");
        commodityTypeEntity.setStatus(0);
        commodityTypeServiceImpl.updateCommodityTypeStatusByID(commodityTypeEntity);
    }

    @Test
    public void testselecAll() {
        PageEntity pageEntity = new PageEntity();
        pageEntity.setPageNum(1);
        pageEntity.setPageSize(10);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("commodityTypeID", "11");
        map.put("status", -1);
        pageEntity.setMap(map);
        List<CommodityTypeEntity> list = commodityTypeServiceImpl.selectCommodityTypeListPage(pageEntity);

        logger.info("list:");
    }
}
