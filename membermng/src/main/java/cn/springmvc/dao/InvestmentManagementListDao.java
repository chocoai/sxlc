

/** 
* @Title: InvestmentManagementDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午6:47:42 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List;

import cn.membermng.model.CreditorTransEntity;
import cn.membermng.model.InvestIncomeEntity;

import product_p2p.kit.pageselect.PageEntity;

/** 
 * @author 刘利 
 * @Description: 我的债权
 * @since 
 * @date 2016-4-13 下午6:47:42  */

public interface InvestmentManagementListDao {
	/**
	 * 转让中的债权
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}#{Member_ID}
	 * @param @return 设定文件 
	 * @return List<CreditorTransEntity> 返回类型 
	 * @date 2016-4-13 下午6:51:15
	 */
	public List<CreditorTransEntity> getCreditorTransfer(PageEntity pageEntity);
	/**
	 * 已转出的债权 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}#{Member_ID}
	 * @param @return 设定文件 
	 * @return List<CreditorTransEntity> 返回类型 
	 * @date 2016-4-13 下午6:54:19
	 */
	public List<CreditorTransEntity> getCreditorOut(PageEntity pageEntity);
	/**
	 * 已转入的债权 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}#{Member_ID}
	 * @param @return 设定文件 
	 * @return List<CreditorTransEntity> 返回类型 
	 * @date 2016-4-13 下午6:56:23
	 */
	public List<CreditorTransEntity> getCreditorIn(PageEntity pageEntity);
	/**
	 * 查看收益列表 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}#{Member_ID}
	 * @param @return 设定文件 
	 * @return List<InvestIncomeEntity> 返回类型 
	 * @date 2016-4-13 下午6:57:34
	 */
	public List<InvestIncomeEntity> getInvest(PageEntity pageEntity);
	/**
	 * 已结清的债权 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}#{Member_ID}
	 * @param @return 设定文件 
	 * @return List<CreditorTransEntity> 返回类型 
	 * @date 2016-4-13 下午6:58:45
	 */
	public List<CreditorTransEntity> getCreditorOff(PageEntity pageEntity);
}

