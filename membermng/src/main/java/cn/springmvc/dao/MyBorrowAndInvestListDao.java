

/** 
* @Title: BorrowingManagementListDao.java 
* @Package cn.springmvc.dao 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午1:36:22 
* @version V5.0 */
 
package cn.springmvc.dao; 

import java.util.List; 

import cn.membermng.model.InvestEntity;
import cn.membermng.model.ProjectAppRecordEntity;

import product_p2p.kit.pageselect.PageEntity;
 

/** 
 * @author 刘利 
 * @Description: 后台-会员管理-借款项目-投资项目
 * @since 
 * @date 2016-4-13 下午1:36:22  */

public interface MyBorrowAndInvestListDao {
	 
	 
	/**
	 * 借款项目查询 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * @param @return 设定文件 
	 * #{skey}				#{Project_No}      #{Project_Title}
	 * #{Record_Date_Min}   #{Record_Date_Max} #{Release_Date_Min}
	 * #{Release_Date_Max}  #{Hold_Date_Min}   #{Hold_Date_Max}
	 * #{Settle_Date_Min}   #{Settle_Date_Max} #{Guarantee_Name}
	 * #{Statu}             #{Type}            #{ordercolumn}
	 * #{orderDsec(0降序，1升序)} 
	 * @return List<ProjectAppRecordEntity> 返回类型 
	 * @date 2016-4-13 下午2:42:53
	 */
	public List<ProjectAppRecordEntity> getBorrowing(PageEntity pageEntity);
	/**
	 * 投资项目查询
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}             #{Project_No}      #{Project_Title}
	 * #{Invest_Date_Min}  #{Invest_Date_Max} #{Hold_Date_Min}
	 * #{Hold_Date_Max}    #{ordercolumn}     #{orderDsec(0降序，1升序)}
     * @param @return 设定文件 
	 * @return List<InvestEntity> 返回类型 
	 * @date 2016-4-13 下午2:50:18
	 */
	public List<InvestEntity> getInvestmentProject(PageEntity pageEntity);
	 
}

