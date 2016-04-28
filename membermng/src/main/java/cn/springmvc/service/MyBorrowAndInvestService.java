

/** 
* @Title: BorrowingManagementService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午2:11:03 
* @version V5.0 */
 
package cn.springmvc.service; 
 
import product_p2p.kit.pageselect.PageEntity;

/** 
 * @author 刘利 
 * @Description: 后台-会员管理-借款项目-投资项目
 * @since 
 * @date 2016-4-13 下午2:11:03  */

public interface MyBorrowAndInvestService { 
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
	 * #{orderDsec(0降序，1升序)}   #{memberID}
	 * @date 2016-4-13 下午2:42:53
	 */
	public void getBorrowing(PageEntity pageEntity);
	/**
	 * 投资项目查询
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}             #{Project_No}      #{Project_Title}
	 * #{Invest_Date_Min}  #{Invest_Date_Max} #{Hold_Date_Min}
	 * #{Hold_Date_Max}    #{ordercolumn}     #{orderDsec(0降序，1升序)} 
	 * #{memberID}
     * @param @return 设定文件  
	 * @date 2016-4-13 下午2:50:18
	 */
	public void getInvestmentProject(PageEntity pageEntity); 
}

