

/** 
* @Title: PostLoanManageDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-15 下午6:56:15 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.Map;

import cn.springmvc.model.LoanRepayUrgedRecordEntity;

/** 
 * @author 刘利 
 * @Description: 贷后管理
 * @since 
 * @date 2016-4-15 下午6:56:15  */

public interface PostLoanManageDao {
	/**
	 * 新增催收记录
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param loanRepayUrgedRecordEntity
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-15 下午7:02:31
	 */
	public int insertLoanRepayUrgedRecord(LoanRepayUrgedRecordEntity  loanRepayUrgedRecordEntity);
	
	//***********贷后监管*********************//
	/**
	 * 新增贷后监管信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param map
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-21 下午2:13:08
	 */
	public int insertProjectAfterLoanInfo(Map<String,Object> map);
	/**
	 * 删除某条贷后监管信息  
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param infoId
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-21 下午3:35:33
	 */
	public int deleteProjectAfterLoanInfoByID(long infoId);
	/**
	 *  删除某条贷后监管信息后           删除对应的附件 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param @param infoId
	 * @param @return 设定文件 
	 * @return int 返回类型 
	 * @date 2016-4-21 下午3:45:51
	 */
	public int deleteAfterLoanAttachByinfoId(long infoId);
}

