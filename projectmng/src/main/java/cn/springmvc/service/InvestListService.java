

/** 
* @Title: investListService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-3-21 下午1:04:38 
* @version V5.0 */
 
package cn.springmvc.service; 

import java.util.List;

import product_p2p.kit.pageselect.PageEntity;
import cn.springmvc.model.ProjectAppRecordEntity;

/** 
 * @author 刘利 
 * @Description: 实现借款项目列表查询 
 * @since 
 * @date 2016-3-21 下午1:04:38  */

public interface InvestListService {
	
	/**
	 * 投资列表
	 * 
	 * selectInvestList(这里用一句话描述这个方法的作用) 
	 * TODO(描述)
	 * @author 刘利  
	 * @Title: selectInvestList 
	 * @Description: TODO 
	 * @param pageEntity 分页实体
	 * <p>map{projectinfo(项目编号或名称),investStatu(项目状态),repayWay(还款方式),reward(1加息标2返现3无奖励)projectType(借款类型)
	 *         yearratemin,yearratemax,deadlineType(期限类型 0：天标 1：月标 2：年标)，deadlinemin,deadlinemax}
	 * <p>  
	 * @param @return 设定文件 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-3-21 下午1:05:21 
	 */
	public List<ProjectAppRecordEntity> selectInvestList(PageEntity pageEntity); 
}

