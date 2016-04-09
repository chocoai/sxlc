

/** 
* @Title: investListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午12:46:49 
* @version V5.0 */
 
package cn.springmvc.dao; 
 
import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 实现借款项目列表查询 
 * @since 
 * @date 2016-3-21 下午12:46:49  */

public interface InvestListDao {  
	/**
	 *  实现借款项目的列表查询  
	 *  @param pageEntity  分页实体
	 *  @author 刘利 
	 *  @Description: 实现借款项目的列表查询  
	 *  @return List<ProjectAppRecordEntity> 项目申请记录列表
	 *  @date 2016-3-21 下午12:50:30
	 */
	public List<ProjectAppRecordEntity> selectInvestList(PageEntity pageEntity); 
}

