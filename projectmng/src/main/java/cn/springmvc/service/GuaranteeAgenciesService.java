

/** 
* @Title: GuaranteeAgenciesService.java 
* @Package cn.springmvc.service 
* @Description: TODO 
* Copyright: Copyright (c) 2016 
* Company:成都四象联创科技有限公司 
* @author 刘利 
* @date 2016-4-13 下午5:25:20 
* @version V5.0 */
 
package cn.springmvc.service; 
 

import product_p2p.kit.pageselect.PageEntity; 

/** 
 * @author 刘利 
 * @Description: 担保项目
 * @since 
 * @date 2016-4-13 下午5:25:20  */

public interface GuaranteeAgenciesService {
	/**
	 * 查询担保项目信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * 	#{skey}            #{Project_No}            #{Project_Title}
	 *  #{Guarantee_Name}  #{Record_Date_Min}       #{Record_Date_Max}
	 *	#{IsCompensatory}  #{Compensatory_Time_Min} #{Compensatory_Time_Max}
	 *  #{ordercolumn}     #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-13 下午5:49:18
	 */
	public void  getGuaranteeproject(PageEntity pageEntity);
	/**
	 * 查询代偿记录信息/历史代偿记录信息 
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * 	#{skey}                  #{Project_No}            #{Project_Title}
	 *  #{Personal_Name}         #{Logname}               #{Personal_Phone}
	 *  #{Guarantee_Name}        #{Repay_MaxTime_Min}     #{Repay_MaxTime_Max}
	 *	#{Compensatory_Time_Min} #{Compensatory_Time_Max} #{Statu}
	 *  #{ordercolumn}           #{orderDsec(0降序，1升序)}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-13 下午5:51:16
	 */
	public void  getCompensatoryrecord(PageEntity pageEntity);
	/**
	 * 查询代偿回款记录信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}           #{Project_No}     #{Project_Title}
	 * #{Personal_Name}  #{Logname}        #{Guarantee_Name}
	 * #{Repay_Time_Min} #{Repay_Time_Max}#{ordercolumn}
	 * @param @return 设定文件 
	 * @return void 返回类型 
	 * @date 2016-4-13 下午5:53:46
	 */
	public void  getReceivablerecords(PageEntity pageEntity);
	/**
	 * 查询交易记录信息
	 * @author 刘利   
	 * @Description: TODO 
	 * @param pageEntity
	 * #{skey}				#{Type_Name} #{Record_Date_Min}
	 * #{Record_Date_Max}   #{ordercolumn}
	 * @param @return 设定文件 
	 * @return List<MemberTradingRecordsEntity> 返回类型 
	 * @date 2016-4-13 下午6:06:37
	 */
	public void getTransaction(PageEntity pageEntity);
}

