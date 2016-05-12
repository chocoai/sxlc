

/** 
* @Title: LoanDaoList.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-5-12 上午11:48:03 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;

import cn.springmvc.model.LoanProjectEntity;

/** 
 * @author 刘利 
 * @Description: 放款管理列表查询
 * @since 
 * @date 2016-5-12 上午11:48:03  */

public interface LoanDaoList {
	/**
	 * 放款管理列表查询
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param pageEntity
	 * @param @return 设定文件 
	 * @return List<LoanProjectEntity> 返回类型 
	 * @date 2016-5-12 下午2:23:04
	 */
	public List<LoanProjectEntity>  selectLoanList(PageEntity pageEntity);
}

