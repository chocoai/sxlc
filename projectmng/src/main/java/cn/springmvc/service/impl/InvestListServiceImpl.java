

/** 
* @Title: investListServiceImpl.java 
* @Package cn.springmvc.service.impl 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午1:05:55 
* @version V5.0 */
 
package cn.springmvc.service.impl; 
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import product_p2p.kit.pageselect.PageEntity; 
import cn.springmvc.dao.InvestListDao;
import cn.springmvc.dao.impl.InvestListDaoImpl; 
import cn.springmvc.model.ProjectAppRecordEntity; 
import cn.springmvc.service.InvestListService;

/** 
 * @author 刘利 
 * @Description: 实现借款项目列表查询  
 * @since 
 * @date 2016-3-21 下午1:05:55  */
@Service("investListServiceImpl")
public class InvestListServiceImpl implements InvestListService {
	@Resource(name="investListDaoImpl")
	private InvestListDao investListDaoImpl;  
 
	@Override
	public List<ProjectAppRecordEntity> selectInvestList(PageEntity pageEntity) { 
		List<ProjectAppRecordEntity> projectAppRecordList= investListDaoImpl.selectInvestList(pageEntity); 
        return projectAppRecordList;
	}

}

